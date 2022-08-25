package com.Ty.TestNG;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class InvocationCountEX {
	@Test(invocationCount = 3)
	public void create()
	{
		Reporter.log("Created",true);
	}
	@Test(invocationCount = 5)
	public void modify()
	{
		Reporter.log("Modified",true);
	}
	

}
