package dev.com.kafkadev.config.services;

import com.sun.net.httpserver.Authenticator;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
@Log4j2
@Service
@RequiredArgsConstructor
public class StringProduceService {
     private final KafkaTemplate<String,String> kafkaTemplate;
     public void sendMessagem(String message,int partition){
       ///  log.info("send Message");
      //   kafkaTemplate.send("Str-topic",message);
//                 .thenAccept(success -> {
//                     if (success != null) {
//                         log.info("Send message with success {}", message);
//                         log.info("Partition {}, Offset {}", success.getRecordMetadata().partition(), success.getRecordMetadata().offset());
//                     }
//                 })
//                 .exceptionally(error -> {
//                     log.error("Error sending message: {}", error.getMessage());
//                     return null; // or handle error accordingly
//                 });

             log.info("Sending Message");
             ProducerRecord<String, String> record = new ProducerRecord<>("dev", partition, null, message);
             kafkaTemplate.send(record);
         }
}
