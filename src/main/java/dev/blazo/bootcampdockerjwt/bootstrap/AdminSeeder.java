package dev.blazo.bootcampdockerjwt.bootstrap;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import dev.blazo.bootcampdockerjwt.dtos.RegisterUserDto;
import dev.blazo.bootcampdockerjwt.entities.Role;
import dev.blazo.bootcampdockerjwt.entities.RoleEnum;
import dev.blazo.bootcampdockerjwt.entities.User;
import dev.blazo.bootcampdockerjwt.repositories.RoleRepository;
import dev.blazo.bootcampdockerjwt.repositories.UserRepository;

@Component
public class AdminSeeder implements ApplicationListener<ContextRefreshedEvent> {

    @Value("${app.admin.name}")
    private String adminName;

    @Value("${app.admin.lastName}")
    private String adminLastName;

    @Value("${app.admin.email}")
    private String adminEmail;

    @Value("${app.admin.password}")
    private String adminPassword;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        this.seedAdmin();
    }

    private void seedAdmin() {
        RegisterUserDto registerUser = new RegisterUserDto();

        registerUser.setName(adminName);
        registerUser.setLastName(adminLastName);
        registerUser.setEmail(adminEmail);
        registerUser.setPassword(adminPassword);

        Optional<User> optionalUser = userRepository.findByEmail(registerUser.getEmail());
        Optional<Role> optionalRole = roleRepository.findByName(RoleEnum.SUPER_ADMIN);

        if (optionalUser.isPresent())
            return;

        if (optionalRole.isEmpty())
            throw new RuntimeException("Role super admin not found");

        User user = new User();
        user.setName(registerUser.getName());
        user.setLastName(registerUser.getLastName());
        user.setEmail(registerUser.getEmail());
        user.setPassword(passwordEncoder.encode(registerUser.getPassword()));
        user.setRole(optionalRole.get());

        userRepository.save(user);

    }

}
