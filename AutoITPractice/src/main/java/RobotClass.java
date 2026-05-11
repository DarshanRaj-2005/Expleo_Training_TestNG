import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RobotClass {
	public static void main(String [] args) throws AWTException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();
		driver.get("https://pdf2doc.com/");
		driver.findElement(By.id("uploadBtn")).click();
		
		Robot rb = new Robot();
		rb.delay(2000);
		StringSelection str = new StringSelection("C:\\New folder\\Online Movie Ticket Booking.pdf");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str,null);
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);
		rb.delay(1000);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		
		driver.quit();
	}
}
