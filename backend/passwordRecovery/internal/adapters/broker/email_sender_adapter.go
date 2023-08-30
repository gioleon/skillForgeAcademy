package broker

import (
	"encoding/json"
	"log"
	"passwordRecovery/internal/model"

	"github.com/confluentinc/confluent-kafka-go/kafka"
)

type EmailSenderAdapter struct {
	Producer *kafka.Producer
	Topic    string
}

func NewEmailSender(producer *kafka.Producer, topic string) *EmailSenderAdapter {
	return &EmailSenderAdapter{
		Producer: producer,
		Topic:    topic,
	}
}

func (emailSender *EmailSenderAdapter) Send(userBroker *model.UserResponseBroker) error {
	userBrokerJson, err := json.Marshal(userBroker)
	if err != nil {
		return err
	}

	// close the producer after all the instructions are done
	defer emailSender.Producer.Close()

	// create deliver channel to receive reports from kafka
	deliverCh := make(chan kafka.Event, 1000)

	go func() {
		for event := range deliverCh {
			switch ev := event.(type) {
			case *kafka.Message:
				if ev.TopicPartition.Error != nil {
					log.Printf("Something went wrong in the delivery to the topic %v",
						ev.TopicPartition.Topic)
				} else {
					log.Printf("Message to the topic %v successfully deliveried",
						ev.TopicPartition.Topic)
				}
			case kafka.Error:
				log.Printf("error: %v", ev)
			default:
				log.Printf("Event ignored: %v", ev)
			}

			// close channel because it only receive reports for one message
			close(deliverCh)
		}
	}()

	err = emailSender.Producer.Produce(&kafka.Message{
		TopicPartition: kafka.TopicPartition{Topic: &emailSender.Topic, Partition: kafka.PartitionAny},
		Value:          []byte(userBrokerJson),
	}, deliverCh)
	if err != nil {
		return err
	}

	emailSender.Producer.Flush(15 * 1000) // wait for message reports before shutting down

	return nil
}
