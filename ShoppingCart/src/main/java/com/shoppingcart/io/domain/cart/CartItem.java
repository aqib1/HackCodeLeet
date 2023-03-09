package com.shoppingcart.io.domain.cart;

import com.shoppingcart.io.domain.policies.PricingPolicy;
import com.shoppingcart.io.domain.products.Product;

import java.util.Objects;

public class CartItem {
    private Product product;
    private PricingPolicy pricingPolicy;

    public CartItem(Product product, PricingPolicy pricingPolicy) {
        this.product = product;
        this.pricingPolicy = pricingPolicy;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public PricingPolicy getPricingPolicy() {
        return pricingPolicy;
    }

    public void setPricingPolicy(PricingPolicy pricingPolicy) {
        this.pricingPolicy = pricingPolicy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartItem cartItem = (CartItem) o;
        return Objects.equals(product, cartItem.product) && Objects.equals(pricingPolicy, cartItem.pricingPolicy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, pricingPolicy);
    }
}
