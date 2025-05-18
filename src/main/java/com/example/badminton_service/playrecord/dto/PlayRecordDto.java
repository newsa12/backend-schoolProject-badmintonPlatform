package com.example.badminton_service.playrecord.dto;

import com.example.badminton_service.common.Result;
import com.example.badminton_service.playrecord.entity.PlayRecord;
import lombok.Builder;

import java.time.LocalDateTime;
@Builder
public record PlayRecordDto(
        Long recordId,
        Long matchId,
        Long userId,
        Integer scoreFor,
        Integer scoreAgainst,
        Result result,
        LocalDateTime recordedAt
) {}
