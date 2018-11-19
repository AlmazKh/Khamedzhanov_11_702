package ru.itis.services;

import ru.itis.forms.BasketForm;
import ru.itis.forms.ProductForm;
import ru.itis.models.Basket;

public interface BasketService {
    void addBasket(BasketForm basketForm);
    void addProduct(ProductForm productForm);

}
