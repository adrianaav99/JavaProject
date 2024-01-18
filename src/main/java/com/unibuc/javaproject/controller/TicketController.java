package com.unibuc.javaproject.controller;

import com.unibuc.javaproject.dto.TicketRequest;
import com.unibuc.javaproject.mapper.TicketMapper;
import com.unibuc.javaproject.model.Event;
import com.unibuc.javaproject.model.Ticket;
import com.unibuc.javaproject.service.TicketService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@Validated
@RequestMapping("tickets")
public class TicketController {
    private TicketService ticketService;
    private TicketMapper ticketMapper;

    public TicketController(TicketService ticketService, TicketMapper ticketMapper){
        this.ticketService = ticketService;
        this.ticketMapper = ticketMapper;
    }

    @PostMapping
    public ResponseEntity<Ticket> createTicket(@Valid @RequestBody TicketRequest ticketRequest){
        Ticket ticket = ticketMapper.map(ticketRequest);
        Ticket createdTicket = ticketService.createTicket(ticket);
        return ResponseEntity
                .created(URI.create("/tickets/" + createdTicket.getId()))
                .body(createdTicket);
    }
    @GetMapping()
    public List<Ticket> getAll(){return ticketService.getAll();}

    @GetMapping("/id/{id}")
    public Ticket getTicket(@PathVariable Long id) {
        return ticketService.getById(id);
    }

    @GetMapping("/event/available")
    public List<Ticket> getAllAvailableAtEvent(@RequestBody Event event){ return ticketService.getAllAvailableAtEvent(event);}
}
