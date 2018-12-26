package ru.itis.services;

import ru.itis.form.LoginForm;
import ru.itis.models.User;

import java.util.Optional;

public interface LoginService {

    Optional<String> login(LoginForm loginForm);
    boolean isExistByCookie(String cookieValue);
    User getIdByCookie(String cookieValue);
}
