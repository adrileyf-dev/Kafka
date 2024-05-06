package dev.consumer.custom.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.converter.JsonMessageConverter;

import java.util.HashMap;

@RequiredArgsConstructor
@Configuration
@Log4j2
public class JsonConsumerConfig {
    private final KafkaProperties properties;
    @Bean
    public ConsumerFactory<String, Object> consumerFactory() {
        var configs = new HashMap<String, Object>();
        configs.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, properties.getBootstrapServers());
        configs.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        configs.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        return new DefaultKafkaConsumerFactory<>(configs);
    }
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Object> jsonContainerFactory(
           ConsumerFactory<String,Object>jsonConsumerFactory)
    {
        var    factory = new ConcurrentKafkaListenerContainerFactory<String,Object>();
               factory.setConsumerFactory(jsonConsumerFactory);
               factory.setRecordMessageConverter(new JsonMessageConverter());
               return factory;
    }//
//    @Bean
//    public ConcurrentKafkaListenerContainerFactory<String, String> ValidarContainerFactory(
//            ConsumerFactory<String, String> consumerFactory) {
//        var factory = new ConcurrentKafkaListenerContainerFactory<String, String>();
//            factory.setConsumerFactory(consumerFactory);
//            factory.setRecordInterceptor(ValidMsg());
//        return factory;
//    }//
//    private RecordInterceptor<String, String> ValidMsg() {
//        return (record,acknowledgment) -> {
//            if (record.value().contains("dev")) {
//                log.info("Achou");
//                return record;
//            }
//            return null;
//        };


}