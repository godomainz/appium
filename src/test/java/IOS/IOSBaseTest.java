package IOS;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class IOSBaseTest {
	public AppiumDriverLocalService localService;
	public IOSDriver driver;

	@BeforeClass
	public void configureAppium() throws MalformedURLException, URISyntaxException {
		String appiumJS = "//usr//local//lib//node_modules//appium//build//lib//main.js";
		AppiumServiceBuilder service = new AppiumServiceBuilder();
		service.withAppiumJS(new File(appiumJS));
		service.withIPAddress("127.0.0.1");
		service.usingPort(4723);
		
		localService =  service.build();
		localService.start();
		
		XCUITestOptions options = new XCUITestOptions();
		options.setDeviceName("iPhone 12 Pro");
		options.setApp("//Users//akila//eclipse-workspace//Appium//src//test//java//resources//UIKitCatalog.app");
		options.setPlatformVersion("17.2");
		options.setWdaLaunchTimeout(Duration.ofSeconds(5));
		
		driver = new IOSDriver(new URI("http://127.0.0.1:4723").toURL(), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
		localService.stop();

	}
	
}
