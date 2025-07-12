package br.com.udemy.strproducer.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class StringProducerService {

    private static final String TOPIC_NAME = "str-topic";

    private final KafkaTemplate<String, String> kafkaTemplate;

    public StringProducerService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message) {
        kafkaTemplate.send(TOPIC_NAME, message);
    }

}
