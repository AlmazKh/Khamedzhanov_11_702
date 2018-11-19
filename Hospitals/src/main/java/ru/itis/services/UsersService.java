package ru.itis.services;

import ru.itis.form.UserForm;
import ru.itis.models.User;

import java.net.URL;
import java.util.List;

public interface UsersService {
    void addUser(UserForm userForm);
    void signUp(UserForm userForm);
    List<User> getUsers();
}
