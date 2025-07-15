package com.example.paymentservice.resource.impl;

import com.example.paymentservice.model.Payment;
import com.example.paymentservice.resource.PaymentResource;
import com.example.paymentservice.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping(value = "/payments")
public class PaymentResourceImpl implements PaymentResource {

    private static final Logger LOG = LoggerFactory.getLogger(PaymentResourceImpl.class);
    private final PaymentService paymentService;

    public PaymentResourceImpl(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @Override
    public ResponseEntity<Payment> payment(Payment payment) {
        paymentService.sendPayment(payment);
        return ResponseEntity.status(CREATED).body(payment);
    }

}
