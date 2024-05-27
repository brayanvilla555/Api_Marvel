package com.app.marvel.persistence.repository;

import com.app.marvel.persistence.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Repository
public interface UserRespository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);
}
