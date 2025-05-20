package com.example.badminton_service.court.service;

import com.example.badminton_service.court.dto.CourtDto;
import com.example.badminton_service.court.dto.CourtRequest;
import com.example.badminton_service.court.entity.Court;
import com.example.badminton_service.court.repository.CourtRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service @RequiredArgsConstructor
public class CourtService {

    private final CourtRepository repo;

    @Transactional
    public CourtDto create(CourtRequest req) {
        Court entity = Court.builder()
                .name(req.name())
                .address(req.address())
                .latitude(req.latitude())
                .longitude(req.longitude())
                .contact(req.contact())
                .openingHours(req.openingHours())
                .build();

        Court saved = repo.save(entity);
        return toDto(saved);
    }

    @Transactional
    public CourtDto find(Long id) {
        return repo.findById(id).map(this::toDto)
                .orElseThrow(() -> new IllegalArgumentException("Court not found"));
    }

    private CourtDto toDto(Court c) {
        return CourtDto.builder()
                .courtId(c.getCourtId())
                .name(c.getName())
                .address(c.getAddress())
                .latitude(c.getLatitude())
                .longitude(c.getLongitude())
                .contact(c.getContact())
                .openingHours(c.getOpeningHours())
                .build();
    }
}
