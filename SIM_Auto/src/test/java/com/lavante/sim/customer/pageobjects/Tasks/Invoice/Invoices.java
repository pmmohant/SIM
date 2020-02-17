/**
 * 
 */
package com.lavante.sim.customer.pageobjects.Tasks.Invoice;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

import com.lavante.sim.Common.Util.LavanteUtils;

/**
 * Navigate to Task - Invoices page & Save & approve an Invoice
 * URL : XXXX/sim/getInvoiceTasks.lvp
 * Flow - >Task ->Supplier Invoice to Approve
 * 
 */
public class Invoices 
{
	
	LavanteUtils lavanteUtils=new LavanteUtils();
	
	public Invoices(WebDriver driver)
	{
		lavanteUtils.driver=driver;
	}
	
//Web Elements 
	
	@FindBy(css="button[type*='reset']")
	private WebElement clear;
	public WebElement clear()
	{
		return clear;
	}
	
	@FindBy(css="button[class*='primary']")
	private WebElement Search;
	public WebElement Search()
	{
		return Search;
	}
	
	@FindBy(css="[id*='filterWorkflow'] a")
	private WebElement Filterby;
	public WebElement Filterby()
	{
		return Filterby;
	}
	
	@FindBy(css="input[ng-click][value*='Edit']")
	private WebElement EditInvoice;
	public WebElement EditInvoice()
	{
		return EditInvoice;
	}
	
	@FindBy(css="iframe[src*='editSupplierInvoice']")
	private WebElement IFRAMEEditInvoice;
	public WebElement IFRAMEEditInvoice()
	{
		return IFRAMEEditInvoice;
	}
	
	@FindBy(css="#uploadSupplierInvoice[title='Save And Approve']")
	private WebElement Approvebtn;
	public WebElement Approvebtn()
	{
		return Approvebtn;
	}
	
	//Adding Web Elements for change in Invoice Type (drop down)
	
	@FindBy(css="[id*='invoiceType_KVID'] a")
	private WebElement Invoicetypedrpdown;
	public WebElement Invoicetypedrpdown()
	{
		return Invoicetypedrpdown;
	}
	
	@FindBy(css="tr:nth-child(7) td:nth-child(2)")
	private WebElement TotalInvAmount;
	public WebElement TotalInvAmount()
	{
		return TotalInvAmount;
	}
	
	@FindBy(css="[data-label*='Amount']")
	private WebElement invamount;
	public WebElement invamount()
	{
		return invamount;
	}
	
	@FindBy(css="[data-label*='PO Number']")
	private WebElement PONumber;
	public WebElement PONumber()
	{
		return PONumber;
	}
	
	@FindBy(css="[data-label*='Receiver Number']")
	private WebElement ReceiverNum;
	public WebElement ReceiverNum()
	{
		return ReceiverNum;
	}
	
	@FindBy(css="[data-label*='Labor Code']")
	private WebElement LaborCode;
	public WebElement LaborCode()
	{
		return LaborCode;
	}
	
	@FindBy(css="[data-label*='Vendor Employee']")
	private WebElement VendorEmployee;
	public WebElement VendorEmployee()
	{
		return VendorEmployee;
	}
	
	@FindBy(css="[data-label*='PLC']")
	private WebElement PLC;
	public WebElement PLC()
	{
		return PLC;
	}
	
	@FindBy(css="[data-label*='Hours']")
	private WebElement Hours;
	public WebElement Hours()
	{
		return Hours;
	}
	
	@FindBy(id="sowNumberId_1")
	private WebElement SOWNumber;
	public WebElement SOWNumber()
	{
		return SOWNumber;
	}
	
	@FindBy(css="#lineItemDeliverableId_1 option")
	private List<WebElement> Deliverable;
	public List<WebElement> Deliverable()
	{
		return Deliverable;
	}
	
	@FindBy(css="#lineItemDeliverableId_1")
	private WebElement Deliverables;
	public WebElement Deliverables()
	{
		return Deliverables;
	}
	
	//
	
