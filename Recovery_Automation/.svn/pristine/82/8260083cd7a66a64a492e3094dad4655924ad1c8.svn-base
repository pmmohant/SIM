package lavante.recovery.pageobjects;

import org.openqa.selenium.By;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import lavante.recovery.utilities.seleniumBaseClass;

public class HomePage extends seleniumBaseClass{
	
	@FindBy(id="frmQuickSearch")
	private WebElement quickSearch_Form;
	
	public void verifyHomePageDisplayed() {
		//fluentwait(quickSearch_Form);
		isDisplayed("quickSearch_Form",quickSearch_Form);
	}
	
/*	//Browser Startup pop up message
	@FindBy(css="div[style*='block'] [title*='close']")
	private WebElement browserStartPopUp;
	
	public int verifyBrowserStartPopUp() {	
		
		if(browserStartPopUp.isDisplayed()){
			browserStartPopUp.click();
			return 1;  
		}
		else
			return 0;
	}*/
	
	//Audit Drop down list
	@FindBy(css="#audit")
	private WebElement auditList;
	
	public void selectAuditList(String objNameStr) {	
		
		selectvalueFrmDpdn(objNameStr);  
	}

	
	//Audit Tab
	@FindBy(css="a[title='Audit']")
	private WebElement auditTab;
	
	public void verifyAuditTab() {	
		auditTab.click();
		  
	}
	
	//Click on audit drop down list
	@FindBy(css="[id='audit_chosen'] a[class='chosen-single']")
	private WebElement auditDropDownList;
	
	public void verifyAuditList() {	
		auditDropDownList.click();
		  
	}
	
	//Inbound Tab
	@FindBy(css="a[title='Inbound']")
	private WebElement inboundLandingPage;
	
	public void verifyInboundTab() {	
		inboundLandingPage.click();
		  
	}

}
