package com.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage {
	
	WebDriver driver;

	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span/h6")
	public WebElement dashboardPageTitle;
	
	public DashboardPage(WebDriver driver) {
		super(driver);
	}
	
	public String getHomepageTitle() {
		return dashboardPageTitle.getText();
	}
	
}
