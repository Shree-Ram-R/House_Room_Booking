package com.example.room_rent.dtos;



import java.time.LocalDate;

public class BookingResponseDto {
    private LocalDate bookingDate;
    private int bookingId;
    private int userId;
    private int roomId;
    private LocalDate startDate;
    private LocalDate endDate;
    private String status;
    private Userdto user;
    private Roomdto room;
    public Roomdto getRoom() {
        return room;
    }

    public void setRoom(Roomdto room) {
        this.room = room;
    }

    public BookingResponseDto(LocalDate bookingDate, int bookingId, int userId, int roomId, LocalDate startDate,
            LocalDate endDate, String status, Userdto user,Roomdto room) {
        this.bookingDate = bookingDate;
        this.bookingId = bookingId;
        this.userId = userId;
        this.roomId = roomId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.user = user;
        this.room=room;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Userdto getUser() {
        return user;
    }

    public void setUser(Userdto user) {
        this.user = user;
    }
}
