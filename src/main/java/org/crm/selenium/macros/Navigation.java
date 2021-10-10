package org.crm.selenium.macros;

import java.util.concurrent.TimeUnit;

import org.crm.selenium.base.TestBase;

public class Navigation extends TestBase{

	public static void navigateback() {
		driver.navigate().back();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public static void navigateTo(String url) {
		driver.navigate().to(url);
	}
}
