package com.example.badminton_service.match.dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;

public record MatchRequest(
        @NotNull Long courtAvailabilityId,
        @NotNull LocalDate scheduledDate,
        @NotNull LocalTime startTime,
        @NotNull LocalTime endTime
) {}
