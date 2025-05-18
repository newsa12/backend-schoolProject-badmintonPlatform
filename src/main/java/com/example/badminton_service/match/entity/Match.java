package com.example.badminton_service.match.entity;

import com.example.badminton_service.court.entity.CourtAvailability;
import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "`match`")
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor
public class Match {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long matchId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "court_availability_id")
    private CourtAvailability courtAvailability;

    @Column(nullable = false)
    private LocalDate scheduleDate;

    @Column(nullable = false)
    private LocalTime startTime;

    @Column(nullable = false)
    private LocalTime endTime;
}
