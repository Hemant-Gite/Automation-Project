package com.qa.freecrm.testlayers;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.freecrm.base.TestBase;
import com.qa.freecrm.pagelayers.CalendarPage;
import com.qa.freecrm.pagelayers.CompaniesPage;
import com.qa.freecrm.pagelayers.ContactPage;
import com.qa.freecrm.pagelayers.DealsPage;
import com.qa.freecrm.pagelayers.HomePage;
import com.qa.freecrm.pagelayers.LoginPage;
import com.qa.freecrm.pagelayers.TaskPage;
import com.qa.freecrm.pagelayers.WelcomePage;

public class HomePageTest extends TestBase {
	
	WelcomePage wPage;
	LoginPage lPage;
	HomePage hPage;
	CalendarPage clPage;
	CompaniesPage cmPage;
	ContactPage coPage;
	DealsPage dPage;
	TaskPage tPage;
	
	
	@BeforeClass
	public void setUp() {
		initialization();
		wPage = new WelcomePage();
		hPage = wPage.clickOnLoginBtn().login();
	}
	
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	@Test(priority = 1)
	public void titleVerificationTest() {
		String title = hPage.titleVerification();
		Assert.assertEquals(title, "Cogmento CRM");
	}
	
	@Test(priority = 2)
	public void logoDisplayTest() {
		Assert.assertTrue(hPage.logoDisplay());
	}
	
	@Test(priority = 3)
	public void userNameDisplayTest() {
		Assert.assertTrue(hPage.userNameDispaly());
	}
	
	@Test(priority = 4)
	public void enabilityOfSearchbarTest() {
		Assert.assertTrue(hPage.enabilityOfSearchBar());
	}
	
	@Test(priority = 5)
	public void sidePannelEnabilityTest() {
		Assert.assertTrue(hPage.sidePannelEnability());
	}
	
	@Test(priority = 6)
	public void mainContentDisplayTest() {
		Assert.assertTrue(hPage.mainContentDisplay());
	}
	
	@Test(priority = 7, dependsOnMethods = "sidePannelEnabilityTest")
	public void clickOnContactTest() {
		coPage = hPage.clickOnContact();
		hPage.clickOnHomePageBtn();
	}
	
	@Test(priority = 7, dependsOnMethods = "sidePannelEnabilityTest")
	public void clickOnCalendarTest() {
		clPage = hPage.clickOnCalender();
		hPage.clickOnHomePageBtn();
	}
	
	@Test(priority = 7, dependsOnMethods = "sidePannelEnabilityTest")
	public void clickOnCompaniesTest() {
		cmPage = hPage.clickOnCompanies();
		hPage.clickOnHomePageBtn();
	}
	
	@Test(priority = 7, dependsOnMethods = "sidePannelEnabilityTest")
	public void clickOnDealsTest() {
		dPage = hPage.clickOnDeals();
		hPage.clickOnHomePageBtn();
	}
	
	@Test(priority = 7, dependsOnMethods = "sidePannelEnabilityTest")
	public void clickOnTaskTest() {
		tPage = hPage.clickOnTask();
		hPage.clickOnHomePageBtn();
	}
	
}
