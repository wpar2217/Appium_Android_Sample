package General_Store;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class MainClass extends BaseClass {
	@Test
	public void SignForm() throws InterruptedException {
		Thread.sleep(6000);
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Sai");
		Thread.sleep(2000);
		driver.findElement(By.id("com.androidsample.generalstore:id/radioMale")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		Thread.sleep(2000);
	}
}