package com.example.badminton_service.court.controller;

import com.example.badminton_service.court.dto.CourtAvailabilityDto;
import com.example.badminton_service.court.dto.CourtAvailabilityRequest;
import com.example.badminton_service.court.entity.CourtAvailability;
import com.example.badminton_service.court.service.CourtAvailabilityService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/court-slots")
@RequiredArgsConstructor
public class CourtAvailabilityController {

    private final CourtAvailabilityService service;

    @PostMapping
    public CourtAvailabilityDto create(@RequestBody @Valid CourtAvailabilityRequest req) {
        return service.create(req);
    }

    @GetMapping("/{id}")
    public CourtAvailabilityDto detail(@PathVariable Long id) {
        return service.find(id);
    }
}
