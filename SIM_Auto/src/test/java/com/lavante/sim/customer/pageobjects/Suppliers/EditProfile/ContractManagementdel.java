/**
 * 
 */
package com.lavante.sim.customer.pageobjects.Suppliers.EditProfile;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.lavante.sim.Common.Util.LavanteUtils;

/**
 * @author Piramanayagam.S
 *
 */
public class ContractManagementdel {
	
	LavanteUtils lavanteUtils=new LavanteUtils();
	public ContractManagementdel(WebDriver driver){
		lavanteUtils.driver=driver;	
	}

	
	@FindBy(how=How.CSS,using="#contractMgmt_table th")
	private List<WebElement> tableheaderlist;	
	public List<WebElement>  tableheaderlist(){
		return tableheaderlist;
	}
	
	@FindBy(how=How.CSS,using="Label")
	private  List<WebElement>  Label;	
	public  List<WebElement>  Labellist(){
		return Label;
	}
	
	@FindBy(how=How.CSS,using="a[href*='sow']")
	private List<WebElement> sowNoList;	
	public List<WebElement>  sowNoList(){
		return sowNoList;
	}
	

	@FindBy(how=How.CSS,using="iframe[src*='sow']")
	private WebElement IFRAMESOWView;	
	public WebElement  IFRAMESOWView(){
		return IFRAMESOWView;
	}
	
	@FindBy(how=How.CSS,using="iframe[id*='search']")
	private WebElement IFRAMESearchResult;	
	public WebElement  IFRAMESearchResult(){
		return IFRAMESearchResult;
	}
	
	
	
}
