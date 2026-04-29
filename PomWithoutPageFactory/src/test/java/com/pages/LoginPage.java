package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	WebDriver driver;
	
	By username = By.name("username");
	
	By password = By.name("password");
	
	By loginBtn = By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button");
	
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void setUsername(String strusername) {
		driver.findElement(username).sendKeys(strusername);
	}
	
	public void setPassword(String strpassword) {
		driver.findElement(password).sendKeys(strpassword);
	}
	
	public void clickLogin() {
		driver.findElement(loginBtn).click();
	}
	
	public String getLoginTitle() {
		return driver.getTitle();
	}
	
	public void loginProcess(String strusername, String strpassword) {
		setUsername(strusername);
		setPassword(strpassword);
		clickLogin();
	}
}
