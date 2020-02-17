/**
 * 
 */
package com.lavante.sim.customer.pageobjects.Suppliers.EditProfile;

import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import com.lavante.sim.Common.Util.LavanteUtils;

/**
 * @author Piramanayagam.S
 *
 */
public class LaunchCTI {
	
	public WebDriver driver;
	LavanteUtils lavanteUtils=null;

	
	public LaunchCTI(WebDriver driver){
		lavanteUtils.driver=driver;
		this.driver=driver;
	}
		
	

	@FindBy(how=How.CSS,using="iframe[id*='cti']")
	private WebElement IFRAMECTI;	
	public WebElement  IFRAMECTI(){
		return IFRAMECTI;
	}
	
	@FindBy(how=How.CSS,using="a[href*='CTI']")
	private WebElement launchW9;	
	public WebElement  launchW9(){
		return launchW9;
	}
	
	
			

	public void LaunchWizard(LinkedHashMap<String, String> dataMap){
		lavanteUtils.switchtoFrame(null);
		lavanteUtils.waitForTime(4000);
		lavanteUtils.fluentwait(launchW9());
		lavanteUtils.Scrollintoview(launchW9());
		launchW9().click();
		lavanteUtils.waitForTime(4000);

		lavanteUtils.waitForTime(10000);
		lavanteUtils.switchtoFrame(null);
		lavanteUtils.fluentwait(IFRAMECTI());
		lavanteUtils.switchtoFrame(IFRAMECTI);
		
		lavanteUtils.Scrollintoview(driver.findElement(By.cssSelector("input[id*='Yes']")));
		lavanteUtils.fluentwait(driver.findElement(By.cssSelector("input[id*='Yes']")));
		driver.findElement(By.cssSelector("input[id*='Yes']")).click();
		
		lavanteUtils.fluentwait(driver.findElement(By.cssSelector("[id*='Permenent']")));
		Select s=new Select(driver.findElement(By.cssSelector("[id*='Permenent']")));
		s.selectByVisibleText("UNITED STATES");
	
		Select ss=new Select(driver.findElement(By.cssSelector("[id*='Mailcountry']")));
		ss.selectByVisibleText("UNITED STATES");
		
		Select Orgcntry=new Select(driver.findElement(By.cssSelector("[id*='Mailcountry']")));
		Orgcntry.selectByVisibleText("UNITED STATES");
	
	//	BasicInfo(dataMap);
		
		driver.findElement(By.cssSelector("[id*='Correct']")).click();
		driver.findElement(By.cssSelector("[role*='dialog'] button:nth-child(2)")).click();
		
		lavanteUtils.fluentwait(driver.findElement(By.cssSelector("[id*='txtEmail']")));
		driver.findElement(By.cssSelector("[id*='txtEmail']")).sendKeys("simsupplierqa42@gmail.com");
		driver.findElement(By.cssSelector("input[id*='ConfirmEmail']")).sendKeys("simsupplierqa42@gmail.com");
		driver.findElement(By.cssSelector("[id*='Submit']")).click();
		driver.findElement(By.cssSelector("[id*='Close']")).click();
		

		//	ReadEmail fpr Ping
		//	[id*='Close'] for continue
	
		//	esign(dataMap);	
		List<WebElement> chk1=driver.findElements(By.cssSelector("[id*='CKBOX']  input"));
		for(int i=0;i<chk1.size();i++){
			chk1.get(i).click();
		}
		

		//	formSelection(dataMap);
		driver.findElement(By.cssSelector("div[id*='FIRST'] input")).sendKeys("simsupplierqa4");
		driver.findElement(By.cssSelector("div[id*='LAST'] input")).sendKeys("simsupplierqa4");
		driver.findElement(By.cssSelector("[id*='Next']")).click();
				
		
		driver.findElement(By.cssSelector("//*[text()='Non-Individual/Entity']")).click();
		driver.findElement(By.cssSelector("//div[contains(@class,'VisibleControlPanel')]//div[contains(@class,'VisibleControlPanel')]//*[text()='No']")).click();
		driver.findElement(By.cssSelector("[id*='Next']")).click();

			
		//	entityFormSelection(dataMap);
		driver.findElement(By.cssSelector("[id*='W8ECI']")).click();
		driver.findElement(By.cssSelector("[id*='Next']")).click();

		
		//incomeType(dataMap);
		driver.findElement(By.cssSelector("[id*='CKBOX'] input")).click();		
		driver.findElement(By.cssSelector("[id*='Next']")).click();

	
		///entityType(dataMap);
		driver.findElement(By.cssSelector("[id*='RBList'] input")).click();
		driver.findElement(By.cssSelector("[id*='Next']")).click();
	
		//W8CI
		driver.findElement(By.cssSelector("[id*='RB'] tr:nth-child(2) input")).click();
		driver.findElement(By.cssSelector("[id*='Next']")).click();
		
		//Thailand
		//County Select
		driver.findElement(By.cssSelector("[id*='ORG'] select")).click();
		driver.findElement(By.cssSelector("[id*='Next']")).click();
		
		//{Ermananent add
		driver.findElement(By.cssSelector("[id*='RB'] tr:nth-child(2) input")).click();
		driver.findElement(By.cssSelector("[id*='Next']")).click();
						
			//Busi add							
		driver.findElement(By.cssSelector("[id*='RB'] tr:nth-child(2) input")).click();
		driver.findElement(By.cssSelector("[id*='Next']")).click();
		
		//USTIN
		driver.findElement(By.cssSelector("[id*='Next']")).click();
		
		//FTIN
		
		driver.findElement(By.cssSelector("[id*='FTIN'] input")).click();
		driver.findElement(By.cssSelector("[id*='FTINCOUNTRY11']")).click();//select
		driver.findElement(By.cssSelector("[id*='Next']")).click();	
				
	//	Business		
		driver.findElement(By.cssSelector("[id*='ADDRESS_1'] input")).click();
		driver.findElement(By.cssSelector("[id*='ADDRESS_2'] input")).click();
		driver.findElement(By.cssSelector("[id*='CITY'] input")).click();
		driver.findElement(By.cssSelector("[id*='STATE'] input")).click();
		driver.findElement(By.cssSelector("[id*='RB'] tr:nth-child(2) input")).click();
		driver.findElement(By.cssSelector("[id*='Next']")).click();							
		
														
		driver.findElement(By.cssSelector("[id*='Next']")).click();
																	
		
																		
		driver.findElement(By.cssSelector("[id*='Next']")).click();																			
		driver.findElement(By.cssSelector("[id*='Next']")).click();					
																						//confirm
		driver.findElement(By.cssSelector("[id*='Next']")).click();	
		
		driver.findElement(By.cssSelector("[id*='Next']")).click();	
		
		
		List<WebElement> sss=driver.findElements(By.cssSelector("[id*='CKBOX'] input"));
		
		driver.findElement(By.cssSelector("[class*='PIN']")).click();
		driver.findElement(By.cssSelector("[id*='Next']")).click();	
		
		
		driver.findElement(By.cssSelector("[id*='SaveAndExit']")).click();																								
																					
		lavanteUtils.switchtoFrame(null);
																						
		driver.findElement(By.cssSelector("[role*='dialog'] button[class*='gre']")).click();
																												
	}
		
	
}
