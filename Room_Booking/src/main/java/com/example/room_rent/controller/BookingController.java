package com.example.room_rent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.room_rent.dtos.Bookingdto;
import com.example.room_rent.service.Bookingservice;



@RestController
@RequestMapping("/book")
// @CrossOrigin(origins = "*")
public class BookingController {
    @Autowired
    private Bookingservice bookingservice;

    @GetMapping
    public List<Bookingdto> getAllBookings() {
        return bookingservice.getAllBookings();
    }
    
}
