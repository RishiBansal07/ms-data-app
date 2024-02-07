package com.assignment.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Address {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String streetName;

    @NotNull
    private String zipCode;

    @NotNull
    private String houseNumber;

    @NotNull
    private String city;

    @NotNull
    private String country;

}
