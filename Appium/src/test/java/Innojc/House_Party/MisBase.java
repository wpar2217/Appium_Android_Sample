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

public class MisBase {
public AndroidDriver driver;
	
	@BeforeClass
	public void OpenApp() throws MalformedURLException {
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("Google Pixel");
		options.setApp("C:\\Users\\PardhaSaradhiWudaru\\eclipse-workspace\\House_Party\\src\\test\\java\\resources\\ApiDemos-debug.apk");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), options);
	}
	
	//To long press
	public void longPressAction(WebElement ele) {
		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture", ImmutableMap.of("elementId",((RemoteWebElement)ele).getId(),"duration",2000));
	}
	
	//To Swipe
	public void SwipeGes(WebElement ele, String direction) {
		((JavascriptExecutor)driver).executeScript("mobile: swipeGesture", ImmutableMap.of("elementId",((RemoteWebElement)ele).getId(),"direction", direction, "percent", 0.75));
	}
	
	//To Drag and Drop
	public void DragDrop(WebElement ele, Object object) {
		((JavascriptExecutor)driver).executeScript("mobile: dragGesture", ImmutableMap.of("elementId",((RemoteWebElement)ele).getId(),"endX", 619, "endY", 569));
	}
	
	@AfterClass
	public void ExitApp() {
		driver.quit();
	}
	
}