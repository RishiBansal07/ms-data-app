package com.assignment.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PetDTO {

    @NotNull(message = "The field \"name\" is required")
    private String name;

    @NotNull(message = "The field \"age\" is required")
    private String age;

}
