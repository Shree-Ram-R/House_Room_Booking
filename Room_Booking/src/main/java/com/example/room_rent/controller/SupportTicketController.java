package com.example.room_rent.controller;
import com.example.room_rent.dtos.SupportTicketDto;
import com.example.room_rent.service.SupportTicketService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/support")
public class SupportTicketController {

    @Autowired
    private SupportTicketService supportService;

    @PostMapping("/create")
    public String createTicket(@RequestBody SupportTicketDto dto) {
        return supportService.createTicket(dto);
    }

    @GetMapping("/alltickets")
    public List<SupportTicketDto> getAllTickets() {
        return supportService.getAllTickets();
    }
    @GetMapping("/ticket/{id}")
public Optional<SupportTicketDto> getTicketById(@PathVariable Integer id) {
    return supportService.getTicketById(id);
        // .map(ResponseEntity::ok)
        // .orElse(ResponseEntity.notFound().build());
}

// Delete ticket by ID
@DeleteMapping("/ticket/delete/{id}")
public String deleteTicket(@PathVariable Integer id) {
    return supportService.deleteTicket(id);
}
}
