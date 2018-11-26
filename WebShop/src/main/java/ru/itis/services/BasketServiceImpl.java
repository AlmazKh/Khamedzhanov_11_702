package ru.itis.services;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.itis.forms.BasketForm;
import ru.itis.forms.ProductForm;
import ru.itis.models.Basket;
import ru.itis.models.Product;
import ru.itis.repositories.AuthRepository;
import ru.itis.repositories.BasketRepository;

import java.util.List;

public class BasketServiceImpl implements BasketService {

    private PasswordEncoder encoder;
    private BasketRepository basketRepository;
    private AuthRepository authRepository;

    public BasketServiceImpl(BasketRepository basketRepository, AuthRepository authRepository) {
        this.basketRepository = basketRepository;
        this.authRepository = authRepository;
        this.encoder = new BCryptPasswordEncoder();
    }

    @Override
    public void addBasket(Long userId, Long productId) {
        basketRepository.addBasket(userId, productId);
    }

    @Override
    public void addProduct(Long userId, Long productId) {
        basketRepository.addProduct(userId, productId);
    }

    @Override
    public List<Product> getProductsByUserId(Long userId) {
        return basketRepository.getProductsByUserId(userId);
    }
}
