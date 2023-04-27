package Innojc.House_Party;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class LongPress extends MisBase {
	@Test
	public void LongPressGesture() throws InterruptedException {
		driver.findElement(By.xpath("//android.widget.TextView[@text='Views']")).click(); //Note: Locator is not working
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Expandable Lists']")).click();
		Thread.sleep(2000);
		driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
		Thread.sleep(2000);
		WebElement ele = driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
		longPressAction(ele);
		Thread.sleep(2000);
		String menutxt = driver.findElement(By.id("android:id/title")).getText();
		Assert.assertEquals(menutxt, "Sample menu");
		Assert.assertTrue(driver.findElement(By.id("android:id/title")).isDisplayed());
		Thread.sleep(2000);
		
	}
}