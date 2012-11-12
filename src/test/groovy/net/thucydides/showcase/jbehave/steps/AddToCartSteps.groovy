package net.thucydides.showcase.jbehave.steps

import net.thucydides.core.annotations.Steps
import org.jbehave.core.annotations.Then
import org.jbehave.core.annotations.When

import static net.thucydides.showcase.jbehave.model.matchers.ProductMatchers.withTitle
import org.jbehave.core.annotations.Given
import net.thucydides.showcase.jbehave.model.CartItem

import static net.thucydides.showcase.jbehave.model.CartItem.containing

class AddToCartSteps extends BigCommerceJBehaveSteps {

    @Steps
    BuyerSteps buyer;

    Integer quantity
    String product

    @Given("that I want to order <quantity> <product> in the <categories> category")
    public void givenThatIWantToOrder(Integer quantity, String product, List<String> categories) {
        this.quantity = quantity
        this.product = product
        buyer.opens_home_page()
        buyer.browses_product_categories(*categories)
        buyer.selects_product(product)
    }

    @When("I add them to the cart")
    public void whenIAddThemToTheCart() {
        buyer.adds_product_to_cart(quantity)
    }

    @Then("the cart should display the product with an item price of <expectedItemPrice> and a total price of <expectedTotal>")
    public void thenTheCartShouldDisplayTheCorrectProductEntry(BigDecimal expectedItemPrice, BigDecimal expectedTotal) {
        buyer.views_or_edits_cart()
        buyer.should_see_cart_item(containing(quantity).
                                    productsCalled(product).
                                    withAnItemPriceOf(expectedItemPrice).
                                    andATotalOf(expectedTotal))
    }

}
