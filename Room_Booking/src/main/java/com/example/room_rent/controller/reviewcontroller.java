package com.example.room_rent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.room_rent.dtos.reviewdto;
import com.example.room_rent.service.reviewservice;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/review")
public class reviewcontroller {
     @Autowired
     private reviewservice rservice;

     @GetMapping("/get")
     public List<reviewdto> all(){
          return rservice.getAllReviews();
     }
     @GetMapping("/getreview/{roomId}")
     public List<reviewdto> getreview(@PathVariable Integer roomId){
          return rservice.getReviewsByRoomId(roomId);
     }
     @PostMapping("/post")
     public reviewdto postmethod(@RequestBody reviewdto dto){
          return rservice.addReview(dto);
     }
     @PutMapping("path/{id}")
     public String putMethodName(@PathVariable Integer id, @RequestBody reviewdto dto) {
         return rservice.update(id,dto);
     }
     @DeleteMapping("/{id}")
     public String deletemethod(@PathVariable Integer id){
          return rservice.deletereview(id);
     }
     

     
}