package com.shoppingcart.io.domain.offers;

import com.shoppingcart.io.domain.cart.CartItem;

import java.math.BigDecimal;
import java.util.List;

public record DefaultOffer() implements Offer {
    @Override
    public BigDecimal apply(List<CartItem> cartItems) {
        BigDecimal total = BigDecimal.ZERO;
        for (CartItem cartItem : cartItems) {
            total = total.add(cartItem
                    .getPricingPolicy()
                    .calculatePrice(cartItem.getProduct()));
        }

        return total;
    }
}
