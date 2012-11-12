package net.thucydides.showcase.jbehave.steps

import net.thucydides.core.annotations.Step
import net.thucydides.core.pages.Pages

import net.thucydides.showcase.jbehave.pages.CartConfirmationPage

import net.thucydides.showcase.jbehave.model.CartItem
import net.thucydides.showcase.jbehave.pages.ShoppingCartPage

class BuyerSteps extends CustomerSteps {
    CartConfirmationPage cartConfirmationPage
    ShoppingCartPage shoppingCartPage

    BuyerSteps(Pages pages) {
        super(pages)
        cartConfirmationPage = pages[CartConfirmationPage]
        shoppingCartPage = pages[ShoppingCartPage]
    }


    @Step("ads {1} products to the cart")
    void adds_product_to_cart(Integer quantity) {
        productDetailsPage.addToCart(quantity)
    }


    BigDecimal getDisplayedSubtotal() {
        cartConfirmationPage.subtotal
    }

    @Step
    void should_see_subtotal(BigDecimal expectedSubTotal) {
        assert cartConfirmationPage.subtotal == expectedSubTotal
    }

    @Step
    def views_cart() {
        homePage.viewCart()
    }

    @Step
    def views_or_edits_cart() {
        cartConfirmationPage.viewOrEditCart()
    }

    @Step
    def should_see_cart_item(CartItem cartItem) {  
		assert (shoppingCartPage.cartItems.contains(cartItem))  
    }
}

