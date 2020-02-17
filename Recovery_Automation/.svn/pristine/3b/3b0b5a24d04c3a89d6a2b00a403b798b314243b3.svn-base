


	package lavante.recovery.pageobjects.Audit;
    import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import lavante.recovery.utilities.LavanteUtils;

	public class AuditCustomerKPIPage {
		
		LavanteUtils lavanteUtils=new LavanteUtils();
		public WebDriver driver=null;
		public AuditCustomerKPIPage(WebDriver driver){
			lavanteUtils.driver=driver;
		}
		//Customer KPI link
		@FindBy(linkText="Customer KPI")
		private WebElement customerKPILink;
		public WebElement customerKPILink(){
			return customerKPILink;
		}
		
		public WebElement verifycustomerKPILink() {
			lavanteUtils.isDisplayed("customer KPI",customerKPILink());
			return customerKPILink();
		}
		
		
		@FindBy(id ="resultSetLnk")
		private WebElement surveyResultsLink;
		public WebElement surveyResultsLink(){
			return surveyResultsLink;
		}
		
		
		@FindBy(id="usercombo")
		private WebElement userName;
		public WebElement userName(){
			return userName;
			
		}
		
		
}
	
	
