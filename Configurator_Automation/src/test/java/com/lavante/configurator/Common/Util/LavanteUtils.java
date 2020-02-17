
package com.lavante.configurator.Common.Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.ObjectUtils.Null;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.microsoft.sqlserver.jdbc.SQLServerConnection;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerResultSet;
import com.microsoft.sqlserver.jdbc.SQLServerStatement;

/**
 * @author Piramanayagam.S
 *
 */
public class LavanteUtils {

	public WebDriver driver = null;
	public  Connection con = null;
	public  Statement stmt = null;
	public  ResultSet rs = null;
	public static com.jcraft.jsch.Session session = null;
	
	public static String dir = System.getProperty("TestData")+ File.separator + "data" ;

	public static final String browserVersion = "";
	public static final String browser = "chrome"; // #internet Explorer
													// #chrome #firefox
	public static final String Platform = "Windows";
	public static final String Version = null;

	public static String DBURL = "", DBUserName = "", DBPassword = "";
	public static ResultSet ResSet = null, RetRS = null, Rest = null;


	static {
		dir = System.getProperty("TestData")+ File.separator + "data" ;
		if(System.getProperty("TestData")==null){
			System.setProperty("TestData","StagingTestData");
			dir = System.getProperty("TestData")+ File.separator + "data" ;
		}
		System.out.println(currenttime());
	}
	
	public void waitforPageLoad(WebElement element){
		WebDriverWait wait=new WebDriverWait(driver,15);
		try{
		       wait.until(ExpectedConditions.visibilityOf(element));
		}catch(TimeoutException e){
		       System.out.println("Page is not refreshed in 10 seconds");
		}
	}
	
	public void selectvalueFromDropdown(String exvalue) {
		//switchtoFrame(null);
		if(exvalue.length()>0)
		{ 
			List<WebElement> el=driver.findElements(By.cssSelector("div[class*='drop'] li"));

			for(int i=0;i<el.size();i++)
			{
				String app=el.get(i).getText();
				if(app.equalsIgnoreCase(exvalue))
				{	
					try {
						el.get(i).click();
					}catch(Exception e){
						Reporter.log("Unable to select value");
					}
					break;
				}
			}
			
		}
		
	}
	
	//Selecting from drop down for exceptional scenarios
	public void selectvalueFrmDpdn(String selectedvalue) {
			//switchtoFrame(null);
			
			try{
			if(selectedvalue.length()>0)
			{  
				List<WebElement> allElements=driver.findElements(By.cssSelector("#audit_chosen div[class*='drop'] li"));
				System.out.println(allElements.size());
				
				for(int i=0;i<allElements.size();i++)
				{
					String app=allElements.get(i).getText();
					System.out.println(app+"APP : EXP"+ selectedvalue);
					if(app.equalsIgnoreCase(selectedvalue))
					{
						allElements.get(i).click();
						break;
					}
				}
			}
			}
			catch(Exception e){
			}
			
		}
		
	/**
	 * InitProperties() method contains set of instructions to read the content
	 * of Initproperties file and gives back the Value after reading the
	 * Specified content
	 * 
	 * @author Piramanayagam.S
	 * @throws Null
	 * @Returns String Value
	 * @param String
	 *            toread which is in the Initproperties file
	 * @throws IOException
	 * @throws FileNotFoundException
	 * 
	 */
    public static String InitProperties(String toread) throws FileNotFoundException, IOException {
		String value = "";
		try {
			Properties config = readProperties("initConfig.properties", "config");
			value = config.getProperty(toread);
		} catch (Exception e) {

		}
		return value;
	}
    
