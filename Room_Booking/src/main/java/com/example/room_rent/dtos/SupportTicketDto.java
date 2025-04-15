package com.example.room_rent.dtos;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class SupportTicketDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "t_id")
    private Integer tId;
    private Integer userId; // User reference
    private String subject;
    private String issueInDetail;
    private String status;
    private LocalDateTime datetime;

    public SupportTicketDto() {}

    public SupportTicketDto(Integer tId, Integer userId, String subject, String issueInDetail, String status, LocalDateTime datetime) {
        this.tId = tId;
        this.userId = userId;
        this.subject = subject;
        this.issueInDetail = issueInDetail;
        this.status = status;
        this.datetime = datetime;
    }

    // Getters and Setters
    // ...
}
