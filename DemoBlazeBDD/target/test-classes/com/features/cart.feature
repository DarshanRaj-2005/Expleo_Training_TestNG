Feature:Cart


	@addToCart
	Scenario:
	Given the user is on home page
	When the user click "Sony vaio i5" link
	Then the user is on product page
	And the user click "Add to cart" button
	Then the user should see "Product Added"
		
	@checkCart
	Scenario:
	Given the user is on home page
	When the user click "Cart" link
	Then the user redirected to cart page
	And the user can see the product added to cart
	
	@removeFromCart
	Scenario:
	Given the user is on cart page
	When the user click "delete" link
	Then the product should be removed from cart

