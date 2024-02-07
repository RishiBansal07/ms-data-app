package com.assignment.service;

import com.assignment.dto.AddressDTO;
import com.assignment.dto.UsersDTO;
import com.assignment.entity.Address;
import com.assignment.entity.Users;
import com.assignment.services.UsersService;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.data.jpa.domain.Specification;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class UsersServiceImplTest {

    Specification<Users> mockSpec;
    @Mock(extraInterfaces = Serializable.class)
    Root<Users> root;
    @Mock(extraInterfaces = Serializable.class)
    CriteriaQuery<?> query;
    @Mock(extraInterfaces = Serializable.class)
    CriteriaBuilder builder;
    @Mock(extraInterfaces = Serializable.class)
    Predicate predicate;

    private final UsersService usersService = mock(UsersService.class);

    @BeforeEach
    void setUp() {
        mockSpec = (Specification<Users>) mock(Specification.class, withSettings().serializable());
        when(mockSpec.toPredicate(root, query, builder)).thenReturn(predicate);
    }

    @Test
    void listOfUsersTest() {
        List<Users> usersOut = new ArrayList<>();
        Users users = new Users();
        users.setId(1L);
        usersOut.add(users);
        users = new Users();
        users.setId(2L);
        usersOut.add(users);
        when(usersService.getListOfUsers()).thenReturn(usersOut);

        //then
        List<Users> listOfUsers = usersService.getListOfUsers();

        //when
        assertEquals(2, listOfUsers.size());
    }

    @Test
    void getUserByIdTest() {
        Users user = new Users();
        user.setId(1L);
        when(usersService.getUserByID(1L)).thenReturn(user);

        //then
        Users userOut = usersService.getUserByID(1L);

        //when
        assertEquals(1, userOut.getId());
    }

    @Test
    void saveUserTest(){
        UsersDTO userDTO = new UsersDTO();
        userDTO.setDateOfBirth("28/06/1993");
        userDTO.setFirstName("Yash");
        userDTO.setLastName("Dun");
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setCity("Amsterdam");
        addressDTO.setCountry("NL");
        addressDTO.setZipCode("1024VH");
        addressDTO.setStreetName("Duinluststratt");
        userDTO.setAddressDTO(addressDTO);

        usersService.saveUser(userDTO);
        verify(usersService, times(1)).saveUser(userDTO);
    }

    @Test
    void searchByFirstAndOrLastNameTest(){
        List<Users> usersOut = new ArrayList<>();
        Users users = new Users();
        users.setId(1L);
        users.setDateOfBirth("28/06/1993");
        users.setFirstName("Yash");
        users.setLastName("Dun");
        Address address = new Address();
        address.setHouseNumber("9");
        address.setCity("Amsterdam");
        address.setCountry("NL");
        address.setZipCode("1024VH");
        address.setStreetName("Duinluststratt");
        users.setAddress(address);
        usersOut.add(users);

        when(usersService.searchByFirstAndOrLastName("Yash",null)).thenReturn(usersOut);

        //then
        List<Users> userResult = usersService.searchByFirstAndOrLastName("Yash", null);

        //when
        assertEquals(1, userResult.size());
    }

}
