package Appium.Appium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class MiscellaneousAppiumActions extends BaseTest {
	
	@Test
	public void miscAppActions() {
		WebElement preferenceBtn = driver.findElement(AppiumBy.accessibilityId("Preference"));
		preferenceBtn.click();
		
		WebElement preferenceDependenciesBtn = driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"3. Preference dependencies\"]"));
		preferenceDependenciesBtn.click();
		
		
		WebElement wifiCheckBox = driver.findElement(By.id("android:id/checkbox"));
		wifiCheckBox.click();
		
		DeviceRotation landscape = new DeviceRotation(0, 0, 90);
		driver.rotate(landscape);
		
		WebElement wifiSettingsBtn = driver.findElement(By.xpath("//android.widget.ListView[@resource-id=\"android:id/list\"]/android.widget.LinearLayout[2]/android.widget.RelativeLayout"));
		wifiSettingsBtn.click();
		
		WebElement alertTitleLbl = driver.findElement(AppiumBy.id("android:id/alertTitle"));
		String alertTitle = alertTitleLbl.getText();
		Assert.assertEquals(alertTitle, "WiFi settings");
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		
		driver.setClipboardText("Akila Wifi");
		WebElement wifiNameTxt = driver.findElement(By.id("android:id/edit"));
		wifiNameTxt.sendKeys(driver.getClipboardText());
		
		List<WebElement> okBtn = driver.findElements(AppiumBy.className("android.widget.Button"));
		okBtn.get(1).click();
		
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
	}

}
