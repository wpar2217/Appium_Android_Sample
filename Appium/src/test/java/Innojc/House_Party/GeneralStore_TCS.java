package Innojc.House_Party;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class GeneralStore_TCS extends Base {
	
	//Fill the form details
	@Test
	public void test1() throws InterruptedException {
		
		Thread.sleep(5000);
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Partha Saradhi");
		Thread.sleep(2000);
		driver.hideKeyboard();
		Thread.sleep(2000);
		driver.findElement(By.id("com.androidsample.generalstore:id/radioMale")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("android:id/text1")).click();
		Thread.sleep(2000);
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		Thread.sleep(2000);
		
	}
	
	//Verify the toast error messages displayed approximately for wrong inputs
	@Test
	public void test2() throws InterruptedException {
		
		Thread.sleep(5000);
		driver.findElement(By.id("com.androidsample.generalstore:id/radioMale")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("android:id/text1")).click();
		Thread.sleep(2000);
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		Thread.sleep(2000);
		String toastMessage = driver.findElement(By.xpath("//android.widget.Toast[1]")).getAttribute("name");
		Assert.assertEquals(toastMessage, "Please enter your name");
		
	}
	
	//Shop the items in the app by scrolling the specific product and add to cart
	@Test
	public void test3() throws InterruptedException {
		
		Thread.sleep(5000);
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Partha Saradhi");
		Thread.sleep(2000);
		driver.hideKeyboard();
		Thread.sleep(2000);
		driver.findElement(By.id("com.androidsample.generalstore:id/radioMale")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("android:id/text1")).click();
		Thread.sleep(2000);
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		Thread.sleep(2000);
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan 6 Rings\"));"));
		int productCount = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
		for(int i = 0; i < productCount; i++) {
			String productName = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
			if(productName.equalsIgnoreCase("Jordan 6 Rings")) {
				driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
			}
		}
		Thread.sleep(2000);
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		Thread.sleep(2000);
		
	}
	
	//Dynamically selecting product by scanning list based on text
	@Test
	public void test4() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Partha Saradhi");
		Thread.sleep(2000);
		driver.hideKeyboard();
		Thread.sleep(2000);
		driver.findElement(By.id("com.androidsample.generalstore:id/radioMale")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("android:id/text1")).click();
		Thread.sleep(2000);
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		Thread.sleep(2000);
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan 6 Rings\"));"));
		int productCount = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
		for(int i = 0; i < productCount; i++) {
			String productName = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
			if(productName.equalsIgnoreCase("Jordan 6 Rings")) {
				driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
			}
		}
		Thread.sleep(2000);
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		
		//waits are used to load the next page perfectly because the locators are same for element in product page and cart page
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));
		String lastPageProduct = driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
		Assert.assertEquals(lastPageProduct, "Jordan 6 Rings");
		Thread.sleep(2000);
		
	}
	
	
	//Validating total amount generated functionality
	@Test
	public void test5() throws InterruptedException {
		
		Thread.sleep(5000);
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Partha Saradhi");
		Thread.sleep(2000);
		driver.hideKeyboard();
		Thread.sleep(2000);
		driver.findElement(By.id("com.androidsample.generalstore:id/radioMale")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("android:id/text1")).click();
		Thread.sleep(2000);
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		Thread.sleep(2000);
		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
		Thread.sleep(2000);
		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
		Thread.sleep(2000);
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		Thread.sleep(2000);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));
		
		List<WebElement> productPrices = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
		
		int count = productPrices.size();
		double TotalSum = 0;
		//Java Normal for loop
		for(int i = 0; i < count; i++) {
			String amountString = productPrices.get(i).getText();
			Double price = getFormattedAmount(amountString);
			TotalSum = TotalSum + price; //160.97 + 120.0
		}
		
		String displaySum = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		Double displayFormattedSum = getFormattedAmount(displaySum);
		
		Assert.assertEquals(TotalSum, displayFormattedSum);
		
	}
	
	//Validating mobile gestures of app(Tap, Long Press)
	@Test
	public void test6() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Partha Saradhi");
		Thread.sleep(2000);
		driver.hideKeyboard();
		Thread.sleep(2000);
		driver.findElement(By.id("com.androidsample.generalstore:id/radioMale")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("android:id/text1")).click();
		Thread.sleep(2000);
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		Thread.sleep(2000);
		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
		Thread.sleep(2000);
		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
		Thread.sleep(2000);
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		Thread.sleep(2000);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));
		
		WebElement ele = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
		longPressAction(ele);
		Thread.sleep(2000);
		driver.findElement(By.id("android:id/button1")).click();
		Thread.sleep(2000);
		driver.findElement(By.className("android.widget.CheckBox")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		Thread.sleep(2000);
	}
	
	//How to handle objects when rendered in web view - Hybrid App(Combination of Web App and Native App)
	@Test
	public void test7() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Partha Saradhi");
		Thread.sleep(2000);
		driver.hideKeyboard();
		Thread.sleep(2000);
		driver.findElement(By.id("com.androidsample.generalstore:id/radioMale")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("android:id/text1")).click();
		Thread.sleep(2000);
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		Thread.sleep(2000);
		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
		Thread.sleep(2000);
		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
		Thread.sleep(2000);
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		Thread.sleep(2000);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));
		
		WebElement ele = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
		longPressAction(ele);
		Thread.sleep(2000);
		driver.findElement(By.id("android:id/button1")).click();
		Thread.sleep(2000);
		driver.findElement(By.className("android.widget.CheckBox")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		Thread.sleep(6000);
		//Java Enhanced for loop
		Set<String> contexts = driver.getContextHandles();
		for(String contextName : contexts) {
			System.out.println(contextName);
		}
		Thread.sleep(2000);
		//Run until here and you will get the webview link
		driver.context("WEBVIEW_com.androidsample.generalstore"); //copy the webview link from the last executed console and paste it here
		Thread.sleep(2000);
		driver.findElement(By.name("q")).sendKeys("https://www.facebook.com/");
		Thread.sleep(2000);
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.context("NATIVE_APP");
		Thread.sleep(2000);
	}
	
}