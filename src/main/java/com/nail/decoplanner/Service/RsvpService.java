package com.nail.decoplanner.Service;
import com.nail.decoplanner.Entity.Rsvp;
import com.nail.decoplanner.Dao.RsvpRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RsvpService {
    private final RsvpRepo rsvpRepository;

    public RsvpService(RsvpRepo rsvpRepository) {
        this.rsvpRepository = rsvpRepository;
    }

    public List<Rsvp> getAllRsvps() {
        return rsvpRepository.findAll();
    }

    public Rsvp getRsvpById(UUID rsvpId) {
        return rsvpRepository.findById((rsvpId))
                .orElseThrow(() -> new IllegalArgumentException("Rsvp not found"));
    }

    public void createRsvp(Rsvp rsvp) {
        rsvpRepository.save(rsvp);
        System.out.println("Rsvp saved successfully!");
    }

    public Rsvp updateRsvp(UUID rsvpId, Rsvp rsvpDetails) {
        Rsvp rsvp = getRsvpById(rsvpId);
        rsvp.setRsvpStatus(rsvpDetails.getRsvpStatus());
        rsvp.setLatitude(rsvpDetails.getLatitude());
        rsvp.setLongitude(rsvpDetails.getLongitude());
        rsvp.setAddress(rsvpDetails.getAddress());
        rsvp.setName(rsvpDetails.getName());
        return rsvpRepository.save(rsvp);
    }

    public void deleteRsvp(UUID rsvpId) {
        rsvpRepository.deleteById(rsvpId);
    }
}
