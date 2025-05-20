package com.example.badminton_service.playrecord.controller;

import com.example.badminton_service.playrecord.dto.PlayRecordRequest;
import com.example.badminton_service.playrecord.dto.PlayRecordDto;
import com.example.badminton_service.playrecord.service.PlayRecordService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/play-records")
@RequiredArgsConstructor
public class PlayRecordController {
    private final PlayRecordService service;

    @PostMapping
    public PlayRecordDto create(@RequestBody @Valid PlayRecordRequest req) {
        return service.create(req);
    }

    @GetMapping("/match/{matchId}")
    public List<PlayRecordDto> listByMatch(@PathVariable Long matchId) {
        return service.listByMatch(matchId);
    }

    //사용자별 기록 조회
    @GetMapping("/user/{userId}")
    public List<PlayRecordDto> listByUser(@PathVariable Long userId) {
        return service.listByUser(userId);
    }
}
