package dev.blazo.bootcampdockerjwt.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import dev.blazo.bootcampdockerjwt.dtos.LoginUserDto;
import dev.blazo.bootcampdockerjwt.dtos.RegisterUserDto;
import dev.blazo.bootcampdockerjwt.entities.Role;
import dev.blazo.bootcampdockerjwt.entities.RoleEnum;
import dev.blazo.bootcampdockerjwt.entities.User;
import dev.blazo.bootcampdockerjwt.repositories.RoleRepository;
import dev.blazo.bootcampdockerjwt.repositories.UserRepository;

@Service
public class AuthenticationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    public User signup(RegisterUserDto registerUser) {
        Optional<Role> role = roleRepository.findByName(RoleEnum.USER);

        if (role.isEmpty()) {
            throw new RuntimeException("Role user not found");
        }

        User user = new User();
        user.setName(registerUser.getName());
        user.setLastName(registerUser.getLastName());
        user.setEmail(registerUser.getEmail());
        user.setPassword(passwordEncoder.encode(registerUser.getPassword()));
        user.setRole(role.get());

        return userRepository.save(user);
    }

    public User signin(LoginUserDto loginUser) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginUser.getEmail(),
                        loginUser.getPassword()));

        return userRepository.findByEmail(loginUser.getEmail())
                .orElseThrow();
    }
}
