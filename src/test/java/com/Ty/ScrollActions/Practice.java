package com.Ty.ScrollActions;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Practice {
public static void main(String[] args) throws MalformedURLException, InterruptedException {
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.amazon.com/");
	Thread.sleep(3000);
	List<WebElement> element = driver.findElements(By.tagName("//img"));
	Thread.sleep(4000);
	for(int i=0;i<element.size();i++)
	{
		System.out.println(element.get(i).getText());
	}
	driver.close();
}
}
