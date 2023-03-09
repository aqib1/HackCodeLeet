package com.shoppingcart.io.domain.offers;

import com.shoppingcart.io.domain.cart.CartItem;

import java.math.BigDecimal;
import java.util.List;

public record BuyXGetYFreeOffer(int requiredBuy, int freeGet) implements Offer {

    @Override
    public BigDecimal apply(List<CartItem> cartItems) {
        BigDecimal total = BigDecimal.ZERO;
        int count = 0;
        for (int x=0; x<cartItems.size(); x++) {
            if(count < requiredBuy) {
             total = total.add(cartItems.get(x).getProduct().getPrice());
             count++;
            } else {
                x+= freeGet;
                count = 0;
            }
        }
        return total;
    }
}
