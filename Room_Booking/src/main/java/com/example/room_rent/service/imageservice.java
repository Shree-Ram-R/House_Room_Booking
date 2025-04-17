package com.example.room_rent.service;
import com.example.room_rent.dtos.imagedto;

import com.example.room_rent.enitity.Roomentity;
import com.example.room_rent.enitity.imageentity;
import com.example.room_rent.repository.Roomrepo;
import com.example.room_rent.repository.imagerepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class imageservice {

    @Autowired
    private imagerepo imageRepository;

    @Autowired
    private Roomrepo roomRepository;

    public imagedto addImage(imagedto dto) {
        Roomentity room = roomRepository.findById(dto.getRoomId())
                .orElseThrow(() -> new RuntimeException("Room not found"));

        imageentity image = new imageentity();
        image.setImgUrl(dto.getImgUrl());
        image.setRoom(room);

        imageentity saved = imageRepository.save(image);
        return new imagedto(saved.getId(), saved.getImgUrl(), saved.getRoom().getRoomid());
    }

    public List<imagedto> getAllImages() {
        return imageRepository.findAll().stream()
                .map(img -> new imagedto(img.getId(), img.getImgUrl(), img.getRoom().getRoomid()))
                .collect(Collectors.toList());
    }

    public List<imagedto> getImagesByRoomId(Integer roomId) {
        List<imageentity> imageEntities = imageRepository.findByRoom_Roomid(roomId);  // FIXED LINE

        // Convert imageentity to imagedto
        return imageEntities.stream().map(image -> new imagedto(
                image.getId(),
                image.getImgUrl(),
                image.getRoom().getRoomid()  // Assuming getRoomid() returns the room's ID
        )).collect(Collectors.toList());
    }

    public String deleteImage(Integer id) {
        imageRepository.deleteById(id);
        return "delete image ";
    }
}