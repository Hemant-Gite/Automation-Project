package com.qa.freecrm.pagelayers;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.freecrm.base.TestBase;

public class WelcomePage extends TestBase {
	

	@FindBy(xpath="//a[text()='Login']")
	public WebElement loginBtn;
	
	@FindBy(xpath = "//*[text()='sign up']")
	public WebElement signupBtn;
	
	@FindBy(xpath = "/html/body/div[1]/header/div/nav/div/div/div[2]/ul/li")
	public List<WebElement> headerLinks;
	
	
	
	public WelcomePage() {
		PageFactory.initElements(driver, this);

	}

	public String titelVerification(){
		String title = driver.getTitle();
		return title;
	}
	
	public boolean enabilityOfHeaderLinks() {
		boolean sFlag = true;
		for(int i = 0; i<headerLinks.size(); i++) {
			boolean flag = headerLinks.get(i).isEnabled();
			if (flag == false) {
				sFlag = false;
				break;
			}
		}
		return sFlag;
	}
	
	public boolean loginBtnEnability() {
		boolean flag = loginBtn.isEnabled();
		return flag;
	}
	
	public boolean signupBtnEnability() {
		boolean flag = signupBtn.isEnabled();
		return flag;
	}
	
	public LoginPage clickOnLoginBtn()  {
		WebElement preloader = driver.findElement(By.xpath("//div[@id='preloader']"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.invisibilityOf(preloader));

		loginBtn.click();
		return new LoginPage();
	}
	
	public SignupPage clickOnSignupBtn() {
		signupBtn.click();
		return new SignupPage();
	}
}
