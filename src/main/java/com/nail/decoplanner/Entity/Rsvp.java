package com.nail.decoplanner.Entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "rsvps")
public class Rsvp {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID rsvpId;

    @Column(nullable = false)
    private UUID userId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private double latitude;

    @Column(nullable = false)
    private double longitude;

    @Column(nullable = false)
    private String rsvpStatus;

    @Column(updatable = false)
    private LocalDateTime createdAt;

    @Column
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    public Rsvp() {}

    // Parameterized constructor
    public Rsvp(UUID userId, String name, String address, double latitude, double longitude) {
        this.userId = userId;
        this.name = name;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.rsvpStatus = "Pending";
    }

    // Getters and Setters
    public UUID getRsvpId() {
        return rsvpId;
    }
    public void setRsvpId(UUID rsvpId) {
        this.rsvpId = rsvpId;
    }
    public UUID getUserId() {
        return userId;
    }
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getAddress() {return address;}
    public void setAddress(String address) {this.address = address;}
    public double getLatitude() {return latitude;}
    public double getLongitude() {return longitude;}
    public void setLongitude(double longitude) {this.longitude = longitude;}
    public void setLatitude(double latitude) {this.latitude = latitude;}
    public void setUserId(UUID userId) {
        this.userId = userId;
    }
    public String getRsvpStatus() {
        return rsvpStatus;
    }
    public void setRsvpStatus(String rsvpStatus) {
        this.rsvpStatus = rsvpStatus;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}