package com.Ty.SpiceJet;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SpiceJetBooking {
	public static void main(String[] args) throws InterruptedException {

		String departureDate="23-July-2022";
		String returnDate="20-October-2022";
		String fromAdd="BLR";
		String toAdd="AGR";


		WebDriverManager.chromedriver().setup();
		ChromeOptions crm=new ChromeOptions();
		crm.addArguments("--disable-notifications");
		WebDriver driver=new ChromeDriver(crm);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.spicejet.com");
		Thread.sleep(2000);
		WebElement roundtripRadio=driver.findElement(By.xpath("//div[.='round trip']"));
		if(!roundtripRadio.isSelected())
		{
			roundtripRadio.click();
		}
		WebElement from=driver.findElement(By.xpath("//div[@data-testid='to-testID-origin']/descendant::input[@type='text']"));
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(from));
		from.sendKeys(fromAdd);
		Thread.sleep(2000);
		WebElement to=driver.findElement(By.xpath("//div[@data-testid='to-testID-destination']/descendant::input[@type='text']"));
		wait.until(ExpectedConditions.visibilityOf(to));
		to.sendKeys(toAdd);
		Thread.sleep(3000);
		selectDate(driver,1,departureDate);
		selectDate(driver,2,returnDate);
	}
	public static void selectDate(WebDriver driver,int i, String date) throws InterruptedException
	{


		int reqMonth=LocalDate.parse(date,DateTimeFormatter.ofPattern("dd-MMMM-yyyy")).getMonthValue();
		int reqYear =Integer.parseInt(date.split("-")[2]);

		String currentMonthYear=driver.findElement(By.xpath("//div[@class='css-76zvg2 r-homxoj r-adyw6z r-1kfrs79']/ancestor::div[@class='css-1dbjc4n r-150rngu r-18u37iz r-16y2uox r-1wbh5a2 r-lltvgl r-buy8e9 r-1sncvnh']/descendant::div[@class='css-1dbjc4n r-k8qxaj']["+i+"]")).getText();
		System.out.println(currentMonthYear);
		int currentMonth=DateTimeFormatter.ofPattern("MMMM yyyy").withLocale(Locale.ENGLISH).parse(currentMonthYear).get(ChronoField.MONTH_OF_YEAR);
		System.out.println(currentMonth);
		int currentYear=DateTimeFormatter.ofPattern("MMMM yyyy").withLocale(Locale.ENGLISH).parse(currentMonthYear).get(ChronoField.YEAR);
		System.out.println(currentYear);
		while(!(currentMonth==reqMonth && currentYear==reqYear)) {
			currentMonthYear=driver.findElement(By.xpath("//div[@class='css-76zvg2 r-homxoj r-adyw6z r-1kfrs79']/ancestor::div[@class='css-1dbjc4n r-150rngu r-18u37iz r-16y2uox r-1wbh5a2 r-lltvgl r-buy8e9 r-1sncvnh']/descendant::div[@class='css-1dbjc4n r-k8qxaj'][1]")).getText();
			currentMonth=DateTimeFormatter.ofPattern("MMMM yyyy").withLocale(Locale.ENGLISH).parse(currentMonthYear).get(ChronoField.MONTH_OF_YEAR);
			currentYear=DateTimeFormatter.ofPattern("MMMM yyyy").withLocale(Locale.ENGLISH).parse(currentMonthYear).get(ChronoField.YEAR);
			
			driver.findElement(By.xpath("//*[local-name()='svg' and @data-testid='svg-img']/ancestor::div[@class='css-1dbjc4n r-14lw9ot r-11u4nky r-rs99b7 r-6koalj r-eqz5dr r-1pi2tsx r-pm9dpa r-1knelpx r-13qz1uu']/div/*[local-name()='svg']")).click();
			currentMonthYear=driver.findElement(By.xpath("//div[@class='css-76zvg2 r-homxoj r-adyw6z r-1kfrs79']/ancestor::div[@class='css-1dbjc4n r-150rngu r-18u37iz r-16y2uox r-1wbh5a2 r-lltvgl r-buy8e9 r-1sncvnh']/descendant::div[@class='css-1dbjc4n r-k8qxaj']["+i+"]")).getText();
			currentMonth=DateTimeFormatter.ofPattern("MMMM yyyy").withLocale(Locale.ENGLISH).parse(currentMonthYear).get(ChronoField.MONTH_OF_YEAR);
			currentYear=DateTimeFormatter.ofPattern("MMMM yyyy").withLocale(Locale.ENGLISH).parse(currentMonthYear).get(ChronoField.YEAR);
			
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-18u37iz']//div[@class='css-76zvg2 r-homxoj r-adyw6z r-1kfrs79' and contains(.,'"+date.split("-")[1]+"')]/ancestor::div[@class='css-1dbjc4n r-1mdbw0j r-ymttw5 r-b2dl2 r-mzjzbw r-wk8lta r-tvv088']/descendant::div[text()='"+date.split("-")[0]+"']")).click();

	}
}

