package lavante.recovery.pageobjects.Configuration.Others;

import org.openqa.selenium.By;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import lavante.recovery.utilities.seleniumBaseClass;

public class CreditRejectionPage extends seleniumBaseClass{
			
		//Configuration--Others--Credit Rejection Link
		@FindBy(css="a[href*='creditRejectionReason']")
		private WebElement othersCreditRejectionLink;
			
		public void verifyOthersCreditRejectionLink() {
			fluentwait(othersCreditRejectionLink);
			click("othersCreditRejectionLink",othersCreditRejectionLink);
		}
				
		//Others--Credit Rejection table
		@FindBy(css="#credit_rejection tr")
		private WebElement othersCreditRejectionTable;
			
		public void verifyOthersCreditRejectionTable() {
			fluentwait(othersCreditRejectionTable);
			isDisplayed("othersCreditRejectionTable",othersCreditRejectionTable);
			verifyError(othersCreditRejectionTable);
		}
		
		//Add New Button
		@FindBy(css="input[title='Add New Credit Rejection Reason']")
		private WebElement addNewBtn;
			
		public void verifyaddNewBtn() {
			
			isDisplayed("addNewBtn",addNewBtn);
			verifyError(addNewBtn);
		}
}
