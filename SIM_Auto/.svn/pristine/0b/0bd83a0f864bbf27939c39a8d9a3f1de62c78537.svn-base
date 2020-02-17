/**
 * 
 */
package com.lavante.sim.Common.Util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.lavante.sim.Common.Util.LavanteUtils;

/**
 * @author Piramanayagam.S
 *
 */
public class Gmail {
	
	public WebDriver driver;
	LavanteUtils lavanteUtils=new LavanteUtils();
	public Gmail(WebDriver driver){
		this.driver=driver;
		lavanteUtils.driver=driver;
		
	}
	

	
	@FindBy(how=How.CSS,using="Email")
	private WebElement username;
	public WebElement username(){
		return username;
	}

	
	@FindBy(how=How.CSS,using="Passwd")
	private WebElement password;
	public WebElement password(){
		return password;
	}
	
	@FindBy(how=How.ID,using="signIn")
	private WebElement siginbtn;	
	public WebElement siginbtn(){
		return siginbtn;
	}
	
	@FindBy(how=How.ID,using="next")
	private WebElement nextbtn;
	public WebElement nextbtn(){
		return nextbtn;
	}
		

	@FindBy(how=How.CSS,using="a[href*='inbox'][href*='mail']")
	private WebElement inbox;
	public WebElement inbox() {
	return inbox;
	}
	

	@FindBy(how=How.ID,using="[role*='main'] [class*='Cp'] tr td:nth-child(6)")
	private List<WebElement> ListofMailSub;
	public List<WebElement> ListofMailSub() {
	return ListofMailSub;
	}

	

	@FindBy(how=How.CSS,using="a[href*='SignOut']")
	private WebElement signoutbtn;
	public WebElement signoutbtn() {
	return signoutbtn;
	}	
	
	@FindBy(how=How.CSS,using="a[href*='Logout']")
	private WebElement logoutbtn;
	public WebElement logoutbtn() {
	return logoutbtn;
	}	
	
		
	
	public void logout() {
		signoutbtn().click();
		lavanteUtils.fluentwait(logoutbtn());
		logoutbtn().click();
		
	}



	public void CheckMail() throws FileNotFoundException, IOException {

		driver.manage().timeouts().pageLoadTimeout(5000, TimeUnit.MILLISECONDS);
		try{
		driver.get("https://accounts.google.com/ServiceLogin?service=mail&passive=true&rm=false&continue=https://mail.google.com/mail/&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1#identifier");
		lavanteUtils.waitForTime(15000);
		}catch(Exception e){
			
		}
		//driver.findElement(By.tagName("body")).sendKeys("Keys.ESCAPE");
		lavanteUtils.fluentwait(nextbtn());
		fillLogindetailandsignin();
	
	}




	private void fillLogindetailandsignin() throws FileNotFoundException, IOException {

		lavanteUtils.fluentwait(username());
//		username().sendKeys(CommonUtils.InitProperties("GMAIL_AUTH_USER"));
		username().sendKeys("piramusss");
		nextbtn().click();
		lavanteUtils.fluentwait(siginbtn());
		password().sendKeys(LavanteUtils.InitProperties("GMAIL_AUTH_PWD"));
		siginbtn().click();
		lavanteUtils.fluentwait(inbox());
	}



	public void Gmaillogout() {
		
	}
	
}
