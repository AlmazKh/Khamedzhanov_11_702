package ru.itis.repositories;

import ru.itis.models.Basket;
import ru.itis.models.Product;

import java.util.List;

public interface BasketRepository extends CrudRepository<Basket> {
    List<Product> findProductsByName(String name);
}
