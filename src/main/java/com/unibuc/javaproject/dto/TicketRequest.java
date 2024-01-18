package com.unibuc.javaproject.dto;

import com.unibuc.javaproject.model.Event;
import com.unibuc.javaproject.model.Participant;
import jakarta.validation.constraints.*;

public class TicketRequest {
    @NotNull(message = "Price cannot be null.")
    @Min(value = 0, message = "Price cannot be negative.")
    private double price;
    private String category;
    private Event event;
    private Participant participant;
    public TicketRequest() {
    }

    public TicketRequest(double price, String category, Event event, Participant participant) {
        this.price = price;
        this.category = category;
        this.event = event;
        this.participant = participant;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public Event getEvent() {
        return event;
    }

    public Participant getParticipant() {return participant;}
}
