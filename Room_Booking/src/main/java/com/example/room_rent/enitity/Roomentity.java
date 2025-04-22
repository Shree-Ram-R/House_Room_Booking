package com.example.room_rent.enitity;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "room")
public class Roomentity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_id")
    private Integer roomid;

    @Column(name = "room_type")
    private String roomtype;
    private String location;
    private Float price;
    @Column(name="is_ac")
    private Boolean isac;
    private String description;
    private Boolean availability;
    @Column(name = "max_occupancy")
    private Integer maxoccupancy;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinColumn(name = "owner_id")
    private Userentity owner;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<imageentity> images = new ArrayList<>();

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

    public List<imageentity> getImages() {
        return images;
    }

    public void setImages(List<imageentity> images) {
        this.images = images;
    }
}