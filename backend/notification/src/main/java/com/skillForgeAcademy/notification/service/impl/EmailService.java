package com.skillForgeAcademy.notification.service.impl;

import com.skillForgeAcademy.notification.model.UserResponseBroker;
import com.skillForgeAcademy.notification.service.IActivateEmail;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Session;
import jakarta.mail.internet.MimeMessage;
import java.util.Properties;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService implements IActivateEmail {

  private Environment env;

  private JavaMailSender mailSender;

  public EmailService(Environment env, JavaMailSender javaMailSender) {
    this.env = env;
    this.mailSender = javaMailSender;
  }

  public Message buildMessage(Properties properties) {
    Session session = Session.getDefaultInstance(properties);
    return new MimeMessage(session);
  }

  @Override
  public void sendActivationEmail(UserResponseBroker userResponseBroker) throws MessagingException {

    SimpleMailMessage message = new SimpleMailMessage();

    message.setSubject("Activate your Skill Forge Academy account");
    message.setFrom(env.getProperty("spring.mail.username"));
    message.setText(
        getActivationEmailTemplate(
            userResponseBroker.getRecipientName(),
            userResponseBroker.getActivationLink(),
            userResponseBroker.getExpirationHours()));

    message.setTo(userResponseBroker.getRecipientEmail());

    mailSender.send(message);
  }

  @Override
  public String getActivationEmailTemplate(
      String recipientName, String activationLink, String expirationHours) {
    return """
                Dear %s,

                Thank you for registering for our service!

                To activate your account, please click on the following link:

                %s

                This link will expire in %s hours.

                If you have any questions, please do not hesitate to contact us.

                Thank you,

                Skill Forge Academy.
                """
        .formatted(recipientName, activationLink, expirationHours);
  }
}
