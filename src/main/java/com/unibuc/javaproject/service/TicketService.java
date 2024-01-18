package com.unibuc.javaproject.service;

import com.unibuc.javaproject.exception.EntityNotFoundException;
import com.unibuc.javaproject.exception.NotFoundException;
import com.unibuc.javaproject.model.Event;
import com.unibuc.javaproject.model.Ticket;
import com.unibuc.javaproject.repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TicketService {
    public TicketRepository ticketRepository;
    public TicketService(TicketRepository ticketRepository){
        this.ticketRepository = ticketRepository;
    }

    public Ticket createTicket(Ticket ticket){ return ticketRepository.save(ticket);}

    public Ticket getById(Long id){
        Optional<Ticket> ticketOptional = ticketRepository.findById(id);
        if(ticketOptional.isEmpty()){
            throw new EntityNotFoundException("Ticket", id);
        }
        return ticketOptional.get();
    }

    public List<Ticket> getAll(){ return ticketRepository.findAll();}

    public List<Ticket> getAllAvailableAtEvent(Event event){
        //i-am dat event care exista?
        List<Ticket> tickets = ticketRepository.findAll();
        List<Ticket> availableTickets = tickets.stream()
                .filter(ticket -> ticket.getEvent().getId() == event.getId()
                        && ticket.getParticipant() == null)
                .toList();
        if(availableTickets.isEmpty())
            throw new NotFoundException("Tickets unavailable at Event with id " + event.getId());
        return availableTickets;
    }
}
