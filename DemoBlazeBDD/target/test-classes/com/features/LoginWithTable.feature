Feature:Login


Background:
Given the user is on the home page
When the user click "Log in" link
Then the log in page opens

    @validCredentials @Smoke
    Scenario:
	When the user enters credentials
	| DarshanRaj  | dharshan123 |
	And the user click "Log in" button
	Then the user should see "Welcome DarshanRaj"
	
	
	@LoginwithInvalidCredentials
	Scenario Outline:
:
	When the user enters username "<username>"
	And the user enters password "<password>"
	When the user click "Log in" button
	Then the user should see "<errorMessage>" message
    
    
    Examples:
|username       |password       |errorMessage        |
|Darsh          |dharshan123    |user does not exist |
|DarshanRaj     |Darshan@12     |Wrong password      |
    