package com.test.io.domains.product;

import java.math.BigDecimal;
import java.util.Objects;

public sealed class Product permits CountableProduct, UnCountableProduct {
    private String name;
    private BigDecimal price;
    private boolean isAgeRestricted;
    private String uuid;
    private final ProductType productType;

    public Product(String name, BigDecimal price, boolean isAgeRestricted, String uuid, ProductType productType) {
        this.name = name;
        this.price = price;
        this.isAgeRestricted = isAgeRestricted;
        this.uuid = uuid;
        this.productType = productType;
    }

    public ProductType getProductType() {
        return productType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public boolean isAgeRestricted() {
        return isAgeRestricted;
    }

    public void setAgeRestricted(boolean ageRestricted) {
        isAgeRestricted = ageRestricted;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name) && Objects.equals(uuid, product.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, uuid);
    }
}
