/**
 * 
 */
package com.lavante.sim.customer.pageobjects.Suppliers.EditProfile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.lavante.sim.Common.Util.LavanteUtils;

/**
 * @author Piramanayagam.S
 *
 */
public class SupplierEditProfile {
	
	LavanteUtils lavanteUtils=null;
	
	public SupplierEditProfile(WebDriver driver){
		lavanteUtils.driver=driver;
	}
	
	@FindBy(how=How.CSS,using="iframe#search_results")
	private WebElement IFRAMEinvoiceresults;
	public WebElement IFRAMEinvoiceresults(){
		return IFRAMEinvoiceresults;
	}
	
	
	
}
