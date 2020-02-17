package lavante.recovery.utilities;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.google.common.base.Predicate;
import com.microsoft.sqlserver.jdbc.SQLServerConnection;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerResultSet;
import com.microsoft.sqlserver.jdbc.SQLServerStatement;

//import reusableUtilities.Report;

public class seleniumBaseClass {
	
	public static WebDriver driver;
	private String appUrl=readConfigFile("APPURL");
	public Logger log;
	public URL url = null;
	public HttpURLConnection connection = null;
	public int responseCode = 0;
	public String currentUrl;
	public static final String Browser="firefox";
	public static final String Platform="Windows";
	public static final String Version="45.0";
	
	public static Connection con = null;
	public static Statement stmt = null;
	public static ResultSet rs = null;
	
	public void launchRecoveryAppForDebug() throws IOException  {	
		try	{
				ProfilesIni profile = new ProfilesIni();
				FirefoxProfile Uleafprofile = profile.getProfile("Selenium_User");					
				driver = new FirefoxDriver(Uleafprofile);
				try
				{
				driver.get(appUrl);
				Report.pass("Browser is launched successfully");
				}
				catch(Exception e)
				{
				Report.fail("Browser is not launched."+e.getMessage());
				}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//	Thread.sleep(5000);
			Report.pass("Application is launched successfully.");
			}
			catch(Exception e) {	
				
			Report.fail("Application is not Launched." + e.getMessage());
			
			}
		}
	
	 public void quitBrowser()	{
	    	
	    	driver.quit();
	    	
	    }
	 
	 
	 public void launchAppThroughPOM(String platform, String browser, String Version) throws MalformedURLException
	 {
		 
		try {
		 	
		 	 String remoteExec = System.getProperty("RemoteExecution");
		 	 System.out.println("remotea" + remoteExec);
				DesiredCapabilities caps = new DesiredCapabilities();
				caps=DesiredCapablity(browser);
					
					//Check for Grid Configuration
				if(remoteExec!=null){
					if(remoteExec.equalsIgnoreCase("true")){
						
					 	 String remoteURL = System.getProperty("RemoteURL");
							URL remoteAddress = new URL(remoteURL + "/wd/hub");
							 Report.info("Broweser Parameters : "+"Browser : "+browser+", Version :"+Version);
						 	 Report.info("Remote Parameters : "+"RemoteURL : "+remoteURL+", RemoteExecution :"+remoteExec);
						driver = new RemoteWebDriver(remoteAddress, caps);
						((RemoteWebDriver) driver).setFileDetector(new LocalFileDetector());

					}
					else {		
						if (browser.equalsIgnoreCase("firefox")) {
							driver = new FirefoxDriver(caps);
						} else if (browser.equalsIgnoreCase("chrome")) {
							System.setProperty("webdriver.chrome.driver", "C:\\LavanteDrivers\\ChromeDriver.exe");
							driver = new ChromeDriver(caps);
						} else if (browser.equalsIgnoreCase("internet explorer")) {
							System.setProperty("webdriver.ie.driver", "C:\\LavanteDrivers\\IEDriverServer.exe");
							driver = new InternetExplorerDriver(caps);
						}
					}
				}else {		
							if (browser.equalsIgnoreCase("firefox")) {
								driver = new FirefoxDriver(caps);
							} else if (browser.equalsIgnoreCase("chrome")) {
								System.setProperty("webdriver.chrome.driver", "C:\\LavanteDrivers\\ChromeDriver.exe");
								driver = new ChromeDriver(caps);
							} else if (browser.equalsIgnoreCase("internet explorer")) {
								System.setProperty("webdriver.ie.driver", "C:\\LavanteDrivers\\IEDriverServer.exe");
								driver = new InternetExplorerDriver(caps);
							}
					}
	
				driver.navigate().to(appUrl);

				driver.manage().window().maximize();
				
				 List<WebElement> overrideLink = driver.findElements(By.name("overridelink"));
				
				 if(overrideLink.size()>0){
					overrideLink.get(0).click();
					
					driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
					Report.pass("Application is launched successfully.");
				}
				 
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	
				Report.pass("Application is launched successfully.");
				
		}
		 catch(Exception e)
		 {
			 Report.fail("Application is not Launched." + e.getMessage());
		 }	
	 }
	 
