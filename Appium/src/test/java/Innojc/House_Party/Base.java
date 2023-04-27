package Innojc.House_Party;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Base {
	public AndroidDriver driver;
	
	@BeforeClass
	public void OpenApp() throws MalformedURLException {
		UiAutomator2Options options = new UiAutomator2Options();
		options.setChromedriverExecutable("C:\\Users\\PardhaSaradhiWudaru\\eclipse-workspace\\Appium_Sample\\House_Party\\src\\test\\java\\resources\\chromedriver.exe");
		options.setDeviceName("Google Pixel");
		options.setApp("C:\\Users\\PardhaSaradhiWudaru\\eclipse-workspace\\Appium_Sample\\House_Party\\src\\test\\java\\resources\\General-Store.apk");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), options);
	}
	
	public Double getFormattedAmount(String amount) {
		Double price = Double.parseDouble(amount.substring(1));
		return price;
	}
	
	public void longPressAction(WebElement ele) {
		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture", ImmutableMap.of("elementId",((RemoteWebElement)ele).getId(),"duration",2000));
	}
	
	@AfterClass
	public void ExitApp() {
		driver.quit();
	}
}