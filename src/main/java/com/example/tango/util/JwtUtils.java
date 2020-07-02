package com.example.tango.util;

import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;

public class JwtUtils {
    private static final String KEY = "worm";
    private static final String ISSUER = "tango";

    public static String create(String username, int userId) {
        Algorithm algorithm = Algorithm.HMAC256(KEY);
        try {
            return JWT.create()
                    .withIssuer(ISSUER)
                    .withClaim("username", username)
                    .withClaim("id", userId)
                    .withExpiresAt(new Date(System.currentTimeMillis() + 1800000))
                    .sign(algorithm);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static DecodedJWT verify(String token) {
        if (token == null || token.isEmpty()) {
            return null;
        }

        try {
            Algorithm algorithm = Algorithm.HMAC256(KEY);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer(ISSUER)
                    .build();
            return verifier.verify(token);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static int getUserId(DecodedJWT decodedJWT) {
        return decodedJWT.getClaim("id").asInt();
    }
}
