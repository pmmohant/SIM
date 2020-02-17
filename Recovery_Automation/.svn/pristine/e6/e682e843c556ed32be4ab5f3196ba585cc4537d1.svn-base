package lavante.recovery.pageobjects.Assignments;

import org.openqa.selenium.By;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import lavante.recovery.utilities.seleniumBaseClass;

public class AuditStatisticsPage extends seleniumBaseClass{
		
	//Audit Statistics Link
	@FindBy(linkText="Audit Statistics")
	private WebElement auditStatisticsLink;
		
	public void verifyauditStatisticsLink() {
		fluentwait(auditStatisticsLink);
		click("auditStatisticsLink",auditStatisticsLink);
		getHttpResponse();
	}
	
	//Audit Statistics Data table
	@FindBy(css="#auditStatistics tr")
	private WebElement auditStatsTable;
		
	public void verifyauditStatsTable() {
		
		isDisplayed("auditStatsTable",auditStatsTable);
		verifyError(auditStatsTable);
	}

}
