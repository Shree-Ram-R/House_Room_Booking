package com.example.room_rent.dtos;

import java.util.List;

import com.example.room_rent.enitity.imageentity;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

public class Roomdto{
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

    private Userdto owner;

    private Integer oid;

    private List<Userdto> renteduser;
    private List<ImageUploadDTO> images;

    public Integer getOid() {
        return oid;
    }
    public void setOid(Integer oid) {
        this.oid = oid;
    }
    
    public Roomdto(Integer roomid, String roomtype, String location, Float price, Boolean isac, String description,
            Boolean availability, Integer maxoccupancy, Userdto owner, List<Userdto> renteduser,
            List<ImageUploadDTO> images) {
        this.roomid = roomid;
        this.roomtype = roomtype;
        this.location = location;
        this.price = price;
        this.isac = isac;
        this.description = description;
        this.availability = availability;
        this.maxoccupancy = maxoccupancy;
        this.owner = owner;
        this.renteduser = renteduser;
        this.images = images;
    }
    public Roomdto(Integer roomid, String roomtype, String location, Float price, Boolean isac, String description,
            Boolean availability, Integer maxoccupancy, Userdto owner, List<Userdto> renteduser) {
        this.roomid = roomid;
        this.roomtype = roomtype;
        this.location = location;
        this.price = price;
        this.isac = isac;
        this.description = description;
        this.availability = availability;
        this.maxoccupancy = maxoccupancy;
        this.owner = owner;
        this.renteduser = renteduser;
    }
    public Roomdto(){};
    public Roomdto(Integer roomid, String roomtype, String location, Float price, Boolean isac,
                   String description, Boolean availability, Integer maxoccupancy, Userdto owner) {
        this.roomid = roomid;
        this.roomtype = roomtype;
        this.location = location;
        this.price = price;
        this.isac = isac;
        this.description = description;
        this.availability = availability;
        this.maxoccupancy = maxoccupancy;
        this.owner = owner;
    }
    public Roomdto(Integer roomid, String roomtype, String location, Float price, Boolean isac,
                   String description, Boolean availability, Integer maxoccupancy) {
        this.roomid = roomid;
        this.roomtype = roomtype;
        this.location = location;
        this.price = price;
        this.isac = isac;
        this.description = description;
        this.availability = availability;
        this.maxoccupancy = maxoccupancy;
    }
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
    public Userdto getOwner() {
        return owner;
    }
    public void setOwner(Userdto owner) {
        this.owner = owner;
    }
    public List<Userdto> getRenteduser() {
        return renteduser;
    }
    public void setRenteduser(List<Userdto> renteduser) {
        this.renteduser = renteduser;
    }
    public List<ImageUploadDTO> getImages() {
        return images;
    }
    public void setImages(List<ImageUploadDTO> images) {
        this.images = images;
    }
}