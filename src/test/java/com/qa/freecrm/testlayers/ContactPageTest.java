package com.qa.freecrm.testlayers;



import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.freecrm.base.TestBase;
import com.qa.freecrm.pagelayers.ContactPage;
import com.qa.freecrm.pagelayers.WelcomePage;
import com.qa.freecrm.utilities.TestUtility;

public class ContactPageTest extends TestBase {
	
	WelcomePage wPage;
	ContactPage coPage;
		
	
	@DataProvider
	public Object[][] getTestData() {
		
		TestUtility xUtility = new TestUtility();
		Object testData [][] = xUtility.dataExtractor("ContactDetails");
		return testData;
		
	}
	
	@BeforeClass
	public void setUp() {
		initialization();
		wPage = new WelcomePage();
		coPage = wPage.clickOnLoginBtn().login().clickOnContact();
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	
	
	@Test(enabled = false)
	public void viewDropdownEnabilityTest() {
		Assert.assertTrue(coPage.viewDropdownEnability());
	}
	
	@Test(dataProvider = "getTestData")
	public void creatNewContactTest(String firstName, String lastName, String companyName, String category, String country) {
		coPage.creatNewContact(firstName, lastName, companyName, category, country);
		
		
	}
	
}

