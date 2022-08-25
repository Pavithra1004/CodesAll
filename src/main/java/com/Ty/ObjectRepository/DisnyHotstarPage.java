package com.Ty.ObjectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class DisnyHotstarPage {
	
	public DisnyHotstarPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void selectGeners(String geners,WebDriver driver) throws InterruptedException
	{
	
		List<WebElement> generslist=driver.findElements(By.xpath("//a[text()='Latest & Trending']/ancestor::div[@class='container']//following-sibling::div[@class='slider-container']/descendant::div[@class='details']//span[@class='content-title ellipsise']"));
	 
		Actions act=new Actions(driver);
		System.out.println(generslist.size());
		for(int i=0;i<generslist.size();i++)
		{
		Thread.sleep(4000);
		act.moveToElement(generslist.get(i)).perform();
		Thread.sleep(4000);
		System.out.println(generslist.get(i).getText());

	}
}
}