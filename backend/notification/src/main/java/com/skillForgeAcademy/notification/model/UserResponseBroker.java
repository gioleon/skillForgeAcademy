package com.skillForgeAcademy.notification.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseBroker {
  private String recipientEmail;
  private String message;
  private String subject;
}
