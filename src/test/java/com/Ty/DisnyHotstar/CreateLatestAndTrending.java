package com.Ty.DisnyHotstar;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.Ty.ObjectRepository.DisnyHotstarPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLatestAndTrending {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.hotstar.com/in");
		String s="Movies Recommended For You";
		Thread.sleep(5000);
		DisnyHotstarPage disnyHotstarPage=new DisnyHotstarPage(driver);
		disnyHotstarPage.selectGeners(s, driver);
//		List<WebElement> movie = driver.findElements(By.xpath("//a[text()='"+s+"']/ancestor::div[@class='container']//following-sibling::div[@class='slider-container']/descendant::div[@class='details']//span[@class='content-title ellipsise']"));
//		Actions act=new Actions(driver);
//		System.out.println(movie.size());
//		for(int i=0;i<movie.size();i++)
//		{
//		Thread.sleep(4000);
//		act.moveToElement(movie.get(i)).perform();
//		Thread.sleep(4000);
//		System.out.println(movie.get(i).getText());
//	}

}
}