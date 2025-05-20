package com.example.badminton_service.rating.service;

import com.example.badminton_service.match.repository.MatchRepository;
import com.example.badminton_service.rating.dto.RatingDto;
import com.example.badminton_service.rating.dto.RatingRequest;
import com.example.badminton_service.rating.entity.Rating;
import com.example.badminton_service.rating.repository.RatingRepository;
import com.example.badminton_service.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RatingService {

    private final RatingRepository repo;
    private final MatchRepository matchRepo;
    private final UserRepository userRepo;

    public RatingDto create(Long fromUserId, RatingRequest req) {
        if (repo.existsByMatch_MatchIdAndFromUser_UserIdAndToUser_UserId(
                req.matchId(), fromUserId, req.toUserId()))
            throw new IllegalStateException("이미 평가했습니다.");

        Rating entity = Rating.builder()
                .fromUser(userRepo.getReferenceById(fromUserId))
                .toUser(userRepo.getReferenceById(req.toUserId()))
                .match(matchRepo.getReferenceById(req.matchId()))
                .score(req.score())
                .build();

        Rating saved = repo.save(entity);
        return toDto(saved);
    }

    //평균 평점
    @Transactional(readOnly = true)
    public double averageForUser(Long userId) {
        return repo.findAverageScoreForUser(userId)
                .orElse(0.0);
    }

    private RatingDto toDto(Rating e) {
        return RatingDto.builder()
                .ratingId   (e.getRatingId())
                .fromUserId (e.getFromUser().getUserId())
                .toUserId   (e.getToUser().getUserId())
                .matchId    (e.getMatch().getMatchId())
                .score      (e.getScore())
                .ratedAt    (e.getRatedAt())
                .build();
    }
}
