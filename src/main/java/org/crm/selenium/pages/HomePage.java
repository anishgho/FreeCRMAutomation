package org.crm.selenium.pages;

import java.util.concurrent.TimeUnit;

import org.crm.selenium.base.TestBase;
import org.crm.selenium.macros.SeleniumClick;
import org.crm.selenium.macros.verifyTitle;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage extends TestBase{

	//using an alternative approach to FindBy

	//xpaths for the webelements of the homepage
	//public static String userNameLabel =  "//td[contains(text(),'Anish Ghosh')]";
		
	public String contactLink = "//a[@title='Contacts' and contains(text(),'Contacts')]";
	
	public static String dealsLink = "//a[@title='Deals']";
	
	public static String emailLink = "//a[@title='Email']";
	
	public static String taskLink = "//a[@title='Tasks']";
	
	public String username = "//td[contains(text(),'Anish Ghosh')]";
	
	public String newContactLink = "//a[text()='New Contact']";
	
	public String getHomePageTitle() {
		return verifyTitle.verifytitle();
	}
	
	public boolean verifyUsername(WebElement elem) {
		return elem.isDisplayed();
	 
	}
	
    public ContactsPage clickonContactLink() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    	SeleniumClick.click(contactLink);
    	return new ContactsPage();
    }
	
	public DealsPage clickonDealsPageLink() {
		SeleniumClick.click(dealsLink);
		return new DealsPage();
	}
	
	public TaskPage clickonTaskPageLink() {
		SeleniumClick.click(taskLink);
		return new TaskPage();
	}
	
	public void clickOnNewContactLink() {
		Actions builder = new Actions(driver);
		
		builder.moveToElement(SeleniumClick.findElement(contactLink)).build().perform();
		builder.moveToElement(SeleniumClick.findElement(newContactLink)).click().perform();
		
	}
}
