package com.crud.events.controller;

import com.crud.events.entity.Event;
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

}
