package com.erdal.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.erdal.common.Payment;
import com.erdal.common.TransactionRequest;
import com.erdal.common.TransactionResponse;
import com.erdal.domain.Order;
import com.erdal.repository.OrderRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final RestTemplate restTemplate;

    public TransactionResponse saveOrder(TransactionRequest transactionRequest) {

        Order order = transactionRequest.getOrder();
        Payment payment = transactionRequest.getPayment();
        payment.setAmount(order.getPrice());

        // Gateway üzerinden ödeme servisine çağrı
        Payment paymentResponse = restTemplate.postForObject(
        		"http://payment-service/payment/doPayment", 
                payment, 
                Payment.class);

        String responseMessage = paymentResponse.getPaymentStatus().equals("SUCCES") ?
                "Payment successful, order placed" :
                "Payment failed, order added to cart";

        orderRepository.save(order);

        return new TransactionResponse(order, paymentResponse.getAmount(), paymentResponse.getTransactionId(), responseMessage);
    }
}
