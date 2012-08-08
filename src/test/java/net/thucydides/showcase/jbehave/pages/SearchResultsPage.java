package net.thucydides.showcase.jbehave.pages;


import net.thucydides.core.pages.PageObject;
import net.thucydides.core.util.Inflector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;

public class SearchResultsPage extends PageObject {

    @CacheLookup
    @FindBy(css=".organic .item .title")
    List<WebElement> displayedTitles;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public void allTitlesShouldContain(String expectedTitle) {
        String pluralTitle = Inflector.getInstance().pluralize(expectedTitle).toUpperCase();
        String singularTitle = Inflector.getInstance().singularize(expectedTitle).toUpperCase();
        for(WebElement displayedTitle : displayedTitles) {
            String itemTitle = displayedTitle.getText();
            assertThat(itemTitle.toUpperCase(), anyOf(containsString(pluralTitle), containsString(singularTitle)));
        }
    }
}