	@FindBy(id="customerOrganizationId_1")
	private WebElement SelectOrg;
	public WebElement SelectOrg()
	{
		return SelectOrg;
	}
	
	@FindBy(css="[class*='ng-scope'] [name*='project']")
	private WebElement ProjectNumber;
	public WebElement ProjectNumber()
	{
		return ProjectNumber;
	}
	
	@FindBy(id="accountNumberId_1")
	private WebElement AccountNumber;
	public WebElement AccountNumber()
	{
		return AccountNumber;
	}
	
	@FindBy(id="comment")
	private WebElement Comment;
	public WebElement Comment()
	{
		return Comment;
	}
	
	@FindBy(css="iframe[src*='customerApprovals']")
	private WebElement IFRAMEComment;
	public WebElement IFRAMEComment()
	{
		return IFRAMEComment;
	}
	
	
	@FindBy(css="[data-name='invoiceSplitAmount']")
	private List<WebElement> VIEWinvamnt;
	public List<WebElement> VIEWinvamnt()
	{
		return VIEWinvamnt;
	}
	
	@FindBy(css="[data-name='customerOrganizationId']")
	private List<WebElement> VIEWinvorg;
	public List<WebElement> VIEWinvorg()
	{
		return VIEWinvorg;
	}
	@FindBy(css="[data-name='projectNumber']")
	private List<WebElement> VIEWinvpro;
	public List<WebElement> VIEWinvpro()
	{
		return VIEWinvpro;
	}
	@FindBy(css="[data-name='accountNumberId']")
	private List<WebElement> VIEWinvacc;
	public List<WebElement> VIEWinvacc()
	{
		return VIEWinvacc;
	}
	
	//Approval History table
	
	@FindBy(xpath =  "//*[contains(text(),'Approval')]/../../..//td[2]")
	private List<WebElement> VIEWinvStatusProfStatusListAction;

	public List<WebElement> VIEWinvStatusProfStatusListAction() {
		return VIEWinvStatusProfStatusListAction;
	}
	
	@FindBy(xpath =  "//*[contains(text(),'Approval')]/../../..//td[3]")
	private List<WebElement> VIEWinvStatusProfStatusListActor;

	public List<WebElement> VIEWinvStatusProfStatusListActor() {
		return VIEWinvStatusProfStatusListActor;
	}
	
	@FindBy(xpath = "//*[contains(text(),'Approval')]/../../..//td[4]")
	private List<WebElement> VIEWinvStatusProfStatusListType;

	public List<WebElement> VIEWinvStatusProfStatusListType() {
		return VIEWinvStatusProfStatusListType;
	}
	
	@FindBy(xpath =  "//*[contains(text(),'Approval')]/../../..//td[6]")
	private List<WebElement> VIEWinvStatusProfStatusListComment;

	public List<WebElement> VIEWinvStatusProfStatusListComment() {
		return VIEWinvStatusProfStatusListComment;
	}
	
	
	@FindBy(css="[id*='customerApproval'] [title*='Submit']")
	private WebElement Submitbtn;
	public WebElement Submitbtn()
	{
		return Submitbtn;
	}
	
	@FindBy(css="[id*='lineItem']")
	private List<WebElement> editDellitm;
	public List<WebElement> editDellitm()
	{
		return editDellitm;
	}
	
	@FindBy(css="[id*='itemType']")
	private List<WebElement> editDelitemType;
	public List<WebElement> editDelitemType()
	{
		return editDelitemType;
	}
	
	@FindBy(css="[id*='description']")
	private List<WebElement> editDeldescription;
	public List<WebElement> editDeldescription()
	{
		return editDeldescription;
	}
	
