package com.Ty.SpiceJet;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
public class SpiceJetProject {
	
		public static void main(String[] args) throws InterruptedException {

			WebDriverManager.chromedriver().setup();
			ChromeOptions opt=new ChromeOptions();
			opt.addArguments("--disable-notifications");
			WebDriver driver=new ChromeDriver(opt);
			driver.get("https://www.spicejet.com/");
			driver.manage().window().maximize();
			
			int sdate = 26;
			int ddate = 26;
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[@data-testid='round-trip-radio-button']")).click();

			driver.findElement(By.xpath("//div[.='From']")).click();
			driver.findElement(By.xpath("//div[.='Kempegowda International Airport']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[.='Indira Gandhi International Airport']")).click();
			driver.findElement(By.xpath("//div[.='"+sdate+"']")).click();
			driver.findElement(By.xpath("//div[.='"+ddate+"']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[.='Search Flight']")).click();  
			driver.close();
			
		}
	}


