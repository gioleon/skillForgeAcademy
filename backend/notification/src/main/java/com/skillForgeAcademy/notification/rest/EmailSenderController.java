package com.skillForgeAcademy.notification.rest;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;

import java.util.function.Consumer;

@Controller
public class EmailSenderController {

    @Bean
    Consumer<String> receiveEmail() {
        return email -> {
            System.out.println(email);
        };
    }

}
