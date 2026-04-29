package com.test;

import org.testng.Assert;
import org.testng.annotations.Test;



public class LoginTest extends BaseTest{
  @Test(priority = 0)
  public void loginTest() {
	 
	  objLogin.loginProcess("Admin","admin123");
	  
	  String loginPageTitle = objLogin.getLoginTitle();
	  
	  System.out.println("Login Page Title: "+loginPageTitle);
	  
	  String title = "OrangeHRM";
	  
	  Assert.assertEquals(loginPageTitle,title);
  }
}
