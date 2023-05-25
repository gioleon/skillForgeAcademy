package com.skillForgeAcademy.domain.spi.broker;

import com.skillForgeAcademy.domain.model.UserResponseBroker;

public interface IEmailSenderPort {
  void send(String channel, UserResponseBroker userResponseBroker);
}
