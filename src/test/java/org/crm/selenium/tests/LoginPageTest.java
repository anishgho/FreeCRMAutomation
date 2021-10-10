package org.crm.selenium.tests;

import org.crm.selenium.base.TestBase;
import org.crm.selenium.macros.Assertions;
import org.crm.selenium.pages.HomePage;
import org.crm.selenium.pages.LoginPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends TestBase{

	LoginPage loginpage;
	HomePage homepage;
	
	public LoginPageTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setup() {
		initialisation();
		loginpage = new LoginPage();
	}
	
	@Test(priority=1)
	public void LoginPageTitleTest() {
		String title = loginpage.getTitle();
		String actitle = "Free CRM - CRM software for customer relationship management, sales, and support.";
		Assertions.assertequal(title, actitle);
		
	}
	
	@Test(priority=2)
	public void CRMLogoValidationTest() {
		boolean flag = loginpage.validateLogo();
		Assertions.asserttrue(flag);
	}
	
	@Test(priority=3)
	public void LoginTest() {
		homepage = loginpage.Login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
//	@AfterMethod
//	public void teardown()
//	{
//		browserclose();
//	}
}
