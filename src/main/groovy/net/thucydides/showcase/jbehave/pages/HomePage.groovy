package net.thucydides.showcase.jbehave.pages

import net.thucydides.core.annotations.DefaultUrl
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import net.thucydides.showcase.jbehave.model.Product
import net.thucydides.showcase.jbehave.model.matchers.ProductMatcher

/**
 * The 3wks home page.
 */
@DefaultUrl("http://3wks.mybigcommerce.com/")
class HomePage extends BigCommercePage {

	@FindBy(id = "LogoImage")
	WebElement logo

    @FindBy(css="#HomeFeaturedProducts .ProductDetails")
    List<WebElement> featuredProducts

    @FindBy(css="#HomeNewProducts .ProductDetails")
    List<WebElement> newProducts

    @FindBy(css="#CategoryContent li")
    List<WebElement> listedProducts

    @FindBy(css="#CategoryHeading h2")
    WebElement categoryHeading

	@FindBy(id = "search_query")
	WebElement searchBox
	
	@FindBy(css = ".Button")
	WebElement searchButton
	
	@FindBy(css = ".ProductDetails > strong > a.TrackLink")
	List<WebElement> searchResults
	
	@FindBy(css = "#SearchForm>p>a>strong")
	WebElement advancedSearchLink
	
	@FindBy(id = "search_query_adv")
	WebElement advancedSearchBox
	
	@FindBy(css = ".Submit>input")
	WebElement advancedSearchButton	
	
	@FindBy(css = ".BlockContent>h2")
	WebElement categoryTitle

    @FindBy(css= ".CartLink a")
    WebElement viewCart

    @FindBy(css=".SideCategoryListClassic a")
    List<WebElement> categoryLinks

    HomePage(WebDriver driver) {
        super(driver)
    }

	def isImageFileInLogoDisplayed() {
		def image
		try {
			image = this.getImage(logo)
		} catch(IOException e) {
			return false
		}
		image?.getWidth() && image?.getHeight()				
	}

    def productTitle =  { product -> new Product(title: product.text) }
    def productDetails =  { WebElement product ->
        def title = product.findElement(By.cssSelector("a")).text
        def price = au.com.threewks.common.Formatting.priceOf(product.findElement(By.cssSelector(".ProductPriceRating em")).text)
        new Product(title: title, price: price)
    }

    List<Product> getFeaturedProducts() {
        featuredProducts.collect productTitle
    }

    List<Product> getNewProducts() {
        newProducts.collect productTitle
    }

    List<Product> getDisplayedProducts() {
        newProducts.collect productDetails
    }

    def select_top_level_category(String category) {
        findBy(".SideCategoryListClassic").then(By.linkText(category)).click()
    }

    List<String> getCategories() {
        categoryLinks.collect { it.text }
    }

    def select_subcategory(String category) {
        findBy(".SubCategoryList").then(By.linkText(category)).click()
    }

    def shouldDisplayProduct(ProductMatcher... productMatchers) {
        displayedProducts.each { product ->
            productMatchers.each {
                assert it.matches(product)
            }
        }
    }

    boolean categoryIsVisible(String category) {
        categoryHeading.text == category
    }

    boolean displaysProduct(ProductMatcher... productMatchers) {
        displayedProducts.find { product ->
            !productMatchers.find { !it.matches(product) }
        }
    }

	def searchFor(String product) {
        element(searchBox).type(product)
		element(searchButton).click()
	}
	
    def selectProduct(title) {
        println "Select product $title"
        findBy(".ProductList").then(By.linkText(title)).click()
    }

    def shouldDisplaySubcategory(subCategory) {
        findBy(".SubCategoryList").then(By.linkText(subCategory)).shouldBeCurrentlyVisible()
    }

    def viewCart() {
        element(viewCart).click()
    }
}
