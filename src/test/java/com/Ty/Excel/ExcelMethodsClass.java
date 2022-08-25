package com.Ty.Excel;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.GenericUtility.ExcelMethodsImplementation;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExcelMethodsClass {
	ExcelMethodsImplementation excelMethodsImplementation=new ExcelMethodsImplementation();
	String filePath="D:\\Selenium\\DisnyTy\\Data.xlsx";
	@Test(priority = 1)
	public void getDataFromExcel() throws EncryptedDocumentException, IOException
	{
		
		excelMethodsImplementation.fetchDataFromExcel(filePath, "Sheet1", 1, 1);
	}
	@Test(enabled = false)
	public void setDataIntoExcel() throws EncryptedDocumentException, IOException
	{
		excelMethodsImplementation.setDataToExcel(filePath, "Sheet1", 22, 1, "Data entered");
	}
	@Test(enabled = false)
	public void getMultipleDataFromExcel() throws EncryptedDocumentException, IOException
	{
		excelMethodsImplementation.fetchMultipleDataFromExcel(filePath, "Sheet1", 0);
		excelMethodsImplementation.fetchMultipleDataFromExcel(filePath, "Sheet1", 1);
	}
	@Test(enabled = false)
	public void setMultipleDataIntoExcel() throws EncryptedDocumentException, IOException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		driver.get("https://www.amazon.com/");
		List<WebElement> ele = driver.findElements(By.xpath("//a"));
		excelMethodsImplementation.setMultipleDataToExcel(filePath, "Sheet2", ele, 0);
	
	}
	
	

}