	//LABELS 
	@FindBy(css="div span[class*='title']")
	private WebElement editinvoiceheader;
	public  WebElement editinvoiceheader()
	{
		return editinvoiceheader;
		
	}
	@FindBy(css="[id*='editSupplierInvoice'] div[class*='head'] span")
	private WebElement editcodingheader;
	public  WebElement Labeleditcodingheader()
	{
		return editcodingheader;
		
	}
	@FindBy(css="[id*='edit'] [class='data_table'] tr:nth-child(1) td:nth-child(1)")
	private WebElement editInvoicenumber;
	public WebElement labeleditInvoicenumber()
	{
		return editInvoicenumber;
	}
	@FindBy(css="[id*='edit'] [class='data_table'] tr:nth-child(2) td:nth-child(1)")
	private WebElement editInvoicedate;
	public WebElement labeleditInvoicedate()
	{
		return editInvoicedate;
	}
	@FindBy(css="[for='invoiceNetAmount']")
	private WebElement editnetamnt;
	public WebElement labeleditnetamnt()
	{
		return editnetamnt;
	}
	@FindBy(css="[id*='edit'] [class='data_table'] tr:nth-child(4) td:nth-child(1)")
	private WebElement edittaxamnt;
	public WebElement labeledittaxamnt()
	{
		return edittaxamnt;
	}
	@FindBy(css="[id*='edit'] [class='data_table'] tr:nth-child(5) td:nth-child(1)")
	private WebElement editfreightamnt;
	public WebElement labeleditfreightamnt()
	{
		return editfreightamnt;
	}
	@FindBy(css="[id*='edit'] [class='data_table'] tr:nth-child(6) td:nth-child(1)")
	private WebElement edittotinvoiceamnt;
	public WebElement labeledittotinvoiceamnt()
	{
		return edittotinvoiceamnt;
	}
	@FindBy(css="[id*='edit'] [class='data_table'] tr:nth-child(7) td:nth-child(1)")
	private WebElement editcurrency;
	public WebElement labeleditcurrency()
	{
		return editcurrency;
	}
	
	@FindBy(css="[id*='edit'] [class='data_table'] tr:nth-child(9) td:nth-child(1)")
	private WebElement editinvoicesta;
	public WebElement labeleditinvoicesta()
	{
		return editinvoicesta;
	}
	
	@FindBy(css="[id*='edit'] [class='data_table'] tr:nth-child(10) td:nth-child(1)")
	private WebElement editinvsubdate;
	public WebElement labeleditinvsubdate()
	{
		return editinvsubdate;
	}
	
	@FindBy(css="[id*='edit'] [class='data_table'] tr:nth-child(11) td:nth-child(1)")
	private WebElement editinvtype;
	public WebElement labeleditinvtype()
	{
		return editinvtype;
	}
	//coding table headers
	
	@FindBy(css="[id*='editSupplierInvoice'] th:nth-child(1)")
	private WebElement Labeleditinvamnt;
	public WebElement labeleditinvamnt()
	{
		return Labeleditinvamnt;
	}
	
	@FindBy(css="[id*='editSupplierInvoice'] th:nth-child(2)")
	private WebElement editinvpo;
	public WebElement Labeleditinvpo()
	{
		return editinvpo;
	}
	
	@FindBy(css="[for*='sowNumber']")
	private WebElement editinvsow;
	public WebElement labeleditinvsow()
	{
		return editinvsow;
	}
	@FindBy(css="th:nth-child(3)")
	private WebElement editinvrcvrnum;
	public WebElement labeleditinvrcvrnum()
	{
		return editinvrcvrnum;
	}
	@FindBy(css="th:nth-child(4)")
	private WebElement editinvlaborcode;
	public WebElement labeleditinvlaborcode()
	{
		return editinvlaborcode;
	}
	@FindBy(css="th:nth-child(5)")
	private WebElement editinvvendor;
	public WebElement labeleditinvvendor()
	{
		return editinvvendor;
	}
	@FindBy(css="th:nth-child(6)")
	private WebElement editinvplc;
	public WebElement labeleditinvplc()
	{
		return editinvplc;
	}
	@FindBy(css="th:nth-child(7)")
	private WebElement editinvhrs;
	public WebElement labeleditinvhrs()
	{
		return editinvhrs;
	}
	
	@FindBy(css="div[class='header'] form-select  select")
	private WebElement tasksViewDDL;
	public WebElement tasksViewDDL(){
		return tasksViewDDL;
	}
	
