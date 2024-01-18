package com.unibuc.javaproject.mapper;

import com.unibuc.javaproject.dto.EventRequest;
import com.unibuc.javaproject.dto.OrganizerRequest;
import com.unibuc.javaproject.model.Event;
import com.unibuc.javaproject.model.Organizer;
import org.springframework.stereotype.Component;

@Component
public class OrganizerMapper {

    public Organizer map(OrganizerRequest organizerRequest){
        Organizer organizer = new Organizer();
        organizer.setUsername(organizerRequest.getUsername());
        organizer.setPassword(organizerRequest.getPassword());
        organizer.setEmail(organizerRequest.getEmail());
        return organizer;
    }
}
