package com.Ty.ScrollActions;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.GenericUtility.ScrollGeneric;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScrollToBottom {
	WebDriver driver;
	ScrollGeneric scrollGeneric=new ScrollGeneric();

	@Test
	public void scrollToBottom() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com/");
		Thread.sleep(2000);
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(2000));
		//wait.until(ExpectedConditions.visibilityOf(ele));
		scrollGeneric.scrollPage(Keys.TAB, driver);
		Thread.sleep(2000);
		scrollGeneric.scrollPage(Keys.ENTER, driver);
		scrollGeneric.scrollToBottom(driver);

}
}
