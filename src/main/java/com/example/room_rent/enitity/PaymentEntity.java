package com.example.room_rent.enitity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "payment")
public class PaymentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(
        name = "user_seq",
        sequenceName = "user_sequence",
        initialValue = 5,   // 👈 Start value
        allocationSize = 1
    )
    private Integer p_id;

    // booking_id -> foreign key
    @ManyToOne
    @JoinColumn(name = "booking_id", nullable = false)
    private Bookingentity booking;

    @Column(name = "amount", precision = 10)
    private double amount;

    @Column(name = "payment_method")
    private String paymentMethod;

    @Column(name = "payment_status")
    private String paymentStatus;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date")
    private LocalDateTime date;


    // constructor
    public PaymentEntity(Bookingentity booking, double amount, String paymentMethod, String paymentStatus, LocalDateTime date){
        this.booking = booking;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = paymentStatus;
        this.date = date;
    }

    public PaymentEntity(){

    }

    public Integer getP_id() {
        return p_id;
    }

    public void setP_id(Integer p_id) {
        this.p_id = p_id;
    }

    public Bookingentity getBooking() {
        return booking;
    }

    public void setBooking(Bookingentity booking) {
        this.booking = booking;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
