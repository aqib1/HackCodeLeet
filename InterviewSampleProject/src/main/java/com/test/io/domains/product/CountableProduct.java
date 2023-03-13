package com.test.io.domains.product;

import java.math.BigDecimal;

import static com.test.io.domains.product.ProductType.COUNTED;

public non-sealed class CountableProduct extends Product {
    private int quantity;

    public CountableProduct(String name, BigDecimal price, boolean isAgeRestricted, String uuid, int quantity) {
        super(name, price, isAgeRestricted, uuid, COUNTED);
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
