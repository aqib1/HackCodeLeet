package com.shoppingcart.io.domain.policies;

import com.shoppingcart.io.domain.products.Product;

import java.math.BigDecimal;

public sealed interface PricingPolicy permits DefaultPricingPolicy, SeasonalSalePolicy {
    BigDecimal calculatePrice(Product product);
}
