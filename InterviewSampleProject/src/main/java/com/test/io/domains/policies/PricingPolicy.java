package com.test.io.domains.policies;

import com.test.io.domains.product.Product;

public sealed interface PricingPolicy permits ClearanceSalePolicy, NoPolicy {
    void apply(Product product);
}
