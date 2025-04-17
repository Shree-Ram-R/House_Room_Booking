package com.example.room_rent.enitity;

import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="review")
public class reviewentity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "r_id")
    private Integer rId;

    @Column(name = "rating")
    private Integer rating;

    @Column(name = "comment", columnDefinition = "TEXT")
    private String comment;

    @Column(name = "review_date")
    private LocalDate reviewDate;

    // Many reviews can belong to one booking
    @ManyToOne
    @JoinColumn(name = "booking_id", referencedColumnName = "booking_id")
    private Bookingentity booking;

    // Many reviews can be for one room
    @ManyToOne
    @JoinColumn(name = "room_id", referencedColumnName = "room_id")
    private Roomentity room;

    public reviewentity(Integer rating, String comment, LocalDate reviewDate, Bookingentity booking, Roomentity room) {
        this.rating = rating;
        this.comment = comment;
        this.reviewDate = reviewDate;
        this.booking = booking;
        this.room = room;
    }
    public reviewentity(){

    }

    public Integer getrId() {
     return rId;
    }

    public void setrId(Integer rId) {
     this.rId = rId;
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

    public LocalDate getReviewDate() {
     return reviewDate;
    }

    public void setReviewDate(LocalDate reviewDate) {
     this.reviewDate = reviewDate;
    }

    public Bookingentity getBooking() {
     return booking;
    }

    public void setBooking(Bookingentity booking) {
     this.booking = booking;
    }

    public Roomentity getRoom() {
     return room;
    }

    public void setRoom(Roomentity room) {
     this.room = room;
    }


    
}
