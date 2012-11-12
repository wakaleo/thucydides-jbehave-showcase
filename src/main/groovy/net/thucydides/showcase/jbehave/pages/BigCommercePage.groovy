package net.thucydides.showcase.jbehave.pages

import net.thucydides.core.pages.PageObject
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import java.awt.image.BufferedImage
import javax.imageio.ImageIO

/**
 * Base page object for all Gecko web site pages.
 * Contains common or shared methods useful for several pages.
 */

class BigCommercePage extends PageObject {
    BigCommercePage(WebDriver driver) {
        super(driver)
    }
	
	/**
	 * Get text assigned to webElements (mainly used by methods checking that links have some text assigned to them).
	 * @param webElements
	 * @return list of strings
	 */
	protected List<String> getDescriptions(List<WebElement> webElements) {
		webElements.collect { element ->
			element.getText()
		}
	}
	
	/**
	 * Get actual image (binary data) available under src path stored in html img tag 
	 * @param image
	 * @return BufferedImage downloaded from passed url
	 */
	protected BufferedImage getImage(WebElement image) {
		BufferedImage img = ImageIO.read(new URL(image.getAttribute("src")))
	} 
}
