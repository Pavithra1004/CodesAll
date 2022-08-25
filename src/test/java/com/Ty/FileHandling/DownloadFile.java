package com.Ty.FileHandling;
import java.awt.AWTException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class DownloadFile {
		
		@Test
		public void fileDownload() throws AWTException, InterruptedException {
			
			WebDriverManager.chromedriver().setup();
			WebDriver driver=new ChromeDriver();
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			driver.manage().window().maximize();

			driver.get("https://chromedriver.storage.googleapis.com/index.html?path=79.0.3945.36/");
			Thread.sleep(2000);
			WebElement btnDownload = driver.findElement(By.xpath("//a[text()='chromedriver_win32.zip']"));
			btnDownload.click();
			
			Thread.sleep(7000);
			
		}
}
