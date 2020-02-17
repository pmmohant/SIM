package lavante.recovery.pageobjects.Audit;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.By;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.Reporter;




import lavante.recovery.utilities.seleniumBaseClass;
import lavante.recovery.utilities.LavanteUtils;

public class AuditOutboundPage {
	
	LavanteUtils lavanteUtils=new LavanteUtils();
	public WebDriver driver=null;
	public AuditOutboundPage(WebDriver driver){
		lavanteUtils.driver=driver;
	}
	//Audit Link
	@FindBy(linkText="Audit")
	private WebElement auditLink;
	public WebElement auditLink(){
		return auditLink;
	}
	
	public void verifyauditLink() {
		
		lavanteUtils.click("auditLink",auditLink);
		lavanteUtils.isDisplayed("auditLink",auditLink);
		lavanteUtils.verifyError(auditLink);	
	}	
	
	//Outbound Link
	@FindBy(linkText="Outbound")
	private WebElement outboundLink;
	public WebElement outboundLink(){ //Added by Ramya
		return outboundLink;
	}
	
	public void verifyoutboundLink() {
	
		lavanteUtils.click("outboundLink",outboundLink);
		lavanteUtils.isDisplayed("outboundLink",outboundLink);
		lavanteUtils.verifyError(outboundLink);	
	}
	
	
	
	//Current Month Credits
	@FindBy(css="a[href*='CurrentMonthCredits']")
	private WebElement currentMonCredits;
	public WebElement currentMonCredits(){     //added by Ramya
		return currentMonCredits;
	}
	
	public void verifycurrentMonCredits() {
		//fluentwait(currentMonCredits);
		lavanteUtils.isDisplayed("currentMonCredits",currentMonCredits);
		lavanteUtils.verifyError(currentMonCredits);	
	}
	
	//Audit Contact Details
	@FindBy(css="#calling-reference tr")
	private WebElement auditContactDetails;
	public WebElement auditContactDetails(){      //added by Ramya
		return auditContactDetails;
	}
	
	public void verifyauditContactDetails() {
	
		lavanteUtils.isDisplayed("auditContactDetails",auditContactDetails);
		lavanteUtils.verifyError(auditContactDetails);	
	}
	
	//Future Credits Graph
	@FindBy(css="#recKHf77UU")
	private WebElement furureCreditsGrph;
	public WebElement futureCreditsGrph(){       //added by Ramya
		return futureCreditsGrph();
	}
	
	public void verifyfurureCreditsGrph() {
	
		lavanteUtils.isDisplayed("furureCreditsGrph",furureCreditsGrph);
		lavanteUtils.verifyError(furureCreditsGrph);	
	}
	
	//Claim History graph
	@FindBy(css="#recKHf77TT")
	private WebElement claimHistoryGrph;
	public WebElement claimHistoryGrph(){        //added by Ramya
		return claimHistoryGrph;
	}
	
	public void verifyclaimHistoryGrph() {
	
		lavanteUtils.click("claimHistoryGrph",claimHistoryGrph);
		lavanteUtils.isDisplayed("claimHistoryGrph",claimHistoryGrph);
		lavanteUtils.verifyError(claimHistoryGrph);	
	}
	
	//Supplier Status by Spend Rank
	@FindBy(css="a[href*='SupplierStatus']")
	private WebElement supplierStatus;
	public WebElement supplierStatus(){          //added by Ramya
		return supplierStatus;
	}
	
	public void verifysupplierStatus() {
	
		lavanteUtils.isDisplayed("supplierStatus",supplierStatus);
		lavanteUtils.verifyError(supplierStatus);	
	}
	
	//Supplier Status by Spend Rank--Credits Link for specific spend rank
	@FindBy(css=".data_table tr:nth-child(1) td:nth-child(2) a[href*='SupplierStatus']")
	private WebElement supplierStatusCreditsLink;
	
	//Supplier Status by Spend Rank--All Links
	@FindBy(css="#col_b div:nth-child(1) div a")
	private List <WebElement> supplierStatusTableAllLinks;
	
