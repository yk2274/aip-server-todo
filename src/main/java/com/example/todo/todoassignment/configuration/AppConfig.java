package com.example.todo.todoassignment.configuration;

import com.example.todo.todoassignment.entity.Task;
import com.example.todo.todoassignment.repository.TaskRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Configuration
public class AppConfig {
    @Bean
    CommandLineRunner commandLineRunner(TaskRepository taskRepository) {
        return args -> {
          List<Task> tasks = List.of(
                  Task.builder()
                          .title("Test task 1")
                          .category("Testing")
                          .description("This is testing 1")
                          .dueDate(LocalDate.now().plus(Period.ofDays(1)))
                          .dateCreated(LocalDate.now())
                          .dateModified(LocalDate.now())
                          .isDelete(false)
                          .build(),
                  Task.builder()
                          .title("Test task 2")
                          .category("Testing")
                          .description("Testing 2 is on the way")
                          .dueDate(LocalDate.now().plus(Period.ofDays(1)))
                          .dateCreated(LocalDate.now())
                          .dateModified(LocalDate.now())
                          .isDelete(false)
                          .build(),
                  Task.builder()
                          .title("Test task 3")
                          .category("Testing")
                          .description("Echo bravo charlies")
                          .dueDate(LocalDate.now().plus(Period.ofDays(1)))
                          .dateCreated(LocalDate.now())
                          .dateModified(LocalDate.now())
                          .isDelete(true)
                          .build(),
                  Task.builder()
                          .title("Test task 4")
                          .category("Testing")
                          .description("Echo bravo charlies")
                          .dueDate(LocalDate.now().plus(Period.ofDays(1)))
                          .dateCreated(LocalDate.now())
                          .dateModified(LocalDate.now())
                          .isDelete(true)
                          .build()
          );
          taskRepository.saveAll(tasks);

        };
    }
}
