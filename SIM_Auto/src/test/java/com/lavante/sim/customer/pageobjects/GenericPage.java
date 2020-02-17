/**
 * Company			: 	LAVANTE
 * Project Name	   	:	Lavante SIM Application
 * Automation		: 	Selenium Automation
 * Author			: 	MadhuMurthy 
 *//*

package com.lavante.sim.customer.pageobjects;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import com.lavante.sim.Common.Util.ConfigPathFile;

public class GenericPage  {
	static WebElement web_Element = null;
	static WebDriverWait wait = null;
	public static Connection con = null;
	public static Statement stmt = null;
	public WebDriver driver=null;
		
	public GenericPage(WebDriver driver){
		this.driver=driver;
	}
	
	public GenericPage() {
		// TODO Auto-generated constructor stub
	}

	public static String DBURL = "", DBUserName="", DBPassword="";
	public static ResultSet ResSet  =null, RetRS =null, Rest=null;

	*//**
	 * Method Name : isWebElementExists Purpose: Method for isWebElementExists
	 * 
	 * @param: mDriver,identifyB,locator
	 * @return
	 * @throws MalformedURLException 
	 *//*
	
	public void launchAppFromPOM(String Platform, String browser, String Version ) throws MalformedURLException
	{
		System.out.println("BR"+browser+Version);
		String strRemoteURL = System.getProperty("RemoteURL");
		String strRemoteExec = System.getProperty("RemoteExecution");
		DesiredCapabilities caps = new DesiredCapabilities();
		URL remoteAddress = new URL(strRemoteURL + "/wd/hub");
		if (browser.equalsIgnoreCase("firefox")) {
			caps = DesiredCapabilities.firefox();
			caps.setBrowserName("firefox");
		} else if (browser.equalsIgnoreCase("chrome")) {
			caps = DesiredCapabilities.chrome();
			caps.setBrowserName("chrome");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");
			options.addArguments("--test-type");
			caps.setCapability(ChromeOptions.CAPABILITY, options);
		} else if (browser.equalsIgnoreCase("internet explorer")) { System.out.println("AS");
			caps = DesiredCapabilities.internetExplorer();
			caps.setBrowserName("internet explorer");
			caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
			caps.setCapability("ignoreZoomSetting", true);
			caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			caps.setCapability(CapabilityType.SUPPORTS_ALERTS, true);
			caps.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, true);
			caps.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, true);
			caps.setCapability(CapabilityType.SUPPORTS_APPLICATION_CACHE, false);
		} else {
			System.err.println("Invalid browser! Unable to execute...");
		
		}
		
		driver = new RemoteWebDriver(remoteAddress, caps);
	}
	
	public void launchAppForDebugg()
	{
		DesiredCapabilities caps = new DesiredCapabilities();
		caps = DesiredCapabilities.firefox();
		caps.setBrowserName("firefox");
		driver = new FirefoxDriver(caps);
		//driver.manage().window().maximize();
	}
	
	 public void quitBrowser()	{
	    	
		 	driver.close();
	    	driver.quit();
	    	
	    }
	
	@SuppressWarnings("unused")
	public  WebElement isWebElementExists(WebDriver driver2,
			String identifyBy, String locator) {
		WebElement rtn_Web_Element = null;
		int size=0;
		System.out.println(driver2+identifyBy+locator);
		boolean rtn_ElementState = false;
		if(identifyBy.equalsIgnoreCase("xpath"))
		{ 
			rtn_Web_Element=driver2.findElement(By.xpath(locator));
			System.out.println(rtn_Web_Element);
			rtn_ElementState=true;
			size=driver2.findElements(By.xpath(locator)).size();	
		} else if(identifyBy.equalsIgnoreCase("id")){
			size=driver2.findElements(By.id(locator)).size(); 
			rtn_Web_Element=driver2.findElement(By.id(locator)); 
			rtn_ElementState=true;
		
		} else if(identifyBy.equalsIgnoreCase("css")){
			rtn_Web_Element=driver2.findElement(By.cssSelector(locator));
			size=driver2.findElements(By.cssSelector(locator)).size();
			rtn_ElementState=true;
		}else if(identifyBy.equalsIgnoreCase("linkText"))
		{
			rtn_Web_Element=driver2.findElement(By.linkText(locator));
			size=driver2.findElements(By.linkText(locator)).size();
			rtn_ElementState=true;
		}else if(identifyBy.equalsIgnoreCase("className"))
		{ 
			rtn_Web_Element=driver2.findElement(By.className(locator));
			System.out.println(rtn_Web_Element);
			rtn_ElementState=true;
			size=driver2.findElements(By.xpath(locator)).size();	
		}
		
		System.out.println(size);
		if(size>0)
		{
			rtn_ElementState = true;
		}
		System.out.println("SUCCESSFULLY element exist");
		
	return rtn_Web_Element;
		boolean rtn_ElementState = false;
		WebElement rtn_Web_Element = null;

		By findBy = null;
		try {
			wait = new WebDriverWait(mDriver, 50);
			switch (identifyBy) {
			case "id":
				rtn_ElementState = wait.until(ExpectedConditions
						.presenceOfElementLocated(By.id(locator))) != null;
				findBy = By.id(locator);
				break;

			case "xpath":
				rtn_ElementState = wait.until(ExpectedConditions
						.presenceOfElementLocated(By.xpath(locator))) != null;
				findBy = By.xpath(locator);
				break;

			case "name":
				rtn_ElementState = wait.until(ExpectedConditions
						.presenceOfElementLocated(By.name(locator))) != null;
				findBy = By.name(locator);
				break;

			case "className":
				rtn_ElementState = wait.until(ExpectedConditions
						.presenceOfElementLocated(By.className(locator))) != null;
				findBy = By.className(locator);
				break;

			case "css":
				rtn_ElementState = wait.until(ExpectedConditions
						.presenceOfElementLocated(By.cssSelector(locator))) != null;
				findBy = By.cssSelector(locator);
				break;
			case "linkText":
				rtn_ElementState = wait.until(ExpectedConditions
						.presenceOfElementLocated(By.linkText(locator))) != null;
				findBy = By.linkText(locator);
				break;

			case "partialLinkText":
				rtn_ElementState = wait.until(ExpectedConditions
						.presenceOfElementLocated(By.partialLinkText(locator))) != null;
				findBy = By.partialLinkText(locator);
				break;

			case "tagName":
				rtn_ElementState = wait.until(ExpectedConditions
						.presenceOfElementLocated(By.tagName(locator))) != null;
				findBy = By.tagName(locator);
				break;

			default:				
				break;
			}
			wait.until(ExpectedConditions.presenceOfElementLocated(findBy));
			rtn_Web_Element = mDriver.findElement(findBy);
			
		} catch (Exception e) {
		//	log.severe("Test is Failed due to exception occured in the method isWebElementExists for the locator "+ locator + " due to  " + e.getMessage());
			takeScreenshot(mDriver, "WebElementDoesNotExists");
			Assert.assertTrue(false,"Test is Failed due to exception occured in the method isWebElementExists for the locator "	+ locator + "  due to  " + e.getMessage());
		}
		return rtn_Web_Element;
	}

	*//**
	 * Method Name : keyTab Purpose: Method for TabOperation
	 * 
	 * @param: mDriver,identifyBy,locator
	 * @return None
	 *//*

	public  void keyTab(WebDriver mDriver, String identifyBy,
			String locator) {
		try {
			web_Element = isWebElementExists(mDriver, identifyBy, locator);
			web_Element.sendKeys(Keys.TAB);

		} catch (Exception e) {
		//	log.severe("Exception in the method keyTab for the element "
		//			+ locator + " due to  " + e.getMessage());
			Assert.assertTrue(false,
					"Exception in the method keyTab for the element " + locator
					+ " due to  " + e.getMessage());
		}
	}

	*//**
	 * Method Name : navigateTo_Back_Frwrd_Page Purpose: Method for
	 * navigateTo_Back_Frwrd_Page
	 * 
	 * @param: mDriver,identifyBy,locator
	 * @return None
	 *//*

	public  void navigateTo_Back_Frwrd_Page(WebDriver mDriver,
			String operation) {
		try {
			waitForTime(1500);
			if (operation.equalsIgnoreCase(ConfigPathFile.BACKPAGE
					.getConstantValue())) {
				mDriver.navigate().back();
			} else if (operation.equalsIgnoreCase(ConfigPathFile.FORWARDPAGE
					.getConstantValue())) {
				mDriver.navigate().forward();
			} else if (operation.equalsIgnoreCase(ConfigPathFile.REFRESH
					.getConstantValue())) {
				mDriver.navigate().refresh();
			}
		} catch (Exception e) {
			//log.severe(" Exception occured in the method navigateTo_Back_Frwrd_Page "
				//	+ e.getMessage());
			Assert.assertTrue(false,
					" Exception occured in the method navigateTo_Back_Frwrd_Page "
							+ e.getMessage());
		}
	}

	*//**
	 * Method Name : PressEnterkey Purpose: Method for Enter key Operation
	 * 
	 * @param: mDriver,identifyBy,locator
	 * @return None
	 *//*

	public  void pressEnterkey(WebDriver mDriver, String identifyBy,
			String locator) {
		try {
			web_Element = isWebElementExists(mDriver, identifyBy, locator);
			web_Element.sendKeys(Keys.ENTER);
		} catch (Exception e) {
		//	log.severe("Exception in the method pressEnterkey for the element "
			//		+ locator + " due to  " + e.getMessage());
			Assert.assertTrue(false,"Exception in the method pressEnterkey for the element "+ locator + " due to  " + e.getMessage());
		}
	}

	*//**
	 * Method Name : assertPageTitle Purpose: Method for assertPageTitle
	 * 
	 * @param: mDriver,expectedPageTitle
	 * @return None
	 *//*

	public  boolean assertPageTitle(WebDriver mDriver,String expectedPageTitle) {
		String actualPageTitle = "";
		waitForTime(2000);
		actualPageTitle = mDriver.getTitle().trim().toString();
		expectedPageTitle = expectedPageTitle.trim().toString();
		if (actualPageTitle.contains(expectedPageTitle)) {
			return true;
		} else
		//	log.severe("Expected page doesn't displayed   "	+ "    Actual title:   " + actualPageTitle	+ " Expected title:   " + expectedPageTitle);
		Assert.assertTrue(false, "  Actual page title:    " + actualPageTitle + "    Expected page title:    " + expectedPageTitle);
		return false;
	}

	*//**
	 * Method Name : compareText Purpose: Method for compare the given Text
	 * @param: mDriver,expectedText,identifyBy,locator
	 * @return boolean value
	 *//*

	public  boolean compareText(WebDriver mDriver,String expectedText,String identifyBy,String locator) {
		String actualText = "";
		actualText = getText(mDriver, identifyBy, locator);
		Reporter.log("ActualText: "+actualText);
		if (actualText.trim().toLowerCase().toString().contains(expectedText.trim().toLowerCase().toString())) {
			return true;
		} else
			return false;
	}

	*//**
	 * Method Name : getText Purpose: Method for getText value
	 * 
	 * @param: mDriver,identifyBy,locator
	 * @return None
	 *//*

	public  String getText(WebDriver mDriver, String identifyBy,String locator) {
		String str_Text = "";
		try { 
			web_Element = isWebElementExists(mDriver, identifyBy, locator);
			str_Text = web_Element.getText();
			str_Text=str_Text.toString();
			System.out.println("GET TEXT :"+str_Text);
		} catch (Exception e) {
		//	log.severe("Exception in the method getText for the element "
			//		+ locator + " due to  " + e.getMessage());
		}
		return str_Text;
	}



	*//**
	 * Method Name : jsExecutor Purpose: Method to Click through jsExcutor
	 * 
	 * @param: mDriver,identifyBy,locator
	 * @return None
	 *//*

	public  void jsExecutor(WebDriver mDriver, String identifyBy,WebElement locator) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) mDriver;
			js.executeScript("arguments[0].click();", locator);	
		} catch (Exception e) {
		//	log.severe("Exception in the method jsExcutor for the element "
			//		+ locator + " due to  " + e.getMessage());
			Assert.assertTrue(false,"Exception in the method jsExcutor for the element "
					+ locator + " due to  " + e.getMessage());
		}
	}

	*//**
	 * Method Name : explicitWaitForWebElement Purpose: Method for
	 * explicitWaitForWebElement or page properties to load
	 * 
	 * @param: driver,identifyBy,locator
	 * @return None
	 *//*
	public  void explicitWaitForWebElementToLoad(WebDriver driver,
			String identifyBy, String locator) {
		try {
			wait = new WebDriverWait(driver, 60);
			switch (identifyBy) {
			case "id":
				wait.until(ExpectedConditions.presenceOfElementLocated(By
						.id(locator)));
				break;

			case "xpath":
				wait.until(ExpectedConditions.presenceOfElementLocated(By
						.xpath(locator)));
				break;

			case "css":
				wait.until(ExpectedConditions.presenceOfElementLocated(By
						.cssSelector(locator)));
				break;

			case "linkText":
				wait.until(ExpectedConditions.presenceOfElementLocated(By
						.linkText(locator)));
				break;

			case "partialLinkText":
				wait.until(ExpectedConditions.presenceOfElementLocated(By
						.partialLinkText(locator)));
				break;

			case "name":
				wait.until(ExpectedConditions.presenceOfElementLocated(By
						.name(locator)));
				break;

			case "className":
				wait.until(ExpectedConditions.presenceOfElementLocated(By
						.className(locator)));
				break;

			case "tagName":
				wait.until(ExpectedConditions.presenceOfElementLocated(By
						.tagName(locator)));
				break;

			default:
				break;
			}
		} catch (Exception e) {
		//	log.severe("Exception in the method explicitWaitForWebElementToLoad for the element "
			//		+ locator + " due to  " + e.getMessage());
			Assert.assertTrue(false,
					"Exception in the method explicitWaitForWebElementToLoad for the element "
							+ locator + " due to  " + e.getMessage());
		}
	}

	*//**
	 * Method Name : explicitWaitForAlert Purpose: Method for
	 * explicitWaitForAlert
	 * 
	 * @param: driver, alertStatus
	 * @return None
	 *//*

	public  String explicitWaitForAlert(WebDriver driver,
			String alertStatus) {
		String alertMessage = "";
		Alert alert = null;
		try {
			wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.alertIsPresent());
			alert = driver.switchTo().alert();
			alertMessage = alert.getText();
			if (alertStatus.equalsIgnoreCase("accept")) {
				alert.accept();
			} else
				alert.dismiss();
		} catch (Exception e) {
		//	log.severe("Exception In the method explecitWaitForAlert due to "
		//			+ e.getMessage());
		}
		return alertMessage;
	}

	*//**
	 * Method Name : waitForTime Purpose: Method for waitForTime
	 * 
	 * @param: longtime
	 * @return None
	 *//*

	public  void waitForTime(long time) { 
		try {  Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        System.out.println( sdf.format(cal.getTime()) );
			Thread.sleep(time);
		 System.out.println( sdf.format(cal.getTime()) );
		} catch (InterruptedException e) {
		//	log.severe("Exception in the method waitForTime due to   "
			//		+ e.getMessage());
			Assert.assertTrue(
					false,
					"Exception in the method waitForTime due to   "
							+ e.getMessage());
		} 
	}

	*//**
	 * Method Name : handleChildWindow Purpose: Method for getChildWindow handle
	 * 
	 * @param: mDriver,flag
	 * @return None
	 *//*

	@SuppressWarnings("unused")
	public  void handleFirstChildWindow(WebDriver mDriver, boolean flag) {
		String parentBrowser = "";
		String childBrowser = "";
		WebDriver popup = null;
		waitForTime(2000);
		try {
			parentBrowser = mDriver.getWindowHandle();
			System.out.println("PARENT"+parentBrowser);
			Iterator<String> itr = mDriver.getWindowHandles().iterator();
			if (flag) {
				while (itr.hasNext()) {
					childBrowser = itr.next();
					popup = mDriver.switchTo().window(childBrowser);
					System.out.println(popup);
				}
			} else {
				mDriver.close();
				parentBrowser=itr.next();
				mDriver.switchTo().window(parentBrowser);
			}
		} catch (Exception e) {
		//	log.severe("Exception in handleChildWindow due to "
			//		+ e.getMessage());
			Assert.assertTrue(
					false,
					"Exception in method handleChildWindow due to "
							+ e.getMessage());
		}
	}

	*//**
	 * Method Name : handlePopUpWindow Purpose: Method for handlePopUpWindow
	 * 
	 * @param: mDriver,identifyBy,identifyBy,pagePartialURL
	 * @return None
	 *//*
	public  String[] handlePopUpWindow(WebDriver mDriver, String page,
			String switchWith) {
		String parentWindow = null;
		String rtnHandle = "";
		try {
			parentWindow = mDriver.getWindowHandle();
			for (String winHandled : mDriver.getWindowHandles()) {
				if (!winHandled.equals(parentWindow)) {
					if (switchWith.equalsIgnoreCase(ConfigPathFile.TITLE
							.getConstantValue())) { waitForTime(2000);
						if (mDriver.switchTo().window(winHandled).getTitle()
								.endsWith(page)) {
							rtnHandle = winHandled;
							break;
						}
					} else if (switchWith.equalsIgnoreCase(ConfigPathFile.URL
							.getConstantValue())) {
						if (mDriver.switchTo().window(winHandled)
								.getCurrentUrl().endsWith(page)) {
							rtnHandle = winHandled;
							break;
						}
					}
				}
			}
			waitForTime(2000);
		} catch (Exception ex) {
		//	log.severe("Exception In the method handlePopUpWindow due to  "
		//			+ ex.getMessage());
			Assert.assertTrue(
					false,
					"Exception In the method handlePopUpWindow due to  "
							+ ex.getMessage());
		}
		String[] rtn_WinHandles = { parentWindow, rtnHandle };
		return rtn_WinHandles;
	}

	*//**
	 * Method Name : switchToParentWindow Purpose: Method for
	 * switchToParentWindow
	 * 
	 * @param: mDriver,index of Array
	 * @return None
	 *//*
	public  void switchToParentWindow(WebDriver driver, String[] index) {
		driver.switchTo().window(index[0]);
	}

	*//**
	 * Method Name : closeChildWindow Purpose: Method for closeChildWindow
	 * 
	 * @param: mDriver,index of Array
	 * @return None
	 *//*
	public  void closeChildWindow(WebDriver driver, String[] index) {
		driver.switchTo().window(index[1]).close();
	}

	*//**
	 * Method Name : isPopupWindowExists Purpose: Method for isPopupWindowExists
	 * 
	 * @param: mDriver
	 * @return None
	 *//*

	public  boolean isPopupWindowExists(WebDriver driver) {
		if (driver.getWindowHandles().size() > 1)
			return true;
		else
			return false;
	}

	*//**
	 * Method Name : typeinEditbox Purpose: Method for typeinEditbox
	 * 
	 * @param: mDriver,identifyBy,identifyBy,locator,valuetoType
	 * @return None
	 *//*
	public  void typeinEditbox(WebDriver driver, String identifyBy,
			String locator, String valuetoType) {
		try {
		    
			System.out.println("gerneric DRIVER"+driver+valuetoType+identifyBy+locator);
			web_Element = isWebElementExists(driver, identifyBy, locator);
			web_Element.clear();
			waitForTime(500);
			web_Element.sendKeys(valuetoType);
		} catch (Exception e) {
		//	log.severe(" MethodName: typeinEditbox :: Exception occured for locator = "
				//	+ locator + "exception = " + e.getMessage() + "");
			Assert.assertTrue(false,
					" MethodName: typeinEditbox :: Exception occured for locator = "
							+ locator + " exception = " + e.getMessage());
		}

	}

	*//**
	 * Method Name : click Purpose: Method for click
	 * 
	 * @param: mDriver,identifyBy,identifyBy,locator,valuetoType
	 * @return None
	 *//*
	public  void click( String identifyBy,
			String locator) {
		try {
			System.out.println(locator+driver);
			web_Element = isWebElementExists(driver, identifyBy, locator);
			web_Element.click();
			
		} catch (Exception e) {
			pressEnterkey(driver, identifyBy, locator);
			//log.severe("MethodName: click :: Exception occured for locator = "+ locator + "exception = " + e.getMessage() + "");
			//Assert.assertTrue(false,"MethodName: click : Exception occured for locator = "	+ locator + "  exception = " + e.getMessage());
		}
	}
	public  void click(WebDriver driver, String identifyBy,
			String locator) {
		try {
			System.out.println(locator+driver);
			web_Element = isWebElementExists(driver, identifyBy, locator);
			web_Element.click();
			
		} catch (Exception e) {
			pressEnterkey(driver, identifyBy, locator);
			//log.severe("MethodName: click :: Exception occured for locator = "+ locator + "exception = " + e.getMessage() + "");
			//Assert.assertTrue(false,"MethodName: click : Exception occured for locator = "	+ locator + "  exception = " + e.getMessage());
		}
	}

	*//**
	 * Method Name : getValue Purpose: Method for getValue
	 * 
	 * @param: mDriver,identifyBy,identifyBy,locator,valuetoType
	 * @return None
	 *//*

	public  String getValue(WebDriver mDriver, String identifyBy,String locator, String valuetoType) {
		String value = "";
		try {
			web_Element = isWebElementExists(mDriver, identifyBy, locator);
			value = web_Element.getAttribute(valuetoType);
		} catch (Exception e) {
		//	log.severe("MethodName: getValue :: Exception occured for locator = "
		//			+ locator + "exception = " + e.getMessage() + "");
			Assert.assertTrue(false,
					"MethodName: getValue :: Exception occured for locator = "
							+ locator + "exception = " + e.getMessage());
		}
		return value;
	}

	*//**
	 * Method Name : select_RadioBtn Purpose: Method for select_RadioBtn
	 * 
	 * @param: mDriver,identifyBy,locator
	 * @return None
	 *//*
	public  void select_RadioBtn(WebDriver mDriver, String identifyBy,String locator) {
		try {
			web_Element = isWebElementExists(mDriver, identifyBy, locator);
			if (!web_Element.isSelected()) {
				web_Element.click();
			} 
		} catch (Exception e) {
		//	log.severe("Exception in the method select_RadioBtn for the element "+ locator + " due to  " + e.getMessage());
			Assert.assertTrue(false,"Exception in the method select_RadioBtn for the element "+ locator + " due to  " + e.getMessage());
		}
	}
	*//**
	 * Method Name : checkBoxBtn Purpose: Method for select_RadioBtn
	 * @param: mDriver,identifyBy,locator
	 * @return None
	 *//*
	public  void clickOncheckBoxBtnByJsExecutor(WebDriver mDriver, String identifyBy,String locator){
		try {
			web_Element = isWebElementExists(mDriver, identifyBy, locator);
			if (!web_Element.isSelected()) {
				jsExecutor(mDriver,ConfigPathFile.ID.getConstantValue(),web_Element);
			} 
		} catch (Exception e) {
		//	log.severe("Exception in the method select_RadioBtn for the element "+ locator + " due to  " + e.getMessage());
			Assert.assertTrue(false,"Exception in the method select_RadioBtn for the element "+ locator + " due to  " + e.getMessage());
		}
	}

	*//**
	 * Method Name : select Purpose: Method for select
	 * 
	 * @param: mDriver,identifyBy,locator,valuetoSelect
	 * @return None
	 *//*
	public  void select(WebDriver mDriver, String identifyBy,String locator, String operation, int index) {
		try {
			web_Element = isWebElementExists(mDriver, identifyBy, locator);
			Select select = new Select(web_Element);
			List<WebElement> l = select.getOptions();
			System.out.println("List Size: "+l.size());
			if (operation.equalsIgnoreCase(ConfigPathFile.INDEX.getConstantValue())) {
				select.selectByIndex(index);
			}else if (operation.equalsIgnoreCase(ConfigPathFile.NAME.getConstantValue())) {
				select.selectByValue("Add New...");
			}

		} catch (Exception e) {
		//	log.severe("Exception in the method select for the element "+ locator + " due to  " + e.getMessage());
			Assert.assertTrue(false,"Exception in the method select for the element " + locator+ " due to  " + e.getMessage());
		}
	}

	*//**
	 * Method Name : selectDropDownValue Purpose: Method for selectDropDownValue
	 * 
	 * @param: mDriver,identifyBy,locator
	 * @return None
	 *//*

	public  void selectDropDownValue(WebDriver mDriver,String identifyBy, String locator, String text) {
		boolean isSelected=false;
		
		List<WebElement> options = null;
		String value = "";

		try {
			web_Element = isWebElementExists(mDriver, identifyBy, locator);
			System.out.println("DRP WE"+web_Element);
			if (identifyBy.equalsIgnoreCase(ConfigPathFile.XPATH.getConstantValue())) {
				options = web_Element.findElements(By.xpath(locator));
			} else if (identifyBy.equalsIgnoreCase(ConfigPathFile.TAGNAME.getConstantValue())) {
				options = web_Element.findElements(By.tagName(locator));
			} else if (identifyBy.equalsIgnoreCase(ConfigPathFile.ID.getConstantValue())) {
				options = web_Element.findElements(By.tagName(ConfigPathFile.OPTION.getConstantValue()));
			} else if (identifyBy.equalsIgnoreCase(ConfigPathFile.CSS.getConstantValue())) {
				options = web_Element.findElements(By.className(locator));
			}
			//Select mySelect= new Select(web_Element);
		
			waitForTime(2000);
			System.out.println("TOTAL DP:"+options.size());
			for (WebElement option : options) {  
				value = option.getText().toString();
				text=text.toString();
				System.out.println(value+"Actual:DRP dwn method:EXP:"+text);
				System.out.println(value.length()+"Acuta:LENG:EXP"+text.length());
				if (text.equalsIgnoreCase(value)) { System.out.println("br CLICK");
					option.click(); System.out.println("AFT drp CLIK");
					isSelected=true;
					break;
				}

			}

			if(!isSelected==true){
			//	log.severe("Test is failed due to given value: "+text+ " is not available in the drop down list");
				takeScreenshot(mDriver, "selectDropDownValue");
				Assert.assertTrue(false,"Test is failed due to given value: "+text+ " is not available in the drop down list");
			}

		} catch (Exception e) {
		//	log.severe("Exception in the method selectDropDownValue for the element "+ locator + " due to  " + e.getMessage());
			//Assert.assertTrue(false,"Exception in the method selectDropDownValue for the element "+ locator + " due to  " + e.getMessage());
		}
	}
	*//**
	 * Method Name : selectDrpValuesByListNumber
	 * Purpose: Method for selectDropDownValue by provided number
	 * @param: mDriver,identifyBy,locator
	 * @return None
	 *//*
	public  void selectDrpValuesByListNumber(WebDriver mDriver,String identifyBy, String locator, int expInt) {
		boolean isSelected=false;
		List<WebElement> options = null;
		try {
			web_Element = isWebElementExists(mDriver, identifyBy, locator);
			if (identifyBy.equalsIgnoreCase(ConfigPathFile.XPATH.getConstantValue())) {
				options = web_Element.findElements(By.xpath(locator));
			} else if (identifyBy.equalsIgnoreCase(ConfigPathFile.TAGNAME.getConstantValue())) {
				options = web_Element.findElements(By.tagName(locator));
			} else if (identifyBy.equalsIgnoreCase(ConfigPathFile.ID.getConstantValue())) {
				options = web_Element.findElements(By.tagName(ConfigPathFile.OPTION.getConstantValue()));
			} else if (identifyBy.equalsIgnoreCase(ConfigPathFile.CSS.getConstantValue())) {
				options = web_Element.findElements(By.className(locator));
			}
			int value =0;
			for (WebElement option : options) {
				value++;
				if (value==expInt) {
					option.click();
					isSelected=true;
					break;
				}
			}
			if(!isSelected==true){
			//	log.severe("Test is failed due to given number is not present in the drop down list: "+expInt+ " is not available in the drop down list");
				takeScreenshot(mDriver, "selectDrpValuesByListNumber");
				Assert.assertTrue(false,"Test is failed due to given number is not present in the drop down list:: "+expInt+ " is not available in the drop down list");
			}
		} catch (Exception e) {
		//	log.severe("Exception in the method selectDrpValuesByListNumber for the element "+ locator + " due to  " + e.getMessage());
			Assert.assertTrue(false,"Exception in the method selectDrpValuesByListNumber for the element "+ locator + " due to  " + e.getMessage());
		}
	}

	public  void SPselectDropDownValue(WebDriver mmdriver, String locator, String text) {
		boolean isSelected=false;
		List<WebElement> options = null;
		String value = "";
		System.out.println("TEX"+text);
		String Dpmenu="//*[@id='"+locator+"']";
		//*[contains(@id,'_chosen')][contains(@class,'active')]//ul//li[2]
		String sellocator="//*[@id='"+locator+"']/..//select";
		String Optlocator="//*[@id='"+locator+"']/..//option";
		String liloctoar="//*[@id='"+locator+"']//ul//li";
		//String liloctoar="//*[@id='"+locator+"'][contains(@class,'active')]//ul//li";
		String oliloctoar="//*[@id='"+locator+"']/..//ul//li";
		waitForTime(2000);
		try {
		//	click(mmdriver, ConfigPathFile.XPATH.getConstantValue(),Dpmenu);
			waitForTime(2000);
			options = mmdriver.findElements(By.xpath(liloctoar));
			System.out.println("LI"+options.size());
			List<WebElement> optoptions = mmdriver.findElements(By.xpath(Optlocator));
			System.out.println("OP"+optoptions.size());
			List<WebElement> oli =mmdriver.findElements(By.xpath(Optlocator));
			System.out.println("Oli"+oli.size());
		//	System.out.println(mDriver.findElement(By.xpath(oliloctoar)).isDisplayed());
			if(mmdriver.findElements(By.xpath(Optlocator)).size()==0)
			{
				oli = mmdriver.findElements(By.xpath(oliloctoar));
			}
			System.out.println(optoptions.size());
			System.out.println(locator+"TOT:"+oli.size()+":AL DP:"+options.size());
			int size=options.size();
			if(size==0)
				{
					size=oli.size();
					System.out.println("NW"+size);
				}
			for(int i=0;i<size;i++)
			{  
				if(i!=0){
			//	click(mmdriver, ConfigPathFile.XPATH.getConstantValue(),Dpmenu);
				waitForTime(2000);
				}
				int j=i+1;
				String slocator=Optlocator+"["+j+"]";
				String lisloctoar=liloctoar+"["+j+"]";
				String Dp=mmdriver.findElement(By.xpath(slocator)).getAttribute("innerHTML");
				System.out.println(Dp);
				
				if(Dp.equalsIgnoreCase(text))
				{

					System.out.println("MATCHED"+lisloctoar);
				
				//	new Select(driver.findElement(By.id("gender"))).selectByVisibleText("Germany");
					System.out.println(j+"B$"+i);
					//se.selectByIndex(j);
					mmdriver.switchTo().defaultContent();
					waitForTime(2000);

					System.out.println(mmdriver+lisloctoar+mmdriver.getTitle()+"WIN");
				//s	System.out.println(mDriver.findElement(By.xpath(lisloctoar)).getTagName());
					mmdriver.findElement(By.xpath(lisloctoar)).click();
					System.out.println("AF");
					//web_Element.findElement(By.xpath(slocator)).click();
					System.out.println("CLIECKered");
					waitForTime(2000);
					isSelected=true;
					break;
				}
					String Dp=options.get(i).getText().toString();
				String slocator=null;
				if(Dp.length()<=0 || options.get(i).isDisplayed()==false)
				{ 
					if(i!=0)
						{
						click(driver, ConfigPathFile.XPATH.getConstantValue(),Dpmenu);
						waitForTime(2000);
						}
					int j=i+1;
					slocator=locator+"["+j+"]";
					System.out.println("IN"+slocator);
					
					Dp=web_Element.findElement(By.xpath(slocator)).getAttribute("innerHTML");
					System.out.println(Dp);
				}
				if((Dp.equalsIgnoreCase(text)) && (web_Element.findElement(By.xpath(slocator)).isDisplayed()))
				{
					System.out.println("MATCHED");
					web_Element.findElement(By.xpath(slocator)).click();
					isSelected=true;
					break;
				}
				System.out.println("APP VALUE:"+Dp);
				System.out.println("Expected VALUE:"+text);
				if(Dp.equalsIgnoreCase(text))
				{
					System.out.println("0 by options");
					options.get(i).click();
					isSelected=true;
					break;
				}
						System.out.println(options.get(i).getText());
				
			}
			for (WebElement option : options) {  
				value = option.getText().toString();
				System.out.println("OP"+option.getText());
				System.out.println("OP"+option.getAttribute("value"));
				text=text.toString();
				System.out.println(value+"Actual:DRP dwn method:EXP:"+text);
				
				if (text.equalsIgnoreCase(value)) {
					option.click();
					isSelected=true;
					break;
				}

			}

			if(!isSelected==true){
			//	log.severe("Test is failed due to given value: "+text+ " is not available in the drop down list");
				takeScreenshot(mmdriver, "selectDropDownValue");
				Assert.assertTrue(false,"Test is failed due to given value: "+text+ " is not available in the drop down list");
			}

		} catch (Exception e) {
		//	log.severe("Exception in the method selectDropDownValue for the element "+ locator + " due to  " + e.getMessage());
			Assert.assertTrue(false,"Exception in the method selectDropDownValue for the element "+ locator + " due to  " + e.getMessage());
		}
	}

	

	public  void SPDselectDropDownValue(WebDriver mDriver,String Frame, String locator, String text) {
		boolean isSelected=false;
		String Dpmenu="//*[@id='"+locator+"']//a";
		System.out.println(Dpmenu+"to selet:"+text);
	//	click(mDriver, ConfigPathFile.XPATH.getConstantValue(),Dpmenu);
		waitForTime(2000);
		
	//	mDriver.switchTo().defaultContent();
		waitForTime(3000);
		System.out.println(mDriver.getTitle());
		String liloctoar="//*[@id='"+locator+"']//ul//li";
		List<WebElement> data = mDriver.findElements(By.xpath(liloctoar));
		System.out.println(data.size()+liloctoar);
		try { String dys=null;
		for(int s=0;s<data.size();s++)
		{
			String es=data.get(s).getText().toString();
			System.out.println("!"+es);
			es=data.get(s).getAttribute("innerHTML");
			System.out.println("@"+es);
			if(es.length()==text.length())
			{
				System.out.println("Length matched");
			}
			if(es.equalsIgnoreCase(text))
			{
				int sp=s+1;
				 dys=liloctoar+"["+sp+"]";
				System.out.println(dys+"MATCHEd"+data.get(s).getAttribute("innerHTML"));
				break;
			//	data.get(s).click();
				System.out.println(mDriver.findElement(By.xpath(dys)).getTagName());
				System.out.println(mDriver.findElement(By.xpath(dys)).isDisplayed());
				mDriver.findElement(By.xpath(dys)).click();
				
				System.out.println("CLIECKered");
				waitForTime(2000);
				isSelected=true;
				break;
			}
		}
		
		waitForTime(2000);
		System.out.println(mDriver.getTitle());
	//	click(mDriver, ConfigPathFile.XPATH.getConstantValue(),Dpmenu);
		System.out.println("SELECTED THE Drop down Menu");
		waitForTime(3000);
		switchToFrameBy(mDriver, Frame,ConfigPathFile.IN.getConstantValue(), ConfigPathFile.XPATH.getConstantValue());
		waitForTime(3000);
		System.out.println("Switched to the frame:"+Frame);
		mDriver.findElement(By.xpath(dys)).click();
		waitForTime(2000);
		isSelected=true;
		
		
		
		List<WebElement> options = null;
		String value = "";
		System.out.println("TEX"+text);
		
		//*[contains(@id,'_chosen')][contains(@class,'active')]//ul//li[2]
		String sellocator="//*[@id='"+locator+"']/..//select";
		String Optlocator="//*[@id='"+locator+"']/..//option";
		
		String oliloctoar="//*[@id='"+locator+"']/..//ul//li";
		waitForTime(2000);
		try {
			options = mDriver.findElements(By.xpath(liloctoar));
			System.out.println("LI"+options.size());
			List<WebElement> optoptions = mDriver.findElements(By.xpath(Optlocator));
			System.out.println("OP"+optoptions.size());
			List<WebElement> oli =mDriver.findElements(By.xpath(Optlocator));
			System.out.println("Oli"+oli.size());
		//	System.out.println(mDriver.findElement(By.xpath(oliloctoar)).isDisplayed());
			if(mDriver.findElements(By.xpath(Optlocator)).size()==0)
			{
				oli = mDriver.findElements(By.xpath(oliloctoar));
			}
			System.out.println(optoptions.size());
			System.out.println(locator+"TOT:"+oli.size()+":AL DP:"+options.size());
			int size=options.size();
			if(size==0)
				{
					size=oli.size();
					System.out.println("NW"+size);
				}
			for(int i=0;i<size;i++)
			{  
				if(i!=0){
				click(driver, ConfigPathFile.XPATH.getConstantValue(),Dpmenu);
				waitForTime(2000);
				}
				int j=i+1;
				String slocator=Optlocator+"["+j+"]";
				String lisloctoar=liloctoar+"["+j+"]";
				String Dp=mDriver.findElement(By.xpath(slocator)).getAttribute("innerHTML");
				System.out.println(Dp);
				
				if(Dp.equalsIgnoreCase(text))
				{

					System.out.println("MATCHED"+lisloctoar);
				
				//	new Select(driver.findElement(By.id("gender"))).selectByVisibleText("Germany");
					System.out.println(j+"B$"+i);
					//se.selectByIndex(j);
		
					System.out.println(lisloctoar+mDriver.getTitle()+"WIN");
				//s	System.out.println(mDriver.findElement(By.xpath(lisloctoar)).getTagName());
					mDriver.findElement(By.xpath(lisloctoar)).click();
					System.out.println("AF");
					//web_Element.findElement(By.xpath(slocator)).click();
					System.out.println("CLIECKered");
					waitForTime(2000);
					isSelected=true;
					break;
				}
					String Dp=options.get(i).getText().toString();
				String slocator=null;
				if(Dp.length()<=0 || options.get(i).isDisplayed()==false)
				{ 
					if(i!=0)
						{
						click(driver, ConfigPathFile.XPATH.getConstantValue(),Dpmenu);
						waitForTime(2000);
						}
					int j=i+1;
					slocator=locator+"["+j+"]";
					System.out.println("IN"+slocator);
					
					Dp=web_Element.findElement(By.xpath(slocator)).getAttribute("innerHTML");
					System.out.println(Dp);
				}
				if((Dp.equalsIgnoreCase(text)) && (web_Element.findElement(By.xpath(slocator)).isDisplayed()))
				{
					System.out.println("MATCHED");
					web_Element.findElement(By.xpath(slocator)).click();
					isSelected=true;
					break;
				}
				System.out.println("APP VALUE:"+Dp);
				System.out.println("Expected VALUE:"+text);
				if(Dp.equalsIgnoreCase(text))
				{
					System.out.println("0 by options");
					options.get(i).click();
					isSelected=true;
					break;
				}
						System.out.println(options.get(i).getText());
				
			}
			for (WebElement option : options) {  
				value = option.getText().toString();
				System.out.println("OP"+option.getText());
				System.out.println("OP"+option.getAttribute("value"));
				text=text.toString();
				System.out.println(value+"Actual:DRP dwn method:EXP:"+text);
				
				if (text.equalsIgnoreCase(value)) {
					option.click();
					isSelected=true;
					break;
				}

			}

			if(!isSelected==true){
			//	log.severe("Test is failed due to given value: "+text+ " is not available in the drop down list");
				takeScreenshot(mDriver, "selectDropDownValue");
				Assert.assertTrue(false,"Test is failed due to given value: "+text+ " is not available in the drop down list");
			}

		} catch (Exception e) {
		//	log.severe("Exception in the method selectDropDownValue for the element "+ locator + " due to  " + e.getMessage());
			Assert.assertTrue(false,"Exception in the method selectDropDownValue for the element "+ locator + " due to  " + e.getMessage());
		}
	}



	public  void SelselectDropDownValue(WebDriver mDriver,String Frame, String locator, String text) {
		boolean isSelected=false;
		String containmenu="//*[contains(@id,'"+locator+"')]";
		System.out.println(containmenu+"to selet:"+text);
		Select dropdown = new Select(mDriver.findElement(By.id(locator)));
		List<WebElement> dp=dropdown.getOptions();
		System.out.println(dp.size());
		waitForTime(2000);
		
		for(int i=0;i<dp.size();i++)
		{
			String actual=dp.get(i).getAttribute("innerHTML").toString();
			System.out.println(actual+"ACTUAL"+text);
			System.out.println(actual.trim().length()+"das"+text.trim().length());
			if(actual.trim().equalsIgnoreCase(text.trim()))
			{ 
				System.out.println("MATCHED");
				mDriver.findElement(By.xpath(containmenu+"/..//div[2]//a")).click();
				waitForTime(4000);
				int s=i+1;
				mDriver.switchTo().defaultContent();
				waitForTime(2000);
				System.out.println("SElected" +containmenu+"/..//ul//li["+s+"]");
				if(	mDriver.findElement(By.xpath(containmenu+"/..//ul//li["+s+"]")).isDisplayed()==true){
				System.out.println("ELEMENT AVAILABLE");	
				}

				WebElement we = mDriver.findElement(By.xpath(containmenu+"/..//ul//li["+s+"]"));
				((JavascriptExecutor) mDriver).executeScript("arguments[0].scrollIntoView();", we);
				System.out.println("SCROLL INTO VIEW");
				waitForTime(2000);
				mDriver.findElement(By.xpath(containmenu+"/..//ul//li["+s+"]")).click();
				waitForTime(2000);
				System.out.println("ELEMENT CLICKED");
				break;
			}
		}
		}

	
	*//**
	 * Method Name : getPropertiesValues Purpose: Method for getPropertiesValues
	 * 
	 * @param: mDriver,identifyB,locator
	 * @return
	 *//*
	public  Properties getPropertiesValues(String filePath) {
		Properties getPropertiesValues = null;
		FileInputStream file = null;
		try {
			getPropertiesValues = new Properties();
			getPropertiesValues.load(new FileInputStream(filePath));
		} catch (Exception e) {
		//	log.severe("Exception in the method getPropertiesValues due to "
			//		+ e.getMessage());
		} finally {
			if (file != null) {
				try {
					file.close();
				} catch (IOException e) {
				//	log.severe("Exception in the method getPropertiesValues due to "
					//		+ e.getMessage());
					Assert.assertTrue(false,
							"Exception in the method getPropertiesValues due to "
									+ e.getMessage());

				}
			}
		}

		return getPropertiesValues;

	}

	*//**
	 * Method Name : isElementDisplayed Purpose: Method for returning boolean
	 * status of web element
	 * 
	 * @param: mDriver,locatorKey,locator
	 * @return
	 *//*
	public  boolean isElementDisplayed(WebDriver mDriver, By locatorKey) {
		//waitForTime(2000);
		try {
			mDriver.findElement(locatorKey);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	*//**
	 * Method Name : isFrameExists Purpose: Method for returning boolean status
	 * of web Frame
	 * 
	 * @param: mDriver,identifyB,locator , operation
	 * @return
	 *//*
	public  boolean rtnAlertBlnState(WebDriver driver) {
		waitForTime(1000);
		try {
			if (driver.switchTo().alert() != null) {
				return true;
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	*//**
	 * Method Name : isAlertPresent Purpose: Method for isAlertPresent
	 * 
	 * @param: driver,pageTitle
	 * @return None
	 *//*
	@SuppressWarnings("unused")
	public  void isAlertPresent(WebDriver driver, String perform) {
		String alertMessage = "";
		Alert alert = null;
		waitForTime(2000);
		if (rtnAlertBlnState(driver) == true) {
			alert = driver.switchTo().alert();
			alertMessage = alert.getText();
			if (perform.equals(ConfigPathFile.ACCEPT.getConstantValue())) {
				alert.accept();
			} else {
				alert.dismiss();
			}
		}

	}

	*//**
	 * Method Name : isFrameExists Purpose: Method for returning boolean status
	 * of web Frame
	 * 
	 * @param: mDriver,identifyB,locator , operation,switchBy
	 * @return
	 *//*
	public  boolean switchToFrameBy(WebDriver mDriver, String locatorKey,String operation, String switchBy) {
		waitForTime(1000);
		try {
			if (operation.equals(ConfigPathFile.IN.getConstantValue())) {
				mDriver.switchTo().defaultContent();
				//waitForTime(2000);
				if (switchBy.equals(ConfigPathFile.INDEX.getConstantValue())) {
					mDriver.switchTo().frame(0);
				} else if (switchBy.equals(ConfigPathFile.XPATH
						.getConstantValue())) {
					mDriver.switchTo().frame(
							mDriver.findElement(By.xpath(locatorKey)));
				} else if (switchBy.equals(ConfigPathFile.ID.getConstantValue())) {
					mDriver.switchTo().frame(
							mDriver.findElement(By.id(locatorKey)));
				} else if (switchBy.equals(ConfigPathFile.NAME
						.getConstantValue())) {
					mDriver.switchTo().frame(
							mDriver.findElement(By.name(locatorKey)));
				}
			} else
				mDriver.switchTo().defaultContent();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	*//**
	 * Method Name : typeinEditbox Purpose: Method for typeinEditbox
	 * @param: mDriver,identifyBy,identifyBy,locator,valuetoType
	 * @return None
	 *//*
	public  boolean isTextFieldEditable(WebDriver mDriver, String identifyBy,String locator, String valuetoType) {

		try {
			web_Element = isWebElementExists(mDriver, identifyBy, locator);
			web_Element.clear();
			web_Element.sendKeys(valuetoType);
			return true;
		} catch (Exception e) {
			return false;		
		}
	}
	*//**
	 * Method Name : takeScreenSort Purpose: Method for capturing screenshot
	 * 
	 * @param: driver,testNo, strFilePath
	 * @return None
	 *//*
	public  void takeScreenshot(WebDriver driver, String testNo) {
		String strScreenshotsFolder = System.getProperty("ScreenshotsFolder");
		try {
			waitForTime(1500);
			DateFormat dateFormat = new SimpleDateFormat("yyyy_dd_MMM_HH_mm_ss");
			Date date = new Date();
			String getCurrentDate = dateFormat.format(date);

			WebDriver augmentedDriver = new Augmenter().augment(driver);
			File scrFile = ((TakesScreenshot) augmentedDriver)
					.getScreenshotAs(OutputType.FILE);
			String path = strScreenshotsFolder + "/" + testNo + "_"
					+ getCurrentDate + ".png";

			FileUtils.copyFile(scrFile, new File(path));
			System.setProperty("org.uncommons.reportng.escape-output", "false");
			FileUtils.copyFile(scrFile, new File(path));
			new File(strScreenshotsFolder).mkdirs();
			Reporter.log("To View Screenshot <a href=\"file:///" + path
					+ "\">Click Here</a>");
		} catch (IOException e) {
		//	log.severe("Exception in the method takeScreenshot: "
			//		+ e.getMessage());
			Assert.assertTrue(
					false,
					" Exception in the method takeScreenshot:  "
							+ e.getMessage());
		}

	}
	*//**
	 * Method Name : Connection
	 * @param: None
	 *@return Connection status
	 *//*
	@SuppressWarnings("unused")
	public  Connection ConnectToDB()
	{
		try
		{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			DBURL = "jdbc:sqlserver://10.10.0.14:1433;databaseName=sim";
			DBUserName = "sim_staging";
			DBPassword = "SIM_AppUser";
			
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			DBURL = "jdbc:sqlserver://192.168.21.17:7462;databaseName=SIM";
			DBUserName = "SIM_AppUser_QA";
			DBPassword = "simqa678!**";
			
			192.168.21.43:49696 

			Database.Username=SIM_AppUser_QA
			Database.Password=simqa678!**
			Database.Name=SIM

			Connection con = DriverManager.getConnection(DBURL, DBUserName, DBPassword);
			Statement stmt = con.createStatement();
			return con;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	*//**
	 * Method Name : ResultSet
	 * @param: con,DBQuery
	 *@return Available ResultSet
	 *//*
	public  ResultSet DBResultSet(Connection con, String DBQuery) 
	{
		try
		{
			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery(DBQuery);           

			if(rs!=null)
			{	
				return rs;
			}
			else
				return null;
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	*//**
	 * Method Name : assertFailure
	 * @param: driver,printExpMsg, printActMsg
	 * @return None
	 * @throws Exception 
	 *//*
	public void assertFailure(WebDriver mDriver,String printExpMsg,String printActMsg){
		//log.severe(printExpMsg+printActMsg);
		//takeScreenshot(mDriver, "assertFailure");
		mDriver.close();
		mDriver.quit();
		//Assert.assertTrue(false,printExpMsg+printActMsg);
	}
	public String getSystemTimeStamp(){
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MMMddhmmssa");
		String getTimeStamp = sdf.format(date);
		return getTimeStamp;
	}

	*//**
	 * Method Name : selectDropDownValue Purpose: Method for selectDropDownValue
	 * 
	 * @param: mDriver,identifyBy,locator
	 * @return None
	 *//*

	public  void countDropDownList(WebDriver mDriver,String identifyBy, String locator, String text) {
		boolean isSelected=false;
		List<WebElement> options = null;
		String value = "";

		try {
			web_Element = isWebElementExists(mDriver, identifyBy, locator);
			if (identifyBy.equalsIgnoreCase(ConfigPathFile.XPATH.getConstantValue())) {
				options = web_Element.findElements(By.xpath(locator));
			} else if (identifyBy.equalsIgnoreCase(ConfigPathFile.TAGNAME.getConstantValue())) {
				options = web_Element.findElements(By.tagName(locator));
			} else if (identifyBy.equalsIgnoreCase(ConfigPathFile.ID.getConstantValue())) {
				options = web_Element.findElements(By.tagName(ConfigPathFile.OPTION.getConstantValue()));
			} else if (identifyBy.equalsIgnoreCase(ConfigPathFile.CSS.getConstantValue())) {
				options = web_Element.findElements(By.className(locator));
			}
			int countSize=0;
			for (WebElement option : options) {
				countSize++;
				value = option.getText().trim().toLowerCase().toString();
				if (text.trim().toLowerCase().toString().equalsIgnoreCase(value)) {
					option.click();
					isSelected=true;
					break;
				}

			}
			System.out.println("countSize : "+countSize);
			if(!isSelected==true){
		//		log.severe("Test is failed due to given value: "+text+ " is not available in the drop down list");
				takeScreenshot(mDriver, "selectDropDownValue");
				Assert.assertTrue(false,"Test is failed due to given value: "+text+ " is not available in the drop down list");
			}

		} catch (Exception e) {
		//	log.severe("Exception in the method selectDropDownValue for the element "+ locator + " due to  " + e.getMessage());
			Assert.assertTrue(false,"Exception in the method selectDropDownValue for the element "+ locator + " due to  " + e.getMessage());
		}
	}
	*//**
	 * Method Name : rtnRegExpValue
	 * Purpose: Method to return matched string value
	 * @param:  String compilerValue, matcherValue
	 * @return: None
	 *//*
	public  String getStrRegExpValue(String compilerValue,String matcherValue){
		String rtnValue="";
		Pattern pattern = Pattern.compile(compilerValue);
		Matcher matcher = pattern.matcher(matcherValue);
		while (matcher.find()){
			rtnValue+=matcher.group();
		}
		return rtnValue;
	}

	*//**
	 * Method Name : getEmail
	 * Purpose: Public method which includes logic related to return the concatenate email with current date
	 * @param: None
	 * @return: None
	 *//*
	public String getEmail(String sEmail){
		String email ="";
		SimpleDateFormat sdfDate = new SimpleDateFormat("MMddHHmmss");
		Date now = new Date();
		String strDate = sdfDate.format(now);
		String [] actualEmail=sEmail.split("@");
		email = actualEmail[0] + strDate + "@" + actualEmail[1];
		return email;
	}

	*//**
	 * Method Name : isFileExist
	 * Purpose: Method to return boolean value
	 * @param:  String filePath
	 * 	 * @return: None
	 *//*
	public  boolean isFileExist(String filePath){
		File f = new File(filePath);
		if(f.exists()){
			Reporter.log("File exists");
			return true;
		}else{
			Reporter.log("File not exists!");
			return true;
		}
	}
	public  void uploadFileBySendKeys(WebDriver mDriver,String identifyBy,String locator,String filePath){
		try {
			web_Element = isWebElementExists(mDriver, identifyBy, locator);
			web_Element.sendKeys(filePath);
		} catch (Exception e) {
		//	log.severe("Exception in the method uploadFileBySendKeys for the element "	+ locator + " due to  " + e.getMessage());
			Assert.assertTrue(false,"Exception in the method uploadFileBySendKeys for the element "+ locator + " due to  " + e.getMessage());
		}

	}

	public  int convertStringToNbr(String strValue){
		Integer rtnInt =0;
		try {
			rtnInt=Integer.valueOf(strValue);
		} catch (Exception e) {
		//	log.severe("Exception in the method convertStringToNbr due to " + e.getMessage());
			Assert.assertTrue(false,"Exception in the method convertStringToNbr due to "+ e.getMessage());
		}
		return rtnInt;
	}

	public void typeinEdit(WebDriver driver2,String typelocator, String locator, String string2) {
		if(typelocator.equalsIgnoreCase("xpath"))
		{ driver2.findElement(By.xpath(locator)).clear();
			driver2.findElement(By.xpath(locator)).sendKeys(string2);	
		} else if(typelocator.equalsIgnoreCase("id")){  driver2.findElement(By.id(locator)).clear();
			driver2.findElement(By.id(locator)).sendKeys(string2);
		} else if(typelocator.equalsIgnoreCase("css")){
			driver2.findElement(By.cssSelector(locator)).clear();
			driver2.findElement(By.cssSelector(locator)).sendKeys(string2);
		}
		System.out.println("SUCCESSFULLY typed");
	}

	public void clicks(WebDriver driver2,String identifyby, String locator) {
		if(identifyby.equalsIgnoreCase("xpath"))
		{ 	System.out.println("BE$"+driver2+locator);
			driver2.findElement(By.xpath(locator)).click();
			System.out.println("AFR");
		} else if(identifyby.equalsIgnoreCase("id")){
			driver2.findElement(By.id(locator)).click();
		} else if(identifyby.equalsIgnoreCase("css")){
			driver2.findElement(By.cssSelector(locator)).click();
			
		}else if(identifyby.equalsIgnoreCase(ConfigPathFile.LINKTEXT.getConstantValue()))
		{
			driver2.findElement(By.linkText(locator)).click();
		}
		System.out.println("SUCCESSFULLY CLICKEd"+identifyby+locator);
		
		
	}
	
	public void click(String objNameStr,WebElement objName)
    {
    
    	try
		{
		objName.click();
		
		Reporter.log("'" + objNameStr+"'" + " is clicked");
		
		}
		catch(Exception e)
		{
		Reporter.log("'" + objNameStr+"'" + " is not clicked");

		}
    	
    }
	
	public void enterText(String objNameStr,WebElement objName, String value)
    {
    
    	
    	try
		{
		objName.clear();
		objName.sendKeys(value);
		Reporter.log("'" + value+"'" + " is entered in " + objNameStr);
		}
		catch(Exception e)
		{
		Reporter.log(objNameStr +" is not displayed");
		
		}
    	
    }
	
	
	

}*/