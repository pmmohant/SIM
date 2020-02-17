package com.lavante.sim.customer.pageobjects.Login;

import java.util.LinkedHashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.lavante.sim.Common.Util.LavanteUtils;

public class ForgotPwd {
	

	public WebDriver driver;
	LavanteUtils lavanteUtils = new LavanteUtils();;

	public ForgotPwd(WebDriver driver) {
		this.driver = driver;
		lavanteUtils.driver = driver;
	}
	
	
	@FindBy(how=How.ID,using="linkForgotPWD")
	private WebElement forgotPwdLink;	
	public WebElement forgotPwdLink(){
		return forgotPwdLink;
	}

	@FindBy(how=How.ID,using="UserName")
	private WebElement unameTxt;	
	public WebElement usernameTxt(){
		return unameTxt;
	}
	
	@FindBy(how=How.CSS,using="input[class*='green']")
	private WebElement UserNameNxt;	
	public WebElement UserNameNxt(){
		return UserNameNxt;
	}
	
	@FindBy(how=How.ID,using="resetLink")
	private WebElement resetLinkpwd;	
	public WebElement resetLinkpwd(){
		return resetLinkpwd;
	}
	
	@FindBy(how=How.ID,using="ChAnswer")
	private WebElement ChAnswer;	
	public WebElement ChAnswer(){
		return ChAnswer;
	}
	
	@FindBy(how=How.CSS,using="input[class*='green']")
	private WebElement forgotPwdSubmit;	
	public WebElement forgotPwdSubmit(){
		return forgotPwdSubmit;
	}
	
	@FindBy(how=How.ID,using="Password")
	private WebElement setPwd;	
	public WebElement setPwd(){
		return setPwd;
	}
	
	@FindBy(how=How.ID,using="ConfirmPWD")
	private WebElement ConfirmPWD;	
	public WebElement ConfirmPWD(){
		return ConfirmPWD;
	}
	
	@FindBy(how=How.CSS,using="td[class*='content'] p")
	private WebElement successMsg;	
	public WebElement successMsg(){
		return successMsg;
	}
	
	public void challangeAns(LinkedHashMap<String,String> dataMap) {
		
		lavanteUtils.click(forgotPwdLink);
		enterUname(dataMap);
		enterForgotAns(dataMap);
	}


	private void enterUname(LinkedHashMap<String, String> dataMap) {
		lavanteUtils.fluentwait(unameTxt);
		
		if(dataMap.containsKey("UserName")){
			String x=dataMap.get("UserName");
			lavanteUtils.typeinEdit(x, unameTxt);	
		}
		if(dataMap.containsKey("UserErrorMsg")){
			
		}else{
			lavanteUtils.click(UserNameNxt);
		}
		
	}
	

	private void enterForgotAns(LinkedHashMap<String, String> dataMap) {
		lavanteUtils.fluentwait(ChAnswer);
		
		if(dataMap.containsKey("ChAnsErrorMsg")){
			
		}else{
			if(dataMap.containsKey("ChAnswer")){
				String x=dataMap.get("ChAnswer");
				lavanteUtils.typeinEdit(x, ChAnswer);	
				
				lavanteUtils.click(forgotPwdSubmit);
			}
			
		}
		
	}

	private void changePwdForm(LinkedHashMap<String, String> dataMap) {
		
		lavanteUtils.fluentwait(setPwd);
		if(dataMap.containsKey("PwdErrorMsg")){
			
		}else{
			if(dataMap.containsKey("SetPwd")){
				String x=dataMap.get("SetPwd");
				lavanteUtils.typeinEdit(x, setPwd);	
				lavanteUtils.typeinEdit(x, ConfirmPWD);	
			}
			
			lavanteUtils.click(forgotPwdSubmit);
		}
	}


}
