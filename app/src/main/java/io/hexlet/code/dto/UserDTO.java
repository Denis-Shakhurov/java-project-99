package io.hexlet.code.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
public class UserDTO {
    private Long id;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @Email
    private String email;
    private LocalDate createdAt;
    private LocalDate updateAt;
}