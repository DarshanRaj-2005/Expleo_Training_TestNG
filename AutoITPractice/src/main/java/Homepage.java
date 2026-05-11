import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Homepage {
	public static void main(String args[]) throws IOException {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();
		driver.get("https://pdf2doc.com/");
		driver.findElement(By.id("uploadBtn")).click();
		Runtime.getRuntime().exec("C:/Users/dhars/Downloads/pdftodoc.exe");
		driver.quit();
	}
}
