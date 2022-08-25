package com.Ty.Excel;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
public class ExcelDataProvider {

	String filePath="D:\\Selenium\\DisnyTy\\DataSet.xlsx";

	WebDriver driver;
	@BeforeMethod
	public void setUp() throws InterruptedException {
		System.out.println("Start test");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		Thread.sleep(2000);
		driver.manage().window().maximize();

	}

	@DataProvider(name ="excel-data")
	public Object[][] excelDP() throws IOException{
		//We are creating an object from the excel sheet data by calling a method that reads data from the excel stored locally in our system
		Object[][] arrObj = getExcelData(filePath,"Sheet1");
		return arrObj;
	}
		//This method handles the excel - opens it and reads the data from the respective cells using a for-loop & returns it in the form of a string array
		public String[][] getExcelData(String filePath, String sheetName){

			String[][] data = null;   	
			try
			{
				FileInputStream fis=new FileInputStream(filePath);
				Workbook wb = WorkbookFactory.create(fis);	
				Sheet sh = wb.getSheet(sheetName);
				 Row row = sh.getRow(0);
				int noOfRows = sh.getPhysicalNumberOfRows();
				int noOfCols = row.getLastCellNum();
				Cell cell;
				data = new String[noOfRows-1][noOfCols];
				for(int i =1; i<noOfRows;i++){
					for(int j=0;j<noOfCols;j++){
						row = sh.getRow(i);
						cell= row.getCell(j);
						data[i-1][j] = cell.getStringCellValue();
					}
				}
			}
			catch (Exception e) {
				System.out.println("The exception is: " +e.getMessage());
			}
			return data;
		}
		@Test(dataProvider ="excel-data")
		public void search(String userName, String password) throws InterruptedException{
			driver.findElement(By.id("txtUsername")).sendKeys(userName);
			driver.findElement(By.id("txtPassword")).sendKeys(password);
			Thread.sleep(2000);
			driver.findElement(By.id("btnLogin")).click();
			String text = driver.findElement(By.id("spanMessage")).getText();
			Reporter.log(text,true);
			Thread.sleep(2000);
		}
		
	@AfterMethod
	public void close()
	{
		driver.close();
	}

}


