package com.example.badminton_service.playrecord.entity;

import com.example.badminton_service.common.Result;
import com.example.badminton_service.match.entity.Match;
import com.example.badminton_service.user.entity.User;
import com.fasterxml.jackson.databind.deser.DataFormatReaders;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "play_record")
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor
public class PlayRecord {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long recordId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "match_id")
    private Match match;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private Integer scoreFor;
    private Integer scoreAgainst;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 10)
    private Result result;

    @Builder.Default
    @Column(nullable = false, updatable = false)
    private LocalDateTime recordedAt = LocalDateTime.now();
}
