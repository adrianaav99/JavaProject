package com.unibuc.javaproject.mapper;

import com.unibuc.javaproject.dto.TicketRequest;
import com.unibuc.javaproject.model.Ticket;
import org.springframework.stereotype.Component;

@Component
public class TicketMapper {
    public Ticket map(TicketRequest ticketRequest){
        Ticket ticket = new Ticket();
        ticket.setPrice(ticketRequest.getPrice());
        ticket.setCategory(ticketRequest.getCategory());
        ticket.setEvent(ticketRequest.getEvent());
        ticket.setParticipant(ticketRequest.getParticipant());
        return ticket;
    }
}
