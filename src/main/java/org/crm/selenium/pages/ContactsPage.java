package org.crm.selenium.pages;

import org.crm.selenium.base.TestBase;
import org.crm.selenium.macros.SeleniumClick;
import org.openqa.selenium.support.ui.Select;

public class ContactsPage extends TestBase{

	public String contactlabel = "//td[contains(text(),'Contacts')]";
	
	public String firstname = "//input[@name='first_name']";
	
	public String surname = "//input[@name='surname']";
	
	public String companyname = "//strong[text()='Company']/parent::td/following-sibling::td//input[3]";
	
	public String selectName = "//select[@name='title']";

	public String savebtn = "//input[@value='Load From Company']/following-sibling::input[@value='Save']";
	
	//dynamic xpath example
	public String checkboxpath = "//a[contains(text(),'Anish Ghosh') and @_cid='29588599']/parent::td/preceding-sibling::td/input[1]";
	
	public boolean verifyContactsPage() {
		boolean val = SeleniumClick.isDisplayed(contactlabel);
		return val;
	}
	
	
	public void createNewContact(String title, String ftname, String ltname, String comp) {
		
		Select select = new Select(SeleniumClick.findElement(selectName));
		select.selectByVisibleText(title);
		
		SeleniumClick.findElement(firstname).sendKeys(ftname);
		SeleniumClick.findElement(surname).sendKeys(ltname);
		SeleniumClick.findElement(companyname).sendKeys(comp);
		SeleniumClick.click(savebtn);
		
	}
	
}
