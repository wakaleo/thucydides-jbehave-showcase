package net.thucydides.showcase.jbehave.steps

import org.jbehave.core.annotations.Given
import org.jbehave.core.annotations.When

import org.jbehave.core.annotations.Then

import static net.thucydides.showcase.jbehave.model.matchers.ProductMatchers.withTitle
import net.thucydides.core.annotations.Steps

class BrowseByCategorySteps extends BigCommerceJBehaveSteps{

    @Steps
    CustomerSteps customer;

    @Given('I am on the home page')
    public void givenIAmOnTheHomePage() {
        customer.opens_home_page()
    }

    @When('I browse through the product categories $categories')
    public void whenIBrowseThroughTheProductCategories(List<String> categories) {
        customer.browses_product_categories(*categories)
    }

    @Then('I should see a product with the title "$expectedTitle"')
    public void thenIShouldSeeAProductWithTheTitle(String expectedTitle) {
        customer.should_see_product withTitle(expectedTitle)
    }

    @When("I look for products in the top-level category <category>")
    public void whenILookForProductsInTheToplevelCategory(String category) {
        customer.browses_product_categories(category)
    }

    @Then("products should be organized into the sub-categories <subcategories>")
    public void thenProductsShouldBeOrganizedIntoTheSubcategories(List<String> subcategories) {
        customer.should_see_subcategories(subcategories)
    }

    @Given("I want to browse the catalog")
    public void givenIWantToBrowseTheCatalog() {}

    @Then('I should see the following product categories: $categories')
    public void shouldSeeCategories(List<String> categories) {
        customer.should_see_categories(*categories)
    }
}
