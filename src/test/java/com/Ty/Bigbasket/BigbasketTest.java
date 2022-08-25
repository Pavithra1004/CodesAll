package com.Ty.Bigbasket;

import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.mysql.cj.x.protobuf.MysqlxExpect.Open.Condition.Key;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BigbasketTest {
	
	@Test
	public void prizeAndName() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		String productName = "tomato";
		driver.get("https://www.bigbasket.com/");
		Thread.sleep(2000);
		 WebElement ele = driver.findElement(By.id("input"));
		ele.sendKeys(productName);
		ele.sendKeys(Keys.ENTER);
		List<WebElement> productText = driver.findElements(By.xpath("//div[@qa='product_name']/a"));
		Thread.sleep(2000);
		List<WebElement> productPrice = driver.findElements(By.xpath("//span[@class='discnt-price']"));
		Reporter.log("ProductSize: "+productText.size(),true);
		for(int j=0;j<50;j++)
		{
			js.executeScript("window.scrollBy(0,350)", "");
			Thread.sleep(2000);
		}

		Reporter.log("ProductSize: "+productText.size(),true);
		for(int i=0;i<productText.size();i++)
		{
			Reporter.log("ProductName: "+productText.get(i).getText(),true);
			Thread.sleep(2000);
			Reporter.log("ProductPrice: "+productPrice.get(i).getText(),true);
		}
		
	}

	}

