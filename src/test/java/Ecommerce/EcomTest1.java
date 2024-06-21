package Ecommerce;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class EcomTest1 extends BaseTest{

	@Test
	private void fillForm() throws InterruptedException {
		WebElement nameTxtElement = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField"));
		nameTxtElement.sendKeys("Akila");
		driver.hideKeyboard();
		
		WebElement femaleRadioElement = driver.findElement(AppiumBy.xpath("//android.widget.RadioButton[@text='Female']"));
		femaleRadioElement.click();
		
		WebElement countryDropDownElement = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/spinnerCountry"));
		countryDropDownElement.click();
		
		String country = "Argentina";
		scrollAction(country);
		
		WebElement sriLankaCountryElement = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\""+country+"\"]"));
		sriLankaCountryElement.click();
		
		WebElement letsShopBtnElement = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop"));
		letsShopBtnElement.click();
		
		Thread.sleep(Duration.ofSeconds(3));

	}
}
