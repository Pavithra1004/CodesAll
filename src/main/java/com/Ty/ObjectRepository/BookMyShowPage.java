package com.Ty.ObjectRepository;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BookMyShowPage {
	
	
	@FindBy(xpath="//input[@class='sc-jvEmr elijMA']")
	private WebElement cityNameSelect;
	
	@FindBy(xpath="//div[@class='sc-7o7nez-0 gUjRuq']")
	private WebElement clickSelectAllLink;

	@FindBy(xpath="//div[@class='sc-133848s-1 kRlmLX']/h1")
	private WebElement printMovieText;

	
	@FindBy(xpath="//div[@class='sc-7o7nez-0 bJKnib']")
	private List<WebElement> movieNames;
	
	@FindBy(xpath="//div[text()='Recommended Movies']")
	private WebElement scrollEle;
	
	@FindBy(xpath="//a[text()='Corporates']")
	private WebElement scrollAbove;
	
	@FindBy(xpath="//div[@class='sc-lnhrs7-2 eQezya']/following-sibling::div/div/*")
	private WebElement clickNext;
	
	@FindBy(xpath="//div[@class='sc-lnhrs7-2 bELhrH']/following-sibling::div/div/*")
	private WebElement clickBack;
	
	@FindBy(xpath="//div[@class='sc-7o7nez-0 ksSobQ']")
	private List<WebElement> listMovies;

	@FindBy(xpath="//span[@class='sc-LKuAh kxVdmj ellipsis']")
	private WebElement selectDiffrentCity;
	
	@FindBy(xpath="//a[text()='Home']")
	private WebElement scrolldowntoHome;
	

	public BookMyShowPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void anyCityNameSelect(String cityName)
	{
		cityNameSelect.sendKeys(cityName);
		cityNameSelect.sendKeys(Keys.ENTER);

	}
	public void clickSelectAllLink()
	{
		clickSelectAllLink.click();

	}
	public void selectDiffrentCityBtn()
	{
		selectDiffrentCity.click();

	}
	public void printMovieText(WebDriver driver) throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String text = printMovieText.getText();
		System.out.println(text);
		
		
//		Point p = scrolldowntoHome.getLocation();
//		int X = p.getX();
//		int Y = p.getY();
//		js.executeScript("window.scrollBy(" + X + ", " + Y + ");");
//		Thread.sleep(2000);
//		Point p1 = scrollAbove.getLocation();
//		int X1 = p1.getX();
//		int Y1 = p1.getY();
//		js.executeScript("window.scrollBy(" + X1 + ", " + Y1 + ");");

		
		for(int i=0;i<20;i++)
		{
			js.executeScript("window.scrollBy(0,350)", "");
			Thread.sleep(2000);
		}
		for(int i=0;i<20;i++)
		{
			js.executeScript("window.scrollBy(0,-350)", "");
			Thread.sleep(2000);
		}
	}
	public void fetchmovieNames(WebDriver driver)
	{
		System.out.println(movieNames.size());
		for(int i=0;i<movieNames.size();i++)
		{
			WebDriverWait wait=new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOf(movieNames.get(i)));
			System.out.println(movieNames.get(i).getText());
		}

	}
	public void scrollTillEle(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		Point p = scrollEle.getLocation();
		int X = p.getX();
		int Y = p.getY();
		js.executeScript("window.scrollBy(" + X + ", " + Y + ");");

	}
	public void scrollTillEleAbove(WebDriver driver) throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		Point p = scrollAbove.getLocation();
		int X = p.getX();
		int Y = p.getY();
		js.executeScript("window.scrollBy(" + X + ", " + Y + ");");
		Thread.sleep(2000);

	}
	public void clickNextBtn()
	{
		clickNext.click();

	}
	public void clickBackBtn()
	{
		clickBack.click();

	}
	public void printMovieNames(WebDriver driver) throws InterruptedException
	{
		clickNext.click();
		Thread.sleep(1000);
		clickBack.click();
		Thread.sleep(1000);
		System.out.println(listMovies.size());
		for(int i=0;i<listMovies.size();i++)
		{
			if(i<=5)
			{
				Thread.sleep(1000);
				System.out.println(listMovies.get(i).getText());
			}
		}
		Thread.sleep(2000);
		clickNext.click();
		for(int i=0;i<listMovies.size();i++)
		{
			if(i>=5)
			{
				WebDriverWait wait=new WebDriverWait(driver, 10);
				Thread.sleep(3000);
				wait.until(ExpectedConditions.visibilityOf(listMovies.get(i)));
				System.out.println(listMovies.get(i).getText());
			}

		}
	}

}
