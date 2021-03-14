package info.kausar.psapi.service;

import info.kausar.psapi.entity.Payment;
import info.kausar.psapi.reposityory.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    public Payment doPayment(Payment payment) {
        payment.setPaymentStatus(paymentProcessing());
        payment.setTransactionId(UUID.randomUUID().toString());
        return paymentRepository.save(payment);
    }

    public String paymentProcessing() {
        //api should be 3rd party payment gateway
        return new Random().nextBoolean()?"success": "failed";
    }

}
