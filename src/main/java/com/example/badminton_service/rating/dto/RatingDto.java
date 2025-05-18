package com.example.badminton_service.rating.dto;

import lombok.Builder;

import java.time.LocalDateTime;
@Builder
public record RatingDto(
        Long ratingId,
        Long fromUserId,
        Long toUserId,
        Long matchId,
        Integer score,
        LocalDateTime ratedAt
) {}
