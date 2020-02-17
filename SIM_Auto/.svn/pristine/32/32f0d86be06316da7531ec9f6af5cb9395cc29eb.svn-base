/**
 * 
 */
package com.lavante.sim.customer.pageobjects.Suppliers.EditProfile;

import java.util.LinkedHashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.lavante.sim.Common.Util.LavanteUtils;

/**
 * @author Piramanayagam.S
 *
 */
public class EditProfEnterprise {
	
	LavanteUtils lavanteUtils=new LavanteUtils();

	
	public EditProfEnterprise(WebDriver driver){
		lavanteUtils.driver=driver;
	}
	
	//Locators
	@FindBy(id="supplierAliasName")
	private WebElement supplierAliasName;	
	public WebElement  supplierAliasName(){
		return supplierAliasName;
	}
	
	@FindBy(css="iframe[src*='addEditContact']")
	private WebElement IFRAMEaddUser;	
	public WebElement  IFRAMEaddUser(){
		return IFRAMEaddUser;
	}
	
	@FindBy(css="button[href*='addEditContact']")
	private WebElement adduserbtn;	
	public WebElement  adduserbtn(){
		return adduserbtn;
	}	
		
	@FindBy(id="contactName")
	private WebElement usrname;	
	public WebElement  usrname(){
		return usrname;
	}
	
	@FindBy(id="email")
	private WebElement usremail;	
	public WebElement  usremail(){
		return usremail;
	}
	
	@FindBy(css="button[type='submit']")
	private WebElement saveUserbtn;	
	public WebElement  saveUserbtn(){
		return saveUserbtn;
	}
	
	@FindBy(css="span[class*='err']")
	private WebElement errmsg;	
	public WebElement errormsg() {
		return errmsg;
	}
	
	@FindBy(id="supplierIdEdit")
	private WebElement erpid;	
	public WebElement  erpid(){
		return erpid;
	}
	//REUSABLE METHODS 
	
	
	public void fillkeySupplierInfo(LinkedHashMap<String, String> dataMap) {
		
		if(dataMap.containsKey("ERPID")){
			lavanteUtils.fluentwait(erpid());
			erpid.clear();
			lavanteUtils.typeString(dataMap.get("ERPID"), erpid());
		}
		
		
	}
	
	
	public String[] addnwuser(LinkedHashMap<String, String> dataMap) {
		
		lavanteUtils.fluentwait(adduserbtn);
		lavanteUtils.click(adduserbtn());
		lavanteUtils.switchtoFrame(IFRAMEaddUser);
		String[] das=new String[10];
		das=filladdnwuser(dataMap);
		formActionnwuser(dataMap);
		return das;
	}


	private String[] filladdnwuser(LinkedHashMap<String, String> dataMap) {
		String[] das=new String[10];
		if(dataMap.containsKey("UserName")){
			das[0]=lavanteUtils.typeString(dataMap.get("UserName"), usrname());
		}
		if(dataMap.containsKey("UserEmail")){
			String data=dataMap.get("UserEmail");
			if(data.equalsIgnoreCase("ANY")){
				String rand=""+LavanteUtils.randomnum();
				data="SP"+rand+"@"+rand+".com";
			
			}
			das[1]=lavanteUtils.typeString(data, usremail());
		}
		return das;
	}


	private void formActionnwuser(LinkedHashMap<String, String> dataMap) {
		if(dataMap.containsKey("SaveUser")){
			lavanteUtils.click(saveUserbtn());
		}
		
	}


	

		

}
