package com.accenture.bootcamp.onlinestore.project.addtocart;

import com.accenture.bootcamp.onlinestore.project.orderproduct.OrderProductService;
import com.accenture.bootcamp.onlinestore.project.orders.OrderService;
import com.accenture.bootcamp.onlinestore.project.products.Product;
import com.accenture.bootcamp.onlinestore.project.products.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import static com.accenture.bootcamp.onlinestore.project.cookies.Cookies.USER_ID_COOKIE_NAME;
import static com.accenture.bootcamp.onlinestore.project.orders.OrdersOrderStatus.ORDER_IN_PROGRESS_STATUS_ID;

@Controller
@AllArgsConstructor
public class AddToCartController {

    private final ProductRepository productRepository;
    private final AddToCartService addToCartService;
    private final OrderService orderService;
    private final OrderProductService orderProductService;

    @GetMapping("/product/{productId}")
    public String productDetails(@PathVariable Long productId,
                                 Model model) {
        Product product = productRepository.findOne(productId);
        AddToCartForm productForm = new AddToCartForm();
        model.addAttribute("product", product);
        model.addAttribute("productForm", productForm);
        return "shop/product-details";
    }

    @PostMapping("/product/{productId}")
    public String addProductToCart(@PathVariable Long productId,
                                   @CookieValue(name = USER_ID_COOKIE_NAME, required = false) String userId,
                                   @Valid AddToCartForm form,
                                   BindingResult result,
                                   HttpServletResponse response,
                                   Model model) {
        Product product = productRepository.findOne(productId);
        Integer productInStock = product.getStock();
        Long orderId = orderService.findOrderIdByUserIdWhereStatusIsShoppingCart(userId, ORDER_IN_PROGRESS_STATUS_ID);
        model.addAttribute("product", product);
        model.addAttribute("productForm", form);

        if (form.getQuantity() == null) {
            model.addAttribute("isError1", true);
//            return "shop/product-details";
        } else if (orderId != null && orderProductService.userHasThisProductInCart(orderId, productId)) {
            int productQuantityInCart = orderProductService.getProductQuantityFromOrder(orderId, productId);
            int totalQuantityToAddToCart = productQuantityInCart + form.getQuantity();
            if (totalQuantityToAddToCart > productInStock) {
                model.addAttribute("isError2", true);
            } else {
                addToCartService.addProductToCart(productId, userId, form, response);
                model.addAttribute("isSuccess", true);
            }
        } else if (form.getQuantity() > productInStock) {
            model.addAttribute("isError3", true);
            result.rejectValue("quantity", "too_large", "Please check quantity, you cannot add more items than available.");
        } else if (result.hasErrors()) {
            model.addAttribute("isError4", true);
            return "shop/product-details";
        } else {
            addToCartService.addProductToCart(productId, userId, form, response);
//        model.addAttribute("productForm", new AddToCartForm());
            model.addAttribute("isSuccess", true);
        }
        return "shop/product-details";
    }

}