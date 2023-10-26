package dev.blazo.bootcampdockerjwt.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import dev.blazo.bootcampdockerjwt.dtos.RegisterUserDto;
import dev.blazo.bootcampdockerjwt.entities.Role;
import dev.blazo.bootcampdockerjwt.entities.RoleEnum;
import dev.blazo.bootcampdockerjwt.entities.User;
import dev.blazo.bootcampdockerjwt.repositories.RoleRepository;
import dev.blazo.bootcampdockerjwt.repositories.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;


    public User authenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        return (User) authentication.getPrincipal();
    }

    public List<User> allUsers() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);

        return users;
    }

    public User createAdmin(RegisterUserDto registerUser) {
        Optional<Role> role = roleRepository.findByName(RoleEnum.ADMIN);

        if (role.isEmpty()) {
            throw new RuntimeException("Role admin not found");
        }

        User user = new User();
        user.setName(registerUser.getName());
        user.setLastName(registerUser.getLastName());
        user.setEmail(registerUser.getEmail());
        user.setPassword(passwordEncoder.encode(registerUser.getPassword()));
        user.setRole(role.get());

        return userRepository.save(user);
    }
}
