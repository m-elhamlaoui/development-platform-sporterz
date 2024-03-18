package com.example.kafkamessaging.Controller;

import com.example.kafkamessaging.MessageRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/kafka")
public class KafkaController {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaController(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping("{topic}/send/")
    public void publish(@PathVariable("topic") String topic, @RequestBody MessageRecord messageRecord) {
        kafkaTemplate.send(topic, messageRecord.message());
    }
}
