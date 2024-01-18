package com.unibuc.javaproject.service;

import com.unibuc.javaproject.exception.EntityNotFoundException;
import com.unibuc.javaproject.model.Venue;
import com.unibuc.javaproject.repository.VenueRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class VenueService {
    private VenueRepository venueRepository;
    public VenueService(VenueRepository venueRepository){
        this.venueRepository = venueRepository;
    }

    @PostConstruct
    private void setUp(){
        List<Venue> venues = new ArrayList<>();
        venues.add(new Venue("Beraria H", "str. ..., nr. ...", 350));
        venues.add(new Venue("Teatrul de National - sala 1", "str. ..., nr. ...", 500));
        venueRepository.saveAll(venues);
    }

    public Venue createVenue(Venue venue){
        return venueRepository.save(venue);
    }
    public Venue getById(Long id){
        Optional<Venue> venueOptional = venueRepository.findById(id);
        if(venueOptional.isEmpty()){
            throw new EntityNotFoundException("Venue", id);
        }
        return venueOptional.get();
    }

    public List<Venue> getAll(){ return venueRepository.findAll();}

    public List<Venue> getAllByCapacity(Integer capacity){ return venueRepository.findVenuesWithCapacity(capacity);}
}
