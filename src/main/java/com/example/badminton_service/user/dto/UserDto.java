package com.example.badminton_service.user.dto;

import lombok.Builder;
import java.time.LocalDateTime;

@Builder
public record UserDto(
        Long userId,
        String username,
        String email,
        String role,
        LocalDateTime joinedAt,
        String profileImage,
        String bio
) {}

