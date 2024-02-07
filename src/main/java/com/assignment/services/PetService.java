package com.assignment.services;

import com.assignment.dto.AddressDTO;
import com.assignment.dto.PetDTO;
import com.assignment.dto.UsersDTO;
import com.assignment.entity.Pet;
import com.assignment.entity.Users;

import java.util.List;

public interface PetService {
    void savePet(PetDTO petDTO);

    void updatePetDetails(Long id, PetDTO petDTO);

    List<Pet> getListOfPet();

    Pet getPetByID(Long id);
}
