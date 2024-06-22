package Ecommerce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MobileBrowser extends BrowserBaseTest {
	
	@Test
	public void mobileBrowserTest() throws InterruptedException {
		
//		driver.get("https://www.google.com/");
//		System.out.println(driver.getTitle());
//		driver.findElement(By.name("q")).sendKeys("Test");
//		Thread.sleep(Duration.ofSeconds(3));
//		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.xpath("//span[@class='navbar-toggler-icon']")).click();
		driver.findElement(By.cssSelector(".nav-link[routerlink='/products']")).click();
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,1000)", "");
		String text = driver.findElement(By.cssSelector("a[href*='products/3']")).getText();
		Assert.assertEquals(text, "Devops");

	}

}
