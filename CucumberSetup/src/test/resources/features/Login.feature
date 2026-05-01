Feature: Login to HRM application

	@validCredentails
	Scenario: Login with valid credentials

	Given user is on home page
	When User enters username as "Admin"
	And user enters password as "admin123"
	Then user should be able to login successfully