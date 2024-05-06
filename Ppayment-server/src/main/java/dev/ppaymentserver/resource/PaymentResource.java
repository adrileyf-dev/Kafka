package dev.ppaymentserver.resource;

import dev.ppaymentserver.model.Payment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


public interface PaymentResource {
    @PostMapping
    ResponseEntity<PaymentResource> payment(@RequestBody Payment payment); //// depois criar um dto


}
