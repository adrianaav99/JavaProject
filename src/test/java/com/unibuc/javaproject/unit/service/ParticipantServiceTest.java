package com.unibuc.javaproject.unit.service;

import com.unibuc.javaproject.exception.EntityNotFoundException;
import com.unibuc.javaproject.model.Participant;
import com.unibuc.javaproject.repository.ParticipantRepository;
import com.unibuc.javaproject.service.ParticipantService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ParticipantServiceTest {
    @InjectMocks
    ParticipantService participantService;

    @Mock
    ParticipantRepository participantRepository;

    @Test
    void whenParticipantExists_getById_returnsTheEvent(){
        Participant participant = new Participant();
        participant.setId(1L);
        when(participantRepository.findById(1L)).thenReturn(Optional.of(participant));
        Participant result = participantService.getById(1L);
        assertNotNull(result);
        assertEquals(participant.getId(), result.getId());
    }

    @Test
    void whenParticipantDoesntExist_getById_throwsEntityNotFoundException(){
        when(participantRepository.findById(1L)).thenReturn(Optional.empty());
        EntityNotFoundException exception = assertThrows(EntityNotFoundException.class, ()->
                participantService.getById(1L));
        assertEquals("Participant with id 1 doesn't exist.", exception.getMessage());
    }
}
