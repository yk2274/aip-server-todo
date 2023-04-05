package com.example.todo.todoassignment.security.Controller;

import com.example.todo.todoassignment.security.Entity.AuthenticationRequest;
import com.example.todo.todoassignment.security.Entity.AuthenticationResponse;
import com.example.todo.todoassignment.security.Service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class UserController {
    private final AuthService authService;

    @PostMapping
    public ResponseEntity<AuthenticationResponse> authenticate (@RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(authService.authenticate(request));
    }

}
