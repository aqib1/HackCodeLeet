package com.shoppingcart.io.domain.policies;

import com.shoppingcart.io.domain.products.Product;

import java.math.BigDecimal;
import java.math.RoundingMode;

public non-sealed class SeasonalSalePolicy implements PricingPolicy {
    private final double discount;

    public SeasonalSalePolicy(double discount) {
        this.discount = discount;
    }

    @Override
    public BigDecimal calculatePrice(Product product) {
        return product.getPrice().subtract(
                BigDecimal.valueOf(discount)
                        .multiply(BigDecimal.valueOf(100))
                        .divide(product.getPrice(), 2, RoundingMode.DOWN));
    }
}
