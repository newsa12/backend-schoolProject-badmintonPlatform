package com.example.badminton_service.court.dto;

import lombok.Builder;

@Builder
public record CourtDto(
        Long courtId,
        String name,
        String address,
        java.math.BigDecimal latitude,
        java.math.BigDecimal longitude,
        String contact,
        String openingHours
) {}
