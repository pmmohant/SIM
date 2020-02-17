package lavante.recovery.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import lavante.recovery.utilities.LavanteUtils;

public class GenericPageObjects {
 
			
		LavanteUtils lavanteUtils = new LavanteUtils();
	
		public GenericPageObjects(WebDriver driver) {
			lavanteUtils.driver = driver;
		}
	
		@FindBy(css="div[class*='notify'] button span")
		private List<WebElement> BrowserInfo;
			
		public List<WebElement> BrowserInfo() {
			return BrowserInfo;
		}
	
	
		//Alert--Close Button
		@FindBy(css="button[type='button'] span")
		private WebElement alertBtn;
			
		public void clickOnAlert() {
			//clickOnAlert("alertBtn",alertBtn);
		}
		
		//Add New Button
		@FindBy(id="addNew")
		private WebElement addNewBtn;
			
		public void verifyaddNewBtn() {
			
			lavanteUtils.isDisplayed("addNewBtn",addNewBtn);
			lavanteUtils.verifyError(addNewBtn);
		}
		
		//Save Button
		@FindBy(css="input[value='Save']")
		private WebElement saveBtn;
			
		public void verifysaveBtn() {
			lavanteUtils.click("saveBtn",saveBtn);
			lavanteUtils.isDisplayed("saveBtn",saveBtn);
			lavanteUtils.verifyError(saveBtn);
		}
		
		//Select Audit drop down list
		@FindBy(css="#audit_chosen a div")
		private WebElement auditSelectbox;
			
		public void verifyAuditSelectBox() {
			lavanteUtils.fluentwait(auditSelectbox);
			if(BrowserInfo.size()>0){
				lavanteUtils.fluentwait(BrowserInfo.get(0));
				lavanteUtils.click(BrowserInfo.get(0),"BrowserInfo");
			}
			lavanteUtils.fluentwait(auditSelectbox);
			lavanteUtils.click(auditSelectbox);
			lavanteUtils.isDisplayed("auditSelectbox",auditSelectbox);
			lavanteUtils.verifyError(auditSelectbox);
		}
		
		//Enter Audit in drop down text box
		@FindBy(css="#audit_chosen .chosen-drop .chosen-search input[type='text']")
		private WebElement auditdrpDownTextBox;
			
		public void verifyAuditSelectBoxTextBox() {
			lavanteUtils.enterText("auditdrpDownTextBox",auditdrpDownTextBox,"Brinker");
			lavanteUtils.isDisplayed("auditdrpDownTextBox",auditdrpDownTextBox);
			lavanteUtils.verifyError(auditdrpDownTextBox);
			lavanteUtils.ActionsTextBox(auditdrpDownTextBox);
		}
		
		
		public void verifyAuditSelectBoxTextBox(String value) {
			lavanteUtils.enterText("auditdrpDownTextBox",auditdrpDownTextBox,value);
			lavanteUtils.isDisplayed("auditdrpDownTextBox",auditdrpDownTextBox);
			lavanteUtils.verifyError(auditdrpDownTextBox);
			lavanteUtils.ActionsTextBox(auditdrpDownTextBox);
		}
		
		
		/**
		 * Selection of Audit 
		 * 
		 * @author Piramanayagam.S
		 * @param expAudit
		 */
		public void SelectAudit(String expAudit) {
			lavanteUtils.fluentwait(auditSelectbox);
			if(BrowserInfo.size()>0){
				lavanteUtils.fluentwait(BrowserInfo.get(0));
				lavanteUtils.click(BrowserInfo.get(0),"BrowserInfo");
			}
			lavanteUtils.fluentwait(auditSelectbox);
			lavanteUtils.click(auditSelectbox);
			lavanteUtils.isDisplayed("auditSelectbox",auditSelectbox);
			
			lavanteUtils.typeinEdit(expAudit,auditdrpDownTextBox);
			lavanteUtils.selectvalueFrmDpdn(expAudit);
			lavanteUtils.isDisplayed("auditdrpDownTextBox",auditdrpDownTextBox);
			//lavanteUtils.ActionsTextBox(auditdrpDownTextBox);
		}
		
		
/*		//Select Audit from drop down list
		@FindBy(css="#audit_chosen a")
		private WebElement auditSelectOption;
			
		public void verifyAuditSelectBoxOption() {
			List<WebElement> allOptions = auditSelectbox.findElements(By.cssSelector("auditSelectOption"));
			
			for(WebElement option:allOptions){
				 if(option.getText().equals("AllianceBernstein")){
					 option.click();
				 }
			}
			isDisplayed("auditSelectbox",auditSelectbox);
			verifyError(auditSelectbox);
		}*/
		
		
		

}
