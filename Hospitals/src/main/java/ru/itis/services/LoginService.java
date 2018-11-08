package ru.itis.services;

import ru.itis.form.LoginForm;

import java.util.Optional;

public interface LoginService {
    Optional<String> login(LoginForm loginForm);
    boolean isExistByCookie(String cookieValue);
}
