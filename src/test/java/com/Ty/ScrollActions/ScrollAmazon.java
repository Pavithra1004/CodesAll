package com.Ty.ScrollActions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.GenericUtility.ScrollGeneric;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScrollAmazon {

	WebDriver driver;
	ScrollGeneric scrollGeneric=new ScrollGeneric();

	@Test
	public void scrollPage() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com/");
		Thread.sleep(2000);
		scrollGeneric.scrollPage(Keys.TAB, driver);
		Thread.sleep(2000);
		scrollGeneric.scrollPage(Keys.ENTER, driver);
		Reporter.log("Alert accept", true);
		scrollGeneric.scrollPage(Keys.PAGE_DOWN, driver);
		Reporter.log("PAGE_DOWN", true);
		scrollGeneric.scrollPage(Keys.END, driver);
		Reporter.log("PAGE_END", true);
		Thread.sleep(2000);
		scrollGeneric.scrollPage(Keys.PAGE_UP, driver);
		Reporter.log("PAGE_UP", true);
		scrollGeneric.scrollPage(Keys.HOME, driver);
		Reporter.log("PAGE_HOME", true);

		WebElement ele = driver.findElement(By.xpath("//span[text()='Popular products in Wireless internationally']"));
		scrollGeneric.scrollTillElement(ele, driver);
		String text = ele.getText();
		Reporter.log(text, true);
		Thread.sleep(2000);
		scrollGeneric.scrollHorizantally(driver);
		Reporter.log("scrollHorizantally", true);
		Thread.sleep(2000);
		scrollGeneric.scrollPageByJSValue(0, 300, driver);
		Reporter.log("scrollPageByJSValue", true);
		Thread.sleep(2000);
		scrollGeneric.scrollPageByJSValue(0, -300, driver);
		Thread.sleep(2000);
		scrollGeneric.scrollToBottom(driver);
		Reporter.log("scrollToBottom", true);

	}

}
