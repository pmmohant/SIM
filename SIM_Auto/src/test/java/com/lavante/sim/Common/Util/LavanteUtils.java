
package com.lavante.sim.Common.Util;

/*
import static org.monte.media.FormatKeys.EncodingKey;
import static org.monte.media.FormatKeys.FrameRateKey;
import static org.monte.media.FormatKeys.KeyFrameIntervalKey;
import static org.monte.media.FormatKeys.MIME_AVI;
import static org.monte.media.FormatKeys.MediaTypeKey;
import static org.monte.media.FormatKeys.MimeTypeKey;
import static org.monte.media.VideoFormatKeys.CompressorNameKey;
import static org.monte.media.VideoFormatKeys.DepthKey;
import static org.monte.media.VideoFormatKeys.ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE;
import static org.monte.media.VideoFormatKeys.QualityKey;

import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment; */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.security.Security;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.search.FlagTerm;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.ObjectUtils.Null;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell; /*
import org.monte.media.Format;
import org.monte.media.FormatKeys.MediaType;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder; */
import org.junit.Ignore;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
/*import org.openqa.selenium.firefox.FirefoxProfile;*/
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;
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
	public static String ReportDir = "ReportDir" ;

	public static final String browserVersion = "45";
	public static final String browser = "chrome"; // #internet Explorer
													// #chrome #firefox
	public static final String Platform = "Windows";

	public static String DBURL = "", DBUserName = "", DBPassword = "";
	public static ResultSet ResSet = null, RetRS = null, Rest = null;
	
	public static String time="";
	public static int lastMailSentCounter=5;
	public static String RunningStatus="WAITING";
	public static int emailTimeOutConcurrency=1000;
	public static int lastemailConcurrency=0;
	public static String lastEmailSentTime="";
	public static ITestContext ctxx;
	public static String InitialReport=""; 	 
	public static String IntermediateReport=""; 
	String suiteStartTime="";
	String SuiteName="";
	ITestNGMethod[] itestMethodList ;

	static {
		System.setProperty("TestData","QATestData");
		dir = System.getProperty("TestData")+ File.separator + "data" ;
		if(System.getProperty("TestData")==null){
			System.setProperty("TestData","StagingTestData");
			dir = System.getProperty("TestData")+ File.separator + "data" ;
		}
		System.out.println(currenttime());
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

		return caps;
	}
/*	 private ScreenRecorder screenRecorder;*/
	 
