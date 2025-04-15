package com.example.room_rent.enitity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "supportticket")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SupportTicketEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tId;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private Userentity user;

    private String subject;

    @Column(name = "issue_in_detail", columnDefinition = "TEXT")
    private String issueInDetail;

    private String status;

    private LocalDateTime datetime;
}
