package lavante.recovery.pageobjects.Configuration.Setup;

import org.openqa.selenium.By;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import lavante.recovery.utilities.LavanteUtils;
import lavante.recovery.utilities.seleniumBaseClass;

public class RequestLettersPage {
	
	LavanteUtils lavanteUtils=new LavanteUtils();
	public WebDriver driver=null;
	public RequestLettersPage(WebDriver driver){
		lavanteUtils.driver=driver;
	}
	
	//Configuration--Setup--Request Letters Link
	@FindBy(css="a[href*='request']")
	private WebElement reqLetterLink;
	public WebElement reqLetterLink(){		//added by Ramya
		return reqLetterLink;
	}
		
	public void verifyReqLetterLink() {
		lavanteUtils.fluentwait(reqLetterLink);
		lavanteUtils.click("reqLetterLink",reqLetterLink);
	//	getHttpResponse();
	}
		
	//Save Button
	@FindBy(css="input[value='Save']")
	private WebElement saveBtn;
	public WebElement saveBtn(){			//added by Ramya
		return saveBtn;
	}
	
	//Reset Button
		@FindBy(css="input[value='Reset']")
		private WebElement resetBtn;
		public WebElement resetBtn(){			//added by Ramya
			return saveBtn;
		}
		
	
		
	public void verifysaveBtn() {
		lavanteUtils.fluentwait(saveBtn);
		lavanteUtils.click("saveBtn",saveBtn);
	//	getHttpResponse();
		lavanteUtils.isDisplayed("saveBtn",saveBtn);
		lavanteUtils.verifyError(saveBtn);
	}
	
	//Request Letters table
	@FindBy(css="#requestLetter_config_form table tr")
	private WebElement reqLetterTable;
	public WebElement reqLetterTable(){				//added by Ramya
		return reqLetterTable;
		
		
	}
	public void verifyReqLetterTable() {
		lavanteUtils.fluentwait(reqLetterTable);
		lavanteUtils.isDisplayed("reqLetterTable",reqLetterTable);
		lavanteUtils.verifyError(reqLetterTable);
	}

}
