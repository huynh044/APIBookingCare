package com.apibookingapp.entity;

import java.sql.Timestamp;
import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
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
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	String id;
	
	@OneToOne
	@JoinColumn(name = "status_id")
	AllCode status;
	@OneToOne
	@JoinColumn(name = "timeType_id")
	AllCode timeType;
	
	@OneToOne
	@JoinColumn(name = "doctor_id")
	Users doctor;
	
	@OneToOne
	@JoinColumn(name = "patient_id")
	Users patient;
	
	Timestamp date;
	
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
