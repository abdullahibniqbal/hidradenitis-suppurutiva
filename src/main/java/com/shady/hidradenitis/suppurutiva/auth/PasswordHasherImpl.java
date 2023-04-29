package com.shady.hidradenitis.suppurutiva.auth;

import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

@Component
public class PasswordHasherImpl implements PasswordHasher {

    @Override
    public String hashWithSalt(String password) {
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("SHA3-256");
        } catch(Exception e) {
            throw new RuntimeException();
        }
        byte[] hashBytes = digest.digest(password.getBytes(StandardCharsets.UTF_8));

        return new String(hashBytes);
    }
}
