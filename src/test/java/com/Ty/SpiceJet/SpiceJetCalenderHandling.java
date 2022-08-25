package com.Ty.SpiceJet;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SpiceJetCalenderHandling {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver=new ChromeDriver(options);
		driver.get("https://www.spicejet.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		String from="BLR";
		String to="DEL";
		String departureDate="22 Jul 2022";
		String returnDate="22 Aug 2022";
		WebElement fromAddr = driver.findElement(By.xpath("//input[@class='css-1cwyjr8 r-homxoj r-ubezar r-10paoce r-13qz1uu']/ancestor::div[@class='css-1dbjc4n r-13awgt0 r-18u37iz']/descendant::div[@data-testid='to-testID-origin']"));
		fromAddr.click();
		fromAddr.sendKeys(from);
		WebElement toAddr = driver.findElement(By.xpath("//input[@class='css-1cwyjr8 r-homxoj r-ubezar r-10paoce r-13qz1uu']/ancestor::div[@class='css-1dbjc4n r-13awgt0 r-18u37iz']/child::div[@data-testid='to-testID-destination']"));
		toAddr.click();
		toAddr.sendKeys(to);
		
		WebElement dDate = driver.findElement(By.xpath("//div[text()='Departure Date']"));
		dDate.click();
		dDate.sendKeys(departureDate);
		WebElement rDate = driver.findElement(By.xpath("//div[text()='Return Date']"));
		rDate.click();
		rDate.sendKeys(returnDate);
		
		driver.close();
	}

}
