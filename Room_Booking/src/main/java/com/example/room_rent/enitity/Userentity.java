package com.example.room_rent.enitity;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

// @JsonIdentityInfo(
//   generator = ObjectIdGenerators.PropertyGenerator.class,
//   property = "userid")
@Entity
@Table(name="USER")
public class Userentity {
        @Id
        @Column(name = "user_id")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer userid;
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
        @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true)
        // @JsonManagedReference   //to avoid infinite recursion(this matches to room and in room it again matches to user and goes on)
        private List<Roomentity> rooms;
        @OneToMany(mappedBy = "user",cascade = CascadeType.ALL,orphanRemoval = true)
        private List<SupportTicketEntity> tickets;
        @OneToMany(mappedBy = "user",cascade = CascadeType.ALL,orphanRemoval = true)
        private List<Bookingentity> bookings;
        public List<Bookingentity> getBookings() {
            return bookings;
        }
        public void setBookings(List<Bookingentity> bookings) {
            this.bookings = bookings;
        }
        public List<SupportTicketEntity> getTickets() {
            return tickets;
        }
        public void setTickets(List<SupportTicketEntity> tickets) {
            this.tickets = tickets;
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
        public Integer getUserid() {
            return userid;
        }
        public void setUserid(Integer userid) {
            this.userid = userid;
        }
        public List<Roomentity> getRooms() {
            return rooms;
        }
        public void setRooms(List<Roomentity> rooms) {
            this.rooms = rooms;
        }

}