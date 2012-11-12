package net.thucydides.showcase.jbehave.common

class Formatting {
    static BigDecimal priceOf(String displayPrice) {
        new BigDecimal(displayPrice.replace('$','').replace(',',''))
    }
}
