package ru.itis.repositories;

import ru.itis.models.Basket;
import ru.itis.models.Product;

public interface BasketRepository extends CrudRepository<Basket> {
    Basket findByName(String name);
}
