package dev.consumer;

import dev.consumer.custom.config.CustomConsumerListener;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
@Component
@Log4j2

public class ConsumerListener {
    @SneakyThrows
    @CustomConsumerListener(groupId = "group-1")
         public void create(String message) {
        log.info("CRETA-Receiver Message {}", message);

        throw  new IllegalArgumentException("EXception");
    }
    @KafkaListener(groupId = "group-2",containerFactory = "ValidarContainerFactory",topics ="dev" )
         public void log(String message) {
        log.info("LOG-Receiver Message {}", message);
    }
}
//      @CustomConsumerListener(groupId = "group-1",topicPartitions ={
//      @TopicPartition(topic = "Str-topic",partitions = {"0"})
//    },containerFactory = "strContainerFactory")
//
//        public  void create(String messge){
//       log.info("linstener - Receiver Message {}",messge);
//    }
//
//      @KafkaListener(groupId = "group-1",topicPartitions ={a
//             @TopicPartition(topic = "Str-topic",partitions = {"1"})
//       },containerFactory = "strContainerFactory")
//
//    public  void log(String messge){
//        log.info("LOG - Receiver Message {}",messge);
//    }
//}
//    @KafkaListener(groupId = "group-1",topicPartitions = {
//            @TopicPartition(topic = "Str_topic",partitions = {"0"})
//    },containerFactory = "strContainerFactory")
//    public  void linstener(String messge){
//        log.info("LOG - Receiver Message {}",messge);
//    }