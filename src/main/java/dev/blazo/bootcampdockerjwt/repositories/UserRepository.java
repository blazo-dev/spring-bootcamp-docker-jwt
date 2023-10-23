package dev.blazo.bootcampdockerjwt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.blazo.bootcampdockerjwt.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
}
