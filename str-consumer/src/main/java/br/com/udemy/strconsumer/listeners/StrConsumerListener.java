package br.com.udemy.strconsumer.listeners;

import br.com.udemy.strconsumer.custom.StrConsumerCustomListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

@Component
public class StrConsumerListener {

    private static final Logger LOG = LogManager.getLogger(StrConsumerListener.class);

//    @KafkaListener(
//            groupId = "group-1",
//            topicPartitions = {
//                    @TopicPartition(
//                            topic = "str-topic",
//                            partitions = {"0"}
//                    )
//            },
//            containerFactory = "strContainerFactory"
//    )

    @StrConsumerCustomListener(groupId = "group-1")
    public void create(String message) throws Exception {
        LOG.info("CREATE :: Partition 0 :: Receive message: {}", message);
        throw new IllegalArgumentException("EXCEPTION...");
    }

    @StrConsumerCustomListener(groupId = "group-1")
    public void log(String message) {
        LOG.info("LOG ::: Receive message: {}", message);
    }

    @KafkaListener(
            groupId = "group-2",
            topics = "str-topic",
            containerFactory = "validMessageContainerFactory"
    )
    public void history(String message) {
        LOG.info("HISTORY ::: Receive message: {}", message);
    }

}
