package com.example.badminton_service.court.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CourtRequest(
        @NotBlank @Size(max = 255) String name,
        @Size(max = 255) String address,
        java.math.BigDecimal latitude,
        java.math.BigDecimal longitude,
        @Size(max = 50) String contact,
        @Size(max = 100) String openingHours
) {}
