package com.skillForgeAcademy.infrastructure.output.broker.adapter;

import com.skillForgeAcademy.domain.spi.broker.IEmailSenderPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;

public class EmailSenderAdapter implements IEmailSenderPort {

  @Autowired private StreamBridge sender;

  @Override
  public void send(String channel, Object object) {
    sender.send(channel, object);
  }
}
