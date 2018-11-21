//package ru.itis.services;
//
//import ru.itis.forms.BasketForm;
//import ru.itis.forms.ProductForm;
//import ru.itis.models.Basket;
//import ru.itis.repositories.BasketRepository;
//
//public class BasketServiceImpl implements BasketService {
//
//    BasketRepository basketRepository;
//
//    @Override
//    public void addBasket(BasketForm basketForm) {
//        Basket basket = Basket.builder()
//                .owner(basketForm.getOwner())
//                .build();
//        basketRepository.save(basket);
//    }
//
//    @Override
//    public void addProduct(ProductForm productForm) {
//
//
//    }
//}
