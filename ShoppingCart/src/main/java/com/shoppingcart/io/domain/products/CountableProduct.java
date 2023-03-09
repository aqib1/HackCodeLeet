package com.shoppingcart.io.domain.products;

import java.math.BigDecimal;

import static com.shoppingcart.io.domain.products.ProductType.COUNTABLE;

public non-sealed class CountableProduct extends Product {
    private int quantity;

    public CountableProduct(BigDecimal price, String productName, boolean ageRestriction, String productUUID, int quantity) {
        super(price, productName, ageRestriction, productUUID, COUNTABLE);
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
