package com.example.badminton_service.court.service;

import com.example.badminton_service.court.dto.CourtAvailabilityDto;
import com.example.badminton_service.court.dto.CourtAvailabilityRequest;
import com.example.badminton_service.court.entity.Court;
import com.example.badminton_service.court.entity.CourtAvailability;
import com.example.badminton_service.court.repository.CourtAvailabilityRepository;
import com.example.badminton_service.court.repository.CourtRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service @RequiredArgsConstructor
public class CourtAvailabilityService {

    private final CourtAvailabilityRepository caRepo;
    private final CourtRepository courtRepo;

    @Transactional
    public CourtAvailabilityDto create(CourtAvailabilityRequest req) {
        Court court = courtRepo.getReferenceById(req.courtId());

        CourtAvailability entity = CourtAvailability.builder()
                .court(court)
                .availableDate(req.availableDate())
                .startTime(req.startTime())
                .endTime(req.endTime())
                .pricePerHour(req.pricePerHour())
                .build();

        CourtAvailability saved = caRepo.save(entity);
        return toDto(saved);
    }

    @Transactional(readOnly = true)
    public CourtAvailabilityDto find(long id) {
        return caRepo.findById(id)
                .map(this::toDto)
                .orElseThrow(() -> new IllegalArgumentException("Slot not found with id: " + id));
    }

    @Transactional(readOnly = true)
    public CourtAvailabilityDto toDto(CourtAvailability ca) {
        return CourtAvailabilityDto.builder()
                .id(ca.getId())
                .courtId(ca.getCourt().getCourtId())
                .availableDate(ca.getAvailableDate())
                .startTime(ca.getStartTime())
                .endTime(ca.getEndTime())
                .pricePerHour(ca.getPricePerHour())
                .build();
    }
}