		public void launchAppFromPOM(String Platform, String browser, String Version) throws IOException
		{
			DesiredCapabilities caps = new DesiredCapabilities();
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
			} else if (browser.equalsIgnoreCase("internet explorer")) {
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
			
			String strRemoteExec = System.getProperty("RemoteExecution");
			
			if(strRemoteExec!=null){
				if(strRemoteExec.equalsIgnoreCase("true")){
					 strRemoteExec = System.getProperty("RemoteExecution");
					 
					String strRemoteURL = System.getProperty("RemoteURL");
					 
					URL remoteAddress = new URL(strRemoteURL + "/wd/hub");
					driver = new RemoteWebDriver(remoteAddress, caps);
					((RemoteWebDriver) driver).setFileDetector(new LocalFileDetector());
				}else {		
					if (browser.equalsIgnoreCase("firefox")) {
						driver = new FirefoxDriver(caps);
					} else if (browser.equalsIgnoreCase("chrome")) {
						System.setProperty("webdriver.chrome.driver", getPresentWorkingDir()+File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"ChromeDriver.exe");
						driver = new ChromeDriver(caps);
					} else if (browser.equalsIgnoreCase("internet explorer")) {
						System.setProperty("webdriver.ie.driver", getPresentWorkingDir()+File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"IEDriverServer.exe");
						driver = new InternetExplorerDriver(caps);
					}
				}
			}else {		
				if (browser.equalsIgnoreCase("firefox")) {
					driver = new FirefoxDriver();
				} else if (browser.equalsIgnoreCase("chrome")) {
					System.setProperty("webdriver.chrome.driver", getPresentWorkingDir()+File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"ChromeDriver.exe");
					driver = new ChromeDriver(caps);
				} else if (browser.equalsIgnoreCase("internet explorer")) {
					//System.setProperty("webdriver.ie.driver", getPresentWorkingDir()+File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"IEDriverServer.exe");
					System.setProperty("webdriver.ie.driver", "C://LavanteDrivers//IEDriverServer.exe");
							//getPresentWorkingDir()+File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"IEDriverServer.exe");
					driver = new InternetExplorerDriver(caps);
					
					driver.navigate().to(appUrl);
					driver.manage().window().maximize();
					
					List<WebElement> overrideLink = driver.findElements(By.name("overridelink"));
					
					if(overrideLink.size()>0){
					overrideLink.get(0).click();
					}
				}
			}
			
			driver.navigate().to(appUrl);
			driver.manage().window().maximize();
			
		}
	 
	 public void verifyBrowserStartPopUp() {
		 List<WebElement> popUp = driver.findElements(By.cssSelector("div[style*='block'] [title*='close']"));
		 
		 if(popUp.size() > 0){
			 popUp.get(0).click();
		 }	
		 
		 else
			waitForTime(3000);
	}
	 
