package com.example.room_rent.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.room_rent.dtos.Roomdto;

import com.example.room_rent.enitity.Roomentity;

import com.example.room_rent.service.Roomservice;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/rooms")
public class Roomcontroller {
    @Autowired
    private Roomservice rserv;


    @PostMapping("/addroom")
    public ResponseEntity<Roomentity> postMethodName(@RequestBody Roomdto dt) {
        Roomentity details = rserv.add(dt);
        return ResponseEntity.ok(details);
    }

    @GetMapping("/{id}")
    public Roomdto rooms(@PathVariable Integer id) {
        return rserv.get(id);
    }
    @GetMapping("/")
    public List<Roomdto> all() {
        return rserv.getAllRooms();
    }
     @GetMapping("/getuserroom/{id}")
     public List<Roomdto> getMethodName(@PathVariable Integer id) {
         return rserv.getuser(id);
     }

     @PutMapping("/{id}")
     public String putMethodName(@PathVariable Integer id, @RequestBody Roomdto dt) {
         return this.rserv.update(id, dt);
     }
     @DeleteMapping("/{id}")
     public String delete(@PathVariable Integer id)
     {
        return rserv.delete(id);
     }
    
}
