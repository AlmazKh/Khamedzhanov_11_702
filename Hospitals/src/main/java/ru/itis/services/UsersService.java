package ru.itis.services;

import ru.itis.form.UserForm;
import ru.itis.models.User;

import java.net.URL;

public interface UsersService {
    void signUp(UserForm userForm);
}
