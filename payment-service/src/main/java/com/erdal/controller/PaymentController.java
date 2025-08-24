package com.erdal.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erdal.domain.Payment;
import com.erdal.service.PaymentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/payment")
@RequiredArgsConstructor
public class PaymentController {

	private final PaymentService paymentService;

	@PostMapping("/doPayment")
	public Payment createPayment(@RequestBody Payment payment) {
		return paymentService.doPayment(payment);
	}
	

	@GetMapping("/{orderId}")
	public ResponseEntity<Payment> findpaymentHistoryByOrderid(@PathVariable int orderId) {
		
	
		Payment payment=paymentService.findpaymentHistoryByOrderid(orderId);
		
		
		return ResponseEntity.ok( payment);

	}
}
