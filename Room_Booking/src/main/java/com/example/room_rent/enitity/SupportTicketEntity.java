package com.example.room_rent.enitity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "supportticket")
public class SupportTicketEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "t_id")
    private Integer tId;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private Userentity user;
    private String subject;
    @Column(name = "issue_in_detail", columnDefinition = "TEXT")
    private String issueInDetail;
    private String status;
    private LocalDateTime datetime;

    public Integer gettId() {
        return tId;
    }

    public void settId(Integer tId) {
        this.tId = tId;
    }

    public Userentity getUser() {
        return user;
    }

    public void setUser(Userentity user) {
        this.user = user;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getIssueInDetail() {
        return issueInDetail;
    }

    public void setIssueInDetail(String issueInDetail) {
        this.issueInDetail = issueInDetail;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getDatetime() {
        return datetime;
    }

    public void setDatetime(LocalDateTime datetime) {
        this.datetime = datetime;
    }
    
}
