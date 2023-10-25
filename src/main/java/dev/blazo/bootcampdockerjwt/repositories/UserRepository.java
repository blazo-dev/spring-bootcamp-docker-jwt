package dev.blazo.bootcampdockerjwt.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.blazo.bootcampdockerjwt.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
