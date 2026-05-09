package com.actions;

import org.openqa.selenium.support.PageFactory;

import com.pages.HomePageLocators;
import com.utils.HelperClass;

public class HomePageActions {
	
	HomePageLocators homepagelocators;
	
	public HomePageActions() {
		this.homepagelocators = new HomePageLocators();
		PageFactory.initElements(HelperClass.getDriver(), homepagelocators);
	}
	
	public String getHomePageText() {
		return homepagelocators.homePageUserName.getText();
	}

}
