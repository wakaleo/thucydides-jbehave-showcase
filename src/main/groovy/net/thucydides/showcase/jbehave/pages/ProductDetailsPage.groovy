package net.thucydides.showcase.jbehave.pages

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

class ProductDetailsPage extends BigCommercePage {

    @FindBy(css="#ProductDetails h2")
    WebElement productTitle;

    @FindBy(css=".ProductPrice")
    WebElement productPrice;

    @FindBy(id="qty_")
    WebElement quantitySelection

    @FindBy(xpath="//input[contains(@src,'AddCartButton')]")
    WebElement addToCart

    ProductDetailsPage(WebDriver driver) {
        super(driver)
    }

    String getProductTitle() {
        element(productTitle).text
    }

    BigDecimal getPrice() {
        au.com.threewks.common.Formatting.priceOf(element(productPrice).text)
    }

    void addToCart(Integer quantity) {
        $(quantitySelection).selectByVisibleText(quantity.toString())
        $(addToCart).waitUntilEnabled()
        $(addToCart).click()
        waitForTextToAppear("added to your cart")
    }
}
