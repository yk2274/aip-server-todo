package com.example.todo.todoassignment.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.boot.context.properties.bind.DefaultValue;

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
    @Column
    private LocalDate dateCreated;

    @UpdateTimestamp
    @Column
    private LocalDate dateModified;

    @Column(nullable = false)
    private Boolean isDelete = false;
}
