package net.thucydides.showcase.jbehave.steps

import net.thucydides.core.annotations.Step
import net.thucydides.core.pages.Pages

import net.thucydides.showcase.jbehave.pages.ProductDetailsPage
import net.thucydides.showcase.jbehave.pages.CartConfirmationPage
import net.thucydides.showcase.jbehave.model.matchers.ProductMatcher

class CustomerSteps extends BigCommerceSteps {
    ProductDetailsPage productDetailsPage
    CartConfirmationPage cartConfirmationPage


    CustomerSteps(Pages pages) {
        super(pages)
        productDetailsPage = pages[ProductDetailsPage]
        cartConfirmationPage = pages[CartConfirmationPage]
    }


    @Step("Should see {0} featured products")
    def should_see_featured_products(expectedProductCount) {
        assert homePage.featuredProducts.size() == expectedProductCount
    }

    @Step("Should see {0} new products")
    def should_see_new_products(expectedProductCount) {
        assert homePage.newProducts.size() == expectedProductCount
    }

    @Step
    def browses_product_categories(String... categories) {
        selects_top_level_category(categories.head())
        categories.tail().each { subcategory ->
            browse_through_subcategory subcategory
        }
    }

    @Step
    def selects_top_level_category(String category) {
        homePage.select_top_level_category category
    }

    @Step
    def browse_through_subcategory(subcategory) {
        homePage.select_subcategory(subcategory)
    }


    @Step
    def should_see_product(ProductMatcher... matchers) {
        homePage.shouldDisplayProduct(matchers)
    }

    @Step
    void should_see_subcategories(List<String> subcategories) {
        subcategories.each { subcategory -> homePage.shouldDisplaySubcategory subcategory }
    }

    @Step
    boolean seesCategory(String category) {
        homePage.categoryIsVisible(category)
    }

    @Step
    boolean product_is_visible(ProductMatcher... matchers) {
        homePage.displaysProduct(matchers)
    }


	@Step
	def searches_for_product(String keywords) {
		homePage.searchFor(keywords)
	}

	@Step
	def opens_advanced_search_form() {
		homePage.advancedSearchLink.click()
	}

    @Step
    def selects_product(title) {
        homePage.selectProduct(title)
    }

    @Step
    void should_see_product_details(String productTitle, BigDecimal price) {
        assert productDetailsPage.productTitle == productTitle
        assert productDetailsPage.price == price
    }

    BigDecimal getDisplayedProductPrice() {
        productDetailsPage.price
    }

    @Step
    void should_see_categories(String... categoryNames) {
        def displayedCategories = homePage.categories
        categoryNames.each { category ->
            assert displayedCategories.contains(category)
        }
    }
}

