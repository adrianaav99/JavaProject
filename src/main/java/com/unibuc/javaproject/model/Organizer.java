package com.unibuc.javaproject.model;

import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "organizers")
public class Organizer extends User {

    @OneToMany(mappedBy = "organizer")
    private List<Event> events;

    public Organizer() {
    }

    public Organizer(String username, String password, String email) {
        super(username, password, email);
    }

    public Organizer(String username, String password, String email, List<Event> events) {
        super(username, password, email);
        this.events = events;
    }

}
