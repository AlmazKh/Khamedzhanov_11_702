package ru.itis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.forms.SignUpForm;
import ru.itis.models.User;
import ru.itis.models.UserState;
import ru.itis.repositories.UsersRepository;

import java.util.UUID;

@Service
public class SignUpServiceImpl implements SignUpService {
    @Autowired
    private EmailService emailService;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void signUp(SignUpForm userForm) {
        String confirmString = UUID.randomUUID().toString();

        User user = User.builder()
                .firstName(userForm.getFirstName())
                .lastName(userForm.getLastName())
                .gender(userForm.getGender())
                .phone(userForm.getPhone())
                .hashPassword(passwordEncoder.encode(userForm.getPassword()))
                .state(UserState.NOT_CONFIRMED)
                .confirmString(confirmString)
                .build();

        usersRepository.save(user);
        String text = "<a href='http://localhost:8080/confirm/" + user.getConfirmString() + "'>" +"Пройдите по ссылке" + "</a>";
        System.out.println(text);
        emailService.sendMail("Подтвреждение регистрации", text, user.getPhone());
    }
}
