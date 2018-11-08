package ru.itis.services;

import ru.itis.forms.ProductForm;
import ru.itis.models.Product;

import java.util.List;

public interface ProductsService {
    void addProduct(ProductForm productForm);
    List<Product> getProducts();
}
