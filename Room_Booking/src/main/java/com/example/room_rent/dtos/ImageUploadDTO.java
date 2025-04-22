package com.example.room_rent.dtos;

import org.springframework.web.multipart.MultipartFile;

public class ImageUploadDTO {
    private MultipartFile file;
    private Integer roomId;

    public ImageUploadDTO(int id, String imgUrl, Integer roomid2) {
        //TODO Auto-generated constructor stub
    }

    public ImageUploadDTO() {
        //TODO Auto-generated constructor stub
    }

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