package com.qa.freecrm.testlayers;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.freecrm.base.TestBase;
import com.qa.freecrm.pagelayers.HomePage;
import com.qa.freecrm.pagelayers.LoginPage;
import com.qa.freecrm.pagelayers.WelcomePage;

public class LoginPageTest extends TestBase {
	
	WelcomePage wPage;
	LoginPage lPage;
	HomePage hPage;
	
	
	@BeforeClass
	public void setUp() {
		initialization();
		wPage = new WelcomePage();
		lPage = wPage.clickOnLoginBtn();
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	@Test(priority = 1)
	public void titleVerificationTest() {
		String title = lPage.titleVerification();
		Assert.assertEquals(title, "Cogmento CRM");
	}
	
	@Test(priority = 2)
	public void enabilityOfForgetPasswordTest() {
		boolean flag = lPage.enabilityOfForgetPassword();
		Assert.assertTrue(flag);
	}
	
	@Test(priority = 3)
	public void loginTest() {
		hPage = lPage.login();
	}		
}
