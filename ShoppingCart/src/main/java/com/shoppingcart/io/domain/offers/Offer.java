package com.shoppingcart.io.domain.offers;

import com.shoppingcart.io.domain.cart.CartItem;

import java.math.BigDecimal;
import java.util.List;

public sealed interface Offer permits DefaultOffer, BuyXGetYFreeOffer {
    BigDecimal apply(List<CartItem> cartItems);
}
