package lavante.recovery.pageobjects;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import lavante.recovery.utilities.seleniumBaseClass;
import lavante.recovery.utilities.LavanteUtils;

public class HomePage {
	
	LavanteUtils lavanteUtils = new LavanteUtils();
	
	public HomePage(WebDriver driver) {
		lavanteUtils.driver = driver;
	}

	
	@FindBy(how=How.CSS,using="[href*='logout']")
	private WebElement logoutbtn;
	
	@FindBy(id="frmQuickSearch")
	private WebElement quickSearch_Form;
	
	@FindBy(css="#searchSelect_chosen>a")
	private WebElement quickSearchDDL;
	
	@FindBy(id="searchText")
	private WebElement quickSrchTxtBox;
	
	@FindBy(id="searchButton")
	private WebElement quickSrchBtn;
	
	public void verifyHomePageDisplayed() {
		lavanteUtils.fluentwait(quickSearch_Form);
		lavanteUtils.isDisplayed("quickSearch_Form",quickSearch_Form);
		lavanteUtils.waitforPageLoad(quickSearch_Form);
		 verifyBrowserStartPopUp();
	}
	
	public void verifyBrowserStartPopUp() {
		lavanteUtils.fluentwait(quickSearchDDL);
		lavanteUtils.fluentwait(quickSrchTxtBox);
		lavanteUtils.waitForTime(3000);
		 List<WebElement> popUp = lavanteUtils.driver.findElements(By.cssSelector("div[style*='block'] [title*='close']"));
		 System.out.println(popUp.size());
		 if(popUp.size() > 0){
			 popUp.get(0).click();
		 }	
		 
		 else
			lavanteUtils.waitForTime(3000);
	}
	
	@FindBy(css="#audit_chosen a div")
	private WebElement auditSelectbox;

	@FindBy(css="[id*='audit'] input[type='text']")
	private WebElement auditdrpDownTextBox;
	
	/**
	 * Selection of Audit 
	 * 
	 * @author Piramanayagam.S
	 * @param expAudit
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public void SelectAudit(String expAudit) throws FileNotFoundException, IOException {
		
		verifyHomePageDisplayed();
		lavanteUtils.fluentwait(auditSelectbox);
		
		if(expAudit.length()>0){
			lavanteUtils.click(auditSelectbox);
			if(expAudit.equalsIgnoreCase("ANY")){
				expAudit=lavanteUtils.InitProperties("DefaultAudit");
				expAudit=expAudit.trim();
			}
			lavanteUtils.typeinEdit(expAudit,auditdrpDownTextBox);
			lavanteUtils.selectvalueFrmDpdn(expAudit);
			lavanteUtils.waitforPageload(auditSelectbox);
			lavanteUtils.fluentwait(auditSelectbox);
		}
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
		
		lavanteUtils.selectvalueFrmDpdn(objNameStr);  
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
		lavanteUtils.click(auditDropDownList);
		  
	}
	
	//Inbound Tab
	@FindBy(css="a[title='Inbound']")
	private WebElement inboundLandingPage;
	
	public void verifyInboundTab() {	
		lavanteUtils.click(inboundLandingPage);
		  
	}

	
	/**
	 * Logout Application
	 * 
	 * @author Piramanayagam.S
	 */
	public void logout() {
		lavanteUtils.switchtoFrame(null);
		lavanteUtils.fluentwait(logoutbtn);
		lavanteUtils.click(logoutbtn);

	}
	
	
}
