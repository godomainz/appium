package Ecommerce;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class ValidatingTotal extends BaseTest {
	
	@Test
	private void valTotalTest() throws InterruptedException {
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
		driver.findElements(AppiumBy.id("com.androidsample.generalstore:id/productAddCart")).get(0).click();
		driver.findElements(AppiumBy.id("com.androidsample.generalstore:id/productAddCart")).get(1).click();
		
		WebElement cartIconElement = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/appbar_btn_cart"));
		cartIconElement.click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.androidsample.generalstore:id/toolbar_title")));
		
		List<WebElement> pricesElements = driver.findElements(AppiumBy.id("com.androidsample.generalstore:id/productPrice"));
		System.out.println(pricesElements.size());
		
		Double total = 0.0;
		for(int i=0; i< pricesElements.size();i++) {
			Double price =getFormattedAmount(pricesElements.get(i).getText());
			total = total + price;
			System.out.println(price);
		}
		
		Double totalAmount = getFormattedAmount(driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/totalAmountLbl")).getText());
		Assert.assertEquals(total, totalAmount);
		
		WebElement termsElement = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/termsButton"));
		longPressAction(termsElement);
		
		WebElement closeBtnElement = driver.findElement(AppiumBy.id("android:id/button1"));
		closeBtnElement.click();
		
		WebElement sendEmailElement = driver.findElement(AppiumBy.xpath("//android.widget.CheckBox[@text=\"Send me e-mails on discounts related to selected products in future\"]"));
		sendEmailElement.click();

		WebElement visitWebElement = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnProceed"));
		visitWebElement.click();
		
		Thread.sleep(Duration.ofSeconds(3));
	}

}
