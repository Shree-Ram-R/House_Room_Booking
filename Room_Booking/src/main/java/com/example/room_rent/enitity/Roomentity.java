package com.example.room_rent.enitity;

import com.example.room_rent.dtos.Userdto;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "room")
public class Roomentity {
    @Id
    @Column(name = "room_id")
    private Integer roomid;
    @Column(name = "room_type")
    private String roomtype;
    private String location;
    private Float  price;
    @Column(name="is_ac")
    private Boolean isac;
    private String description;
    private Boolean availability;
    @Column(name = "max_occupancy")
    private Integer maxoccupancy;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "owner_id")
    // @JsonBackReference //to avoid infinite recursion(this matches to user and in user it again matches to room and goes on)
    private Userentity owner;
    public Integer getRoomid() {
        return roomid;
    }
    public void setRoomid(Integer roomid) {
        this.roomid = roomid;
    }
    public String getRoomtype() {
        return roomtype;
    }
    public void setRoomtype(String roomtype) {
        this.roomtype = roomtype;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public Float getPrice() {
        return price;
    }
    public void setPrice(Float price) {
        this.price = price;
    }
    public Boolean getIsac() {
        return isac;
    }
    public void setIsac(Boolean isac) {
        this.isac = isac;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Boolean getAvailability() {
        return availability;
    }
    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }
    public Integer getMaxoccupancy() {
        return maxoccupancy;
    }
    public void setMaxoccupancy(Integer maxoccupancy) {
        this.maxoccupancy = maxoccupancy;
    }
    public Userentity getOwner() {
        return owner;
    }
    public void setOwner(Userentity owner) {
        this.owner = owner;
    }
}
