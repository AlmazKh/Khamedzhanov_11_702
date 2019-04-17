package ru.itis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.models.Auth;
import ru.itis.models.User;

import java.util.Optional;

public interface AuthRepository extends JpaRepository<Auth, Long> {

    Optional<Auth> findByCookieValue(String cookieValue);
    Optional<User> findUserByCookieValue (String cookieValue);
}
