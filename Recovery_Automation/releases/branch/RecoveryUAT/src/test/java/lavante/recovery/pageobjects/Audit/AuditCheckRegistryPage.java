package lavante.recovery.pageobjects.Audit;

import org.openqa.selenium.By;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import lavante.recovery.utilities.LavanteUtils;
import lavante.recovery.utilities.seleniumBaseClass;

public class AuditCheckRegistryPage{
	


	LavanteUtils lavanteUtils=new LavanteUtils();
	public WebDriver driver=null;
	public AuditCheckRegistryPage(WebDriver driver){
		lavanteUtils.driver=driver;
	}
	
	
	//Check Registry Link
	@FindBy(css="a[href*='checkRequest.lvp']")
	private WebElement chkRegLink;
	public WebElement chkRegLink(){   //added by Ramya
		return chkRegLink;
	}
		
	public void verifychkRegLink() {
		
		lavanteUtils.click("chkRegLink",chkRegLink);
		lavanteUtils.fluentwait(chkRegLink);
	//	getHttpResponse();
	}

	//Registry list
	@FindBy(css="#registry-list tr td")
	private WebElement chkRegList;
	public WebElement chkRegList(){		//added by Ramya
		return chkRegList;
		
	}
		
	public void verifychkRegList() {
		
		lavanteUtils.isDisplayed("chkRegList",chkRegList);
		lavanteUtils.verifyError(chkRegList);	
	}
	
	//Add New Button
	@FindBy(css="#addNew")
	private WebElement addNewBtn;      
	public WebElement addNewBtn(){       //added by Ramya
		return addNewBtn;
	}
		
	public void verifyaddNewBtn() {
		
		lavanteUtils.isDisplayed("addNewBtn",addNewBtn);
		lavanteUtils.verifyError(addNewBtn);	
	}
}
