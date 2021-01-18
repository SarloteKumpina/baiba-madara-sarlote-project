package com.accenture.bootcamp.onlinestore.project.shoppingcart;

import com.accenture.bootcamp.onlinestore.project.products.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ShoppingCartMapper {

    //1. get all orders_products
    @Select("select products.imageUri, products.id, products.name, products.price, orders_products.quantity\n" +
            "from orders_products\n" +
            "inner join orders on orders_products.order_id = orders.id\n" +
            "inner join products on orders_products.product_id = products.id;\n")
    List<Product> findAllOrdersProducts();

    //2. get all products in pending (=1) status
    @Select("select products.imageUri, products.id, products.name, products.price, orders_products.quantity\n" +
            "from orders_products\n" +
            "inner join orders on orders_products.order_id = orders.id\n" +
            "inner join products on orders_products.product_id = products.id\n" +
            "inner join status on orders.status_id = status.id\n" +
            "where status.id = '1'")
    List<Product> getProductsPending();

    //3. get all products of one order in pending (=1) status
    @Select("select products.imageUri, products.id, products.name, products.price, orders_products.quantity\n" +
            "from orders_products\n" +
            "inner join orders on orders_products.order_id = orders.id\n" +
            "inner join products on orders_products.product_id = products.id\n" +
            "inner join status on orders.status_id = status.id\n" +
            "where status.id = '1' AND #{id} IS NULL OR (orders.id = #{id})")
    List<Product> getProductsForOrderPending(Long orderId);

    @Select("select products.imageUri, products.id, products.name, products.price, orders_products.quantity, " +
            "(products.price * orders_products.quantity) as total\n" +
            "from orders_products\n" +
            "inner join orders on orders_products.order_id = orders.id\n" +
            "inner join products on orders_products.product_id = products.id\n" +
            "inner join status on orders.status_id = status.id\n" +
            "where status.id = '4' AND #{id} IS NULL OR (orders.id = #{id})")
    List<ShoppingCart> getProductsForOrderStatusShoppingCart(Long orderId);


    //nospiežot add to cart -> vai jau ir šāds cepums (meklē pēc id, cepums glabājas orders tabulā)
    //ja nav - jauns order db ar statusu pending un orders_products samapo order id ar prod id
    //ja ir - orders_products samapo order id ar prod id
    //ievietojam produktu orders_products un mīnus 1 produkts products stock

    //ievietojam produktu orders_products
    @Options(useGeneratedKeys = true,
            keyProperty = "id",
            keyColumn = "id")
    @Insert("insert into orders_products(imageUri, id, name, price, quantity)" +
            "values(#{imageUri}, #{id}, #{name}, #{price}, #{quantity})")
    ShoppingCart create(ShoppingCart cart);

    //dzēšam produktu no shopping cart - pagaidām netaisām
    @Delete("delete from orders_products where id=#{id}")
    void delete(Long productId);

    //aprēķinām product total ar sql query - cena reiz skaits - pagaidām netaisām
    @Select("SELECT products.price, orders_products.quantity, (price * quantity)" +
            "FROM orders_products" +
            "INNER JOIN orders ON orders_products.order_id = orders.id" +
            "INNER JOIN products ON orders_products.product_id = products.id")
    Long calculateTotal(Long total);

    //aprēķinām grand total

    //mainām produktu skaitu un update shopping cart - pagaidām netaisām

//pēc Checkout nospiešanas mainās statuss uz ?
//grozā preces vairs nevar pievienot
}
