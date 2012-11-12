package net.thucydides.showcase.jbehave;

import net.thucydides.core.ThucydidesSystemProperty;
import net.thucydides.jbehave.ThucydidesJUnitStories;

public class JBehaveTestSuite extends ThucydidesJUnitStories {
    public JBehaveTestSuite() {
        //runThucydides().withProperty(ThucydidesSystemProperty.DRIVER).setTo("htmlunit");
    }
}
