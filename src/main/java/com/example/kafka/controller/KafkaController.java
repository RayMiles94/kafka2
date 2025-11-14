package com.example.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.kafka.services.MessageProducer;

@RestController
@RequestMapping("/kafka")
public class KafkaController {

    @Autowired
    private final MessageProducer producer;

    public KafkaController(MessageProducer producer) {
        this.producer = producer;
    }

    @PostMapping("/send")
    public String send(@RequestParam String msg) {
        producer.send(msg);
        return "Message sent: " + msg;
    }
}
