package com.example.todo.todoassignment.service;

import com.example.todo.todoassignment.dto.TaskDto;
import com.example.todo.todoassignment.entity.Task;
import com.example.todo.todoassignment.repository.TaskRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Data
@AllArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;
    private final ModelMapper modelMapper;

    public Task dtoToEntity(TaskDto taskDto) {
        Task task = modelMapper.map(taskDto, Task.class);
        if (!StringUtils.isBlank(taskDto.getDueDate())) {
            LocalDate dueDate = LocalDate.parse(taskDto.getDueDate());
            task.setDueDate(dueDate);
        }
        return task;
    }

    public TaskDto entityToDto(Task task) {
        TaskDto taskDto = modelMapper.map(task, TaskDto.class);
        if (task.getDueDate() != null) {
            String dueDate = (task.getDueDate()).toString();
            taskDto.setDueDate(dueDate);
        }
        return modelMapper.map(task, TaskDto.class);
    }

    public Task checkTask(Long taskId) {
        Task existingTask = taskRepository.findById(taskId).orElseThrow(() ->
                new IllegalArgumentException("Task Id:" + taskId + " doesn't exist"));
        return existingTask;
    }

    public List<TaskDto> getTasks() {
        return taskRepository.findAll().stream()
                .filter(task -> task.getIsDelete() == false)
                .map(this::entityToDto)
                .collect(Collectors.toList());
    }

    public TaskDto addTask(TaskDto taskDto) {
        Task taskEntity = dtoToEntity(taskDto);
        return entityToDto(taskRepository.save(taskEntity));
    }

    public TaskDto updateTask(TaskDto taskDto, Long taskId) {
        Task existingTask = checkTask(taskId);
        existingTask.setTitle(taskDto.getTitle());
        existingTask.setCategory(taskDto.getCategory());
        existingTask.setDescription(taskDto.getDescription());
        LocalDate dueDate = LocalDate.parse(taskDto.getDueDate());
        existingTask.setDueDate(dueDate);
        return entityToDto(taskRepository.save(existingTask));
    }

    public TaskDto deleteTask(Long taskId) {
        Task existingTask = checkTask(taskId);
        existingTask.setIsDelete(Boolean.TRUE);
        return entityToDto(taskRepository.save(existingTask));
    }
}
