Feature:purchase


@successfulPurchase
Scenario:
Given the user on home page
When the user click "Sony vaio i5" link
And the user clicks "Add to cart" button
When the user clicks "cart" link
Then the user is on cart page
And the user click "Place order" button

