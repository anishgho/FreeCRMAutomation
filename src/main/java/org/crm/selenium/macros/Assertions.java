package org.crm.selenium.macros;

import org.testng.Assert;

public class Assertions {

	public static void assertequal(String a, String b) {
		Assert.assertEquals(a, b);;
	}
	
	public static void asserttrue(boolean condition) {
		Assert.assertTrue(condition);
	}
}

