package ru.itis.services;

import ru.itis.forms.UserForm;
import ru.itis.models.User;
import java.util.List;


public interface UsersService {
    void addUser(UserForm userForm);
    List<User> getUsers();
}
