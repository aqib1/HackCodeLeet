package com.shoppingcart.io.domain.receipt;

import com.shoppingcart.io.domain.cart.CartItem;
import com.shoppingcart.io.domain.products.CountableProduct;
import com.shoppingcart.io.domain.products.UncountableProduct;

import java.math.BigDecimal;
import java.util.List;

public class Receipt {
    private List<CartItem> cartItems;
    private BigDecimal totalCost;

    public Receipt(List<CartItem> cartItems, BigDecimal totalCost) {
        this.cartItems = cartItems;
        this.totalCost = totalCost;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("--------Thanks for shopping----------\n");
        sb.append("\n Here is the break-down of your purchase\n");

        cartItems.forEach(item -> {
            sb.append("-------------------------------------------\n");
            sb.append("Item Name: ").append(item.getProduct().getProductName()).append("\n");
            switch (item.getProduct().getProductType()) {
                case COUNTABLE -> sb.append("Number of items: ").append(((CountableProduct)item.getProduct()).getQuantity()).append("\n");
                case UNCOUNTABLE -> sb.append("Items weight: ").append(((UncountableProduct)item.getProduct()).getWeight()).append("\n");
                default -> throw new IllegalStateException("Invalid Product Type!");
            }
            sb.append("Item Price: ").append(item.getProduct().getPrice()).append("\n");
        });
        sb.append("-------------------------------------------\n");
        sb.append("Total cost: ").append(totalCost);
        return sb.toString();
    }
}
