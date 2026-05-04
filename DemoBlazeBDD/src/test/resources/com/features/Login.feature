Feature:Login


Background:
Given the user is on the home page
When the user click "Log in" link
Then the log in page opens

    @validCredentials @Smoke
    Scenario:
	When the user enters username "DarshanRaj"
	And the user enters password "dharshan123"
	When the user click "Log in" button
	Then the user should see "Welcome DarshanRaj"
	
	@invalidPassword
	Scenario:
	When the user enters username "Darshan"
	And the user enters password "Darshan"
	When the user click "Log in" button
	Then the user should see "Wrong password" message
	
	@invalidUsername
	Scenario:
	When the user enters username "Dars"
	And the user enters password "Darshan@12"
	When the user click "Log in" button
	Then the user should see "Wrong password" message
    
    