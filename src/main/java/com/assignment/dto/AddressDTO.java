package com.assignment.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AddressDTO {

    @NotNull(message = "The field \"streetName\" is required")
    private String streetName;

    @NotNull(message = "The field \"zipCode\" is required")
    private String zipCode;

    @NotNull(message = "The field \"houseNumber\" is required")
    private String houseNumber;

    @NotNull(message = "The field \"city\" is required")
    private String city;

    @NotNull(message = "The field \"country\" is required")
    private String country;
}
