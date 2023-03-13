package com.test.io.domains.cart;

import com.test.io.domains.policies.PricingPolicy;
import com.test.io.domains.product.Product;

import java.util.Objects;

public record CartItem(Product product, PricingPolicy policy) {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartItem cartItem = (CartItem) o;
        return Objects.equals(product, cartItem.product);
    }

    public Product getProduct() {
        return product;
    }

    public void applyPolicy() {
        this.policy.apply(product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product);
    }
}
