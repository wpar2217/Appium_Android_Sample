package Innojc.House_Party;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class Miscellaneous extends MisBase {
	
	//To rotate device from potrait to landscape
	@Test
	public void RotatingDevice() {
		DeviceRotation landscape = new DeviceRotation(0, 0, 90);
		driver.rotate(landscape);
		
	}
	
	//Copy and Paste
	@Test
	public void CopyPaste() {
		driver.setClipboardText("Rahul Wifi");
		driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
		
		//keyboard 'Enter'
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
	}
	
	//To directly open the particular page
	@Test
	public void DirectEnter() {
		Activity activity = new Activity("io.appium.android.apis", "Window{944eddb u0 io.appium.android.apis/io.appium.android.apis.ApiDemos}");
		driver.startActivity(activity);
	}
	
	//Mobile Popups
	@Test
	public void Popups() throws InterruptedException {
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("android:id/checkbox")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("android:id/edit")).sendKeys("Partha Wifi");
		Thread.sleep(2000);
		driver.findElements(By.className("android.widget.Button")).get(1).click();
		Thread.sleep(2000);
		
	}
}