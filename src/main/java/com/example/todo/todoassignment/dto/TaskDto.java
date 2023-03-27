package com.example.todo.todoassignment.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaskDto {
    @JsonProperty
    private Long id;

    @NotBlank(message = "Title cannot be empty")
    @Size(max = 250, message = "Title too long (within 250 characters)")
    private String title;

    @Size(max = 2000, message = "Category too long (within 2000 characters)")
    private String category;

    @Size(max = 2000, message = "Description too long (within 2000 characters)")
    private String description;

    @JsonProperty
    private String dueDate;

    @JsonProperty
    private String dateCreated;

    @JsonProperty
    private String dateModified;

    @NotNull(message = "cannot be null")
    @JsonProperty
    private Boolean isDelete;

}
