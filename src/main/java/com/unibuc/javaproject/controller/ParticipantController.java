package com.unibuc.javaproject.controller;

import com.unibuc.javaproject.dto.OrganizerRequest;
import com.unibuc.javaproject.dto.ParticipantRequest;
import com.unibuc.javaproject.mapper.ParticipantMapper;
import com.unibuc.javaproject.model.Organizer;
import com.unibuc.javaproject.model.Participant;
import com.unibuc.javaproject.service.ParticipantService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.*;

@RestController
@Validated
@RequestMapping("participants")
public class ParticipantController {
    private ParticipantService participantService;
    private ParticipantMapper participantMapper;

    public ParticipantController(ParticipantService participantService, ParticipantMapper participantMapper) {
        this.participantService = participantService;
        this.participantMapper = participantMapper;
    }

    @PostMapping
    public ResponseEntity<Participant> createParticipant(@Valid @RequestBody ParticipantRequest participantRequest) {
        Participant participant = participantMapper.map(participantRequest);
        Participant createdParticipant = participantService.createParticipant(participant);
        return ResponseEntity
                .created(URI.create("/participants/" + createdParticipant.getId()))
                .body(createdParticipant);
    }

    @GetMapping
    public List<Participant> getAll(){ return  participantService.getAll();}

    @GetMapping("/id/{id}")
    public Participant getParticipant(@PathVariable Long id){ return participantService.getById(id);}
}