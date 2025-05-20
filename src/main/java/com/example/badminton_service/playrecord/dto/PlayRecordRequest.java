package com.example.badminton_service.playrecord.dto;

import com.example.badminton_service.common.Result;
import com.example.badminton_service.playrecord.entity.PlayRecord;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record PlayRecordRequest(
        @NotNull(message = "matchId는 필수입니다.")
        Long matchId,

        @NotNull(message = "userId는 필수입니다.")
        Long userId,

        @NotNull(message = "scoreFor는 필수입니다.")
        @Min(value = 0, message = "scoreFor는 0 이상이어야 합니다.")
        Integer scoreFor,

        @NotNull(message = "scoreAgainst는 필수입니다.")
        @Min(value = 0, message = "scoreAgainst는 0 이상이어야 합니다.")
        Integer scoreAgainst,

        @NotNull(message = "result는 필수입니다.")
        Result result
) {
//    public enum Result { WIN, LOSS }
}
