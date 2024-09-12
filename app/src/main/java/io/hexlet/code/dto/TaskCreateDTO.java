package io.hexlet.code.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    private String title;

    private int index;

    private String content;

    @NotNull
    private String status;

    @JsonProperty("assignee_id")
    private Long assigneeId;
}
