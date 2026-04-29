package com.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {
  @Test
  public void loginTest() {
	  objLoginpage.login("DarshanRaj","dharshan123");
	  
	  String logout = objLoginpage.logout();
	  String result = "Log out";
	  
	  Assert.assertEquals(result, logout,"loggin not success");
	  System.out.println("log in success");
  }
}
