package com.tests;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.pages.*;

public class BaseTest {

	WebDriver driver;

	LoginPage objLoginpage;
	HomePage objHomepage;
	ProductPage objProductpage;
	
	@BeforeMethod
	@Parameters({"browser","url"})
	public void beforeMethod(String browser, String url) {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);

		new WebDriverWait(driver, Duration.ofSeconds(30))
				.until(ExpectedConditions.visibilityOfElementLocated(By.id("login2")));

		objLoginpage = new LoginPage(driver);
		objHomepage = new HomePage(driver);
		objProductpage = new ProductPage(driver);
	}

	@AfterMethod
	public void afterMethod() {
	  driver.quit();
	}
	
	public WebDriver getDriver() {
		return driver;
	}

}
