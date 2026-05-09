package com.stepDefinition;

import io.cucumber.java.Scenario;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.utils.HelperClass;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

	public static Logger log = LogManager.getLogger(Hooks.class);

	@Before
	public static void setUp(Scenario scenario) {
		HelperClass.setupDriver();
		HelperClass.getDriver().navigate().refresh();
		log.info("Scenario started: {}", scenario.getName());
	}

	@After
	public static void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			File screenshotFile = ((TakesScreenshot) HelperClass.getDriver()).getScreenshotAs(OutputType.FILE);

			try {
				File destination = new File("screenshots/" + scenario.getName().replaceAll(" ", "_") + ".png");
				FileUtils.copyFile(screenshotFile, destination);
				byte[] screenshotBytes = ((TakesScreenshot) HelperClass.getDriver()).getScreenshotAs(OutputType.BYTES);
				scenario.attach(screenshotBytes, "image/png", "Failure screenshot");
				log.error("Scenario failed: {}", scenario.getName());
			} catch (IOException e) {
				log.error("Failed to take screenshot: {}", e.getMessage());
			}
		} else {
			log.info("Scenario passed: {}", scenario.getName());
		}
		HelperClass.tearDown();
	}
}
