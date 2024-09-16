package com.myproject.springmicroservices.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQSender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Value("${springmicroservice.rabbitmq.exchange}")
    private String exchange;

    @Value("${springmicroservice.rabbitmq.routingkey}")
    private String routingkey;
    String kafkaTopic = "s1_topic";

    public void send(String message) {
        amqpTemplate.convertAndSend(exchange, routingkey, message);
        System.out.println("Send msg = " + message);

    }
}