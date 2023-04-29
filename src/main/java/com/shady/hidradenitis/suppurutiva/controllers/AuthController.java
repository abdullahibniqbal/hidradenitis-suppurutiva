package com.shady.hidradenitis.suppurutiva.controllers;

import com.shady.hidradenitis.suppurutiva.dtos.request.auth.UserDto;
import com.shady.hidradenitis.suppurutiva.dtos.response.auth.AuthResponse;
import com.shady.hidradenitis.suppurutiva.mappers.DtoMapper;
import com.shady.hidradenitis.suppurutiva.services.auth.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @Autowired
    private AuthService service;

    @Autowired
    private DtoMapper mapper;

    @PostMapping("/signup")
    public AuthResponse signup(@RequestBody UserDto user) {
        service.signup(mapper.map(user));

        return new AuthResponse();
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody UserDto userDto) {
        return service.login(mapper.map(userDto));
    }

    @PostMapping("/verify")
    public AuthResponse verify(@RequestHeader String token) {
        return service.verify(token);
    }
}
