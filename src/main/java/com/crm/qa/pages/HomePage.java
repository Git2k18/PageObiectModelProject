package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

	
	@FindBy(xpath="//td[contains(text(), 'User: Demo User')]")
	WebElement userNameLabel;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement NewContacts;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement DealsLink;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement Tasks;
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public String verifyHomePage()
	{
		return driver.getTitle();
	}
	
	public boolean VerifyCorrectUseName()
	{
	return userNameLabel.isDisplayed();
	}
	
	public Contacts clickOnContactsLink()
	{
		
		contactsLink.click();
		return new Contacts();
	}
	
	
	public DealsPage clickOnDealsLink()
	{
		DealsLink.click();
		return new DealsPage(); // Return Deals Page
	}
	
	public TaskPage ClickOnTaskPage()
	{
		Tasks.click();
		return new TaskPage(); //Return Task Page
	}
	
	public void ClickOnNewContactList()
	{
		Actions action = new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		NewContacts.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
