package com.example.room_rent.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.room_rent.enitity.PaymentEntity;

public interface Paymentrepo extends JpaRepository<PaymentEntity,Integer> {
    
}
