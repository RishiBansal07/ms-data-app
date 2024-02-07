package com.assignment.services;

import com.assignment.dto.AddressDTO;
import com.assignment.dto.UsersDTO;
import com.assignment.entity.Users;

import java.util.List;

public interface UsersService {

   Users getUserByID(Long id);

   void saveUser(UsersDTO usersDTO);

    List<Users> searchByFirstAndOrLastName(String firstName, String lastName);

    void updateUserAddress(Long id, AddressDTO addressDTO);

    List<Users> getListOfUsers();
}
