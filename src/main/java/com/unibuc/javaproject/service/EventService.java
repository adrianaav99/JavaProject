package com.unibuc.javaproject.service;

import com.unibuc.javaproject.exception.EntityNotFoundException;
import com.unibuc.javaproject.model.Event;
import com.unibuc.javaproject.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EventService {
    private EventRepository eventRepository;

    public EventService(EventRepository eventRepository){
        this.eventRepository = eventRepository;
    }

    public Event createEvent(Event event){
        return eventRepository.save(event);
    }

    public Event getById(Long id) {
        Optional<Event> eventOptional = eventRepository.findById(id);
        if(eventOptional.isEmpty()) {
            throw new EntityNotFoundException("Event", id);
        }
        return eventOptional.get();
    }

    public List<Event> getAll(){return eventRepository.findAll();}

    public List<Event> getAllByTitle(String title) {
        return eventRepository.findAllByTitle(title);
    }
    public List<Event> getAllByOrganizerId(Long id){
        return eventRepository.findAllByOrganizer_Id(id);
    }
}
