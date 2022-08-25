package com.Ty.TestNG;

import org.testng.annotations.Test;

public class ParentClassTest {
	@Test(dependsOnMethods = { "testTwo" })
	public void testOne() {
		System.out.println("Test method one");
	}
	@Test(groups = "sanity")
	public void testTwo() {
		System.out.println("Test method two");
	}
}
