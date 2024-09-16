package com.myproject.springmicroservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.myproject.springmicroservices.service.RabbitMQSender;

@RestController
@RequestMapping(value = "/s1-rabbitmq/")
public class RabbitMQController {

    @Autowired
    RabbitMQSender rabbitMQSender;

    @GetMapping(value = "/producer")
    public String producer() {

        rabbitMQSender.send("ping");

        return "Message sent to the RabbitMQ JavaInUse Successfully";
    }
}