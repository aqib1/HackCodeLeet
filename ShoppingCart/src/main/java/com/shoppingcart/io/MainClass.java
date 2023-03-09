package com.shoppingcart.io;

import com.shoppingcart.io.business.ShoppingCart;
import com.shoppingcart.io.domain.cart.CartItem;
import com.shoppingcart.io.domain.policies.DefaultPricingPolicy;
import com.shoppingcart.io.domain.policies.SeasonalSalePolicy;
import com.shoppingcart.io.domain.products.CountableProduct;
import com.shoppingcart.io.domain.products.Product;
import com.shoppingcart.io.domain.products.ProductType;
import com.shoppingcart.io.domain.products.UncountableProduct;
import com.shoppingcart.io.domain.users.User;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class MainClass {
    private static final double DEFAULT_SEASONAL_DISCOUNT = 20.0;
    public static void main(String[] args) {
        SeasonalSalePolicy policy = new SeasonalSalePolicy(DEFAULT_SEASONAL_DISCOUNT);
        Product p = new CountableProduct(
                BigDecimal.valueOf(100),
                "p1",
                true,
                "",
                1);
        Product p2 = new UncountableProduct(
                BigDecimal.valueOf(100),
                "p1",
                true,
                "",
                BigDecimal.valueOf(12));

        Product p3 = new UncountableProduct(
                BigDecimal.valueOf(100),
                "p3",
                true,
                "",
                BigDecimal.valueOf(12));

        List<CartItem> cartItems = new ArrayList<>();
        cartItems.add(new CartItem(p, policy));
        cartItems.add(new CartItem(p2, new DefaultPricingPolicy()));
        cartItems.add(new CartItem(p3, new DefaultPricingPolicy()));

        User user = new User("test", 24, true);

        ShoppingCart shoppingCart = new ShoppingCart(user);
        cartItems.forEach(shoppingCart::addToCart);


        System.out.println(shoppingCart.checkOut());

    }
}
