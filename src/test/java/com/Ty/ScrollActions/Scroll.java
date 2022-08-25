package com.Ty.ScrollActions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.GenericUtility.ScrollMethods;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scroll {

	ScrollMethods scrollMethods=new ScrollMethods();
	@Test
	public void scroll() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		driver.manage().window().maximize();
		  driver.get("https://www.tutorialspoint.com/index.htm");
		  Thread.sleep(2000);
	      // object of Actions class to scroll up and down
	      Actions at = new Actions(driver);
	 
	      at.sendKeys(Keys.PAGE_DOWN).build().perform();
	      Reporter.log("Pagedown", true);
	      Thread.sleep(2000);
	      at.sendKeys(Keys.PAGE_UP).build().perform();
	      Reporter.log("Pageup", true);
	      Thread.sleep(2000);
	      at.sendKeys(Keys.END).build().perform();
	      Thread.sleep(3000);
	      Reporter.log("page end", true);
	      at.sendKeys(Keys.HOME).build().perform();
	      Thread.sleep(3000);
	      driver.quit();
		
	}
}
