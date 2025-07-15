package com.example.jsonconsumer.listener;

import com.example.jsonconsumer.model.Payment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import static java.lang.Thread.sleep;

@Component
public class JsonListener {

    private static final Logger LOG = LoggerFactory.getLogger(JsonListener.class);

    @KafkaListener(topics = "payment-topic", groupId = "create-group", containerFactory = "jsonContainerFactory")
    public void antiFraud(@Payload Payment payment) throws InterruptedException {
        LOG.info("Recebi o pagamento {}", payment.toString());
        LOG.info("Validando fraude...");
        sleep(2000);

        LOG.info("Recommendation: APPROVED...");
    }

    @KafkaListener(topics = "payment-topic", groupId = "pdf-group", containerFactory = "jsonContainerFactory")
    public void pdfGenerator() throws InterruptedException {
        LOG.info("Gerando PDF...");
        sleep(2000);
    }

    @KafkaListener(topics = "payment-topic", groupId = "email-group", containerFactory = "jsonContainerFactory")
    public void sendEmail() throws InterruptedException {
        LOG.info("Enviando email de confirmação...");
    }

}
