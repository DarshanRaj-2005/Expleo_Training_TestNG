import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChooseFileOption {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/upload-download");
		
		WebElement upload = driver.findElement(By.id("uploadFile"));
		upload.sendKeys("C:\\New folder\\Online Movie Ticket Booking.pdf");
		
		
		WebElement text = driver.findElement(By.id("uploadedFilePath"));
		wait.until(ExpectedConditions.visibilityOf(text));
		System.out.println(text.getText());
		driver.quit();
	}
}
