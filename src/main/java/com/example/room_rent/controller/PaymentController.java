package com.example.room_rent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.room_rent.dtos.Paymentdto;
import com.example.room_rent.service.Paymentservice;




@RestController
@RequestMapping("/payment")
// @CrossOrigin(origins = "*")
public class PaymentController {
    
    @Autowired
    private Paymentservice paymentservice;

    @PostMapping
    public Paymentdto createPayment(@RequestBody Paymentdto paymentdto) {
        //TODO: process POST request
        return paymentservice.createPayment(paymentdto);
    }

    @GetMapping
    public List<Paymentdto> getAllPayment(){
        return paymentservice.getAllPayments();
    }

    @GetMapping("/{id}")
    public Paymentdto getPaymentById(@PathVariable Integer id) {
        return paymentservice.getPaymentById(id);
    }
    
    @DeleteMapping("/{id}")
    public String deletePayment(@PathVariable Integer id){
        paymentservice.deletePayment(id);
        return "payment with the ID" + id + "has been deleted Sucessfully";
    }
}
