package com.example.room_rent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.room_rent.enitity.Bookingentity;

@Repository
public interface BookingRepository extends JpaRepository<Bookingentity,Integer> {
    
}
