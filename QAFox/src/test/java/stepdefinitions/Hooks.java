package stepdefinitions;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;


public class Hooks {
	public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public static WebDriverWait wait;
    
    @Before
    public void setup(Scenario scenario) {
    	ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        
        driver.set(new ChromeDriver(options));
        wait = new WebDriverWait(driver.get(), Duration.ofSeconds(10));
    }
    
    @After
    public void tearDown(Scenario scenario) throws IOException {
    	if(scenario.isFailed())
		{
			TakesScreenshot sc = (TakesScreenshot) driver.get();
			File src = sc.getScreenshotAs(OutputType.FILE);
			FileHandler.copy(src, new File("test-output/screenshots/"+scenario.getName()+System.currentTimeMillis()+".png"));
			
			byte[] img = sc.getScreenshotAs(OutputType.BYTES);
			scenario.attach(img, "image/png", "Failure Screenshot");
			
		}
	
		if (driver.get() != null) {
			driver.get().quit();
			driver.remove();
		}
    }
}
