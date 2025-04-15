package com.example.room_rent.dtos;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class SupportTicketDto {
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
