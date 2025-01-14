package com.nail.decoplanner.Controller;
import com.nail.decoplanner.Entity.Rsvp;
import com.nail.decoplanner.Service.RsvpService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/rsvps")
public class RSVP_Controller {
    private final RsvpService rsvpService;

    public RSVP_Controller(RsvpService rsvpService) {
        this.rsvpService = rsvpService;
    }


    @GetMapping
    public ResponseEntity<List<Rsvp>> getAllRsvps() {
        System.out.println("GETTING ALL RSVPS");
        return ResponseEntity.ok(rsvpService.getAllRsvps());
    }

    @GetMapping("/{rsvpId}")
    public ResponseEntity<Rsvp> getRsvpById(@PathVariable UUID rsvpId) {
        System.out.println("GETTING RSVP BY ID: " + rsvpId);
        return ResponseEntity.ok(rsvpService.getRsvpById(rsvpId));
    }

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Rsvp> createRsvp(@RequestBody Rsvp rsvp) {
        rsvpService.createRsvp(rsvp);
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "/{rsvpId}")
    public ResponseEntity<Rsvp> updateRsvp(
            @PathVariable UUID rsvpId, @RequestBody Rsvp rsvpDetails) {
        return ResponseEntity.ok(rsvpService.updateRsvp(rsvpId, rsvpDetails));
    }

    @DeleteMapping(value = "/{rsvpId}")
    public ResponseEntity<Void> deleteRsvp(@PathVariable UUID rsvpId) {
        rsvpService.deleteRsvp(rsvpId);
        return ResponseEntity.noContent().build();
    }
}
