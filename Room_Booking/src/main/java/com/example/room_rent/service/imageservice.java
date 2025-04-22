package com.example.room_rent.service;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.example.room_rent.dtos.ImageUploadDTO;
import com.example.room_rent.enitity.Roomentity;
import com.example.room_rent.enitity.imageentity;
import com.example.room_rent.repository.Roomrepo;
import com.example.room_rent.repository.imagerepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Service
public class imageservice {

    @Autowired
    private imagerepo imageRepository;

    @Autowired
    private Roomrepo roomRepository;
    @Autowired
    private Cloudinary cloudinary;



//    public imagedto addImage(ImageUploadDTO dto) {
//        Roomentity room = roomRepository.findById(dto.getRoomId())
//                .orElseThrow(() -> new RuntimeException("Room not found"));
//
//        imageentity image = new imageentity();
//        image.setImgUrl(dto.getImgUrl());
//        image.setRoom(room);
 //
//        imageentity saved = imageRepository.save(image);
//        return new imagedto(saved.getId(), saved.getImgUrl(), saved.getRoom().getRoomid());
//    }

    @Transactional
    public imageentity uploadImage(ImageUploadDTO imageUploadDTO) throws IOException {
        // Upload to Cloudinary
        Map<?, ?> uploadResult = cloudinary.uploader().upload(
                imageUploadDTO.getFile().getBytes(),
                ObjectUtils.emptyMap()
        );

        // Get the room
        Roomentity room = roomRepository.findById(imageUploadDTO.getRoomId())
                .orElseThrow(() -> new RuntimeException("Room not found"));

        // Create and save image entity
        imageentity image = new imageentity();
        image.setImgUrl(uploadResult.get("url").toString());
        image.setRoom(room);

        return imageRepository.save(image);


    }

    @GetMapping
    public ResponseEntity<String> handleGetImages() {
        return ResponseEntity.ok("This endpoint only accepts POST for image uploads.");
    }

    // public Object uploadImage(MultipartFile file, int roomId) {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'uploadImage'");
    // }

//    public List<imagedto> getAllImages() {
//        return imageRepository.findAll().stream()
//                .map(img -> new imagedto(img.getId(), img.getImgUrl(), img.getRoom().getRoomid()))
//                .collect(Collectors.toList());
//    }
//
//    public List<imagedto> getImagesByRoomId(Integer roomId) {
//        List<imageentity> imageEntities = imageRepository.findByRoom_Roomid(roomId);  // FIXED LINE
//
//        // Convert imageentity to imagedto
//        return imageEntities.stream().map(image -> new imagedto(
//                image.getId(),
//                image.getImgUrl(),
//                image.getRoom().getRoomid()  // Assuming getRoomid() returns the room's ID
//        )).collect(Collectors.toList());
//    }
//
//    public String deleteImage(Integer id) {
//        imageRepository.deleteById(id);
//        return "delete image ";
//    }
//    public String uploadImage(byte[] file) {
//        try {
//            Map uploadResult = cloudinary.uploader().upload(file.length, ObjectUtils.emptyMap());
//            return (String) uploadResult.get("secure_url");
//        } catch (IOException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }

}