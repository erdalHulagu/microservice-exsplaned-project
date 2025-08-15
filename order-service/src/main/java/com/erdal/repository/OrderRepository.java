package com.erdal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.erdal.domain.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{

}
