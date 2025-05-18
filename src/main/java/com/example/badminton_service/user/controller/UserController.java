package com.example.badminton_service.user.controller;

import com.example.badminton_service.user.dto.UserDto;
import com.example.badminton_service.user.dto.UserRequest;
import com.example.badminton_service.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @PostMapping        //회원가입
    public UserDto register(@RequestBody @Valid UserRequest req) {
        return service.register(req);
    }
    //단건 조회
    @GetMapping("/{id}")
    public UserDto profile(@PathVariable Long id) {
        return service.find(id);
    }

    //전체 조회
    @GetMapping
    public List<UserDto> listAll() {
        return service.findAll();
    }
}
