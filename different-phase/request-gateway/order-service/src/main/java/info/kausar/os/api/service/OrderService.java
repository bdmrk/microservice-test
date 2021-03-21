package info.kausar.os.api.service;

import info.kausar.os.api.common.Payment;
import info.kausar.os.api.common.TransactionRequest;
import info.kausar.os.api.common.TransactionResponse;
import info.kausar.os.api.entity.Order;
import info.kausar.os.api.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    private OrderRepository oRepository;

    @Autowired
    private RestTemplate template;

    public TransactionResponse orderSave(TransactionRequest request) {

        String response = "";
        Order order = request.getOrder();
        Payment payment = request.getPayment();
        payment.setOrderId(order.getId());
        payment.setAmount(order.getPrice());
        //rest api call

        //for the time being hard code url
        Payment paymentResponse = template.postForObject("http://PAYMENT-SERVICE/payment/doPayment", payment, Payment.class);
        response = paymentResponse.getPaymentStatus().equals("success") ? "Payment success and order placed" : "Payment Failed but order placed";
        oRepository.save(order);
        return new TransactionResponse(order, paymentResponse.getAmount(), paymentResponse.getTransactionId(), response);

    }
}
