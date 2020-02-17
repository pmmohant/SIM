package lavante.recovery.pageobjects.Assignments;

import org.openqa.selenium.By;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import lavante.recovery.utilities.LavanteUtils;
import lavante.recovery.utilities.seleniumBaseClass;

public class AuditStatisticsPage {
		
	
	LavanteUtils lavanteUtils=new LavanteUtils();
	
	public WebDriver driver=null;
	public AuditStatisticsPage(WebDriver driver){
		lavanteUtils.driver=driver;
	}

	
	//Audit Statistics Link
	@FindBy(linkText="Audit Statistics")
	private WebElement auditStatisticsLink;
	public WebElement auditsStatisticsLink(){		//added by Ramya
		return auditStatisticsLink;
	}
	
	public WebElement auditStElement(){
		return auditStatisticsLink;
	}
	
	public void verifyauditStatisticsLink() {
		lavanteUtils.fluentwait(auditStatisticsLink);
		lavanteUtils.click("auditStatisticsLink",auditStatisticsLink);
	//	getHttpResponse();
	}
	
	//Audit Statistics Data table
	@FindBy(css="#auditStatistics tr")
	private WebElement auditStatsTable;
	public WebElement auditStatsTable(){
		return auditStatsTable;
	}
		
	public void verifyauditStatsTable() {
		
		lavanteUtils.isDisplayed("auditStatsTable",auditStatsTable);
		lavanteUtils.verifyError(auditStatsTable);
	}

}
