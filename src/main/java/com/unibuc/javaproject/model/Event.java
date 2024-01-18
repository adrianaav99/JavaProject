package com.unibuc.javaproject.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;
    private String description;

    //in postgresql timestamp without time zone
    @Column(name = "date_time")
    private LocalDateTime dateTime;

    //bidirectional ManyToOne with Venue
    //direct side of the relationship -> FK
    @ManyToOne
    @JoinColumn(name = "venue_id")
    private Venue venue;

    @ManyToOne
    @JoinColumn(name = "organizer_id")
    private Organizer organizer;

    @OneToMany(mappedBy = "event")
    private List<Ticket> tickets;

    @OneToMany(mappedBy = "event")
    private List<Review> reviews;

    @ManyToMany(mappedBy = "events")
    private List<Category> categories;
    public Event() {
    }

    public Event(long id, String title, String description, LocalDateTime dateTime) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.dateTime = dateTime;
    }

    public Event(String title, String description, LocalDateTime dateTime) {
        this.title = title;
        this.description = description;
        this.dateTime = dateTime;
    }

    public long getId() {return id;}

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public Organizer getOrganizer() {
        return organizer;
    }

    public void setOrganizer(Organizer organizer) {
        this.organizer = organizer;
    }
}
