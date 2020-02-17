package lavante.recovery.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import lavante.recovery.utilities.seleniumBaseClass;

public class LoginPage extends seleniumBaseClass {
	
	
	@FindBy(id="username")
	private WebElement userName_txtField;
	public void enterUserName(String username) {

		enterText("userName_txtField", userName_txtField, username);
	}
	
	@FindBy(id="password")
	private WebElement password_txtField;
	public void enterPassWord(String password) {

		enterText("password_TextField", password_txtField, password);
	} 
	
	@FindBy(css="[src*='login_button.png']")
	//@FindBy(css="input[name='submit']")
	private WebElement login_Button;
	public void clickLoginButton() {
		
		fluentwait(login_Button);
		click("login_Button", login_Button);
	}
	
	
	

	
	

	
	

}
