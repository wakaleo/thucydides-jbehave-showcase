package net.thucydides.showcase.jbehave.pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("http://www.newsclassifieds.com.au")
public class HomePage extends PageObject {

    @CacheLookup
    @FindBy(name="adFilter.searchTerm")
    WebElement searchTerm;

    @CacheLookup
    @FindBy(css=".keywords button")
    WebElement search;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void chooseRegion(String region) {
        findBy("#location-select .arrow").then().click();
        waitFor(500).milliseconds();
        findBy("//ul[@class='dropdown-menu']//a[.='" + region + "']").then().click();
    }

    public void chooseCategoryFromDropdown(String category) {
        getDriver().navigate().refresh();
        findBy("#category-select").then(".arrow").then().click();
        findBy("//span[@id='category-select']//a[contains(.,'" + category + "')]").then().click();
    }

    public void enterKeywords(String keywords) {
        element(searchTerm).type(keywords);
    }

    public void performSearch() {
        element(search).click();
    }
}
