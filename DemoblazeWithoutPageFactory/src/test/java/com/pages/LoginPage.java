package com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver,Duration.ofSeconds(30));
	}
	
	By login = By.id("login2");
	
	By username = By.id("loginusername");
	
	By password = By.id("loginpassword");
	
	By loginBtn = By.xpath("//button[text()='Log in']");
	
	By logout = By.id("logout2");
	
	public void clickLogin() {
		wait.until(ExpectedConditions.elementToBeClickable(login));
		driver.findElement(login).click();
	}
	 
	public void setUsername(String strusername) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(username));
		driver.findElement(username).sendKeys(strusername);
	}
	
	public void setPassword(String strpassword) {
		driver.findElement(password).sendKeys(strpassword);
	}
	
	public void clickLoginBtn() {
		driver.findElement(loginBtn).click();
	}
	
	public String logout() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(logout));
		return driver.findElement(logout).getText();
	}
	public void login(String strusername, String strpassword) {
		clickLogin();
		setUsername(strusername);
		setPassword(strpassword);
		clickLoginBtn();
	}
}
