package com.Ty.Robort;

import java.awt.AWTException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.GenericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeyboardFunctions {
	
	@Test
	public void keyboardFunctions() throws AWTException, InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		WebDriverUtility  webDriverUtility=new WebDriverUtility();
		driver.get("https://www.amazon.com/gp/goldbox?ref_=nav_cs_gb&deals-widget=%257B%2522version%2522%253A1%252C%2522viewIndex%2522%253A0%252C%2522presetId%2522%253A%25228FE39AB8E8307094BFDF2073AD8ACA10%2522%252C%2522departments%2522%253A%255B%25221055398%2522%255D%252C%2522sorting%2522%253A%2522BY_CUSTOM_CRITERION%2522%257D");
		webDriverUtility.pageDown();
		Thread.sleep(2000);
		webDriverUtility.pageUp();
		Thread.sleep(2000);
		webDriverUtility.end();
		Thread.sleep(2000);
		webDriverUtility.home();
		webDriverUtility.clickTab();
		Thread.sleep(2000);
		webDriverUtility.enter();
		Thread.sleep(3000);
		for(int i=0;i<10;i++)
		{
		Thread.sleep(3000);
		webDriverUtility.clickTab();
		}
		Thread.sleep(2000);
		webDriverUtility.enter();
		Thread.sleep(2000);
		driver.close();
	}
	

}
