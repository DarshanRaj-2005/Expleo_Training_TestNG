package com.tests;

import org.testng.annotations.Test;

public class ProductPageTest extends BaseTest {
  @Test
  public void productpageTest() {
	  
	  objLoginpage.login("DarshanRaj","dharshan123");
	  objHomepage.homepageAction();
	  objProductpage.productPageAction();
	  
	  objProductpage.alerthandle();
	  System.out.println("Product Added to cart successfully");
  }
}
