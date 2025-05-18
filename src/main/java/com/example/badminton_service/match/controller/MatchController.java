package com.example.badminton_service.match.controller;

import com.example.badminton_service.match.dto.MatchDto;
import com.example.badminton_service.match.dto.MatchRequest;
import com.example.badminton_service.match.service.MatchService;
import com.example.badminton_service.user.dto.UserDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/matches")
@RequiredArgsConstructor
public class MatchController {

    private final MatchService service;

    @PostMapping
    public MatchDto create(@RequestBody @Valid MatchRequest req) {
        return service.create(req);
    }

    @GetMapping("/{id}")
    public MatchDto detail(@PathVariable Long id) {
        return service.find(id);
    }

    //전체 조회
    @GetMapping
    public List<MatchDto> listAll() {
        return service.findAll();
    }
}
