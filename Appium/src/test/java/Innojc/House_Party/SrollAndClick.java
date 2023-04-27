package Innojc.House_Party;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class SrollAndClick extends MisBase {

	@Test
	public void SrollGesture() throws InterruptedException {
		driver.findElement(AppiumBy.accessibilityId("Graphics")).click();
		Thread.sleep(2000);
		// To scroll until the given element is visible
		driver.findElement(AppiumBy.androidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(\"SurfaceView Overlay\"));"));
		Thread.sleep(2000);
	}
}