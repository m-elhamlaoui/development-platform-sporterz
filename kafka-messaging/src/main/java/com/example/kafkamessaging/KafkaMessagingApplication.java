package com.example.kafkamessaging;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.test.EmbeddedKafkaBroker;
import org.springframework.kafka.test.EmbeddedKafkaZKBroker;

@SpringBootApplication
@Configuration
public class KafkaMessagingApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaMessagingApplication.class, args);
	}

	@Bean
	EmbeddedKafkaBroker broker() {
		return new EmbeddedKafkaZKBroker(1)
				.kafkaPorts(9092)
				.brokerListProperty("spring.kafka.bootstrap-servers");
	}

}
