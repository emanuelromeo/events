package com.crud.events.controller;

import com.crud.events.entity.Event;
import com.crud.events.entity.Participant;
import com.crud.events.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventService eventService;

    /**
     * Selects all events.
     * @return a response entity containing a list of events.
     */
    @GetMapping("/select-all")
    public ResponseEntity<List<Event>> findAllEvents() {
        List<Event> events = eventService.findAllEvents();
        return ResponseEntity.ok(events);
    }

    /**
     * Returns an event by its id.
     * @param id
     * @return a response entity containing the event with the given id or ResponseEntity.notFound() if none found.
     */
    @GetMapping("/select-by-id/{id}")
    public ResponseEntity<Event> findEventById(@PathVariable Long id) {
        Optional<Event> optionalEvent = eventService.findEventById(id);

        if (optionalEvent.isPresent()) {
            return ResponseEntity.ok(optionalEvent.get());
        }

        return ResponseEntity.notFound().build();
    }

    /**
     * Saves a given event.
     * @param event
     * @return a response entity containing the saved event.
     */
    @PostMapping("/create")
    public ResponseEntity<Event> saveEvent(@RequestBody Event event) {
        Event savedEvent = eventService.saveEvent(event);
        return ResponseEntity.ok(savedEvent);
    }

    /**
     * Updates an event by its id with values from the given event.
     * @param id
     * @param updatedEvent
     * @return a response entity containing the updated event or ResponseEntity.notFound() if none found.
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<Event> updateEvent(@PathVariable Long id, @RequestBody Event updatedEvent) {
        Optional<Event> optionalEvent = eventService.updateEvent(id, updatedEvent);

        if (optionalEvent.isPresent()) {
            return ResponseEntity.ok(optionalEvent.get());
        }

        return ResponseEntity.notFound().build();
    }

    /**
     * Deletes an event by its id.
     * @param id
     * @return ResponseEntity.ok()
     */
    @DeleteMapping("/delete-by-id/{id}")
    public ResponseEntity<Event> deleteEventById(@PathVariable Long id) {
        eventService.deleteEventById(id);
        return ResponseEntity.ok().build();
    }
}
