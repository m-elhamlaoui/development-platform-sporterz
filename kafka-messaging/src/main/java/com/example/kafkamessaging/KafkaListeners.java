package com.example.kafkamessaging;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    @KafkaListener(topics = "sporterz", groupId = "groupId")
    public void listen(Message message) {
        System.out.println("Received message: " + message.mssg());
    }
}
