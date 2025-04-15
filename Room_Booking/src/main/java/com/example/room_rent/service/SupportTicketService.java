package com.example.room_rent.service;

import com.example.room_rent.dtos.SupportTicketDto;
import com.example.room_rent.enitity.SupportTicketEntity;
import com.example.room_rent.enitity.Userentity;
import com.example.room_rent.repository.SupportTicketRepo;
import com.example.room_rent.repository.Userrepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SupportTicketService {

    @Autowired
    private SupportTicketRepo supportTicketRepo;

    @Autowired
    private Userrepo userrepo;

    public String createTicket(SupportTicketDto dto) {
        Optional<Userentity> userOpt = userrepo.findById(dto.getUserId());
        if (userOpt.isEmpty()) {
            return "User not found";
        }

        SupportTicketEntity ticket = new SupportTicketEntity();
        ticket.setUser(userOpt.get());
        ticket.setSubject(dto.getSubject());
        ticket.setIssueInDetail(dto.getIssueInDetail());
        ticket.setStatus(dto.getStatus());
        ticket.setDatetime(dto.getDatetime());

        supportTicketRepo.save(ticket);
        return "Ticket submitted successfully";
    }

    public List<SupportTicketDto> getAllTickets() {
        List<SupportTicketEntity> entities = supportTicketRepo.findAll();
        return entities.stream().map(ticket -> new SupportTicketDto(
            ticket.getTId(),
            ticket.getUser().getUserid(),
            ticket.getSubject(),
            ticket.getIssueInDetail(),
            ticket.getStatus(),
            ticket.getDatetime()
        )).collect(Collectors.toList());
    }
    public Optional<SupportTicketDto> getTicketById(Integer id) {
        return supportTicketRepo.findById(id).map(ticket -> new SupportTicketDto(
            ticket.getTId(),
            ticket.getUser().getUserid(),
            ticket.getSubject(),
            ticket.getIssueInDetail(),
            ticket.getStatus(),
            ticket.getDatetime()
        ));
    }
    
    // Delete ticket by ID
    public String deleteTicket(Integer id) {
        if (supportTicketRepo.existsById(id)) {
            supportTicketRepo.deleteById(id);
            return "Ticket deleted successfully";
        }
        return "Ticket not found";
    }
}
