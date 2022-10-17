package com.qa.freecrm.pagelayers;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.freecrm.base.TestBase;


public class LoginPage extends TestBase {
	
	@FindBy(xpath = "//input[@name='email']")
	WebElement emailId;
	
	@FindBy(xpath = "//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath = "//div[text()='Login']")
	WebElement loginBtn;
	
	@FindBy(xpath = "//a[text()='Forgot your password?']")
	WebElement forgetLink;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String titleVerification() {
		String title = driver.getTitle();
		return title;
	}
	
	public boolean enabilityOfForgetPassword() {
		boolean flag = forgetLink.isEnabled();
		return flag;
	}
	public HomePage login() {
		emailId.sendKeys(prop.getProperty("username"));
		password.sendKeys(prop.getProperty("password"));
		loginBtn.click();
		return new HomePage();
	}
	
	
}
