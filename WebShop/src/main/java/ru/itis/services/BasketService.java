package ru.itis.services;

import ru.itis.forms.BasketForm;
import ru.itis.forms.ProductForm;
import ru.itis.models.Basket;
import ru.itis.models.Product;

import java.util.List;

public interface BasketService {
    void addBasket(Long userId, Long productId);
    void addProduct(Long userId, Long productId);
    void deleteProduct(Long userId, Long productId);
    List<Product> getProductsByUserId(Long userId);
}
