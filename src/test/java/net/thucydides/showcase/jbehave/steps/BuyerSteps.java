package net.thucydides.showcase.jbehave.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;
import net.thucydides.showcase.jbehave.pages.HomePage;
import net.thucydides.showcase.jbehave.pages.SearchResultsPage;

public class BuyerSteps extends ScenarioSteps {

    HomePage homePage;
    SearchResultsPage searchResultsPage;

    public BuyerSteps(Pages pages) {
        super(pages);
        homePage = getPages().get(HomePage.class);
        searchResultsPage = getPages().get(SearchResultsPage.class);
    }

    @Step
    public void opens_home_page() {
        homePage.open();
    }

    @Step
    public void chooses_region(String region) {
        homePage.chooseRegion(region);
    }

    @Step
    public void chooses_category_and_keywords(String category, String keywords) {
        homePage.chooseCategoryFromDropdown(category);
        homePage.enterKeywords(keywords);
    }

    @Step
    public void performs_search() {
        homePage.performSearch();
    }

    @Step
    public void should_only_see_results_with_titles_containing(String title) {
        searchResultsPage.allTitlesShouldContain(title);
    }

    @Step
    public void should_only_see_results_from_region(String region) {
        // TODO
    }

    @Step
    public void should_only_see_results_in_category(String category) {
        // TODO
    }
}
