package General_Store;

import java.net.MalformedURLException;
import java.net.URL;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class BaseClass {
	public AndroidDriver driver;
	@BeforeClass
	public void OpenApp() throws MalformedURLException {
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("Google Pixel");
		options.setApp("C:\\Users\\PardhaSaradhiWudaru\\eclipse-workspace\\Appium_Sample\\House_Party\\src\\test\\java\\resources\\General-Store.apk");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), options);
	}
	
	@AfterClass
	public void CloseApp() {
		driver.quit();
	}
}