package com.qa.freecrm.utilities;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

import com.qa.freecrm.base.TestBase;


public class TestUtility extends TestBase  {
	
	
	public static String dataFilePath = "C:\\Users\\asus\\eclipse-workspace\\AutomationProject\\src\\main\\java\\com\\qa\\freecrm\\testdata\\CrmData.xlsx";
	
	public Object[][] dataExtractor(String sheetName) {
		
	ExelReader er = new ExelReader(dataFilePath);
	int cCount = er.getColumnCount(sheetName);
	int rCount = er.getRowCount(sheetName);
	Object testData [][] = new Object[rCount-1][cCount];
	
	for(int rowNum =2; rowNum<=rCount; rowNum++) {
		for(int colNum=0; colNum<cCount; colNum++) {
			testData[rowNum-2][colNum]= er.getCellData(sheetName, colNum, rowNum);
		}
	}
	return testData;
	
	}
	
	
	public void screenshotAtFailuer() throws IOException {
		File srcFile =  ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(srcFile, new File( "C:\\Users\\asus\\eclipse-workspace\\AutomationProject\\screenshots\\"+ System.currentTimeMillis() +".png"));
	}
	
	public void screenshotOnCall(String name) throws IOException {
		File srcFile =  ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(srcFile, new File( "C:\\Users\\asus\\eclipse-workspace\\AutomationProject\\screenshots\\"+ name +".png"));
	}
	
	public void dropDownSelection(String by, String value, WebElement element) {
		
		Select s = new Select(element);
		
		if(by.equalsIgnoreCase("value")) {
			s.selectByValue(value);
		}
		else if (by.equalsIgnoreCase("text")) {
			s.selectByVisibleText(value);
		}
		else if (by.equalsIgnoreCase("index")) {
			int index = Integer.parseInt(value);
			s.selectByIndex(index);
		}
		else {
			try {
				throw new Exception("wrong input for method: dropDownSelection()");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
