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

	public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	LoginPage objLoginpage;
	HomePage objHomepage;
	ProductPage objProductpage;
	
	@BeforeMethod
	@Parameters({"browser","url"})
	public void beforeMethod(String browser, String url) {
		driver.set(new ChromeDriver());
		driver.get().manage().window().maximize();
		driver.get().get(url);

		new WebDriverWait(driver.get(), Duration.ofSeconds(30))
				.until(ExpectedConditions.visibilityOfElementLocated(By.id("login2")));

		objLoginpage = new LoginPage(driver.get());
		objHomepage = new HomePage(driver.get());
		objProductpage = new ProductPage(driver.get());
	}

	@AfterMethod
	public void afterMethod() {
	  driver.get().quit();
	}
	
	public static WebDriver getDriver() {
		return driver.get();
	}
}
