package net.thucydides.showcase.jbehave.pages

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.By

class CartConfirmationPage extends BigCommercePage {

    @FindBy(css=".subtotal .ProductPrice")
    WebElement subtotalPrice;

    @FindBy(css=".modalClose")
    WebElement close;

    CartConfirmationPage(WebDriver driver) {
        super(driver)
    }

    BigDecimal getSubtotal() {
        au.com.threewks.common.Formatting.priceOf(element(subtotalPrice).text)
    }

    void close() {
        element(close).click()
    }

    void viewOrEditCart() {
        find(By.linkText("View or edit your cart")).then().click()
    }
}
