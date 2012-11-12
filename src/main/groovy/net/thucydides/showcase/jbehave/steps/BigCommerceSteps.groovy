
package net.thucydides.showcase.jbehave.steps

import net.thucydides.core.annotations.Step
import net.thucydides.core.pages.Pages
import net.thucydides.core.steps.ScenarioSteps
import net.thucydides.showcase.jbehave.pages.HomePage

class BigCommerceSteps extends ScenarioSteps {

    HomePage homePage

    BigCommerceSteps(Pages pages) {
        super(pages)
        homePage = pages[HomePage]
    }

    @Step
    def opens_home_page() {
        homePage.open()
    }
}
