package com.Ty.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FileHandlingPage {
	public WebDriver driver;
	public FileHandlingPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	/**
	* This method is to upload file
	* https://the-internet.herokuapp.com/upload
	*/
	@FindBy(id="file-upload")
	private WebElement uploadBtn;
	public void chooseFileBtn(String filePath) {
	uploadBtn.sendKeys(filePath);
	}

}
