package com.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	
	WebDriver driver;
	
	@FindBy(name ="username")
	public WebElement username;
	
	@FindBy(name = "password")
	public WebElement password;
	
	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")
	public WebElement loginBtn;
	
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	public void setUsername(String strusername) {
		username.sendKeys(strusername);
	}
	
	public void setPassword(String strpassword) {
		password.sendKeys(strpassword);
	}
	
	public void clickLogin() {
		loginBtn.click();
	}
	
	public void loginProcess(String strusername, String strpassword) {
		setUsername(strusername);
		setPassword(strpassword);
		clickLogin();
	}
}
