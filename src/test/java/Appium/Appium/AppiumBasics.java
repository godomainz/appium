package Appium.Appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumBasics {
	
	@Test
	private void AppiumTest() throws MalformedURLException, URISyntaxException {
		
		String appiumJS = "C:\\Users\\Akila\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js";
		AppiumServiceBuilder service = new AppiumServiceBuilder();
		service.withAppiumJS(new File(appiumJS));
		service.withIPAddress("127.0.0.1");
		service.usingPort(4723);
		
		AppiumDriverLocalService localService =  service.build();
		localService.start();
		
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("Pixel 4 API 30");
		options.setApp("F:\\Eclipse Workspace\\Appium\\src\\test\\java\\resources\\ApiDemos-debug.apk");
		
		AndroidDriver driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
		driver.quit();
		
		localService.stop();

	}

}
