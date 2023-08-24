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

    message.setSubject(userResponseBroker.getSubject());
    message.setFrom(env.getProperty("spring.mail.username"));
    message.setText(userResponseBroker.getMessage());

    message.setTo(userResponseBroker.getRecipientEmail());

    mailSender.send(message);
  }

}
