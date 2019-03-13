package ru.itis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.itis.form.UserForm;
import ru.itis.models.User;
import ru.itis.repositories.UsersRepository;
import ru.itis.services.UsersService;

import java.util.List;

public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersRepository usersRepository;

    private PasswordEncoder passwordEncoder;

    public UsersServiceImpl() {
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    public void signUp(UserForm userForm) {
        User newUser = User.builder()
                .firstName(userForm.getFirstName())
                .lastName(userForm.getLastName())
                .gender(userForm.getGender())
                .phone(userForm.getPhone())
                .hashPassword(passwordEncoder.encode(userForm.getPassword()))
                .build();
        usersRepository.save(newUser);
    }

    @Override
    public List<User> getUsers() {
        return usersRepository.findAll();
    }
}
