package Innojc.House_Party;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class DragAndDrop extends MisBase {
	public void test1() throws InterruptedException {
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		Thread.sleep(2000);
		driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).clear();
		Thread.sleep(2000);
		WebElement ele = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
		
		((JavascriptExecutor)driver).executeScript("mobile: dragGesture", ImmutableMap.of("elementId",((RemoteWebElement)ele).getId(),"endX", 619, "endY", 569));
		
		Thread.sleep(5000);
		String result = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1")).getText();
		Assert.assertEquals(result, "Dropped!");
		Thread.sleep(2000);
	}
}