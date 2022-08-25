package com.Ty.TestNG;

import org.testng.annotations.Test;

public class DependsOnParent  extends ParentClassTest
{
	@Test(groups = {"sanity","regression"})
	public void testThree() 
	{
		System.out.println("testThree");
	}

	@Test(dependsOnMethods  = "testThree")
	public void testFour() 
	{
		System.out.println("testFour");
	}
}
