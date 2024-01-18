package com.unibuc.javaproject.controller;

import com.unibuc.javaproject.dto.OrganizerRequest;
import com.unibuc.javaproject.mapper.OrganizerMapper;
import com.unibuc.javaproject.model.Organizer;
import com.unibuc.javaproject.service.OrganizerService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.*;
@RestController
@Validated
@RequestMapping("organizers")
public class OrganizerController {
    private OrganizerService organizerService;
    private OrganizerMapper organizerMapper;
    public OrganizerController(OrganizerService organizerService, OrganizerMapper organizerMapper){
        this.organizerService = organizerService;
        this.organizerMapper = organizerMapper;
    }

    @PostMapping
    public ResponseEntity<Organizer> createOrganizer(@Valid @RequestBody OrganizerRequest organizerRequest){
        Organizer organizer = organizerMapper.map(organizerRequest);
        Organizer createdOrganizer = organizerService.createOrganizer(organizer);
        return ResponseEntity
                .created(URI.create("/organizers/" + createdOrganizer.getId()))
                .body(createdOrganizer);
    }

    @GetMapping
    public List<Organizer> getAll(){ return organizerService.getAll();}

    @GetMapping("/id/{id}")
    public Organizer getOrganizer(@PathVariable Long id){ return organizerService.getById(id);}


}
