package com.Ty.BookMyShow;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.Ty.ObjectRepository.BookMyShowPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FetchTheRecommendedBangloreMoviesByclickingNext {
	@Test
	public void fetchTheRecommendedBangloreMoviesByclickingNext() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://in.bookmyshow.com/explore/home");
		String city1 = "Bengaluru";
		BookMyShowPage bookMyShowPage=new BookMyShowPage(driver);
		
		bookMyShowPage.anyCityNameSelect(city1);
		bookMyShowPage.scrollTillEle(driver);
		Thread.sleep(2000);
		bookMyShowPage.clickNextBtn();
		Thread.sleep(2000);
		bookMyShowPage.clickBackBtn();
		Thread.sleep(2000);
		bookMyShowPage.printMovieNames(driver);
		
	}

}
