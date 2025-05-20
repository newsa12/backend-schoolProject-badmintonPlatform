package com.example.badminton_service.court.repository;

import com.example.badminton_service.court.entity.Court;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourtRepository extends JpaRepository<Court, Long> {}