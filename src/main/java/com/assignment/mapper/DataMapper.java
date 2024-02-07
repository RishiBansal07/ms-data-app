package com.assignment.mapper;

import com.assignment.dto.AddressDTO;
import com.assignment.dto.PetDTO;
import com.assignment.dto.UsersDTO;
import com.assignment.entity.Address;
import com.assignment.entity.Pet;
import com.assignment.entity.Users;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DataMapper {

    UsersDTO convertToUsersDto(Users users);

    Users convertToUsersEntity(UsersDTO usersDTO);

    AddressDTO convertToAddressDto(Address address);

    Address convertToAddressEntity(AddressDTO addressDTO);

    Pet convertToPetEntity(PetDTO petDTO);

    PetDTO convertToPetDTO(Pet pet);
}
