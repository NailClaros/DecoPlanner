package com.nail.decoplanner.Service;
import com.nail.decoplanner.Entity.Rsvp;
import com.nail.decoplanner.Dao.RsvpRepo;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RsvpService {
    private final RsvpRepo rsvpRepository;

    public RsvpService(RsvpRepo rsvpRepository) {
        this.rsvpRepository = rsvpRepository;
    }

    public List<Rsvp> getAllRsvps() {
        return rsvpRepository.findAll();
    }

    public Rsvp getRsvpById(String rsvpId) {
        return rsvpRepository.findById(rsvpId)
                .orElseThrow(() -> new IllegalArgumentException("Rsvp not found"));
    }

    public Rsvp createRsvp(Rsvp rsvp) {
        return rsvpRepository.save(rsvp);
    }

    public Rsvp updateRsvp(String rsvpId, Rsvp rsvpDetails) {
        Rsvp rsvp = getRsvpById(rsvpId);
        rsvp.setRsvpStatus(rsvpDetails.getRsvpStatus());
        return rsvpRepository.save(rsvp);
    }

    public void deleteRsvp(String rsvpId) {
        rsvpRepository.deleteById(rsvpId);
    }
}
