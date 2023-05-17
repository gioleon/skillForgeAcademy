package com.skillForgeAcademy.notification.rest;

import com.skillForgeAcademy.notification.service.impl.EmailService;
import jakarta.mail.MessagingException;
import java.util.function.Consumer;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class EmailSenderController {

  private final EmailService emailSender;

  @Bean
  Consumer<String> receiveEmail() {
    return data -> {
      try {
        emailSender.sendActivationEmail(data);
      } catch (MessagingException e) {
        throw new RuntimeException(e);
      }
    };
  }
}
