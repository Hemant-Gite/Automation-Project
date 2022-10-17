package com.qa.freecrm.utilities;

import java.io.IOException;

import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.qa.freecrm.base.TestBase;

public class CustomTestngListners extends TestBase implements ITestListener, ISuiteListener {
	
	TestUtility tUtility;
	

	public void onTestFailure(ITestResult result) {  		//ITestListener
		
		tUtility = new TestUtility();
		try {
			tUtility.screenshotAtFailuer();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Test fail");
	}
	
	public void onFinish(ITestContext context) {			//ITestListener
		    // not implemented
	}
	 
	 public void onStart(ITestContext context) {			//ITestListener
		    // not implemented
	 }
	 public void onTestFailedWithTimeout(ITestResult result) {			//ITestListener
		 onTestFailure(result);	
	}
	 
	 public void onTestFailedButWithinSuccessPercentage(ITestResult result) {			//ITestListener
		 onTestFailure(result);		
	}	
	 
	public void onTestSkipped(ITestResult result) {			//ITestListener
		    // not implemented
	}
	 
	public void onTestSuccess(ITestResult result) {			//ITestListener
		    // not implemented
	}
	 
	public void onTestStart(ITestResult result) {			//ITestListener
		 System.out.println("Test start");
	}
	 
	public void onStart(ISuite suite) {									//ISuiteListener
		System.out.println("Suit Start: "+ suite.toString());
	}

	public void onFinish(ISuite suite) {								//ISuiteListener
	    System.out.println("Suit Finish: "+ suite.toString());	
	}

}
