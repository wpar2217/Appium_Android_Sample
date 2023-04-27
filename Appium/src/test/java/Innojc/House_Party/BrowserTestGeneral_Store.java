package Innojc.House_Party;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BrowserTestGeneral_Store extends BaseForMobileBrowser {
	
	//How to inspect the elements in web browser for an android and using it
	@Test
	public void test1() throws InterruptedException {
		driver.get("https://www.google.com");
		System.out.println(driver.getTitle());
		Thread.sleep(2000);
		driver.findElement(By.name("q")).sendKeys("https://www.facebook.com/");
		Thread.sleep(2000);
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		 
		/*
		 * driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		 * Thread.sleep(2000);
		 * driver.findElement(By.xpath("//span[@class='navbar-toggler-icon']")).click();
		 * Thread.sleep(2000); driver.findElement(By.
		 * cssSelector("#navbarSupportedContent > ul > li.nav-item.active > a")).click()
		 * ; Thread.sleep(2000);
		 * ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,1000)","");
		 * //To scroll String text = driver.findElement(By.
		 * cssSelector("body > app-root > app-product-details > div > div:nth-child(3) > div > ul > div:nth-child(3) > li > div > div > a"
		 * )).getText(); Assert.assertEquals(text, "Devops"); Thread.sleep(2000);
		 */
	}
}