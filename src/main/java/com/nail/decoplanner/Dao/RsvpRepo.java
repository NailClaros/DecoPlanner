package com.nail.decoplanner.Dao;

import com.nail.decoplanner.Entity.Rsvp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RsvpRepo extends JpaRepository<Rsvp, String> {

}