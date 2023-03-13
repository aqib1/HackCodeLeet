package com.test.io.domains.policies;

import com.test.io.domains.product.Product;

public record NoPolicy() implements PricingPolicy {

    @Override
    public void apply(Product product) {

    }
}
