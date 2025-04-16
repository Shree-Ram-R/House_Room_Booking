package com.example.room_rent.enitity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "booking")
public class Bookingentity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookingId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Userentity user;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Roomentity room;

    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDate bookingDate;

    private String status;

    public Bookingentity() {

    }

    public Bookingentity(Integer bookingId, Userentity user, Roomentity room,
            LocalDate startDate, LocalDate endDate, LocalDate bookingDate, String status) {
        this.bookingId = bookingId;
        this.user = user;
        this.room = room;
        this.startDate = startDate;
        this.endDate = endDate;
        this.bookingDate = bookingDate;
        this.status = status;
    }

    public Bookingentity(Userentity user, Roomentity room,
            LocalDate startDate, LocalDate endDate, LocalDate bookingDate, String status) {

        this.user = user;
        this.room = room;
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

    public Userentity getUser() {
        return user;
    }

    public void setUser(Userentity user) {
        this.user = user;
    }

    public Roomentity getRoom() {
        return room;
    }

    public void setRoom(Roomentity room) {
        this.room = room;
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
