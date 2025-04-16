package com.example.room_rent.controller;

import com.example.room_rent.dtos.imagedto;
import com.example.room_rent.service.imageservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/images")
public class imagecontroller {
    @Autowired
    private imageservice imageservice;
    // Add image to a room
    @PostMapping("/add/{roomId}")
    public imagedto addImage(@RequestBody imagedto imgdto) {
        return imageservice.addImage(imgdto);
    }

    // Get all images for a specific room
    @GetMapping("/room/{roomId}")
    public List<imagedto> getImages(@PathVariable Integer roomId) {
        return imageservice.getImagesByRoomId(roomId);
    }

    // Delete image by ID
    @DeleteMapping("/delete/{id}")
    public String deleteImage(@PathVariable Integer id) {
        return imageservice.deleteImage(id);
    }

    @GetMapping("/all")
    public List<imagedto> getAllImages() {
        return imageservice.getAllImages();
    }


}
