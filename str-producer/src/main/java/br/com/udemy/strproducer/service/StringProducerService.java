package br.com.udemy.strproducer.service;

import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class StringProducerService {

    private static final String TOPIC_NAME = "str-topic";

    private static final Logger LOG = LogManager.getLogger(StringProducerService.class);
    private final KafkaTemplate<String, String> kafkaTemplate;

    public StringProducerService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message) {
        LOG.info("Send message: {}", message);
        kafkaTemplate.send(TOPIC_NAME, message);
//                .addCallback(
//                success -> {
//                    if (success != null) {
//                        LOG.info("Send message with success {}", success);
//                        LOG.info("Partition {}, Offset {}",
//                                success.getRecordMetadata().partition(),
//                                success.getRecordMetadata().offset()
//                        );
//                    }
//                },
//                error -> LOG.error("Error send message")
//        );
    }

}
