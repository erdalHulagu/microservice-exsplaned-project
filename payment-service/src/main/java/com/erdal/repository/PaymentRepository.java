package com.erdal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.erdal.domain.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {

}
