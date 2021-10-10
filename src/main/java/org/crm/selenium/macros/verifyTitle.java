package org.crm.selenium.macros;

import org.crm.selenium.base.TestBase;

public class verifyTitle extends TestBase{

	public static String verifytitle() {
		String actualtitle = driver.getTitle();
		return actualtitle;
				
	}
	
}
