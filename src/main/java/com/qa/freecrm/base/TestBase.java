package com.qa.freecrm.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverListener;

import com.qa.freecrm.utilities.MYListner;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase(){
		prop = new Properties();
		try {
			FileInputStream ipsStream = new FileInputStream("C:\\Users\\asus\\eclipse-workspace\\AutomationProject\\src\\"
					+ "main\\java\\com\\qa\\freecrm\\configuration\\config.properties");
			prop.load(ipsStream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void initialization() {
		String browser = prop.getProperty("browser");
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\asus\\Downloads\\chromedriver\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\asus\\Downloads\\geckodriver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else {
			System.out.println("Browser input from configuration is not correct");
		}
		
		WebDriverListener eListener = new MYListner();
        driver =  new EventFiringDecorator<WebDriver>(eListener).decorate(driver);  
        
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
		driver.get(prop.getProperty("url"));
	}
	
	
}
