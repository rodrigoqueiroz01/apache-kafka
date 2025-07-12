package br.com.udemy.strproducer.rest;

import br.com.udemy.strproducer.service.StringProducerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping(value = "/v1/producer")
public class StringProducerResource {

    private final StringProducerService service;

    public StringProducerResource(StringProducerService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> sendMessage(@RequestBody String message) {
        service.sendMessage(message);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
