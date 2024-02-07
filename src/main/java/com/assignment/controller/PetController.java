package com.assignment.controller;

import com.assignment.dto.PetDTO;
import com.assignment.entity.Pet;
import com.assignment.services.PetServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/public/pet")
@RequiredArgsConstructor
public class PetController {

    private final PetServiceImpl petService;

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<Pet> findAllPets () {
        return petService.getListOfPet();
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveAPet (@Valid @RequestBody PetDTO petDTO) {
        petService.savePet(petDTO);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateAPet(@PathVariable Long id, @RequestBody
    PetDTO petDTO) {
        petService.updatePetDetails(id, petDTO);
    }

}
