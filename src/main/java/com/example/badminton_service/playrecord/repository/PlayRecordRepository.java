package com.example.badminton_service.playrecord.repository;

import com.example.badminton_service.playrecord.entity.PlayRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayRecordRepository extends JpaRepository<PlayRecord, Long> {

    /** 특정 경기 기준으로 모든 기록 조회 */
    List<PlayRecord> findByMatch_MatchId(Long matchId);
    /** 특정 사용자 기준으로 모든 기록 조회 */
    List<PlayRecord> findByUser_UserId(Long userId);
    /** 같은 경기에서 같은 사용자의 기록이 이미 있는지 중복 확인 */
    boolean existsByMatch_MatchIdAndUser_UserId(Long matchId, Long userId);
}
