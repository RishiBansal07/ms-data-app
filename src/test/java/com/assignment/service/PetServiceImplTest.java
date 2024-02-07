package com.assignment.service;

import com.assignment.dto.PetDTO;
import com.assignment.entity.Pet;
import com.assignment.services.PetService;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class PetServiceImplTest {

    private final PetService petService = mock(PetService.class);

    @Test
    void listOfPetsTest() {
        List<Pet> petList = new ArrayList<>();
        Pet pet = new Pet();
        pet.setId(1L);
        petList.add(pet);
        pet = new Pet();
        pet.setId(2L);
        petList.add(pet);
        when(petService.getListOfPet()).thenReturn(petList);

        //then
        List<Pet> listOfPets = petService.getListOfPet();

        //when
        assertEquals(2, listOfPets.size());
    }

    @Test
    void getPetByIdTest() {
        Pet pet = new Pet();
        pet.setId(1L);
        when(petService.getPetByID(1L)).thenReturn(pet);

        //then
        Pet petOut = petService.getPetByID(1L);

        //when
        assertEquals(1, petOut.getId());
    }

    @Test
    void savePetTest(){
        PetDTO petDTO = new PetDTO();
        petDTO.setAge("11");
        petDTO.setName("Tommy");

        petService.savePet(petDTO);
        verify(petService, times(1)).savePet(petDTO);
    }

}
