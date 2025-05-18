package com.example.badminton_service.court.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "court")
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Court {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courtId;

    @Column(nullable = false, length = 250)
    private String name;

    @Column(length = 250)
    private String address;

    @Column(precision = 9, scale = 6)
    private java.math.BigDecimal latitude;

    @Column(precision = 9, scale = 6)
    private java.math.BigDecimal longitude;

    private String contact;
    private String openingHours;
}
