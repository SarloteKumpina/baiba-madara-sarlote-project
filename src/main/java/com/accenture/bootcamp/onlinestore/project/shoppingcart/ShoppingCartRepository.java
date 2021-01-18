package com.accenture.bootcamp.onlinestore.project.shoppingcart;

import com.accenture.bootcamp.onlinestore.project.products.Product;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ShoppingCartRepository implements ShoppingCartMapper {

    private final ShoppingCartMapper shoppingCartMapper;

    public ShoppingCartRepository(ShoppingCartMapper shoppingCartMapper) {
        this.shoppingCartMapper = shoppingCartMapper;
    }

    //1. get all orders_products
    @Override
    public List<Product> findAllOrdersProducts() {
        List<Product> products = shoppingCartMapper.findAllOrdersProducts();
        return products;
    }

    //2. get all products in pending (=1) status
    public List<Product> getProductsPending() {
        List<Product> products = shoppingCartMapper.getProductsPending();
        return products;
    }

    //3. get all products of one order in pending (=1) status
    @Override
    public List<Product> getProductsForOrderPending(Long id) {
        List<Product> products = shoppingCartMapper.getProductsForOrderPending(id);
        return products;
    }


    //nospiežot add to cart -> vai jau ir šāds cepums (meklē pēc id, cepums glabājas orders tabulā)
    //ja nav - jauns order db ar statusu pending un orders_products samapo order id ar prod id
    //ja ir - orders_products samapo order id ar prod id
    //ievietojam produktu orders_products un mīnus 1 produkts products stock

    //ievietojam produktu orders_products
    @Override
    public ShoppingCart create(ShoppingCart cart) {
        return null;
    }

    //dzēšam produktu no shopping cart - pagaidām netaisām
    @Override
    public void delete(Long productId) {

    }

    //aprēķinām product total ar sql query - cena reiz skaits - pagaidām netaisām
    @Override
    public Long calculateTotal(Long total) {
        total = shoppingCartMapper.calculateTotal(total);
        return total;
    }

    @Override
    public List<ShoppingCart> getProductsForOrderStatusShoppingCart(Long id) {
        List<ShoppingCart> products = shoppingCartMapper.getProductsForOrderStatusShoppingCart(id);
        return products;
    }

    //aprēķinām grand total

    //mainām produktu skaitu un update shopping cart - pagaidām netaisām

//pēc Checkout nospiešanas mainās statuss uz ?
//grozā preces vairs nevar pievienot
}
