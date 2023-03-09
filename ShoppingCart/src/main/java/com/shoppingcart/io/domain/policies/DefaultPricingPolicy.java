package com.shoppingcart.io.domain.policies;

import com.shoppingcart.io.domain.products.Product;

import java.math.BigDecimal;

public non-sealed class DefaultPricingPolicy implements PricingPolicy {

    @Override
    public BigDecimal calculatePrice(Product product) {
        return product.getPrice();
    }
}
