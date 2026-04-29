package com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage{
WebDriver driver;
WebDriverWait wait;
	
	public ProductPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver,Duration.ofSeconds(30));
	}
	
	By addToCart = By.xpath("//*[@id=\"tbodyid\"]/div[2]/div/a");
	
	public void clickAddToCart() {
		wait.until(ExpectedConditions.elementToBeClickable(addToCart));
		driver.findElement(addToCart).click();
	}
	
	public void alerthandle() {
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
	}
	public void productPageAction() {
		clickAddToCart();
	}
}
