package com.stepDefinition;

import org.testng.Assert;

import com.actions.HomePageActions;
import com.actions.LoginPageActions;
import com.pages.LoginPageLocators;
import com.utils.HelperClass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageDefinition {
	
	LoginPageActions objLogin = new LoginPageActions();
	HomePageActions objHomePage = new HomePageActions();
	LoginPageLocators loginLocators = new LoginPageLocators();
	
	@Given("the user is on HRMLogin page {string}")
	public void loginTest(String url) {
		HelperClass.openPage(url);
	}
	
	@When("the user enters username and password")
	public void goToHomePage() {
		objLogin.login();
	}
	
	@Then("the user should be able to login successfully and should see Dashboard")
	public void verifyLogin() {
		Assert.assertTrue(objHomePage.getHomePageText().contains("Dashboard"));
	}
	
	@Then("the user should see invalid credentials message")
	public void the_user_should_see_invalid_credentials_message() {
	    Assert.assertTrue(loginLocators.message.getText().contains("Invalid credentials"));
	}
}
