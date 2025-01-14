package com.nail.decoplanner.Controller;
import com.nail.decoplanner.Service.EventService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.nail.decoplanner.Entity.Event;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/events")
public class Event_Controller {
    private final EventService eventService;

    public Event_Controller(EventService eventService) {
        this.eventService = eventService;
    }
    @GetMapping
    public ResponseEntity<List<Event>> getAllEvents() {
        return ResponseEntity.ok(eventService.getAllEventees());
    }

    @GetMapping(value = "/{rsvp_id}")
    public ResponseEntity<List<Event>> getEventById(@PathVariable UUID rsvp_id) {
        return ResponseEntity.ok(eventService.getEventByRSVPID(rsvp_id));
    }

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createEvent(@RequestBody Event event) {
        eventService.createEvent(event);
        return ResponseEntity.ok("Event Created!");
    }

    @DeleteMapping("/u{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable UUID userId) {
        eventService.deleteEvent(userId);
        return ResponseEntity.ok("deleted = " + userId);
    }
}
