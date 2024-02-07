package com.assignment.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class UsersDTO {

    @NotNull(message = "The field \"firstName\" is required")
    private String firstName;

    @NotNull(message = "The field \"lastName\" is required")
    private String lastName;

    @NotNull(message = "The field \"dateOfBirth\" is required")
    private String dateOfBirth;

    @NotNull(message = "The field \"addressDTO\" is required")
    private AddressDTO addressDTO;
}
