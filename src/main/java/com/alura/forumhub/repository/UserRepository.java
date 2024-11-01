package com.alura.forumhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import com.alura.forumhub.domain.user.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    UserDetails findByUsername(String username);
    Optional<User> findUserByUsername(String username);
}
