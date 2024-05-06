package dev.consumer.listners;

import dev.consumer.model.Payment;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import static java.lang.Thread.sleep;

@Component
@Log4j2

public class ConsumerListener {
    @SneakyThrows
    @KafkaListener(topics = "payment",groupId = "create",containerFactory = "jsonContainerFactory")
    public void antiFraud(@Payload Payment payment ){
        log.info("Pagamento {}",payment);
        log.info("Validando Anti Fraude ");
        sleep(2000);
        log.info("Compra comprovada");
        sleep(3000);

    }
    @SneakyThrows
    @KafkaListener(topics = "payment",groupId = "pdf",containerFactory = "jsonContainerFactory")
    public void pdf(){
        log.info("Gerando PDF");
        sleep(2000);
    }
    @SneakyThrows
    @KafkaListener(topics = "payment",groupId = "email",containerFactory = "jsonContainerFactory")
    public void SendEmal(){
        log.info("Enviado Email");

    }
}