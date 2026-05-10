Feature: Login to HRM Application

@ValidCredentials 
Scenario: Login with Valid Credentials

Given the user is on HRMLogin page "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
When the user enters validusername and validpassword
Then the user should be able to login successfully and should see Dashboard

@InvalidCredentials
Scenario:Login with Invalid Credentials
Given the user is on HRMLogin page "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
When the user enters invalidusername and invalidpassword
Then the user should see invalid credentials message

