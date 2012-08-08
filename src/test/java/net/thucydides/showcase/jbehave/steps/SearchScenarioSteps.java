package net.thucydides.showcase.jbehave.steps;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class SearchScenarioSteps {
    @Steps
    BuyerSteps buyer;

    @Given("Sally wants to buy a $present for her son")
    public void buyingAPresent(String present) {
        buyer.opens_home_page();
    }

    @When("she looks for ads in the $category category containing $keyword in $region")
    public void adSearchByCategoryAndKeywordInARegion(String category, String keyword, String region) {
        buyer.chooses_region(region);
        buyer.chooses_category_and_keywords(category, keyword);
        buyer.performs_search();
    }

    @Then("she should obtain a list of $category ads containing the word $keyword from advertisers in $region")
    public void resultsForACategoryAndKeywordInARegion(String category, String keyword, String region) {
        buyer.should_only_see_results_with_titles_containing(keyword);
        buyer.should_only_see_results_from_region(region);
        buyer.should_only_see_results_in_category(category);
    }
}


