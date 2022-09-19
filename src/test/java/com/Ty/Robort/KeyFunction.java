package com.Ty.Robort;

import java.awt.AWTException;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.GenericUtility.WebDriverMethods;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeyFunction {
	@Test
	public void keyFunction() throws AWTException
	{
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
	driver.get("https://www.amazon.com/");
	WebDriverMethods webDriverMethods=new WebDriverMethods();
	webDriverMethods.selectOneKey(KeyEvent.VK_END);
	webDriverMethods.selectOneKey(KeyEvent.VK_PAGE_UP);
	webDriverMethods.selectOneKey(KeyEvent.VK_PAGE_DOWN);
	
	webDriverMethods.selectOneKey(KeyEvent.VK_HOME);

	
//	webDriverMethods.selectOneKey(KeyEvent.VK_TAB);
//	webDriverMethods.selectOneKey(KeyEvent.VK_ENTER);
//	webDriverMethods.selectTwoKey(KeyEvent.VK_CONTROL, KeyEvent.VK_A);
//	webDriverMethods.selectTwoKey(KeyEvent.VK_CONTROL, KeyEvent.VK_C);
//	webDriverMethods.selectTwoKey(KeyEvent.VK_CONTROL, KeyEvent.VK_V);
//	webDriverMethods.selectThreeKey(KeyEvent.VK_CONTROL,KeyEvent.VK_SHIFT, KeyEvent.VK_O);
	}
}
