package com.crud.events.service;

import com.crud.events.entity.Participant;
import com.crud.events.repository.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParticipantService {

    @Autowired
    private ParticipantRepository participantRepository;

    /**
     * Selects all participants.
     * @return a list of participants.
     */
    public List<Participant> findAllParticipants() {
        return participantRepository.findAll();
    }

    /**
     * Returns a participant by its id.
     * @param id
     * @return an optional containing the participant with the given id or Optional.empty() if none found.
     */
    public Optional<Participant> findParticipantById(Long id) {
        return participantRepository.findById(id);
    }

    /**
     * Saves a given participant.
     * @param participant
     * @return the saved participant.
     */
    public Participant saveParticipant(Participant participant) {
        return participantRepository.save(participant);
    }
}
