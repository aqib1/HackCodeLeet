package com.shoppingcart.io.domain.products;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

public sealed class Product permits CountableProduct, UncountableProduct {

    private BigDecimal price;
    private String productName;
    private boolean ageRestricted;
    private ProductType productType;
    private final String productUUID;

    public Product(BigDecimal price, boolean ageRestricted, String productName, ProductType productType) {
        this(price, productName, ageRestricted ,UUID.randomUUID().toString(), productType);
    }

    public Product(BigDecimal price, String productName, boolean ageRestricted, String productUUID, ProductType productType) {
       this.price = price;
       this.productName = productName;
       this.productUUID = productUUID;
       this.ageRestricted = ageRestricted;
       this.productType = productType;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductUUID() {
        return productUUID;
    }

    public void setAgeRestricted(boolean ageRestricted) {
        this.ageRestricted = ageRestricted;
    }

    public boolean isAgeRestricted() {
        return ageRestricted;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return ageRestricted == product.ageRestricted && Objects.equals(price, product.price) && Objects.equals(productName, product.productName) && productType == product.productType && Objects.equals(productUUID, product.productUUID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, productName, ageRestricted, productType, productUUID);
    }
}
