package com.example.badminton_service.user.dto;

import jakarta.validation.constraints.*;

public record UserRequest(
        @NotBlank @Size(max = 50) String username,
        @Email String email,
        @NotBlank @Size(min = 8, max = 250, message = "비밀번호는 최소 8자 이상입니다.")
        String password
) {}