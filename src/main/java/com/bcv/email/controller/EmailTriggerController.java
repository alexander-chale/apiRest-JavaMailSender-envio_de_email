package com.bcv.email.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailTriggerController {
    
    @Autowired
    MailSender mailSender;

    @RequestMapping(path = "/email/trigger/{email}", method = RequestMethod.POST)
    public String triggerEmail(@PathVariable String email) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setText("Enviado desde spring boot localhost:8080 ");
        message.setTo(email);
        message.setSubject("Proceso de registro cugs");
        message.setFrom("contraparteBCV@bcv.org.ve");
        try {
            mailSender.send(message);
            return "{\"message\": \"OK\"}";
        } catch (Exception e) {
            e.printStackTrace();
            return "{\"message\": \"Error\"}";
        }
    }

}