	//Outbound supplier details--Supplier Name link
	@FindBy(css="#tabResults tr:nth-child(1) .sub_table tr:nth-child(1) a")
	private WebElement obsuppDetailsSuppName;
	
	//Pending Correspondence
	@FindBy(css="a[href*='Correspondence']")
	private WebElement pendingCorrespondence;
	public WebElement pendingCorrespondence(){    //added by Ramya
		return pendingCorrespondence;
	}
	
	public void verifypendingCorrespondence() {
	
		lavanteUtils.isDisplayed("pendingCorrespondence",pendingCorrespondence);
		lavanteUtils.verifyError(pendingCorrespondence);	
	}
	
	//Pending Correspondence--All links
	@FindBy(css="#pendingCorrespondence tr td a")
	private List <WebElement> pendingCorrespondencedrillableLinks;
	
	//Doc action--Doc Type
	@FindBy(css="#documentType")
	private WebElement docActiondocType;
	
	//Doc action--Selected supplier Drop down
	@FindBy(css="#supplierStatus")
	private WebElement suppStatusDrpDown;
	
	
	//Save button
	@FindBy(css="#save-button")
	private WebElement saveBtn;
	
	//Save button After change - pop up -OK Button
	@FindBy(css="[class*='dialog'] [class*='green']")
	private WebElement popupOKBtn;
	
	//Doc action--Selected supplier status
	@FindBy(css="#supplierStatus option[ng-selected='true']")
	private WebElement selectedSuppStatus;
	
	//Outbound supplier details--Count
	@FindBy(css="table[style*='table-layout'] tr td:nth-child(1)")
	private WebElement outboundSuppDetailsResultSet;
	
	//Future Credits--Details by Month
	@FindBy(css="#recKHf77UU table tr td:nth-child(1) a:nth-child(2)")
	private WebElement futreCreditsDetailsByMonth;
	
	//Future Credits--Details by Month
	@FindBy(css="#groupBySupplier tr td:nth-child(1) a:nth-child(2)")
	private List<WebElement> futreCreditsDetailsByMonthAllSppliers;
	
	//Outbound data page--Outbound action
	@FindBy(css="#outbound-action")
	private WebElement outboundAction;
	
	//Outbound data page--Outbound action PDF IFrame
	@FindBy(css="iframe[src*='docActionOutboundAction']")
	private WebElement iFrameoutboundAction;
	
	//Outbound data page--Outbound action PDF IFrame close button
	@FindBy(css="button[title='close']")
	private WebElement iFramepopupClose;
	
	//Supplier Details Section---Contact Name
	@FindBy(css="tbody:nth-child(3) tr:nth-child(1) td:nth-child(2) input")
	private WebElement contactName;
	
	//LogOut
	@FindBy(linkText="Logout")
	private WebElement logout;
	
	//LogOut
	@FindBy(css="a[href*='logout']")
	private WebElement LogOutBtn;
	
	//Contact name--Verification Letter
	@FindBy(css=".data_table tr:nth-child(1) td:nth-child(4)")
	private WebElement contactNameinReqLetter;
	
	//Outbound fax--Send button for enabled 
	@FindBy(css="button[type='submit']")
	private WebElement outboundFaxSendBtn;
	
	//Outbound fax--Send button message
	@FindBy(css=".ui-dialog-buttons div:nth-child(2)")
	private WebElement confrmationPopUpMsg;
	
	//Related supplier tab
	@FindBy(css="#rel-supp-tab")
	private WebElement relSuppTab;
	
	//Related supplier table
	@FindBy(css="#related_supplier_table tr td")
	private List <WebElement> relSuppTable;
	
	//Related supplier search by Filters
	@FindBy(css="#selClnt")
	private WebElement searchDrpDownRelSuppliers;
	
	//Related supplier ICON
	@FindBy(css="#related_supplier_table td img")
	private List <WebElement> imgRelSupp;
	
	//Related supplier name
	@FindBy(css="#related_supplier_table td:nth-child(3) a")
	private List <WebElement> relSuppList;
	
