/**
 * 
 */
package com.lavante.sim.customer.pageobjects.Dashboard;

import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import org.testng.Reporter;

import com.lavante.sim.Common.Util.LavanteUtils;
/**
 * @author Piramanayagam.S
 *
 */
public class Dashboard {
	
	public WebDriver driver;
	public LavanteUtils lavanteUtils=new LavanteUtils();
	
	public Dashboard(WebDriver driver){
		lavanteUtils.driver=driver;
		this.driver=driver;
	}
	
	@FindBy(css="a[class*='user-info']")
	private WebElement UserName;
	
	@FindBy(css="[class*='table_ab_b'] span[title]")
	private List<WebElement> claimchats;
	
	@FindBy(css="a[href='customerDashboard.lvp']")
	private WebElement OnBoarding;
	
	@FindBy(css="a[href*='customerValidation']")
	private WebElement RegulatoryCompliance;
	
	@FindBy(css="a[href*='Diversity']")
	private WebElement expiringCertification;
	
	@FindBy(css="a[href*='USPSValidation']")
	private WebElement Validations;
	
	@FindBy(css="a[href*='customerDashboard']")
	private WebElement customerDashboardlnk;
	public WebElement customerDashboardlnk(){
		return customerDashboardlnk;
	}
	
	@FindBy(css="#content dd a")
	public WebElement FrequentlyAskedQuestionsSection;
	
	//Headlines
	@FindBy(xpath="//div[@class='panel-body']//tr/td/div[@class='count']")
	private List<WebElement> headLinesCountList;
	
	public List<WebElement> headLinesCountList() {
		return headLinesCountList;
	}
	
	@FindBy(xpath="//div[contains(text(),'Suppliers loaded')]/../div[@class='count']")
	private WebElement supplierLoaded;
	public WebElement supplierLoaded() {
		return supplierLoaded;
	}
	
	@FindBy(xpath="//div[contains(text(),'Suppliers invited')]/../div[@class='count']")
	private WebElement supplierInvited;
	public WebElement supplierInvited() {
		return supplierInvited;
	}
	
	@FindBy(xpath="//div[contains(text(),'complete invitations')]/../div[@class='count']")
	private WebElement supplierCompleteInv;
	public WebElement supplierCompleteInv() {
		return supplierCompleteInv;
	}
	
	@FindBy(xpath="//div[contains(text(),'completed all invitations')]/../div[@class='count']")
	private WebElement supplierCompleteAllInv;
	public WebElement supplierCompleteAllInv() {
		return supplierCompleteAllInv;
	}
	
	@FindBy(xpath="//div[contains(text(),'Suppliers approved')]/../div[@class='count']")
	private WebElement supplierApprovedByAll;
	public WebElement supplierApprovedByAll() {
		return supplierApprovedByAll;
	}
	
	
	
	@FindBy(css="div[class*='help'] h4")
	private List<WebElement> KrogerHelp;
	
	@FindBy(css="div[class*='chart'] div[class*='header'] span")
	private List<WebElement> KrogerChart;
	
	@FindBy(css="[class*='quick_links']")
	public WebElement QuickLinksSection;
	
	@FindBy(xpath="//div[@id='content']//td[contains(text(),'To Do List')]")
	private WebElement ToDoListSection;
	
	@FindBy(xpath="//div[@id='content']//td[contains(text(),'Alerts')]")
	private WebElement AlertsSection;
	
	@FindBy(xpath="//span[contains(text(),'Supplier invitations vs. registration')]")
	private WebElement SupplierInvitationsvsRegistration;
	
	@FindBy(xpath="//span[contains(text(),'Supplier invitation status')]")
	private WebElement SupplierInvitationStatus;
	
	@FindBy(xpath="//span[contains(text(),'New supplier on-boarding')]")
	private WebElement NewSupplierOnboarding;
	

	
	@FindBy(xpath="//span[contains(text(),'OFAC SDN screening')]")
	private WebElement OFACSDNScreening;
	
	@FindBy(xpath="//span[contains(text(),'FATCA compliance')]")
	private WebElement FATCACompliance;
	
