package com.shoppingcart.io.business;

import com.shoppingcart.io.domain.cart.CartItem;
import com.shoppingcart.io.domain.offers.BuyXGetYFreeOffer;
import com.shoppingcart.io.domain.offers.DefaultOffer;
import com.shoppingcart.io.domain.offers.Offer;
import com.shoppingcart.io.domain.receipt.Receipt;
import com.shoppingcart.io.domain.users.User;
import com.shoppingcart.io.exceptions.EmptyCartException;
import com.shoppingcart.io.exceptions.UnauthorizedItemException;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ShoppingCart {

    private final List<CartItem> cartItems;
    private final User user;
    private final Offer offer;

    public ShoppingCart(User user) {
        this(user, new BuyXGetYFreeOffer(1, 2), new CopyOnWriteArrayList<>());
    }

    public ShoppingCart(User user, Offer offer, List<CartItem> cartItems) {
        this.user = user;
        this.offer = offer;
        this.cartItems = cartItems;
    }

    public void addToCart(CartItem item) {
        if(item.getProduct().isAgeRestricted()
                && user.isUnderAge()) {
            throw new UnauthorizedItemException("User is not authorized for age restricted product.");
        }
        this.cartItems.add(item);
    }

    private BigDecimal calculateTotalPrice() {
        return this.offer.apply(cartItems);
    }

    public Receipt checkOut() {
        if(this.cartItems.isEmpty()) throw new EmptyCartException("No items found to checkout");
        return new Receipt(cartItems, calculateTotalPrice());
    }

}
