package com.example.badminton_service.user.service;

import com.example.badminton_service.user.dto.UserDto;
import com.example.badminton_service.user.dto.UserRequest;
import com.example.badminton_service.user.entity.User;
import com.example.badminton_service.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repo;

    //회원가입
    @Transactional
    public UserDto register(UserRequest req) {
        if (repo.existsByEmail(req.email())) {
            throw new IllegalStateException("이미 가입된 메일입니다.");
        }
        User entity = User.builder()
                .username(req.username())
                .email(req.email())
                .password(req.password())
                .build();
        User saved = repo.save(entity);
        return toDto(saved);
    }

    //단건 조회
    @Transactional(readOnly = true)
    public UserDto find(Long id) {
        return repo.findById(id)
                .map(this::toDto)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
    }

    //전체 조회
    @Transactional(readOnly = true)
    public List<UserDto> findAll() {
        return repo.findAll().stream()
                .map(this::toDto)
                .toList();
    }

    //Entity -> Dto 매핑
    private UserDto toDto(User e) {
        return UserDto.builder()
                .userId(e.getUserId())
                .username(e.getUsername())
                .email(e.getEmail())
                .role(e.getRole())
                .joinedAt(e.getJoinedAt())
                .profileImage(e.getProfileImage())
                .bio(e.getBio())
                .build();
    }
}
