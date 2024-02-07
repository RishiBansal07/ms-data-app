package com.assignment.dataprovider;

import com.assignment.entity.Address;
import com.assignment.entity.Users;

import java.util.List;

public class DataProvider {

    public static List<Users> getUsersDetails() {
        return List.of(Users.builder()
                .id(1L).firstName("some-first-name")
                .lastName("some-last-name")
                .dateOfBirth("07/11/1999")
                .address(Address.builder().country("some-country")
                        .houseNumber("1")
                        .city("some-city")
                        .streetName("some-street")
                        .zipCode("11111")
                        .build())
                .build());
    }
}
