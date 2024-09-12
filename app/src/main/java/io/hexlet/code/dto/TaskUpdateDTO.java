package io.hexlet.code.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.openapitools.jackson.nullable.JsonNullable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaskUpdateDTO {
    @NotNull
    @Size(min = 1)
    private JsonNullable<String> name;

    private JsonNullable<Integer> index;

    private JsonNullable<String> description;

    @NotNull
    private JsonNullable<String> taskStatusSlug;

    private JsonNullable<Long> assigneeId;
}
