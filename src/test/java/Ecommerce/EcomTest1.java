package Ecommerce;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

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
		
		String productName = "Jordan 6 Rings";
		scrollAction(productName);
		
		List<WebElement> productElements = driver.findElements(AppiumBy.xpath("//android.support.v7.widget.RecyclerView[@resource-id=\"com.androidsample.generalstore:id/rvProductList\"]/android.widget.RelativeLayout/android.widget.LinearLayout"));
		System.out.println(productElements.size());
		
		WebElement productElement = null;
		for (Iterator<WebElement> iterator = productElements.iterator(); iterator.hasNext();) {
			WebElement webElement = (WebElement) iterator.next();
			String productNameTmp = webElement.findElement(AppiumBy.id("com.androidsample.generalstore:id/productName")).getText();
			if(productNameTmp.equalsIgnoreCase(productName)) {
				productElement = webElement;
				break;
			}
		}
		
		WebElement addTocartBtnElement = productElement.findElement(AppiumBy.id("com.androidsample.generalstore:id/productAddCart"));
		addTocartBtnElement.click();
		
		WebElement cartIconElement = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/appbar_btn_cart"));
		cartIconElement.click();
		
		Thread.sleep(Duration.ofSeconds(3));

	}
}
