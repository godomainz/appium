package Appium.Appium;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class AppiumBasics extends BaseTest {
	
	@Test
	public void wifiSettingsName() throws MalformedURLException, URISyntaxException {
		WebElement preferenceBtn = driver.findElement(AppiumBy.accessibilityId("Preference"));
		preferenceBtn.click();
		
		WebElement preferenceDependenciesBtn = driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"3. Preference dependencies\"]"));
		preferenceDependenciesBtn.click();
		
		WebElement wifiCheckBox = driver.findElement(By.id("android:id/checkbox"));
		wifiCheckBox.click();
		
		WebElement wifiSettingsBtn = driver.findElement(By.xpath("//android.widget.ListView[@resource-id=\"android:id/list\"]/android.widget.LinearLayout[2]/android.widget.RelativeLayout"));
		wifiSettingsBtn.click();
	}

}
