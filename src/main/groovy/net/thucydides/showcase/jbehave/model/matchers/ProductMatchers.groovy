package net.thucydides.showcase.jbehave.model.matchers

import net.thucydides.showcase.jbehave.model.Product

class ProductMatchers {

    static ProductMatcher withTitle(String title) {
        return new ProductMatcher() {
            @Override
            boolean matches(Product product) {
                product.title == title
            }

            @Override
            String toString() {
                "with title '$title'"
            }
        }
    }

    static ProductMatcher withPrice(BigDecimal price) {
        return new ProductMatcher() {
            @Override
            boolean matches(Product product) {
                product.price.compareTo(price) == 0
            }
            @Override
            String toString() {
                "with price \$$price"
            }
        }
    }

}
