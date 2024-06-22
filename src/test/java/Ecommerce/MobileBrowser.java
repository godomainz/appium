package Ecommerce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class MobileBrowser extends BrowserBaseTest {
	
	@Test
	public void mobileBrowserTest() throws InterruptedException {
		
		driver.get("https://www.google.com/");
		System.out.println(driver.getTitle());
		driver.findElement(By.name("q")).sendKeys("Test");
		Thread.sleep(Duration.ofSeconds(3));
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);

	}

}
