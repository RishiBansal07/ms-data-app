package com.assignment.controller;

import com.assignment.dto.AddressDTO;
import com.assignment.services.UsersServiceImpl;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/secured/users")
@SecurityRequirement(name = "appdata")
public class AdminUserController {

    private final UsersServiceImpl usersServiceImpl;

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateAddress(@PathVariable Long id, @RequestBody AddressDTO addressDTO) {
        usersServiceImpl.updateUserAddress(id, addressDTO);
    }
}
