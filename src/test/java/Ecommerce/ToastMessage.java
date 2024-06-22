package Ecommerce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class ToastMessage extends BaseTest {
	
	@Test
	private void toastMessageTest() {
		WebElement letsShopBtnElement = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop"));
		letsShopBtnElement.click();
		
		WebElement toastElement = driver.findElement(By.xpath("//android.widget.Toast[1]"));
		String toastMessage = toastElement.getAttribute("name");
		Assert.assertEquals(toastMessage, "Please enter your name");
	}

}
