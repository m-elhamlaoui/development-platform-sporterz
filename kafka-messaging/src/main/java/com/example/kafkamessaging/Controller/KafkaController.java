package com.example.kafkamessaging.Controller;

import com.example.kafkamessaging.MessageRecord;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("api/kafka")
public class KafkaController {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final AdminClient adminClient;

    @Autowired
    public KafkaController(KafkaTemplate<String, String> kafkaTemplate, AdminClient adminClient) {
        this.kafkaTemplate = kafkaTemplate;
        this.adminClient = adminClient;
    }

    @PostMapping("send/{topic}")
    public void publish(@PathVariable("topic") String topic, @RequestBody MessageRecord messageRecord) {
        kafkaTemplate.send(topic, messageRecord.message());
    }

    @PostMapping("create-topic")
    public ResponseEntity<String> createTopic(@RequestParam String topicName) {
        NewTopic newTopic = new NewTopic(topicName, 1, (short) 1);
        try {
            adminClient.createTopics(Collections.singleton(newTopic)).all().get();
            return ResponseEntity.status(HttpStatus.CREATED).body("Topic created successfully: " + topicName);
        } catch (InterruptedException | ExecutionException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create topic: " + topicName);
        }
    }
}
