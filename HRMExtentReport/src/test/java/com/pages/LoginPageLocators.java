package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageLocators {
		@FindBy(xpath = "//input[@placeholder='Username']")
		public WebElement username;
		
		@FindBy(xpath = "//input[@placeholder='Password']")
		public WebElement password;
		
		@FindBy(xpath = "//button[@type='submit']")
		public WebElement login;
		
		@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/div/div[1]/div[1]/p")
		public WebElement message;
}
