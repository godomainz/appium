package IOS;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class IOSBasics extends IOSBaseTest {
	@Test
	public void IOSBasicsTest() {
		WebElement alertViewBtnElement = driver.findElement(AppiumBy.accessibilityId("Alert Views"));
		alertViewBtnElement.click();
		
		WebElement textEntryBtnElement = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`name == \"Text Entry\"`]"));
		textEntryBtnElement.click();
		
		WebElement shortTitleTxtElement = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeCell"));
		shortTitleTxtElement.sendKeys("Hello World");
		
		WebElement okBtnElement = driver.findElement(AppiumBy.accessibilityId("OK"));
		okBtnElement.click();
		
	}

}
