package com.Ty.DisnyHotstar;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreatePopularShowsParticularTest {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebDriverWait wait=new WebDriverWait(driver, 10);
		// String name="Popular Shows";
		driver.get("https://www.hotstar.com/in");
		driver.findElement(By.xpath("//a[.='Popular Shows']")).click();
		for(int j=0;j<20;j++)
		{
			try {
		
		WebElement ele = driver.findElement(By.xpath("//a[text()='Terms of Use']"));
		js.executeScript("arguments[0].scrollIntoView(true);",ele);
		
			}
			catch (Exception e) {
				e.getMessage();
			}
		}
		List<WebElement> movieNameSize = driver.findElements(By.xpath("//h2[text()='Popular Shows']/ancestor::div[@class='container']/descendant::div[@class='details']"));
		List<WebElement> movieNames = driver.findElements(By.xpath("//h2[text()='Popular Shows']/ancestor::div[@class='container']/descendant::div[@class='details']//span[@class='content-title ellipsise']"));
		System.out.println(movieNames.size());
		Actions act=new Actions(driver);
		 
		
		for(int i=0;i<movieNames.size();i++)
		{	
		
		act.moveToElement(movieNameSize.get(i)).perform();
		wait.until(ExpectedConditions.visibilityOf(movieNameSize.get(i)));
		//Thread.sleep(1000);
		System.out.println(movieNames.get(i).getText());
			}
		driver.close();
		}
		

}
