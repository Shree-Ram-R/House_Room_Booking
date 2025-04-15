package com.example.room_rent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.room_rent.enitity.Roomentity;
import java.util.List;


@Repository
public interface Roomrepo extends JpaRepository<Roomentity,Integer>{
    List<Roomentity> findByowner_userid(Integer id);
}
