package com.Ty.DisnyHotstar;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PrintMoviesBasedOnLanguage  {
	
@Test
public void PrintMoviesBasedOnLanguage() throws InterruptedException, EncryptedDocumentException, IOException
{
//	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException {
		String filePath="D:\\Selenium\\DisnyTy\\src\\test\\resources\\Movie.xlsx";
		FileInputStream fis=new FileInputStream(filePath);
		Workbook wb = WorkbookFactory.create(fis);	
		Sheet s = wb.getSheet("Sheet1");
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebDriverWait wait=new WebDriverWait(driver, 10);
		Actions act=new Actions(driver);
		String languageName="English";

		driver.get("https://www.hotstar.com/in");
		Thread.sleep(1000);
		WebElement movie = driver.findElement(By.xpath("//div[text()='Movies']"));
		Thread.sleep(1000);
		act.moveToElement(movie).perform();
		driver.findElement(By.xpath("//a[text()='"+languageName+"']")).click();
		Thread.sleep(1000);
		driver.findElements(By.xpath("//h2[text()='"+languageName+"']/ancestor::div[@class='container']/descendant::div[@class='content-play']/span[@class='content-title ellipsise']"));
		for(int j=0;j<3;j++)
		{
			try {

				WebElement ele = driver.findElement(By.xpath("//a[text()='Terms of Use']"));
				Thread.sleep(1000);
				js.executeScript("arguments[0].scrollIntoView(true);",ele);
				Thread.sleep(1000);
			}
			catch (Exception e) {
				e.getMessage();
			}
		}
		
		
		List<WebElement> movieNameSize = driver.findElements(By.xpath("//h2[text()='"+languageName+"']/ancestor::div[@class='container']/descendant::div[@class='details']"));
		Thread.sleep(1000);
		List<WebElement> movieNames = driver.findElements(By.xpath("//h2[text()='"+languageName+"']/ancestor::div[@class='container']/descendant::div[@class='content-play']/span[@class='content-title ellipsise']"));
		System.out.println(movieNames.size());
		for(int i=0;i<movieNames.size();i++)
		{	
			act.moveToElement(movieNameSize.get(i)).perform();
			wait.until(ExpectedConditions.visibilityOf(movieNameSize.get(i)));
			Thread.sleep(1000);
			Row r = s.createRow(i+1);			
			Cell c1 = r.createCell(0);
			c1.setCellValue(languageName);
			
					
			Cell c3 = r.createCell(1);
			c3.setCellValue(movieNames.get(i).getText());
			System.out.println(movieNames.get(i).getText());	
		}
		
		FileOutputStream fout=new FileOutputStream(filePath);
		wb.write(fout);
		wb.close();
		
		driver.close();
}
}