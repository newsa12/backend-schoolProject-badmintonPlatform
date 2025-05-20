package com.example.badminton_service.court.dto;

import lombok.Builder;

import java.time.LocalDate;
import java.time.LocalTime;

@Builder
public record CourtAvailabilityDto(
        Long id,
        Long courtId,
        LocalDate availableDate,
        LocalTime startTime,
        LocalTime endTime,
        java.math.BigDecimal pricePerHour
) {}
