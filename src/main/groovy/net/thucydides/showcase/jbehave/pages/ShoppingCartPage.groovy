package net.thucydides.showcase.jbehave.pages

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

import static net.thucydides.showcase.jbehave.common.Formatting.priceOf
import net.thucydides.showcase.jbehave.model.CartItem
import org.openqa.selenium.By
import net.thucydides.core.pages.WebElementFacade

class ShoppingCartPage extends BigCommercePage {

    ShoppingCartPage(WebDriver driver) {
        super(driver)
    }

    @FindBy(xpath="//tr[contains(@class,'SubTotal') and contains(.,'Subtotal')]//em[@class='ProductPrice']")
    WebElement subtotal

    @FindBy(xpath="//tr[contains(@class,'SubTotal') and contains(.,'Grand Total')]//em[@class='ProductPrice']")
    WebElement grandTotal

    @FindBy(css = ".CartContents tbody tr")
    List<WebElement> shoppingCartItems

    BigDecimal getSubtotal() {
        priceOf(element(subtotal).text)
    }

    BigDecimal getGrandTotal() {
        priceOf(element(grandTotal).text)
    }

    List<CartItem> getCartItems() {    
		shoppingCartItems.collect { cartItemfromElement(it) } 
    }    

	CartItem cartItemfromElement(WebElement element) {
	    Integer quantity = Integer.parseInt(itemQuantity(element))
	    String product = productName(element)
	    BigDecimal itemPrice = priceOf(itemPrice(element))
	    BigDecimal totalPrice = priceOf(totalPrice(element))  

	    return CartItem.containing(quantity).productsCalled(product).
								             withAnItemPriceOf(itemPrice).
								             andATotalOf(totalPrice)
	}

    private String productName(WebElement cartItem) {
        $(cartItem).findBy(".ProductName").text
    }

    private String totalPrice(WebElement cartItem) {
        $(cartItem).findBy(".CartItemTotalPrice").text

    }

    private String itemPrice(WebElement cartItem) {
        $(cartItem).findBy(".CartItemIndividualPrice").text
    }

    private String itemQuantity(WebElement cartItem) {
        $(cartItem).findBy(".CartItemQuantity").then("select").selectedValue
    }
}
