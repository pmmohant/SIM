package lavante.recovery.pageobjects.Configuration.Others;

import org.openqa.selenium.By;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import lavante.recovery.utilities.LavanteUtils;
import lavante.recovery.utilities.seleniumBaseClass;

public class CreditRejectionPage{
			

	LavanteUtils lavanteUtils=new LavanteUtils();
	public WebDriver driver=null;
	public CreditRejectionPage(WebDriver driver){
		lavanteUtils.driver=driver;
	}
	
		//Configuration--Others--Credit Rejection Link
		@FindBy(css="a[href*='creditRejectionReason']")
		private WebElement othersCreditRejectionLink;
		public WebElement othersCreditRejectionLink(){		//added by Ramya
			return othersCreditRejectionLink;
		}
			
		public void verifyOthersCreditRejectionLink() {
			lavanteUtils.fluentwait(othersCreditRejectionLink);
			lavanteUtils.click("othersCreditRejectionLink",othersCreditRejectionLink);
		}
				
		//Others--Credit Rejection table
		@FindBy(css="#credit_rejection tr")
		private WebElement othersCreditRejectionTable;
		public WebElement othersCreditRejectionTable(){		//added by Ramya
			return othersCreditRejectionTable;
		}
			
		public void verifyOthersCreditRejectionTable() {
			lavanteUtils.fluentwait(othersCreditRejectionTable);
			lavanteUtils.isDisplayed("othersCreditRejectionTable",othersCreditRejectionTable);
			lavanteUtils.verifyError(othersCreditRejectionTable);
		}
		
		//Add New Button
		@FindBy(css="input[title='Add New Credit Rejection Reason']")
		private WebElement addNewBtn;
		public WebElement addNewBtn(){     			      // added by Ramya
			return addNewBtn;
		}
			
		public void verifyaddNewBtn() {
			
			lavanteUtils.isDisplayed("addNewBtn",addNewBtn);
			lavanteUtils.verifyError(addNewBtn);
		}
}
