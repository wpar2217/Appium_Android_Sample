package Innojc.House_Party;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class SwipeDemo extends MisBase {
	
	@Test
	public void Swipe() throws InterruptedException {
		driver.findElement(By.xpath("//android.widget.TextView[@text='Views']")).click(); //Note: Locator is not working
		Thread.sleep(2000);
		driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.TextView[@text='1. Photos']")).click();
		Thread.sleep(2000);
		WebElement ele = driver.findElement(By.xpath("//andoid,widget.ImageView[1]"));
		Assert.assertEquals(driver.findElement(By.xpath("//andoid,widget.ImageView[1]")).getAttribute("focussable"), "true");
		//Swipe
		SwipeGes(ele, "left");
		Assert.assertEquals(driver.findElement(By.xpath("//andoid,widget.ImageView[1]")).getAttribute("focussable"), "false");

		
	}
}