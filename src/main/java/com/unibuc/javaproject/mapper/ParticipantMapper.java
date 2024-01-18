package com.unibuc.javaproject.mapper;

import com.unibuc.javaproject.dto.OrganizerRequest;
import com.unibuc.javaproject.dto.ParticipantRequest;
import com.unibuc.javaproject.model.Organizer;
import com.unibuc.javaproject.model.Participant;
import org.springframework.stereotype.Component;

@Component
public class ParticipantMapper {
    public Participant map(ParticipantRequest participantRequest){
        Participant participant = new Participant();
        participant.setUsername(participantRequest.getUsername());
        participant.setPassword(participantRequest.getPassword());
        participant.setEmail(participantRequest.getEmail());
        return participant;
    }
}
