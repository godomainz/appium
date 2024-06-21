package Appium.Appium;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class Swipe extends BaseTest {
	
	@Test
	public void swipeTest() {
		WebElement viewsBtn = driver.findElement(AppiumBy.accessibilityId("Views"));
		viewsBtn.click();
		
		WebElement galleryBtn = driver.findElement(AppiumBy.accessibilityId("Gallery"));
		galleryBtn.click();
		
		WebElement photosBtn = driver.findElement(AppiumBy.accessibilityId("1. Photos"));
		photosBtn.click();
		
		WebElement galleryElement = driver.findElement(AppiumBy.id("io.appium.android.apis:id/gallery"));
		galleryElement.click();
		
		
		WebElement firstImage = driver.findElement(AppiumBy.xpath("//android.widget.ImageView[1]"));
		String focusable = firstImage.getAttribute("focusable");
		Assert.assertEquals(focusable, "true");
		
		swipeAction(firstImage, "left");
		
		firstImage = driver.findElement(AppiumBy.xpath("//android.widget.ImageView[1]"));
		focusable = firstImage.getAttribute("focusable");
		Assert.assertEquals(focusable, "false");
	}
}
