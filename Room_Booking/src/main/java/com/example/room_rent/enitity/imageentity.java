package com.example.room_rent.enitity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;



@Entity
@Table(name="room_img")
public class imageentity {
    // @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    // // @SequenceGenerator(
    // //         name = "user_seq",
    // //         sequenceName = "user_sequence",
    // //         initialValue = 5,   // 👈 Start value
    // //         allocationSize = 1
    // // )
    // @Column(name = "img_id")
    // private Integer id;

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "img_id")
private int id;

    @Column(name = "img_url", nullable = false)
    private String imgUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id", nullable = false)
    private Roomentity room;


    public imageentity(int id, String imgUrl, Roomentity room) {
        this.id = id;
        this.imgUrl = imgUrl;
        this.room = room;
    }

    public imageentity() {

    }

    public int getId() {
        return id;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public Roomentity getRoom() {
        return room;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public void setRoom(Roomentity room) {
        this.room = room;
    }
}