/*	public void startRecording() throws Exception
    {
                         
         GraphicsConfiguration gc = GraphicsEnvironment
            .getLocalGraphicsEnvironment()
            .getDefaultScreenDevice()
            .getDefaultConfiguration();

        this.screenRecorder = new ScreenRecorder(gc,
            new Format(MediaTypeKey, MediaType.FILE, MimeTypeKey, MIME_AVI),
            new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
                 CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
                 DepthKey, 24, FrameRateKey, Rational.valueOf(15),
                 QualityKey, 1.0f,
                 KeyFrameIntervalKey, 15 * 60),
            new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, "black",
                 FrameRateKey, Rational.valueOf(30)),
            null);
       this.screenRecorder.start();
     
    }*/

   /* public void stopRecording() throws Exception
    {
      this.screenRecorder.stop();
    }
	*/
	public void launchAppFromPOM(String Platform, String browser, String Version) throws Exception {
      /*   startRecording();*/                                         
                       
		DesiredCapabilities caps = new DesiredCapabilities();
		/*DesiredCapabilities capss  = new DesiredCapabilities();*/
		
		if (browser.equalsIgnoreCase("firefox")) {
			caps = DesiredCapabilities.firefox();
			System.setProperty("webdriver.firefox.marionette","C:\\LavanteDrivers\\geckodriver.exe");
			//System.setProperty("webdriver.gecko.driver", "C:\\LavanteDrivers\\geckodriver.exe");
			
	        caps.setCapability("marionette", true);
	        caps.setBrowserName("firefox");
	   //     FirefoxOptions options = new FirefoxOptions();
		//	options.setBinary("C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe"); //This is the location where you have installed Firefox on your machine
		//	caps.setCapability("moz:firefoxOptions", options);
			
/*	        capss  = new FirefoxOptions()
	        .setProfile(new FirefoxProfile()).addTo(DesiredCapabilities.firefox());
*/	   
/*			caps.setBrowserName("firefox");*/
			/*caps.setCapability("marionette", true);*/
		//	System.setProperty("webdriver.gecko.driver", getPresentWorkingDir()  + File.separator + System.getProperty("TestData") + File.separator + "geckodriver.exe");
			//If Firefox Crashes in Startup to disabledebug mode popup
			/*FirefoxProfile firefoxProfile = new FirefoxProfile();
			firefoxProfile.setPreference("toolkit.startup.max_resumed_crashes", "0");
			caps.setCapability(FirefoxDriver.PROFILE, firefoxProfile);*/
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
		String paths=getPresentWorkingDir()  + File.separator + System.getProperty("TestData") + File.separator ;
		
		String strRemoteExec = System.getProperty("RemoteExecution");
		if (strRemoteExec != null) {
			if (strRemoteExec.equalsIgnoreCase("true")) {
				
				strRemoteExec = System.getProperty("RemoteExecution");
				String strRemoteURL = System.getProperty("RemoteURL");
				URL remoteAddress = new URL(strRemoteURL + "/wd/hub");
				driver = new RemoteWebDriver(remoteAddress, caps);
				((RemoteWebDriver) driver).setFileDetector(new LocalFileDetector());
				paths="C:"+File.separator+"LavanteDrivers";
			//killBrowserInstance(browser,paths);
			} else {
				if (browser.equalsIgnoreCase("firefox")) {
					System.setProperty("webdriver.gecko.driver", getPresentWorkingDir()  + File.separator + System.getProperty("TestData") + File.separator + "geckodriver.exe");
					System.setProperty("webdriver.firefox.marionette",
							getPresentWorkingDir()  + File.separator + System.getProperty("TestData") + File.separator + "geckodriver.exe");
					driver = new FirefoxDriver(caps);
				} else if (browser.equalsIgnoreCase("chrome")) {
					System.setProperty("webdriver.chrome.driver",
							getPresentWorkingDir()  + File.separator + System.getProperty("TestData") + File.separator + "chromeDriver.exe");
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
	
	@Ignore
	private void killBrowserInstance(String browser2,String path) throws IOException {
		String orgpath="C:"+File.separator+"LavanteDrivers"+File.separator;
		if(browser2.equalsIgnoreCase("firefox")){
			 path =  orgpath+"killFirefox.bat";
             path = "cmd.exe /c start "+ path;
			 System.out.println(browser2+":path:"+path+"/"+getPresentWorkingDir());
            Runtime rn = Runtime.getRuntime();
            rn.exec(path);
		}
		if(browser2.equalsIgnoreCase("chrome")){
            path = orgpath+"killChrome.bat";
            path = "cmd.exe /c start "+ path;
            System.out.println(browser2+":path:"+path+"/"+getPresentWorkingDir());
            Runtime rn = Runtime.getRuntime();
            rn.exec(path);
     }
		if(browser2.equalsIgnoreCase("internet explorer")){
            path=orgpath+"killIE.bat";
            path = "cmd.exe /c start "+ path;
            System.out.println(browser2+":path:"+path+"/"+getPresentWorkingDir());
            Runtime rn = Runtime.getRuntime();
            rn.exec(path);
     }


		
	}

	public void openAPP() throws FileNotFoundException, IOException {
		driver.get(InitProperties("APPURL"));
		String x=driver.getPageSource();
		int xx=0;
		while(!x.contains("username")&&(xx<5)){
			driver.navigate().to(InitProperties("APPURL"));
			x=driver.getPageSource();
			xx=xx+1;
		}
		/*List<WebElement> s = driver.findElements(By.id("overridelink"));
		if (s.size() > 0) {
			driver.navigate().to("javascript:document.getElementById('overridelink').click()");
		}waitForTime(3000);*/
		classNameDisplay();
	}

	//Azure app
	/**
	 * Temp Method for Azure Application Connect 
	 * 
	 * @author Piramanayagam.S
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void openAPP1() throws FileNotFoundException, IOException {
		openAPP();
	/*	driver.navigate().to(InitProperties("APPURLAzure"));
		String x=driver.getPageSource();
		int xx=0;
		while(!x.contains("username")&&(xx<5)){
			driver.navigate().to(InitProperties("APPURLAzure"));
			x=driver.getPageSource();
			xx=xx+1;
		}
		classNameDisplay();*/
	}
	
	//QA app
	/**
	 * Temp Method for QA Application Connect 
	 * 
	 * @author Piramanayagam.S
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void openQAAPP3() throws FileNotFoundException, IOException {
		driver.get(InitProperties("QASIM"));
		String x=driver.getPageSource();
		int xx=0;
		while(!x.contains("username")&&(xx<5)){
			driver.navigate().to(InitProperties("QASIM"));
			x=driver.getPageSource();
			xx=xx+1;
		}
		/*List<WebElement> s = driver.findElements(By.id("overridelink"));
		if (s.size() > 0) {
			driver.navigate().to("javascript:document.getElementById('overridelink').click()");
		}waitForTime(3000);*/
		classNameDisplay();
	}

	

	public String fetchCustomer(String loginUserEmail) throws FileNotFoundException, IOException, SQLException {
		String customerID = "";
		String quer = "select CustomerID from Customer_Contact_Map where ContactID=( "
				+ "select  ContactID from Contact where Email ='" + loginUserEmail + "')";
		customerID = fetchDBdata(quer);
		
		return customerID;
	}
	
	public String fetchSupplierCustomer(String loginUserEmail) throws FileNotFoundException, IOException, SQLException {
		String customerID = "";
		String quer = "select  MAX(CustomerID) From Relationship where LavanteUID in ( select LavanteUID from Supplier_Contact_Map where ContactID in (  "
				+ "			select  ContactID from Contact where Email like '"+loginUserEmail+"'))";
		customerID = fetchDBdata(quer);

		return customerID;
	}
	
	public String fetchSupFromSupCustomer(String loginUserEmail)
			throws FileNotFoundException, IOException, SQLException {
		String supName = "";
		String quer = "select suppliername from supplier where LavanteUID in (select  MAX(LavanteUID) From Relationship where LavanteUID in ( select LavanteUID from Supplier_Contact_Map where ContactID in (  "
				+ "			select  ContactID from Contact where Email like '" + loginUserEmail + "')))";
		supName = fetchDBdata(quer);
		return supName;
	}
	

	/**
	 * This Method is to login to the Application
	 * 
	 * @param dataContent
	 * @author Piramanayagam.S
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws SQLException
	 */
	public List login(String key, String browser) throws FileNotFoundException, IOException, SQLException {
		List das = new ArrayList();
		LinkedHashMap<String, String> dataMaps = new LinkedHashMap<String, String>();
		dataMaps = logindata(key, browser);
		String customerid = fetchCustomer(dataMaps.get("username"));
		das.add(dataMaps);
		das.add(customerid);
		return das;
	}

	@Ignore
	private LinkedHashMap<String, String> logindata(String key, String browser) throws IOException, SQLException {
		LinkedHashMap<String, String> loginDataMap = new LinkedHashMap<String, String>();
		String[] xx = ReadExcelField("Login.xls", browser, key);
		
		if(xx[0].contains("#")){
			String[] d= xx[0].split("#");
			String category=d[0];
			String role=d[1];
			String query="";
			if(d[0].equalsIgnoreCase("Customer")){
				 query=" select MAX(Co.Email) from Customer_Contact_Map ccm, Customer c, Login l, LoginRole lr ,Contact Co "
						+ " where c.CustomerID = ccm.CustomerID and ccm.ContactID = l.ContactID and Co.ContactID = l.ContactID "
						+ "and l.UserRoleID = lr.UserRoleID and lr.UserRoleName like '%"+role+"%' and Co.IsActive=1" ;
				
				query=fetchDBdata(query);
				xx[0]=query;
			}else{
				query="select MAX(Co.Email) from Supplier_Contact_Map ccm,  Login l, LoginRole lr ,Contact Co,Relationship r,Customer c "
						+ " where ccm.ContactID = l.ContactID and Co.ContactID = l.ContactID and ccm.LavanteUID = r.LavanteUID "
						+ " and l.UserRoleID = lr.UserRoleID and lr.UserRoleName like '%"+role+"%' and Co.IsActive=1 and c.customerID=r.CustomerID "
						+ " and c.Name='"+category+"' "; 
				query=fetchDBdata(query);
				xx[0]=query;
			}
				query=" Select MAX(l.EncryptedPassword) from Login l,Contact Co where l.ContactID = Co.ContactID and Co.Email='"+query+"' and Co.IsActive=1" ;
				query=fetchDBdata(query);
				
				if(query.equalsIgnoreCase("Csfqito1TIySInLbV4l8I4S35Hk")){
					xx[1]="lavante123";
					
				}else {
					//Write Update Query;
					query="update Login where EncryptedPassword='Csfqito1TIySInLbV4l8I4S35Hk', PasswordSalt='Fqw9lCV8E8o=' where LoginID in (Select MAX(l.LoginID) "
							+ " from Login l,Contact Co where l.ContactID = Co.ContactID and Co.Email='"+xx[0]+"' and Co.IsActive=1) ";
					
					UpdateDB(query);
					xx[1]="lavante123";
				}
		}
		
		loginDataMap.put("username", xx[0]);
		loginDataMap.put("password", xx[1]);
		loginDataMap.put("supname", xx[2]);
		
		Reporter.log("-------------------------------Test Creds for browser :"+browser+"," + xx[0] + ",Password :" + xx[1]+"------------------",true);

		return loginDataMap;
	}
	
	public void quitBrowser() {
		driver.close();
		driver.quit();
		/*try {
			stopRecording();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
	
	public void waitForTime(int i) {
		try {
			Thread.sleep(i);
		} catch (Exception e) {

		}
	}

	public void waitForTime(long i) {
		try {
			Thread.sleep(i);
		} catch (Exception e) {

		}
	}

	public boolean switchtoFrame(WebElement element) {
		boolean flag = true;
		driver.switchTo().defaultContent();
		if (element != null) {
			fluentwait(element);
			driver.switchTo().frame(element);
			//waitForTime(3000);
			exception();
		}

		waitForTime(3000);
		return flag;
	}
	
	/**
	 * Frame within a frame
	 * @param element
	 * @return
	 */
	public boolean switchFrame(WebElement element) {
		boolean flag = true;
		if (element != null) {
			fluentwait(element);
			driver.switchTo().frame(element);
			//waitForTime(3000);
			exception();
		}

		waitForTime(3000);
		return flag;
	}

	
	/**
	 * Contains Dropdown Method <Replica of Select Value from Dropdown
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
						//Bcz login email some time we pass it as Lowercase and in app it is uppercase.
						app=app.toLowerCase();
						exvalue=exvalue.toLowerCase();
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
	 * NwselectvalueFrmDpdn this method used for new pages like task tracker page
	 * 
	 * 
	 * Prioirty: 1 for Direct Equals
	 * Priority: 2 Containsvaluefromdropdwn
	 * Priority 3 :Same Frame drpdown
	 * 
	 * 
	 * @author Piramanayagam.S
	 */
	public String NwselectvalueFrmDpdn(String exvalue) {
		String selectedValue = null;
		switchtoFrame(null);
		if (exvalue.length() > 0) {
			
			List<WebElement> el = driver.findElements(By.cssSelector("div[style*='block'] li[role='presentation'] a"));
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
									click(driver.findElement(By.cssSelector("li:nth-child(" + i + ") a")));
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
									el = driver.findElements(By.cssSelector("div[class*='active'] div[class*='drop'] li"));
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
	 * NwselectvalueFrmDpdn this method used for new pages like task tracker page
	 * 
	 * 
	 * Prioirty: 1 for Direct Equals
	 * Priority: 2 Containsvaluefromdropdwn
	 * Priority 3 :Same Frame drpdown
	 * 
	 * 
	 * @author Piramanayagam.S
	 */
	public String NwselectvalueFrmDpdn2(String exvalue) {
		String selectedValue = null;
		switchtoFrame(null);
		if (exvalue.length() > 0) {
			
			List<WebElement> el = driver.findElements(By.cssSelector("div[class*='dropd'] li[ng-repeat]"));
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
								el = driver.findElements(By.cssSelector("li:nth"));
							
								int in=0;
								System.out.println("Basic Click,el:"+el.size());
								
								while(el.size()>0 && in<=10){
									//	clickJavaScript(el.get(i));
									Actions action = new Actions(driver).click(el.get(i));
									action.build().perform();
									in++;
									System.out.println("Action Click for DP:"+in+",el:"+el.size());
									el = driver.findElements(By.cssSelector("div[class*='active'] div[class*='drop'] li"));
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
	 * NwselectvalueFrmDpdn this method used for new pages like task tracker page
	 * 
	 * 
	 * Prioirty: 1 for Direct Equals
	 * Priority: 2 Containsvaluefromdropdwn
	 * Priority 3 :Same Frame drpdown
	 * 
	 * 
	 * @author Piramanayagam.S
	 */
	public String NwselectvalueFrmDpdn1(String exvalue) {
		String selectedValue = null;
		switchtoFrame(null);
		if (exvalue.length() > 0) {
			
			List<WebElement> el = driver.findElements(By.cssSelector("div[style*='block'] li [title*='"+exvalue+"']"));
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
									click(driver.findElement(By.cssSelector("li:nth-child(" + i + ") a")));
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
								el = driver.findElements(By.cssSelector("div[style*='block'] li [title*='"+exvalue+"']"));
							
								
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
	    * NwselectvalueFrmDpdn this method used for new pages like task tracker page
	    * 
	     * 
	     * Prioirty: 1 for Direct Equals
	    * Priority: 2 Containsvaluefromdropdwn
	    * Priority 3 :Same Frame drpdown
	    * 
	     * 
	     * @author Piramanayagam.S
	    */
	    public String NwselectvalueFrmDpdnValue(String exvalue) {
	           String selectedValue = null;
	           switchtoFrame(null);
	           if (exvalue.length() > 0) {
	                  List<WebElement> el = driver.findElements(By.cssSelector("pop-up div[ng-style*='block'] div[class*='item ng-binding']"));
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
	                                                           click(driver.findElement(By.cssSelector("li:nth-child(" + i + ")")));
	                                                    }
	                                                    selectedValue = app;
	                                                    break;
	                                             }
	                                      }
	                                      if (app.equalsIgnoreCase(exvalue)) {
	                                             try {
	                                                    el.get(i).click();
	                                             } catch (Exception e) {
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
	public String selectvalueFrmDpdn(String exvalue) {
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
									el = driver.findElements(By.cssSelector("div[class*='active'] div[class*='drop'] li"));
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
	 * Replica of Select Value from Dropdown
	 * 
	 * Difference is there is Scroll to View and Click
	 * 
	 * 
	 * @author Piramanayagam.S
	 */
	public String ScrollselectvalueFrmDpdn(String exvalue) {
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
								click(el.get(i));
								//el.get(i).click();
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
	 * Replica of Select Value from Dropdown
	 * 
	 * Difference is there is no action clicks
	 * 
	 * 
	 * @author Piramanayagam.S
	 */
	public String selectValueFrmdropdown(String exvalue) {
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
							/*  Can be deleted used in inviting org invite customer
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
								}*/
								
								
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
	 * selectvalueFrmDpdn is diff with other method where we pass the element,
	 *  in some case it is required.
	 * 
	 * 
	 * Prioirty: 1 for Direct Equals
	 * Priority: 2 Containsvaluefromdropdwn
	 * Priority 3 :Same Frame drpdown
	 * Prioirty 4  :selectvalueFrmDpdn with Eleement
	 * 
	 * 
	 * @author Piramanayagam.S
	 */
	public String selectvalueFrmDpdn(String exvalue,String element) {
		String selectedValue = null;
		switchtoFrame(null);
		if (exvalue.length() > 0) {
			List<WebElement> el = driver.findElements(By.cssSelector(element));
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
									click(driver.findElement(By.cssSelector(element+":nth-child(" + i + ")")));
								}
								selectedValue = app;
								break;
							}
						}
						if (app.equalsIgnoreCase(exvalue)) {
							try {
								click(el.get(i));
								el = driver.findElements(By.cssSelector(element));
							
							} catch (Exception e) {
							
							}
							selectedValue = exvalue;
							break;
						}
					}
				
				}
			
			}

		}
		return selectedValue;

	}
	
	/** selectvalueFrmDpdn is diff with other method where we pass the element,
	 *  in some case it is required.
	 * 
	 * 
	 * Prioirty: 1 for Direct Equals
	 * Priority: 2 Containsvaluefromdropdwn
	 * Priority 3 :Same Frame drpdown
	 * Prioirty 4  :selectvalueFrmDpdn with Eleement
	 * 
	 * 
	 * @author Piramanayagam.S
	 */
	public String selectvalueFrmDpdnXpath(String exvalue,String element) {
		String selectedValue = null;
		switchtoFrame(null);
		if (exvalue.length() > 0) {
			List<WebElement> el = driver.findElements(By.xpath(element));
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
									click(driver.findElement(By.cssSelector(element+":nth-child(" + i + ")")));
								}
								selectedValue = app;
								break;
							}
						}
						if (app.equalsIgnoreCase(exvalue)) {
							try {
								click(el.get(i));
								el = driver.findElements(By.cssSelector(element));
							
								int in=0;
								System.out.println("Basic Click,el:"+el.size());
								
								while(el.size()>0 && in<=10){
									//	clickJavaScript(el.get(i));
									Actions action = new Actions(driver).click(el.get(i));
									action.build().perform();
									in++;
									System.out.println("Action Click for DP:"+in+",el:"+el.size());
									el = driver.findElements(By.cssSelector(element));
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

	/** selectvalueFrmDpdn is diff with other method where we pass the element,
	 *  in some case it is required.
	 * 
	 * 
	 * Prioirty: 1 for Direct Equals
	 * Priority: 2 Containsvaluefromdropdwn
	 * Priority 3 :Same Frame drpdown
	 * Prioirty 4  :selectvalueFrmDpdn with Eleement
	 * 
	 * 
	 * @author Piramanayagam.S
	 */
	public String selectvalueFrmDpdnXpathAttribute(String exvalue,String element) {
		String selectedValue = "";
		switchtoFrame(null);
		if (exvalue.length() > 0) {
			List<WebElement> el = driver.findElements(By.xpath(element));
			System.out.println("DP SIZE " + el.size());
			if(el.size()>0){
				
				String app = el.get(0).getAttribute("value");
				System.out.println("Default Dp Value,"+app+",Expected:"+exvalue);
				//if(!app.equalsIgnoreCase(exvalue))
				{
					for (int i = el.size() - 1; i >= 0; i--) {
						app = el.get(i).getAttribute("value");
						System.out.println(i+":"+app+":APP,EXP:"+exvalue);
						if (exvalue.equalsIgnoreCase("any")) {
							if (!app.contains("Select")) {
								try {
									click(el.get(i));
								} catch (Exception e) {
									click(driver.findElement(By.cssSelector(element+":nth-child(" + i + ")")));
								}
								selectedValue = app;
								break;
							}
						}
						if (app.equalsIgnoreCase(exvalue)) {
							try {
								click(el.get(i));
								selectedValue = exvalue;
							} catch (Exception e) {

							}
							
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
	 * selectvalueFrmDpdnAction 
	 * 
	 * 
	 * Prioirty: 1 for Direct Equals
	 * Priority: 2 Containsvaluefromdropdwn
	 * Priority 3 :Same Frame drpdown
	 * 
	 * 
	 * @author Piramanayagam.S
	 */
	public String selectvalueFrmDpdnAction(String exvalue) {
		String selectedValue = null;
		switchtoFrame(null);
		if (exvalue.length() > 0) {
			List<WebElement> el = driver.findElements(By.cssSelector("drop-down ul li input"));
			System.out.println("DP SIZE " + el.size());
			if(el.size()>0){
				
				String app = el.get(0).getAttribute("value");
				System.out.println("Default Dp Value,"+app+",Expected:"+exvalue);
				//if(!app.equalsIgnoreCase(exvalue))
				{
					for (int i =0; i <el.size(); i++) {
						app = el.get(i).getAttribute("value");
						System.out.println(i+":"+app+":APP,EXP:"+exvalue);
						if (exvalue.equalsIgnoreCase("any")) {
							if (!app.contains("Select")) {
								try {
									click(el.get(i));
								} catch (Exception e) {
									click(driver.findElement(By.cssSelector("drop-down ul li:nth-child(" + i + ") input")));
								}
								selectedValue = app;
								break;
							}
						}
						if (app.equalsIgnoreCase(exvalue)) {
							try {
								el.get(i).click();
								
							} catch (Exception e) {

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
			List<WebElement> el = driver.findElements(By.cssSelector("div[class*='chosen-drop'] li"));
			System.out.println("DP SIZE " + el.size());

			for (int i = el.size() - 1; i >= 0; i--) {
				String app = el.get(i).getText();
				System.out.println(app + "APP : EXP " + exvalue);
				if (exvalue.equalsIgnoreCase("any")) {
					if (!app.contains("Select")) {
						try {
							click(el.get(i));
						} catch (Exception e) {
							click(driver.findElement(By.cssSelector("div[class*='chosen-drop'] li:nth-child(" + i + ")")));
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
							el = driver.findElements(By.cssSelector("div[class*='active'] div[class*='chosen-drop'] li"));
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
				System.out.println(app + ",APP&EXP," + exvalue);
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
						if(el.size()>0){
							//	clickJavaScript(el.get(i));
							Actions action = new Actions(driver).click(el.get(i));
							action.build().perform();

							//el = driver.findElements(By.cssSelector("div[class*='drop'] li"));
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
		fluentwait(e);
		try {
			Scrollintoview(e);
			e.click();
			exception();
		} catch (Exception ex) {
			Scrollintoview(e);
			clickJavaScript(e);
		}
	}

	public void clicks(WebElement e) {
		fluentwait(e);
		try {
			e.click();
		} catch (Exception ex) {
			clickJavaScript(e);
		}
	}
	
	public String getText(String objNameStr, WebElement objName) {

		String str;

		try {
			str = objName.getText();
			Report.info(objNameStr + " is returns " + str);
			return str;
		} catch (Exception e) {
			Report.info(objNameStr + " is not displayed");
			Assert.fail(objNameStr + " is not displayed");
			return null;
		}

	}

	/**
	 * ScrollUp 250 Px
	 * @author Piramanayagam.S
	 */
	public void scrollup() {
		 ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, -250)");
	}

	/**
	 * ClickJAVASCript-- Method to Click for Javascript
	 * @author Piramanayagam.S
	 * @param e
	 */
	public void clickJavaScript(WebElement e) {
		fluentwait(e);
		clickJavaScriptNoWait(e);
	}
	
	/**
	 * Click Method with JavaScript but without wait time
	 * @author Piramanayagam.S
	 */
	public void clickJavaScriptNoWait(WebElement e) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		try {
			executor.executeScript("arguments[0].click();", e);
		} catch (Exception ex) {
			Scrollintoview(e);
			executor.executeScript("arguments[0].click();", e);
		}

	}
	
	/**
	 * Move To Element
	 * 
	 * @author Piramanayagam.S
	 * @param e
	 * @return
	 */
	public void moveToElement(WebElement e) {
		Actions oAction = new Actions(driver);
		oAction.moveToElement(e).build().perform();;
	}
	

	public void rightclickOpen(WebElement e) {

		try {
			Actions oAction = new Actions(driver);
			oAction.moveToElement(e);
			oAction.contextClick(e).build()
					.perform(); /* this will perform right click */
			WebElement elementOpen = driver.findElement(By.linkText(
					"Open")); /* This will select menu after right click */

			elementOpen.click();
		} catch (Exception ex) {
			clickJavaScript(e);
		}

	}

	public int typeinEdit(String totype, WebElement e) {
		int amnt = 0;
		fluentwait(e);
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
		fluentwait(e);
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
			upload.sendKeys(file);
		} else {
			String file = getPresentWorkingDir() + File.separator + dir + File.separator + toselect;
			upload.sendKeys(file);
		}
	}

	public void selectChckbx(WebElement element) {

		click(element);
	}

	public void selectChkBox(WebElement element, String flag) {
		if ("yes".equalsIgnoreCase(flag)) {
			if (!element.isSelected())
				clickJavaScriptNoWait(element);
		} else if ("no".equalsIgnoreCase(flag)) {
			if (element.isSelected())
				clickJavaScriptNoWait(element);
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
		int timeoutSeconds = 80;
		boolean flagreturn=false;
		boolean x=exception();
		
		if(x!=false){
			loaderIcon();
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
		}
		/*	String endtime=currenttime();
		Reporter.log("FLUENT WAIT END:"+endtime,true);
		Integer xx=Integer.parseInt(starttime);
		Integer y=Integer.parseInt(endtime);
		Integer z=y-xx;
		Reporter.log("WAITED For:"+z); */
		return flagreturn;
	}
	
	/**
	 * To get the Options 
	 * 
	 * @author Vidya.C
	 * @param e
	 * @return
	 */
	public List<WebElement> getOptions(WebElement e) {
		Select s = new Select(e);
		List<WebElement> options = s.getOptions();
		return options;
	}
	
	public void selectbyNumber(int toselect, WebElement element) {
		try {
			Select s = new Select(element);
			s.selectByIndex(toselect);

		} catch (Exception e) {
			selectmultiselect(""+toselect,element);
			//Assert.assertFalse(true, "Failed in Select By Visible Text for the element: " + e.toString());
		}
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

	public void selectbyvalue(String toselect, WebElement element) {
		try {
			Select s = new Select(element);
			s.selectByValue(toselect);

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
		//	Assert.assertFalse(true, "Failed in Select By Visible Text for the element: " + e.toString());
			List<WebElement> options =   driver.findElements(By.xpath(".//option[normalize-space(.) = '"+toselect+"']"));
			
			for (WebElement option : options) {
				 clicks(option);
	    	}
		}
	}

	public void takeScreenshot() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile,
				new File(getPresentWorkingDir() + File.separator + dir + File.separator + randomnum() + ".png"));
	}

	public void Scrollintoview(WebElement e) {
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", e);
			waitForTime(3000);
		} catch (Exception ex) {
			
		}
	}

	public void refreshPage() {
		driver.navigate().refresh();
	}

		/*
	public DesiredCapabilities DesiredCapablity(String browser) {
		DesiredCapabilities caps = new DesiredCapabilities();
		if (browser.equalsIgnoreCase("firefox")) {
			caps = DesiredCapabilities.firefox();
		//	caps.setBrowserName("firefox");
			caps.setCapability("marionette", true);
			
		} else if (browser.equalsIgnoreCase("chrome")) {
			caps = DesiredCapabilities.chrome();
			caps.setBrowserName("chrome");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");
			options.addArguments("--test-type");
			caps.setCapability(ChromeOptions.CAPABILITY, options);
		} else if (browser.equalsIgnoreCase("internet explorer")) {
			System.out.println("AS");
			caps = DesiredCapabilities.internetExplorer();
			caps.setBrowserName("internet explorer");
			caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			caps.setCapability("ignoreZoomSetting", true);
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
*/

	/*
	public void launchAppFromPOM(String Platform, String browser, String Version) throws IOException {
		System.out.println(Platform + browser + Version);
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
			caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
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
		if (strRemoteExec != null) {
			if (strRemoteExec.equalsIgnoreCase("true")) {
				strRemoteExec = System.getProperty("RemoteExecution");
				String strRemoteURL = System.getProperty("RemoteURL");

				URL remoteAddress = new URL(strRemoteURL + "/wd/hub");
				driver = new RemoteWebDriver(remoteAddress, caps);
				((RemoteWebDriver) driver).setFileDetector(new LocalFileDetector());
			} else {
				if (browser.equalsIgnoreCase("firefox")) {
					System.setProperty("webdriver.firefox.marionette",
							getPresentWorkingDir() + System.getProperty("TestData") + File.separator + "geckodriver.exe");
					driver = new FirefoxDriver(caps);
				} else if (browser.equalsIgnoreCase("chrome")) {
					System.setProperty("webdriver.chrome.driver",
							getPresentWorkingDir() + System.getProperty("TestData") + File.separator + "ChromeDriver.exe");
					driver = new ChromeDriver(caps);
				} else if (browser.equalsIgnoreCase("internet explorer")) {
					System.setProperty("webdriver.ie.driver",
							getPresentWorkingDir() + System.getProperty("TestData") + File.separator + "IEDriverServer.exe");
					driver = new InternetExplorerDriver(caps);
				}
			}
		} else {
			if (browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.firefox.marionette",
						getPresentWorkingDir() + System.getProperty("TestData") + File.separator + "geckodriver.exe");
				driver = new FirefoxDriver();
			} else if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						getPresentWorkingDir() + System.getProperty("TestData") + File.separator + "ChromeDriver.exe");
				driver = new ChromeDriver(caps);
			} else if (browser.equalsIgnoreCase("internet explorer")) {
				System.setProperty("webdriver.ie.driver",
					getPresentWorkingDir() + System.getProperty("TestData") + File.separator + "IEDriverServer.exe");
				driver = new InternetExplorerDriver(caps);
			}
		}

	}
*/
	public boolean exception(){
		boolean flag=true;
		String x=driver.getPageSource();
		if(x.contains("Access Denied")||(x.contains("Internal Server"))){
			flag=false;
			Reporter.log("Page contains Access Denied",true);
			driver.navigate().back();
			refreshPage();
			Assert.assertTrue(false,"Please Fix the internal server Error, The Test Failed ,so Please Fix:"+x);
		}
		return flag;
	}
	
	public boolean verifyElementDisplayed(String objNameStr, WebElement objName) {

		try {
			fluentwait(objName);
			objName.isDisplayed();
			Report.pass(objNameStr + " is displayed");
			return true;

		} catch (Exception e) {
			exception();
			//Report.fail(objNameStr + " is not displayed");
			Reporter.log(objNameStr + " is not displayed");
			return false;
		}

	}

	public void keyTab(WebElement locator) {
		try {
			locator.sendKeys(Keys.TAB);

		} catch (Exception e) {
			Assert.assertTrue(false,"Exception in the method keyTab for the element " + locator + " due to  " + e.getMessage());
		}
	}

	/**
	 * Method Name : navigateTo_Back_Frwrd_Page Purpose: Method for
	 * navigateTo_Back_Frwrd_Page
	 * 
	 * @param: mDriver,identifyBy,locator
	 * @return None
	 */
	public void navigateTo_Back_Frwrd_Page(WebDriver mDriver, String operation) {
		try {
			waitForTime(1500);
			if (operation.equalsIgnoreCase(ConfigPathFile.BACKPAGE.getConstantValue())) {
				mDriver.navigate().back();
			} else if (operation.equalsIgnoreCase(ConfigPathFile.FORWARDPAGE.getConstantValue())) {
				mDriver.navigate().forward();
			} else if (operation.equalsIgnoreCase(ConfigPathFile.REFRESH.getConstantValue())) {
				mDriver.navigate().refresh();
			}
		} catch (Exception e) {
			// log.severe(" Exception occured in the method
			// navigateTo_Back_Frwrd_Page "
			// + e.getMessage());
			Assert.assertTrue(false, " Exception occured in the method navigateTo_Back_Frwrd_Page " + e.getMessage());
		}
	}

	public void navigateTo_Back_Frwrd_Page(String operation) {
		try {
			waitForTime(1500);
			if (operation.equalsIgnoreCase(ConfigPathFile.BACKPAGE.getConstantValue())) {
				driver.navigate().back();
			} else if (operation.equalsIgnoreCase(ConfigPathFile.FORWARDPAGE.getConstantValue())) {
				driver.navigate().forward();
			} else if (operation.equalsIgnoreCase(ConfigPathFile.REFRESH.getConstantValue())) {
				driver.navigate().refresh();
			}
		} catch (Exception e) {
			// log.severe(" Exception occured in the method
			// navigateTo_Back_Frwrd_Page "
			// + e.getMessage());
			Assert.assertTrue(false, " Exception occured in the method navigateTo_Back_Frwrd_Page " + e.getMessage());
		}
	}

	/**
	 * Method Name : PressEnterkey Purpose: Method for Enter key Operation
	 * 
	 * @param: mDriver,identifyBy,locator
	 * @return None
	 */
	public void pressEnterkey(String strLocator, WebElement Objlocator) {
		try {

			// web_Element = isWebElementExists(mDriver, identifyBy, locator);
			Objlocator.sendKeys(Keys.ENTER);

		} catch (Exception e) {
			// log.severe("Exception in the method pressEnterkey for the element
			// "
			// + locator + " due to " + e.getMessage());
			Assert.assertTrue(false, "Exception in the method pressEnterkey for the element " + strLocator + " due to  "
					+ e.getMessage());
		}
	}

	/**
	 * Method Name : assertPageTitle Purpose: Method for assertPageTitle
	 * 
	 * @param: mDriver,expectedPageTitle
	 * @return None
	 */
	public boolean assertPageTitle(String expectedPageTitle) {
		String actualPageTitle = "";
		waitForTime(2000);
		actualPageTitle = driver.getTitle().trim().toString();
		expectedPageTitle = expectedPageTitle.trim().toString();
		if (actualPageTitle.contains(expectedPageTitle)) {
			return true;
		} else
			// log.severe("Expected page doesn't displayed " + " Actual title: "
			// + actualPageTitle + " Expected title: " + expectedPageTitle);
			Assert.assertTrue(false,
					"  Actual page title:    " + actualPageTitle + "    Expected page title:    " + expectedPageTitle);
		return false;
	}

	/**
	 * Method Name : compareText Purpose: Method for compare the given Text
	 * 
	 * @param: mDriver,expectedText,identifyBy,locator
	 * @return boolean value
	 */
	public boolean compareText(WebElement e, String expectedText) {
		String actualText = "";
		actualText = getText(e);
		Reporter.log("ActualText: " + actualText);
		if (actualText.trim().toLowerCase().toString().contains(expectedText.trim().toLowerCase().toString())) {
			return true;
		} else
			return false;
	}

	public boolean compareValue(String actual, String expected) {

		try {
			Assert.assertEquals(actual.trim(), expected.trim());
			Report.pass("Actual : " + actual + ", Expected :" + expected);
			return true;
		} catch (Exception e) {

			Report.fail("Actual : " + actual + ", Expected :" + expected);
			return false;
		}

	}

	/**
	 * Method Name : getText Purpose: Method for getText value
	 * 
	 * @param: mDriver,identifyBy,locator
	 * @return None
	 */
	public String getText(WebElement web_Element) {
		String str_Text = "";
		try {
			str_Text = web_Element.getText();
			str_Text = str_Text.toString().trim();
		} catch (Exception e) {
			// log.severe("Exception in the method getText for the element "
			// + locator + " due to " + e.getMessage());
		}
		return str_Text;
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
	 * Method Name : handleChildWindow Purpose: Method for getChildWindow handle
	 * 
	 * @param: mDriver,flag
	 * @return None
	 */

	@SuppressWarnings("unused")
	public void handleFirstChildWindow(WebDriver mDriver, boolean flag) {
		String parentBrowser = "";
		String childBrowser = "";
		WebDriver popup = null;
		waitForTime(2000);
		try {
			parentBrowser = mDriver.getWindowHandle();
			System.out.println("PARENT" + parentBrowser);
			Iterator<String> itr = mDriver.getWindowHandles().iterator();
			if (flag) {
				while (itr.hasNext()) {
					childBrowser = itr.next();
					popup = mDriver.switchTo().window(childBrowser);
					System.out.println(popup);
				}
			} else {
				mDriver.close();
				parentBrowser = itr.next();
				mDriver.switchTo().window(parentBrowser);
			}
		} catch (Exception e) {
			// log.severe("Exception in handleChildWindow due to "
			// + e.getMessage());
			Assert.assertTrue(false, "Exception in method handleChildWindow due to " + e.getMessage());
		}
	}

	@SuppressWarnings("unused")
	public void handleFirstChildWindow(boolean flag) {
		String parentBrowser = "";
		String childBrowser = "";
		WebDriver popup = null;
		waitForTime(2000);
		parentBrowser = driver.getWindowHandle();
		Iterator<String> itr = driver.getWindowHandles().iterator();
		if (flag) {
			while (itr.hasNext()) {
				childBrowser = itr.next();
				popup = driver.switchTo().window(childBrowser);
				System.out.println(popup);
			}
		} else {
			driver.close();
			parentBrowser = itr.next();
			driver.switchTo().window(parentBrowser);
		}
		
	}

	/**
	 * Method Name : handlePopUpWindow Purpose: Method for handlePopUpWindow
	 * 
	 * @param: mDriver,identifyBy,identifyBy,pagePartialURL
	 * @return None
	 */
	public String[] handlePopUpWindow(String page, String switchWith) {
		String parentWindow = null;
		String rtnHandle = "";
		try {
			parentWindow = driver.getWindowHandle();
			for (String winHandled : driver.getWindowHandles()) {
				if (!winHandled.equals(parentWindow)) {
					if (switchWith.equalsIgnoreCase(ConfigPathFile.TITLE.getConstantValue())) {
						waitForTime(2000);
						if (driver.switchTo().window(winHandled).getTitle().endsWith(page)) {
							rtnHandle = winHandled;
							break;
						}
					} else if (switchWith.equalsIgnoreCase(ConfigPathFile.URL.getConstantValue())) {
						if (driver.switchTo().window(winHandled).getCurrentUrl().endsWith(page)) {
							rtnHandle = winHandled;
							break;
						}
					}
				}
			}
			waitForTime(2000);
		} catch (Exception ex) {
			// log.severe("Exception In the method handlePopUpWindow due to "
			// + ex.getMessage());
			Assert.assertTrue(false, "Exception In the method handlePopUpWindow due to  " + ex.getMessage());
		}
		String[] rtn_WinHandles = { parentWindow, rtnHandle };
		return rtn_WinHandles;
	}

	/**
	 * Method Name : switchToParentWindow Purpose: Method for
	 * switchToParentWindow
	 * 
	 * @param: mDriver,index
	 *             of Array
	 * @return None
	 */
	public void switchToParentWindow(String[] index) {
		driver.switchTo().window(index[0]);
	}

	/**
	 * Method Name : closeChildWindow Purpose: Method for closeChildWindow
	 * 
	 * @param: mDriver,index
	 *             of Array
	 * @return None
	 */
	public void closeChildWindow(String[] index) {
		driver.switchTo().window(index[1]).close();
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
			//Assert.assertTrue(false, "MethodName: getValue :: Exception occured for locator ");
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
				value = option.getText().toString().trim();
				text = text.toString();
				if(text.equalsIgnoreCase("ANY")){
					if (!value.contains("Select")){
						text=value;
					}
				}
				if (text.equalsIgnoreCase(value)) {
					option.click();
					isSelected = true;
					break;
				}
			}

			if (!isSelected == true) {
				Assert.assertTrue(false,"Test is failed due to given value: " + text + " is not available in the drop down list");
			}

		} catch (Exception e) {
		}
	}

	public boolean isElementDisplayed(WebElement e) {
		boolean flag = false;
		try {
			e.isDisplayed();
			flag = true;
		} catch (NoSuchElementException ex) {
			flag = false;
		}
		return flag;
	}

	public boolean isElementDisplayed(String e) {
		boolean flag = false;
		try {
			WebElement el=driver.findElement(By.xpath(e));
			el.isDisplayed();
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

	/**
	 * Method Name : isAlertPresent Purpose: Method for isAlertPresent
	 * 
	 * @param: driver,pageTitle
	 * @return None
	 */
	@SuppressWarnings("unused")
	public void isAlertPresent(String perform) {
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

	/**
	 * Method Name : typeinEditbox Purpose: Method for typeinEditbox
	 * 
	 * @param: mDriver,identifyBy,identifyBy,locator,valuetoType
	 * @return None
	 */
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

	public String getSystemTimeStamp() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MMMddhmmssa");
		String getTimeStamp = sdf.format(date);
		return getTimeStamp;
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
	 * Method Name : getEmail Purpose: Public method which includes logic
	 * related to return the concatenate email with current date
	 * 
	 * @param: None
	 * @return: None
	 */
	public String getEmail(String sEmail) {
		String email = "";
		SimpleDateFormat sdfDate = new SimpleDateFormat("MMddHHmmss");
		Date now = new Date();
		String strDate = sdfDate.format(now);
		String[] actualEmail = sEmail.split("@");
		email = actualEmail[0] + strDate + "@" + actualEmail[1];
		return email;
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

	public void click(String objNameStr, WebElement objName) {

		try {
			objName.click();

			Report.pass("'" + objNameStr + "'" + " is clicked");

		} catch (Exception e) {

			Report.fail("'" + objNameStr + "'" + " is not clicked");

		}

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

	/**
	 * Random Num Generator based on the Range
	 * 
	 * @author Piramanayagam.S
	 * @param i
	 * @return integer
	 */
	public static int randomnum(int i) {

		int rand = 0;
		if(i==1||i==0){
			rand=0;
		}else{
			Random r = new Random();
			while (rand == 0) {
				rand = r.nextInt(i);
			}
		}

		return rand;
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
	 * Randomnum Generator from Currenttime on a Diff Format
	 * 
	 * @author Piramanayagam.S
	 * @param null
	 * @return String , time
	 */
	public static String randomnumFmt() {

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HHmm");
		Calendar cal = Calendar.getInstance();  //2019-01-08_1201
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
		String x=driver.getCurrentUrl();
		String y="";
		if(x.contains("simdev")){
			y="Auto";
		}else if(x.contains("simqa.westus2")){
			y="QAAzure";
		}else if(x.contains("qasim")){
			y="QA";
		}else if(x.contains("simconfqaprod")){
			y="SIMCONF";
		}else if(x.contains("simstaging")){
			y="StagingAzure";
		}else if(x.contains("stagesim")){
			//For Grace	
			y="Prod";
		}else {
			//For Staging / for Production
			y="Prod";
		}
				
		String dbUrl = InitProperties("sim.dbURL"+"."+y);
		String dbUser = InitProperties("sim.dbUser"+"."+y);
		String dbPass = InitProperties("sim.dbPass"+"."+y);
		int port = Integer.parseInt(InitProperties("sim.dbport"+"."+y));
		String dbName = InitProperties("sim.dbName"+"."+y);

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
	 * 
	 * Created for Executing any procedure,Method will return the conncection
	 * 
	 * 
	 */
	public Connection ConnectDB1() throws FileNotFoundException, IOException {
		String x=driver.getCurrentUrl();
		String y="";
		if(x.contains("simdev")){
			y="Auto";
		}else if(x.contains("simqa.westus2")){
			y="QAAzure";
		}else if(x.contains("qasim")){
			y="QA";
		}else if(x.contains("simconfqaprod")){
			y="SIMCONF";
		}else {
			//For Staging / for Production
			y="Prod";
		}
		
				
		String dbUrl = InitProperties("sim.dbURL"+"."+y);
		String dbUser = InitProperties("sim.dbUser"+"."+y);
		String dbPass = InitProperties("sim.dbPass"+"."+y);
		int port = Integer.parseInt(InitProperties("sim.dbport"+"."+y));
		String dbName = InitProperties("sim.dbName"+"."+y);

		try {
			SQLServerDataSource ds = new SQLServerDataSource();
			ds.setUser(dbUser);
			ds.setPassword(dbPass);
			ds.setServerName(dbUrl);
			ds.setPortNumber(port);
			ds.setDatabaseName(dbName);
			con = (SQLServerConnection) ds.getConnection();
		//	stmt = (SQLServerStatement) con.createStatement();

		} catch (Exception e) {
		}

		return con;
	}
	
	/**
	 * Connect DB -Connect DB Platform
	 * 
	 * @author Piramanayagam.S
	 * @return Statement
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public Statement ConnectPlatformDB() throws FileNotFoundException, IOException {
		String x=driver.getCurrentUrl();
		String y="";
		if(x.contains("simdev")){
			y="Auto";
		}else if(x.contains("simqa.westus2")){
			y="QAAzure";
		}else if(x.contains("qasim")){
			y="QA";
		}else if(x.contains("simstaging")){
			y="StagingAzure";
		}else if(x.contains("simconfqaprod")){
			y="SIMCONF";
		}else {
			//For Staging / for Production
			y="Prod";
		}
				
		String dbUrl = InitProperties("sim.dbURL"+"."+y);
		String dbUser = InitProperties("sim.dbUser"+"."+y);
		String dbPass = InitProperties("sim.dbPass"+"."+y);
		int port = Integer.parseInt(InitProperties("sim.dbport"+"."+y));
		String dbName = InitProperties("simplatform.dbName"+"."+y);
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
		}
		CloseDB();

		return result;
	}
	
	/**
	 * FetchDBdata run query in the SQL for Platform
	 * 
	 * @author Piramanayagam.S
	 * @param query
	 * @return String ,single value from Database
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @throws SQLException
	 */
	public  String fetchDBdataPlatform(String query) throws FileNotFoundException, IOException, SQLException {

		String result = null;

		stmt = ConnectPlatformDB();
		rs = null;
		rs = (SQLServerResultSet) stmt.executeQuery(query);
		while (rs.next()) {
			result = rs.getString(1);
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
		}
		CloseDB();

		return result;
	}

	public void dataBaseCheck(String query, String expected) throws FileNotFoundException, IOException, SQLException {
		String data = null;

		try {

			data = fetchDBdata(query);
			compareValue(data, expected);

			Report.pass("Expected : " + data + ", Actual" + expected);
		} catch (Exception e) {

			Report.fail("Expected : " + data + ", Actual" + expected);
		}

	}

	/**
	 * Update DB with the given Query Platform
	 * 
	 * @author Piramanayagam.S
	 * @param Query
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @throws SQLException
	 */
	public  int UpdatePlatformDB(String Query) throws FileNotFoundException, IOException, SQLException {

		Statement stmt = ConnectPlatformDB();
		int rs = stmt.executeUpdate(Query);
		CloseDB();
		return rs;

	}
	
	/**
	 * Update DB with the given Query
	 * 
	 * @author Piramanayagam.S
	 * @param Query
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @throws SQLException
	 */
	public  int UpdateDB(String Query) throws FileNotFoundException, IOException, SQLException {

		Statement stmt = ConnectDB();

		int rs = stmt.executeUpdate(Query);
		System.out.println("QUERY:" + Query);
		CloseDB();
		return rs;

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
	 * getCustomIDQuery method for getting the Custom field ID from Database
	 * 
	 * @author Piramanayagam.S
	 * @param UTFString,Page
	 * @param page
	 * @return
	 * @throws IOException
	 */
	public  String getCustomIDQUERY(String UTFString, String page, String CustomerID) throws IOException {
		String id = "";

		String query = "select UIFieldId FROM CFE_Definition as c where c.Label_i18nKey in "
				+ "(select i18nKey from UserTranslation where LanguageID='50'  and " + "UTFString like '%" + UTFString
				+ "%')  and CFE_PageInfoID='" + page + "' and CustomerID=" + CustomerID;
		try {
			id = fetchDBdata(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return id;
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
		wb.close();
		fs.close();
		
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
				String pwds="";
				
				if (pwd != null) {
					pwd.setCellType(Cell.CELL_TYPE_STRING);
					pwds = pwd.getStringCellValue();
				}
				

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
	 * To Read Email From GMAIL BOX
	 * 
	 * @author Piramanayagam.S
	 * @return
	 */
	public String Readmail() {

		String Subject = null;

		String SMTP_HOST_NAME = "pop.gmail.com";
		String SMTP_HOST_PORT = "995";
		final String SMTP_AUTH_USER = "simsupplierqa42@gmail.com";
		final String SMTP_AUTH_PWD = "lavante123";
		String SMTP_HOST_PROTOCAL = "ON";
		final String emailFromAddress = "simsupplierqa42@gmail.com";

		boolean isAuthenticationRequired = true;

		Properties props = new Properties();
		props.setProperty("mail.smtp.host", SMTP_HOST_NAME);
		props.setProperty("mail.smtp.port", SMTP_HOST_PORT);
		props.setProperty("mail.smtp.protocal", SMTP_HOST_PROTOCAL);

		props.put("mail.smtp.timeout", "60000");
		props.put("mail.smtp.connectiontimeout", "60000");
		props.put("mail.smtp.auth", "true");
		props.setProperty("mail.smtp.auth", Boolean.toString(isAuthenticationRequired));
		if (SMTP_AUTH_USER != null && !SMTP_AUTH_USER.trim().equals(""))

			props.setProperty("mail.smtp.username", SMTP_AUTH_USER);

		if (SMTP_AUTH_PWD != null && !SMTP_AUTH_PWD.trim().equals(""))

			props.setProperty("mail.smtp.password", SMTP_AUTH_PWD);
		try {
			Session session = Session.getInstance(props, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(emailFromAddress, SMTP_AUTH_PWD);
				}
			});
			try {

				System.out.println("CONNECTED to Mail Box");
			} catch (Exception e) {
				System.out.println("EX");
			}
			Store store = session.getStore("imaps");
			store.connect(SMTP_HOST_NAME, emailFromAddress, SMTP_AUTH_PWD);
			Folder inbox = store.getFolder("INBOX");

			System.out.println("Total Messages: " + inbox.getMessageCount());
			System.out.println("New Messages: " + inbox.getNewMessageCount());
			System.out.println("Unread Messages: " + inbox.getUnreadMessageCount());

			if (!(inbox.getNewMessageCount() > 0)) {
				try {
					waitForTime(4000);
				} catch (Exception e) {

				}
			}

			inbox.open(Folder.READ_ONLY);

			FlagTerm ft = new FlagTerm(new Flags(Flags.Flag.SEEN), false);
			Message message[] = inbox.search(ft);

			for (int i = 0; i <= message.length - 1; i++) {
				System.out.println(Subject + (i + 1) + ":" + message[i].getSubject() + "\n");

				if (message[i].getSubject().equalsIgnoreCase(Subject)) {
					Subject = message[i].getSubject();
				}

			}

		} catch (Exception mex) {
			mex.printStackTrace();
		}
		System.out.println(Subject);

		return Subject;

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
	 * To Create Copy of Any file
	 * 
	 * @author Piramanayagam.S
	 * @return
	 * @throws IOException
	 */
	public static String CopyFile(String orgfile,String nfile) throws IOException {
		System.out.println(orgfile);
		
		System.out.println("COPY:" + nfile);
		File srcfile = new File(getPresentWorkingDir() + File.separator + dir + File.separator + orgfile);
		File destfile = new File(getPresentWorkingDir() + File.separator + dir + File.separator + nfile);

		FileUtils.copyFile(srcfile, destfile);
		System.out.println("COPIED File:" + destfile);

		return nfile;
	}
	
	public static String ingestion(String Find) throws IOException {
		if(Find.contains("invoice")){
			String y= "kro_kro0064_2018-10-20_9940SING_invoice.txt";
			String[] nwfile = y.split("\\.");
			String x=nwfile[0];
			if(x.contains("_"+Find)){
				x=x.replace(Find, currenttime()+"_"+Find);
			}
			String nfile = x + "." + nwfile[1];
			Find=CopyFile(y,nfile);
		}else if(Find.contains("Liab")){
			String y= "kro_kro0064_2018-10-20_9940SING_Liab.txt";
			String[] nwfile = y.split("\\.");
			String x=nwfile[0];
			if(x.contains("_"+Find)){
				x=x.replace(Find, currenttime()+"_"+Find);
			}
			String nfile = x + "." + nwfile[1];
			Find=CopyFile(y,nfile);
		}else if(Find.contains("NCH")){
			String y= "kro_kro0132_2019-01-08_1201_Kroger_Deductions_20190107_NCH.txt";
			String[] nwfile = y.split("\\.");
			String x=nwfile[0];
			if(x.contains("2019-01-08_1201")){
				x=x.replace("2019-01-08_1201", randomnumFmt());
				//String yy=""+randomnum(9)+""+randomnum(9)+""+randomnum(9)+""+randomnum(9)+"-1"+randomnum(2)+"-"+""+randomnum(2)+""+randomnum(9);
				//x=x.replace("2019-01-08",yy);
			}
			String nfile = x + "." + nwfile[1];
			Find=CopyFile(y,nfile);
		}
		
		return Find;
		
	}
	
		/***
	 * To Edit CSV- First row will retain and Second row will be edited with the
	 * given value
	 * 
	 * @author Piramanayagam.S
	 * @param csvFile
	 * @param row
	 * @param value
	 */
	public static void editcsv(String csvFile, int row, String value) {

		if (value.contains(",")) {
			value = "\"" + value + "\"";
		}
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
		String[] fieldheader = null;
		String[] fieldValue = null;
		try {
			String file = getPresentWorkingDir() + File.separator + dir + File.separator + csvFile;
			System.out.println("Edit" + file);
			br = new BufferedReader(new FileReader(file));
			// Reading Header
			System.out.println("READ CSV");
			line = br.readLine();
			fieldheader = line.split(cvsSplitBy);
			for (int i = 0; i < fieldheader.length; i++) {

			}

			// Reading FirstLine Value
			line = br.readLine();
			fieldValue = line.split(cvsSplitBy);
			for (int i = 0; i < fieldValue.length; i++) {
			}

			System.out.println("EDIT CSV");
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			for (int i = 0; i < fieldheader.length; i++) {
				System.out.println(i + "VALUES:" + value);
				if (i == fieldheader.length - 1) {
					bw.write(fieldheader[i]);
				} else {
					bw.write(fieldheader[i]);
					bw.write(",");
				}
			}
			bw.newLine();

			for (int i = 0; i < fieldValue.length; i++) {
				if (i == fieldValue.length - 1 && i == row) {
					bw.write(value);
				}
				if (i == row && i < fieldValue.length - 1) {
					bw.write(value);
					bw.write(",");
				} else if (i != row) {
					bw.write(fieldValue[i]);
					bw.write(",");
				}
			}

			bw.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		System.out.println("Done");
	}

	/***
	 * To Edit CSV- First Header row will retain and Second Onwards row will be edited with the
	 * given value
	 * 
	 * @author Piramanayagam.S
	 * @param csvFile
	 * @param col
	 * @param value
	 */
	public static void editMultiRowcsv(String csvFile, int row,int col, String value) {
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
		String[] fieldheader = null;
		String[] fieldValue = null;
		try {
			String file = getPresentWorkingDir() + File.separator + dir + File.separator + csvFile;
			System.out.println("Edit" + file);
			br = new BufferedReader(new FileReader(file));
			// Reading Header
			System.out.println("READ CSV");
		/*	
			for (int i = 0; i < fieldheader.length; i++) {

			}*/

			// Reading FirstLine Value
	
			line = br.readLine();
			System.out.println("Header"+line);
			fieldheader = line.split(cvsSplitBy);
			System.out.println("EDIT CSV");
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			for (int i = 0; i < fieldheader.length; i++) {
		//		System.out.println(i + "VALUES:" + value);
				if (i == fieldheader.length - 1) {
					bw.write(fieldheader[i]);
				} else {
					bw.write(fieldheader[i]);
					bw.write(",");
				}
			}
			for(int j=1;j<=row;j++){
			
				if(j<=row || j==1){
					line = br.readLine();
					if(line!=null){
						fieldValue = line.split(cvsSplitBy);
					}
				}

				bw.newLine();
				System.out.println("*************Editing of **********************"+row+",With VALUE"+value);
				if(j==row){
				
					for (int i = 0; i < fieldValue.length; i++) {
						if (i == fieldValue.length - 1 && i == col) {
							bw.write(value);
						}
						if (i == col && i < fieldValue.length - 1) {
							bw.write(value);
							System.out.println(value+"___"+i+":NEW WRITE"+col);
							bw.write(",");
							
						} else if (i != col) {
							bw.write(fieldValue[i]);
							System.out.println(fieldValue[i]+"___"+i+":OLD WRITE"+col);
							bw.write(",");
						}
					}
				
				}else{
					for (int i = 0; i < fieldValue.length; i++) {
						if (i == fieldValue.length - 1 && i == col) {
							bw.write(fieldValue[i]);
						}
						if (i == col && i < fieldValue.length - 1) {
							bw.write(fieldValue[i]);
							bw.write(",");
						} else if (i != col) {
							bw.write(fieldValue[i]);
							bw.write(",");
						}
					}
				}
			}
			
			bw.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		System.out.println("Done");
	}

	/***
	 * To Read CSV-Read all the Columns and Row data
	 * 
	 * @author Piramanayagam.S
	 * @param csvFile
	 * @return Hashmap
	 * 
	 */
	public static String Readcsv(String csvFile, int col) {

		String data = "";
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
		String[] fieldheader = null;
		String[] fieldValue = null;
		try {
			String file = getPresentWorkingDir() + File.separator + dir + File.separator + csvFile;
			System.out.println("READ:" + file);
			br = new BufferedReader(new FileReader(file));

			// Reading Header
			line = br.readLine();
			fieldheader = line.split(cvsSplitBy);
			for (int i = 0; i < fieldheader.length; i++) {
			}

			// Reading FirstLine Value
			line = br.readLine();
			fieldValue = line.split(cvsSplitBy);
			for (int i = 0; i < fieldValue.length; i++) {
				if (i == col) {
					data = fieldValue[i];
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		System.out.println("Done");

		return data;
	}

	private static ChannelSftp Connecttolinux() throws Exception {

		String hostname = InitProperties("lf.hostname");
		String username = InitProperties("lf.username");
		String password = InitProperties("lf.password");
		ChannelSftp sftpChannel = null;
		ChannelSftp channel2 = null;
		String oldestFile = null;

		JSch jsch = new JSch();
		session = null;

		try {
			session = jsch.getSession(username, hostname, 22);
			session.setConfig("StrictHostKeyChecking", "no");
			session.setPassword(password);
			session.connect();
			Channel channel = session.openChannel("sftp");
			channel.connect();

			channel2 = (ChannelSftp) session.openChannel("sftp");
			channel2.connect();

			sftpChannel = (ChannelSftp) channel;
			System.out.println("COnnected to linux");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("EXPCE" + e);
		}

		return channel2;
	}
	 
	public static String ServerLatestFile(String folder, String type) throws Exception {

		String oldestFile = null;
		/*
		 * String platform=CommonUtils.InitProperties("Server");
		 * 
		 * if(platform.equalsIgnoreCase("Linux")){
		 * 
		 * try {
		 * 
		 * ChannelSftp sftpChannel = Connecttolinux(); System.out.println(
		 * "Linux Directory:" + sftpChannel.pwd());
		 * System.out.println("F"+folder); sftpChannel.cd("..");
		 * sftpChannel.cd("/home/lavante"); sftpChannel.cd(folder);
		 * 
		 * System.out.println("Linux Directory:" + sftpChannel.pwd());
		 * Vector<ChannelSftp.LsEntry> list = sftpChannel.ls("*.csv");
		 * System.out.println(sftpChannel.pwd());
		 * 
		 * System.out.println(list.size()+list.get(list.size()-1).getFilename())
		 * ; ChannelSftp.LsEntry lsEntry = null; SftpATTRS attrs = null; String
		 * nextName = null;
		 * 
		 * 
		 * int currentOldestTime; int nextTime = 2;
		 * 
		 * lsEntry = (ChannelSftp.LsEntry) list.firstElement();
		 * 
		 * attrs = lsEntry.getAttrs(); currentOldestTime = attrs.getMTime(); for
		 * (Object sftpFile : list) { lsEntry = (ChannelSftp.LsEntry) sftpFile;
		 * nextName = lsEntry.getFilename();
		 * System.out.println(nextName+currentOldestTime); attrs =
		 * lsEntry.getAttrs(); nextTime = attrs.getMTime(); if
		 * (currentOldestTime < nextTime) { oldestFile = nextName;
		 * currentOldestTime = nextTime; } }
		 * 
		 * oldestFile = list.get(list.size()-1).getFilename();
		 * 
		 * sftpChannel.exit(); session.disconnect();
		 * 
		 * } catch (SftpException e) { e.printStackTrace(); } } else {
		 * System.out.println("Window");
		 * 
		 * String hostname = "192.168.21.20"; String username =
		 * "Indecomm\\lavanateqa"; String password = "Indecomm1$"; ChannelSftp
		 * sftpChannel=null; ChannelSftp channel2=null;
		 * 
		 * JSch jsch = new JSch(); session = null;
		 * 
		 * try { session = jsch.getSession(username, hostname, 22);
		 * session.setConfig("StrictHostKeyChecking", "no");
		 * session.setPassword(password); session.connect(); Channel channel =
		 * session.openChannel("sftp"); channel.connect();
		 * 
		 * channel2 = (ChannelSftp)session.openChannel("sftp");
		 * channel2.connect();
		 * 
		 * sftpChannel = (ChannelSftp) channel; System.out.println(
		 * "COnnected to linux");
		 * 
		 * } catch (Exception e) { e.printStackTrace();
		 * System.out.println("EXPCE"+e); }
		 * 
		 * System.out.println("Linux Directory:" + sftpChannel.pwd());
		 * 
		 * 
		 * 
		 * 
		 * String USER_NAME = "INDECOMM\\lavanteqa"; String PASSWORD =
		 * "Indecomm1$"; String NETWORK_FOLDER =
		 * "smb:\\192.168.21.20\\filerepo"; // NETWORK_FOLDER=
		 * "smb:\\LAVAQA2012.INDECOMM.LOCAL\\filerepo\\exportContractManagement\\";
		 * NtlmPasswordAuthentication auth = new
		 * NtlmPasswordAuthentication("INDECOMM", USER_NAME, PASSWORD);
		 * System.out.println("Authenticated for: "+auth.getUsername());
		 * 
		 * String Servername = NETWORK_FOLDER+"";
		 * 
		 * SmbFile destFile = new SmbFile(Servername,auth); System.out.println(
		 * "AITH: '"+auth+"' :"+Servername+":"+destFile); for (SmbFile f :
		 * destFile.listFiles()) {
		 * System.out.println(f.getServer()+f.getLastModified()+f.getType()+f.
		 * getURL()); System.out.println(f.getName()+":"+f.getDate());
		 * 
		 * 
		 * } File srcfiles=new File(""); String srcfilesstring =
		 * "smb://192.168.21.20/Anonymos Logon/5-252064-1426149906850.pdf";
		 * System.out.println(srcfiles.getTotalSpace()); // FileInputStream src
		 * = new FileInputStream(srcfilesstring); SmbFileOutputStream sfos = new
		 * SmbFileOutputStream(destFile);
		 * 
		 * 
		 * try{ int bytesRead = 0; byte[] buffer = new byte[8192]; while
		 * ((bytesRead = src.read(buffer, 0, 8192)) != -1) { sfos.write(buffer,
		 * 0, bytesRead); } System.out.println("Dropped File: " +
		 * srcfilesstring); } catch (Exception e) { e.printStackTrace(); }
		 * 
		 * 
		 * 
		 * }
		 */
		return oldestFile;
	}

	/**
	 * Copy the files from Server machine to Test data Folder
	 * Folder is linux exact folder File is Exact file name, it will fetch from test data folder
	 * @param folder
	 * @param file
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void ServerCopyFile(String folder, String file) throws FileNotFoundException, IOException {
		String hostname = InitProperties("lf.hostname");
		String username = InitProperties("lf.username");
		String password = InitProperties("lf.password");
		JSch jsch = new JSch();
		com.jcraft.jsch.Session session = null;

		try {
			session = jsch.getSession(username, hostname, 22);
			session.setConfig("StrictHostKeyChecking", "no");
			session.setPassword(password);
			session.connect();
			Channel channel = session.openChannel("sftp");
			channel.connect();
			ChannelSftp sftpChannel = (ChannelSftp) channel;
			sftpChannel.cd("..");  // if the path
			sftpChannel.cd(folder);
			String g = folder + "/" + file;
			String dest=getPresentWorkingDir() + File.separator + dir + File.separator + file;
			//sftpChannel.get(g, dest);
			System.out.println(g);
			System.out.println(dest+"Diset");
			sftpChannel.put(dest,g);
			System.out.println("Linux File:" + file+"is available nw at:"+dest);
			sftpChannel.exit();
			session.disconnect();

		} catch (JSchException e) {
			e.printStackTrace();
			System.out.println(e);
		} catch (SftpException e) {
			e.printStackTrace();
			System.out.println(e);
		}

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

	public void navigateTo(String objNameStr, WebElement objName) {
		try {

			fluentwait(objName);
			click(objName);
			Report.pass("Naviagated to " + objNameStr + " successfully");

		} catch (Exception e) {

			Report.fail("Naviagation failed at " + objNameStr + e.getMessage());

		}

	}

	/**
	 * WinHandle Paramter if Its for Switch to frame
	 * Note: Ideally not required need to check
	 * @param winhandle
	 * @return
	 */
	public List<String> listelement(String winhandle) {
		if(winhandle==null){
			switchtoFrame(null);
		}
		List<String> explist = new ArrayList<String>();
		List<WebElement> el = driver.findElements(By.cssSelector("div[class*='drop'] li"));
		System.out.println("DP SIZE" + el.size());

		for (int i = 0; i < el.size(); i++) {
			String app = el.get(i).getText();
			explist.add(app);
		}
		return explist;
	}

/*	*//**
	 * This Method is to login to the Application
	 * 
	 * @param dataContent
	 * @author Piramanayagam.S
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws SQLException
	 *//*
	public List login(String key, String browser) throws FileNotFoundException, IOException, SQLException {
		List das = new ArrayList();
		LinkedHashMap<String, String> dataMaps = new LinkedHashMap<String, String>();
		dataMaps = logindata(key, browser);
		String customerid = fetchCustomer(dataMaps.get("username"));
		das.add(dataMaps);
		das.add(customerid);
		return das;
	}

	private LinkedHashMap<String, String> logindata(String key, String browser) throws IOException {
		LinkedHashMap<String, String> loginDataMap = new LinkedHashMap<String, String>();
		String[] xx = ReadExcelField("Login.xls", browser, key);
		loginDataMap.put("username", xx[0]);
		loginDataMap.put("password", xx[1]);
		loginDataMap.put("supname", xx[2]);
		Reporter.log("Credentials:");
		System.out.println("Test Class  :" + xx[0] + ",Passow at:" + xx[1]);
		Reporter.log("Username:" + xx[0]);
		Reporter.log("Password:" + xx[1]);

		return loginDataMap;
	}*/

	/**
	 * This Method is to replace orginal string with replace char and org
	 * charachter
	 * 
	 * @param dataContent
	 * @author Tejaswini AR
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws SQLException
	 */
	public static String replaceString(String orgstring, String replacechar, String orgchar) {
		if (orgstring.contains(replacechar)) {
			orgstring = orgstring.replace(replacechar, orgchar);
		}
		return orgstring;
	}

	public int generateRandomNumberOnLength(int num) {
		int randomNumber = randomnum(9);
		int xl = String.valueOf(randomNumber).length();
		while (xl != num) {
			randomNumber = randomNumber + randomnum(9);
			xl = String.valueOf(randomNumber).length();
		}

		/*
		 * while (loop) { // randomNumber = random.nextInt(); //
		 * System.out.println(Math.random()); String
		 * randomNumberx=""+Math.random(); System.out.println(randomNumberx);
		 * if(randomNumberx.contains(".")){
		 * randomNumberx=randomNumberx.replace("0.", "");
		 * System.out.println(randomNumberx); } Integer
		 * x=Integer.parseInt(randomNumberx);
		 * 
		 * 
		 * if (Integer.toString(x).length() == num) { loop = false; }
		 * 
		 * }
		 */
		return randomNumber;
	}

	public String generateRandomNumber9OnLength(int num) {
		DateFormat dateFormat = new SimpleDateFormat("ddHHmmss");
		Calendar cal = Calendar.getInstance();
		String x="4"+dateFormat.format(cal.getTime());
		System.out.println(x+"random leng:"+x.length());
		return x;
	}

	/**
	 * For the Given Date Select from the Date Picker
	 * 
	 * @author Piramanayagam.S
	 */
	public void selectdate(String date) {
		if(date.contains("-")){
			String[] date1=date.split("-");
			String dd=date1[0];
			String mm=date1[1];
			String yy=date1[2];
	
			selectbyvisibiletxt(yy,driver.findElement(By.cssSelector("[class*='datepicker-year']")));
			selectbyvisibiletxt(mm,driver.findElement(By.cssSelector("[class*='datepicker-month']")));
			
			List<WebElement> Date=driver.findElements(By.xpath("//table[contains(@class,'date')]//a[@href='#']"));
	
			outr:for(int i=0;i<Date.size();i++){
			if(Date.get(i).getText().equalsIgnoreCase(dd)){
				clickJavaScript(Date.get(i));
				break outr;
				}
			}
		}else{
			Assert.assertTrue(false,"Cannot Select Date,"+date);
		}
	}

	public void waitforPageload(WebElement webElement) {
		exception();
		loaderIcon();
		try{
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.elementToBeClickable(webElement));
		}catch(Exception ex){
			int i=0;
			boolean f=isElementDisplayed(webElement);
			while(f==false){
				i=i+1;
				f=isElementDisplayed(webElement);
				if(i==10){
					f=true;
				}
			}
		}
	}
	
	/**
	 *Loader Icon Shown in throughout the application, so forcing to Wait 
	 * 
	 * @author Piramanayagam.S
	 */
	private void loaderIcon() {
		List<WebElement> webElement=driver.findElements(By.cssSelector("div[style*='block'] div[class*='load']"));
		int count =1;
	//	System.out.println(webElement.size()+",Loader Count:"+count);
		while(webElement.size()>0 && count<10){
			Reporter.log(webElement.size()+",Loader Count:"+count,true);
			waitForTime(1000);
			webElement=driver.findElements(By.cssSelector("div[style*='block'] div[class*='load']"));
			count=count+1; 
		}
	}
	
	public void loaderIcon(String x) {
		List<WebElement> webElement=driver.findElements(By.cssSelector("div[style*='block'] div[class*='load']"));
		int count =1;
		int iterate=1;
		System.out.println(iterate+webElement.size()+",Loader Count:"+count);
		if(x==null||x.length()>0){
			while (webElement.size()>0 && iterate<4){
				while(webElement.size()>0 && count<10 ){
					Reporter.log(webElement.size()+",Loader Count:"+count,true);
					waitForTime(1000);
					webElement=driver.findElements(By.cssSelector("div[style*='block'] div[class*='load']"));
					count=count+1;
				}
				refreshPage();
				iterate=iterate+1;
			}
		}
	}
	
	/**
	 * waitforPage -if element present it will wait
	 * @param webElement
	 * 
	 */
	public void waitforPage(WebElement webElement) {
		waitForTime(4000L);
			int i=0;
			int j=0;
			loaderIcon();
			boolean f=isElementDisplayed(webElement);
			while(f==true){
				i=i+1;
				f=isElementDisplayed(webElement);
				if(i==10){
					j=j++;
					i=0;
					f=false;
					refreshPage();
					if(j==3){
						f=true;
					}
				}
			}
			
	}

	/**
	 * Send Email is to Send Email using the properties from initconfig
	 * 
	 *@author Piramanayagam.S 
	 */
	public static void sendemail(String[] to, String[] cc, String sub,String emailmsg, String Attachmentpath,String[] FileAttachment) throws Exception, InterruptedException, Throwable {

		Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
		String emailMsgTxt = emailmsg+" \n Send via automated code-SP at "+currenttime();
		// Reading Data from init properties

		String SMTP_HOST_NAME = InitProperties("SMTP_HOST_NAME");
		String SMTP_HOST_PORT = InitProperties("SMTP_HOST_PORT");
		String SMTP_AUTH_USER =InitProperties("SMTP_AUTH_USER");
		String SMTP_AUTH_PWD = InitProperties("SMTP_AUTH_PWD");
		String SMTP_HOST_PROTOCAL = InitProperties("SMTP_HOST_PROTOCAL");
		String emailFromAddress = InitProperties("emailFromAddress");

		boolean isAuthenticationRequired = true;

		// Set the host smtp address

		Properties props = new Properties();
		props.setProperty("mail.smtp.host",SMTP_HOST_NAME);
		props.setProperty("mail.smtp.port",SMTP_HOST_PORT);
		props.setProperty("mail.smtp.protocal",SMTP_HOST_PROTOCAL);
		props.put("mail.smtp.starttls.enable", "true");
		
		props.put("mail.smtp.timeout", "60000");
		props.put("mail.smtp.connectiontimeout", "60000");

		props.setProperty("mail.smtp.auth", Boolean
				.toString(isAuthenticationRequired));

		if (SMTP_AUTH_USER != null && !SMTP_AUTH_USER.trim().equals(""))

			props.setProperty("mail.smtp.username", SMTP_AUTH_USER);

		if (SMTP_AUTH_PWD != null && !SMTP_AUTH_PWD.trim().equals(""))

			props.setProperty("mail.smtp.password", SMTP_AUTH_PWD);
		Session session = Session.getInstance(props);
		// Session session = Session.getInstance(props, new
		// MailAuthenticator(emailFromAddress, SMTP_AUTH_PWD));
		
		 props.put("mail.smtp.port",SMTP_HOST_PORT);  
		MimeMessage msg = new MimeMessage(session);

		// set the from address
		InternetAddress addressFrom = new InternetAddress(emailFromAddress);

		// Attachment
		// Create the message part
		BodyPart messageBodyPart = new MimeBodyPart();

		// Fill the message
		messageBodyPart.setText(emailMsgTxt);

		// Create a multipart message
		Multipart multipart = new MimeMultipart();

		// Set text message part
		multipart.addBodyPart(messageBodyPart);
		
				
		// Attachment
		if (FileAttachment != null) {
			if (FileAttachment.length>=1) {
				
				for(int i=0;i<=FileAttachment.length-1;i++)
				{
					messageBodyPart = new MimeBodyPart();
					DataSource source = new FileDataSource(Attachmentpath+File.separator+FileAttachment[i]);		
					System.out.println(Attachmentpath+File.separator+FileAttachment[i]);
					messageBodyPart.setDataHandler(new DataHandler(source));
					messageBodyPart.setFileName(FileAttachment[i]);
					multipart.addBodyPart(messageBodyPart);
				}
				
			}
		}
		msg.setContent(multipart);

		// End of Attachment

		// Setting the Subject and Content Type
		msg.setSubject(sub);

		// msg.setContent(message, "text/html");
		msg.setHeader("X-Priority", "1");

		// From ID
		msg.setFrom(addressFrom);

		// Setting CC ID
		if (cc != null) {
			for (int j = 0; j < cc.length; j++) {
				InternetAddress ccid = new InternetAddress(cc[j]);
				msg.addRecipient(Message.RecipientType.CC, ccid);
			}
		}

		// Setting TO ID
		if (to != null) {
			for (int i = 0; i < to.length; i++) {
				InternetAddress toid = new InternetAddress(to[i]);
				msg.addRecipient(Message.RecipientType.TO, toid);
				if (FileAttachment == null){
						System.out.println("Sucessfully sent mail to: " + to[i] +" With subject: " + sub);
				}else if (FileAttachment.length>=1) {
					System.out.println("Sucessfully sent mail to: " + to[i]  + " With subject: " + sub + " With "+FileAttachment.length +" Attachment " );
					
					for(int j=0;j<=FileAttachment.length-1;j++)
					{
						int k=j+1;
						System.out.println("File :"+k+": "+FileAttachment[j]);
					}
					
				}
			}
			/*
			 * //Setting BCC ID if (bcc != null){ for( int k = 0; k<to.length;
			 * k++) { InternetAddress bccid = new InternetAddress(bcc[k]);
			 * msg.addRecipient(Message.RecipientType.BCC, bccid); } }
			 */
			Transport mailTransport = session.getTransport(SMTP_HOST_PROTOCAL);
			mailTransport.connect(SMTP_HOST_NAME, SMTP_AUTH_USER,SMTP_AUTH_PWD);

			try {
				mailTransport.sendMessage(msg, msg.getAllRecipients());
				mailTransport.close();
			} catch (MessagingException e) {
				e.printStackTrace();
			}

		}
	}
	
	/**
	 * Navigate to Acc Setup using the link 
	 * 
	 * @author subhas.bv
	 * @param dataContent
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws SQLException
	 */
	public String navigatetoAccSetup(String[] dataContent) throws FileNotFoundException, IOException, SQLException {

		String fetchCustomerid = "";
		String fetchRelationShipid = "";
		String fetchContactID = "";
		String fetchContactEmail = "";
		String fetchInviteID = "";
		if (dataContent.length > 0) {

			if (dataContent[0].length() > 0) {
				fetchRelationShipid = "select RelationshipID from Relationship where LavanteUID=(select LavanteUID from Supplier where "
						+ " SupplierName='" + dataContent[0] + "') order by RelationshipID desc ";
				fetchRelationShipid = fetchDBdata(fetchRelationShipid);

				fetchCustomerid = "select CustomerID from Relationship where RelationshipID=" + fetchRelationShipid
						+ "";
				fetchCustomerid = fetchDBdata(fetchCustomerid);
			}

			if (dataContent[1].length() > 0) {
				fetchContactID = "select ContactID from Contact where ContactName='" + dataContent[1] + "'";
				fetchContactID = fetchDBdata(fetchContactID);

				fetchContactEmail = "select Email from Contact where ContactName='" + dataContent[1] + "'";
				fetchContactEmail = fetchDBdata(fetchContactEmail);

			}
			if (dataContent[2] == null) {
				fetchInviteID = "select InviteId from invite where RelationshipId=" + fetchRelationShipid
						+ " order by InviteId desc";
				fetchInviteID = fetchDBdata(fetchInviteID);
			} else {
				fetchInviteID = dataContent[2].trim();
			}

		}

		String authenticationToken = DESEncryptionUtil
				.encrypt(String.format("contactId=%s&contactEmailId=%s&customerId=%s&relationshipId=%s&inviteId=%s",
						fetchContactID, fetchContactEmail, fetchCustomerid, fetchRelationShipid, fetchInviteID));

		System.out.println(authenticationToken);

		String accurl = "/supplierAccountSetup.lvp";
		String simurl = InitProperties("AccSetupURL");

		String registrationStrongLinkUrl = String.format("%s%s?%s", simurl, accurl, authenticationToken);
		System.out.println("RegistrationStrongLinkUrl " + registrationStrongLinkUrl);
		driver.get(registrationStrongLinkUrl);
		return registrationStrongLinkUrl;
	}

	/**
	 * Method to get the Show Count i.e. total no. of records in the table.
	 * @author Girish.N
	 * 
	 */
	public int getCount(){
		int count=-1;
		WebElement totalCount= driver.findElement(By.cssSelector("span[class='highlight_green']"));
		
		if(totalCount!=null){
			if(totalCount.getText().length()>0 && totalCount.getText().contains("(")){
				count=Integer.parseInt(totalCount.getText().trim().replace("(", "").replace(")","").trim());
			}
		}else{
			Reporter.log("<--------- Total is not displayed on the table header",true);
		}
		
		return count;
	}

	/**
	 * Some Search Page Has String in 1 -11 out of 11
	 * Fetching the total records
	 * 
	 * @author Piramanayagam.S
	 * 
	 */
	public int getCount(String x){
		
		int count=-1;
		if(x.length()>0 && x.contains(" of ")){
			String[] y=x.split(" of ");
			count=Integer.parseInt(y[1]);
		}
		
		return count;
	}
	public String selectDropDownValues(WebElement elemen, String text) {
		boolean isSelected = false;

		List<WebElement> options = null;
		String value = "";

		try {

			options = elemen.findElements(By.xpath(".//option"));

			waitForTime(2000);
			for (WebElement option : options) {
				value = option.getText().toString().trim();
				text = text.toString();
				if(text.equalsIgnoreCase("any") && !value.contains("Select")) {
					option.click();
					isSelected = true;
					break;
				} else if (text.equalsIgnoreCase(value)) {
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
		return value;
	}
	
	/**
	  * AddSubDate-  Add/Subtract date to the current date
	  * //format "dd-MMM-yyyy"
	  * @author Subhas.BV
	  * @throws ParseException
	  */
	 public static String AddSubDateWithFormat(int noofdays, String format) throws ParseException {
		  DateFormat dateFormat = new SimpleDateFormat(format);
		  Calendar cal = Calendar.getInstance();
		  String dt=dateFormat.format(cal.getTime());
		  
		  cal.setTime(dateFormat.parse(dt));
		  cal.add(Calendar.DATE, noofdays);  
		  dt = dateFormat.format(cal.getTime());
		  
		  return dt;
	 }

	 /**
	  * Created for Extent Report Implementation
	  * 
	  * @return
	  */
	public WebDriver getDriver() {
		// TODO Auto-generated method stub
		return null;
	}

	File flag=null;
	
	public File recursivefolder(File f,String files) throws InterruptedException, Exception, Throwable{
		
		
		if(f.isDirectory() || f.isFile()){
			outr:for (File file : f.listFiles()) {
			     if (file.isDirectory()) {
			    	 recursivefolder(file,files);
			     }else {
			    	 if(file.isFile()){
			    		 System.out.println(file.getName());
			    		 if(file.getName().contains(files)){
			    			 System.out.println("success");
			    		//	 GridReportEmail.AfterSuiteCall();
			    			 System.out.println(file);
			    			 flag=file;
			    			 break outr;
			    		 }
			    	 }
			     }
			 }
			
		}
		 
		 return flag;
	}
	
	
	/**
	 * Created for grid Report Run
	 * @throws Throwable 
	 * @throws Exception 
	 * @throws InterruptedException 
	 * 
	 */
	@BeforeSuite
	public void BeforeSuite(ITestContext ctx) throws InterruptedException, Exception, Throwable{
		
		String strRemoteExec = System.getProperty("RemoteExecution");
		if (strRemoteExec != null && strRemoteExec.equalsIgnoreCase("true")){
		ctxx=ctx;
		 String suiteName = ctx.getCurrentXmlTest().getSuite().getName();
		
		 File f=new File(getPresentWorkingDir()+File.separator+ReportDir);
		 for (File file : f.listFiles()) {
		     if (file.isFile()) {
		         file.delete();
		     }
		 }
		 
		 //Fetched from PomQA/Staging.xml
		 File src=new File(getPresentWorkingDir()+File.separator+"TestResults");
		 File dest=new File(getPresentWorkingDir()+File.separator+"BackupResults");
		 
		 if(src.isDirectory()){
			 System.out.println(src);
			 FileUtils.copyDirectory(src,dest);
			 try {
				 FileUtils.deleteDirectory(src);
			 }catch(Exception e){
				 System.out.println("Cannot delete the driectory to be used");
			 }
		 }
		 
		 if(!suiteName.equalsIgnoreCase("Default Suite")){
			 String sub="SIM-Automation Nightly Run Status";
			 suiteStartTime=currenttime();
			 String msg="Hi ,Team,\n\n "+suiteName+",Test Started at : "+currentDateTime()+",\n\nRegards,\nBy Automation Team";
			 String[] cc=null;
			 String[] t=null;
			 String[] FileAttachment=null;
			 String Attachmentpath="";
			 String emailTo = InitProperties("emailFromAddress");
			 t=new String[1];
			 t[0]=emailTo;
			 sendemail(t,cc,sub,msg,Attachmentpath,FileAttachment);
		 }
		 
		 itestMethodList=ctxx.getAllTestMethods();
		 lastEmailSentTime=currenttime();
		 lastemailConcurrency=0;
		}
	}
	
	/**
	 * Created for grid Report Run
	 * 
	 * @throws Throwable 
	 * @throws Exception 
	 * @throws InterruptedException 
	 * 
	 */
	@AfterSuite
	public void AfterSuite(ITestContext ctx) throws InterruptedException, Exception, Throwable{

		String strRemoteExec = System.getProperty("RemoteExecution");
		if (strRemoteExec != null && strRemoteExec.equalsIgnoreCase("true")){
			String suiteName = ctx.getCurrentXmlTest().getSuite().getName();
		// if(!suiteName.equalsIgnoreCase("Default Suite")){
			 String y=currenttime();
			 Integer z=Integer.parseInt(y)-Integer.parseInt(suiteStartTime);
			 String sub="SIM-Automation Nightly Run Status";
			 String msg="Hi ,Team, "+suiteName+",Test Ended at : "+currentDateTime() +",*********Total Time Taken [in Seconds] ::"+z+"******,By Automation Team";
			 String[] cc=null;
			 String[] t=null;
			 String[] FileAttachment = null;
			 String Attachmentpath="";
			 File f=new File(getPresentWorkingDir()+File.separator+ReportDir);
			 File[] listOfFiles = f.listFiles();
			 int count=0;
			 
			 for (File file : listOfFiles) {
			     if (file.isFile()) {
			         if(file.getName().contains("_Running")){
			        	 count=count+1;
			         }
			     }
			 }
			 if(count>0){
				 FileAttachment=new String[count];
			 }
			 int i=0;
			 for (File file : listOfFiles) {
			     if (file.isFile()) {
			    	 Attachmentpath=getPresentWorkingDir()+File.separator+ReportDir;
			         if(file.getName().contains("_Running")){
			        	 FileAttachment[i]=file.getName();
			        	 i=i+1;
			         }
			     }
			 }
			 

			 //	f=new File(getPresentWorkingDir()+File.separator+"TestResults");
			// 	recursivefolder(f,"");
				 String emailTo = InitProperties("emailFromAddress");
				 t=new String[1];
				 t[0]=emailTo;
				 sendemail(t,cc,sub,msg,Attachmentpath,FileAttachment);
			 
				 for( i=0;i<itestMethodList.length;i++){
						tearDown(itestMethodList[i]);
					}
		 }
			
		
	}

	/**
	 * To Display the Class Name
	 * Also Used in Automation report
	 * 
	 * @author Piramanayagam.S
	 * @throws IOException 
	 */
	public void classNameDisplay() throws IOException {
		String testName = this.getClass().getName();
		System.out.println("--------------Test Class  :" + testName + ",Started at:" + randomnum()+"--------------------------------------");
		Reporter.log("---------------Test Class  :" + testName + ",Started at:" + randomnum()+"--------------------------------------");
		String strRemoteExec = System.getProperty("RemoteExecution");
		if (strRemoteExec != null && strRemoteExec.equalsIgnoreCase("true")) {
			String x="";
			if(testName.contains("TestScripts.")){
				String[] sp=testName.split("TestScripts.");
				x=sp[1];
			}
			InitialReport=x+"_Started.txt";		
			IntermediateReport=x+"_Running.txt";
			//String suiteName = ctx.getCurrentXmlTest().getSuite().getName();
			itestMethodList=ctxx.getAllTestMethods();
			if(itestMethodList.length>0){
				for(int i=0;i<itestMethodList.length;i++){
					tearUp(itestMethodList[i]);
				}
				
			}
		}
		
	}
	
	/**
	 * Prepare Test Report should run after the Method Run ,Result is captured in the text document and Email Would be sent on a Counter Interval
	 * 
	 * @author Piramanayagam.S
	 * @param result
	 * @throws InterruptedException
	 * @throws Exception
	 * @throws Throwable
	 */
	 @AfterMethod
	  public void prepareTestReport(ITestResult result) throws InterruptedException, Exception, Throwable {
		 	
		 	String strRemoteExec = System.getProperty("RemoteExecution");
			if (strRemoteExec != null && strRemoteExec.equalsIgnoreCase("true")) {
				String methodname=result.getMethod().getMethodName();
				switch (result.getStatus()) {
			    case ITestResult.SUCCESS:
			        sendIntermediateMail("======PASS=====",methodname);
			        break;

			    case ITestResult.FAILURE:
			        sendIntermediateMail("======FAIL=====",methodname);
			        break;

			    case ITestResult.SKIP:
			        sendIntermediateMail("======SKIP=====",methodname);
			        break;

			    //default:
			        //throw new RuntimeException("Invalid status");
			    }
			}
		  }
	 
	/**
	 * Sending Intermediate Report to the Gmail for the test result status only if the Run takes 
	 * more than the configured time and there is a counter to control the freq of mail sent
	 * 
	 * @author Piramanayagam.S
	 * @param testStatus
	 * @param methodName
	 * @throws InterruptedException
	 * @throws Exception
	 * @throws Throwable
	 */
	 private void sendIntermediateMail(String testStatus,String methodName) throws InterruptedException, Exception, Throwable{
		  String file = getPresentWorkingDir()+ File.separator + ReportDir + File.separator + InitialReport;
		  File xx=new File(file);
		 FileReader fr = new FileReader(xx);
	     BufferedReader br = new BufferedReader(fr);
	     
	     String file2 =  getPresentWorkingDir()+ File.separator + ReportDir + File.separator + IntermediateReport;
		 String line=br.readLine();
		      String x="";
		      while (line != null){
		            	x=x+line;
		            	if(line.contains(methodName)){
		            		if(line.contains(RunningStatus)){
			            		 FileWriter fw = new FileWriter(file2,true);
			     				BufferedWriter bw = new BufferedWriter(fw);
			     				String[] y=line.split(RunningStatus);
			     				bw.write(y[0]+testStatus+"at "+currentDateTime()+"\n");
			     				bw.close();
			            		fw.close();
			            			String yy=currenttime();
		            				Integer z=Integer.parseInt(yy)-Integer.parseInt(lastEmailSentTime); 
		            				System.out.println("REPLACEDMENT:"+z+",EmailTime,"+emailTimeOutConcurrency+",last:"+lastemailConcurrency+",lastMailSentCounter:"+lastMailSentCounter);
		            				
	            					 if(z>emailTimeOutConcurrency && lastemailConcurrency>lastMailSentCounter )	 {
		            					 //Call send Email Method only for grid Run
	            						 	String strRemoteExec = System.getProperty("RemoteExecution");
		            						if (strRemoteExec != null && strRemoteExec.equalsIgnoreCase("true")) {
				            					String sub="SIM-Automation Inter-Mediate Status";
				            					 String emailmsg="Hi ,Team,Inter-Mediate Status , Please Refer the Attachment, to know the Intermediate Status, \n \n Note:This is not Final Report and Run is Still Going ON , \n \n By Automation Team \n \n";
				            					 String[] cc=null;
				            					 String[] t=null;
				            					 String[] FileAttachment=null;
				            				//	 FileAttachment[1]=IntermediateReport;
				            					 String Attachmentpath=getPresentWorkingDir()+ File.separator + ReportDir;
				            					 String emailTo = InitProperties("emailFromAddress");
				            					 t=new String[1];
				            					 t[0]=emailTo;
				            					 File xxx=new File(Attachmentpath);
				            					 int count=0;
				            					 for (File filen : xxx.listFiles()) {
				            					     if (filen.isFile()) {
				            					         if(filen.getName().contains("_Running")){
				            					        	 count=count+1;
				            					         }
				            					     }
				            					 }
				            					 count=count+1;
			            						 FileAttachment=new String[count];
				            					 
				            					 FileAttachment[0]=InitialReport;
				            					 int i=1;
				            					 for (File filen : xxx.listFiles()) {
				            					     if (filen.isFile()) {
				            					    	 Attachmentpath=getPresentWorkingDir()+File.separator+ReportDir;
				            					         if(filen.getName().contains("_Running")){
				            					        	 FileAttachment[i]=filen.getName();
				            					        	 i=i+1;
				            					         }
				            					     }
				            					 }
				            					 
            									 sendemail(t, cc, sub, emailmsg, Attachmentpath, FileAttachment);
            									 lastEmailSentTime=currenttime();
				            					 lastemailConcurrency=0;
		            						}			
			            					
			            				}else if (z>emailTimeOutConcurrency){
			            					//Donot send Email
			            					lastemailConcurrency=lastemailConcurrency+1;
			            				}
			            					
			            		 }
		            		line=null;
		            		break;
		            	}
		            	if(line!=null){
		            		line = br.readLine();
		            	}
		            
		      	}
		br.close();
		fr.close();
	 }
	 
	/**
	 * @author Piramanayagam.S
	 * @param itx
	 * @throws IOException
	 */
	private synchronized void tearUp(ITestNGMethod itx) throws IOException {
		String strRemoteExec = System.getProperty("RemoteExecution");
		if (strRemoteExec != null && strRemoteExec.equalsIgnoreCase("true")) {
		  String xx=itx.getMethodName();
		  System.out.println(xx);
		  String file = getPresentWorkingDir()+ File.separator +  ReportDir + File.separator + InitialReport;
		  File x=new File(file);
		  FileWriter fw = new FileWriter(x,true);
			BufferedWriter bw = new BufferedWriter(fw);
			try {
				bw.write(xx+": "+RunningStatus+" \n");
			}finally{
				bw.close();
				fw.close();
			}
		}
	}
	
	/**
	  * To Fetch the Method fromt the Class
	  * 
	  * @author Piramanayagam.S
	  * @param iTestNGMethod
	  * @throws IOException
	  */
	private void tearDown(ITestNGMethod iTestNGMethod) throws IOException {
			String strRemoteExec = System.getProperty("RemoteExecution");
			if (strRemoteExec != null && strRemoteExec.equalsIgnoreCase("true")) {
			  String xx=iTestNGMethod.getMethodName();
			  String file = getPresentWorkingDir()+ File.separator +  ReportDir + File.separator + InitialReport;
			  File x=new File(file);
			  FileWriter fw = new FileWriter(x,true);
			BufferedWriter bw = new BufferedWriter(fw);
			try {
				bw.write(xx+": "+RunningStatus+" \n");
			}finally{
				bw.close();
				fw.close();
			}
		}
		
	}
	  
	/**
	 * Used for Suite Report to Print
	 *  
	 * @author Nagappa
	 */
	private static String currentDateTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        
        return dtf.format(now);
	}

	public LinkedHashMap<String, String> convertdatamap(LinkedHashMap<String, String> dataMap) throws FileNotFoundException, IOException, SQLException {
				
		LinkedHashMap<String, String> dataMaps=dataMap;
		if(dataMaps.containsKey("CustomerID")){
			String x=dataMap.get("CustomerID");
			for (String key : dataMaps.keySet()) {
				if(dataMaps.containsKey(key)){
					String[] xy=new String[2];
					xy[0]="";
					xy[1]="";
					String val=dataMap.get(key);
						dataMaps.put(key, val);	
						if(val.contains("AutoID")){
							val=val.replace("AutoID", x);
							if(val.contains("#"))
							{
								xy=val.split("#");
								val=xy[1];
							}
							val=fetchDBdata(val);
							if(val!=null ){
								if(xy[0].length()>0){
									val=xy[0]+","+val;
								}
								dataMaps.put(key, val);	
							}else{
								Assert.assertTrue(false,"Given Query is not giving any value,Query,"+dataMap);
							}
							
					}
				}
			}
		}
		if(dataMaps.containsKey("AutoEmail")){
			String x=dataMap.get("AutoEmail");
			for (String key : dataMaps.keySet()) {
				if(dataMaps.containsKey(key)){
					String[] xy=new String[2];
					xy[0]="";
					xy[1]="";
					String val=dataMap.get(key);
					dataMaps.put(key, val);	
					if(val.contains("AutoEmail")){
						val=val.replace("AutoEmail", x);
						if(val.contains("#"))
						{
							xy=val.split("#");
							val=xy[1];
						}
						val=fetchDBdata(val);
						if(val!=null ){
							if(xy[0].length()>0){
								val=xy[0]+"#"+val;
							}
							dataMaps.put(key, val);	
						}else{
							Assert.assertTrue(false,"Given Query is not giving any value,Query,"+dataMap);
						}
						
					}
				}
			}
		}if(dataMaps.containsKey("AutoClaim")){
			String claimID="";
			if(dataMaps.containsKey("Claim ID")){
				String zcxh=dataMaps.get("Claim ID");
				if(zcxh.contains("#")){
					String[] adad=zcxh.split("#");
					if(adad.length>0){
						claimID=adad[1];
					}
				}
			}
			if(claimID.length()>0){
			for (String key : dataMaps.keySet()) {
				if(dataMaps.containsKey(key)){
					String[] xy=new String[2];
					xy[0]="";
					xy[1]="";
					String val=dataMap.get(key);
					dataMaps.put(key, val);	
					if(val.contains("AutoClaim")){
						val=val.replace("AutoClaim", claimID);
						if(val.contains("#"))
						{
							xy=val.split("#");
							val=xy[1];
						}
						val=fetchDBdata(val);
						if(val!=null ){
							if(xy[0].length()>0){
								val=xy[0]+"#"+val;
							}
							dataMaps.put(key, val);	
						}else{
							Assert.assertTrue(false,"Given Query is not giving any value,Query,"+dataMap);
						}
						
					}
				}
			}
		}
		}
		
		
		return dataMaps;
	}
	
	public LinkedHashMap<String, String> convertdatamapwoDB(LinkedHashMap<String, String> dataMap) throws FileNotFoundException, IOException, SQLException {
	
		LinkedHashMap<String, String> dataMaps=dataMap;
		if(dataMaps.containsKey("CustomerID")){
			String x=dataMap.get("CustomerID");
			for (String key : dataMaps.keySet()) {
				if(dataMaps.containsKey(key)){
					String val=dataMap.get(key);
					if(val.contains("AutoID")){
						val=val.replace("AutoID", x);
					}
					dataMaps.put(key, val);
				}
			}
		}
		
		return dataMaps;
	}
	
	public void replaceColumnString(String file, String replaceString, int startIndex, int endIndex)
			throws IOException {
		file=getPresentWorkingDir()  + File.separator + 	System.getProperty("TestData")+ File.separator + "data" + File.separator +file;
		File fileToBeModified = new File(file);
		BufferedReader reader = null;
		FileWriter writer = null;
		reader = new BufferedReader(new FileReader(fileToBeModified));
		String line = reader.readLine();
		int start = startIndex - 1;
		int end = endIndex - 1;
		if (endIndex == 0) {
			Character empty;
			int j = 0;
			int size = line.length();
			if (line != null) {
				for (int i = 0; i < size; i++) {
					empty = line.charAt(startIndex + i);
					if (!Character.isWhitespace(empty)) {
						j++;
					} else {
						break;
					}
				}
				int subLength = (startIndex) + j;
				for (int i = 0; i < j; i++) {
					replaceString = replaceString.concat(" ");
				}
				line = line.replace(line.substring(start, subLength), replaceString);
			}
		} else {
			int repStringLength = replaceString.length();
			int dif = endIndex - startIndex;
			if (repStringLength < dif) {
				for (int i = 0; i < dif - repStringLength; i++) {
					replaceString = replaceString.concat(" ");
				}
			}
			if (repStringLength > dif) {
				replaceString = replaceString.substring(0, dif);
			}
			String x=line.substring(start, end);
			line = line.replace(x, replaceString);
		}
		
		System.out.println("Complete string " + line + " after replacing substring by /n" + replaceString);
		writer = new FileWriter(fileToBeModified);
		writer.write(line);
		writer.flush();
		reader.close();
		writer.close();
	}

	

	public void jobWaiting(String job,String time ) throws FileNotFoundException, IOException, SQLException {
		String x="select TRIGGER_STATE From QRTZ_TRIGGERS where TRIGGER_NAME  in ('"+job+"')";
		x=fetchDBdataPlatform(x);
		boolean flag=false;
		if(x.contains("WAITING") || x.contains("BLOCKED")){
			while(x.contains("WAITING") && (flag==false)){
				System.out.println("Inside WAIT");
				x="select TRIGGER_STATE From QRTZ_TRIGGERS where TRIGGER_NAME  in ('"+job+"')";
				x=fetchDBdataPlatform(x);
				String y="select NEXT_FIRE_TIME From QRTZ_TRIGGERS where TRIGGER_NAME  in ('"+job+"')";
				y=fetchDBdataPlatform(y);
				if(! x.equalsIgnoreCase(time) && (y.equalsIgnoreCase("WAITING"))){
					flag=true;
				}
				waitForTime(4000);
			}
			
			while(x.contains("BLOCKED")){
				System.out.println("Inside Block");
				x="select TRIGGER_STATE From QRTZ_TRIGGERS where TRIGGER_NAME  in ('"+job+"')";
				x=fetchDBdataPlatform(x);
				waitForTime(4000);
			}
			
		}
		
	}

}
