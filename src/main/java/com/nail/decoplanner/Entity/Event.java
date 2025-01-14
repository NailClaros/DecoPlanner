package com.nail.decoplanner.Entity;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.util.UUID;


@Entity
@Table(name = "eventees")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID participant_id;

    @Column(nullable = false)
    private UUID rsvp_id;

    @Column(nullable = false)
    private UUID user_id;



    public Event() {}

    public Event(UUID rsvp_id, UUID user_id) {
        this.rsvp_id = rsvp_id;
        this.user_id = user_id;
    }

    public UUID getRsvp_id() {
        return rsvp_id;
    }
    public UUID getUser_id() {
        return user_id;
    }
    public void setRsvp_id(UUID rsvp_id) {
        this.rsvp_id = rsvp_id;
    }
    public void setUser_id(UUID user_id) {
        this.user_id = user_id;
    }

}
