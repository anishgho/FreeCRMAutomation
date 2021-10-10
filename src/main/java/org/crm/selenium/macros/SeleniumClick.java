package org.crm.selenium.macros;

import org.crm.selenium.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SeleniumClick extends TestBase {

	public static void click(String locator) {

	driver.findElement(By.xpath(locator)).click();
	}
	
	public static boolean isDisplayed(String locator) {
		return driver.findElement(By.xpath(locator)).isDisplayed();
	}
	
	public static WebElement findElement(String locator) {
		if(locator.contains("@name")) {
			WebElement elem = driver.findElement(By.name(locator));
			return elem;

		}else {
			WebElement elem = driver.findElement(By.xpath(locator));
			return elem;

		}
		
	}
}
