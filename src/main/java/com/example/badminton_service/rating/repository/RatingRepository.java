package com.example.badminton_service.rating.repository;

import com.example.badminton_service.rating.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface RatingRepository extends JpaRepository<Rating, Long> {
    /** 동일 경기에서 동일 대상에 대해 이미 평가했는지 중복 체크 */
    boolean existsByMatch_MatchIdAndFromUser_UserIdAndToUser_UserId(
            Long matchId, Long fromUserId, Long toUserId);
    @Query("select avg(r.score) from Rating r where r.toUser.userId = :userId")
    Optional<Double> findAverageScoreForUser(@Param("userId") Long userId);
}