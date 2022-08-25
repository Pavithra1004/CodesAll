package com.Ty.Wiki;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WikiIphoneText {


	@Test
	public void test()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://en.wikipedia.org/wiki/IPhone_12");

		WebElement pageText = driver.findElement(By.xpath("//div[@class='mw-parser-output']//p[3]"));
		String pagesplit = pageText.getText();

		String start="addition";
		String end="4K";

		String[] arrSplit = pagesplit.split(" ");
		int arr = arrSplit.length;
		System.out.println(arr);

		int count=1;
		for(int j=1;j<=arrSplit.length;j++)
		{
			if(arrSplit[j].equals(start))
			{
				break;
			}
			else {
				count++;

			}
		}
		System.out.println(count);


		for (int i=count; i <= arrSplit.length; i++)
		{	
			if(arrSplit[i].equals(end))
			{
				break;
			}
			else 
			{
				System.out.print(arrSplit[i+1]+" ");
			}

		}
	}
}