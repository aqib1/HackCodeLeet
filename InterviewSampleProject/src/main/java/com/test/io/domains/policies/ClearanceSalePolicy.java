package com.test.io.domains.policies;

import com.test.io.domains.product.Product;

import java.math.BigDecimal;
import java.math.RoundingMode;

public record ClearanceSalePolicy(BigDecimal discount) implements PricingPolicy {
    @Override
    public void apply(Product product) {
        product.setPrice(
                product.getPrice().subtract(
                        discount.divide(
                                product.getPrice(), 2, RoundingMode.CEILING
                        ).multiply(BigDecimal.valueOf(100))));
    }
}
