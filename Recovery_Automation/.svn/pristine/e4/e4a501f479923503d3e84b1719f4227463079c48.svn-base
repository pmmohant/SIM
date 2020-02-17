package lavante.recovery.pageobjects.Configuration.Finance;

import org.openqa.selenium.By;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import lavante.recovery.utilities.LavanteUtils;
import lavante.recovery.utilities.seleniumBaseClass;

public class FinanceInvoicesPage {
	
	LavanteUtils lavanteUtils=new LavanteUtils();
	public WebDriver driver=null;
	public FinanceInvoicesPage(WebDriver driver){
		lavanteUtils.driver=driver;
	}
	
	//Configuration--Finance--Link
	@FindBy(css="a[title='Finance']")
	private WebElement financeLink;
	public WebElement financeLink(){				//added by Ramya
		return financeLink;
	}
		
	public void verifyFinanceLink() {
		lavanteUtils.fluentwait(financeLink);
		lavanteUtils.click("financeLink",financeLink);
	//	getHttpResponse();
	}
	
	//Configuration--Finance--Invoices Link
	@FindBy(css="a[href='financeConfiguration.lvp']")
	private WebElement finInvoicesLink;
	public WebElement finInvoicesLink(){			//added by Ramya
		return finInvoicesLink;
	}
		
	public void verifyFinInvoicesLink() {
		lavanteUtils.fluentwait(finInvoicesLink);
		lavanteUtils.click("finInvoicesLink",finInvoicesLink);
	//	getHttpResponse();
	}
			
	//Finance--Invoices table
	@FindBy(css="#invoice-details tr")
	private WebElement finInvoicesTable;
	public WebElement finInvoicesTable(){			//added by Ramya
		return finInvoicesTable;
	}
		
	public void verifyFinInvoicesTable() {
		lavanteUtils.fluentwait(finInvoicesTable);
		lavanteUtils.isDisplayed("finInvoicesTable",finInvoicesTable);
		lavanteUtils.verifyError(finInvoicesTable);
	}

}
