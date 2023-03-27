package com.example.todo.todoassignment.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 250, nullable = false)
    private String title;

    @Column(length = 2000)
    private String category;

    @Column(length = 2000)
    private String description;

    private LocalDate dueDate;

    @CreationTimestamp
    private LocalDate dateCreated;

    @UpdateTimestamp
    private LocalDate dateModified;

    @NotNull
    private Boolean isDelete;
}
