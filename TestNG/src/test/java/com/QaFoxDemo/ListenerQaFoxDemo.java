package com.QaFoxDemo;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerQaFoxDemo implements ITestListener {

    public void onTestFailure(ITestResult result) {
        System.out.println("Test Failed : " + result.getName());

        Object testClass = result.getInstance();
        WebDriver driver = ((QaFoxDemo) testClass).getDriver();

        screenshot(driver, result.getName());
    }

    public void screenshot(WebDriver driver, String testName) {

        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        File dest = new File("C:\\Users\\dhars\\Documents\\SeleniumAndTesting\\TestNG\\Screenshots\\"
                + testName + ".png");

        try {
            FileUtils.copyFile(src, dest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
