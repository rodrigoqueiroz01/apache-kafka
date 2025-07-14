package br.com.udemy.strconsumer.exceptions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.kafka.listener.KafkaListenerErrorHandler;
import org.springframework.kafka.listener.ListenerExecutionFailedException;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
public class ErrorCustomHandler implements KafkaListenerErrorHandler {

    private static final Logger LOG = LogManager.getLogger(ErrorCustomHandler.class);

    @Override
    public Object handleError(Message<?> message, ListenerExecutionFailedException e) {
        LOG.info("EXCEPTION_HANDLER :: Erro capturado");
        LOG.info("PAYLOAD :: {}", message.getPayload());
        LOG.info("HEADER :: {}", message.getHeaders());
        LOG.info("OFFSET :: {}", message.getHeaders().get("kafka_offset"));
        LOG.info("MESSAGE_EXCEPTION :: {}", e.getMessage());
        return null;
    }

}
