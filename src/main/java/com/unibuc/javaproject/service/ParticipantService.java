package com.unibuc.javaproject.service;

import com.unibuc.javaproject.exception.EntityNotFoundException;
import com.unibuc.javaproject.model.Participant;
import com.unibuc.javaproject.repository.ParticipantRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ParticipantService {
    private ParticipantRepository participantRepository;

    public ParticipantService(ParticipantRepository participantRepository){
        this.participantRepository = participantRepository;
    }

    @PostConstruct
    private void setUp(){
        List<Participant> participants = new ArrayList<>();
        participants.add(new Participant("Ion Popescu", "parola1234", "popescuion2334@yahoo.com"));
        participants.add(new Participant("Adriana Vladone", "parola9999", "adriana.valdone99@gmail.com"));
        participantRepository.saveAll(participants);
    }

    public Participant createParticipant(Participant participant){ return participantRepository.save(participant);}

    public Participant getById(Long id){
        Optional<Participant> participantOptional = participantRepository.findById(id);
        if(participantOptional.isEmpty()){
            throw new EntityNotFoundException("Participant", id);
        }
        return participantOptional.get();
    }

    public List<Participant> getAll() { return participantRepository.findAll();}
}