	//Related supplier pop up--IFRAME
	@FindBy(css="iframe[src*='relatedSupplierPopup']")
	private WebElement iframeRelSupp;
	
	//Related supplier pop up--IFRAME--DLink Button
	@FindBy(css="button[title*='D-link']")
	private WebElement DLinkBtn;
	
	//Related supplier DLink Button
	@FindBy(css="#d-link")
	private WebElement DLinkMainBtn;
	
	//Related supplier pop up--IFRAME--Link as Parent Button
	@FindBy(css="input[title*='Link as Parent']")
	private WebElement linkAsParentBtn;
	
	//Supplier Status by Spend Rank --DNA 
	@FindBy(css=".scrollable_orig tr:nth-child(4) a[ng-bind*='nintyPlus']")
	private WebElement dnaSuppliers;
	
	//Supplier Status by Spend Rank --DNA all columns
	@FindBy(css=".scrollable_orig tr:nth-child(4)")
	private WebElement dnaSuppliersAllRanks;
	
	//Supplier Status by Spend Rank --Not Contacted 
	@FindBy(css=".scrollable_orig tr:nth-child(7) a[ng-bind*='nintyPlus']")
	private WebElement notContactedSuppliers;
	
	@SuppressWarnings("unused")
	public void verifyRelatedSuppler(){
		lavanteUtils.waitForTime(5000);
		relSuppTab.click();
		
			 if(relSuppTable.size() > 1){  //Check if related supplier table has data 
				 System.out.println("In Current customer" + relSuppTable.size());
			
				 	if(imgRelSupp.size() > 0){    //This is for checking if any of the supplier is linked to any supplier
				 		System.out.println("Already linked suppliers are present" + imgRelSupp.size() + "rel supp list" + relSuppList.size());
				 		
				 		
				 		for(int i = 0 ; i<relSuppList.size(); i++){
				 			for(int j = i ; j<imgRelSupp.size(); j++){
				 				System.out.println(imgRelSupp.get(j).getText().toLowerCase().toString());
				 				relSuppList.get(j).click();
				 				DLinkMainBtn.click();
				 				lavanteUtils.switchtoFrame(iframeRelSupp);
						 		DLinkBtn.click();
						 		lavanteUtils.switchtoFrame(null);
						 		lavanteUtils.waitForTime(3000);  
				 				break;
				 			}	
				 			break;
				 		}

				 				String confirmMsg = confrmationPopUpMsg.getText().toString();
				 			
				 				if(confirmMsg.equalsIgnoreCase("Related Supplier Delinked successfully")){
				 					System.out.println("Related supplier Delinked successfully");
				 					Reporter.log("Related supplier Delinked successfully");
				 					popupOKBtn.click();
				 					lavanteUtils.waitForTime(5000);
				 				}
				 		 
				 				else{
				 					System.out.println("Error in DeLinking supplier");
				 					Reporter.log("Error in DeLinking supplier");
				 					popupOKBtn.click();
				 					Assert.assertTrue(false, "Error in DeLinking supplier" + confirmMsg);
				 				}
				 	}
				 	
				 	else{
				 		//Write logic for linking supplier as parent/ child
				 		relSuppList.get(0).click();
				 		lavanteUtils.switchtoFrame(iframeRelSupp);
				 		linkAsParentBtn.click();
				 		lavanteUtils.switchtoFrame(null);
				 		lavanteUtils.waitForTime(3000);  
				 		
				 				String confirmMsg = confrmationPopUpMsg.getText().toString();
			 			
				 				if(confirmMsg.equalsIgnoreCase("Related Supplier linked successfully")){
				 						System.out.println("Related supplier linked successfully");
				 						Reporter.log("Related supplier linked successfully");
				 						popupOKBtn.click();
				 				}
		 		 
				 				else{
				 					System.out.println("Error in Linking supplier");
				 					Reporter.log("Error in Linking supplier");
				 					popupOKBtn.click();
				 					Assert.assertTrue(false, "Error in Linking supplier" + confirmMsg);
				 				}	
				 				
				 				lavanteUtils.waitForTime(3000);  
				 		System.out.println("supplier delinking started");
				 		for(int i = 0 ; i<relSuppList.size(); i++){
				 			for(int j = i ; j<imgRelSupp.size(); j++){
				 				System.out.println(imgRelSupp.get(j).getText().toLowerCase().toString());
				 				relSuppList.get(j).click();
				 				DLinkMainBtn.click();
				 				lavanteUtils.switchtoFrame(iframeRelSupp);
						 		DLinkBtn.click();
						 		lavanteUtils.switchtoFrame(null);
						 		
				 				break;
				 			}	
				 			break;
				 		}
				 		lavanteUtils.fluentwait(confrmationPopUpMsg); 

		 					confirmMsg = confrmationPopUpMsg.getText().toString();
		 			
		 					if(confirmMsg.equalsIgnoreCase("Related Supplier Delinked successfully")){
		 						System.out.println("Related supplier Delinked successfully");
		 						Reporter.log("Related supplier Delinked successfully");
		 						popupOKBtn.click();
		 						lavanteUtils.waitForTime(5000);
		 					}
		 					
		 					else{
		 						System.out.println("Error in DeLinking supplier");
		 						Reporter.log("Error in DeLinking supplier");
		 						popupOKBtn.click();
		 						Assert.assertTrue(false, "Error in DeLinking supplier" + confirmMsg);
		 					}
				 		
				 	}
			 }
			 String confirmMsg = "";
			 lavanteUtils.waitForTime(2000);
			// selectByVisibiletxt("All Customers", searchDrpDownRelSuppliers);
			 lavanteUtils. waitForTime(10000);
			 if(relSuppTable.size() > 1){   //Check if related supplier table has no data for Current Customer, select All Customers 
								 
	
				 	if(relSuppTable.size() > 1){
				 		System.out.println("In All Customers");
				 		
				 		if(imgRelSupp.size() == 0){    //This is for checking if supplier is linked to any supplier
					 		System.out.println("Already linked suppliers are present");
					 		relSuppList.get(0).click();
					 		lavanteUtils.switchtoFrame(iframeRelSupp);
					 		
					 		linkAsParentBtn.click();
					 		lavanteUtils.switchtoFrame(null);
					 		
					 		 confirmMsg = confrmationPopUpMsg.getText().toString();
					 		
					 		 if(confirmMsg.equalsIgnoreCase("Related Supplier linked successfully")){
					 			 	System.out.println("Related supplier linked successfully");
					 			 	Reporter.log("Related supplier linked successfully");
					 			 	popupOKBtn.click();
					 		 }
					 		 
					 		 else{
					 			 	System.out.println("Error in Linking supplier");
					 			 	Reporter.log("Error in Linking supplier");
					 			 	popupOKBtn.click();
					 			 	Assert.assertTrue(false, "Error in DeLinking supplier" + confirmMsg);
					 		 }
				 		}
				 		
				 		/*waitForTime(5000);
				 		for(int j = 0 ; j<imgRelSupp.size(); j++){
				 			
				 			System.out.println(imgRelSupp.size());
				 			
				 			for(int i = j ; i<relSuppList.size(); i++){	
				 				System.out.println(imgRelSupp.get(i).getText().toLowerCase().toString());
				 				relSuppList.get(i).click();
				 				DLinkMainBtn.click();
				 				switchtoFrame(iframeRelSupp);
						 		DLinkBtn.click();
						 		switchtoFrame(null);
						 		
				 				break;
				 			}	
				 			break;
				 		}
				 			fluentwait(confrmationPopUpMsg); 

		 					 confirmMsg = confrmationPopUpMsg.getText().toString();
		 			
		 					if(confirmMsg.equalsIgnoreCase("Related Supplier Delinked successfully")){
		 						System.out.println("Related supplier Delinked successfully");
		 						Reporter.log("Related supplier Delinked successfully");
		 						popupOKBtn.click();
		 						waitForTime(5000);
		 					}
		 					
		 					else{
		 						System.out.println("Error in DeLinking supplier");
		 						Reporter.log("Error in DeLinking supplier");
		 						popupOKBtn.click();
		 						Assert.assertTrue(false, "Error in DeLinking supplier" + confirmMsg);
		 					}*/
				 	}
			 }	 	
			 lavanteUtils.waitForTime(3000);
			// 	selectByVisibiletxt("Delinked Supplier", searchDrpDownRelSuppliers);
			 	System.out.println("Delinked Supplier");
			 	lavanteUtils.waitForTime(10000);
			 
					 	if(relSuppTable.size() > 1){
					 		System.out.println("In Delinkied suppliers");
					 		
					 		if(imgRelSupp.size() == 0){    //This is for checking if supplier is linked to any supplier
						 		System.out.println("Already linked suppliers are present");
						 		relSuppList.get(0).click();
						 		lavanteUtils.switchtoFrame(iframeRelSupp);
						 		
						 		linkAsParentBtn.click();
						 		lavanteUtils.switchtoFrame(null);
						 		
						 		 confirmMsg = confrmationPopUpMsg.getText().toString();
						 		
						 		 	if(confirmMsg.equalsIgnoreCase("Related Supplier linked successfully")){
						 			 	System.out.println("Related supplier linked successfully");
						 			 	Reporter.log("Related supplier linked successfully");
						 			 	popupOKBtn.click();
						 		 	}
						 		 
						 		 	else{
						 			 	System.out.println("Error in Linking supplier");
						 			 	Reporter.log("Error in Linking supplier");
						 			 	popupOKBtn.click();
						 			 	Assert.assertTrue(false, "Error in DeLinking supplier" + confirmMsg);
						 		 	}
					 		}
					 	}	
					 	
					 	else{
					 		Reporter.log("No data available for related supplier, pleaser try with test data");
					 		Assert.assertTrue(false, "No data available for related supplier, pleaser try with test data");
					 	}
			
			 
	}

