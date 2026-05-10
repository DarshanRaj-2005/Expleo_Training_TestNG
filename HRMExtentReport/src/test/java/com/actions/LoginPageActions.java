package com.actions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.support.PageFactory;

import com.pages.LoginPageLocators;
import com.utils.HelperClass;

public class LoginPageActions {
	LoginPageLocators loginpagelocators;
	String strUsername, strPassword;
	
	public LoginPageActions() {
		this.loginpagelocators = new LoginPageLocators();
		
		PageFactory.initElements(HelperClass.getDriver(), loginpagelocators);
	}
	 
	public void setUserName(String strUsername) {
		loginpagelocators.username.sendKeys(strUsername);
	}
	
	public void setPassword(String strPassword) {
		loginpagelocators.password.sendKeys(strPassword);
	}
	
	public void clickLogin() {
		loginpagelocators.login.click();
	}
	
	public void login() {
		File file = new File("C:\\Users\\dhars\\Documents\\SeleniumAndTesting\\HRMExtentReport\\src\\test\\resources\\testdata.properties");
		
		FileInputStream fileInput = null;
		
		try {
			fileInput = new FileInputStream(file);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		
		Properties prop = new Properties();
		
		try {
			prop.load(fileInput);
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		strUsername = prop.getProperty("validusername");
		strPassword = prop.getProperty("validpassword");
		
		this.setUserName(strUsername);
		this.setPassword(strPassword);
		this.clickLogin();
		
	}
}
