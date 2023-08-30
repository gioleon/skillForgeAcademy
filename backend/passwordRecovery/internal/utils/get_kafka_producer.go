package utils

import "github.com/confluentinc/confluent-kafka-go/kafka"

func GetBrokerConnection() *kafka.Producer {
	kafkaInstance, err := kafka.NewProducer(&kafka.ConfigMap{
		"bootstrap.servers": "localhost:9092"})
	if err != nil {
		panic(err)
	}

	return kafkaInstance
}