	@FindBy(css="thead th")
	private List<WebElement> Headers;
	
	@FindBy(css="[ng-bind='vm.dataSource.message']")
	private WebElement NoData;
	public WebElement NoData(){
		return NoData;
	}	
	
	//New locators
	@FindBy(css=".ng-scope.check_box span")
	private List<WebElement> checkBoxList;
	public List<WebElement> checkBoxList(){
		return checkBoxList;
	}
	
	@FindBy(css= "button[class*='action_buttons']")
	private WebElement Actnbtn;
	
	@FindBy(css="[value='Reject']")
	private WebElement RejectBtn;
	public WebElement RejectBtn(){
		return RejectBtn;
	}
	
	@FindBy(css="[title='Request Update']")
	private WebElement RequestUpdate;
	public WebElement RequestUpdate(){
		return RequestUpdate;
	}
	
	@FindBy(css="iframe[src*='customerApprovalsForm.lvp']")
	private WebElement IFrameCustomerApproval;
	public WebElement IFrameCustomerApproval(){
		return IFrameCustomerApproval;
	}
	
	@FindBy(id="comment")
	private WebElement commentTxtBox;
	public WebElement commentTxtBox(){
		return commentTxtBox;
	}
	
	@FindBy(css=".error")
	private WebElement commentErrorMsg;
	public WebElement commentErrorMsg(){
		return commentErrorMsg;
	}
	
	@FindBy(css="[for='privateComment']")
	private WebElement privateChkBox;
	public WebElement privateChkBox(){
		return privateChkBox;
	}
	
	@FindBy(css=".button_primary")
	private WebElement submitBtn;
	public WebElement submitBtn(){
		return submitBtn;
	}
	
	@FindBy(id="bannerDiv")
	private WebElement bannerMsg;
	public WebElement bannerMsg(){
		return bannerMsg;
	}
	
	@FindBy(css="iframe[src*='invoiceTasksRequestUpdate.lvp']")
	private WebElement IFrameRequestUpdate;
	public WebElement IFrameRequestUpdate(){
		return IFrameRequestUpdate;
	}
	
	@FindBy(css="div#user_chosen span")
	private WebElement recipientDrpdn;
	public WebElement recipientDrpdn(){
		return recipientDrpdn;
	}
	
	@FindBy(css=".chosen-search>input")
	private WebElement recipientSearchTxt;
	public WebElement recipientSearchTxt(){
		return recipientSearchTxt;
	}
	
	@FindBy(id="subject")
	private WebElement subjectTextbox;
	public WebElement subjectTextbox(){
		return subjectTextbox;
	}
	
	@FindBy(css="[data-messagebag-id*='subject']")
	private WebElement subjectErrMsg;
	public WebElement subjectErrMsg(){
		return subjectErrMsg;
	}
	
	@FindBy(id="message")
	private WebElement messageTextbox;
	public WebElement messageTextbox(){
		return messageTextbox;
	}
	
	@FindBy(css="[data-messagebag-id*='message']")
	private WebElement messageErrMsg;
	public WebElement messageErrMsg(){
		return messageErrMsg;
	}
	
	//End Of Locators
	
	//Main Method
	public void Search(LinkedHashMap<String, String> dataMap) throws IOException
	{
		//Jump to Another Dashboard
		/*if(dataMap.containsKey("Filterby"))
		{
			lavanteUtils.click(Filterby);
			lavanteUtils.selectvalueFrmDpdn(dataMap.get("Filterby"));
			lavanteUtils.waitForTime(2000);
		}*/
		switchTasksClaimView(dataMap);
		search(dataMap);
	}
	
