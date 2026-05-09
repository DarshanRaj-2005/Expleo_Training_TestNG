package com.utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperClass {
	private static HelperClass helperClass;
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	private static ThreadLocal<WebDriverWait> wait = new ThreadLocal<>();
	public final static int TIMEOUT = 10;
	
	
	HelperClass() {
		WebDriver webdriver = new ChromeDriver();
		driver.set(webdriver);
		wait.set(new WebDriverWait(webdriver, Duration.ofSeconds(TIMEOUT)));
		webdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		webdriver.manage().window().maximize();
	}
	
	public static void openPage(String url) {
		driver.get().get(url);
	}
	
	public static void setupDriver() {
		if(helperClass == null) {
			helperClass = new HelperClass(); 
		}
	}
	
	public static WebDriver getDriver() {
		return driver.get();
	}
	
	public static void tearDown() {
	    if(driver != null) {
	        driver.get().quit();
	        driver = null;
	    }
	    helperClass = null;
	}
}
