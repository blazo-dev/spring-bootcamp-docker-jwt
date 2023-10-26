package dev.blazo.bootcampdockerjwt.bootstrap;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import dev.blazo.bootcampdockerjwt.entities.Role;
import dev.blazo.bootcampdockerjwt.entities.RoleEnum;
import dev.blazo.bootcampdockerjwt.repositories.RoleRepository;

@Component
public class RoleSeeder implements ApplicationListener<ContextRefreshedEvent> {

    private Logger logger = LoggerFactory.getLogger(RoleSeeder.class);

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        this.seedRolesTable();
    }

    private void seedRolesTable() {
        // RoleEnum[] roles = RoleEnum.values();
        RoleEnum[] roleNames = { RoleEnum.USER, RoleEnum.ADMIN, RoleEnum.SUPER_ADMIN };

        Map<RoleEnum, String> rolesMap = Map.of(
                RoleEnum.USER, "Default user role",
                RoleEnum.ADMIN, "Admin role",
                RoleEnum.SUPER_ADMIN, "Super admin role");

        Arrays.stream(roleNames).forEach(roleName -> {
            Optional<Role> optionalRole = roleRepository.findByName(roleName);

            optionalRole.ifPresentOrElse(role -> logger.info(role.toString()), () -> {
                Role roleToCreate = new Role();

                roleToCreate.setName(roleName);
                roleToCreate.setDescription(rolesMap.get(roleName));

                roleRepository.save(roleToCreate);
            });
        });

    }

}
