package org.crm.selenium.utils;

import org.crm.selenium.base.TestBase;
import org.crm.selenium.pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TestUtil extends TestBase{

	//static HomePage homepage = new HomePage();
	
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 10;
	
	
	public static void switchToFrame(String framename) {
		driver.switchTo().frame(framename);
		
	}
	
	public static void switchToParentFrame() {
		driver.switchTo().parentFrame();
	}
}
