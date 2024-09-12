package io.hexlet.code.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaskCreateDTO {
    @NotNull
    @Size(min = 1)
    private String name;

    private int index;

    private String description;

    @NotNull
    private String taskStatusSlug;

    private Long assigneeId;
}
