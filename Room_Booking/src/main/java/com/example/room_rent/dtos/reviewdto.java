package com.example.room_rent.dtos;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;


public class reviewdto {
     private Integer rating;
     private String comment;
     private Integer bookingId;
     private Integer roomId;
     private Integer rId;
     @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
     private LocalDateTime LocalDate;

     
     // public reviewdto(Integer rating, String comment, Integer bookingId, Integer roomId) {
     //      this.rating = rating;
     //      this.comment = comment;
     //      this.bookingId = bookingId;
     //      this.roomId = roomId;
     // }
     public reviewdto(Integer rating, String comment, Integer bookingId, Integer roomId,Integer rId,LocalDateTime LocalDate) {
          this.rating = rating;
          this.comment = comment;
          this.bookingId = bookingId;
          this.roomId = roomId;
          this.rId=rId;
          this.LocalDate=LocalDate;
     }
     public reviewdto(){

     }
     
     public LocalDateTime getLocalDate() {
          return LocalDate;
     }
     public void setLocalDate(LocalDateTime localDate) {
          LocalDate = localDate;
     }
     public Integer getRid() {
          return rId;
     }
     public void setRid(Integer rid) {
          this.rId = rid;
     }
     public Integer getRating() {
          return rating;
     }
     public void setRating(Integer rating) {
          this.rating = rating;
     }
     public String getComment() {
          return comment;
     }
     public void setComment(String comment) {
          this.comment = comment;
     }
     public Integer getBookingId() {
          return bookingId;
     }
     public void setBookingId(Integer bookingId) {
          this.bookingId = bookingId;
     }
     public Integer getRoomId() {
          return roomId;
     }
     public void setRoomId(Integer roomId) {
          this.roomId = roomId;
     }
     
}
