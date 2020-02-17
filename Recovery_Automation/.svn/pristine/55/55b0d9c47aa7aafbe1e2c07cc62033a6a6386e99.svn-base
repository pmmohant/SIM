package lavante.recovery.pageobjects.Configuration.Finance;

import org.openqa.selenium.By;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import lavante.recovery.utilities.LavanteUtils;
import lavante.recovery.utilities.seleniumBaseClass;

public class ContractDetailsPage {
		
	LavanteUtils lavanteUtils=new LavanteUtils();
	public WebDriver driver=null;
	public ContractDetailsPage(WebDriver driver){
		lavanteUtils.driver=driver;
	}
	
	//Configuration--Finance--Contract Details Link
	@FindBy(css="a[href*='contractDetails']")
	private WebElement finContractDetailsLink;
	public WebElement finContractDetailsLink(){					//added by Ramya
		return finContractDetailsLink;
	}
		
	public void verifyFinanaceContractDetailsLink() {
		lavanteUtils.fluentwait(finContractDetailsLink);
		lavanteUtils.click("finContractDetailsLink",finContractDetailsLink);
	//	getHttpResponse();
	}
			
	//Finance--Contract Details table
	@FindBy(css="#contract-details tr")							//added by Ramya
	private WebElement finContractDetailsTable;
	public WebElement finContractDetailsTable(){
		return finContractDetailsTable;
	}
		
	public void verifyfinContractDetailsTable() {
		lavanteUtils.fluentwait(finContractDetailsTable);
		lavanteUtils.isDisplayed("finContractDetailsTable",finContractDetailsTable);
		lavanteUtils.verifyError(finContractDetailsTable);
	}
}
