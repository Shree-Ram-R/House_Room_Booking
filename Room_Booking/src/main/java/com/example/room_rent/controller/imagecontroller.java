package com.example.room_rent.controller;
import com.example.room_rent.dtos.ImageUploadDTO;
import com.example.room_rent.enitity.imageentity;
import com.example.room_rent.service.imageservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/photos")
public class imagecontroller {
    @Autowired
    private imageservice imageservice;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<imageentity> uploadImage(
            @RequestParam("file") MultipartFile file,
            @RequestParam("roomId") Integer roomId) {
        try {
            ImageUploadDTO imageUploadDTO = new ImageUploadDTO();
            imageUploadDTO.setFile(file);
            imageUploadDTO.setRoomId(roomId);

            imageentity image = imageservice.uploadImage(imageUploadDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(image);
        } catch (IOException e) {
            throw new RuntimeException("Failed to upload image", e);
            
}}


    // Add image to a room
//    @PostMapping("/add/{roomId}")
//    public imagedto addImage(@RequestBody imagedto imgdto) {
//        return imageservice.addImage(imgdto);
//    }
//
//    // Get all images for a specific room
//    @GetMapping("/room/{roomId}")
//    public List<imagedto> getImages(@PathVariable Integer roomId) {
//        return imageservice.getImagesByRoomId(roomId);
//    }
//
//    // Delete image by ID
//    @DeleteMapping("/delete/{id}")
//    public String deleteImage(@PathVariable Integer id) {
//        return imageservice.deleteImage(id);
//    }
//
//    @GetMapping("/all")
//    public List<ImageUploadDTO> getAllImages() {
//        return imageservice.getAllImages();
//    }
//
//
//    @PostMapping("/upload")
//    public ResponseEntity<String> addImage(@RequestParam("file") MultipartFile file) {
//        try {
//            byte[] bytes = file.getBytes();
//            String imageUrl = imageservice.uploadImage(bytes);
//            return ResponseEntity.ok(imageUrl);
//        } catch (IOException e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Upload failed");
//        }
//    }




}
