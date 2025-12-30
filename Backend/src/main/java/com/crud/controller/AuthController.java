package com.crud.controller;

import com.crud.confg.JwtUtil;
import com.crud.dto.LoginDto;
import com.crud.dto.OtpRequest;
import com.crud.entity.User;
import com.crud.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDto request) {
        return ResponseEntity.ok(authService.login(request.getEmail(), request.getPassword()));
    }

    // Step 2: Verify OTP -> Return JWT
    @PostMapping("/verify-otp")
    public ResponseEntity<?> verifyOtp(@RequestBody OtpRequest dto) {
        try {
            User user = authService.verifyOtp(dto.getEmail(), dto.getOtp());

                String token = jwtUtil.generateToken(dto.getEmail(), user.getRole().name());
                return ResponseEntity.ok(Map.of(
                        "message", "Login successful ✅",
                        "userId", user.getUserId(),
                        "userName", user.getUserName(),
                        "email", user.getEmail(),
                        "role", user.getRole().name(),
                        "token", token

                ));
               } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }

    }

    }





