package com.shady.hidradenitis.suppurutiva.controllers;

import com.shady.hidradenitis.suppurutiva.dtos.request.auth.UserDto;
import com.shady.hidradenitis.suppurutiva.dtos.response.auth.JwtDto;
import com.shady.hidradenitis.suppurutiva.mappers.DtoMapper;
import com.shady.hidradenitis.suppurutiva.services.auth.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @Autowired
    private AuthService service;

    @Autowired
    private DtoMapper mapper;

    @PostMapping("/login")
    public JwtDto login(@RequestBody UserDto userDto) {
        return service.login(mapper.map(userDto));
    }
}
