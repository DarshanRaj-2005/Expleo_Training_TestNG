package com.test;


import com.pages.LoginPage;
import com.pages.DashboardPage;

import org.testng.annotations.BeforeClass;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class BaseTest {
	
	public static WebDriver driver;
	LoginPage objLogin;
	DashboardPage objDashboard;

  @BeforeClass
  public void setup() {
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	  driver.get("https://opensource-demo.orangehrmlive.com/");
	  
	  objLogin = new LoginPage(driver);
	  objDashboard = new DashboardPage(driver);
  }

  @AfterClass
  public void close() {
	  driver.close();
  }

}
