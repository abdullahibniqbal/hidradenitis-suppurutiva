package com.shady.hidradenitis.suppurutiva.auth;

public interface PasswordHasher {
    String hashWithSalt(String password);
}
