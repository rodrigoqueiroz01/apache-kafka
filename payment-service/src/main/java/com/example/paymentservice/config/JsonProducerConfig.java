package com.example.paymentservice.config;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.io.Serializable;
import java.util.HashMap;

@Configuration
public class JsonProducerConfig {

    private final KafkaProperties kafkaProperties;

    public JsonProducerConfig(KafkaProperties kafkaProperties) {
        this.kafkaProperties = kafkaProperties;
    }

    @Bean
    public ProducerFactory jsonProducerFactory() {
        var configs = new HashMap<String, Object>();
        configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getBootstrapServers());
        configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        return new DefaultKafkaProducerFactory(configs, new StringSerializer(), new JsonSerializer());
    }

    @Bean
    public KafkaTemplate<String, Serializable> jsonKafkaTemplate(ProducerFactory jsonProducerFactory) {
        return new KafkaTemplate<>(jsonProducerFactory);
    }

}
