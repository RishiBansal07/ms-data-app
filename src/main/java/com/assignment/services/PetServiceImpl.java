package com.assignment.services;

import com.assignment.dto.PetDTO;
import com.assignment.entity.Pet;
import com.assignment.mapper.DataMapper;
import com.assignment.repository.PetRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PetServiceImpl implements PetService{

    private final PetRepository petRepository;
    private final DataMapper dataMapper;

    @Override
    public List<Pet> getListOfPet() {
        return petRepository.findAll();
    }

    @Override
    public void savePet(PetDTO petDTO) {
        Pet pet = dataMapper.convertToPetEntity(petDTO);
        petRepository.save(pet);
    }

    @Override
    public Pet getPetByID(Long id) {
        return petRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(String.format("Pet not found with id: %s", id)));
    }

    @Override
    public void updatePetDetails(Long id, PetDTO petDTO) {
        getPetByID(id);
        Pet pet = dataMapper.convertToPetEntity(petDTO);
        petRepository.save(pet);
    }
}
