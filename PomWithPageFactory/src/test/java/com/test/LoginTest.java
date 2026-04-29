package com.test;

import org.testng.Assert;
import org.testng.annotations.Test;



public class LoginTest extends BaseTest{
  @Test
  public void loginTest() {
	 
	  
	  
	  String loginPageTitle = driver.getTitle();
	  
	  System.out.println("Login Page Title: "+loginPageTitle);
	  
	  String title = "OrangeHRM";
	  
	  Assert.assertEquals(loginPageTitle,title);
  }
}
