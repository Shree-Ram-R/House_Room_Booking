package com.example.room_rent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;

import com.example.room_rent.enitity.SupportTicketEntity;

public interface SupportTicketRepo extends JpaRepository<SupportTicketEntity, Integer> {
    
}
