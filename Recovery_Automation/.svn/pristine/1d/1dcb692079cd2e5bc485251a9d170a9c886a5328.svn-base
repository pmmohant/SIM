package lavante.recovery.pageobjects.Assignments;


import org.openqa.selenium.By;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import lavante.recovery.utilities.LavanteUtils;
import lavante.recovery.utilities.seleniumBaseClass;

public class HoldsPage {
	

	LavanteUtils lavanteUtils=new LavanteUtils();
	public HoldsPage(WebDriver driver){
		lavanteUtils.driver=driver;
	}
	
	//Assignments Link
	@FindBy(linkText="Assignments")
	private WebElement assignmentsLink;
	public WebElement assignmentsLink(){		//added by Ramya
		return assignmentsLink;
	}
		
	public void verifyAssignmentsLink() {
		lavanteUtils.fluentwait(assignmentsLink);
		lavanteUtils.click("assignmentsLink",assignmentsLink);
	}
	
	//Holds Link
	@FindBy(css="a[href*='holdAssignments.lvp']")
	private WebElement holdsLink;
	public WebElement holdsLink(){				//added by Ramya
		return holdsLink;
	}
		
	public void verifyHoldsLink() {
		lavanteUtils.fluentwait(holdsLink);
		lavanteUtils.click("holdsLink",holdsLink);
	}
	
	@FindBy(css="#iframe_page")
	private WebElement holdsTableiFrame;
		
	public void verifyHoldsTableiFrame() {
		lavanteUtils.switchtoFrame(holdsTableiFrame);
		lavanteUtils.isDisplayed("holdsTableiFrame",holdsTableiFrame);
		lavanteUtils.verifyError(holdsTableiFrame);
	}	
	
	//Holds search Data table
	@FindBy(css=".table_ab .table_ab_b")
	private WebElement holdsTable;
	public WebElement holdsTable(){				//added by Ramya
		return holdsTable;
	}
	
		
	public void verifyHoldsTable() {
		lavanteUtils.fluentwait(holdsTable);
		lavanteUtils.isDisplayed("holdsTable",holdsTable);
		lavanteUtils.verifyError(holdsTable);
	}
	
	//Holds search filter
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
