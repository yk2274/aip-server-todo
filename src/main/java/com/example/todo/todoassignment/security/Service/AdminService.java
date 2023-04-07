package com.example.todo.todoassignment.security.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    public List<String> getUsers() {
        return List.of("1. user", "2. admin");
    }
}
