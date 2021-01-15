package com.accenture.bootcamp.onlinestore.project.shop;

import com.accenture.bootcamp.onlinestore.project.categories.Category;
import com.accenture.bootcamp.onlinestore.project.categories.CategoryService;
import com.accenture.bootcamp.onlinestore.project.products.Product;
import com.accenture.bootcamp.onlinestore.project.products.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.UUID;

import com.accenture.bootcamp.onlinestore.project.cookies.CookieUtils;
import static com.accenture.bootcamp.onlinestore.project.cookies.Cookies.USER_ID_COOKIE_NAME;

@Controller
@AllArgsConstructor
public class ShopProductController {

    private final ProductRepository productRepository;
    private final CategoryService categoryService;

    @GetMapping("/product/{productId}")
    public String productDetails(@PathVariable Long productId,
                                 Model model) {
        Product product = productRepository.findOne(productId);
        List<Category> categories = categoryService.findAll();
        ShopAddProductToCartForm productForm = new ShopAddProductToCartForm();
        model.addAttribute("productForAddToCart", product);
        model.addAttribute("categoriesForProduct", categories);
        model.addAttribute("productForm", productForm);
        return "shop/product-details";
    }

    @PostMapping("/product/{productId}")
    public String addProductToCart(@PathVariable Long productId,
                                   //We can use this annotation before the parameter to tell Spring to
                                   //set the value of this parameter to the value of cookie (if user has a cookie)
                                   @CookieValue(name = USER_ID_COOKIE_NAME, required = false) String userId,
                                   ShopAddProductToCartForm form,
                                   HttpServletResponse response,
                                   Model model) {
        System.out.println("add to cart product: " + productId + " and quantity " + form);
        System.out.println("Cart cookie ID: " + userId);

        model.addAttribute("productForm", new ShopAddProductToCartForm());
        model.addAttribute("isSuccess", true);

        String userIdentifier = UUID.randomUUID().toString(); // example how we can create unique identifier

        //Example of how we can generate unique ID and set cookie for user
        addShoppingCartCookieToResponse(response, userIdentifier);
        return "shop/product-details";
    }

    private void addShoppingCartCookieToResponse(HttpServletResponse response, String cookieValue) {
        Cookie cookie = CookieUtils.createCookie(USER_ID_COOKIE_NAME, cookieValue);
        response.addCookie(cookie);
    }
}
