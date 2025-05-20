package com.example.badminton_service.court.controller;

import com.example.badminton_service.court.dto.CourtDto;
import com.example.badminton_service.court.dto.CourtRequest;
import com.example.badminton_service.court.service.CourtService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/courts")
@RequiredArgsConstructor
public class CourtController {

    private final CourtService service;

    @PostMapping
    public CourtDto create(@RequestBody @Valid CourtRequest req) {
        return service.create(req);
    }

    @GetMapping("/{id}")
    public CourtDto get(@PathVariable Long id) {
        return service.find(id);
    }
}
