package lavante.recovery.pageobjects.Configuration.Jobs;

import org.openqa.selenium.By;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import lavante.recovery.utilities.seleniumBaseClass;

public class BackGroundJobsPage extends seleniumBaseClass{
	
		//Background Jobs link
		@FindBy(css="a[href='backgroundJobs.lvp']")
		private WebElement backgroundJobsLink;
			
		public void verifyBackgroundJobsLink() {
			fluentwait(backgroundJobsLink);
			click("backgroundJobsLink",backgroundJobsLink);
			getHttpResponse();
		}

		//Configuration--Jobs --Background Jobs table
		@FindBy(css="#background_jobs table tr")
		private WebElement backgroundJobsTable;
			
		public void verifyBackgroundJobsTable() {
			fluentwait(backgroundJobsTable);
			isDisplayed("backgroundJobsTable",backgroundJobsTable);
			verifyError(backgroundJobsTable);
		}		

}
