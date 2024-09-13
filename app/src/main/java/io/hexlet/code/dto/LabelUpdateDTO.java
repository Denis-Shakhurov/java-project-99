package io.hexlet.code.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.openapitools.jackson.nullable.JsonNullable;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LabelUpdateDTO {

    @NotNull
    @Size(min = 1, max = 1000)
    private JsonNullable<String> name;
}