	 public DesiredCapabilities DesiredCapablity(String browser) {
		 
			DesiredCapabilities caps = new DesiredCapabilities();
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
			} else if (browser.equalsIgnoreCase("internet explorer")) { 
				caps = DesiredCapabilities.internetExplorer();
				caps.setBrowserName("internet explorer");
				caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
				caps.setCapability("ignoreZoomSetting", true);
				caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				caps.setCapability(CapabilityType.SUPPORTS_ALERTS, true);
				caps.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, true);
				caps.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, true);
				caps.setCapability(CapabilityType.HAS_NATIVE_EVENTS, false);
				caps.setCapability(CapabilityType.SUPPORTS_APPLICATION_CACHE, false);
				caps.setCapability(InternetExplorerDriver.FORCE_CREATE_PROCESS, true);
			} else {
				Report.fail("Invalid browser! Unable to execute...");
			}
			
			System.out.println(caps);
		
			return caps;
		}
	 
	 
	 public void enterText(String objNameStr,WebElement objName, String value)  {
	    	try
			{
	    	System.out.println(driver + value + objName + objNameStr);
			objName.clear();
			objName.sendKeys(value);

			Report.pass("'" + value+"'" + " is entered in " + objNameStr);

			}
			catch(Exception e)
			{
	
			Report.fail("'" + value+"'" + " is not entered in " + objNameStr+e.getMessage());
			}
	    	
	    }
	
	 public void click(String objNameStr,WebElement objName)   {
	    
	    	try {	
	    	System.out.println(objNameStr + "," + objName);
	    	objName.click();
	    	System.out.println(objNameStr + objName);
			
			//Report.pass("'" + objNameStr+"'" + " is clicked");			
			
			}
			catch(Exception e) {
			getHttpResponse();
			Report.fail("'" + objNameStr + "' is not displayed");
			
			//driver.navigate().back();
			
			}
	    	
	    }
	 
	 
	 public void isDisplayed(String objNameStr,WebElement objName)	 {
		 
		 try {
				if(objName.isDisplayed()) {
					
					Report.pass("'" + objNameStr + "' is displayed");					
				}
				
			} 
			catch (Exception e) {
				
				Report.fail("'" + objNameStr + "' is not displayed"+e.getMessage());
		
			}

		 
	 }
	 
	 public void startTest(String testName)
	 {
		 //System.out.println("------------Test ' "+testName+" ' Started------------");
		 Report.info("------------Test ' "+testName+" ' Started------------");
	 }
	    
	 public void endTest(String testName)
	 {
		 //System.out.println("------------Test ' "+testName+" ' Ended------------");
		 Report.info("------------Test ' "+testName+" ' Ended------------");
	 }
 
 	//Reading configuration file
    public String readConfigFile(String value)
	{
		try
		{
		Properties props=new Properties();
		//FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\conf\\initConfig.properties");
		FileInputStream fis=new FileInputStream(getPresentWorkingDir() + File.separator + "conf"+ File.separator + "initConfig.properties");
		props.load(fis);	
		Report.pass("Config file"+ fis + "found");
		return props.getProperty(value);	
		}
		catch(Exception e)
		{
		Report.fail("Config file is not read");
		return "";
		}
		
	}
    
    public static String getPresentWorkingDir() throws IOException {
		File directory = new File(".");
	//	Pattern p = Pattern.compile("\\\\");
	//	Pattern p1 = Pattern.compile("/");
	//	Matcher m = p.matcher(directory.getAbsolutePath());
	//	Matcher m1 = p1.matcher(directory.getAbsolutePath());
	//	boolean result = m.find() || m1.find();
	//	System.out.println("GPD"+result);
		//D:\QA-Automation\Workspace\SIM_NewFrameWork\conf\initConfig.properties

	//	if (result) {
		//	directory = new File("/");
	//	}
		System.out.println("Get Present"+directory.getCanonicalPath());
		return directory.getCanonicalPath();
	}
    
    //Wait method
    public static void waitForTime(int time) {
		try{
			Long t=(long) time;
			Thread.sleep(t);
		}catch(Exception e){
			Report.fail("Timed out" + e.getMessage());
		}
	}
    
    //Selecting from drop down list - For normal scenarios
	public void selectByVisibiletxt(String toselect,WebElement element) {
		try{
			new Select(element).selectByVisibleText(toselect);
		}
		catch(Exception e){
			Report.fail(element + "  Not found in drop down list");
		}
		
	}

    //Selecting from drop down list with index
	public void selectByIndex(int i, WebElement element) {
		try{
			new Select(element).selectByIndex(i);
		}
		catch(Exception e){
			Report.fail(element + "  Not found in drop down list");
		}
		
	}
	
    //Selecting from drop down list - For normal scenarios
	public void selectByText(String toselect,WebElement element) {
		try{
			Select sel = new Select(element);
			sel.selectByValue(toselect);
			System.out.println(toselect + element);
		}
		catch(Exception e){
			Report.fail(element + "  Not found in drop down list");
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
			Report.fail(selectedvalue + "  Not found in drop down list");
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
	
	/**
     * This method will set any parameter string to the system's clipboard.
     */
	public static void setClipboardData(String string) {
		//StringSelection is a class that can be used for copy and paste operations.
		   StringSelection stringSelection = new StringSelection(string);
		   Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
	}
	
	public static void uploadFile(String fileLocation) {
        try {
        	//Setting clipboard with file location
            setClipboardData(fileLocation);
            //native key strokes for CTRL, V and ENTER keys
            Robot robot = new Robot();
	
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            waitForTime(3000);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        } catch (Exception exp) {
        	exp.printStackTrace();
        }
    }
	
	public void selectvalue(WebElement drpdown, String exvalue) {
		switchtoFrame(null);
		if(exvalue.length()>0)
		{ 
			System.out.println("drp down : " + drpdown);
			
			List<WebElement> el=driver.findElements(By.cssSelector(drpdown + ".no-chosen"));
			
			System.out.println("DP SIZE"+el.size());
			
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
		
	
	public void typeinEditforAudit(String totype) {
		WebElement textBox = driver.findElement(By.cssSelector("#audit_chosen .chosen-search input"));
		textBox.sendKeys(totype);
		
		//return amnt;
	}
	
	//Method for switching frame
	public void switchtoFrame(WebElement frame) {

			try{
				
				if(frame==null){
					driver.switchTo().defaultContent();
				}
				
				else{
				//fluentwait(frame);
				driver.switchTo().frame(frame);	
				}
				
				System.out.println("frame element is" + frame);
				Report.info("Switched successfully to frame" + frame);
			}
			catch (NoSuchFrameException e) {
				System.out.println("Unable to locate frame" + frame + e.getStackTrace());
				Assert.assertTrue(false, "Unable to locate frame" + frame + e.getStackTrace());
			} catch (Exception e) {
				System.out.println("Unable to navigate to frame" + frame + e.getStackTrace());
				Assert.assertTrue(false, "Unable to locate frame" + frame + e.getStackTrace());
			}
			//driver.switchTo().defaultContent();
				waitForTime(3000);
	}

	
	public void switchtoFramebyID(int frameNumber) {
		 try{
				driver.switchTo().frame(frameNumber);	
				Report.info("Switched successfully to frame :" + frameNumber);
			}
			catch (NoSuchFrameException e) {
				System.out.println("Unable to locate frame with id " + frameNumber + e.getStackTrace());
			} catch (Exception e) {
				System.out.println("Unable to navigate to frame with id " + frameNumber + e.getStackTrace());
			}
		
		
/*		else {
			driver.switchTo().defaultContent();
		}*/
		waitForTime(3000);
	}
	
	public void switchBackDefault() {
		driver.switchTo().defaultContent();
	}

    //Verify text method
	public void verifyText(String expectedText,WebElement actualText)	 {
	 
	 try {
		 String text = actualText.getText();
		 
		 if(text==expectedText){
				Report.pass("'" + text + "' matches with expected" + " "+ expectedText);					
			}
		
		} 
		catch(Exception e) {
			Report.fail("'" + actualText + "' does not match" + e.getMessage());			
		} 
	}
	
	//Verify Errors in the application 
	public void verifyError(WebElement objName){
		 try {
			 String errText = objName.getText();
			 
			 if(errText.contains("error")){
					Report.fail("Error loading " + objName);					
				}
			
			} 
			catch(Exception e) {
				Report.fail(e.getMessage());			
			} 	
	}
	
	//Get text
	public String getText(String objNameStr, WebElement objStatus){
		String text = "";
		try{
		 text =objStatus.getText();
		}
		catch(Exception e){
		Report.fail("Unable to retreive element" + objNameStr + e.getMessage());
		}
		return text;
	}
	
	//Get Attribute by value
	public String getattributeByValue(WebElement objStatus){
		String text = "";
		try{
		 text = objStatus.getAttribute("value");
		}
		catch(Exception e){
		Report.fail("Unable to retreive element" + e.getMessage());
		}
		return text;
	}
	
	//Handling alert box
	public void clickOnAlert(){
		
		try{
			boolean presentFlag = false;
			
			Alert alert = driver.switchTo().alert();
			
			presentFlag = true;
			System.out.println("alert " +presentFlag);
			
			String alerttext = alert.getText();
	
			if(alerttext.equalsIgnoreCase("ÖK"))
			alert.accept();
			System.out.println("clicked on ok");
				//objName.click();
			
		//	else //if(objName.getText().equals("Close"))
		//	alert.dismiss();	
		}
		catch(Exception e){
		Report.fail("Unable to retreive element" + e.getMessage());
		}
	}
	
	public void alertpopup(){
		
		try{
			WebElement objPopUp = driver.switchTo().activeElement();
			objPopUp.click();
		}
		catch(Exception e){
		Report.fail("Unable to retreive element" + e.getMessage());
		}
	}
	
	public void ActionsTextBox(WebElement ObjName){

//			Actions act = new Actions (driver);
			
			ObjName.sendKeys(Keys.ESCAPE);	
	}
	
	public void ActionsforDoubleClick(WebElement ObjName){
			Actions act = new Actions(driver);
			act.moveToElement(ObjName);
			act.doubleClick(ObjName).build().perform();
	}
	
	public void ActionsforSingleClick(WebElement ObjName){
		try{
			Actions act = new Actions(driver);
			act.moveToElement(ObjName).build().perform();
			
			System.out.println(ObjName.getText());
			
			act.click(ObjName).build().perform();
		}catch(Exception e){
			Reporter.log("Unable to click button" + e);
			Assert.assertTrue(false, "Unable to click button" + e);
		}
	}
	
	public void click(WebElement e) {
		  try {
		   e.click();
		  } catch (Exception ex) {
		   clickJavaScript(e);
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
	
	public void Scrollintoview(WebElement e) {
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", e);
			waitForTime(3000);
		} catch (Exception ex) {
			Assert.assertFalse(true, "Failed in Scroll to View: " + e.toString());
		}
	}
	
	public static String generateRandomDate() {
		 String date="";
	        int yearBegin=2012;
	        int yearEnd=2016-yearBegin;

	        date="" + (1 + (int)(Math.random() * 12) + 
	        		"/" +
	        		(1 + (int)(Math.random() * 31) +
	        		"/" + 
	        		(yearBegin + (int)(Math.random() * yearEnd))));
	       System.out.println(date);
	       
	       return date;  
 }
	    
	public void ExplicitWaitforLinksClick(WebElement ObjName){

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(ObjName));
	}
	
	public void ExplicitWaitforelements(WebElement ObjName){

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(ObjName));
	}
	
	public void waitforPageLoad(WebElement element){
		WebDriverWait wait=new WebDriverWait(driver,15);
		try{
		       wait.until(ExpectedConditions.visibilityOf(element));
		}catch(TimeoutException e){
		       System.out.println("Page is not refreshed in 10 seconds");
		}
	}
	
	
	//Get Page Current URL
	public void getCurrentURL(){
	  currentUrl = driver.getCurrentUrl();
	}
	
	//Getting Current Date and Time in MMM dd yyyy format
	public String getCurrentDateTime(){
		Date d = new Date();
	    SimpleDateFormat form = new SimpleDateFormat("MMM dd yyyy");
	    String str = form.format(d); 
	    System.out.println(str); 
	    return str;
	}
	
	//Verify HTTP Response for URL for broken pages
	public void getHttpResponse(){
	 
		try {
			getCurrentURL();
			url = new URL(currentUrl);
		} catch (MalformedURLException e) {
			Report.fail("Unable to get current URL" + currentUrl + e.getMessage());
		}
		try {
			connection = (HttpURLConnection)url.openConnection();
		} catch (IOException e) {
			Report.fail("Unable to get connection" + connection + e.getMessage());
		}
		try {
			connection.setRequestMethod("GET");
		} catch (ProtocolException e) {
			e.printStackTrace();
		}
		try {
			connection.connect();
		} catch (IOException e) {
			Report.fail("Unable to connect" + e.getMessage());
		}

     int responseCode = 0;
     	try {
		responseCode = connection.getResponseCode();
     	} catch (IOException e) {
		Report.fail("Unable to get response for response code :" + responseCode + e.getMessage());
     	
     	}
     	if (responseCode!=200){
     		Report.fail(currentUrl + ": is Broken");
     		driver.navigate().back();
     		waitForTime(3000);
		}
     	else{
     		Report.pass(currentUrl + " Page is working fine");
     	}
	}
	
	/**
	 * Method Name : takeScreenSort Purpose: Method for capturing screenshot
	 * @param: 
	 * @return None
	 */
	public static void takeScreenshot() {
		String strScreenshotsFolder = System.getProperty("ScreenshotsFolder");
		try {
			waitForTime(1500);
			DateFormat dateFormat = new SimpleDateFormat("yyyy_dd_MMM_HH_mm_ss");
			Date date = new Date();
			String getCurrentDate = dateFormat.format(date);

			WebDriver augmentedDriver = new Augmenter().augment(driver);
			File scrFile = ((TakesScreenshot) augmentedDriver)
					.getScreenshotAs(OutputType.FILE);
			String path = strScreenshotsFolder + "/"+ getCurrentDate + ".png";

			FileUtils.copyFile(scrFile, new File(path));
			System.setProperty("org.uncommons.reportng.escape-output", "false");
			FileUtils.copyFile(scrFile, new File(path));
			//new File(strScreenshotsFolder).mkdirs();
			Reporter.log("To View Screenshot <a href=\"file:///" + path
					+ "\">Click Here</a>");
		} catch (IOException e) {
			Assert.assertTrue(
					false,
					" Exception in the method takeScreenshot:  "
							+ e.getMessage());
		}

	}
	
	public static void scrollToBottom(WebDriver driver) {
        ((JavascriptExecutor) driver)
                .executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }
	
	public static void scrollTo(WebDriver driver, WebElement element) {
	        ((JavascriptExecutor) driver).executeScript(
	                "arguments[0].scrollIntoView();", element);
	}
	
	public static void navigateBack() {
			driver.navigate().back();
}
	
	//Window handles
	public static void getWindowHandle(WebElement element) {
		
		String parentWindow = driver.getWindowHandle();
		
		Set<String> allWindows = driver.getWindowHandles();
		
		System.out.println(allWindows.size());
		
		for(String eachWindow : allWindows){
			if(eachWindow!=parentWindow){
				driver.switchTo().window(eachWindow);
			}
		}
    }
	
	
	
	public void scrollingByCoordinatesofAPage() {
		((JavascriptExecutor) driver).executeScript("window.scrollBy(20,20)");
	}
	
	public void scrollingToElementofAPage(WebElement element) {
		((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView();", element);
	}
	
	/*public boolean fluentwait(WebElement element) {
		int timeoutSeconds=120;
		try{
			FluentWait<WebElement> wait=new FluentWait<WebElement>(element)
			.withTimeout(timeoutSeconds, TimeUnit.SECONDS)
			.pollingEvery(100,TimeUnit.MILLISECONDS)
			.ignoring(org.openqa.selenium.StaleElementReferenceException.class)
			.ignoring(org.openqa.selenium.NoSuchElementException.class)
			.ignoring(org.openqa.selenium.InvalidSelectorException.class)
			.ignoring(org.openqa.selenium.WebDriverException.class)
			.ignoring(org.openqa.selenium.ElementNotVisibleException.class);
			
			wait.until(new Predicate<WebElement>() {   
				public boolean apply(WebElement element) {                       
					System.out.println("FW:"+element.isDisplayed()+":"+element);
					return element.isDisplayed();
					
				}               
			});
    				
			return true;
    			
		}catch(TimeoutException e){
			return false;
		}
	}*/
	
	public String verifyTooltip(WebElement element){
		String title = element.getAttribute("title");
		return title;
	}
	
	/**
	 * FetchDBdata run query in the SQL
	 * 
	 * @author Srikanth
	 * @param query
	 * @return String ,single value from Database
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @throws SQLException
	 */
	public static String fetchDBdata(String query) throws FileNotFoundException, IOException, SQLException {

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
	
	/**
	 * Close DB connection After Connection
	 * 
	 * @author Srikanth
	 * @throws SQLException
	 */
	private static void CloseDB() throws SQLException {
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
	
	public static Properties readProperties(String Filename, String Folder) {
		Properties props = new Properties();
		try {
			// File config_file = new File(Folder + "//"testdata + Filename);
			String directory = getPresentWorkingDir();
			String dir = directory + File.separator + "src" + File.separator + "test" + File.separator + "resources";
			System.out.println(directory);
			File config_file = new File(dir + File.separator + Folder + File.separator + Filename);
			System.out.println(config_file);
			props.load(new FileInputStream(config_file));
		} catch (FileNotFoundException e) {

		} catch (IOException e) {

		}
		return props;
	}
	
	public static String InitProperties(String toread) throws FileNotFoundException, IOException {
		String value = "";
		try {
			Properties config = readProperties("initConfig.properties", "config");
			value = config.getProperty(toread);
		} catch (Exception e) {

		}
		return value;
	}
	
	
	public static Statement ConnectDB() throws FileNotFoundException, IOException {
		String dbUrl = InitProperties("Recovery.dbURL");
		String dbUser = InitProperties("Recovery.dbUser");
		String dbPass = InitProperties("Recovery.dbPass");
		int port = Integer.parseInt(InitProperties("Recovery.dbport"));

		String dbName = InitProperties("Recovery.dbName");

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
	
}
	 

