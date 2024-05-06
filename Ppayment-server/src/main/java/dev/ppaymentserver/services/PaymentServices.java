package dev.ppaymentserver.services;

import dev.ppaymentserver.model.Payment;

public interface PaymentServices {
     void SendPayment(Payment payment);
}
