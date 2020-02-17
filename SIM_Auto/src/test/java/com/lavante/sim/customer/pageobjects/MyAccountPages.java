/**
 * 
 */
package com.lavante.sim.customer.pageobjects;

import java.util.LinkedHashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.lavante.sim.Common.Util.LavanteUtils;

/**
 * @author Piramanayagam.S
 *
 */
public class MyAccountPages {
	
	public WebDriver driver;
	LavanteUtils lavanteUtils=new LavanteUtils();
	public MyAccountPages(WebDriver driver){
		lavanteUtils.driver=driver;
		this.driver=driver;
	}
	
	@FindBy(css="a[class*='user-info']")
	private WebElement UserName;
	public WebElement Username(){
		return UserName;
	}
	
	@FindBy(css="ul a[href*='myAccount']")
	private  WebElement  myAccLink;	
	public WebElement  myAccLink(){
		return myAccLink;
	}
	
	@FindBy(css="[src*='myAccounts']")
	private  WebElement  IFRAMEMyAcc;	
	public WebElement  IFRAMEMyAcc(){
		return IFRAMEMyAcc;
	}
	
	
	//Reset Password Tab
	@FindBy(how=How.ID,using="currentPassword")
	private  WebElement  CurrentPwd;	
	public WebElement  CurrentPwd(){
		return CurrentPwd;
	}
	
	@FindBy(how=How.ID,using="newPassword")
	private  WebElement  NewPwd;	
	public WebElement  NewPwd(){
		return NewPwd;
	}
	
	@FindBy(how=How.ID,using="confirmPassword")
	private  WebElement  ConfirmPwd;	
	public WebElement  ConfirmPwd(){
		return ConfirmPwd;
	}
	
	
	///My Setting Tab
	
	@FindBy(css="a[href*='myPref']")
	private  WebElement  TabMySetting;	
	public WebElement  TabMySetting(){
		return TabMySetting;
	}
	
	@FindBy(css="[id*='language'] a")
	private  WebElement  langdrpdn;	
	public WebElement  langdrpdn(){
		return langdrpdn;
	}
	
	@FindBy(css="[id*='language'] input")
	private  WebElement  langtext;	
	public WebElement  langtext(){
		return langtext;
	}
	
	
	@FindBy(css="[id*='timeZone'] a")
	private  WebElement  timeZoneDpdn;	
	public WebElement  timeZoneDpdn(){
		return timeZoneDpdn;
	}
	
	@FindBy(css="[id*='timeZoneID'] input")
	private  WebElement  timeText;	
	public WebElement  timeText(){
		return timeText;
	}
	
	@FindBy(css="[type*='reset']")
	private  WebElement  clearBtn;	
	public WebElement  clearBtn(){
		return clearBtn;
	}
	
	@FindBy(css="[type*='submit']")
	private  WebElement  saveBtn;	
	public WebElement  saveBtn(){
		return saveBtn;
	}
	
	
	@FindBy(css="span[class*='error']")
	private  WebElement  ErrorMsg;	
	public WebElement  ErrorMsg(){
		return ErrorMsg;
	}
	
	@FindBy(css="[class*='front'][class*='dial'][style*='fixed'] div:nth-child(2)")
	private  WebElement  SuccessMsg;	
	public WebElement  SuccessMsg(){
		return SuccessMsg;
	}
	
	
	public void MyAccfill(LinkedHashMap<String, String> dataMap) {
		
		lavanteUtils.switchtoFrame(null);
		lavanteUtils.click(UserName);
		lavanteUtils.click(myAccLink);
		AccSettings(dataMap);
	}
	
	public void AccSettings(LinkedHashMap<String, String> dataMap) {
		
	
		lavanteUtils.switchtoFrame(IFRAMEMyAcc);
		
		Selecttab(dataMap);
		fillform(dataMap);
		formAction(dataMap);
	}


	private void Selecttab(LinkedHashMap<String, String> dataMap) {
		if(dataMap.containsKey("MySetting")){
			lavanteUtils.click(TabMySetting);
		}
		
	}


	private void fillform(LinkedHashMap<String, String> dataMap) {
		
	//Reset Password tab
		if(dataMap.containsKey("CurrentPassword")){
			lavanteUtils.typeinEdit(dataMap.get("CurrentPassword"),CurrentPwd);
		}
		if(dataMap.containsKey("NewPassword")){
			lavanteUtils.typeinEdit(dataMap.get("NewPassword"),NewPwd);
		}
		if(dataMap.containsKey("ConfirmPassword")){
			lavanteUtils.typeinEdit(dataMap.get("ConfirmPassword"),ConfirmPwd);
		}
		
		
		//My Setting Tab
		if(dataMap.containsKey("Language")){
			lavanteUtils.click(langdrpdn);
			lavanteUtils.switchtoFrame(null);
			lavanteUtils.typeinEdit(dataMap.get("Language"), langtext);
			lavanteUtils.selectvalueFrmDpdn(dataMap.get("Language"));
			lavanteUtils.switchtoFrame(IFRAMEMyAcc);
		}
		if(dataMap.containsKey("Timezone")){
			lavanteUtils.click(timeZoneDpdn);
			lavanteUtils.switchtoFrame(null);
			lavanteUtils.typeinEdit(dataMap.get("Timezone"), timeText);
			lavanteUtils.selectvalueFrmDpdn(dataMap.get("Timezone"));
			lavanteUtils.switchtoFrame(IFRAMEMyAcc);
		}
		
	}


	public void formAction(LinkedHashMap<String, String> dataMap) {
		lavanteUtils.switchtoFrame(IFRAMEMyAcc);
		
		if(dataMap.containsKey("Save")){
		
			if(dataMap.containsKey("VerifyMsg")){
				lavanteUtils.click(saveBtn);
				lavanteUtils.switchtoFrame(null);
				
			}else{
				lavanteUtils.click(saveBtn);
				lavanteUtils.switchtoFrame(null);
			}
		}
		
		if(dataMap.containsKey("Clear")){
			lavanteUtils.click(clearBtn);
		}
		
	}
	
	
	
	


}
