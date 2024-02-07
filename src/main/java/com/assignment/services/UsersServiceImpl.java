package com.assignment.services;

import com.assignment.dto.AddressDTO;
import com.assignment.dto.UsersDTO;
import com.assignment.exceptions.NotFoundException;
import com.assignment.mapper.DataMapper;
import com.assignment.entity.Address;
import com.assignment.entity.Users;
import com.assignment.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService {

    private final UserRepository userRepository;
    private final DataMapper dataMapper;

    public List<Users> getListOfUsers() {
        return userRepository.findAll();
    }

    @Override
    public Users getUserByID(Long id) {
        return userRepository.findById(id).orElseThrow(
                () -> new NotFoundException(String.format("User not found with id: %s", id)));
    }

    @Override
    public void saveUser(UsersDTO usersDTO) {
        Users users = dataMapper.convertToUsersEntity(usersDTO);
        users.setAddress(dataMapper.convertToAddressEntity(usersDTO.getAddressDTO()));
        userRepository.save(users);
    }

    @Override
    public List<Users> searchByFirstAndOrLastName(String firstName, String lastName) {
        return userRepository.searchByFirstAndOrLastName(firstName, lastName);
    }

    @Override
    public void updateUserAddress(Long id, AddressDTO addressDTO) {
        Users users = getUserByID(id);
        Address address = dataMapper.convertToAddressEntity(addressDTO);
        Long addressId = users.getAddress().getId();
        address.setId(addressId);
        users.setAddress(address);
        userRepository.save(users);
    }
}
