package dev.ppaymentserver.services.impl;
import dev.ppaymentserver.model.Payment;
import dev.ppaymentserver.services.PaymentServices;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
@Log4j2
@RequiredArgsConstructor
public class PaymentServiceImpl  implements PaymentServices {
    private final KafkaTemplate<String, Serializable>kafkaTemplate;
    @SneakyThrows
    @Override
    public void SendPayment(Payment payment) {
        log.info("Recebendo objet{}" ,payment);
        Thread.sleep(1000);
        log.info("Enviado pagamento...");
        kafkaTemplate.send("payment",payment);

    }
}
