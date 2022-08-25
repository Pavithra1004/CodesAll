package com.Ty.ObjectRepository;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MakeMyTripHomePage {
	@FindBy(xpath="//span[@class='langCardClose']")
	private WebElement alertClose;

	@FindBy(xpath="//li[@data-cy='roundTrip']")
	private WebElement tripType;

	@FindBy(xpath="//label[@for='fromCity']/span")
	private WebElement fromTxt;

	@FindBy(xpath="//label[@for='toCity']/span")
	private WebElement toTxt;

	@FindBy(xpath="//a[text()='Search']")
	private WebElement searchFlight;

	@FindBy(xpath="//div[@id='listing-id']//p")
	private List<WebElement> flightDetails1;

	@FindBy(xpath="//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")
	private WebElement nextCalenderBtn;


	@FindBy(xpath="//input[@placeholder='From']")
	private WebElement fromInput;
	
	@FindBy(xpath="//input[@placeholder='To']")
	private WebElement toInput;
	
	
	
	public MakeMyTripHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void fromInputTxt(String fromAddr,WebDriver driver) throws InterruptedException
	{
		fromInput.sendKeys(fromAddr);
		Thread.sleep(2000);
		fromInput.sendKeys(Keys.ARROW_DOWN);
		fromInput.sendKeys(Keys.TAB);
//		Actions act=new Actions(driver);
//		Thread.sleep(2000);
//		act.moveToElement(fromInput).build().perform();

		
	}
	public void toInputTxt(String toAddr,WebDriver driver) throws InterruptedException
	{
		toInput.sendKeys(toAddr);
		Thread.sleep(2000);
		toInput.sendKeys(Keys.ARROW_DOWN);
		toInput.sendKeys(Keys.TAB);
//		Actions act=new Actions(driver);
//		Thread.sleep(2000);
//		act.moveToElement(toInput).build().perform();


	}
	public void makeMyAlert()
	{
		alertClose.click();

	}
	public void tripClick()
	{
		tripType.click();

	}
	public void fromTxtClick()
	{
		fromTxt.click();

	}

	public void toTxtClick()
	{
		toTxt.click();

	}
	public void searchFlightBtn()
	{
		searchFlight.click();

	}
	public void nextCalenderBtnClick()
	{
		nextCalenderBtn.click();

	}
	
	public void flightDetails()
	{

		for(int i=0;i<=flightDetails1.size();i++)
		{
			System.out.println(flightDetails1.get(i).getText());
		}
	}


}
