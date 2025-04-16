package com.example.room_rent.dtos;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class SupportTicketDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "t_id")
    private Integer tId;
    private Integer uid;
    private Userdto userdetails; // User reference
    private String subject;
    private String issueInDetail;
    private String status;
    private LocalDateTime datetime;

    public SupportTicketDto() {}

    public SupportTicketDto(Integer tId, String subject, String issueInDetail, String status, LocalDateTime datetime) {
        this.tId = tId;
        this.subject = subject;
        this.issueInDetail = issueInDetail;
        this.status = status;
        this.datetime = datetime;
    }
    public SupportTicketDto(Integer tId,Userdto userdetails, String subject, String issueInDetail, String status, LocalDateTime datetime) {
        this.tId = tId;
        this.userdetails = userdetails;
        this.subject = subject;
        this.issueInDetail = issueInDetail;
        this.status = status;
        this.datetime = datetime;
    }

    public Userdto getUserdetails() {
        return userdetails;
    }

    public void setUserdetails(Userdto userdetails) {
        this.userdetails = userdetails;
    }

    public Integer gettId() {
        return tId;
    }

    public void settId(Integer tId) {
        this.tId = tId;
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

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }
    
}
