package com.Ty.TestNG;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertClass {
	@Test
	public void check()
	{
		SoftAssert s=new SoftAssert();
		System.out.println("Created");
		s.assertEquals("A", "A");
		System.out.println("correct");
		s.assertEquals("B", "C");
		s.assertAll();
	}

}
