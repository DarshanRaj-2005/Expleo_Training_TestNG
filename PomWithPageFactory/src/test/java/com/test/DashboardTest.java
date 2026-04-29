package com.test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {
  @Test
  public void dashboardTest() {
	  
	  objLogin.loginProcess("Admin","admin123");
	  
	  String dashboardTitle = objDashboard.getHomepageTitle();
	  
	  System.out.println("Dashboard Page Title: "+dashboardTitle);
	  
	  String title = "Dashboard";
	  
	  Assert.assertEquals(dashboardTitle, title);
  }
}
