Narrative:
In order to find the product I want
As a customer
I want to be able to search for products with certain words in the title or description

Meta:
@tag component:search

Scenario: Search by keyword
Given that I want to find products in the "<range>" range
When I search for products by keyword "<keywords>"
Then I should see a product with the title <expectedTitle>

Examples:
| range              | keywords   | expectedTitle           |
| Simone             | Simone     | 3by3 Simone             |
| Grey Steel Classic | Steel      | 3by3 Grey Steel Classic |
| KV Bags            | KV         | KV Classic Satchel      |