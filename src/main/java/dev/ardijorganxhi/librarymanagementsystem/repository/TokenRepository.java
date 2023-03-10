package dev.ardijorganxhi.librarymanagementsystem.repository;

import dev.ardijorganxhi.librarymanagementsystem.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TokenRepository extends JpaRepository<Token, Long> {

    Optional<Token> findByToken(String token);


}
