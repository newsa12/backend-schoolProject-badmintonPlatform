package com.example.badminton_service.rating.controller;

import com.example.badminton_service.rating.dto.RatingDto;
import com.example.badminton_service.rating.dto.RatingRequest;
import com.example.badminton_service.rating.service.RatingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/ratings")
@RequiredArgsConstructor
public class RatingController {

    private final RatingService service;

    //평가 생성
    @PostMapping
    public RatingDto create(
        @RequestHeader("X-USER-ID") Long fromUserId,
        @RequestBody @Valid RatingRequest req) {
        return service.create(fromUserId, req);
    }

    @GetMapping("/average/{userId}")
    public Map<String, Double> avg(@PathVariable Long userId) {
        return Map.of("avgScore", service.averageForUser(userId));
    }
}
