package com.shady.hidradenitis.suppurutiva.services.auth;

import com.shady.hidradenitis.suppurutiva.auth.User;
import com.shady.hidradenitis.suppurutiva.dtos.response.auth.JwtDto;

public interface AuthService {
    JwtDto login(User userDto);
}
