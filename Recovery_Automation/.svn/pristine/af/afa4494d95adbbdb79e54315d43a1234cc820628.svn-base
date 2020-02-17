package lavante.recovery.pageobjects.Configuration.Setup;

import org.openqa.selenium.By;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import lavante.recovery.utilities.LavanteUtils;
import lavante.recovery.utilities.seleniumBaseClass;

public class AuditPage {
	
	LavanteUtils lavanteUtils=new LavanteUtils();
	public WebDriver driver=null;
	public AuditPage(WebDriver driver){
		lavanteUtils.driver=driver;
	}
	
	
	//Configuration link
	@FindBy(linkText="Configuration")
	private WebElement configurationLink;
		
	public void verifyconfigurationLink() {
		lavanteUtils.fluentwait(configurationLink);
		lavanteUtils.click("configurationLink",configurationLink);
		
	}
	
	//Configuration--Setup Link
	@FindBy(linkText="SetUp")
	private WebElement setUpLink;
	public WebElement setUpLink(){   //added by Ramya
		return setUpLink;
	}
		
	public void verifySetUpLink() {
		lavanteUtils.fluentwait(setUpLink);
	//	click("setUpLink",setUpLink);
	}
	
	//Configuration--Setup--Audit Link
	@FindBy(css="a[href='configuration.lvp']")
	private WebElement setUpAuditLink;
	public WebElement setUpAuditLink(){   //added by Ramya
		return setUpAuditLink;
	}
		
	public void verifysetUpAuditLink() {
		lavanteUtils.fluentwait(setUpAuditLink);
		lavanteUtils.click("setUpAuditLink",setUpAuditLink);
	}
	
	//Save Button
	@FindBy(css="input[value='Save']")
	private WebElement saveBtn;
	public WebElement saveBtn(){        //added by Ramya
		return saveBtn;
	}
		
	public void verifysaveBtn() {
		lavanteUtils.fluentwait(saveBtn);
		lavanteUtils.click("saveBtn",saveBtn);
		lavanteUtils.isDisplayed("saveBtn",saveBtn);
		lavanteUtils.verifyError(saveBtn);
	}
	
	//Alert--Close Button
	@FindBy(css="button[type='button'] span")
	private WebElement alertBtn;
		
	public void clickOnAlert() {
	//	clickOnAlert("alertBtn",alertBtn);
		lavanteUtils.fluentwait(alertBtn);
	}
	
	//Add New Button
	@FindBy(id="addNew")
	private WebElement addNewBtn;
	public WebElement addNewBtn(){			//added by Ramya
		return addNewBtn;
	}
		
	public void verifyaddNewBtn() {
		lavanteUtils.fluentwait(addNewBtn);
		lavanteUtils.isDisplayed("addNewBtn",addNewBtn);
		lavanteUtils.verifyError(addNewBtn);
	}
	
	
	//AuditSetup page--VRL Credits
	@FindBy(css="#vrlCredits")
	private WebElement vrlCredits;
	public WebElement vrlCredits(){			//added by Ramya
		return vrlCredits;
	}
	
	public String fetchVRLCredits(){
		String VRLCount = lavanteUtils.getattributeByValue(vrlCredits);
		return VRLCount;
	}

}
