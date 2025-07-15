package com.example.paymentservice.service.impl;

import com.example.paymentservice.model.Payment;
import com.example.paymentservice.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    private static final Logger LOG = LoggerFactory.getLogger(PaymentService.class);

    @Override
    public void sendPayment(Payment payment) {
        LOG.info("PAYMENT_SERVICE_IMPL :: Recebi o pagamento {}", payment);
    }

}
