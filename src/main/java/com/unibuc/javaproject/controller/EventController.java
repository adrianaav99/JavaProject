package com.unibuc.javaproject.controller;


import com.unibuc.javaproject.dto.EventRequest;
import com.unibuc.javaproject.mapper.EventMapper;
import com.unibuc.javaproject.model.Event;
import com.unibuc.javaproject.service.EventService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.*;

@RestController
@Validated
@RequestMapping("/events")
@Tag(name = "Event", description = "the Event Api")
public class EventController {

    private EventService eventService;
    private EventMapper eventMapper;
    public EventController(EventService eventService, EventMapper eventMapper){
        this.eventService = eventService;
        this.eventMapper = eventMapper;
    }

    @PostMapping
    @Operation(summary = "Creates a new Event based on the information received in the request")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "The Event was successfully created based on the received request"),
            @ApiResponse(responseCode = "400", description = "Validation error on the received request")
    })
    public ResponseEntity<Event> createEvent(
            @Valid @RequestBody
            @Parameter(name = "event", description = "Event details", required = true)
            EventRequest eventRequest){
        Event event = eventMapper.map(eventRequest);
        Event createdEvent = eventService.createEvent(event);
        return ResponseEntity
                .created(URI.create("/events/" + createdEvent.getId()))
                .body(createdEvent);
    }

    @GetMapping()
    @Operation(summary = "Returns all Events")
    public List<Event> getAll(){return eventService.getAll();}

    @GetMapping("/id/{id}")
    @Operation(summary = "Returns the Event with the specified id")
    public Event getEvent(@PathVariable @Parameter Long id) {
        return eventService.getById(id);
    }

    @GetMapping("/title")
    @Operation(summary = "Returns the Event with the specified title")
    public List<Event> getAllByTitle(@RequestParam @Parameter String title) {
        return eventService.getAllByTitle(title);
    }

    @GetMapping("/organizer")
    @Operation(summary = "Returns the Event with the specified organizer")
    public List<Event> getAllByOrganizer(@RequestParam @Parameter Long id){ return  eventService.getAllByOrganizerId(id); }

}
