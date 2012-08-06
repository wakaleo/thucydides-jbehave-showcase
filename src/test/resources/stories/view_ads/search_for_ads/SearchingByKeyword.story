In order to find the items I am interested in faster
As a buyer
I want to be able to list all the ads with a particular keyword in the description or title.

Scenario: Searching by keyword and category

Given Sally wants to buy some antique stamps for her son
When she looks for ads in the 'Antiques' category containing 'stamps'
Then she should obtain a list of ads related to 'stamps' from the 'Antiques' category

Scenario: Searching by keyword and location

Given Sally wants to buy a puppy for her son
When she looks for ads in the Pets & Animals category containing puppy in New South Wales
Then she should obtain a list of Pets & Animals ads containing the word puppy from advertisers in New South Wales
