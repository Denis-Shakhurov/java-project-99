package io.hexlet.code.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserCreateDTO {

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @Email
    private String email;

    private String password;

}
