package com.example.room_rent.repository;

import com.example.room_rent.enitity.imageentity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface imagerepo extends JpaRepository<imageentity,Integer> {
     List<imageentity> findByRoom_Roomid(Integer roomid);
}