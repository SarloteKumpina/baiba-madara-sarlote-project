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
        return "shop/shop-detail";
    }

    private void addShoppingCartCookieToResponse(HttpServletResponse response, String cookieValue) {
        Cookie cookie = CookieUtils.createCookie(USER_ID_COOKIE_NAME, cookieValue);
        response.addCookie(cookie);
    }
}
