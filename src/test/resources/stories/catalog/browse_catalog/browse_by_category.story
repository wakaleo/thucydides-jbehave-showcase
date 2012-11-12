Meta:
@tag component:catalog

Narrative:
In order to find items more easily
As a customer
I want to be able to see what product categories exist

Scenario: See all top-level categories
Given I want to browse the catalog
When I am on the home page
Then I should see the following product categories: Clothing, Accessories, Shoes

