package ru.itis.repositories;

import ru.itis.models.Auth;
import ru.itis.models.User;

import java.util.Optional;

public interface AuthRepository extends CrudRepository<Auth> {
    Optional<Auth> findByCookieValue(String cookieValue);
    Optional<User> findOneByCookie(String cookieValue);

}
