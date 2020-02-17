package lavante.recovery.pageobjects;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import lavante.recovery.utilities.LavanteUtils;
import lavante.recovery.utilities.seleniumBaseClass;

public class LoginPage {
	
	LavanteUtils lavanteUtils=new LavanteUtils();
	public WebDriver driver=null;
	public LoginPage(WebDriver driver){
		lavanteUtils.driver=driver;
	}
	
	
	@FindBy(id="username")
	private WebElement userName_txtField;
	
	
	@FindBy(id="password")
	private WebElement password_txtField;
	
	
	@FindBy(css="[src*='login_button.png']")
	private WebElement login_Button;
	
	
	/**
	 * Main Method For Login to Recovery application
	 * 
	 * User Name and password is picked from the conf file as one login as of now
	 * 
	 * @author Piramanayagam.S
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void login() throws FileNotFoundException, IOException{
		enterUserName(lavanteUtils.InitProperties("username"));
		enterPassWord(lavanteUtils.InitProperties("password"));	
		clickLoginButton();
	
	}
	
	public void enterUserName(String username) {

		lavanteUtils.typeinEdit(username, userName_txtField);
	}
	
	public void enterPassWord(String password) {
		lavanteUtils.typeinEdit( password, password_txtField);
	} 
	 
	public void clickLoginButton() {
		lavanteUtils.click( login_Button);
	}
	
	

}
