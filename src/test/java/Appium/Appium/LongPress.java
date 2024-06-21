package Appium.Appium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumBy;

public class LongPress extends BaseTest {

	@Test
	public void longPress() {
		WebElement viewsBtn = driver.findElement(AppiumBy.accessibilityId("Views"));
		viewsBtn.click();
		
		WebElement expandableListsBtn = driver.findElement(AppiumBy.accessibilityId("Expandable Lists"));
		expandableListsBtn.click();
		
		WebElement customAdapterBtn = driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter"));
		customAdapterBtn.click();
		
		WebElement peoplesNamesBtn = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"People Names\"]"));

		longPressAction(peoplesNamesBtn);
		
		WebElement sampleMenuLbl = driver.findElement(By.id("android:id/title"));
		String sampleMenu = sampleMenuLbl.getText();
		
		Assert.assertTrue(sampleMenuLbl.isDisplayed());
		Assert.assertEquals(sampleMenu, "Sample menu");
		

	}
}
