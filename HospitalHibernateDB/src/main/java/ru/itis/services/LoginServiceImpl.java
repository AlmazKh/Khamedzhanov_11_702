package ru.itis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.forms.LoginForm;
import ru.itis.models.Auth;
import ru.itis.models.User;
import ru.itis.repositories.AuthRepository;
import ru.itis.repositories.UsersRepository;

import java.util.Optional;
import java.util.UUID;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private AuthRepository authRepository;
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private PasswordEncoder encoder;

    @Override
    public Optional<String> login(LoginForm loginForm) {
        User user = usersRepository.findUserByPhone(loginForm.getPhone());
        if (user != null && encoder.matches(loginForm.getPassword(), user.getHashPassword())) {
            String cookieValue = UUID.randomUUID().toString();
            Auth auth = Auth.builder()
                    .user(user)
                    .cookieValue(cookieValue)
                    .build();
            authRepository.save(auth);

            return Optional.of(cookieValue);
        } else return Optional.empty();
    }

    @Override
    public boolean isExistByCookie(String cookieValue) {
        return authRepository.findByCookieValue(cookieValue).isPresent();
    }

    @Override
    public User getIdByCookie(String cookieValue) {
        return authRepository.findUserByCookieValue(cookieValue).get();
    }
}
