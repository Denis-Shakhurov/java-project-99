package io.hexlet.code.model;

import lombok.Getter;
import jakarta.persistence.*;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private LocalDate createdAt;

    private LocalDate updateAt;
}