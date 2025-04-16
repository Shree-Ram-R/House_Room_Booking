package com.example.room_rent.dtos;

import java.time.LocalDate;

public class Bookingdto {
    
    private Integer bookingId;
    private Integer userId;
    private Integer roomId;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDate bookingDate;
    private String status;

    public Bookingdto() {
    }

    public Bookingdto(Integer bookingId, Integer userId, Integer roomId,
                      LocalDate startDate, LocalDate endDate, LocalDate bookingDate, String status) {
        this.bookingId = bookingId;
        this.userId = userId;
        this.roomId = roomId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.bookingDate = bookingDate;
        this.status = status;
    }

    public Integer getBookingId() {
        return bookingId;
    }

    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
