package com.shady.hidradenitis.suppurutiva.auth;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.shady.hidradenitis.suppurutiva.mappers.PayloadMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Base64;
import java.util.Calendar;

@Component
public class JwtHmac256Impl implements Jwt {
    @Autowired
    private PayloadMapper mapper;

    @Override
    public String sign(Payload payload) {
        Algorithm algorithm = Algorithm.HMAC256(getSecret());

        return JWT.create()
                .withPayload(mapper.map(payload))
                .withIssuedAt(Calendar.getInstance().getTime())
                .sign(algorithm);
    }

    private String getSecret() {
        return "Cream fruit chat";
    }

    @Override
    public Boolean verify(String jwt) {
        if(jwt == null) return false;   //edge case

        Algorithm algorithm = Algorithm.HMAC256(getSecret());
        JWTVerifier verifier = JWT.require(algorithm).build();

        try {
            verifier.verify(jwt);
        } catch(JWTDecodeException e) {
            return false;
        }
        return true;
    }

    @Override
    public Payload decode(String jwt) throws JWTDecodeException {
        if(jwt == null) throw new IllegalArgumentException();   //edge case

        Algorithm algorithm = Algorithm.HMAC256(getSecret());
        JWTVerifier verifier = JWT.require(algorithm).build();

        DecodedJWT decodedJwt = verifier.verify(jwt);
        String payloadInBase64 = new String(Base64.getDecoder().decode(decodedJwt.getPayload()));

        return mapper.map(payloadInBase64);
    }
}