	private void switchTasksClaimView(LinkedHashMap<String, String> dataMap) {
		String data="17201";
		if (dataMap.containsKey("View")){
			data=dataMap.get("View");
			if(data.contains("My Tasks")){
				data=""+17202;
				lavanteUtils.selectbyvalue(data,tasksViewDDL);
				lavanteUtils.fluentwait(Search);
			}else{
				data=""+17201;
				lavanteUtils.selectbyvalue(data,tasksViewDDL);
				lavanteUtils.fluentwait(Search);
			}
		}
	}
		
	
	public void selectInvoiceMethod(LinkedHashMap<String, String> dataMap) throws IOException {
		switchTasksClaimView(dataMap);
		search(dataMap);
		selectInvoice(dataMap);
		if(dataMap.containsKey("InvoiceNumber")){
			if(!dataMap.get("InvoiceNumber").equalsIgnoreCase("ANY")){
				formAction(dataMap);
			}else{
				Assert.assertTrue(false,"No invoice Found");
			}
		}else{
			Assert.assertTrue(false,"No invoice Found");
		}
	}
	
	private void selectInvoice(LinkedHashMap<String, String> dataMap) {
		int size = iterateSearchHeaderFindColList("Invoice Number").size() - 1;
		if (iterateSearchHeaderFindColList("Invoice Number").size() > 0) {
			if (dataMap.containsKey("InvoiceNumber") && dataMap.containsKey("supplierName") ) {
				String actualInv="";  
				String actualSup=""; 
				
				for (int i = 0; i <= size; i++) {
					String expSuper = dataMap.get("supplierName"); 
					String expInv= dataMap.get("InvoiceNumber")  ;
					actualSup = iterateSearchHeaderFindColList("Supplier Name").get(i).getText();
					
					if(expSuper.equalsIgnoreCase(actualSup) || expSuper.equalsIgnoreCase("Any")) {
						actualSup = iterateSearchHeaderFindColList("Supplier Name").get(i).getText();
						actualInv = iterateSearchHeaderFindColList("Invoice Number").get(i).getText(); //1100
						if(expInv.equalsIgnoreCase(actualInv) || expInv.equalsIgnoreCase("ANY") ){
								lavanteUtils.click(iterateSearchHeaderFindColList("Invoice Date").get(i));
								dataMap.put("supplierName", actualSup);
								dataMap.put("InvoiceNumber", actualInv);
								break;
							}
						}
					}
				
			}
			lavanteUtils.waitForTime(2000);
		}else{
			Reporter.log("No Invoice data found for this search");
		}
		
	}

	public void search(LinkedHashMap<String, String> dataMap) throws IOException
	{
		lavanteUtils.fluentwait(Search);
		String y="DUMMY";
		String x="//*[text()='"+y+"']/../following-sibling::div//input";
		
		if(dataMap.containsKey("supplierName")){
			if(!dataMap.get("supplierName").equalsIgnoreCase("ANY")){
				String z=x;
				z=z.replace(y, "Supplier Name");
				lavanteUtils.driver.findElement(By.xpath(z)).clear();
				lavanteUtils.driver.findElement(By.xpath(z)).sendKeys(dataMap.get("supplierName"));
			}
		}
		if(dataMap.containsKey("InvoiceNumber")){
			if(!dataMap.get("InvoiceNumber").equalsIgnoreCase("ANY")){
				String z=x;
				z=z.replace(y, "Invoice Number");
				lavanteUtils.driver.findElement(By.xpath(z)).clear();
				lavanteUtils.driver.findElement(By.xpath(z)).sendKeys(dataMap.get("InvoiceNumber"));
			}
		}
		if(dataMap.containsKey("InvoiceType")){
			if(!dataMap.get("InvoiceType").equalsIgnoreCase("ANY")){
				String z=x;
				z=z.replace(y, "Invoice Type");
				z=z.replace("input", "button");
				lavanteUtils.driver.findElement(By.xpath(z)).click();
				lavanteUtils.NwselectvalueFrmDpdn1(dataMap.get("InvoiceType"));
			}
		}
		
		lavanteUtils.click(Search);
		lavanteUtils.waitForTime(2000);
	}
	
	public void formAction(LinkedHashMap<String, String> dataMap) {
		lavanteUtils.click(Actnbtn);
		if(dataMap.containsKey("Reject")) {
			lavanteUtils.click(RejectBtn);
			rejectInvoice(dataMap);
		}
		
		if(dataMap.containsKey("RequestUpdate")) {
			lavanteUtils.click(RequestUpdate);
			requestUpdate(dataMap);
		}
	}
	
