package lavante.recovery.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import lavante.recovery.utilities.LavanteUtils;
import lavante.recovery.utilities.Report;
import lavante.recovery.utilities.seleniumBaseClass;

public class InboundLandingPage {
	
		
	LavanteUtils lavanteUtils=new LavanteUtils();
	public WebDriver driver=null;
	public InboundLandingPage(WebDriver driver){
		lavanteUtils.driver=driver;
	}
	
	//Recognized Fax
	@FindBy(id="recognized")
	private WebElement recognizedfax;
	
	public void verifyRecognizedFax() {
		lavanteUtils.click("recognized",recognizedfax);
	}
	
	//UnRecognized Fax
	@FindBy(id="unrecognized")
	private WebElement unrecognizedfax;
	
	public void verifyUnrecognizedFax() {
		lavanteUtils.click("unrecognized",unrecognizedfax);
	}
	
	//Do not Audit (DNA) Fax
	@FindBy(id="dna")
	private WebElement dna;
	
	public void verifyUnrsecognizedFax() {
		lavanteUtils.click("dna",dna);
	}
	
	//Statements
	@FindBy(id="statements")
	private WebElement statements;
	
	public void verifyStatements() {
		lavanteUtils.click("statements",statements);
	}
	
	//Verifications
	@FindBy(id="verifications")
	private WebElement verifications;
		
	public void verifyVerifications() {
		lavanteUtils.click("verifications",verifications);
	}
	
	//Check request
	@FindBy(id="checks")
	private WebElement checks;
			
	public void verifyChecks() {
		lavanteUtils.click("checks",checks);
	}
	
	//Correspondence
	@FindBy(id="correspondence")
	private WebElement correspondence;
	
	public void verifyCorrespondence(){
		lavanteUtils.click("correspondence", correspondence);
	}
	
	//Duplicates
	@FindBy(id="duplicate")
	private WebElement duplicate;
	
	public void verifyDuplicate(){
		lavanteUtils.click("duplicate", duplicate);
	}
	
	//Profiles
	@FindBy(id="profiles")
	private WebElement profiles;
	
	public void verifyduplicate(){
		lavanteUtils.click("profiles", profiles);
	}
	
	//Date-Range picker
	@FindBy(id="date-range")
	private WebElement daterange;
	
	public void verifyDateRange(){
		lavanteUtils.click("date-range", daterange);
	}

	//Document Status drop down
	@FindBy(id="document_status_chosen")
	private WebElement document_status_chosen;
	
	public void verifyDocumentStatus(){
		lavanteUtils.selectByVisibiletxt("document_status_chosen", document_status_chosen);
	}

	//Document Summary-->Supplier Status-->Active
	@FindBy(css="[ng-bind*='active']")
	private WebElement SupplierStatus_Active;
	
	//Document Summary-->Supplier Status-->inactive
	@FindBy(css="[ng-bind*='inactive']")
	private WebElement SupplierStatus_inactive;
	
	//Document Summary-->Supplier Status-->needAddress
	@FindBy(css="[ng-bind*='needAddress']")
	private WebElement SupplierStatus_needAddress;
	
	//Document Summary-->Supplier Status-->willNotProvide
	@FindBy(css="[ng-bind*='willNotProvide']")
	private WebElement SupplierStatus_willNotProvide;
	
	//Document Summary-->Supplier Status-->received
	@FindBy(css="[ng-bind*='received'][ng-bind*='supplier']")
	private WebElement SupplierStatus_received;
	
	//Document Summary-->Document Status-->received
	@FindBy(css="[ng-bind*='received'][ng-bind*='document']")
	private WebElement DocStatus_Received;
	
	//Document Summary-->Document Status-->contactEntered
	@FindBy(css="[ng-bind*='contactEntered'][ng-bind*='document']")
	private WebElement ContactsEntered;
	
	//Document Summary-->Document Status-->ceReview
	@FindBy(css="[ng-bind*='ceReview'][ng-bind*='document']")
	private WebElement CERevew;
	
	//Document Summary-->Document Status-->statementReview
	@FindBy(css="[ng-bind*='statementReview'][ng-bind*='document']")
	private WebElement statementReview;
	
	//Document Summary-->Document Status-->awaitingResponse
	@FindBy(css="[ng-bind*='awaitingResponse'][ng-bind*='document']")
	private WebElement awaitingResponse;
	

	
	public int getStatus(String value){
		
		 WebElement Status = driver.findElement(By.xpath("//table[@id='inbound_supplier_status']//tr[contains(.," + value + ")])//td[1]"));

	String actualvalue = Status.getText();
	
   int StatusCount  =	Integer.parseInt(actualvalue);
	
	return StatusCount;
	
	}

	
	
	
}
