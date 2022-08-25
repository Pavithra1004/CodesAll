package com.GenericUtility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class WebDriverUtility {

	public Robot robot;
	public void enter() throws AWTException
	{
		robot = new Robot();
		robot. keyPress(KeyEvent. VK_ENTER);
		robot. keyRelease(KeyEvent. VK_ENTER);
	}
	public void arrowDown() throws AWTException
	{
		robot = new Robot();
		robot. keyPress(KeyEvent.VK_DOWN);
		robot. keyRelease(KeyEvent. VK_DOWN);
	}
	public void arrowUp() throws AWTException
	{
		robot = new Robot();
		robot. keyPress(KeyEvent.VK_UP);
		robot. keyRelease(KeyEvent. VK_UP);
	}
	public void arrowRight() throws AWTException
	{
		robot = new Robot();
		robot. keyPress(KeyEvent.VK_RIGHT);
		robot. keyRelease(KeyEvent. VK_RIGHT);
	}

	public void arrowLeft() throws AWTException
	{
		robot = new Robot();
		robot. keyPress(KeyEvent.VK_LEFT);
		robot. keyRelease(KeyEvent. VK_LEFT);
	}
	public void clickTab() throws AWTException
	{
		robot = new Robot();
		robot. keyPress(KeyEvent.VK_TAB);
		robot. keyRelease(KeyEvent. VK_TAB);
	}
	public void clickShift() throws AWTException
	{
		robot = new Robot();
		robot. keyPress(KeyEvent.VK_SHIFT);
		robot. keyRelease(KeyEvent. VK_SHIFT);
	}
	public void clickControl() throws AWTException
	{
		robot = new Robot();
		robot. keyPress(KeyEvent.VK_CONTROL);
		robot. keyRelease(KeyEvent. VK_CONTROL);
	}
	public void clickAlt() throws AWTException
	{
		robot = new Robot();
		robot. keyPress(KeyEvent.VK_ALT);
		robot. keyRelease(KeyEvent. VK_ALT);
	}
	public void backSpace() throws AWTException
	{
		robot = new Robot();
		robot. keyPress(KeyEvent.VK_BACK_SPACE);
		robot. keyRelease(KeyEvent. VK_BACK_SPACE);
	}
	public void delete() throws AWTException
	{
		robot = new Robot();
		robot. keyPress(KeyEvent.VK_DELETE);
		robot. keyRelease(KeyEvent. VK_DELETE);
	}
	public void escape() throws AWTException
	{
		robot = new Robot();
		robot. keyPress(KeyEvent.VK_ESCAPE);
		robot. keyRelease(KeyEvent. VK_ESCAPE);
	}
	public void home() throws AWTException
	{
		robot = new Robot();
		robot. keyPress(KeyEvent.VK_HOME);
		robot. keyRelease(KeyEvent. VK_HOME);
	}
	public void insert() throws AWTException
	{
		robot = new Robot();
		robot. keyPress(KeyEvent.VK_INSERT);
		robot. keyRelease(KeyEvent. VK_INSERT);
	}
	public void pageUp() throws AWTException
	{
		robot = new Robot();
		robot. keyPress(KeyEvent.VK_PAGE_UP);
		robot. keyRelease(KeyEvent. VK_PAGE_UP);
	}
	public void pageDown() throws AWTException
	{
		robot = new Robot();
		robot. keyPress(KeyEvent.VK_PAGE_DOWN);
		robot. keyRelease(KeyEvent. VK_PAGE_DOWN);
	}
	public void end() throws AWTException
	{
		robot = new Robot();
		robot. keyPress(KeyEvent.VK_END);
		robot. keyRelease(KeyEvent. VK_END);
	}
	public void equals() throws AWTException
	{
		robot = new Robot();
		robot. keyPress(KeyEvent.VK_EQUALS);
		robot. keyRelease(KeyEvent. VK_EQUALS);
	}
	public void clickFunctionKey(String key) throws AWTException
	{
		robot = new Robot();
		robot. keyPress(KeyEvent.VK_F1);
		robot. keyRelease(KeyEvent. VK_F1);
		
	}
	public void f2() throws AWTException
	{
		robot = new Robot();
		robot. keyPress(KeyEvent.VK_F2);
		robot. keyRelease(KeyEvent. VK_F2);
	}
	public void f3() throws AWTException
	{
		robot = new Robot();
		robot. keyPress(KeyEvent.VK_F3);
		robot. keyRelease(KeyEvent. VK_F3);
	}
	public void f4() throws AWTException
	{
		robot = new Robot();
		robot. keyPress(KeyEvent.VK_F4);
		robot. keyRelease(KeyEvent. VK_F4);
	}
	public void f5() throws AWTException
	{
		robot = new Robot();
		robot. keyPress(KeyEvent.VK_F5);
		robot. keyRelease(KeyEvent. VK_F5);
	}
	public void f6() throws AWTException
	{
		robot = new Robot();
		robot. keyPress(KeyEvent.VK_F6);
		robot. keyRelease(KeyEvent. VK_F6);
	}
	public void f7() throws AWTException
	{
		robot = new Robot();
		robot. keyPress(KeyEvent.VK_F7);
		robot. keyRelease(KeyEvent. VK_F7);
	}
	public void f8() throws AWTException
	{
		robot = new Robot();
		robot. keyPress(KeyEvent.VK_F8);
		robot. keyRelease(KeyEvent. VK_F8);
	}
	public void f9() throws AWTException
	{
		robot = new Robot();
		robot. keyPress(KeyEvent.VK_F9);
		robot. keyRelease(KeyEvent. VK_F9);
	}
	public void f10() throws AWTException
	{
		robot = new Robot();
		robot. keyPress(KeyEvent.VK_F10);
		robot. keyRelease(KeyEvent. VK_F10);
	}
	public void f11() throws AWTException
	{
		robot = new Robot();
		robot. keyPress(KeyEvent.VK_F11);
		robot. keyRelease(KeyEvent. VK_F11);
	}
	public void f12() throws AWTException
	{
		robot = new Robot();
		robot. keyPress(KeyEvent.VK_F12);
		robot. keyRelease(KeyEvent. VK_F12);
	}
	public void printScreen() throws AWTException
	{
		robot = new Robot();
		robot. keyPress(KeyEvent.VK_PRINTSCREEN);
		robot. keyRelease(KeyEvent. VK_PRINTSCREEN);
	}
	public void capsLock() throws AWTException
	{
		robot = new Robot();
		robot. keyPress(KeyEvent.VK_CAPS_LOCK);
		robot. keyRelease(KeyEvent. VK_CAPS_LOCK);
	}
	public void select() throws AWTException
	{
		robot = new Robot();
		robot. keyPress(KeyEvent.VK_CONTROL);
		robot. keyPress(KeyEvent.VK_A);
		robot. keyRelease(KeyEvent. VK_A);
		robot. keyRelease(KeyEvent. VK_CONTROL);
		
		
	}
	public void copy() throws AWTException
	{
		robot = new Robot();
		robot. keyPress(KeyEvent.VK_CONTROL);
		robot. keyPress(KeyEvent.VK_C);
		robot. keyRelease(KeyEvent. VK_C);
		robot. keyRelease(KeyEvent. VK_CONTROL);
		
	}
	public void paste() throws AWTException
	{
		robot = new Robot();
		robot. keyPress(KeyEvent.VK_CONTROL);
		robot. keyPress(KeyEvent.VK_V);
		robot. keyRelease(KeyEvent. VK_V);
		robot. keyRelease(KeyEvent. VK_CONTROL);
		
	}
	


}
