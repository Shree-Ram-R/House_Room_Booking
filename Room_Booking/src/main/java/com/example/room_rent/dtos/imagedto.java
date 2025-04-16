package com.example.room_rent.dtos;

public class imagedto {
        private int imgId;
        private String imgUrl;
        private int roomId;

    public imagedto(int imgId, String imgUrl, int roomId) {
        this.imgId = imgId;
        this.imgUrl = imgUrl;
        this.roomId = roomId;
    }

    public int getImgId() {
        return imgId;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }
}
