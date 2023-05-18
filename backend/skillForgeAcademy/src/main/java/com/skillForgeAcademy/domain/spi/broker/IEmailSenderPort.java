package com.skillForgeAcademy.domain.spi.broker;

public interface IEmailSenderPort {
  void send(String channel, Object object);
}
