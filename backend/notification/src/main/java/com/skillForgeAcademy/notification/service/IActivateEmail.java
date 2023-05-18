package com.skillForgeAcademy.notification.service;

import jakarta.mail.MessagingException;
import java.util.Properties;

public interface IActivateEmail {
  Properties configPropertiesActivationEmail();

  void sendActivationEmail(Object data) throws MessagingException;

  String getActivationEmailTemplate(
      String recipientName, String activationLink, String expirationHours);
}
