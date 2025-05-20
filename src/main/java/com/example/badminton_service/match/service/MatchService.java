package com.example.badminton_service.match.service;

import com.example.badminton_service.court.repository.CourtAvailabilityRepository;
import com.example.badminton_service.match.dto.MatchDto;
import com.example.badminton_service.match.dto.MatchRequest;
import com.example.badminton_service.match.entity.Match;
import com.example.badminton_service.match.repository.MatchRepository;
import com.example.badminton_service.user.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MatchService {

    private final MatchRepository matchRepo;
    private final CourtAvailabilityRepository caRepo;

    //매치 생성
    @Transactional
    public MatchDto create(MatchRequest req) {
        var ca = caRepo.getReferenceById(req.courtAvailabilityId());

        Match entity = Match.builder()
                .courtAvailability(ca)
                .scheduleDate(req.scheduledDate())
                .startTime(req.startTime())
                .endTime(req.endTime())
                .build();

        Match saved = matchRepo.save(entity);
        return toDto(saved);
    }

    //단건 조회
    @Transactional(readOnly = true)
    public MatchDto find(Long id) {
        return matchRepo.findById(id)
                .map(this::toDto)
                .orElseThrow(() -> new IllegalArgumentException("Match not found"));
    }

    //전체 조회
    @Transactional(readOnly = true)
    public List<MatchDto> findAll() {
        return matchRepo.findAll().stream()
                .map(this::toDto)
                .toList();
    }

    private MatchDto toDto(Match m) {
        return MatchDto.builder()
                .matchId(m.getMatchId())
                .courtAvailabilityId(m.getCourtAvailability().getId())
                .scheduledDate(m.getScheduleDate())
                .startTime(m.getStartTime())
                .endTime(m.getEndTime())
                .build();
    }
}
