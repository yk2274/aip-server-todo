package com.example.todo.todoassignment.controller;

import com.example.todo.todoassignment.dto.TaskDto;
import com.example.todo.todoassignment.service.TaskService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "tasks")
@Data
@AllArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @GetMapping
    public List<TaskDto> getTasks() {
        return taskService.getTasks();
    }

    @PostMapping
    public TaskDto addTask(@Valid @RequestBody TaskDto task) {
        return taskService.addTask(task);
    }

    @PutMapping
    public TaskDto updateTask(@Valid @RequestBody TaskDto task,
                              @RequestParam("taskId") Long taskId) {
        return taskService.updateTask(task, taskId);
    }

    @DeleteMapping
    public TaskDto deleteTask(@RequestParam("taskId") Long taskId) {
        return taskService.deleteTask(taskId);
    }

}
