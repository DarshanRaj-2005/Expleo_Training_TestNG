package com.tests;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerDemoblaze implements ITestListener{
	
	private static final Logger log = LogManager.getLogger(ListenerDemoblaze.class);
	
	public void onTestStart(ITestResult result) {
		log.info("Test Started " + result.getName());
	}
	
	public void onTestSuccess(ITestResult result) {
		log.info("Test Success "+ result.getName());
	}
	
	public void onTestFailure(ITestResult result) {
		
		log.error("Failed Test: "+ result.getName());
		
		WebDriver driver = BaseTest.getDriver();
		
		try {
			long time = System.currentTimeMillis();
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			File dest = new File("C:\\Users\\dhars\\Documents\\SeleniumAndTesting\\DemoblazeWithoutPageFactory\\src\\test\\Screenshots\\"+result.getName()+"_"+time+".png");
			FileUtils.copyFile(src,dest);
		}catch(Exception e){
			log.error("Screenshot failed "+e);
		}
		
	}
	
	public void onTestSkipped(ITestResult result) {
		log.info("Skipped Test "+result.getName());
	}
}
