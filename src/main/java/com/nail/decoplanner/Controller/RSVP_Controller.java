package com.nail.decoplanner.Controller;
import com.nail.decoplanner.Entity.Rsvp;
import com.nail.decoplanner.Service.RsvpService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rsvps")
public class RSVP_Controller {
    private final RsvpService rsvpService;

    public RSVP_Controller(RsvpService rsvpService) {
        this.rsvpService = rsvpService;
    }


    @GetMapping
    public ResponseEntity<List<Rsvp>> getAllRsvps() {
        return ResponseEntity.ok(rsvpService.getAllRsvps());
    }

    @GetMapping("/{rsvpId}")
    public ResponseEntity<Rsvp> getRsvpById(@PathVariable String rsvpId) {
        return ResponseEntity.ok(rsvpService.getRsvpById(rsvpId));
    }

    @PostMapping
    public ResponseEntity<Rsvp> createRsvp(@RequestBody Rsvp rsvp) {
        return ResponseEntity.ok(rsvpService.createRsvp(rsvp));
    }

    @PutMapping("/{rsvpId}")
    public ResponseEntity<Rsvp> updateRsvp(
            @PathVariable String rsvpId, @RequestBody Rsvp rsvpDetails) {
        return ResponseEntity.ok(rsvpService.updateRsvp(rsvpId, rsvpDetails));
    }

    @DeleteMapping("/{rsvpId}")
    public ResponseEntity<Void> deleteRsvp(@PathVariable String rsvpId) {
        rsvpService.deleteRsvp(rsvpId);
        return ResponseEntity.noContent().build();
    }
}
