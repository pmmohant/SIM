/**
 * 
 */
package com.lavante.sim.customer.pageobjects.SupportProperties;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import org.testng.Reporter;

import com.lavante.sim.Common.Util.LavanteUtils;

/**
 * @author Piramanayagam.S
 *
 */
public class CustomerSetup {
	
	LavanteUtils lavanteUtils=new LavanteUtils();
	
	public CustomerSetup(WebDriver driver){
		lavanteUtils.driver=driver;
	}
	
	@FindBy(css = "div[class*='caption']")
	public WebElement title;
	
	@FindBy(css = "tbody a")
	public List<WebElement> CustomerList;
	
	//Sanity
	public void customerSanity() throws FileNotFoundException, IOException, SQLException{
		Reporter.log("Expected Title:Customer List,Actuals"+title.getText(),true);
		Assert.assertEquals(title.getText(), "Customer List","Title not matched");
		
		String count=""+CustomerList.size();
		String x="SELECT Count(Name) FROM customer";
		x=lavanteUtils.fetchDBdata(x);
		
		Reporter.log("Total count of Customer"+x+",Actuals:"+count,true);
		Assert.assertEquals(x,count,"Customer Count not matched");
		
	}
	
	
}
