shoppingMeta:
@tag component:orders

Narrative:
In order to obtain the product I want to buy
As a customer
I want to be able to purchase products in the catalog

Scenario: Adding a product to the cart
Given that I want to order <quantity> <product> in the <categories> category
When I add them to the cart
Then the cart should display the product with an item price of <expectedItemPrice> and a total price of <expectedTotal>

Examples:
|categories      |product                          |quantity | expectedItemPrice | expectedTotal |
|Clothing,Mens   |3by3 Milano Stretch Cotton Shirt |1        | 99.00             | 99.00         |
|Clothing,Womens |No Logo Assymmetric Dress        |2        | 150.00            | 300.00        |