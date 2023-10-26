package dev.blazo.bootcampdockerjwt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.blazo.bootcampdockerjwt.dtos.RegisterUserDto;
import dev.blazo.bootcampdockerjwt.entities.User;
import dev.blazo.bootcampdockerjwt.services.UserService;

@RestController
@RequestMapping("/api/admins")
public class AdminController {

    @Autowired
    private UserService userService;

    @PostMapping
    @PreAuthorize("hasRole('SUPER_ADMIN')")
    public ResponseEntity<User> createAdmin(@RequestBody RegisterUserDto registerUser) {
        User createdAdmin = userService.createAdmin(registerUser);

        return ResponseEntity.ok(createdAdmin);
    }

}
