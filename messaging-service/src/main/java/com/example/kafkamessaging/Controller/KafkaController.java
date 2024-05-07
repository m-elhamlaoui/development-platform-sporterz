package com.example.kafkamessaging.Controller;

import com.example.kafkamessaging.MessageRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/kafka/send")
@CrossOrigin(origins = "http://localhost:8888")
public class KafkaController {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaController(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping
    public void publish(@RequestBody MessageRecord messageRecord) {
        kafkaTemplate.send("sporterz", messageRecord.message());
    }
}
