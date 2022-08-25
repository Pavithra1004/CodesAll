package com.GenericUtility;

import java.awt.AWTException;
import java.awt.Robot;

public class WebDriverMethods {
	public Robot robot;
	/*
	 * If we need to click one key like ENTER,ALT,CAPS LOCK we can use this method
	 * In parameter we should pass like (KeyEvent.VK_ENTER)
	 */
	public void selectOneKey(int key) throws AWTException
	{
		robot = new Robot();
		robot. keyPress(key);
		robot. keyRelease(key);
	}
	/*
	 * If we want to click two keys in keyboard i we can use this method lick Control + A,Control +C
	 * In parameter we should pass like (KeyEvent.VK_CONTROL,KeyEvent_VK_A)
	 */
	public void selectTwoKey(int f1,int f2) throws AWTException
	{
		robot = new Robot();
		robot. keyPress(f1);
		robot. keyPress(f2);
		robot. keyRelease(f2);
		robot. keyRelease(f1);	
	}
	
	/*If we want to click two keys in keyboard i we can use this method lick Control + A,Control +C
	 * In parameter we should pass like (KeyEvent.VK_CONTROL,KeyEvent.VK_SHIFT,KeyEvent.VK_O)
	 */
	public void selectThreeKey(int f1,int f2,int f3) throws AWTException
	{
		robot = new Robot();
		robot. keyPress(f1);
		robot. keyPress(f2);
		robot. keyPress(f3);
		robot. keyRelease(f3);
		robot. keyRelease(f2);
		robot. keyRelease(f1);
		
	}

}
