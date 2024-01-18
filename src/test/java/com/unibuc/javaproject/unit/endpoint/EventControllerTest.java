package com.unibuc.javaproject.unit.endpoint;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.unibuc.javaproject.controller.EventController;
import com.unibuc.javaproject.dto.EventRequest;
import com.unibuc.javaproject.mapper.EventMapper;
import com.unibuc.javaproject.model.Event;
import com.unibuc.javaproject.service.EventService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

public class EventControllerTest {
    private MockMvc mockMvc;
    @InjectMocks
    private EventController eventController;

    @Mock
    private EventService eventService;

    @Mock
    private EventMapper eventMapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(eventController).build();
    }

    @Test
    void testGetEvent_Success(){
        Event event = getDummyEvent();
        event.setId(1l);
        when(eventService.getById(1L)).thenReturn(event);
        Event result = eventController.getEvent(1L);
        assertNotNull(result);
        assertEquals(event.getId(), result.getId());
        assertEquals(event.getTitle(), result.getTitle());
        assertEquals(event.getDescription(), result.getDescription());
        assertEquals(event.getDateTime(), result.getDateTime());
    }

//    @Test
//    public void testSave_Success() throws Exception {
//        EventRequest eventRequest = getDummyEventRequest();
//        Event eventToSave = getDummyEvent();
//        Event savedEvent = getDummyEvent();
//        savedEvent.setId(1L);
//
//        Mockito.when(eventMapper.map(eventRequest)).thenReturn(eventToSave);
//        Mockito.when(eventService.createEvent(eventToSave)).thenReturn(savedEvent);
//
//        mockMvc.perform(MockMvcRequestBuilders
//                .post("/events")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(new ObjectMapper().writeValueAsString(eventRequest)))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content().json(new ObjectMapper().writeValueAsString(savedEvent)));
//    }

    private EventRequest getDummyEventRequest(){
        EventRequest eventRequest = new EventRequest();
        eventRequest.setTitle("Concert Irina Rimes");
        eventRequest.setDescription("Concert cu scop caritabil ...");
        //eventRequest.setDateTime(LocalDateTime.parse("2024-05-24T19:30"));
        return eventRequest;
    }

    private Event getDummyEvent(){
        Event event = new Event();
        event.setTitle("Concert Irina Rimes");
        event.setDescription("Concert cu scop caritabil ...");
        //event.setDateTime(LocalDateTime.parse("2024-05-24T19:30"));
        return event;
    }
}
