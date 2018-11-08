package ru.itis.services;

import ru.itis.forms.ProductForm;
import ru.itis.models.Product;
import ru.itis.repositories.ProductsRepository;

import java.util.List;

public class ProductsServiceImpl implements ProductsService {

    private ProductsRepository productsRepository;

    public ProductsServiceImpl(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }
    @Override
    public void addProduct(ProductForm productForm) {
        Product product =Product.builder()
                .name(productForm.getName())
                .build();

        productsRepository.save(product);
    }

    @Override
    public List<Product> getProducts() {
        return productsRepository.findAll();
    }
}
