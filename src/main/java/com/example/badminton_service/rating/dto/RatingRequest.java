package com.example.badminton_service.rating.dto;

import jakarta.validation.constraints.*;

public record RatingRequest(
        @NotNull(message = "matchId는 필수입니다.")
        Long matchId,

        @NotNull(message = "toUserId는 필수입니다.")
        Long toUserId,

        @NotNull(message = "score는 필수입니다.")
        @Min(value = 1, message = "score는 1 이상이어야 합니다.")
        @Max(value = 5, message = "score는 5 이하이어야 합니다.")
        Integer score
) {}
