package lavante.recovery.pageobjects.Assignments;


import org.openqa.selenium.By;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import lavante.recovery.utilities.LavanteUtils;
import lavante.recovery.utilities.seleniumBaseClass;

public class CreditsPage {
	
	LavanteUtils lavanteUtils=new LavanteUtils();
	
	public WebDriver driver=null;
	public CreditsPage(WebDriver driver){
		lavanteUtils.driver=driver;
	}
	
	//Credits Link
	@FindBy(linkText="Credits")
	private WebElement creditsLink;
	public WebElement creditsLink(){ 		//added by Ramya
		return creditsLink;
	}
		
	public void verifycreditsLink() {
		lavanteUtils.fluentwait(creditsLink);	
		lavanteUtils.click("creditsLink",creditsLink);
	//	getHttpResponse();
	}
	
	//Credits search Data table
	@FindBy(css=".table_ab .table_ab_b")
	private WebElement creditsTable;
	public WebElement creditsTable(){		//added by Ramya
		return creditsTable;
	}
		
	public void verifycreditsTable() {
		lavanteUtils.fluentwait(creditsTable);
		lavanteUtils.isDisplayed("creditsTable",creditsTable);
		lavanteUtils.verifyError(creditsTable);
	}
	
	//Credits search filter
	@FindBy(css="button[title='Search']")
	private WebElement searchBtn;			//added  by Ramya
	public WebElement searchBtn(){
		return searchBtn;
	}
		
	public void verifysearchBtn() {
		
		lavanteUtils.isDisplayed("searchBtn",searchBtn);
		lavanteUtils.verifyError(searchBtn);
	}
}
