package com.qa.freecrm.pagelayers;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.freecrm.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath = "//div[@class='header item']")
	WebElement logo;
	
	@FindBy(xpath = "//span[@class='user-display']")
	WebElement userName;  		//text()='Pritee Shirsath'
	
	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement searchBar;
	
	@FindBy(xpath = "//div[@id='main-nav']//div")
	List<WebElement> sidePannelElements;
	
	@FindBy(xpath = "//*[@id=\"main-content\"]/div/div/div")
	List<WebElement> mainContent;   //  -1
	
	@FindBy(xpath = "//span[text()='Home']")
	WebElement homePageBtn;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String titleVerification() {
		String title = driver.getTitle();
		return title;
	}
	
	public boolean logoDisplay() {
		boolean flag = logo.isDisplayed();
		return flag;
	}
	
	public boolean userNameDispaly() {
		boolean flag = false;
		boolean flag1 = userName.isDisplayed();
		boolean flag2 = (userName.getText()).equalsIgnoreCase("Pritee Shirsath");
		if(flag1 && flag2) {
			flag = true;
		}
		return flag;
	}
	
	public boolean enabilityOfSearchBar() {
		boolean flag = searchBar.isEnabled();
		return flag;
	}
	
	public boolean sidePannelEnability() {
		boolean flag = true;
		for(int i=0; i<sidePannelElements.size(); i++) {
			Boolean flag1 = sidePannelElements.get(i).isEnabled();
			if(flag1 == false) {
				flag = flag1;
				break;
			}
		}
		return flag;
	}
	
	public boolean mainContentDisplay() {
		boolean flag = true;
		for (int i=0; i<mainContent.size()-1; i++) {
			Boolean flag1 = mainContent.get(i).isDisplayed();
			if(flag1==false) {
				flag = flag1;
			}
		}
		return flag;
	}
	
	public ContactPage clickOnContact() {
		for(int i=0; i<sidePannelElements.size(); i++) {
			if((sidePannelElements.get(i).getText()).equalsIgnoreCase("Contacts")) {
				sidePannelElements.get(i).click();
				break;
			}
		}
		return new ContactPage();
	}
	
	public DealsPage clickOnDeals() {
		for(int i=0; i<sidePannelElements.size(); i++) {
			if((sidePannelElements.get(i).getText()).equalsIgnoreCase("Deals")) {
				sidePannelElements.get(i).click();
				break;
			}
		}
		return new DealsPage();
	}
	
	public CalendarPage clickOnCalender() {
		for(int i=0; i<sidePannelElements.size(); i++) {
			if((sidePannelElements.get(i).getText()).equalsIgnoreCase("Calendar")) {
				sidePannelElements.get(i).click();
				break;
			}
		}
		return new CalendarPage();
	}
	
	public TaskPage clickOnTask() {
		for(int i=0; i<sidePannelElements.size(); i++) {
			if((sidePannelElements.get(i).getText()).equalsIgnoreCase("Tasks")) {
				sidePannelElements.get(i).click();
				break;
			}
		}
		return new TaskPage();
	}
	
	public CompaniesPage clickOnCompanies() {
		for(int i=0; i<sidePannelElements.size(); i++) {
			if((sidePannelElements.get(i).getText()).equalsIgnoreCase("Companies")) {
				sidePannelElements.get(i).click();
				break;
			}
		}
		return new CompaniesPage();
	}
	
	public void clickOnHomePageBtn() {
		homePageBtn.click();
	}
}
