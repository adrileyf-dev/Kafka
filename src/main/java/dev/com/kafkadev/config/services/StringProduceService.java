package dev.com.kafkadev.config.services;

import com.sun.net.httpserver.Authenticator;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
@Log4j2
@Service
@RequiredArgsConstructor
public class StringProduceService {
     private final KafkaTemplate<String,String> kafkaTemplate;
     public void sendMessagem(String message){
         kafkaTemplate.send("Str-topic",message)
                 .thenAccept(success -> {
                     if (success != null) {
                         log.info("Send message with success {}", message);
                         log.info("Partition {}, Offset {}", success.getRecordMetadata().partition(), success.getRecordMetadata().offset());
                     }
                 })
                 .exceptionally(error -> {
                     log.error("Error sending message: {}", error.getMessage());
                     return null; // or handle error accordingly
                 });
         }
}
