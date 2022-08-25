package com.Ty.ScrollActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Practice1 {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://en.wikipedia.org/wiki/IPhone");
		Thread.sleep(3000);
		String parent=driver.getWindowHandle();
		Thread.sleep(2000);
		System.out.println("Parent ID"+parent);
		
	}

}
