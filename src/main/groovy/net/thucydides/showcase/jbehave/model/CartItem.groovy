package net.thucydides.showcase.jbehave.model

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@ToString
@EqualsAndHashCode
class CartItem {
    String title
    Integer quantity
    BigDecimal itemPrice
    BigDecimal itemTotal

    static CartItemBuilder containing(Integer quantity) {
        new CartItemBuilder(quantity: quantity)
    }

    static class CartItemBuilder {
        Integer quantity
        String title
        BigDecimal itemPrice

        CartItemBuilder productsCalled(title) { new CartItemBuilder(quantity: quantity, title: title) }
        CartItemBuilder withAnItemPriceOf(itemPrice) { new CartItemBuilder(quantity: quantity, title: title,
                                                                           itemPrice:itemPrice) }
        CartItem andATotalOf(itemTotal) { new CartItem(quantity: quantity, title: title,
                                                       itemPrice:itemPrice, itemTotal:itemTotal) }
    }
}
