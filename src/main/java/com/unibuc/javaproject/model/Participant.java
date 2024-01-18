package com.unibuc.javaproject.model;

import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "participants")
public class Participant extends User{

    @OneToMany(mappedBy = "participant")
    private List<Ticket> tickets;

    @OneToMany(mappedBy = "participant")
    private List<Review> reviews;

    public Participant() {
    }

    public Participant(String username, String password, String email) {
        super(username, password, email);
    }
}
