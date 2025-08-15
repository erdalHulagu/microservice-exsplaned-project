package com.erdal.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erdal.domain.Payment;
import com.erdal.service.PaymentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/payments")
@RequiredArgsConstructor
public class PaymentController {
	
	private final PaymentService paymentService;

	@PostMapping("/doPayment")
	public Payment createPayment(@RequestBody Payment payment) {
	    return paymentService.doPayment(payment);
	}
	

}
