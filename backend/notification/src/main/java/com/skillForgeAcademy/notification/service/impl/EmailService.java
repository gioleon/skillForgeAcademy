package com.skillForgeAcademy.notification.service.impl;

import com.skillForgeAcademy.notification.service.IActivateEmail;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import java.util.HashMap;
import java.util.Properties;

public class EmailService implements IActivateEmail {

  public Message buildMessage(Properties properties) {
    Session session = Session.getDefaultInstance(properties);
    return new MimeMessage(session);
  }

  @Override
  public Properties configPropertiesActivationEmail() {
    Properties properties = new Properties();
    properties.put("mail.smtp.host", "smtp.gmail.com");
    properties.put("mail.smtp.port", "587");
    properties.put("mail.smtp.auth", "true");
    properties.put("mail.smtp.starttls.enable", "true");

    return properties;
  }

  @Override
  public void sendActivationEmail(Object data) throws MessagingException {

    HashMap<String, String> userInfo = (HashMap<String, String>) data;

    Properties properties = configPropertiesActivationEmail();
    Message message = buildMessage(properties);

    message.setSubject("Activate your Skill Forge Academy account");
    message.setFrom(new InternetAddress("my email"));
    message.setText(
        getActivationEmailTemplate(
            userInfo.get("recipientName"),
            userInfo.get("activationLink"),
            userInfo.get("expirationHours")));
    message.setRecipient(
        Message.RecipientType.TO, new InternetAddress(userInfo.get("recipientEmail")));
    Transport.send(message);
  }

  @Override
  public String getActivationEmailTemplate(
      String recipientName, String activationLink, String expirationHours) {
    return """
                Subject: Account Activation

                Dear {recipientName},

                Thank you for registering for our service!

                To activate your account, please click on the following link:

                {activationLink}

                This link will expire in {expirationHours} hours.

                If you have any questions, please do not hesitate to contact us.

                Thank you,

                Skill Forge Academy.
                """
        .formatted(recipientName, activationLink, expirationHours);
  }
}
