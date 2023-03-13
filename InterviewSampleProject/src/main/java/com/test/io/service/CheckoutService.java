package com.test.io.service;

import com.test.io.domains.cart.CartItem;
import com.test.io.domains.policies.PricingPolicy;
import com.test.io.domains.product.Product;
import com.test.io.domains.receipt.IReceipt;
import com.test.io.domains.user.User;
import com.test.io.exceptions.AgeRestrictedProductException;

import java.math.BigDecimal;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class CheckoutService {
    private final ConcurrentMap<CartItem, Integer> cartItems;
    private final User user;

    public CheckoutService(User user) {
        this.cartItems = new ConcurrentHashMap<>();
        this.user = user;
    }

    public void addProductToCart(Product product, PricingPolicy pricingPolicy) {
        if(user.isUnderAge() && product.isAgeRestricted()) {
            throw new AgeRestrictedProductException("This product is age restricted");
        }
        CartItem cartItem = new CartItem(product, pricingPolicy);
        if(cartItems.containsKey(cartItem)) {
            cartItems.put(cartItem, cartItems.get(cartItem) + 1);
        } else {
            cartItems.put(cartItem, 1);
        }
    }

    private BigDecimal getTotalCost() {
        // before calculating cost lets apply all pricing policies
        this.cartItems.forEach((cartItems, count) -> {
            cartItems.applyPolicy();
        });
        BigDecimal sum = BigDecimal.ZERO;
        for(CartItem cartItem: this.cartItems.keySet()) {
            sum = sum.add(cartItem.getProduct().getPrice());
        }
        return sum;
    }

    public IReceipt checkout() {
        return new IReceipt(cartItems, getTotalCost());
    }

}
