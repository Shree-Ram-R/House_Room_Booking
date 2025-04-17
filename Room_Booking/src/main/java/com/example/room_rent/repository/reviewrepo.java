package com.example.room_rent.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.room_rent.enitity.reviewentity;

public interface reviewrepo extends JpaRepository<reviewentity,Integer> {
     List<reviewentity> findByRoom_roomid(Integer roomid);
     
}
