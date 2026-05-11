import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class DownloadPDF {

	public static void main(String[] args) throws InterruptedException {
		String downloadFilepath = System.getProperty("user.dir") + File.separator + "downloads";
		
		ChromeOptions options = new ChromeOptions();
		
		Map<String,Object> prefs = new HashMap<>();
		prefs.put("download.default_directory", downloadFilepath);
		options.setExperimentalOption("prefs",prefs);
		
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/upload-download");
		WebElement download = driver.findElement(By.xpath("//*[@id=\"downloadButton\"]"));
		download.click();
		
		
		Thread.sleep(5000);
		File downloaded = new File(downloadFilepath + File.separator + "sampleFile.jpeg");
	
		
		if(downloaded.exists()) {
			System.out.println("File is downloaded");
		}
		else {
			System.out.println("File not downloaded");
		}
		driver.quit();
	}

}
