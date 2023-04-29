package com.shady.hidradenitis.suppurutiva.services.auth;

import com.shady.hidradenitis.suppurutiva.auth.Jwt;
import com.shady.hidradenitis.suppurutiva.auth.PasswordHasher;
import com.shady.hidradenitis.suppurutiva.auth.User;
import com.shady.hidradenitis.suppurutiva.dtos.response.auth.AuthResponse;
import com.shady.hidradenitis.suppurutiva.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthImpl implements AuthService {
    @Autowired
    private UserRepository repository;

    @Autowired
    private Jwt jwt;

    @Autowired
    private PasswordHasher hasher;

    @Override
    public void signup(User user) {
        User existingUser = repository.findByName(user.name);

        if(existingUser != null) {
            throw new RuntimeException();   //TODO
        }
        User applicant = new User();
        applicant.name = user.name;
        applicant.password = hasher.hashWithSalt(user.password);

        repository.save(applicant);
    }

    @Override
    public AuthResponse login(User user) {
        User userResult = repository.findByNameAndPassword(user.name, hasher.hashWithSalt(user.password));

        AuthResponse authResponse = new AuthResponse();
        if(userResult != null) {
            authResponse.jwt = jwt.sign(userResult);
        }
        return authResponse;
    }

    @Override
    public AuthResponse verify(String token) {
        if(jwt.verify(token)) {
            return new AuthResponse();
        }
        else {
            throw new RuntimeException();
        }
    }
}
