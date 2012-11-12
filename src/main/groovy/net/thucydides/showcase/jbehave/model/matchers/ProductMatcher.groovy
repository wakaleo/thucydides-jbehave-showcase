package net.thucydides.showcase.jbehave.model.matchers

import net.thucydides.showcase.jbehave.model.Product


interface ProductMatcher {
    boolean matches(Product product);
}
