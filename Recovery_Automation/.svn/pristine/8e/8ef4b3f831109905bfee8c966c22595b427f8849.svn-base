package lavante.recovery.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import lavante.recovery.utilities.seleniumBaseClass;

public class GenericPageObjects extends seleniumBaseClass {
 
		//Alert--Close Button
		@FindBy(css="button[type='button'] span")
		private WebElement alertBtn;
			
		public void clickOnAlert() {
			clickOnAlert("alertBtn",alertBtn);
		}
		
		//Add New Button
		@FindBy(id="addNew")
		private WebElement addNewBtn;
			
		public void verifyaddNewBtn() {
			
			isDisplayed("addNewBtn",addNewBtn);
			verifyError(addNewBtn);
		}
		
		//Save Button
		@FindBy(css="input[value='Save']")
		private WebElement saveBtn;
			
		public void verifysaveBtn() {
			click("saveBtn",saveBtn);
			isDisplayed("saveBtn",saveBtn);
			verifyError(saveBtn);
		}
		
		//Select Audit drop down list
		@FindBy(css="#audit_chosen a")
		private WebElement auditSelectbox;
			
		public void verifyAuditSelectBox() {

			click("auditSelectbox",auditSelectbox);
			//fluentwait(auditSelectbox);
			isDisplayed("auditSelectbox",auditSelectbox);
			verifyError(auditSelectbox);
		}
		
		//Enter Audit in drop down text box
		@FindBy(css="#audit_chosen .chosen-drop .chosen-search input[type='text']")
		private WebElement auditdrpDownTextBox;
			
		public void verifyAuditSelectBoxTextBox() {
			enterText("auditdrpDownTextBox",auditdrpDownTextBox,"Kaiser Permanente");
			isDisplayed("auditdrpDownTextBox",auditdrpDownTextBox);
			verifyError(auditdrpDownTextBox);
			ActionsTextBox(auditdrpDownTextBox);
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
