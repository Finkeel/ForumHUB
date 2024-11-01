package com.alura.forumhub.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.alura.forumhub.domain.user.UserRequestDTO;
import com.alura.forumhub.domain.user.UserResponseDTO;
import com.alura.forumhub.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody @Valid UserRequestDTO request){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createUser(request));
    }

    @SecurityRequirement(name = "bearer-key")
    @GetMapping("{userId}")
    public ResponseEntity<UserResponseDTO> getUser(@PathVariable("userId") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.getUser(id));
    }
}
