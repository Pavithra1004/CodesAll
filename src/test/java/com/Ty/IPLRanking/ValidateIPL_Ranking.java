package com.Ty.IPLRanking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import com.GenericUtility.DataBaseMethods;
import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ValidateIPL_Ranking {
WebDriver driver;
	public void validateIPL_Ranking() throws SQLException
	{
	WebDriverManager.chromedriver().setup();
	 driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
	driver.manage().window().maximize();
	
	driver.get("https://www.google.com/search?q=IPL+ranknking+2022&oq=IPL+ranknking+2022&aqs=chrome.0.69i59j0i13l8j0i22i30.1021j0j7&sourceid=chrome&ie=UTF-8#cobssid=s");
	
	driver.findElement(By.xpath("//span[@class='wHYlTd RES9jf' and text()='See more']")).click();
	
	List<WebElement> teams = driver.findElements(By.xpath("//div[@class='tb_c immersive-container tb_stc']/descendant::table[@class='Jzru1c']//tr/td[3]"));
	List<WebElement> Mcount = driver.findElements(By.xpath("//div[@class='tb_c immersive-container tb_stc']/descendant::table[@class='Jzru1c']//tr/td[4]"));
	List<WebElement> Wount = driver.findElements(By.xpath("//div[@class='tb_c immersive-container tb_stc']/descendant::table[@class='Jzru1c']//tr/td[5]"));
	List<WebElement> Lcount = driver.findElements(By.xpath("//div[@class='tb_c immersive-container tb_stc']/descendant::table[@class='Jzru1c']//tr/td[6]"));

	Driver driver=new Driver();
	DriverManager.registerDriver(driver);
	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pro", "Pavithra", "Root@123");
	Statement statement = connection.createStatement();
	System.out.println(teams.size());
	
	
	ArrayList<String> list=new ArrayList<>();
	ResultSet result = statement.executeQuery("select * from IPL_Ranking;");
	while(result.next())
	{

		System.out.println(result.getString("SLN")+" " +result.getString("TeamName"));
	}
	
	ResultSet result1 = statement.executeQuery("select * from IPL_Ranking;");
	for(int i=0;i<teams.size();i++)
	{
			while(result1.next())
	{
		String excpected = result1.getString("TeamName");
		SoftAssert ast=new SoftAssert();
		ast.assertEquals(teams.get(i).getText(), excpected);
		System.out.println("validated");
	ast.assertAll();
   }

	}
	}
}