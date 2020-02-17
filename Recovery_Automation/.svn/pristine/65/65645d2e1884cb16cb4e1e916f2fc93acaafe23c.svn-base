package lavante.recovery.testsuites;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import lavante.recovery.pageobjects.pageInitiator;

public class FaxCountValidation_DocumentSummary extends pageInitiator {
	
	
  @BeforeClass
  @Parameters({ "Platform", "Browser", "Version" })
  public void preCondition(String platform, String browser, String version) throws IOException  {
  //public void preCondition() throws IOException {
	  
	  launchAppThroughPOM(platform,browser,version);
	  //launcRecoveryAppForDebug();
	  System.out.println("!"+driver);
	  initiate();
	  
	 startTest("loginWithValidCredentials");
	  
	  loginPage.enterUserName("adminuser1");
	  loginPage.enterPassWord("lavante@123");	
	  loginPage.clickLoginButton();  

	  homePage.verifyHomePageDisplayed();
	 
	  endTest("loginWithValidCredentials");	 
  }

  
  @Test
  public void getFaxCount(){
	  waitForTime(5000);
	  //Close the pop up for Browser specific info
	  homePage.verifyBrowserStartPopUp();
	  
	  //Click on Audit Drop down list
	//  homePage.verifyAuditList();
	  
	  //Click on Audit  drop down list
	  WebElement auditList = driver.findElement(By.cssSelector("[id='audit_chosen'] a"));
	  Actions actDrpDown = new Actions (driver);
	  actDrpDown.moveToElement(auditList).build().perform();
	  waitForTime(2000);
	  actDrpDown.click().build().perform();
	  
	  //Enter Audit Name as Lafarge 2008
	  WebElement enterAudittxt = driver.findElement(By.cssSelector("[id='audit_chosen'] div[class*='drop'] div[class*='search'] input"));
	  enterAudittxt.sendKeys("Lafarge 2008");
	  
	  //selectvalueFrmDpdn("Lafarge 2008", "Audit selected");
	  
	  //Press Enter after entering audit name
	  Actions actAudittxt = new Actions (driver);
	  waitForTime(2000);
	  actAudittxt.sendKeys(Keys.ENTER).build().perform();
	
	  //navigate to Audit Tab--Click on it--Find Locator for Audit tab
	  waitForTime(5000);
	  homePage.verifyAuditTab();
	  
	  //Navigate to Inbound Tab--Click on it --Find Locator for Inbound tab
	  waitForTime(5000);
	  homePage.verifyInboundTab();
	  
	  //Click on Document Status drop down in Inbound Landing Page
	  WebElement docStatusDrpDown = driver.findElement(By.cssSelector("[id='document_status_chosen'] a"));
	  Actions actdocStatusDrpDown = new Actions (driver);
	  actdocStatusDrpDown.moveToElement(docStatusDrpDown).build().perform();
	  waitForTime(2000);
	  actdocStatusDrpDown.click().build().perform();
	
	  waitForTime(2000);
	  
	  List<WebElement> selectDocStatus = driver.findElements(By.cssSelector("[id='document_status_chosen'] div ul li"));
	  
		int count= 0;
		
		/*for(count = 0; count <7; count ++){
			String eachDocStatus = selectDocStatus.get(count).getText();
			System.out.println("clicked : " + eachDocStatus);
			
			  actdocStatusDrpDown.moveToElement(docStatusDrpDown).build().perform();
			  waitForTime(2000);
			  actdocStatusDrpDown.click().build().perform();
			  waitForTime(3000);
			  selectDocStatus.get(count).click();
			  waitForTime(3000);
		
		}*/
	   
	  
	  //Store all the values in a list 
	  
	  //Select by Index within for loop
	  
	  //Take locators for all the documents from Inbound Landing Page page object class
	  
	  //Get text for each of the document type
	  
	  //Iterate through each document type
	  
	  //Click on each document type and store this as expected result
	  
	  //Navigate to Document status table from Inbound Landing page POM class
		List<WebElement> alltrRows = driver.findElements(By.cssSelector("[id='inbound_document_status'] tr"));
		for(int i= 0;i < alltrRows.size();i++){
			
			WebElement eachtrRow = alltrRows.get(i);
			System.out.println("each row locator is :" + eachtrRow.getText());
			
			List<WebElement> eachtrAllColumns = driver.findElements(By.cssSelector(eachtrRow + " td"));
			for(WebElement eachtreachCol :eachtrAllColumns){
				System.out.println(eachtreachCol.getText());
			}
			
		}
	  
	  //For each document status selected in step 5, compare with that
	  
	  //Asset with pass/ fail
	  
  }
  
  
  @AfterTest
  public void clean() {
	  quitBrowser();
  }
  
}
