package com.test.io.domains.receipt;

import com.test.io.domains.cart.CartItem;

import java.math.BigDecimal;
import java.util.concurrent.ConcurrentMap;

public record IReceipt(ConcurrentMap<CartItem, Integer> cartItems, BigDecimal totalCost) {

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("--------------Thanks for shopping----------\n");
        cartItems.forEach((cartItem, count) -> {
            sb.append("Product name :").append(cartItem.getProduct().getName());
            sb.append("Price of product: ").append(cartItem.getProduct().getPrice())
                    .append(" x ").append(count);

            switch (cartItem.getProduct().getProductType()) {
//                case COUNTED ->
//                case UNCOUNTED ->
            }

        });
        sb.append("Total cost: ").append(totalCost);
        return sb.toString();
    }
}
