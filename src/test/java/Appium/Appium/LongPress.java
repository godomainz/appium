package Appium.Appium;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;
import com.google.common.collect.ImmutableMap;
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

		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of("elementId", ((RemoteWebElement) peoplesNamesBtn).getId(), "duration", 2000));

	}
}