	public DesiredCapabilities DesiredCapablity(String browser) {
		DesiredCapabilities caps = new DesiredCapabilities();
		if (browser.equalsIgnoreCase("firefox")) {
			caps = DesiredCapabilities.firefox();
		//	caps.setBrowserName("firefox");
			caps.setCapability("marionette", true);
		 /*	FirefoxOptions options = new FirefoxOptions();
		 	
		    options.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
		    caps.setCapability("moz:firefoxOptions", options);*/
		    
		} else if (browser.equalsIgnoreCase("chrome")) {
			caps = DesiredCapabilities.chrome();
			caps.setBrowserName("chrome");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");
			options.addArguments("--test-type");
			caps.setCapability(ChromeOptions.CAPABILITY, options);
		} else if (browser.equalsIgnoreCase("internet explorer")) {
			caps = DesiredCapabilities.internetExplorer();
			caps.setBrowserName("internet explorer");
			/*caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);*/
			caps.setCapability("ignoreZoomSetting", true);
			caps.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
			caps.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, true);
			caps.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true);
			caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			caps.setCapability(CapabilityType.SUPPORTS_ALERTS, true);
			caps.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, true);
			caps.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, true);
			caps.setCapability(CapabilityType.HAS_NATIVE_EVENTS, false);
			caps.setCapability(CapabilityType.SUPPORTS_APPLICATION_CACHE, false);
		} else {
			System.err.println("Invalid browser! Unable to execute...");

		}
		System.out.println(caps);

		return caps;
	}

	public void launchAppThroughPOM(String Platform, String browser, String Version) throws Exception {
		System.out.println(Platform + browser + Version);
		DesiredCapabilities caps = new DesiredCapabilities();
		if (browser.equalsIgnoreCase("firefox")) {
			caps = DesiredCapabilities.firefox();
			System.setProperty("webdriver.firefox.marionette","C:\\LavanteDrivers\\geckodriver.exe");
	        caps.setCapability("marionette", true);
	       // caps.setBrowserName("firefox");
		} else if (browser.equalsIgnoreCase("chrome")) {
			caps = DesiredCapabilities.chrome();
			caps.setBrowserName("chrome");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");
			options.addArguments("--test-type");
			caps.setCapability(ChromeOptions.CAPABILITY, options);
		} else if (browser.equalsIgnoreCase("internet explorer")) {
			caps = DesiredCapabilities.internetExplorer();
			caps.setBrowserName("internet explorer");
			caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			caps.setCapability("ignoreZoomSetting", true);
			caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			caps.setCapability(CapabilityType.SUPPORTS_ALERTS, true);
			caps.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, true);
			caps.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, true);
			caps.setCapability(CapabilityType.SUPPORTS_APPLICATION_CACHE, false);
			caps.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
			caps.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, true);
			caps.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true);

		} else {
			System.err.println("Invalid browser! Unable to execute...");
		}
		String strRemoteExec = System.getProperty("RemoteExecution");
		if (strRemoteExec != null) {
			if (strRemoteExec.equalsIgnoreCase("true")) {
				
				strRemoteExec = System.getProperty("RemoteExecution");
				String strRemoteURL = System.getProperty("RemoteURL");
				URL remoteAddress = new URL(strRemoteURL + "/wd/hub");
				driver = new RemoteWebDriver(remoteAddress, caps);
				((RemoteWebDriver) driver).setFileDetector(new LocalFileDetector());
			} else {
				if (browser.equalsIgnoreCase("firefox")) {
					System.setProperty("webdriver.gecko.driver", getPresentWorkingDir()  + File.separator + System.getProperty("TestData") + File.separator + "geckodriver.exe");
					System.setProperty("webdriver.firefox.marionette",
							getPresentWorkingDir()  + File.separator + System.getProperty("TestData") + File.separator + "geckodriver.exe");
					driver = new FirefoxDriver(caps);
				} else if (browser.equalsIgnoreCase("chrome")) {
					System.setProperty("webdriver.chrome.driver",
							getPresentWorkingDir()  + File.separator + System.getProperty("TestData") + File.separator + "ChromeDriver.exe");
					driver = new ChromeDriver(caps);
				} else if (browser.equalsIgnoreCase("internet explorer")) {
					System.setProperty("webdriver.ie.driver",
							getPresentWorkingDir()  + File.separator + System.getProperty("TestData") + File.separator + "IEDriverServer.exe");
					driver = new InternetExplorerDriver(caps);
				}
			}
		} else {
			if (browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", getPresentWorkingDir()  + File.separator + System.getProperty("TestData") + File.separator + "geckodriver.exe");
				System.setProperty("webdriver.firefox.marionette",
						getPresentWorkingDir() + File.separator + System.getProperty("TestData") + File.separator + "geckodriver.exe");
				driver = new FirefoxDriver(caps);
			} else if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						getPresentWorkingDir()  + File.separator + System.getProperty("TestData") + File.separator + "ChromeDriver.exe");
				driver = new ChromeDriver(caps);
			} else if (browser.equalsIgnoreCase("internet explorer")) {
				System.setProperty("webdriver.ie.driver",
					getPresentWorkingDir()  + File.separator + System.getProperty("TestData") + File.separator + "IEDriverServer.exe");
				driver = new InternetExplorerDriver(caps);
			}
		}

	}

	public void openAPP() throws FileNotFoundException, IOException {
		//driver.get(InitProperties("APPURL"));
		driver.navigate().to(InitProperties("APPURL"));
		List<WebElement> s = driver.findElements(By.id("overridelink"));
		if (s.size() > 0) {
			driver.navigate().to("javascript:document.getElementById('overridelink').click()");
		}
	//	driver.manage().window().maximize();
		waitForTime(3000);
		classNameDisplay();
	}
	
	private void classNameDisplay() {

		String testName = this.getClass().getName();
		System.out.println("--------------Test Class  :" + testName + ",Started at:" + randomnum()+"--------------------------------------");
		Reporter.log("---------------Test Class  :" + testName + ",Started at:" + randomnum()+"--------------------------------------");
	}
	
	public void quitBrowser() {
		driver.close();
		driver.quit();
	}
	
	public void waitForTime(int i) {
		try {
			Thread.sleep(i);
			System.out.println("Waiting Done for :"+i);
		} catch (Exception e) {

		}
	}

	public void waitForTime(long i) {
		try {
			Thread.sleep(i);
			System.out.println("Waiting Done for :"+i);
		} catch (Exception e) {

		}
	}

	public boolean switchtoFrame(WebElement element) {
		boolean flag = true;
		driver.switchTo().defaultContent();
		if (element != null) {
			fluentwait(element);
			driver.switchTo().frame(element);
			waitForTime(3000);
		}

		waitForTime(3000);
		return flag;
	}

	/**
	 * Contains Dropdown Method <Replica of Select Value from Dropdown>
	 * 
	 * @author Piramanayagam.S
	 * 
	 */
	public String selectContainFrmDpdn(String exvalue) {
		String selectedValue = null;
		switchtoFrame(null);
		if (exvalue.length() > 0) {
			List<WebElement> el = driver.findElements(By.cssSelector("div[class*='active'] div[class*='drop'] li"));
			System.out.println("DP SIZE " + el.size());
			if(el.size()>0){
				
				String app = el.get(0).getText();
				System.out.println("Default Dp Value,"+app+",Expected:"+exvalue);
				//if(!app.equalsIgnoreCase(exvalue))
				{
					for (int i = el.size() - 1; i >= 0; i--) {
						app = el.get(i).getText();
						System.out.println(i+":"+app+":APP,EXP:"+exvalue);
						if (exvalue.equalsIgnoreCase("any")) {
							if (!app.contains("Select")) {
								try {
									click(el.get(i));
								} catch (Exception e) {
									click(driver.findElement(By.cssSelector("div[class*='active'] div[class*='drop'] li:nth-child(" + i + ")")));
								}
								selectedValue = app;
								break;
							}
						}
						if (app.contains(exvalue)) {
							try {
								//Scrollintoview(el.get(i));
								//click(el.get(i));
								el.get(i).click();
								el = driver.findElements(By.cssSelector("div[class*='active'] div[class*='drop'] li"));
							
								int in=0;
								System.out.println("Basic Click,el:"+el.size());
								
								while(el.size()>0 && in<=10){
									//	clickJavaScript(el.get(i));
									Actions action = new Actions(driver).click(el.get(i));
									action.build().perform();
									in++;
									System.out.println("Action Click for DP:"+in+",el:"+el.size());
									el = driver.findElements(By.cssSelector("div[class*='drop'] li"));
								}
								
								if(el.size()>0 && in>=10){
									System.out.println("Click Try javascript for DP:"+in+",el:"+el.size());
									clickJavaScript(el.get(i));
								}
								
								
							} catch (Exception e) {
							//	click(driver.findElement(By.cssSelector("div[class*='drop'] li:nth-child(" + i + ")")));
							}
							selectedValue = exvalue;
							break;
						}
					}
				
				//IF Not Matching the default value available in the dropdown.
				}
			
			
			//For the Size
			}

		}
		return selectedValue;

	}
	
	/**
	 * Most of the Class use this Dropdown Selection Method
	 * 
	 * 
	 * Prioirty: 1 for Direct Equals
	 * Priority: 2 Containsvaluefromdropdwn
	 * Priority 3 :Same Frame drpdown
	 * 
	 * 
	 * @author Piramanayagam.S
	 */
	public String selectvalueFrmDpdnSIM(String exvalue) {
		String selectedValue = null;
		switchtoFrame(null);
		if (exvalue.length() > 0) {
			List<WebElement> el = driver.findElements(By.cssSelector("div[class*='active'] div[class*='drop'] li"));
			System.out.println("DP SIZE " + el.size());
			if(el.size()>0){
				
				String app = el.get(0).getText();
				System.out.println("Default Dp Value,"+app+",Expected:"+exvalue);
				//if(!app.equalsIgnoreCase(exvalue))
				{
					for (int i = el.size() - 1; i >= 0; i--) {
						app = el.get(i).getText();
						System.out.println(i+":"+app+":APP,EXP:"+exvalue);
						if (exvalue.equalsIgnoreCase("any")) {
							if (!app.contains("Select")) {
								try {
									click(el.get(i));
								} catch (Exception e) {
									click(driver.findElement(By.cssSelector("div[class*='active'] div[class*='drop'] li:nth-child(" + i + ")")));
								}
								selectedValue = app;
								break;
							}
						}
						if (app.equalsIgnoreCase(exvalue)) {
							try {
								//Scrollintoview(el.get(i));
								//click(el.get(i));
								el.get(i).click();
								el = driver.findElements(By.cssSelector("div[class*='active'] div[class*='drop'] li"));
							
								int in=0;
								System.out.println("Basic Click,el:"+el.size());
								
								while(el.size()>0 && in<=10){
									//	clickJavaScript(el.get(i));
									Actions action = new Actions(driver).click(el.get(i));
									action.build().perform();
									in++;
									System.out.println("Action Click for DP:"+in+",el:"+el.size());
									el = driver.findElements(By.cssSelector("div[class*='drop'] li"));
								}
								
								if(el.size()>0 && in>=10){
									System.out.println("Click Try javascript for DP:"+in+",el:"+el.size());
									clickJavaScript(el.get(i));
								}
								
								
							} catch (Exception e) {
							//	click(driver.findElement(By.cssSelector("div[class*='drop'] li:nth-child(" + i + ")")));
							}
							selectedValue = exvalue;
							break;
						}
					}
				
				//IF Not Matching the default value available in the dropdown.
				}
			
			
			//For the Size
			}

		}
		return selectedValue;

	}
	
	public String selectFrmDpdn(String exvalue) {
		String selectedValue = null;
		switchtoFrame(null);
		if (exvalue.length() > 0) {
			List<WebElement> el = driver.findElements(By.cssSelector("div[class*='drop'] li"));
			System.out.println("DP SIZE " + el.size());

			for (int i = el.size() - 1; i >= 0; i--) {
				String app = el.get(i).getText();
				System.out.println(app + "APP : EXP " + exvalue);
				if (exvalue.equalsIgnoreCase("any")) {
					if (!app.contains("Select")) {
						try {
							click(el.get(i));
						} catch (Exception e) {
							click(driver.findElement(By.cssSelector("div[class*='drop'] li:nth-child(" + i + ")")));
						}
						selectedValue = app;
						break;
					}
				}
				if (app.equalsIgnoreCase(exvalue)) {
					try {
						int in=0;
						while(el.size()>0 && in<=30){
							//	clickJavaScript(el.get(i));
							Actions action = new Actions(driver).click(el.get(i));
							action.build().perform();
							in++;
							System.out.println("Try for DP:"+in+",el:"+el.size());
							el = driver.findElements(By.cssSelector("div[class*='drop'] li"));
						}
						if(el.size()>0 && in>=30){
							System.out.println("Click Try javascript for DP:"+in+",el:"+el.size());
							clickJavaScript(el.get(i));
						}
					} catch (Exception e) {
						//click(driver.findElement(By.cssSelector("div[class*='drop'] li:nth-child(" + i + ")")));
					}
					selectedValue = exvalue;
					break;
				}
			}

		}
		return selectedValue;

	}
	
	public String SameFrameselectvalueFrmDpdn(String exvalue) {
		String selectedValue = null;
		if (exvalue.length() > 0) {
			List<WebElement> el = driver.findElements(By.cssSelector("div[class*='drop'] li"));
			System.out.println("DP SIZE " + el.size());

			for (int i = el.size() - 1; i >= 0; i--) {
				String app = el.get(i).getText();
				System.out.println(app + "APP : EXP " + exvalue);
				if (exvalue.equalsIgnoreCase("any")) {
					if (!app.contains("Select")) {
						try {
							click(el.get(i));
						} catch (Exception e) {
							click(driver.findElement(By.cssSelector("div[class*='drop'] li:nth-child(" + i + ")")));
						}
						selectedValue = app;
						break;
					}
				}
				if (app.equalsIgnoreCase(exvalue)) {
					try {
						while(el.size()>0){
							//	clickJavaScript(el.get(i));
							Actions action = new Actions(driver).click(el.get(i));
							action.build().perform();

							el = driver.findElements(By.cssSelector("div[class*='drop'] li"));
						}
					} catch (Exception e) {
					//	click(driver.findElement(By.cssSelector("div[class*='drop'] li:nth-child(" + i + ")")));
					}
					selectedValue = exvalue;
					break;
				}
			}

		}
		return selectedValue;

	}

	public boolean getValueFrmDpdn(String exvalue) {
		boolean flag = false;
		switchtoFrame(null);
		if (exvalue.length() > 0) {
			List<WebElement> el = driver.findElements(By.cssSelector("div[class*='drop'] li"));
			System.out.println("DP SIZE" + el.size());

			for (int i = 0; i < el.size(); i++) {
				String app = el.get(i).getText();
				System.out.println(app + "APP : EXP" + exvalue);
				if (app.equalsIgnoreCase(exvalue)) {
					flag = true;
					break;
				}
			}

		}
		return flag;

	}
	
	public void click(WebElement e) {
		try {
			Scrollintoview(e);
			clickJavaScript(e);
		} catch (Exception ex) {
			Scrollintoview(e);
			e.click();
		}
	}
	
	public void clickJavaScript(WebElement e) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		try {
			executor.executeScript("arguments[0].click();", e);
		} catch (Exception ex) {
			Scrollintoview(e);
			executor.executeScript("arguments[0].click();", e);
		}

	}

	public int typeinEdit(String totype, WebElement e) {
		int amnt = 0;
		if (totype.length() > 0) {
			if (totype.equalsIgnoreCase("ANY")) {
			//	e.clear();
				amnt = randomnum(9999);
				e.sendKeys("" + amnt);
			} else {
			//	e.clear();
				System.out.println(e + ":" + totype);
				e.sendKeys(totype);
			}
		} else {
			//e.clear();
		}
		return amnt;
	}

	public String typeString(String totype, WebElement e) {
		String str = "";
		if (totype.length() > 0) {
			if (totype.equalsIgnoreCase("ANY")) {
			//	e.clear();
				str = "AutoSP" + randomnum();
				e.sendKeys("" + str);
			} else {
				//e.clear();
				System.out.println(e + ":" + totype);
				e.sendKeys(totype);
				str = totype;
			}
		} else {
			//e.clear();
		}

		return str;
	}

	public void selectDate(String toselect, WebElement datelocator, WebElement deLtodaydate) {
		if (toselect.equalsIgnoreCase("ANY")) {
			datelocator.click();
			switchtoFrame(null);
			click(deLtodaydate);
		} else {

		}

	}

	public void uploadFile(String toselect, WebElement upload) throws IOException {
		if (toselect.equalsIgnoreCase("ANY")) {
			String file = getPresentWorkingDir() + File.separator + dir + File.separator + "a.png";
			System.out.println("A" + file);
			upload.sendKeys(file);
		} else {
			String file = getPresentWorkingDir() + File.separator + dir + File.separator + toselect;
			System.out.println("A" + file);
			upload.sendKeys(file);
		}
	}

	public void selectChckbx(WebElement element) {

		click(element);
	}

	public void selectChkBox(WebElement element, String flag) {
		if ("yes".equalsIgnoreCase(flag)) {
			if (!element.isSelected())
				clickJavaScript(element);
		} else if ("no".equalsIgnoreCase(flag)) {
			if (element.isSelected())
				clickJavaScript(element);
		}
		// test
	}

	public void UnselectChkBox(WebElement element, String flag) {
		
		if ("UnSelect".equalsIgnoreCase(flag)) {
			if (element.isSelected()) {
					clickJavaScript(element);
				}
		}
		if ("Select".equalsIgnoreCase(flag)) {
			if (!element.isSelected()) {
					clickJavaScript(element);
				}
		}
	}
	
	public boolean fluentwait(  WebElement elements) {
		int timeoutSeconds = 60;
		 boolean flagreturn=false;
		try {
			/*
			 * FluentWait<WebElement> wait = new FluentWait<WebElement>(element)
					.withTimeout(timeoutSeconds, TimeUnit.SECONDS).pollingEvery(100, TimeUnit.MILLISECONDS)
					.ignoring(org.openqa.selenium.StaleElementReferenceException.class)
					.ignoring(org.openqa.selenium.NoSuchElementException.class)
					.ignoring(org.openqa.selenium.InvalidSelectorException.class)
					.ignoring(org.openqa.selenium.WebDriverException.class)
					.ignoring(org.openqa.selenium.ElementNotVisibleException.class)
					.ignoring(InterruptedException.class);
			wait.until(new Predicate<WebElement>() {
				public boolean apply(WebElement element) {
					System.out.println("FW:" + element.isDisplayed() + ":" + element);
					return element.isDisplayed();
				}
			});
			*/
			
			final WebElement  finalElement=elements;
			Function<WebDriver, WebElement> function = new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver drivers) {
					drivers=driver;
					WebElement element = finalElement;
					if (element != null) {
						boolean flag=element.isDisplayed();
					//	Reporter.log(currenttime()+"FW:" + flag + ":" + element);
						System.out.println(currenttime()+"FW:" + flag + ":" + element);
						if(flag==true){
							element=finalElement;
							
						}else{
							element=null;
						}
					}
					
					return element;
				}
			};
		
			FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
			wait.withTimeout(timeoutSeconds, TimeUnit.SECONDS).pollingEvery(100, TimeUnit.MILLISECONDS);
			wait.ignoring(NoSuchElementException.class);
			wait.ignoring(org.openqa.selenium.StaleElementReferenceException.class);
			wait.ignoring(org.openqa.selenium.NoSuchElementException.class);
			wait.ignoring(org.openqa.selenium.InvalidSelectorException.class);
			wait.ignoring(org.openqa.selenium.WebDriverException.class);
			wait.ignoring(org.openqa.selenium.ElementNotVisibleException.class);
			wait.ignoring(InterruptedException.class);
			wait.ignoring(TimeoutException.class);
			wait.until(function);
			flagreturn=true;
			
		} catch (Exception e) {
			return false;
		}
		return flagreturn;
	}

	public void selectbyvisibiletxt(String toselect, WebElement element) {
		try {
			Select s = new Select(element);
			s.selectByVisibleText(toselect);

		} catch (Exception e) {
			selectmultiselect(toselect,element);
			//Assert.assertFalse(true, "Failed in Select By Visible Text for the element: " + e.toString());
		}
	}

	public void selectmultiselect(String toselect, WebElement element) {
		try {
			Select s = new Select(element);
			s.selectByValue(toselect);
		} catch (Exception e) {
			List<WebElement> options =   driver.findElements(By.xpath(".//option[normalize-space(.) = '"+toselect+"']"));
			boolean matched = false;
			for (WebElement option : options) {
				 click(option);
	    	}
		}
	}

	public void takeScreenshot1() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile,
				new File(getPresentWorkingDir() + File.separator + dir + File.separator + randomnum() + ".png"));
	}

	public void Scrollintoview(WebElement e) {
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", e);
			waitForTime(3000);
		} catch (Exception ex) {
			Assert.assertFalse(true, "Failed in Scroll to View: " + e.toString());
		}
	}

	public void refreshPage() {
		driver.navigate().refresh();

	}

	/**
	 * Method Name : explicitWaitForAlert Purpose: Method for
	 * explicitWaitForAlert
	 * 
	 * @param: driver,
	 *             alertStatus
	 * @return None
	 */
	public String explicitWaitForAlert(WebDriver driver, String alertStatus) {
		String alertMessage = "";
		Alert alert = null;
		try {
			alert = driver.switchTo().alert();
			alertMessage = alert.getText();
			if (alertStatus.equalsIgnoreCase("accept")) {
				alert.accept();
			} else
				alert.dismiss();
		} catch (Exception e) {
			// log.severe("Exception In the method explecitWaitForAlert due to "
			// + e.getMessage());
		}
		return alertMessage;
	}

	/**
	 * Method Name : getValue Purpose: Method for getValue
	 * 
	 * @param: mDriver,identifyBy,identifyBy,locator,valuetoType
	 * @return None
	 */
	public String getValue(WebElement web_Element, String attributeName) {
		String value = "";
		try {
			value = web_Element.getAttribute(attributeName);
		} catch (Exception e) {
			// log.severe("MethodName: getValue :: Exception occured for locator
			// = "
			// + locator + "exception = " + e.getMessage() + "");
			Assert.assertTrue(false, "MethodName: getValue :: Exception occured for locator ");
		}
		return value;
	}

	/**
	 * Method Name : selectDropDownValue Purpose: Method for selectDropDownValue
	 * 
	 * @param: mDriver,identifyBy,locator
	 * @return None
	 */
	public void selectDropDownValue(WebElement elemen, String text) {
		boolean isSelected = false;

		List<WebElement> options = null;
		String value = "";

		try {

			options = elemen.findElements(By.xpath(".//option"));

			waitForTime(2000);
			for (WebElement option : options) {
				value = option.getText().toString();
				text = text.toString();
				if (text.equalsIgnoreCase(value)) {
					option.click();
					isSelected = true;
					break;
				}
			}

			if (!isSelected == true) {
				// log.severe("Test is failed due to given value: "+text+ " is
				// not available in the drop down list");
				takeScreenshot(driver, "selectDropDownValue");
				Assert.assertTrue(false,
						"Test is failed due to given value: " + text + " is not available in the drop down list");
			}

		} catch (Exception e) {
			// log.severe("Exception in the method selectDropDownValue for the
			// element "+ locator + " due to " + e.getMessage());
			// Assert.assertTrue(false,"Exception in the method
			// selectDropDownValue for the element "+ locator + " due to " +
			// e.getMessage());
		}
	}

	public boolean isElementDisplayed(WebElement e) {
		// waitForTime(2000);
		boolean flag = false;
		try {
			e.isDisplayed();
			flag = true;
		} catch (NoSuchElementException ex) {
			flag = false;
		}
		return flag;
	}

	public boolean isElementPresent(List<WebElement> e) {
		// waitForTime(2000);
		boolean flag = false;
		try {
			if (e.size() > 0) {
				flag = true;
			}
		} catch (NoSuchElementException ex) {
			flag = false;
		}
		return flag;
	}

	/**
	 * Method Name : isFrameExists Purpose: Method for returning boolean status
	 * of web Frame
	 * 
	 * @param: mDriver,identifyB,locator
	 *             , operation
	 * @return
	 */
	public boolean rtnAlertBlnState(WebDriver driver) {
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

	public boolean isTextFieldEditable(WebElement locator, String valuetoType) {

		try {
			locator.clear();
			locator.sendKeys(valuetoType);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Method Name : takeScreenSort Purpose: Method for capturing screenshot
	 * 
	 * @param: driver,testNo,
	 *             strFilePath
	 * @return None
	 */
	public void takeScreenshot(WebDriver driver, String testNo) {
		String strScreenshotsFolder = System.getProperty("ScreenshotsFolder");
		try {
			waitForTime(1500);
			DateFormat dateFormat = new SimpleDateFormat("yyyy_dd_MMM_HH_mm_ss");
			Date date = new Date();
			String getCurrentDate = dateFormat.format(date);

			WebDriver augmentedDriver = new Augmenter().augment(driver);
			File scrFile = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.FILE);
			String path = strScreenshotsFolder + "/" + testNo + "_" + getCurrentDate + ".png";

			FileUtils.copyFile(scrFile, new File(path));
			System.setProperty("org.uncommons.reportng.escape-output", "false");
			FileUtils.copyFile(scrFile, new File(path));
			new File(strScreenshotsFolder).mkdirs();
			Reporter.log("To View Screenshot <a href=\"file:///" + path + "\">Click Here</a>");
		} catch (IOException e) {
			// log.severe("Exception in the method takeScreenshot: "
			// + e.getMessage());
			Assert.assertTrue(false, " Exception in the method takeScreenshot:  " + e.getMessage());
		}

	}

	public void takeScreenshot(String testNo) {
		String strScreenshotsFolder = System.getProperty("ScreenshotsFolder");
		try {
			waitForTime(1500);
			DateFormat dateFormat = new SimpleDateFormat("yyyy_dd_MMM_HH_mm_ss");
			Date date = new Date();
			String getCurrentDate = dateFormat.format(date);

			WebDriver augmentedDriver = new Augmenter().augment(driver);
			File scrFile = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.FILE);
			String path = strScreenshotsFolder + "/" + testNo + "_" + getCurrentDate + ".png";

			FileUtils.copyFile(scrFile, new File(path));
			System.setProperty("org.uncommons.reportng.escape-output", "false");
			FileUtils.copyFile(scrFile, new File(path));
			new File(strScreenshotsFolder).mkdirs();
			Reporter.log("To View Screenshot <a href=\"file:///" + path + "\">Click Here</a>");
		} catch (IOException e) {
			// log.severe("Exception in the method takeScreenshot: "
			// + e.getMessage());
			Assert.assertTrue(false, " Exception in the method takeScreenshot:  " + e.getMessage());
		}

	}

	/**
	 * Method Name : rtnRegExpValue Purpose: Method to return matched string
	 * value
	 * 
	 * @param: String
	 *             compilerValue, matcherValue
	 * @return: None
	 */
	public String getStrRegExpValue(String compilerValue, String matcherValue) {
		String rtnValue = "";
		Pattern pattern = Pattern.compile(compilerValue);
		Matcher matcher = pattern.matcher(matcherValue);
		while (matcher.find()) {
			rtnValue += matcher.group();
		}
		return rtnValue;
	}

	/**
	 * Method Name : isFileExist Purpose: Method to return boolean value
	 * 
	 * @param: String
	 *             filePath * @return: None
	 */
	public boolean isFileExist(String filePath) {
		File f = new File(filePath);
		if (f.exists()) {
			Reporter.log("File exists");
			return true;
		} else {
			Reporter.log("File not exists!");
			return true;
		}
	}

	public int convertStringToNbr(String strValue) {
		Integer rtnInt = 0;
		try {
			rtnInt = Integer.valueOf(strValue);
		} catch (Exception e) {
			// log.severe("Exception in the method convertStringToNbr due to " +
			// e.getMessage());
			Assert.assertTrue(false, "Exception in the method convertStringToNbr due to " + e.getMessage());
		}
		return rtnInt;
	}

	public void enterText(String objNameStr, WebElement objName, String value) {

		try {
			objName.clear();
			objName.sendKeys(value);
			Reporter.log("'" + value + "'" + " is entered in " + objNameStr);
		} catch (Exception e) {
			Reporter.log(objNameStr + " is not displayed");

		}

	}

	/**
	 * getPresentWorkingDir() method contains set of instructions to get the
	 * current working directory
	 * 
	 * @throws IOException
	 * @param
	 * @return String CurrentWorkingDirectory
	 */
	public static String getPresentWorkingDir() throws IOException {
		File directory = new File(".");
		// Pattern p = Pattern.compile("\\\\");
		// Pattern p1 = Pattern.compile("/");
		// Matcher m = p.matcher(directory.getAbsolutePath());
		// Matcher m1 = p1.matcher(directory.getAbsolutePath());
		// boolean result = m.find() || m1.find();
		// System.out.println("GPD"+result);
		// D:\QA-Automation\Workspace\SIM_NewFrameWork\conf\initConfig.properties

		// if (result) {
		// directory = new File("/");
		// }
		//System.out.println("Get Present" + directory.getCanonicalPath());
		return directory.getCanonicalPath();
	}

	/**
	 * readProperties() method contains set of instructions to read the
	 * properties file where 'Filename' is the actual file which has to be read
	 * and 'Folder' is the location of this file.
	 * 
	 * @throws FileNotFoundException
	 *             , IOException
	 * @param String
	 *            Filename, String Folder
	 * @return
	 * @return Properties AllProperties
	 */
	public static Properties readProperties(String Filename, String Folder) {
		Properties props = new Properties();
		try {
			// File config_file = new File(Folder + "//"testdata + Filename);
			String directory = getPresentWorkingDir();
			String dir = directory + File.separator + System.getProperty("TestData");
			File config_file = new File(dir + File.separator + Folder + File.separator + Filename);
			props.load(new FileInputStream(config_file));
		} catch (FileNotFoundException e) {

		} catch (IOException e) {

		}
		return props;
	}

	/**
	 * currenttime() method contains set of instructions to show the current
	 * system time.
	 * 
	 * @throws Null
	 * @Returns String[]
	 * @param
	 */
	public static String currenttime() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat DateFormats = new SimpleDateFormat("hh:mm:ss");
		String CurrentDates = DateFormats.format(cal.getTime());
		String time[] = CurrentDates.split(":");
		String hmstime = time[0] + time[1] + time[2];
		return hmstime;
	}

	/**
	 * Random Num Generator based on the Range
	 * 
	 * @author Piramanayagam.S
	 * @param i
	 * @return integer
	 */
	public static int randomnum(int i) {

		int rand = 0;
		Random r = new Random();
		while (rand == 0) {
			rand = r.nextInt(i);
		}

		return rand;
	}

	/**
	 * Randomnum Generator from Currenttime
	 * 
	 * @author Piramanayagam.S
	 * @param null
	 * @return String , time
	 */
	public static String randomnum() {

		DateFormat dateFormat = new SimpleDateFormat("yyMMddHHmmss");
		Calendar cal = Calendar.getInstance();
		return dateFormat.format(cal.getTime());
	}
	
	/**
	 * AddSubDate-  Add/Subtract date to the current date
	 * 
	 * @author Piramanayagam.S
	 * @throws ParseException
	 * 
	 */
	public static String AddSubDate(int noofdays) throws ParseException {

		DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
		Calendar cal = Calendar.getInstance();
		String dt=dateFormat.format(cal.getTime());
		
		cal.setTime(dateFormat.parse(dt));
		cal.add(Calendar.DATE, noofdays);  
		dt = dateFormat.format(cal.getTime());
		System.out.println(dt);
		
		return dt;
	}

	/**
	 * Connect DB -Connect DB
	 * 
	 * @author Piramanayagam.S
	 * @return Statement
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public Statement ConnectDB() throws FileNotFoundException, IOException {
		String dbUrl = InitProperties("sim.dbURL");
		String dbUser = InitProperties("sim.dbUser");
		String dbPass = InitProperties("sim.dbPass");
		int port = Integer.parseInt(InitProperties("sim.dbport"));

		String dbName = InitProperties("sim.dbName");

		try {
			SQLServerDataSource ds = new SQLServerDataSource();
			ds.setUser(dbUser);
			ds.setPassword(dbPass);
			ds.setServerName(dbUrl);
			ds.setPortNumber(port);
			ds.setDatabaseName(dbName);
			con = (SQLServerConnection) ds.getConnection();
			stmt = (SQLServerStatement) con.createStatement();

		} catch (Exception e) {
		}

		return stmt;
	}

	/**
	 * FetchDBdata run query in the SQL
	 * 
	 * @author Piramanayagam.S
	 * @param query
	 * @return String ,single value from Database
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @throws SQLException
	 */
	public  String fetchDBdata(String query) throws FileNotFoundException, IOException, SQLException {

		String result = null;

		stmt = ConnectDB();
		rs = null;
		rs = (SQLServerResultSet) stmt.executeQuery(query);
		while (rs.next()) {
			result = rs.getString(1);
			System.out.println(result + "FRM DB");
		}
		CloseDB();

		return result;
	}
	
	public  List<String> fetchDBlistdata(String query) throws FileNotFoundException, IOException, SQLException {

		List<String>  result = new ArrayList<String>();

		stmt = ConnectDB();
		rs = null;
		rs = (SQLServerResultSet) stmt.executeQuery(query);
		while (rs.next()) {
			result.add(rs.getString(1));
			
			System.out.println(result + "FRM DB");
		}
		CloseDB();

		return result;
	}

	/**
	 * Close DB connection After Connection
	 * 
	 * @author Piramanayagam.S
	 * @throws SQLException
	 */
	private  void CloseDB() throws SQLException {
		if (rs != null) {
			rs.close();
		}
		if (stmt != null) {
			stmt.close();
		}
		if (con != null) {
			con.close();
		}

	}

	/**
	 * Read Excel return the sheet when filename given
	 * 
	 * @author Piramanayagam.S
	 * @param Fname
	 * @param Sheetname
	 * @return
	 * @throws IOException
	 */
	public static HSSFSheet ReadExcel(String Fname, String Sheetname) throws IOException {

		File f = new File(getPresentWorkingDir() + File.separator + dir + File.separator + Fname);
		FileInputStream fs = new FileInputStream(f);
		HSSFWorkbook wb = new HSSFWorkbook(fs);
		HSSFSheet sheet = wb.getSheet(Sheetname);

		return sheet;
	}

	public static String[] ReadExcelField(String fname, String sheetname, String comment) throws IOException {
		String[] val = new String[3];
		String sname = "";
		HSSFSheet sheet = ReadExcel(fname, sheetname);
		int rowcount = sheet.getLastRowNum();
		outr: for (int x = 0; x <= rowcount; x++) {
			HSSFRow rows = sheet.getRow(x);
			HSSFCell cel = rows.getCell(0);
			String colval = cel.getStringCellValue();
			if (colval.equalsIgnoreCase(comment)) {

				HSSFCell uname = rows.getCell(1);
				HSSFCell pwd = rows.getCell(2);
				String unames = uname.getStringCellValue();
				String pwds = pwd.getStringCellValue();

				HSSFCell snames = rows.getCell(3);
				if (snames != null) {
					snames.setCellType(Cell.CELL_TYPE_STRING);
					sname = snames.getStringCellValue();
				}

				val[0] = unames;
				val[1] = pwds;
				val[2] = sname;
				break outr;
			}

		}
		return val;
	}

	/**
	 * To Create Copy of Any file
	 * 
	 * @author Piramanayagam.S
	 * @return
	 * @throws IOException
	 */
	public static String CopyFile(String orgfile) throws IOException {
		System.out.println(orgfile);
		// For File format
		String[] nwfile = orgfile.split("\\.");
		String nfile = randomnum() + "." + nwfile[1];
		System.out.println("COPY:" + nfile);
		File srcfile = new File(getPresentWorkingDir() + File.separator + dir + File.separator + orgfile);
		File destfile = new File(getPresentWorkingDir() + File.separator + dir + File.separator + nfile);

		FileUtils.copyFile(srcfile, destfile);
		System.out.println("COPIED File:" + destfile);

		return nfile;
	}

	/**
	 * Method is used to Delete the file from the Test data folder
	 * 
	 * @param file
	 * @throws IOException
	 */
	public static void deleteFile(String file) throws IOException {
		File f = new File(getPresentWorkingDir() + File.separator + dir + File.separator + file);
		if (f.exists()) {
			f.delete();
		}
	}

	public void waitforPageload(WebElement webElement) {
		waitForTime(4000L);
		try{
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(webElement));
		}catch(Exception e){
			System.out.println("WPL:"+e);
		}
	}
	
	
}