	@FindBy(xpath="//span[contains(text(),'Compliance by foreign country')]")
	private WebElement CompliancebyForeignCountry;	
	
	@FindBy(xpath="//span[contains(text(),'Spend by diversity')]")
	private WebElement SpendbyDiversity;
	
	@FindBy(xpath="//span[contains(text(),'Small business expiry')]")
	private WebElement SmallBusinessExpiry;
	
	@FindBy(xpath="//span[contains(text(),'Insurance certificate expiry')]")
	private WebElement InsuranceCertificateExpiry;
	
	//MinorityExpiry renamed to Diverse & Disadvantaged Certificate Expiry
	@FindBy(xpath="//span[contains(text(),'Diverse & disadvantaged certificate expiry')]")
	private WebElement MinorityBusinessExpiry;
	
	@FindBy(xpath="//span[contains(text(),'Legal ID authentication')]")
	private WebElement LegalIDAuthentication;
	
	@FindBy(xpath="//span[contains(text(),'USPS address validation')]")
	private WebElement USPSAddressValidation;
	
	@FindBy(xpath="//span[contains(text(),'Swift code validation')]")
	private WebElement SwiftCodeValidation;
	
	@FindBy(xpath="//span[contains(text(),'Account number validation')]")
	private WebElement AccountNumberValidation;
	
	@FindBy(css="button[class*='dashboard']")
	private WebElement btnDashboard;
	public WebElement btnDashboard(){
		return btnDashboard;
	}
	
	@FindBy(linkText="Invite New Supplier")
	private WebElement InviteNewSupplier;
	
	@FindBy(id="supplierInviteJustification")
	private WebElement ReasonNewSuppmandatoryField;
		
	public List<WebElement> claimchats(){
		return claimchats;
	}
	
	
	
	public void selectTab(LinkedHashMap<String, String> dataMap) {
		
		if(dataMap.containsKey("maintab")){
			System.out.println(dataMap.get("maintab"));
			String main="//*[contains(@id,'main')]//*[contains(@href,'"+dataMap.get("maintab").toString()+"')]";
			lavanteUtils.fluentwait(driver.findElement(By.xpath(main)));
			driver.findElement(By.xpath(main)).click();
			System.out.println(main+driver);
		}
	
	}
	
	
	public boolean verifyOnBoardingDashboardItemsDisplayed() throws InterruptedException {
		
		boolean flag=false;
		lavanteUtils.fluentwait(SupplierInvitationsvsRegistration);
		//lavanteUtils.verifyElementDisplayed("ToDoListSection", ToDoListSection);
		//lavanteUtils.verifyElementDisplayed("AlertsSection", AlertsSection);
		boolean flag1=lavanteUtils.verifyElementDisplayed("SupplierInvitationsvsRegistration", SupplierInvitationsvsRegistration);
		boolean flag2=lavanteUtils.verifyElementDisplayed("NewSupplierOnboarding", NewSupplierOnboarding);		
		boolean flag3=lavanteUtils.verifyElementDisplayed("SupplierOutreachStatuses", SupplierInvitationStatus);

		if(flag1 && flag2 && flag3){
			flag=true;
		}
		return flag;
	}
	
