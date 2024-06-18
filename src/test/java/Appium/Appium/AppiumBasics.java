package Appium.Appium;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class AppiumBasics extends BaseTest {
	
	@Test
	private void wifiSettingsName() throws MalformedURLException, URISyntaxException {
		WebElement preferenceBtn = driver.findElement(AppiumBy.accessibilityId("Preference"));
		preferenceBtn.click();
	}

}
