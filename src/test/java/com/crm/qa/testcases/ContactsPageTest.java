package com.crm.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.Contacts;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {
	
	Logger log = Logger.getLogger(ContactsPageTest.class);
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	Contacts contact;
	String sheetName = "contacts";

	
	public ContactsPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void SetUp()
	{
		log.info("****************************** Starting test cases execution  *****************************************");
		
		initialization();
		testUtil = new TestUtil();
		contact = new Contacts();
		loginPage = new LoginPage();
		homePage  =	loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		testUtil.switchToFrame();
		homePage.clickOnContactsLink();
		
		log.info("entering application URL");
		log.warn("Hey this just a warning message");
		log.fatal("hey this is just fatal error message");
		log.debug("this is debug message");
	}
	
	
	@Test(priority = 1)
	public void verifyContactsPageLevel()
	{
		log.info("****************************** starting test case *****************************************");
		log.info("****************************** verifyContactsPageLevel *****************************************");
		
		Assert.assertTrue(contact.verifyContactsLabel(),"contacts doesn't match");
		
		log.info("****************************** endinging test case *****************************************");
		log.info("****************************** verifyContactsPageLevel *****************************************");
		
	}
	
	@Test(priority = 2)
	public void selectContactsByName()
	{
		log.info("****************************** starting test case *****************************************");
		log.info("****************************** selectContactsByName *****************************************");
		
		contact.selectContactsByName("Amit Shah");
		
		log.info("****************************** ending test case *****************************************");
		log.info("****************************** selectContactsByName *****************************************");
	}
	
	
	@DataProvider
	public Object[][] getCRMTestData()
	{
		Object data[][]=TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority = 3, dataProvider = "getCRMTestData")
	public void validateCreateNewContacts(String title, String firstName, String lastName, String company)
	{
		log.info("****************************** starting test case *****************************************");
		log.info("****************************** validateCreateNewContacts *****************************************");
		
		homePage.clickOnContactsLink();
		contact.createNewContact(title, firstName, lastName, company);
		
		log.info("****************************** ending test case *****************************************");
		log.info("****************************** validateCreateNewContacts *****************************************");
	}
	
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
		
		log.info("****************************** Browser is closed *****************************************");

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
