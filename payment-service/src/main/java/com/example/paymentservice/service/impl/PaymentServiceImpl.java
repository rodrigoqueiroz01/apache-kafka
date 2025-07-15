package com.example.paymentservice.service.impl;

import com.example.paymentservice.model.Payment;
import com.example.paymentservice.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public class PaymentServiceImpl implements PaymentService {

    private static final Logger LOG = LoggerFactory.getLogger(PaymentService.class);
    private final KafkaTemplate<String, Serializable> kafkaTemplate;

    public PaymentServiceImpl(KafkaTemplate<String, Serializable> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void sendPayment(Payment payment) throws InterruptedException {
        LOG.info("Recebi o pagamento {}", payment);
        Thread.sleep(1000);

        LOG.info("enviando pagamento...");
        kafkaTemplate.send("payment-topic", payment);
    }

}
