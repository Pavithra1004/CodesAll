package com.Ty.ObjectRepository;

import java.awt.AWTException;
import java.awt.Robot;

public class RobotClassPom {
	Robot robot;
	public void keyPressRobotActions(int keyCode) {

		try {
			robot=new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		robot.keyPress(keyCode);
	}
	/**
	 * Robot Class
	 * This method contains Key Release Actions.
	 */
	public void keyReleaseRobotActions(int keyCode) {
		try {
			robot=new Robot();
		}
		catch (AWTException e) 
			{
				e.printStackTrace();
			}
			robot.keyRelease(keyCode);
		}
}