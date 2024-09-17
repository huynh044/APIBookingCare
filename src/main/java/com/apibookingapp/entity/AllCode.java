package com.apibookingapp.entity;

import java.sql.Timestamp;
import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
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
public class AllCode {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	String id;
	String key;
	String type;
	String value_en;
	String value_vi;
	@OneToOne(mappedBy = "roleId")
	Users users;
	
	@OneToOne(mappedBy = "status")
	Booking status;
	@OneToOne(mappedBy = "timeType")
	Booking timeType;
	
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
