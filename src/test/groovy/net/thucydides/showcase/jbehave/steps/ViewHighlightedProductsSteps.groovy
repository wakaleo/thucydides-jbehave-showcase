package net.thucydides.showcase.jbehave.steps

import net.thucydides.core.annotations.Steps
import org.jbehave.core.annotations.Then
import org.jbehave.core.annotations.When

import static net.thucydides.showcase.jbehave.model.matchers.ProductMatchers.withTitle

class ViewHighlightedProductsSteps extends BigCommerceJBehaveSteps{
    @Steps
    CustomerSteps customer;

    @Then('I should see $productCount featured products')
    public void thenIShouldSeeFeaturedProducts(int productCount) {
        customer.should_see_featured_products(productCount)
    }

    @Then('I should see $productCount new products')
    public void thenIShouldSeeNewProducts(int productCount) {
        customer.should_see_new_products(productCount)
    }
}
