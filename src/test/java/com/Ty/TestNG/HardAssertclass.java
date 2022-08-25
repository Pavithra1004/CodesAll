package com.Ty.TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertclass {
	@Test
	public void check()
	{
		System.out.println("ABC");
		Assert.assertEquals("A", "B");
		System.out.println("Print");
	}

}
