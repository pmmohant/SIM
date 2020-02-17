/**
 * 
 */
package com.lavante.sim.customer.pageobjects.Admin;


import java.util.LinkedHashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.lavante.sim.Common.Util.LavanteUtils;

/**
 * @author Ramya
 *
 */
public class GLCodePage {
	
	public LavanteUtils lavanteUtils=new LavanteUtils();
	
	public GLCodePage(WebDriver driver){
		lavanteUtils.driver=driver;
	}
	
	@FindBy(css="button[class*='add_Gl_codes']")
	private WebElement addGLCodeButton;
	public WebElement addGLCodeButton(){
		return addGLCodeButton;
	}
	
	@FindBy(css="input[class*='edit_GLCodes']")
	private WebElement GLCodeTextbox;
	public WebElement GLCodeTextbox(){
		return GLCodeTextbox;
	}
	
	@FindBy(css="input[class*='edit_GLCodes field']")
	private WebElement GLCodeEditbox;
	public WebElement GLCodeEditbox(){
		return GLCodeEditbox;
	}
	
	@FindBy(css="select[class*='glCodesStatus']")
	private WebElement statusDropdown;
	public WebElement statusDropdown(){
		return statusDropdown;
	}
	
	@FindBy(css="div[class*='icon_file_save']")
	private WebElement saveIcon;
	public WebElement saveIcon(){
		return saveIcon;
	}
	
	@FindBy(css="a[class*='icon_delete']")
	private WebElement deleteGLCodeIcon;
	public WebElement deleteGLCodeIcon(){
		return deleteGLCodeIcon;
	}
	
	@FindBy(css="select[class*='no-chosen']")
	private WebElement filter;
	public WebElement filter(){
		return filter;
	}
	
	@FindBy(id = "glCode")
	private WebElement GLCodeSearchbox;
	public WebElement GLCodeSearchbox(){
		return GLCodeSearchbox;
	}
	
	@FindBy(id= "searchGLCode")
	private WebElement searchbutton;
	public WebElement searchbutton(){
		return searchbutton;
	}
	
	@FindBy(css="div[class*='wrap_text']")
	private WebElement GLCodeText;
	public WebElement GLCodeText(){
		return GLCodeText;
	}
	
	@FindBy(css="table[class*='data_table'] tbody tr:nth-child(1) td:nth-child(1)")
	private WebElement glcodeTableValue;
	public WebElement glcodeTableValue(){
		return glcodeTableValue;
	}
	
	@FindBy(css="table[class*='data_table'] tbody tr:nth-child(1) td:nth-child(3) a")
	private WebElement GlCodeDelete;
	public WebElement GlCodeDelete(){
		return GlCodeDelete;
	}
	
	@FindBy(css="button[class*='button_primary']:nth-child(2)")
	private WebElement deleteConfirmButton;
	public WebElement deleteConfirmButton(){
		return deleteConfirmButton;
	}
	
	@FindBy(css="table[class*='data_table'] tr td")
	private WebElement noResultsText;
	public WebElement noResultsText(){
		return noResultsText;
	}
	
	@FindBy(css="div[class*='bannerMessage']")
	private WebElement Message;
	public WebElement Message(){
		return Message;
	}
	
	@FindBy(css="tr:nth-child(1) div[class*='icon_edit']")
	private WebElement editGlcode;
	public WebElement editGlcode(){
		return editGlcode;
	}
	
	public void createGLCode(LinkedHashMap<String, String> dataMap){
		
		if(dataMap.containsKey("AddGLCode")){
			lavanteUtils.click(addGLCodeButton);
		}
		
		if(dataMap.containsKey("GLCode")){
			String data = dataMap.get("GLCode");
			lavanteUtils.typeString(data,GLCodeTextbox);
	    }
		
		if(dataMap.containsKey("Status")){
			String data = dataMap.get("Status");
			lavanteUtils.click(statusDropdown);
			lavanteUtils.selectFrmDpdn(data);
		}
		
		if(dataMap.containsKey("SaveIcon")){
			lavanteUtils.click(saveIcon);
			lavanteUtils.waitForTime(4000);
			lavanteUtils.fluentwait(searchbutton);
		}
	}	
		
	 public void searchGLCode(LinkedHashMap<String, String> dataMap){
	    if(dataMap.containsKey("SearchValue")){
	    	String data=dataMap.get("SearchValue");
	    	lavanteUtils.fluentwait(GLCodeSearchbox);
	    		if(data.length()>0){
	    			GLCodeSearchbox.clear();
	    			lavanteUtils.typeString(data, GLCodeSearchbox);
	    		}
		}
		lavanteUtils.fluentwait(searchbutton);
		lavanteUtils.click(searchbutton);
		lavanteUtils.fluentwait(searchbutton);
		
	}
	 
	 
	 
	 	/**
	 	 * Used for Sanity
	 	 * 
	 	 * @author Thejaswi.Bhat
	 	 */
		//Sanity
		public boolean verifyGLCodePage() {
			boolean eval=false;

			lavanteUtils.switchtoFrame(null);
			lavanteUtils.fluentwait(addGLCodeButton);
			boolean flag1=lavanteUtils.verifyElementDisplayed("Add GL Code", addGLCodeButton);
			boolean flag2=lavanteUtils.verifyElementDisplayed(" GL Code Search Box", GLCodeSearchbox);
			boolean flag3=lavanteUtils.verifyElementDisplayed(" GL Code Search button", searchbutton);
			boolean flag4=lavanteUtils.verifyElementDisplayed(" GL Code Search Text", GLCodeText);
			boolean flag5=lavanteUtils.verifyElementDisplayed("Filter Dropdown", filter);

			if(flag1 && flag2 && flag3 && flag4 && flag5){
				eval=true;
			}
			return eval;
			
		}

			
}
		
	
    	
	