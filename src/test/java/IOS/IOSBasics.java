package IOS;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class IOSBasics extends IOSBaseTest {
	@Test
	public void IOSBasicsTest() {
		WebElement alertViewBtnElement = driver.findElement(AppiumBy.accessibilityId("Alert Views"));
		alertViewBtnElement.click();
		
	}

}
