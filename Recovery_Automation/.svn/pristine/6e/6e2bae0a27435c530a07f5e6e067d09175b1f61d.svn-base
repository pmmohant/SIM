package lavante.recovery.testsuites;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import lavante.recovery.pageobjects.pageInitiator;

public class loginTest extends pageInitiator {
	
	
  @BeforeClass
 // @Parameters({ "Platform", "Browser", "Version" })
  //public void preCondition(String platform, String browser, String version) throws IOException  {
  public void preCondition() throws IOException {
	  
	  //launchAppThroughPOM(platform,browser,version);
	  launchRecoveryAppForDebug();
	  initiate();
  }
  
  @Test
  public void loginWithValidCredentials() {	  
	  
	  startTest("loginWithValidCredentials");
	  
	  loginPage.enterUserName("adminuser1");
	  loginPage.enterPassWord("lavante@123");	
	  loginPage.clickLoginButton();  

	  homePage.verifyHomePageDisplayed(); 
	  endTest("loginWithValidCredentials");	  
	  
	  driver.navigate().to("http://recoveryqa27.lavante.com:8080/recovery/inbound.lvp#recognized");
	  
	    int i = inboundLandingPage.getStatus("Active");
	  
	    System.out.println(i);
	  
  }
  
  
  @AfterTest
  public void clean() {
	  
	  quitBrowser();
  }
  
}
