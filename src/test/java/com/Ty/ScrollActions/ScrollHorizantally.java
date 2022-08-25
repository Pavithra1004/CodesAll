package com.Ty.ScrollActions;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.GenericUtility.ScrollGeneric;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScrollHorizantally {
	WebDriver driver;
	ScrollGeneric scrollGeneric=new ScrollGeneric();
	@Test
	public void scrollBySpecifiedHeight() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		driver.manage().window().maximize();
		driver.get("https://www.vogue.es/micros/tendencias-moda-anos-80/");
		Thread.sleep(9000);
		//WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(2000));
		//wait.until(ExpectedConditions.visibilityOf(ele));
		//		Alert alt=driver.switchTo().alert();
		//		alt.accept();
		driver.findElement(By.xpath("//button[text()='Acepto']")).click();
		Thread.sleep(2000);
//		for(int i=0;i<20;i++)
//		{
//			scrollGeneric.scrollPage(Keys.ARROW_RIGHT,driver);	
//			Thread.sleep(2000);
//		}
		Thread.sleep(2000);
		WebElement ele = driver.findElement(By.xpath("//img[@id='ImgSec91']"));
		scrollGeneric.scrollTillElement(ele, driver);
//		scrollGeneric.scrollHorizantally(driver);
//		scrollGeneric.scrollToSpecifiedHorizantal(500, driver);

	}
}