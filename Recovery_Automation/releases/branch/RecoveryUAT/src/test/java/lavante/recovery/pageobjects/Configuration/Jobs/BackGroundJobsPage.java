package lavante.recovery.pageobjects.Configuration.Jobs;

import org.openqa.selenium.By;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import lavante.recovery.utilities.LavanteUtils;
import lavante.recovery.utilities.seleniumBaseClass;

public class BackGroundJobsPage {
	
	LavanteUtils lavanteUtils=new LavanteUtils();
	public WebDriver driver=null;
	public BackGroundJobsPage(WebDriver driver){
		lavanteUtils.driver=driver;
	}
	
		//Background Jobs link
		@FindBy(css="a[href='backgroundJobs.lvp']")
		private WebElement backgroundJobsLink;
		public WebElement backgroundJobsLink(){				//added by Ramya
			return backgroundJobsLink;
		}
			
		public void verifyBackgroundJobsLink() {
			lavanteUtils.fluentwait(backgroundJobsLink);
			lavanteUtils.click("backgroundJobsLink",backgroundJobsLink);
	//		getHttpResponse();
		}

		//Configuration--Jobs --Background Jobs table
		@FindBy(css="#background_jobs table tr")
		private WebElement backgroundJobsTable;				//added by Ramya
		public WebElement backgroundJobsTable(){
			return backgroundJobsTable;
		}
			
		public void verifyBackgroundJobsTable() {
			lavanteUtils.fluentwait(backgroundJobsTable);
			lavanteUtils.isDisplayed("backgroundJobsTable",backgroundJobsTable);
			lavanteUtils.verifyError(backgroundJobsTable);
		}		

}
