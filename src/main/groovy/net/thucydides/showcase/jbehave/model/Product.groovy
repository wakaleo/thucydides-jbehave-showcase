package net.thucydides.showcase.jbehave.model

import groovy.transform.ToString
import groovy.transform.EqualsAndHashCode

@ToString
@EqualsAndHashCode
class Product {
    String title
    BigDecimal price
	List<String> category
}
