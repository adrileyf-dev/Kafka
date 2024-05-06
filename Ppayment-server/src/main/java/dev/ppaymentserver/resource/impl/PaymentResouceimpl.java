package dev.ppaymentserver.resource.impl;

import dev.ppaymentserver.model.Payment;
import dev.ppaymentserver.resource.PaymentResource;
import dev.ppaymentserver.services.PaymentServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(value ="payment" )
public class PaymentResouceimpl  implements PaymentResource {
    private  final PaymentServices paymentServices;

    @Override
    public ResponseEntity<PaymentResource> payment(Payment payment) {
        paymentServices.SendPayment(payment);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
