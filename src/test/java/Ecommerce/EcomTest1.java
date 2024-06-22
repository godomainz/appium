package Ecommerce;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
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
		
		String productName = "Jordan 6 Rings";
		scrollAction(productName);
		
		List<WebElement> productElements = driver.findElements(AppiumBy.id("com.androidsample.generalstore:id/productName"));
		System.out.println(productElements.size());
		
		WebElement productAddToCartBtnElement = null;
		for (int i=0;i<productElements.size();i++) {
			String productText = productElements.get(i).getText();
			if(productText.equalsIgnoreCase(productName)) {
				productAddToCartBtnElement = driver.findElements(AppiumBy.id("com.androidsample.generalstore:id/productAddCart")).get(i);
				break;
			}
		}
		
		productAddToCartBtnElement.click();

		WebElement cartIconElement = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/appbar_btn_cart"));
		cartIconElement.click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.androidsample.generalstore:id/toolbar_title")));
		
		List<WebElement> cartProductElements = driver.findElements(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productName\"]"));
		System.out.println(cartProductElements.size());
		boolean productFound = false;
		for (int i=0;i<cartProductElements.size();i++) {
			WebElement webElement = cartProductElements.get(i);
			String productNameTmp = webElement.getText();
			System.out.println(productNameTmp);
			if(productNameTmp.equalsIgnoreCase(productName)) {
				productFound = true;
				break;
			}
		}
		Assert.assertTrue(productFound);
		
		
		Thread.sleep(Duration.ofSeconds(3));

	}
}
