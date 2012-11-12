package net.thucydides.showcase.jbehave.steps

import net.thucydides.core.annotations.Steps
import org.jbehave.core.annotations.Then
import org.jbehave.core.annotations.When

import static net.thucydides.showcase.jbehave.model.matchers.ProductMatchers.withTitle
import org.jbehave.core.annotations.Given

class SimpleSearchSteps extends BigCommerceJBehaveSteps{
    @Steps
    CustomerSteps customer;

    @Given('that I want to find products in the "<range>" range')
    public void givenThatIWantToFindProductsInTheRange(String range) {
        customer.opens_home_page()
    }

    @When('I search for products by keyword "<keywords>"')
    public void whenISearchForProductsByKeyword(String keywords) {
        customer.searches_for_product(keywords)
    }

    @Then('I should see a product with the title <expectedTitle>')
    public void thenIShouldSeeAProductWithTheTitle(String expectedTitle) {
        customer.should_see_product withTitle(expectedTitle)
    }
}

