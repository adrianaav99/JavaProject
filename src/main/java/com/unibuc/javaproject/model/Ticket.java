package com.unibuc.javaproject.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tickets")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private double price;
    private String category;

    //nu poti adauga ticket fara event
    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    //poti adauga ticket fara participant
    @ManyToOne
    @JoinColumn(name = "participant_id")
    private Participant participant;

    public Ticket() {
    }

    public Ticket(double price, String category) {
        this.price = price;
        this.category = category;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Participant getParticipant() {
        return participant;
    }

    public void setParticipant(Participant participant) {
        this.participant = participant;
    }
}
