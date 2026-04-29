package com.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest{
  @Test
  public void homepageTest() {
	  System.out.println("Homepage loaded successfully");
	  
	  objLoginpage.login("DarshanRaj","dharshan123");
	  objHomepage.homepageAction();
	  
	  String productTitle = objHomepage.ProductTitle();
	  
	  String title = "Samsung galaxy s7";
	  
	  Assert.assertEquals(title, productTitle);
	  System.out.println("Product Page Loaded Successfully");
  }
}