	public void verifyCreditsinOutboundAction() throws FileNotFoundException, IOException, SQLException{
		futreCreditsDetailsByMonth.click();
		
		if(futreCreditsDetailsByMonthAllSppliers.size()>0){
			for(int count = 0 ; count<futreCreditsDetailsByMonthAllSppliers.size();count++){
				futreCreditsDetailsByMonthAllSppliers.get(0).click();
				lavanteUtils.waitForTime(5000);
				lavanteUtils.enterText("contactName", contactName, "testing lavante");
			//	waitforPageLoad(contactName);
				String contactNameinSuppSection = contactName.getAttribute("value").toString();
				System.out.println(contactNameinSuppSection);
				
			//	scrollToBottom(driver); 
				saveBtn.click();
				//ActionsforSingleClick(popupOKBtn);
			//	waitforPageLoad(outboundAction);
				
			//	selectByVisibiletxt("Verification, Today-EN",outboundAction);
				lavanteUtils.switchtoFrame(iFrameoutboundAction);
				
				String contactNameinVerificationLetter = contactNameinReqLetter.getText().toString();
				System.out.println(contactNameinVerificationLetter);
				
				outboundFaxSendBtn.click();
				lavanteUtils.waitForTime(5000);
				lavanteUtils.switchtoFrame(null);
				lavanteUtils.fluentwait(confrmationPopUpMsg);

				String sendfaxMsg = confrmationPopUpMsg.getText().toString();
				
				if(sendfaxMsg.equalsIgnoreCase("Fax is queued for sending")){
					System.out.println("Fax is queued for sending");
					Reporter.log("Fax is queued for sending");
					popupOKBtn.click();
				}
				
				else{
					System.out.println("Error in sending fax");
					Reporter.log("Error in sending fax");
					popupOKBtn.click();
					Assert.assertTrue(false, "Error in sending fax");
				}
				
				if(contactNameinSuppSection.equalsIgnoreCase(contactNameinVerificationLetter)){
					System.out.println("Contact Name Updated successfully in request letter");
					Reporter.log("Contact Name Updated successfully in request letter");
				}
				
				else{
					System.out.println("Contact Name NOT Updated in request letter");
					Reporter.log("Contact Name NOT Updated in request letter");
					Assert.assertTrue(false, "Contact Name NOT Updated in request letter");
				}
			}
		}
		
		else
			Assert.assertTrue(false, "No Suppliers in Details by Month");
		
	}
	