	public void rejectInvoice(LinkedHashMap<String, String> dataMap) {
		lavanteUtils.switchtoFrame(IFrameCustomerApproval());
		
		if(dataMap.containsKey("RejectComment")) {
			if(dataMap.containsKey("CommentError")) {
				lavanteUtils.click(submitBtn);
				dataMap.put("CommentError", commentErrorMsg.getText());
			}
			
			lavanteUtils.typeinEdit(dataMap.get("RejectComment"), commentTxtBox);
			if(dataMap.containsKey("PrivateFlag")) {
				lavanteUtils.click(privateChkBox);
			}
			lavanteUtils.click(submitBtn);
			lavanteUtils.switchtoFrame(null);
			lavanteUtils.fluentwait(bannerMsg);
			dataMap.put("BannerMsg", bannerMsg.getText());
		}
	}
	
	public void requestUpdate(LinkedHashMap<String, String> dataMap) {
		lavanteUtils.switchtoFrame(IFrameRequestUpdate);
		
		if(dataMap.containsKey("MandatoryChecks")) {
			lavanteUtils.click(submitBtn);
			dataMap.put("SubjectErr", subjectErrMsg.getText());
			dataMap.put("MessageErr", messageErrMsg.getText());
		}
		if(dataMap.containsKey("Recipient")) {
			lavanteUtils.click(recipientDrpdn);
			lavanteUtils.waitForTime(2000);
			lavanteUtils.switchtoFrame(null);
			lavanteUtils.typeinEdit(dataMap.get("Recipient"), recipientSearchTxt);
			lavanteUtils.selectvalueFrmDpdn("any");
			lavanteUtils.switchtoFrame(IFrameRequestUpdate());
		}
		
		if(dataMap.containsKey("Subject")) {
			lavanteUtils.typeinEdit(dataMap.get("Subject"), subjectTextbox);
		}
		
		if(dataMap.containsKey("Message")) {
			lavanteUtils.typeinEdit(dataMap.get("Message"), messageTextbox);
		}
			
		lavanteUtils.click(submitBtn);
		
		lavanteUtils.switchtoFrame(null);
		lavanteUtils.fluentwait(bannerMsg);
		dataMap.put("BannerMsg", bannerMsg.getText());
	}
	
	public void TaskInvoice(LinkedHashMap<String, String> dataMap) throws IOException
	{
		lavanteUtils.switchtoFrame(IFRAMEEditInvoice);
		lavanteUtils.waitForTime(6000);
		lavanteUtils.fluentwait(invamount);
		
		fillEditInvoiceDetails(dataMap);
		formSaveAndApprove(dataMap);
	}
	
