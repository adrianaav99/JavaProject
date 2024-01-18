package com.unibuc.javaproject.unit.service;

import com.unibuc.javaproject.exception.EntityNotFoundException;
import com.unibuc.javaproject.model.Organizer;
import com.unibuc.javaproject.repository.OrganizerRepository;
import com.unibuc.javaproject.service.OrganizerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class OrganizerServiceTest {
    @InjectMocks
    OrganizerService organizerService;
    @Mock
    OrganizerRepository organizerRepository;

    @Test
    void whenOrganizerExists_getById_returnsTheOrganizer(){
        Organizer organizer = new Organizer();
        organizer.setId(1L);
        when(organizerRepository.findById(1L)).thenReturn(Optional.of(organizer));
        Organizer result = organizerService.getById(1L);
        assertNotNull(result);
        assertEquals(organizer.getId(), result.getId());
    }

    @Test
    void whenOrganizerDoesntExist_getById_throwsEntityNotFoundException(){
        when(organizerRepository.findById(1L)).thenReturn(Optional.empty());
        EntityNotFoundException exception = assertThrows(EntityNotFoundException.class, ()->
                organizerService.getById(1L));
        assertEquals("Organizer with id 1 doesn't exist.", exception.getMessage());
    }
}
