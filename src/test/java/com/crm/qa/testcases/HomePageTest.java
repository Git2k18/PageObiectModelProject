package com.crm.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.Contacts;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase{


	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	Contacts contact;

	Logger log = Logger.getLogger(HomePageTest.class);
	
	public HomePageTest()
	{
		super();
	}

	@BeforeMethod
	public void SetUp()
	{
		log.info("****************************** Starting test cases execution  *****************************************");
		
		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		homePage  =	loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		
		log.info("entering application URL");
		log.warn("Hey this just a warning message");
		log.fatal("hey this is just fatal error message");
		log.debug("this is debug message");
	}

   
	@Test(priority = 1)
	public void  verifyHomePageTitleTest()
	{
		log.info("****************************** starting test case *****************************************");
		log.info("****************************** verifyHomePageTitleTest *****************************************");
		
	String homePageTittle=	homePage.verifyHomePage();
	Assert.assertEquals(homePageTittle, "CRMPRO","Home Page Title not matched");
	
	log.info("****************************** ending test case *****************************************");
	log.info("****************************** verifyHomePageTitleTest *****************************************");
	}

	@Test(priority = 2)
	public void VerifyUserNameTest()
	{
		log.info("****************************** starting test case *****************************************");
		log.info("****************************** VerifyUserNameTest *****************************************");
		
		testUtil.switchToFrame();
		Assert.assertTrue(homePage.VerifyCorrectUseName());
		
		log.info("****************************** ending test case *****************************************");
		log.info("****************************** VerifyUserNameTest *****************************************");
	}

	@Test(priority = 3)
    public void VerifyContactsLinkTest()
    {
		log.info("****************************** starting test case *****************************************");
		log.info("****************************** VerifyContactsLinkTest *****************************************");
		
		testUtil.switchToFrame();
		contact = homePage.clickOnContactsLink();
		
		log.info("****************************** ending test case *****************************************");
		log.info("****************************** VerifyContactsLinkTest *****************************************");
		
    }

	@AfterMethod
	public void tearDown() {
		driver.quit();
		
		log.info("****************************** Browser is closed *****************************************");

	}
}
