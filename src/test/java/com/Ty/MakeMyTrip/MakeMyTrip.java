package com.Ty.MakeMyTrip;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.Ty.ObjectRepository.MakeMyTripHomePage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MakeMyTrip {


	public static void main(String[] args) throws InterruptedException
	{
		String departureDate="10-August-2022";
		String returnDate="10-June-2023";
		String fromCity="Bengaluru, India";
		String toCity="New Delhi, India";

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com/");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		MakeMyTripHomePage makeMyTripHomePage=new MakeMyTripHomePage(driver);
		makeMyTripHomePage.makeMyAlert();
		makeMyTripHomePage.tripClick();
		makeMyTripHomePage.fromTxtClick();
		Thread.sleep(2000);
		makeMyTripHomePage.fromInputTxt(fromCity, driver);
		Thread.sleep(2000);
		makeMyTripHomePage.toTxtClick();
		Thread.sleep(2000);
		makeMyTripHomePage.toInputTxt(toCity, driver);

		selectDate(driver, 1, departureDate);
		selectDate(driver, 2, returnDate);

		makeMyTripHomePage.searchFlightBtn();

		for(int i=0;i<13;i++)
		{
			js.executeScript("window.scrollBy(0,350)", "");
			Thread.sleep(2000);
		}
		for(int i=0;i<13;i++)
		{
			js.executeScript("window.scrollBy(0,-350)", "");
			Thread.sleep(2000);
		}



		try {
			makeMyTripHomePage.flightDetails();
		}
		catch (Exception e) {
			e.getMessage();
		}
		driver.close();

	}
	public static void selectDate(WebDriver driver,int i, String date)
	{

		MakeMyTripHomePage makeMyTripHomePage=new MakeMyTripHomePage(driver);
		int reqMonth=LocalDate.parse(date,DateTimeFormatter.ofPattern("dd-MMMM-yyyy")).getMonthValue();
		int reqYear =Integer.parseInt(date.split("-")[2]);

		String currentMonthYear=driver.findElement(By.xpath("//div[@class='DayPicker-Months']/div["+i+"]/div[@class='DayPicker-Caption']/div")).getText();
		int currentMonth=DateTimeFormatter.ofPattern("MMMMyyyy").withLocale(Locale.ENGLISH).parse(currentMonthYear).get(ChronoField.MONTH_OF_YEAR);
		int currentYear=DateTimeFormatter.ofPattern("MMMMyyyy").withLocale(Locale.ENGLISH).parse(currentMonthYear).get(ChronoField.YEAR);

		while(!(currentMonth==reqMonth && currentYear==reqYear)) {
			currentMonthYear=driver.findElement(By.xpath("//div[@class='DayPicker-Months']/div[2]/div[@class='DayPicker-Caption']/div")).getText();
			currentMonth=DateTimeFormatter.ofPattern("MMMMyyyy").withLocale(Locale.ENGLISH).parse(currentMonthYear).get(ChronoField.MONTH_OF_YEAR);
			currentYear=DateTimeFormatter.ofPattern("MMMMyyyy").withLocale(Locale.ENGLISH).parse(currentMonthYear).get(ChronoField.YEAR);
			makeMyTripHomePage.nextCalenderBtnClick();

			currentMonthYear=driver.findElement(By.xpath("//div[@class='DayPicker-Months']/div[1]/div[@class='DayPicker-Caption']/div")).getText();
			currentMonth=DateTimeFormatter.ofPattern("MMMMyyyy").withLocale(Locale.ENGLISH).parse(currentMonthYear).get(ChronoField.MONTH_OF_YEAR);
			currentYear=DateTimeFormatter.ofPattern("MMMMyyyy").withLocale(Locale.ENGLISH).parse(currentMonthYear).get(ChronoField.YEAR);
		}
		
		driver.findElement(By.xpath("//div[@class='DayPicker-Month' and contains(.,'"+date.split("-")[1]+"')]//p[.='"+date.split("-")[0]+"']")).click();
		//div[@class='DayPicker-Month' and contains(.,'December')]//p[contains(.,'10')]

	}

}
