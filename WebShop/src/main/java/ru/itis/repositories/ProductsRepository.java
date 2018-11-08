package ru.itis.repositories;

import ru.itis.models.Product;

public interface ProductsRepository extends CrudRepository<Product> {
    Product findByName(String name);
}
