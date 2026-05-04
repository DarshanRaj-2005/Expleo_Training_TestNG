package com.stepDefinition;

import java.time.Duration;

import io.cucumber.java.Before;
import io.cucumber.java.After;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefinition {

	WebDriver driver;
	WebDriverWait wait;

	@Before
	public void setup() {
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		driver.manage().window().maximize();

	}

	@Given("the user is on the home page")
	public void the_user_is_on_the_home_page() {
		driver.get("https://demoblaze.com/");
	}

	@When("the user click {string} link")
	public void the_user_click_link(String string) {
		driver.findElement(By.id("login2")).click();
	}

	@Then("the log in page opens")
	public void the_log_in_page_opens() {
		WebElement text = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logInModalLabel")));
		String message = "Log in";
		Assert.assertEquals(text.getText(), message);
		System.out.println("Log in tab appears");
	}

	@When("the user enters username {string}")
	public void the_user_enters_username(String string) {
		WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername")));
	    username.sendKeys(string);
	}

	@When("the user enters password {string}")
	public void the_user_enters_password(String string) {
		driver.findElement(By.id("loginpassword")).sendKeys(string);
	}

	@When("the user click {string} button")
	public void the_user_click_button(String string) {
		driver.findElement(By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[2]")).click();
	}

	@Then("the user should see {string}")
	public void the_user_should_see(String string) {
		WebElement mes = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nameofuser")));
		Assert.assertEquals(mes.getText(), "Welcome DarshanRaj");
	}

	@Then("the user should see {string} message")
	public void the_user_should_see_message(String string) {
		wait.until(ExpectedConditions.alertIsPresent());
	    Alert alert = driver.switchTo().alert();
	    alert.accept();
	}
	@After
	public void tearDown() {
		driver.quit();
	}
}
