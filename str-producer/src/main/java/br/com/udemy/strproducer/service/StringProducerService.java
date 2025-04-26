package br.com.udemy.strproducer.service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import static java.util.Objects.isNull;

@Log4j2
@Service
@AllArgsConstructor
public class StringProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message) {
        kafkaTemplate.send("str-topic", message)
                .addCallback(
                        success -> {
                            if (!isNull(success)) {
                                log.info("Send message with success {}", message);
                                log.info("Partition: {}, offset: {}",
                                        success.getRecordMetadata().partition(), success.getRecordMetadata().offset());
                            }
                        },
                        error -> log.error("Error: {}", error.getMessage())
                );
    }

}
