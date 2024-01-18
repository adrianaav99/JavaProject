package com.unibuc.javaproject.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
    private String color;

    @ManyToMany
    @JoinTable(name = "categories_events",
                joinColumns = @JoinColumn(name = "category_id"),
                inverseJoinColumns = @JoinColumn(name = "event_id"))
    private List<Event> events;

    public Category() {
    }

    public Category(long id, String name, String description, String color, List<Event> events) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.color = color;
        this.events = events;
    }

    public Category(String name, String description, String color, List<Event> events) {
        this.name = name;
        this.description = description;
        this.color = color;
        this.events = events;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
}
