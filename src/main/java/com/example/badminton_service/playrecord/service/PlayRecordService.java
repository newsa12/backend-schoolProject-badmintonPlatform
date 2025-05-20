package com.example.badminton_service.playrecord.service;

import com.example.badminton_service.match.repository.MatchRepository;
import com.example.badminton_service.playrecord.dto.PlayRecordDto;
import com.example.badminton_service.playrecord.dto.PlayRecordRequest;
import com.example.badminton_service.playrecord.entity.PlayRecord;
import com.example.badminton_service.playrecord.repository.PlayRecordRepository;
import com.example.badminton_service.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PlayRecordService {

    private final PlayRecordRepository playRepo;
    private final MatchRepository matchRepo;
    private final UserRepository userRepo;

    // 1) 경기 결과기록 생성
    @Transactional
    public PlayRecordDto create(PlayRecordRequest req) {

        // 1-1) 이미 같은 사용자·경기에 기록이 있으면 중복 방지
        if (playRepo.existsByMatch_MatchIdAndUser_UserId(
                req.matchId(), req.userId())) {
            throw new IllegalStateException("이미 결과를 기록했습니다.");
        }

        // 1-2) 참조 엔티티 조회 (지연 로딩 proxy)
        var match = matchRepo.getReferenceById(req.matchId());
        var user = userRepo.getReferenceById(req.userId());

        // 1-3) PlayRecord 엔티티 생성
        PlayRecord entity = PlayRecord.builder()
                .match(match)
                .user(user)
                .scoreFor(req.scoreFor())
                .scoreAgainst(req.scoreAgainst())
                .result(req.result())
                .build();
        // 1-4) 저장 -> PK(recordId) 자동 생성
        PlayRecord saved = playRepo.save(entity);
        // 1-5) DTO 변환 후 반환
        return toDto(saved);
    }

    // 2) 특정 경기(matchId)별 기록 목록 조회
    @Transactional(readOnly = true)
    public List<PlayRecordDto> listByMatch(Long matchId) {
        return playRepo.findByMatch_MatchId(matchId)
                .stream()
                .map(this::toDto)
                .toList();
    }

    // 3) 특정 사용자(userId)별 기록 목록 조회
    @Transactional(readOnly = true)
    public List<PlayRecordDto> listByUser(Long userId) {
        return playRepo.findByUser_UserId(userId)
                .stream()
                .map(this::toDto)
                .toList();
    }

    // 공통 DTO 매핑 method
    private PlayRecordDto toDto(PlayRecord e) {
        return PlayRecordDto.builder()
                .recordId(e.getRecordId())
                .matchId(e.getMatch().getMatchId())
                .userId(e.getUser().getUserId())
                .scoreFor(e.getScoreFor())
                .scoreAgainst(e.getScoreAgainst())
                .result(e.getResult())
                .recordedAt(e.getRecordedAt())
                .build();
    }
}
