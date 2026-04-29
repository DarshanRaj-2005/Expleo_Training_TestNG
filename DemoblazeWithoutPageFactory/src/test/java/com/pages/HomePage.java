package com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver,Duration.ofSeconds(30));
	}
	
	By title = By.id("nava");
	By samsungs7 = By.xpath("//*[@id=\"tbodyid\"]/div[4]/div/div/h4/a");
	By productTitle = By.xpath("//*[@id=\"tbodyid\"]/h2");
	By logout = By.id("logout2");
	
	public void clickSamsung() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(logout));
		wait.until(ExpectedConditions.elementToBeClickable(samsungs7));
		driver.findElement(samsungs7).click();
	}
	
	public String ProductTitle() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(productTitle));
		return driver.findElement(productTitle).getText();
	}
	
	public void homepageAction() {
		clickSamsung();
	}
}
