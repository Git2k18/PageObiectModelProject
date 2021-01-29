package com.crm.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {

	LoginPage loginpage;
	HomePage homepage;

	Logger log = Logger.getLogger(LoginPageTest.class);

	public LoginPageTest()
	{
		super();
	}

	@BeforeMethod
	public void setUp() {

		log.info("****************************** Starting test cases execution  *****************************************");
		initialization();
		loginpage = new LoginPage();
		log.info("entering application URL");
		log.warn("Hey this just a warning message");
		log.fatal("hey this is just fatal error message");
		log.debug("this is debug message");
	}


	@Test(priority = 1)
	public void loginPageTitleTest()
	{
		log.info("****************************** starting test case *****************************************");
		log.info("****************************** freeCrmTitleTest *****************************************");
		
		String title = loginpage.validateLoginPageTitle();
		Assert.assertEquals(title, "CRMPRO - CRM software for customer relationship management, sales, and support.","Tittle doesn't match");
		

		log.info("****************************** ending test case *****************************************");
		log.info("****************************** freeCrmTitleTest *****************************************");

	}

	@Test(priority = 2)
	public void crmLogoImageTest()
	{
		log.info("****************************** starting test case *****************************************");
		log.info("****************************** freeCrmLogoTest *****************************************");
		
		boolean flag = loginpage.validateCRMImage();
		Assert.assertTrue(flag);
		
		log.info("****************************** ending test case *****************************************");
		log.info("****************************** freeCrmLogoTest ******************************************");
	}


	@Test(priority = 3)
	public void loginTest()
	{
		log.info("****************************** starting test case *****************************************");
		log.info("****************************** LoginTest **************************************************");
		
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		
		log.info("****************************** ending test case *****************************************");
		log.info("****************************** LoginTest **************************************************");

	}



	@AfterMethod
	public void tearDown() {
		driver.quit();
		
		log.info("****************************** Browser is closed *****************************************");

	}

}
