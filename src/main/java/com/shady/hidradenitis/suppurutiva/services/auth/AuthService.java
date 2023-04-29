package com.shady.hidradenitis.suppurutiva.services.auth;

import com.shady.hidradenitis.suppurutiva.auth.User;
import com.shady.hidradenitis.suppurutiva.dtos.request.auth.UserDto;
import com.shady.hidradenitis.suppurutiva.dtos.response.auth.AuthResponse;

public interface AuthService {
    void signup(User user);
    AuthResponse login(User userDto);
    AuthResponse verify(String token);
}
