package com.unibuc.javaproject.mapper;

import com.unibuc.javaproject.dto.EventRequest;
import com.unibuc.javaproject.model.Event;
import org.springframework.stereotype.Component;

@Component
public class EventMapper {

    public Event map(EventRequest eventRequest){
        Event event = new Event();
        event.setTitle(eventRequest.getTitle());
        event.setDescription(eventRequest.getDescription());
        event.setDateTime(eventRequest.getDateTime());
        event.setOrganizer(eventRequest.getOrganizer());
        event.setVenue(eventRequest.getVenue());
        return event;
    }
}
