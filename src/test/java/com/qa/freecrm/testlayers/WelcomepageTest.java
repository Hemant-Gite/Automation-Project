package com.qa.freecrm.testlayers;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.freecrm.base.TestBase;
import com.qa.freecrm.pagelayers.LoginPage;
import com.qa.freecrm.pagelayers.WelcomePage;

public class WelcomepageTest extends TestBase {
	
	WelcomePage wPage;
	LoginPage lPage;
	
	
	@BeforeClass
	public void setUp()   {
		initialization();
		wPage = new WelcomePage();
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	@Test (priority = 1)
	public void titleVerificationTest() {
		String title = wPage.titelVerification();
		Assert.assertEquals(title, "#1 Free CRM customer relationship management software cloud");
	}
	@Test(priority = 2)
	public void headerEnabilityTest() {
		boolean flag = wPage.enabilityOfHeaderLinks();
		Assert.assertTrue(flag);
	}
	
	@Test(priority = 3)
	public void loginButtonEnabilityTest() {
		boolean flag = wPage.loginBtnEnability();
		Assert.assertTrue(flag);
	}
	
	@Test(priority = 5, dependsOnMethods = "loginButtonEnabilityTest")
	public void clickOnLoginButtonTest() {
		lPage = wPage.clickOnLoginBtn();
	}
	
	@Test(priority = 4)
	public void signUpButtonEnabilityTest() {
		boolean flag = wPage.signupBtnEnability();
		Assert.assertTrue(flag);
	}
	
		
	
	
}
