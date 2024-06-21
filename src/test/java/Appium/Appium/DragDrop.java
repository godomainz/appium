package Appium.Appium;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class DragDrop extends BaseTest {
	
	@Test
	public void dragDropTest() {
		WebElement viewsBtn = driver.findElement(AppiumBy.accessibilityId("Views"));
		viewsBtn.click();
		
		WebElement dragDropBtn = driver.findElement(AppiumBy.accessibilityId("Drag and Drop"));
		dragDropBtn.click();
		
		WebElement firstDotElement = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_1"));
//		dragDrop(firstDotElement, firstDotElement.getSize().width, firstDotElement.getSize().height);
		dragDrop(firstDotElement, 623, 532);
		
		WebElement droppedTxtElement = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_result_text"));
		String droppedTxt = droppedTxtElement.getText();
		
		Assert.assertEquals(droppedTxt, "Dropped!");
		
	}

}
