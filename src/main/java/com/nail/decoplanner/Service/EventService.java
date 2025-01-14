package com.nail.decoplanner.Service;
import com.nail.decoplanner.Entity.Event;
import com.nail.decoplanner.Dao.EventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EventService {

    private final EventRepo eventRepository;
    @Autowired
    public EventService(EventRepo eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<Event> getAllEventees() {
        return eventRepository.findAll();
    }

    public List<Event> getEventByRSVPID(UUID rsvp_id) {
        return eventRepository.findAll().stream()
                .filter(event -> rsvp_id.equals(event.getRsvp_id()))
                .toList();
    }

    public List<Event> getEventByUserId(UUID userId) {
        return eventRepository.findAll().stream()
                .filter(event -> userId.equals(event.getUser_id()))
                .toList();
    }

    public void createEvent(Event event) {
        System.out.println("Eventee saved successfully!");
        eventRepository.save(event);
    }

    public Event updateEvent(UUID eventId, Event eventDetails) {
        return eventRepository.save(eventDetails);

    }

    public void deleteEvent(UUID eventId) {
        eventRepository.deleteById(eventId);
    }
}