	public void LogOut(){
	//	scrollingToElementofAPage(logout);
		logout.click();
	}
	
	public void verifyPendingCorrespondanceTableLinks(){																																																																																																																																																																																																																																																																																																																																																																																																											
		try{
	
	//	scrollToBottom(driver);
		
		if(pendingCorrespondencedrillableLinks.size() > 0){
				for(int count=0; count<=pendingCorrespondencedrillableLinks.size(); count++){
					String pendingCorrespondanceTableLink = pendingCorrespondencedrillableLinks.get(0).getText();
					
					System.out.println("Before clicking pending corres : " + pendingCorrespondanceTableLink);
					
					pendingCorrespondencedrillableLinks.get(0).click();
					
					lavanteUtils.fluentwait(outboundSuppDetailsResultSet);
		
				String text = outboundSuppDetailsResultSet.getText().toString();
				System.out.println("After clicking pending corres :" + text);
				
				if(text.contains(pendingCorrespondanceTableLink)){
					Reporter.log("Count before and after drill matched from Pending Correspondence table");
					System.out.println("Count before and after drill matched from Pending Correspondence table");
					break;
				}
				else{
					Assert.assertTrue(false, "Count before and after drill NOT matched from Pending Correspondence table");
				}
			}
		}
		
		else{
			Reporter.log("No links are present in pending correspondance table, please check data for different audit");
		}
		}
		catch(Exception e){
			System.out.println("Exception in Pending Correspondence");
			Assert.assertTrue(false, "Exception in Pending Correspondence");
		}

	}
	
	
	public void verifySupplierStatisticsTableLinks(){
		try{

		if(supplierStatusTableAllLinks.size() > 0){
				for(int count=0; count<=supplierStatusTableAllLinks.size(); count++){
					String suppStatsTableLink = supplierStatusTableAllLinks.get(0).getText();
					
					System.out.println("Before clicking in Supplier Stats" + suppStatsTableLink);
					
					supplierStatusTableAllLinks.get(0).click();
					lavanteUtils.waitForTime(5000);
		
				String text = outboundSuppDetailsResultSet.getText().toString();
				System.out.println("After clicking in Supplier Stats" + text);
				
				if(text.contains(suppStatsTableLink)){
					Reporter.log("Count before and after drill matched in Supplier Stats table");
					System.out.println("Count before and after drill matched in Supplier Stats table");
					break;
				}
				else{
					Assert.assertTrue(false, "Count not matched before and after drill in Supplier Stats table");
				}
			}
		}
		
		else{
			Reporter.log("No links are present in pending correspondance table");
		}
		}
		catch(Exception e){
			System.out.println("Exception in Supplier Stats table");
			Assert.assertTrue(false, "Unable to drill from Supplier Stats table");
		}

	}
	
