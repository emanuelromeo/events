package com.crud.events.controller;

import com.crud.events.entity.Event;
import com.crud.events.entity.Participant;
import com.crud.events.service.ParticipantService;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/participants")
public class ParticipantController {

    @Autowired
    private ParticipantService participantService;

    /**
     * Selects all participants.
     * @return a response entity containing a list of participants.
     */
    @GetMapping("/select-all")
    public ResponseEntity<List<Participant>> findAllParticipants() {
        List<Participant> participants = participantService.findAllParticipants();
        return ResponseEntity.ok(participants);
    }

    /**
     * Returns a participant by its id.
     * @param id
     * @return a response entity containing the participant with the given id or ResponseEntity.notFound() if none found.
     */
    @GetMapping("/select-by-id/{id}")
    public ResponseEntity<Participant> findParticipantById(@PathVariable Long id) {
        Optional<Participant> participantOptional = participantService.findParticipantById(id);

        if (participantOptional.isPresent()) {
            return ResponseEntity.ok(participantOptional.get());
        }

        return ResponseEntity.notFound().build();
    }

    /**
     * Saves a given participant.
     * @param participant
     * @return a response entity containing the saved participant.
     */
    @PostMapping("/create")
    public ResponseEntity<Participant> saveParticipant(@RequestBody Participant participant) {
        Participant savedParticipant = participantService.saveParticipant(participant);
        return ResponseEntity.ok(savedParticipant);
    }

    /**
     * Updates a participant by its id with values from the given participant.
     * @param id
     * @param updatedParticipant
     * @return a response entity containing the updated participant or ResponseEntity.notFound() if none found.
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<Participant> updateParticipant(@PathVariable Long id, @RequestBody Participant updatedParticipant) {
        Optional<Participant> optionalParticipant = participantService.updateParticipant(id, updatedParticipant);

        if (optionalParticipant.isPresent()) {
            return ResponseEntity.ok(optionalParticipant.get());
        }

        return ResponseEntity.notFound().build();
    }

    /**
     * Deletes a participant by its id.
     * @param id
     * @return ResponseEntity.ok()
     */
    @DeleteMapping("/delete-by-id/{id}")
    public ResponseEntity<Participant> deleteParticipantById(@PathVariable Long id) {
        participantService.deleteParticipantById(id);
        return ResponseEntity.ok().build();
    }
}
