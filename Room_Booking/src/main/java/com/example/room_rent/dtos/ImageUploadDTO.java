package com.example.room_rent.dtos;

import org.springframework.web.multipart.MultipartFile;

public class ImageUploadDTO {
    private MultipartFile file;
    private Integer roomId;

    // Getters and Setters
    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
}
}