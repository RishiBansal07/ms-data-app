package com.assignment.controller;

import com.assignment.dto.UsersDTO;
import com.assignment.entity.Users;
import com.assignment.services.UsersServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/public/users")
@RequiredArgsConstructor
public class UserController {

    private final UsersServiceImpl usersServiceImpl;

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<Users> listOfUsers() {
        return usersServiceImpl.getListOfUsers();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Users getUserByID(@PathVariable Long id) {
        return usersServiceImpl.getUserByID(id);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveUser(@Valid @RequestBody UsersDTO usersDTO) {
        usersServiceImpl.saveUser(usersDTO);
    }

    @GetMapping("/search")
    @ResponseStatus(HttpStatus.OK)
    public List<Users> searchByFirstNameAndOrLastName(@RequestParam(required = false) String firstName, @RequestParam(required = false) String lastName) {
        return usersServiceImpl.searchByFirstAndOrLastName(firstName, lastName);
    }


}
