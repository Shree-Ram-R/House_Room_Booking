package com.example.room_rent.service;

import com.example.room_rent.dtos.SupportTicketDto;
import com.example.room_rent.dtos.Userdto;
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
        Optional<Userentity> userOpt = userrepo.findById(dto.getUid());
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
        return entities.stream().map(ticket ->{
        Userentity user=ticket.getUser();
        Userdto details=new Userdto(user.getUserid(),user.getName(),user.getPhone(),user.getEmail(),user.getPassword());
        return new SupportTicketDto(
            ticket.gettId(),details,
            ticket.getSubject(),
            ticket.getIssueInDetail(),
            ticket.getStatus(),
            ticket.getDatetime());
        }).collect(Collectors.toList());
    }
    
    public SupportTicketDto getTicketById(Integer id) {
        Optional<SupportTicketEntity> ticket=supportTicketRepo.findById(id);
        if(ticket.isPresent())
        {
            SupportTicketEntity uticket =ticket.get();
            Userentity user=uticket.getUser();
            Userdto udto=new Userdto(user.getUserid(),user.getName(),user.getPhone(),user.getEmail(),user.getPassword());
            return new SupportTicketDto(
            uticket.gettId(),udto,
            uticket.getSubject(),
            uticket.getIssueInDetail(),
            uticket.getStatus(),
            uticket.getDatetime());
        }
        return null;
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
