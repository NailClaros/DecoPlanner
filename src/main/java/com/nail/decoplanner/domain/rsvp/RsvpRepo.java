package com.nail.decoplanner.domain.rsvp;

import com.nail.decoplanner.domain.rsvp.Rsvp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RsvpRepo extends JpaRepository<Rsvp, String> {

}