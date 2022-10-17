package com.qa.freecrm.utilities;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.time.Duration;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.events.WebDriverListener;

import com.qa.freecrm.base.TestBase;


public class MYListner extends TestBase implements WebDriverListener{
	
	public static TestUtility tUtility ;

	 // Global

	public void beforeAnyCall(Object target, Method method, Object[] args)  {}
	public void afterAnyCall(Object target, Method method, Object[] args, Object result)  {}

	public void onError(Object target, Method method, Object[] args, InvocationTargetException e) {
		tUtility = new TestUtility();
		try {
			tUtility.screenshotAtFailuer();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		e.printStackTrace();
	}
	

	  // WebDriver

	public void beforeAnyWebDriverCall(WebDriver driver, Method method, Object[] args)  {}
	public void afterAnyWebDriverCall(WebDriver driver, Method method, Object[] args, Object result)  {}

	public void beforeGet(WebDriver driver, String url) {
		System.out.println("Getting: "+ url);
	}
	public void afterGet(WebDriver driver, String url) {
		System.out.println("Got: "+ url);
	}

	public void beforeGetCurrentUrl(WebDriver driver) {
		System.out.println("Getting current url");
	}
	public void afterGetCurrentUrl(String result, WebDriver driver) {
		System.out.println("Got current url");
	}

	public void beforeGetTitle(WebDriver driver) {}
	public void afterGetTitle(WebDriver driver, String result) {}

	public void beforeFindElement(WebDriver driver, By locator) {
		System.out.println("Finding Element: "+ locator);
	}
	public void afterFindElement(WebDriver driver, By locator, WebElement result) {
		System.out.println("Found Element: "+ locator);
	}

	public void beforeFindElements(WebDriver driver, By locator) {
		System.out.println("Finding Elements: "+ locator);
	}
	public void afterFindElements(WebDriver driver, By locator, List<WebElement> result) {
		System.out.println("Found Elements: "+ locator);
	}

	public void beforeGetPageSource(WebDriver driver) {}
	public void afterGetPageSource(WebDriver driver, String result) {}

	public void beforeClose(WebDriver driver) {}
	public void afterClose(WebDriver driver) {}

	public void beforeQuit(WebDriver driver) {}
	public void afterQuit(WebDriver driver) {}

	public void beforeGetWindowHandles(WebDriver driver) {}
	public void afterGetWindowHandles(WebDriver driver, Set<String> result) {}

	public void beforeGetWindowHandle(WebDriver driver) {}
	public void afterGetWindowHandle(WebDriver driver, String result) {}

	public void beforeExecuteScript(WebDriver driver, String script, Object[] args) {}
	public void afterExecuteScript(WebDriver driver, String script, Object[] args, Object result) {}

	public void beforeExecuteAsyncScript(WebDriver driver, String script, Object[] args) {}
	public void afterExecuteAsyncScript(WebDriver driver, String script, Object[] args, Object result) {}

	public void beforePerform(WebDriver driver, Collection<Sequence> actions) {}
	public void afterPerform(WebDriver driver, Collection<Sequence> actions) {}

	public void beforeResetInputState(WebDriver driver) {}
	public void afterResetInputState(WebDriver driver) {}

	  // WebElement

	public void beforeAnyWebElementCall(WebElement element, Method method, Object[] args)  {}
	public void afterAnyWebElementCall(WebElement element, Method method, Object[] args, Object result)  {}

	public void beforeClick(WebElement element) {
		System.out.println("Before clicking: "+ element);
	}
	public void afterClick(WebElement element) {
		System.out.println("After clicked: "+ element);
	}

	public void beforeSubmit(WebElement element) {}
	public void afterSubmit(WebElement element) {}

	public void beforeSendKeys(WebElement element, CharSequence... keysToSend) {
		System.out.println("Sending key: "+ keysToSend);
	}
	public void afterSendKeys(WebElement element, CharSequence... keysToSend) {
		System.out.println("Key sent: "+ keysToSend);
	}

	public void beforeClear(WebElement element) {}
	public void afterClear(WebElement element) {}

	public void beforeGetTagName(WebElement element) {}
	public void afterGetTagName(WebElement element, String result) {}

	public void beforeGetAttribute(WebElement element, String name) {}
	public void afterGetAttribute(WebElement element, String name, String result) {}

	public void beforeIsSelected(WebElement element) {}
	public void afterIsSelected(WebElement element, boolean result) {}

	public void beforeIsEnabled(WebElement element) {}
	public void afterIsEnabled(WebElement element, boolean result) {}

	public void beforeGetText(WebElement element) {}
	public void afterGetText(WebElement element, String result) {}

	public void beforeFindElement(WebElement element, By locator) {
		System.out.println("Finding Element: "+ locator);
	}
	public void afterFindElement(WebElement element, By locator, WebElement result) {
		System.out.println("Finding Element:  "+ locator +"  "+ result);
	}

	public void beforeFindElements(WebElement element, By locator) {}
	public void afterFindElements(WebElement element, By locator, List<WebElement> result) {}

	public void beforeIsDisplayed(WebElement element) {}
	public void afterIsDisplayed(WebElement element, boolean result) {}

	public void beforeGetLocation(WebElement element) {}
	public void afterGetLocation(WebElement element, Point result) {}

	public void beforeGetSize(WebElement element) {}
	public void afterGetSize(WebElement element, Dimension result) {}

	public void beforeGetCssValue(WebElement element, String propertyName) {}
	public void afterGetCssValue(WebElement element, String propertyName, String result) {}

	  // Navigation

	public void beforeAnyNavigationCall(WebDriver.Navigation navigation, Method method, Object[] args)  {}
	public void afterAnyNavigationCall(WebDriver.Navigation navigation, Method method, Object[] args, Object result)  {}

	public void beforeTo(WebDriver.Navigation navigation, String url) {
		System.out.println("Navigating to: "+ url);
	}
	public void afterTo(WebDriver.Navigation navigation, String url) {
		System.out.println("Navigated to: "+ url);
	}

	public void beforeTo(WebDriver.Navigation navigation, URL url) {
		System.out.println("Navigating to: "+ url);
	}
	public void afterTo(WebDriver.Navigation navigation, URL url) {
		System.out.println("Navigated to: "+ url);
	}

	public void beforeBack(WebDriver.Navigation navigation) {}
	public void afterBack(WebDriver.Navigation navigation) {}

	public void beforeForward(WebDriver.Navigation navigation) {}
	public void afterForward(WebDriver.Navigation navigation) {}

	public void beforeRefresh(WebDriver.Navigation navigation) {}
	public void afterRefresh(WebDriver.Navigation navigation) {}

	  // Alert

	public void beforeAnyAlertCall(Alert alert, Method method, Object[] args)  {}
	public void afterAnyAlertCall(Alert alert, Method method, Object[] args, Object result)  {}

	public void beforeAccept(Alert alert) {
		System.out.println("Accepting Alert");
	}
	public void afterAccept(Alert alert) {
		System.out.println("Alert Accepted");
	}

	public void beforeDismiss(Alert alert) {
		System.out.println("Dismissing Alert");
	}
	public void afterDismiss(Alert alert) {
		System.out.println("Alert Dismissed");
	}

	public void beforeGetText(Alert alert) {
		System.out.println("Getting Text from Alert");
	}
	public void afterGetText(Alert alert, String result) {
		System.out.println("Got Text from Alert: "+ result);
	}

	public void beforeSendKeys(Alert alert, String text) {
		System.out.println("Sending text to Alert: "+ text);
	}
	public void afterSendKeys(Alert alert, String text) {
		System.out.println("Text send to Alert: "+ text);
	}

	  // Options

	public void beforeAnyOptionsCall(WebDriver.Options options, Method method, Object[] args)  {}
	public void afterAnyOptionsCall(WebDriver.Options options, Method method, Object[] args, Object result)  {}

	public void beforeAddCookie(WebDriver.Options options, Cookie cookie) {}
	public void afterAddCookie(WebDriver.Options options, Cookie cookie) {}

	public void beforeDeleteCookieNamed(WebDriver.Options options, String name) {}
	public void afterDeleteCookieNamed(WebDriver.Options options, String name) {}

	public void beforeDeleteCookie(WebDriver.Options options, Cookie cookie) {}
	public void afterDeleteCookie(WebDriver.Options options, Cookie cookie) {}

	public void beforeDeleteAllCookies(WebDriver.Options options) {}
	public void afterDeleteAllCookies(WebDriver.Options options) {}

	public void beforeGetCookies(WebDriver.Options options) {}
	public void afterGetCookies(WebDriver.Options options, Set<Cookie> result) {}

	public void beforeGetCookieNamed(WebDriver.Options options, String name) {}
	public void afterGetCookieNamed(WebDriver.Options options, String name, Cookie result) {}

	  // Timeouts

	public void beforeAnyTimeoutsCall(WebDriver.Timeouts timeouts, Method method, Object[] args)  {}
	public void afterAnyTimeoutsCall(WebDriver.Timeouts timeouts, Method method, Object[] args, Object result)  {}

	public void beforeImplicitlyWait(WebDriver.Timeouts timeouts, Duration duration) {}
	public void afterImplicitlyWait(WebDriver.Timeouts timeouts, Duration duration) {}

	public void beforeSetScriptTimeout(WebDriver.Timeouts timeouts, Duration duration) {}
	public void afterSetScriptTimeout(WebDriver.Timeouts timeouts, Duration duration) {}

	public void beforePageLoadTimeout(WebDriver.Timeouts timeouts, Duration duration) {}
	public void afterPageLoadTimeout(WebDriver.Timeouts timeouts, Duration duration) {}

	  // Window

	public void beforeAnyWindowCall(WebDriver.Window window, Method method, Object[] args)  {}
	public void afterAnyWindowCall(WebDriver.Window window, Method method, Object[] args, Object result)  {}

	public void beforeGetSize(WebDriver.Window window) {}
	public void afterGetSize(WebDriver.Window window, Dimension result) {}

	public void beforeSetSize(WebDriver.Window window, Dimension size) {}
	public void afterSetSize(WebDriver.Window window, Dimension size) {}

	public void beforeGetPosition(WebDriver.Window window) {}
	public void afterGetPosition(WebDriver.Window window, Point result) {}

	public void beforeSetPosition(WebDriver.Window window, Point position) {}
	public void afterSetPosition(WebDriver.Window window, Point position) {}

	public void beforeMaximize(WebDriver.Window window) {}
	public void afterMaximize(WebDriver.Window window) {}

	public void beforeFullscreen(WebDriver.Window window) {}
	public void afterFullscreen(WebDriver.Window window) {}

	
}


















