package com.unibuc.javaproject.dto;

import com.unibuc.javaproject.model.Event;
import com.unibuc.javaproject.model.Participant;
import jakarta.validation.constraints.*;

public class ReviewRequest {
    @NotNull(message = "Rating cannot be null.")
    @Min(value = 0, message = "Rating connot be negative.")
    @Max(value = 10, message = "Maximum rating is 10.")
    private float rating;
    private String comment;
    private Participant participant;
    private Event event;

    public ReviewRequest() {
    }

    public ReviewRequest(float rating, String comment, Participant participant, Event event) {
        this.rating = rating;
        this.comment = comment;
        this.participant = participant;
        this.event = event;
    }

    public float getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }

    public Participant getParticipant() {
        return participant;
    }

    public Event getEvent() {
        return event;
    }
}
