package com.example.todo.todoassignment.security.Controller;

import com.example.todo.todoassignment.security.Service.AdminService;
import com.example.todo.todoassignment.security.Service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
    private final AdminService adminService;

    @GetMapping
    public ResponseEntity<List<String>> getUsers () {
        return ResponseEntity.ok(adminService.getUsers());
    }
}
