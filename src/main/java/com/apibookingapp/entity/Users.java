package com.apibookingapp.entity;

import java.sql.Timestamp;
import java.time.Instant;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Users {
	@Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    String email;

    @Column(name = "first_name")
    String firstName;

    @Column(name = "last_name")
    String lastName;

    String address;
    String gender;
    String image;

    @OneToOne
    @JoinColumn(name = "role_id")  // Foreign key column for the role
    AllCode roleId;
    @OneToOne(mappedBy = "doctor")
    Booking doctor;
    @OneToOne(mappedBy = "patient")
    Booking patient;

    @Column(name = "create_at")
    Timestamp createdAt;

    @Column(name = "update_at")
    Timestamp updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = Timestamp.from(Instant.now());
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = Timestamp.from(Instant.now());
    }
}
