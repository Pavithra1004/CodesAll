package com.Ty.DisnyHotstar;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

	
public class Practice {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.hotstar.com/in");
		String Geners="Movies Recommended For You";
		Thread.sleep(1000);
		int elements=8;
		
		Actions act=new Actions(driver);
		WebDriverWait wait=new WebDriverWait(driver, 10);
		for(int i=0;i<40;i++)
		{
		for(int k=1;k<6;k++)
		{
			if(i==(elements*k))
			{
				Thread.sleep(1000);
				driver.findElement(By.xpath("//a[text()='"+Geners+"']/ancestor::div[@class='container']//following-sibling::div[@class='slider-container']/descendant::i[@class='right-arrow']")).click();

			}
		}
		}
		for(int j=0;j<40;j++)
		{
		for(int k=1;k<6;k++)
		{
			if(j==(elements*k))
			{
				Thread.sleep(1000);
				driver.findElement(By.xpath("//a[text()='"+Geners+"']/ancestor::div[@class='container']//following-sibling::div[@class='slider-container']/descendant::i[@class='left-arrow']")).click();

			}
		}
		}
		List<WebElement> movieName = driver.findElements(By.xpath("//a[text()='"+Geners+"']/ancestor::div[@class='container']//following-sibling::div[@class='slider-container']/descendant::div[@class='details']//span[@class='content-title ellipsise']"));
		System.out.println(movieName.size());
		for(int i=0;i<movieName.size();i++)
		{
			try {
				if(i<=elements)
				{
					Thread.sleep(1000);
					act.moveToElement(movieName.get(i)).perform();
					//Thread.sleep(1000);
					wait.until(ExpectedConditions.visibilityOf(movieName.get(i)));
					System.out.println(movieName.get(i).getText());
				}
				else 
				{
					for(int k=1;k<6;k++)
					{
						if(i==(elements*k))
						{
							driver.findElement(By.xpath("//a[text()='"+Geners+"']/ancestor::div[@class='container']//following-sibling::div[@class='slider-container']/descendant::i[@class='right-arrow']")).click();

						}
					}
					act.moveToElement(movieName.get(i)).perform();
					wait.until(ExpectedConditions.visibilityOf(movieName.get(i)));
					//Thread.sleep(1000);
					System.out.println(movieName.get(i).getText());
				}
			}
			catch(Exception e)
			{
				e.getMessage();
			}
		}
		driver.close();
	}
	}
//List<WebElement> movies = driver.findElements(By.xpath("//div[text()='Recommended Movies']/ancestor::div[@class='sc-133848s-3 cWbeuJ']/following-sibling::div[@class='sc-lnhrs7-0 hCzkOF']//a"));
//System.out.println(movies.size());
//for(int i=0;i<movies.size();i++)
//{
//	//div[@class='sc-lnhrs7-7 faepMR']/ancestor::div[@class='sc-b1h692-8 lauXqK']
//	
//}
//
