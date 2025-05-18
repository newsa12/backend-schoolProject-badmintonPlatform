package com.example.badminton_service.match.repository;

import com.example.badminton_service.match.entity.Match;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchRepository extends JpaRepository<Match, Long> {}