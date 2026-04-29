package com.tests;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.pages.*;

public class BaseTest {

	WebDriver driver;

	LoginPage objLoginpage;
	HomePage objHomepage;
	ProductPage objProductpage;

	@BeforeClass
	public void beforeClass() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoblaze.com/");

		new WebDriverWait(driver, Duration.ofSeconds(30))
				.until(ExpectedConditions.visibilityOfElementLocated(By.id("login2")));

		objLoginpage = new LoginPage(driver);
		objHomepage = new HomePage(driver);
		objProductpage = new ProductPage(driver);
	}

	@AfterClass
	public void afterClass() {
	  driver.quit();
	}

}
