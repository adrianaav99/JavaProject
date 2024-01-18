package com.unibuc.javaproject.unit.service;

import com.unibuc.javaproject.exception.EntityNotFoundException;
import com.unibuc.javaproject.model.Event;
import com.unibuc.javaproject.repository.EventRepository;
import com.unibuc.javaproject.service.EventService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EventServiceTest {

    @InjectMocks
    EventService eventService;

    @Mock
    EventRepository eventRepository;


    @Test
    void whenEventExists_getById_returnsTheEvent(){
        //Arrange
        Event event = new Event();
        event.setId(1);
        when(eventRepository.findById(1L)).thenReturn(Optional.of(event));
        //Act
        Event result = eventService.getById(1L);
        //Assert
        assertNotNull(result);
        assertEquals(event.getId(), result.getId());
    }

    @Test
    void whenEventDoesntExist_getById_throwsEntityNotFoundException(){
        when(eventRepository.findById(1L)).thenReturn(Optional.empty());
        EntityNotFoundException exception  = assertThrows(EntityNotFoundException.class, () ->
                eventService.getById(1L));
        assertEquals("Event with id 1 doesn't exist.", exception.getMessage());
    }

}
