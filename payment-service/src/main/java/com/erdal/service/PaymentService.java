package com.erdal.service;

import java.util.Random;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.erdal.domain.Payment;
import com.erdal.repository.PaymentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaymentService {
	
	private final PaymentRepository paymentRepository;
	
	public Payment doPayment(Payment payment) {
		
		payment.setPaymentStatus(paymentProssesing());
		payment.setTransactionId(UUID.randomUUID().toString());
		return paymentRepository.save(payment);
	}
public String paymentProssesing() {
		
		// api sould be 3rd party payment (PayPal,Visa,...)
		
		return new Random().nextBoolean() ? "SUCCES" :"FALSE";
	}
public Payment findpaymentHistoryByOrderid(int orderId) {
	return paymentRepository.findByOrderId(orderId);
	
	
	
}

}
