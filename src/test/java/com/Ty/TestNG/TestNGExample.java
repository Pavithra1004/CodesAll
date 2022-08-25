package com.Ty.TestNG;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestNGExample {
	@Test
	public void create()
	{
		Reporter.log("Created",true);
	}
	@Test
	public void modify()
	{
		Reporter.log("Modified",true);
	}
	
	@Test
	public void delete()
	{
		Reporter.log("Deleted",true);
	}
}
