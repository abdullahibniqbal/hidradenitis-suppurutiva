package com.shady.hidradenitis.suppurutiva.auth;

public interface Jwt {
    String sign(Payload payload);
    Boolean verify(String jwt);
    Payload decode(String jwt);
}
