package com.GenericUtility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ScrollMethods {
	WebDriver driver;
	JavascriptExecutor j;

	public void scrollPageBySeleniumAction()
	{
		//Keys var = Keys.END;
		Actions a = new Actions(driver);
		//scroll down a page
		a.sendKeys(Keys.PAGE_DOWN).build().perform();
		//scroll up a page
		a.sendKeys(Keys.PAGE_UP).build().perform();
		//scroll  to End of page
		a.sendKeys(Keys.END).build().perform();
		//scroll to home page
		a.sendKeys(Keys.HOME).build().perform();
	}
	public void scrollPageBySeleniumJS()
	{
		j = (JavascriptExecutor)driver;
		j.executeScript("window.scrollBy(0,500)");
		j.executeScript("window.scrollBy(0,-500)");
	}
	public  void scrollToCoOrdinates(WebElement element)
	{
	 Point p = element.getLocation();
     int X = p.getX();
     int Y = p.getY();
     j.executeScript("window.scrollBy(" + X + ", " + Y + ");");
     System.out.println("Text is: " + element.getText());
	}
}