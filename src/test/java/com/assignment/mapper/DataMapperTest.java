package com.assignment.mapper;

import com.assignment.dto.AddressDTO;
import com.assignment.dto.UsersDTO;
import com.assignment.entity.Address;
import com.assignment.entity.Users;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mapstruct.factory.Mappers.getMapper;

public class DataMapperTest {
    private DataMapper dataMapper = getMapper(DataMapper.class);

    @Test
    void convertToAddressDtoTest() {
        AddressDTO actual = dataMapper.convertToAddressDto(null);
        assertNull(actual);
    }

    @Test
    void convertToAddressEntityTest() {
        Address actual = dataMapper.convertToAddressEntity(null);
        assertNull(actual);
    }

    @Test
    void convertToUsersEntityTest() {
        Users actual = dataMapper.convertToUsersEntity(null);
        assertNull(actual);
    }

    @Test
    void convertToUsersDtoTest() {
        UsersDTO actual = dataMapper.convertToUsersDto(null);
        assertNull(actual);
    }
}
