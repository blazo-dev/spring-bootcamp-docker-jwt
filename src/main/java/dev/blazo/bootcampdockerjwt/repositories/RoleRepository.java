package dev.blazo.bootcampdockerjwt.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.blazo.bootcampdockerjwt.entities.Role;
import dev.blazo.bootcampdockerjwt.entities.RoleEnum;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleEnum name);
}
