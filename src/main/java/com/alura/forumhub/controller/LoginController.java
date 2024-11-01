package com.alura.forumhub.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alura.forumhub.domain.user.User;
import com.alura.forumhub.infra.security.auth.LoginRequest;
import com.alura.forumhub.infra.security.auth.LoginResponse;
import com.alura.forumhub.infra.security.auth.TokenService;

@RestController
@RequestMapping("/login")
public class LoginController {

    private final AuthenticationManager manager;
    private final TokenService tokenService;

    public LoginController(AuthenticationManager manager, TokenService tokenService) {
        this.manager = manager;
        this.tokenService = tokenService;
    }

    @PostMapping
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        var authentication = manager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.username(), loginRequest.password()));
        User user = (User) authentication.getPrincipal();
        String token = tokenService.generateToken(user);
        return ResponseEntity.ok(new LoginResponse("Bearer", token));
    }
}
