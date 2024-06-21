package Ecommerce;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest {
	
	public AppiumDriverLocalService localService;
	public AndroidDriver driver;
	
	@BeforeClass
	public void configureAppium() throws MalformedURLException, URISyntaxException {
		String appiumJS = "C:\\Users\\Akila\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js";
		AppiumServiceBuilder service = new AppiumServiceBuilder();
		service.withAppiumJS(new File(appiumJS));
		service.withIPAddress("127.0.0.1");
		service.usingPort(4723);
		
		localService =  service.build();
		localService.start();
		
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("Pixel 4 API 30");
		options.setApp("F:\\Eclipse Workspace\\Appium\\src\\test\\java\\resources\\General-Store.apk");
		
		driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public void longPressAction(WebElement element) {
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of("elementId", ((RemoteWebElement) element).getId(), "duration", 2000));

	}

	public void scrollAction(String text) {
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"));"));
	}
	
	public void scrollJSAction(String direction) {
		boolean canScrollMore =false;
		do {
			canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
				    "left", 500, "top", 500, "width", 600, "height", 600,
				    "direction", direction,
				    "percent", 3.0
				));
		} while (canScrollMore);
	}
	
	public void swipeAction(WebElement element, String direction) {
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
				"elementId",((RemoteWebElement)element).getId(),
			    "direction", direction,
			    "percent", 0.5
			));

	}
	
	public void dragDrop(WebElement element, int x, int y) {
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) element).getId(),
			    "endX", x,
			    "endY", y
			));
	}
	
	public void startActivity(String fullActivityName) {
		((JavascriptExecutor) driver).executeScript("mobile: startActivity", ImmutableMap.of("intent", fullActivityName));
	}


	@AfterClass
	public void tearDown() {
		driver.quit();
		localService.stop();

	}
}
