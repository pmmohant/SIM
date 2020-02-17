package lavante.recovery.pageobjects.Configuration.Jobs;

import org.openqa.selenium.By;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import lavante.recovery.utilities.LavanteUtils;
import lavante.recovery.utilities.seleniumBaseClass;

public class FaxJobPage{
	
	LavanteUtils lavanteUtils=new LavanteUtils();
	public WebDriver driver=null;
	public FaxJobPage(WebDriver driver){
		lavanteUtils.driver=driver;
	}
	
	
	//Jobs link
	//@FindBy(css="a[title='Jobs']")
	@FindBy(css="a[title*='Jobs']")
	private WebElement configurationJobsLink;
	public WebElement configurationJobsLink(){		//added by Ramya
		return configurationJobsLink;
	}
		
	public void verifyConfigurationJobsLink() {
		lavanteUtils.fluentwait(configurationJobsLink);
		lavanteUtils.click("configurationJobsLink",configurationJobsLink);
	//	getHttpResponse();
	}
	
	//Configuration--Jobs --FaxJobs Link
	@FindBy(css="a[href*='jobConfiguration']")
	private WebElement faxJobsLink;
	public WebElement faxJobsLink(){				//added by Ramya
		return faxJobsLink;
	}
	
	
		
	public void verifyFaxJobsLink() {
		lavanteUtils.fluentwait(faxJobsLink);
		lavanteUtils.click("faxJobsLink",faxJobsLink);
//		getHttpResponse();
	}
	
	//Configuration--Jobs --FaxJobs table
	@FindBy(css="#background_jobs table tr td")
	private WebElement faxJobsTable;
	public WebElement faxJobsTable(){				//added by Ramya
		return faxJobsTable;
	}
	
		
	public void verifyFaxJobsTable() {
		lavanteUtils.fluentwait(faxJobsTable);
		lavanteUtils.isDisplayed("faxJobsTable",faxJobsTable);
		lavanteUtils.verifyError(faxJobsTable);
	}	

}
