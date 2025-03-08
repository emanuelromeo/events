package com.crud.events.service;

import com.crud.events.entity.Event;
import com.crud.events.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    /**
     * Selects all events.
     * @return a list of events.
     */
    public List<Event> findAllEvents() {
        return eventRepository.findAll();
    }

    /**
     * Returns an event by its id.
     * @param id
     * @return an optional containing the event with the given id or Optional.empty() if none found.
     */
    public Optional<Event> findEventById(Long id) {
        return eventRepository.findById(id);
    }

    /**
     * Saves a given event.
     * @param event
     * @return the saved event.
     */
    public Event saveEvent(Event event) {
        return eventRepository.save(event);
    }

    /**
     * Updates an event by its id with values from the given event.
     * @param id
     * @param updatedEvent
     * @return an optional containing the updated event or Optional.empty() if none found.
     */
    public Optional<Event> updateEvent(Long id, Event updatedEvent) {
        Optional<Event> optionalEvent = eventRepository.findById(id);

        if (optionalEvent.isPresent()) {
            optionalEvent.get().setName(updatedEvent.getName());
            optionalEvent.get().setEventType(updatedEvent.getEventType());

            Event savedEvent = eventRepository.save(optionalEvent.get());
            return Optional.of(savedEvent);
        }

        return Optional.empty();
    }

    /**
     * Deletes an event by its id.
     * @param id
     */
    public void deleteEventById(Long id) {
        eventRepository.deleteById(id);
    }

}
