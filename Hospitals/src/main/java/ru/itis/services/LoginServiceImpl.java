package ru.itis.services;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ru.itis.form.LoginForm;
import ru.itis.models.Auth;
import ru.itis.models.User;
import ru.itis.repositories.AuthRepository;
import ru.itis.repositories.UsersRepository;

import java.util.Optional;
import java.util.UUID;

public class LoginServiceImpl implements LoginService {

    private AuthRepository authRepository;

    private UsersRepository usersRepository;

    private BCryptPasswordEncoder encoder;

    public LoginServiceImpl(AuthRepository authRepository, UsersRepository usersRepository) {
        this.authRepository = authRepository;
        this.usersRepository = usersRepository;
        this.encoder = new BCryptPasswordEncoder();
    }

    @Override
    public Optional<String> login(LoginForm loginForm) {
        User user = usersRepository.findByPhone(loginForm.getPhone());
        if (user != null && encoder.matches(loginForm.getPassword(), user.getHashPassword())) {
            String cookieValue = UUID.randomUUID().toString();
            Auth auth = Auth.builder()
                    .cookieValue(cookieValue)
                    .user(user)
                    .build();
            authRepository.save(auth);

            return Optional.of(cookieValue);
        } else return Optional.empty();
    }

    @Override
    public boolean isExistByCookie(String cookieValue) {
        return authRepository.findByCookieValue(cookieValue).isPresent();
    }
}
