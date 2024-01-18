package com.unibuc.javaproject.dto;

import com.unibuc.javaproject.model.Event;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class CategoryRequest {
    @NotNull
    @NotBlank(message = "Title cannot be null.")
    private String name;
    @NotNull
    private String description;
    private String color;
    private List<Event> events;

    public CategoryRequest() {
    }

    public CategoryRequest(String name, String description, String color, List<Event> events) {
        this.name = name;
        this.description = description;
        this.color = color;
        this.events = events;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getColor() {
        return color;
    }

    public List<Event> getEvents() {
        return events;
    }
}