	public boolean krogerDashboard() throws InterruptedException {
		boolean flag=false;
		String[] act=new String[3];
		lavanteUtils.fluentwait(UserName);
		for(int i=0;i<KrogerHelp.size();i++){
			String x=KrogerHelp.get(i).getText();
			act[i]=x;
		}
		
		String[] exp=new String[3];
		exp[0]="Kroger Policies and Information";
		exp[1]="Supplier Chain Vendor Compliance";
		exp[2]="How To";
		
		for(int i=0;i<exp.length;i++){
			Reporter.log(act[i]+",Actuals Help,"+exp[i],true);
			Assert.assertEquals(act[i], exp[i]);
		}
		
		
		act=new String[3];
		for(int i=0;i<KrogerChart.size();i++){
			String x=KrogerChart.get(i).getText();
			act[i]=x;
		}

		exp=new String[3];
		exp[0]="Outstanding tasks";
		exp[1]="Claims";
		exp[2]="Open tasks by assignment";
		
		for(int i=0;i<exp.length;i++){
			Reporter.log(act[i]+",Actuals Header,"+exp[i],true);
			Assert.assertTrue(act[i].contains(exp[i]));
		}
		
		LinkedHashMap<String, String> dataMap=new LinkedHashMap<>();
		 // Navigating sub menu items under Dashboard menu
		dataMap.put("Dashboard", "Claims");
		switchDashboard(dataMap);
		
		act=new String[10];
		int j=0;
		for(int i=0;i<KrogerChart.size();i++){
			String x=KrogerChart.get(i).getText();
			if(x.length()>0){
				act[j]=x;
				j=j+1;
			}
		}

		exp=new String[10];
		exp[0]=null;
		exp[1-1]="Claims metrics";
		exp[2-1]="Claims summary top 20 vendors";
		exp[3-1]="Claims summary top 10 divisions";
		exp[4-1]="Claims summary by type";
		exp[5-1]="Claims submitted vs closed";
		exp[6-1]="Supplier activity relating to transactions";
		
		
		for(int i=0;i<exp.length;i++){
			if(act[i]!=null){
				Reporter.log(act[i]+",Actuals Header,"+exp[i],true);
				Assert.assertEquals(act[i], exp[i]);
				flag=true;
			}
		}

		return flag;

	}
	
	
	
	public boolean verifyRegulatoryComplianceItemsDisplayed()	{
		
		boolean flag=false;
		lavanteUtils.switchtoFrame(null);
		lavanteUtils.fluentwait(OFACSDNScreening);
		boolean flag1=lavanteUtils.verifyElementDisplayed("OFACSDNScreening",OFACSDNScreening);
		boolean flag2=lavanteUtils.verifyElementDisplayed("FATCACompliance",FATCACompliance);
		boolean flag3=lavanteUtils.verifyElementDisplayed("CompliancebyForeignCountry", CompliancebyForeignCountry);
		
		if(flag1 && flag2 && flag3 ){
			flag=true;
		}
		return flag;
		
	}
	
	public boolean verifyExpiringCeritifcationDisplayed() {
		
		boolean flag=false;
		lavanteUtils.fluentwait(SpendbyDiversity);
		boolean flag1=lavanteUtils.verifyElementDisplayed("InsuranceCertificateExpiry",InsuranceCertificateExpiry);
		boolean flag2=lavanteUtils.verifyElementDisplayed("SpendbyDiversity",SpendbyDiversity);
		boolean flag3=lavanteUtils.verifyElementDisplayed("SmallBusinessExpiry",SmallBusinessExpiry);
		boolean flag4=lavanteUtils.verifyElementDisplayed("MinorityBusinessExpiry",MinorityBusinessExpiry);
		
		if(flag1 && flag2 && flag3 && flag4){
			flag=true;
		}
		return flag;
		
	}
	
	public boolean verifyValidationsItemsDisplayed()
	{
		boolean flag=false;
		lavanteUtils.fluentwait(LegalIDAuthentication);
		boolean flag1=lavanteUtils.verifyElementDisplayed("LegalIDAuthentication",LegalIDAuthentication);
		boolean flag2=lavanteUtils.verifyElementDisplayed("USPSAddressValidation",USPSAddressValidation);
		boolean flag3=lavanteUtils.verifyElementDisplayed("SwiftCodeValidation",SwiftCodeValidation);
		boolean flag4=lavanteUtils.verifyElementDisplayed("AccountNumberValidation",AccountNumberValidation);
		

		if(flag1 && flag2 && flag3 && flag4){
			flag=true;
		}
		return flag;
		
	}
	
	
	public void navigateToInviteSupplier()
	{
		lavanteUtils.click(InviteNewSupplier);
	}



	public void switchDashboard(LinkedHashMap<String, String> dataMap) {
		if(dataMap.containsKey("Dashboard")){
			String x=dataMap.get("Dashboard");
			lavanteUtils.click(btnDashboard);
			lavanteUtils.selectvalueFrmDpdn(x,"div[class*='open'] ul li a");
			
			lavanteUtils.waitForTime(4000);
		}
		
	}
	


}
