/**
 * 
 */
package com.lavante.sim.customer.pageobjects.SupportProperties;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.Reporter;

import com.lavante.sim.Common.Util.LavanteUtils;

/**
 * @author Piramanayagam.S
 *
 */
public class Properties {
	
	LavanteUtils lavanteUtils=new LavanteUtils();
	
	public Properties(WebDriver driver){
		lavanteUtils.driver=driver;
	}
	
	@FindBy(css="div[class*='caption']")
	private List<WebElement> tableHeader;
	public List<WebElement> tableHeader(){
		return tableHeader;
	}
	
	public String getPropValue(String propname){
		String propvalue="//*[contains(@title,'"+propname+"')]/..//td[2]";
		lavanteUtils.fluentwait(lavanteUtils.driver.findElement(By.xpath(propvalue)));
		propvalue=lavanteUtils.getText(lavanteUtils.driver.findElement(By.xpath(propvalue)));
		return propvalue;
	}
	
	

	public void verifyTablePresent() {
		
		String[] s=new String[10];
		s[0]="Application Properties From DB";
		s[1]="Anti-virus properties";
		s[2]="Application Properties From File";
		s[3]="Fax properties";
		s[4]="Fax properties";
		for(int i=0;i<tableHeader.size();i++){
			String x=tableHeader.get(i).getText();
			Reporter.log("Header Expected:"+s[i]+",Actuals:"+x);
			Assert.assertEquals(s[i], x,"Header Not Matched");
		}
	}
	
}
