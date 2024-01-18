package com.unibuc.javaproject.controller;

import com.unibuc.javaproject.dto.VenueRequest;
import com.unibuc.javaproject.mapper.VenueMapper;
import com.unibuc.javaproject.model.Venue;
import com.unibuc.javaproject.service.VenueService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@Validated
@RequestMapping("venues")
public class VenueController {
    private VenueService venueService;
    private VenueMapper venueMapper;
    public VenueController(VenueService venueService, VenueMapper venueMapper){
        this.venueService = venueService;
        this.venueMapper = venueMapper;
    }

    @PostMapping
    public ResponseEntity<Venue> createVenue(@Valid @RequestBody VenueRequest venueRequest){
        Venue venue = venueMapper.map(venueRequest);
        Venue createdVenue = venueService.createVenue(venue);
        return ResponseEntity
                .created(URI.create("/venues/" + createdVenue.getId()))
                .body(createdVenue);
    }
    @GetMapping()
    public List<Venue> getAll(){ return venueService.getAll();}

    @GetMapping("/id/{id}")
    public Venue getVenue(@PathVariable Long id) { return venueService.getById(id);}

    @GetMapping("/capacity")
    public List<Venue> getAllByCapacity(@RequestParam Integer capacity){ return venueService.getAllByCapacity(capacity);}
}
