package net.thucydides.showcase.jbehave.steps

import net.thucydides.core.annotations.Steps
import org.jbehave.core.annotations.Given
import org.jbehave.core.annotations.When

class BigCommerceJBehaveSteps {
    @Steps
    CustomerSteps customer;

    @Given('I am on the home page')
    public void givenIAmOnTheHomePage() {
        customer.opens_home_page()
    }

    @When('I am on the home page')
    public void opensTheHomePage() {
        customer.opens_home_page()
    }


}
