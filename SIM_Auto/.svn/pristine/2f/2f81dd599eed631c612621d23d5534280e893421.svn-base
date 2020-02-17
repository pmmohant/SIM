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
public class Cache {
	
	LavanteUtils lavanteUtils=new LavanteUtils();
	
	public Cache(WebDriver driver){
		lavanteUtils.driver=driver;
	}
	
	@FindBy(css = "div[class*='caption']")
	public WebElement title;
	
	
	//Sanity
	public void CacheSanity() {
		Reporter.log("Expected Title: Second Level Cache Statistics,Actuals"+title.getText(),true);
		Assert.assertEquals(title.getText(), "Second Level Cache Statistics","Title not matched");
		
	}
	
	
}
