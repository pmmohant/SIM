package lavante.recovery.pageobjects.Configuration.Jobs;

import org.openqa.selenium.By;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import lavante.recovery.utilities.seleniumBaseClass;

public class FaxJobPage extends seleniumBaseClass{
	
	//Jobs link
	@FindBy(css="a[title='Jobs']")
	private WebElement configurationJobsLink;
		
	public void verifyConfigurationJobsLink() {
		fluentwait(configurationJobsLink);
		click("configurationJobsLink",configurationJobsLink);
		getHttpResponse();
	}
	
	//Configuration--Jobs --FaxJobs Link
	@FindBy(css="a[href*='jobConfiguration']")
	private WebElement faxJobsLink;
		
	public void verifyFaxJobsLink() {
		fluentwait(faxJobsLink);
		click("faxJobsLink",faxJobsLink);
		getHttpResponse();
	}
	
	//Configuration--Jobs --FaxJobs table
	@FindBy(css="#background_jobs table tr td")
	private WebElement faxJobsTable;
		
	public void verifyFaxJobsTable() {
		fluentwait(faxJobsTable);
		isDisplayed("faxJobsTable",faxJobsTable);
		verifyError(faxJobsTable);
	}	

}