	public void navigateToOutBoundDataPage(WebElement obLandingPage){
		obLandingPage.click();
		
		lavanteUtils.waitForTime(5000);
		obsuppDetailsSuppName.click();
	}
	
	public void navigateDatapage(){
		navigateToOutBoundDataPage(dnaSuppliers);
	}
	
	public void DataPageCheckforSendFax(LinkedHashMap<String, String> dataMap){
		
		if(dataMap.containsKey("Do Not Audit")){
			navigateToOutBoundDataPage(dnaSuppliers);
		//	scrollToBottom(driver);
		//	selectByVisibiletxt("Verification, Today-EN",outboundAction);
			
			lavanteUtils.switchtoFrame(iFrameoutboundAction);
			
			try{
				String sendBtnStatus = outboundFaxSendBtn.getAttribute("disabled");
				
				if(sendBtnStatus.equalsIgnoreCase("true")){
					System.out.println("Send fax is disabled for DNA");
					Reporter.log("Send fax is disabled for DNA");
				}
			}catch(Exception e){
				System.out.println("Send fax is enabled for DNA, test failed");
				Reporter.log("Send fax is enabled for DNA, test failed" + e);
				Assert.assertTrue(false, "Send fax is enabled for DNA, test failed");
			}
			lavanteUtils.switchtoFrame(null);
			iFramepopupClose.click();
		//	scrollingToElementofAPage(auditLink);
		}
		
		/*if(dataMap.containsKey("Not Contacted")){
			dnaSuppliersAllRanks.click();
			scrollToBottom(driver);
			navigateToOutBoundDataPage(notContactedSuppliers);
			scrollToBottom(driver);
			selectByVisibiletxt("Verification, Today-EN",outboundAction);
			
			switchtoFrame(iFrameoutboundAction);
			
			try{
				String sendBtnStatus = outboundFaxSendBtn.getAttribute("disabled");
				
				if(sendBtnStatus.equalsIgnoreCase("true")){
					System.out.println("Send fax is disabled for DNA");
					Reporter.log("Send fax is disabled for DNA");
				}
			}catch(Exception e){
				System.out.println("Send fax is enabled for DNA, test failed");
				Reporter.log("Send fax is enabled for DNA, test failed" + e);
				Assert.assertTrue(false, "Send fax is enabled for DNA, test failed");
			}
			switchtoFrame(null);
			iFramepopupClose.click();
			scrollingToElementofAPage(auditLink);
		}*/
		
	}
	
