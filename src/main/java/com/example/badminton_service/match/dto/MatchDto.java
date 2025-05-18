package com.example.badminton_service.match.dto;

import lombok.Builder;

import java.time.LocalDate;
import java.time.LocalTime;

@Builder
public record MatchDto(
        Long matchId,
        Long courtAvailabilityId,
        LocalDate scheduledDate,
        LocalTime startTime,
        LocalTime endTime
) {}
