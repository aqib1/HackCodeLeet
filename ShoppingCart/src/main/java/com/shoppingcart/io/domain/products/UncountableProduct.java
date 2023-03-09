package com.shoppingcart.io.domain.products;

import java.math.BigDecimal;

import static com.shoppingcart.io.domain.products.ProductType.UNCOUNTABLE;

public non-sealed class UncountableProduct extends Product {
    private BigDecimal weight;

    public UncountableProduct(BigDecimal price, String productName, boolean ageRestriction, String productUUID, BigDecimal weight) {
        super(price, productName, ageRestriction, productUUID, UNCOUNTABLE);
        this.weight = weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public BigDecimal getWeight() {
        return weight;
    }
}
