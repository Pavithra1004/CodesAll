package com.Ty.TestNG;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class PriorityInTestNg {

	@Test(priority = 1)
	public void create()
	{
		Reporter.log("Created",true);
	}
	@Test(priority = 3)
	public void modify()
	{
		Reporter.log("Modified",true);
	}
	
	@Test(priority = 2)
	public void delete()
	{
		Reporter.log("Deleted",true);
	}
	@Test(priority = 2)
	public void send()
	{
		Reporter.log("send",true);
	}
}
