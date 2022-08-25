package com.Ty.TestNG;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class DependsOnMethods {
	
	@Test
	public void create()
	{
		int arr[]= {1,2,3,4,5,7,9};
		Reporter.log("Created",true);
		Reporter.log("Array value "+arr[5],true);
	}
	@Test(dependsOnMethods = "create")
	public void modify()
	{
		Reporter.log("Modified",true);
	}
	@Test
	public void send()
	{
		Reporter.log("send",true);
	}
	
	@Test(dependsOnMethods  = {"modify","send"})
	public void delete()
	{
		Reporter.log("Deleted",true);
	}

}
