package com.crud.events.service;

import com.crud.events.entity.Event;
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

    /**
     * Updates a participant by its id with values from the given participant.
     * @param id
     * @param updatedParticipant
     * @return an optional containing the updated participant or Optional.empty() if none found.
     */
    public Optional<Participant> updateParticipant(Long id, Participant updatedParticipant) {
        Optional<Participant> optionalParticipant = participantRepository.findById(id);

        if (optionalParticipant.isPresent()) {
            optionalParticipant.get().setName(updatedParticipant.getName());
            optionalParticipant.get().setEmail(updatedParticipant.getEmail());

            Participant savedParticipant = participantRepository.save(optionalParticipant.get());
            return Optional.of(savedParticipant);
        }

        return Optional.empty();
    }

    /**
     * Deletes a participant by its id.
     * @param id
     */
    public void deleteParticipantById(Long id) {
        participantRepository.deleteById(id);
    }
}
