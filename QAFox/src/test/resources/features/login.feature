Feature:LoginFearure

	Background:
		Given the user launches the application
		
	@ValidLogin
	Scenario Outline: Verify login with valid credentials
	
	 Given the user is on login page
	 When the user enters the valid email as "<email>"
	 When the user enters the valid password as "<password>"
	 And click login
	 Then the link should appear as "<linkText>";
	 
	 Examples:
	 | email                        | password | linkText                      |
	 | darshan3@gmail.com | darshan10     | Edit your account information |
	 | darshan@gmail.com1 | darshan10     | Edit your account information |