package com.skillForgeAcademy.notification.service;

import com.skillForgeAcademy.notification.model.UserResponseBroker;
import jakarta.mail.MessagingException;

public interface IActivateEmail {

  void sendActivationEmail(UserResponseBroker userResponseBroker) throws MessagingException;
}
