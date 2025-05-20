package com.example.badminton_service.court.repository;

import com.example.badminton_service.court.entity.CourtAvailability;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourtAvailabilityRepository extends JpaRepository<CourtAvailability, Long> {}