package lavante.recovery.pageobjects.Assignments;


import org.openqa.selenium.By;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import lavante.recovery.utilities.LavanteUtils;
import lavante.recovery.utilities.seleniumBaseClass;

public class StatementsPage {
	
	LavanteUtils lavanteUtils=new LavanteUtils();
	public WebDriver driver=null;
	public StatementsPage(WebDriver driver){
		lavanteUtils.driver=driver;
	}
	
	//Statements Link
	@FindBy(linkText="Statements")
	private WebElement statementsLink;
	public WebElement statementsLink(){			//added by Ramya
		return statementsLink;
	}
		
	public void verifyStatementsLink() {
		lavanteUtils.fluentwait(statementsLink);
		lavanteUtils.click("statementsLink",statementsLink);
	//	getHttpResponse();
	}
	
	//Statements search Data table
	@FindBy(css=".table_ab .table_ab_b")
	private WebElement statementsTable;
	public WebElement statementsTable(){		//added by Ramya
		return statementsTable;
	}
		
	public void verifyStatementsTable() {
		lavanteUtils.fluentwait(statementsTable);
		lavanteUtils.isDisplayed("statementsTable",statementsTable);
		lavanteUtils.verifyError(statementsTable);
	}
	
	//Credits search filter
	@FindBy(css="button[title='Search']")
	private WebElement searchBtn;
	public WebElement searchBtn(){				//added by Ramya
		return searchBtn;
	}
		
	public void verifysearchBtn() {
		
		lavanteUtils.isDisplayed("searchBtn",searchBtn);
		lavanteUtils.verifyError(searchBtn);
	}

}
