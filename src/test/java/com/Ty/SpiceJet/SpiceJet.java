package com.Ty.SpiceJet;


import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
public class SpiceJet {
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeOptions crm=new ChromeOptions();
		crm.addArguments("--disable-notifications");
		WebDriver driver=new ChromeDriver(crm);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.spicejet.com");
		WebElement oneWayRadio=driver.findElement(By.xpath("//div[.='one way']"));
		if(!oneWayRadio.isSelected())
		{
			oneWayRadio.click();
		}
		String fromAdd="BLR";
		String toAdd="DEL";
		WebElement from=driver.findElement(By.xpath("//div[@data-testid='to-testID-origin']/descendant::input[@type='text']"));
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(from));
		from.sendKeys(fromAdd);
		WebElement to=driver.findElement(By.xpath("//div[@data-testid='to-testID-destination']/descendant::input[@type='text']"));
		wait.until(ExpectedConditions.visibilityOf(to));
		to.sendKeys(toAdd);
		Date date=new Date();
		String d=date.toString();
		String[] sarr = d.split(" ");
		String dow=sarr[0];
		int day=date.getDate()+7;
		String mon=sarr[1];
		String year=sarr[5];
		//String dDate="Mon,"+" "+"18"+" "+"Jul"+" "+"2022";//Sat, 27 Aug 2022 Mon,18 Jul 2022
		//String rDate="Thu,"+" "+"25"+" "+"Aug"+" "+"2022";
		//Tue, 12 Jul 2022
		//System.out.println(date);
		//System.out.println(bDate);

		driver.findElement(By.xpath("//div[.='Departure Date']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("div[@class='css-76zvg2 r-homxoj r-ubezar r-16dba41' and text()='"+day+"']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='css-76zvg2 r-1862ga2' and text()='"+dow+"']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='css-76zvg2 r-homxoj r-adyw6z r-1kfrs79' and text()='"+mon+"']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='css-76zvg2 r-homxoj r-adyw6z r-1kfrs79' and text()='"+year+"']")).click();
		
		
			
		driver.findElement(By.xpath("//div[.='Return Date']")).click();
		driver.findElement(By.xpath("//div[@class='css-76zvg2 r-homxoj r-adyw6z r-1kfrs79' and text()='"+year+"']")).click();
		driver.findElement(By.xpath("//div[@class='css-76zvg2 r-homxoj r-adyw6z r-1kfrs79' and text()='"+mon+"']")).click();
		driver.findElement(By.xpath("//div[@class='css-76zvg2 r-1862ga2' and text()='"+dow+"']")).click();
		driver.findElement(By.xpath("div[@class='css-76zvg2 r-homxoj r-ubezar r-16dba41' and text()='"+day+"']")).click();
		
		
		
		
		
		
		
		
		//Thread.sleep(2000);
//			driver.findElement(By.xpath("//div[.='Departure Date']/following-sibling::div[*]/descendant::div[text()='"+dDate+"']")).click();  
//			Thread.sleep(3000);
//			driver.findElement(By.xpath("//div[.='Return Date']/following-sibling::div[*]/descendant::div[text()='"+rDate+"']")).click();  
//			
		driver.findElement(By.xpath("//div[@data-testid='home-page-flight-cta']")).click();


		driver.close();

	}

}
//div[.='Departure Date']/following-sibling::div[*]/descendant::div[text()='Sat, 27 Aug 2022']

//div[.='Departure Date']/following-sibling::div[*]/descendant::div[text()='"+dDate+"']

//*[local-name()='svg' and @data-testid="svg-img"]
