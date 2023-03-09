package com.shoppingcart.io.business;

import com.shoppingcart.io.domain.cart.CartItem;
import com.shoppingcart.io.domain.policies.SeasonalSalePolicy;
import com.shoppingcart.io.domain.products.Product;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import java.math.BigDecimal;
import static com.shoppingcart.io.domain.products.ProductType.COUNTABLE;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class ShoppingCartTest {

    @Mock
    public ShoppingCart cart = mock(ShoppingCart.class);

    @Test
    public void addItem_ShouldAddCartItem_Success() {
        // when
        doNothing().when(cart).addToCart(any(CartItem.class));

        // given
        CartItem item = getCartItem();

        // when
        cart.addToCart(item);

        // then
        verify(cart, times(1)).addToCart(item);
    }


    private CartItem getCartItem() {
        Product product = new Product(BigDecimal.TEN, true, "test", COUNTABLE);
        return new CartItem(product, new SeasonalSalePolicy(20.0));
    }
}
