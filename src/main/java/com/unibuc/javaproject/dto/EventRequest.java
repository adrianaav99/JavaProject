package com.unibuc.javaproject.dto;

import com.unibuc.javaproject.model.Organizer;
import com.unibuc.javaproject.model.Venue;
import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

public class EventRequest {
    @NotNull
    @NotBlank(message = "Title cannot be null.")
    private String title;
    @NotNull
    private String description;
    @NotNull
    private LocalDateTime dateTime;
    private Venue venue;
    private Organizer organizer;

    public EventRequest() {

    }

    public EventRequest(String title, String description, LocalDateTime dateTime, Organizer organizer, Venue venue) {
        this.title = title;
        this.description = description;
        this.dateTime = dateTime;
        this.organizer = organizer;
        this.venue = venue;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public Venue getVenue() {
        return venue;
    }

    public Organizer getOrganizer() {
        return organizer;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public void setOrganizer(Organizer organizer) {
        this.organizer = organizer;
    }
}
