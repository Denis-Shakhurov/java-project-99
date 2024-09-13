package io.hexlet.code.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Getter
public class TaskDTO {

    private Long id;

    private String title;

    private int index;

    private String content;

    @JsonProperty("status")
    private String slug;

    @JsonProperty("assignee_id")
    private Long assigneeId;

    private List<Long> labelIds;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate createdAt;
}