	public void updateSuppStatus(LinkedHashMap<String, String> dataMap){

		System.out.println("sele status" + selectedSuppStatus.getAttribute("value"));
		System.out.println("status drp" + selectedSuppStatus.getText());
		
		//	scrollingToElementofAPage(suppStatusDrpDown);
			
			if(selectedSuppStatus.getText().equalsIgnoreCase(dataMap.get("Active"))){
			/*	selectByVisibiletxt("Credits",suppStatusDrpDown);
				selectByVisibiletxt("Verification",docActiondocType);
				selectByVisibiletxt("Verification, Today-EN",outboundAction);
			*/	
				lavanteUtils.switchtoFrame(iFrameoutboundAction);
				
				try{
					String sendBtnStatus = outboundFaxSendBtn.getAttribute("disabled");
					
					if(sendBtnStatus.equalsIgnoreCase("true")){
						System.out.println("Send fax is disabled for DNA");
						Reporter.log("Send fax is disabled for DNA");
					}
				}catch(Exception e){
					System.out.println("Send fax is enabled for DNA, test failed");
					Reporter.log("Send fax is enabled for DNA, test failed" + e);
					Assert.assertTrue(false, "Send fax is enabled for DNA, test failed");
				}
				lavanteUtils.switchtoFrame(null);
				iFramepopupClose.click();
				
				//saveBtn.click();
		       	//ActionsforSingleClick(popupOKBtn);
				lavanteUtils.waitForTime(5000);
			}
			
			else{
			/*	selectByVisibiletxt("Active",suppStatusDrpDown);
				selectByVisibiletxt("Verification",docActiondocType);
				selectByVisibiletxt("Verification, Today-EN",outboundAction);
				*/
				//saveBtn.click();
		        //ActionsforSingleClick(popupOKBtn);
				try{
					String sendBtnStatus = outboundFaxSendBtn.getAttribute("disabled");
					
					if(sendBtnStatus.equalsIgnoreCase("true")){
						System.out.println("Send fax is disabled for DNA");
						Reporter.log("Send fax is disabled for DNA");
					}
				}catch(Exception e){
					System.out.println("Send fax is enabled for DNA, test failed");
					Reporter.log("Send fax is enabled for DNA, test failed" + e);
					Assert.assertTrue(false, "Send fax is enabled for DNA, test failed");
				}
				lavanteUtils.switchtoFrame(null);
				iFramepopupClose.click();
				
				lavanteUtils.waitForTime(5000);
			}
	
		
		

	}

}
