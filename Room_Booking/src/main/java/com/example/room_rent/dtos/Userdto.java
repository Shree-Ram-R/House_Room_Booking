package com.example.room_rent.dtos;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

public class Userdto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(
        name = "user_seq",
        sequenceName = "user_sequence",
        initialValue = 5,   // 👈 Start value
        allocationSize = 1
    )
    private Integer user_id;
    private String name;
    private String phone;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String username;
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    private String password;
    private List<Roomdto> rooms;
    private List<SupportTicketDto> tickets;
    private List<BookingResponseDto> booking;
    public List<BookingResponseDto> getBooking() {
        return booking;
    }
    public void setBooking(List<BookingResponseDto> booking) {
        this.booking = booking;
    }
    public List<SupportTicketDto> getTickets() {
        return tickets;
    }
    public void setTickets(List<SupportTicketDto> tickets) {
        this.tickets = tickets;
    }
    public Userdto() {}
    public Userdto(String username,String pass) {
        this.username = username;
        this.password=pass;

    }
    public Userdto(Integer userid, String name, String phone, String email, String password) {
        this.user_id = userid;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.password = password;
    }
    
    public Userdto(Integer userid, String name, String phone, String email,String username,String pass) {
        this.user_id = userid;
        this.username=username;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.password=pass;
    }
    public Userdto(Integer userid, String name, String phone, String email,String pass,List<Roomdto> rooms) {
        this.user_id = userid;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.password=pass;
        this.rooms=rooms;
    }
    public Userdto(Integer userid, String name, String phone, String email,String pass,List<Roomdto> rooms,List<SupportTicketDto> ticket) {
        this.user_id = userid;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.password=pass;
        this.rooms=rooms;
        this.tickets=ticket;
    }
    
    public Userdto(Integer user_id, String name, String phone, String email, String password, List<Roomdto> rooms,
            List<SupportTicketDto> tickets, List<BookingResponseDto> booking) {
        this.user_id = user_id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.rooms = rooms;
        this.tickets = tickets;
        this.booking = booking;
    }
    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public List<Roomdto> getRooms() {
        return rooms;
    }

    public void setRooms(List<Roomdto> rooms) {
        this.rooms = rooms;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

}
