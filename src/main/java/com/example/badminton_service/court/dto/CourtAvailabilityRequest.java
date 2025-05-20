package com.example.badminton_service.court.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;

public record CourtAvailabilityRequest(
        @NotNull Long courtId,
        @NotNull LocalDate availableDate,
        @NotNull LocalTime startTime,
        @NotNull LocalTime endTime,
        @DecimalMin("0.0") java.math.BigDecimal pricePerHour
){}