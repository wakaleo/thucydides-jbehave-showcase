Meta:
@tag component:catalog

Narrative:
In order to find items more easily
As a customer
I want to be able to browse through the product categories

Scenario: Browse through product categories
Given I am on the home page
When I browse through the product categories Clothing, Mens, Shirts
Then I should see a product with the title "3by3 Milano Stretch Cotton Shirt"

