package org.crm.selenium.pages;

import org.crm.selenium.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase{

	
	//Page Factory of Login Page - Object Repository
	//instead of using driver.findElement we can use FindBy
	
	@FindBy(xpath="//input[@name='username']")
	WebElement username;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement loginbtn;
	
	@FindBy(xpath="//a[contains(text(),'Sign Up')]")
	WebElement signuplink;
	
	@FindBy(xpath="//a[@class='navbar-brand']//img[@class='img-responsive']")
	WebElement crmlogo;
	
	//initializing the driver with the present objects in the class using PageFactoryClass	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Methods
	public String getTitle()
	{
		return driver.getTitle();
	}
	
	public boolean validateLogo() {
		return crmlogo.isDisplayed();
	}
	
	//returning homepage class object as from login page it is landing to the homepage
	public HomePage Login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginbtn.click();
		
		return new HomePage();
	}
}
