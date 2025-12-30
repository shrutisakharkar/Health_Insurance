package com.crud.confg;

import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class JwtUtil {

    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final int TOKEN_LENGTH = 8;
    private final SecureRandom random = new SecureRandom();

    // In-memory storage for demo (better: Redis/DB)
    private final Map<String, String> tokenStore = new ConcurrentHashMap<>();

    //  Generate 8-char token
    public String generateToken(String email, String role) {
        StringBuilder token = new StringBuilder(TOKEN_LENGTH);
        for (int i = 0; i < TOKEN_LENGTH; i++) {
            token.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        }
        String finalToken = token.toString();
        tokenStore.put(email, finalToken); // store for validation
        return finalToken;
    }

    //  Extract email from token
    public String extractEmail(String token) {
        return tokenStore.entrySet()
                .stream()
                .filter(entry -> entry.getValue().equals(token))
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
    }

    //  Check if token is valid (length + chars + stored)
    public boolean validateToken(String token, String email) {
        if (token == null || token.length() != TOKEN_LENGTH) {
            return false;
        }

        // check only alphanumeric
        if (!token.matches("^[A-Za-z0-9]+$")) {
            return false;
        }

        // check against stored token
        return tokenStore.containsKey(email) && tokenStore.get(email).equals(token);
    }
}
