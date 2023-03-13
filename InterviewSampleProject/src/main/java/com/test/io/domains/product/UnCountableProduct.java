package com.test.io.domains.product;

import java.math.BigDecimal;

import static com.test.io.domains.product.ProductType.UNCOUNTED;

public non-sealed class UnCountableProduct extends Product {
    private BigDecimal weight;

    public UnCountableProduct(String name, BigDecimal price, boolean isAgeRestricted, String uuid, BigDecimal weight) {
        super(name, price, isAgeRestricted, uuid, UNCOUNTED);
        this.weight = weight;

    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }
}
