package com.unibuc.javaproject.service;

import com.unibuc.javaproject.exception.EntityNotFoundException;
import com.unibuc.javaproject.model.Organizer;
import com.unibuc.javaproject.repository.OrganizerRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OrganizerService {
    private OrganizerRepository organizerRepository;

    public OrganizerService(OrganizerRepository organizerRepository){
        this.organizerRepository = organizerRepository;
    }

    @PostConstruct
    public void setUp(){
        List<Organizer> organizers = new ArrayList<>();
        organizers.add(new Organizer("Primul organizator festivaluri", "parola1234", "org12334@yahoo.com"));
        organizers.add(new Organizer("Un organizator teatru", "parola9999", "blabla99@gmail.com"));
        organizerRepository.saveAll(organizers);
    }

    public Organizer createOrganizer(Organizer organizer){ return organizerRepository.save(organizer);}

    public Organizer getById(Long id){
        Optional<Organizer> organizerOptional = organizerRepository.findById(id);
        if(organizerOptional.isEmpty()){
            throw new EntityNotFoundException("Organizer", id);
        }
        return organizerOptional.get();
    }

    public List<Organizer> getAll(){ return organizerRepository.findAll();}
}
