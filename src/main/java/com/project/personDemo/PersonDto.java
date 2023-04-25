package com.project.personDemo;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class PersonDto implements Serializable {
    private final Integer id;
    @NotNull
    private final String firstName;
    @NotNull
    private final String lastName;
    @NotNull
    private final LocalDate birthDate;
}