package com.shady.hidradenitis.suppurutiva.services.auth;

import com.shady.hidradenitis.suppurutiva.auth.Jwt;
import com.shady.hidradenitis.suppurutiva.auth.User;
import com.shady.hidradenitis.suppurutiva.dtos.response.auth.JwtDto;
import com.shady.hidradenitis.suppurutiva.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthImpl implements AuthService {
    @Autowired
    private UserRepository repository;

    @Autowired
    private Jwt jwt;

    @Override
    public JwtDto login(User user) {
        User dummyUser = new User();
        dummyUser.name = "mustehssun";
        dummyUser.password = "avengers123";

        repository.save(dummyUser);

        User userResult = repository.findByNameAndPassword(user.name, user.password);

        JwtDto jwtDto = new JwtDto();
        if(userResult != null) {
            jwtDto.jwt = jwt.sign(userResult);
        }
        return jwtDto;
    }
}
