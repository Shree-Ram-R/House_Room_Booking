package com.example.room_rent.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


import com.example.room_rent.enitity.Userentity;

@Repository
public interface Userrepo extends JpaRepository<Userentity,Integer>{
    boolean existsByEmail(String email);
     Optional<Userentity> findByUsername(String username);
    Optional<Userentity> findByEmail(String email);

    // @Query("SELECT new com.example.room_rent.dtos.UserSecureDto(u.username, u.email) FROM Userentity u")
    // List<UserSecureDto> allUsers(); 
}
