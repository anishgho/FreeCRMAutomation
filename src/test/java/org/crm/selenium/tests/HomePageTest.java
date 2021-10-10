package org.crm.selenium.tests;

import java.util.concurrent.TimeUnit;

import org.crm.selenium.base.TestBase;
import org.crm.selenium.macros.Assertions;
import org.crm.selenium.macros.Navigation;
import org.crm.selenium.macros.verifyTitle;
import org.crm.selenium.pages.ContactsPage;
import org.crm.selenium.pages.DealsPage;
import org.crm.selenium.pages.HomePage;
import org.crm.selenium.pages.LoginPage;
import org.crm.selenium.pages.TaskPage;
import org.crm.selenium.utils.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase{

	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactpage;
	DealsPage dealspage;
	TaskPage taskpage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialisation();
		loginpage = new LoginPage();
		homepage = loginpage.Login(prop.getProperty("username"), prop.getProperty("password"));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@Test(priority=1)
	public void verifyHomepageTitletest() {
		Assertions.assertequal(verifyTitle.verifytitle(), "CRMPRO");
	}
	
	@Test(priority=2)
	public void verifyUsernameTest() {
		TestUtil.switchToFrame("mainpanel");
		WebElement framelem = driver.findElement(By.xpath(homepage.username));
		boolean flag = homepage.verifyUsername(framelem);
		Assertions.asserttrue(flag);
		TestUtil.switchToParentFrame();
		
	}

	@Test(priority=3)
	public void verifyContactPageLinkTest() {
		TestUtil.switchToFrame("mainpanel");
		contactpage= homepage.clickonContactLink();
		Navigation.navigateback();
	}
	
	@Test(priority=4)
	public void verifyDealsPageLinkTest() {
		TestUtil.switchToFrame("mainpanel");
		dealspage = homepage.clickonDealsPageLink();
		Navigation.navigateback();

	}
	
	@Test(priority=5)
	public void verifyTasksPageLinkTest() {
		TestUtil.switchToFrame("mainpanel"); 
		taskpage = homepage.clickonTaskPageLink();
		Navigation.navigateback();

		
	}
	
}
