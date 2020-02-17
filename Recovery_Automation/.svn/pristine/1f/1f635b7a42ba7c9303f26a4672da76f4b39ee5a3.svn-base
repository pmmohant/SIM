package lavante.recovery.pageobjects.Audit;

import java.awt.Robot;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import lavante.recovery.utilities.seleniumBaseClass;

public class AuditInboundPage extends seleniumBaseClass{
	
	//Inbound Link
	@FindBy(linkText="Inbound")
	private WebElement inboundLink;
	
	public void verifyinboundLink() {
	
		click("inboundLink",inboundLink);
		fluentwait(inboundLink);
		getHttpResponse();
		isDisplayed("inboundLink",inboundLink);
		verifyError(inboundLink);	
	}

	//Incoming Document Statistics table
	@FindBy(css="#inboundDocumentStatistics tr")
	private WebElement inboundDocumentStatistics;
	
	public void verifyinboundDocumentStatistics() {
	
		isDisplayed("inboundDocumentStatistics",inboundDocumentStatistics);
		verifyError(inboundDocumentStatistics);	
	}
	
	//Document Summary
	@FindBy(css="#inboundDocumentSummary tr")
	private WebElement inboundDocumentSummary;
	
	public void verifyinboundDocumentSummary() {
	
		isDisplayed("inboundDocumentSummary",inboundDocumentSummary);
		verifyError(inboundDocumentSummary);	
	}
	
	//Recognized Fax
	@FindBy(id="recognized")
	private WebElement recognizedfax;
	
	public void verifyRecognizedFax() {
		click("recognizedfax",recognizedfax);
		fluentwait(recognizedfax);
		getHttpResponse();
	}
	
	//UnRecognized Fax
	@FindBy(id="unrecognized")
	private WebElement unrecognizedfax;
	
	public void verifyUnrecognizedFax() {
		click("unrecognizedfax",unrecognizedfax);
		fluentwait(unrecognizedfax);
		getHttpResponse();
	}
	
	//Do not Audit (DNA) Fax
	@FindBy(id="dna")
	private WebElement dna;
	
	public void verifyDNAFax() {
		click("dna",dna);
		fluentwait(dna);
		getHttpResponse();
	}
	
	//Statements
	@FindBy(id="statements")
	private WebElement statements;
	
	public void verifyStatements() {
		click("statements",statements);
		fluentwait(statements);
		getHttpResponse();
	}
	
	//Statements table 
	@FindBy(css="#inbound-dashboard-table tr td")
	private WebElement statementsTable;
	
	public void verifyStatementsTable() {
		//verifyStatements();
		isDisplayed("statementsTable",statementsTable);
		verifyError(statementsTable);		
	}
	
	//Verifications
	@FindBy(id="verifications")
	private WebElement verifications;
		
	public void verifyVerifications() {
		click("verifications",verifications);
		fluentwait(verifications);
		getHttpResponse();
		isDisplayed("verifications",verifications);
		verifyError(verifications);
	}
	
	//Verifications table
	@FindBy(css="#inbound-dashboard-table tr td")
	private WebElement verificationsTable;
		
	public void verifyVerificationsTable() {
		//verifyVerifications();
		isDisplayed("verificationsTable",verificationsTable);
		verifyError(verificationsTable);
	}
	
	//Check request
	@FindBy(id="checks")
	private WebElement checks;
			
	public void verifyChecks() {
		click("checks",checks);
		fluentwait(checks);
		getHttpResponse();
	}
	
	//Check request table
	@FindBy(css="#inbound-dashboard-table tr td")
	private WebElement checksTable;
			
	public void verifyChecksTable() {
		isDisplayed("checksTable",checksTable);
		verifyError(checksTable);
	}
	
	//Correspondence
	@FindBy(id="correspondence")
	private WebElement correspondence;
	
	public void verifyCorrespondence(){
		click("correspondence", correspondence);
		fluentwait(correspondence);
	}
	
	//Correspondence table
	@FindBy(css="#inbound-dashboard-table tr td")
	private WebElement correspondenceTable;
	
	public void verifyCorrespondenceTable(){
		isDisplayed("correspondenceTable",correspondenceTable);
		verifyError(correspondenceTable);
	}
	
	//Duplicates
	@FindBy(id="duplicate")
	private WebElement duplicate;
	
	public void verifyDuplicate(){
		click("duplicate", duplicate);
		fluentwait(duplicate);
		getHttpResponse();
	}
	
	//Duplicates table
	@FindBy(css="#inbound-dashboard-table tr td")
	private WebElement duplicateTable;
	
	public void verifyDuplicateTable(){
		isDisplayed("duplicateTable",duplicateTable);
		verifyError(duplicateTable);
	}
	
	//Profiles
	@FindBy(id="profiles")
	private WebElement profiles;
	
	public void verifyProfiles(){
		click("profiles", profiles);
		fluentwait(profiles);
		getHttpResponse();
	}
	
	//Profiles table
	@FindBy(css="#inbound-dashboard-table tr td")
	private WebElement profilesTable;
	
	public void verifyprofilesTable(){
		click("profilesTable", profilesTable);
		fluentwait(profilesTable);
		getHttpResponse();
	}
	
	//Supplier main Table
	@FindBy(css="#inbound-dashboard-table tr td:nth-child(2) a")
	private List<WebElement> supplier;
	
	public void selectSupplierfromInboundPage(){
		if(supplier.size()>0){
			WebElement eachSupplier = supplier.get(0);
			eachSupplier.click();
			getWindowHandle(eachSupplier);
			
		}
		else{
			verifyStatements();
			
				if(supplier.size()>0){
					WebElement eachSupplier = supplier.get(0);
					eachSupplier.click();
					getWindowHandle(eachSupplier);
				}
				
				else{
					Reporter.log("No data available");
				}
		}
			
	}
	
	//Validate supplier popup Table
	@FindBy(css="#ui-id-3")
	private WebElement validateSupplier;
	
	public void validateSupplier(){
		if(validateSupplier.isDisplayed()){
				
		//validateSupplier.sendKeys(Keys.ESCAPE);
		}	
}	

}

		
	
	

