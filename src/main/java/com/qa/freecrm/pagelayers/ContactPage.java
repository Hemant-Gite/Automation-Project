package com.qa.freecrm.pagelayers;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.freecrm.base.TestBase;


public class ContactPage extends TestBase {
		
	@FindBy(xpath = "//div[@name='view']")
	WebElement ddView;
	
	@FindBy(xpath = "//button[text()='Create']")
	WebElement creatContactBtn;
	
	@FindBy(name = "first_name")
	WebElement firstNameE;

	@FindBy(name = "last_name")
	WebElement lastNameE;
	
	@FindBy(xpath = "//div[@name='company']//input")
	WebElement companyNameE;
	
	@FindBy(xpath = "//div[@name='category' and @role='listbox']")
	WebElement categoryTextBox;
	
	@FindBy(xpath = "//div[@class='visible menu transition']//div")
	private static List<WebElement> categoryList;      // Lead Customer Contact Affiliate
	
	@FindBy(xpath = "//div[@name='country']//i[@aria-hidden='true']")
	private WebElement countryDownArrow;
	
	@FindBy(xpath = "//div[@name='country']//div[2]//div")
	private static List<WebElement> countryList;   //India France Australia Japan United States

	@FindBy(xpath = "//button//i[@class='save icon']")
	private WebElement saveBtn;
	
	@FindBy(xpath = "//button[text()='Cancel']")
	private WebElement cancelBtn;

	public ContactPage(){
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean viewDropdownEnability() {
		return ddView.isEnabled();
	}
	
	public void creatNewContact(String firstName, String lastName, String companyName, String category, String country) {
		creatContactBtn.click();
		firstNameE.sendKeys(firstName);
		lastNameE.sendKeys(lastName);
		companyNameE.sendKeys(companyName);
		categoryTextBox.click();
		for (Iterator<WebElement> iterator = categoryList.iterator(); iterator.hasNext();) {
			WebElement categoryE = (WebElement) iterator.next();
			if((categoryE.getText()).equalsIgnoreCase(category)) {
				categoryE.click();
				break;
			}
		}
		countryDownArrow.click();
		for (Iterator<WebElement> iterator = countryList.iterator(); iterator.hasNext();) {
			WebElement countryE = (WebElement) iterator.next();
			if((countryE.getText()).equalsIgnoreCase(country)) {
				countryE.click();
				break;
			}
		}
//		saveBtn.click();
		cancelBtn.click();
		
	}
	
	
}