	//fillEditInvoiceDetails
		public void fillEditInvoiceDetails(LinkedHashMap<String, String> dataMap) throws IOException 
	{
		if(dataMap.containsKey("OrgNumber"))
		{ 
			Select s=new Select(SelectOrg);
			s.selectByVisibleText(dataMap.get("OrgNumber"));
			
		}
		
		if(dataMap.containsKey("ProjNumber"))
		{
			lavanteUtils.typeinEdit(dataMap.get("ProjNumber"), ProjectNumber);
			
		}
		
		
		if(dataMap.containsKey("AccNumber"))
		{
		
			Select s=new Select(AccountNumber);
			s.selectByVisibleText(dataMap.get("AccNumber"));			
		}
		
		//Fill Data by changing the invoice type
		if(dataMap.containsKey("Invtypedrpdown"))
		{
			lavanteUtils.click(Invoicetypedrpdown);
			lavanteUtils.selectvalueFrmDpdn(dataMap.get("Invtypedrpdown"));
			lavanteUtils.switchtoFrame(IFRAMEEditInvoice);
		}
		
		
		if(dataMap.containsKey("InvAmount"))
		{
			lavanteUtils.typeinEdit(dataMap.get("InvAmount"), invamount);
			
		}
		
		
		if(dataMap.containsKey("PONumber"))
		{
			lavanteUtils.typeinEdit(dataMap.get("PONumber"), PONumber);
			
		}
		
		if(dataMap.containsKey("ReceiverNumber"))
		{
			lavanteUtils.typeinEdit(dataMap.get("ReceiverNumber"), ReceiverNum);
			
		}
		
		/*if(dataMap.containsKey("InvSOWNum"))
		{
			SOWNumber().click();
			CommonUtils.waitForTime(2000);
			lu.switchtoFrame(null);
			lu.selectvalueFrmDpdn(dataMap.get("InvSOWNum"));
			lu.switchtoFrame(IFRAMEEditInvoice);
		}*/
		
		if(dataMap.containsKey("InvSOWNum"))
		{
		
			Select s=new Select(SOWNumber);
			s.selectByVisibleText(dataMap.get("InvSOWNum"));			
		}
		
		
		if(dataMap.containsKey("InvDel"))
		{
			String deliverable=dataMap.get("InvDel");
			if(deliverable.contains("#"))
			{
					String[] Deliverablelist=deliverable.split("#");
						for(int i=0;i<Deliverablelist.length;i++)
						{
							for(int j=0;j<Deliverable.size();j++){
								String appdel=Deliverable.get(j).getText();
								if(appdel.equalsIgnoreCase(Deliverablelist[i])){
									Deliverable.get(j).click();
								}
						}
						
						}
			}else
			{	
				for(int j=0;j<Deliverable.size();j++){
					String appdel=Deliverable.get(j).getText();
					if(appdel.equalsIgnoreCase(deliverable)){ 
						
						Select s=new Select(Deliverables);
						s.selectByVisibleText(deliverable);
						
				}
			}
			}
				
		
		if(dataMap.containsKey("LabourCode"))
		{
			
			LaborCode().click();
			lavanteUtils.waitForTime(3000);
			if(dataMap.containsKey("VendorEmployee"))
			{
				lavanteUtils.typeinEdit(dataMap.get("VendorEmployee"), VendorEmployee);
				
			}
			
			if(dataMap.containsKey("PLC"))
			{
				lavanteUtils.typeinEdit(dataMap.get("PLC"), PLC);
				
			}
			
			if(dataMap.containsKey("hours"))
			{
				lavanteUtils.typeinEdit(dataMap.get("hours"), Hours);
				
			}
		}
		}
		
		
		
	}
		
	public List<WebElement> iterateSearchHeaderFindColList(String col) {
		List<WebElement> s = null;
		int j = ColIdentify(col);
		String x = "tbody td:nth-child(" + j + ")";
		s = lavanteUtils.driver.findElements(By.cssSelector(x));
		if (col.contains("Invoice Number") || col.contains("Supplier Name")) {
			x = "tbody td:nth-child(" + j + ") a";
			s = lavanteUtils.driver.findElements(By.cssSelector(x));
		}
		return s;
	}
	
	public int ColIdentify(String col) {
		int ki = 0;
		boolean found = false;
		if (Headers.size() > 0) {
			for (int i = 0; i < Headers.size(); i++) {
				String x = Headers.get(i).getText().toLowerCase();
				if (x.contains(col.toLowerCase())) {
					ki = i;
					// List start with 0 but need a number more than that to
					// fetch in xpath
					ki = i + 1;
					found = true;
					break;
				}
			}
		}

		if (found == false) {
			Assert.assertTrue(false, "Col name not found" + col);
		}
		return ki;

	}
		
	//formSaveAndApprove
	public void formSaveAndApprove(LinkedHashMap<String, String> dataMap) throws IOException 
	{
		if(dataMap.containsKey("SaveAndApprove"))
		{
			lavanteUtils.click(Approvebtn);
			lavanteUtils.switchtoFrame(IFRAMEComment);
			//SubmitComment
			lavanteUtils.fluentwait(Comment);
			lavanteUtils.typeString(dataMap.get("comment"), Comment);
			lavanteUtils.click(Submitbtn);
			lavanteUtils.switchtoFrame(null);
		}
			
	}
	
}
