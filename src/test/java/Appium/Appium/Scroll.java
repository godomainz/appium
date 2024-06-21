package Appium.Appium;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class Scroll extends BaseTest {
	
	@Test
	public void scroll() {
		WebElement viewsBtn = driver.findElement(AppiumBy.accessibilityId("Views"));
		viewsBtn.click();
		
//		scrollAction("WebView");
		scrollJSAction("down");
		
		
	}

}
