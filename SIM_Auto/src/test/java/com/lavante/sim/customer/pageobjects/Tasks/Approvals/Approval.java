
package com.lavante.sim.customer.pageobjects.Tasks.Approvals;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
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
 * Navigate to Task - Approval
 * @author Piramanayagam.S
 * @date- 24-10-2016
 */
public class Approval 
{
	
	LavanteUtils lavanteUtils=new LavanteUtils();
	
	public Approval(WebDriver driver)
	{
		lavanteUtils.driver=driver;
	}
	
	//Web Elements 
	
	
	@FindBy(css="button[type*='subm']")
	private WebElement searchbtn;
	public WebElement searchbtn()
	{
		return searchbtn;
	}
	
	//Page Navigation
	@FindBy(css="a[href*='pageNo'][href*='from']")
	private WebElement TotalPage;
	public WebElement TotalPage(){
		return TotalPage;
	}
	
	@FindBy(xpath= "//a[contains(@ng-click,'Page')][not(contains(@ng-click,'1'))]")
	private List<WebElement> TotalPages;
	public List<WebElement> TotalPages(){
		return TotalPages;
	}
	
	@FindBy(css="ul[class*='pag'] li:nth-child(5) a[href*='customer']")
	private List<WebElement> Nextpagebtn;
	public List<WebElement> Nextpagebtn(){
		return Nextpagebtn;
	}
	
	
	//Form Action
	
	@FindBy(css= "button[class*='action_buttons']")
	private WebElement Actnbtn;

	
	@FindBy(css="input[value*='Send']")
	private WebElement SendEmailbtn;
	public WebElement SendEmailbtn()
	{
		return SendEmailbtn;
	}
	
	@FindBy(css="input[value*='Edit']")
	private WebElement EditProfilebtn;
	public WebElement EditProfilebtn()
	{
		return EditProfilebtn;
	}
	
	@FindBy(css="input[value*='Reject']")
	private WebElement Rejectbtn;
	public WebElement Rejectbtn()
	{
		return Rejectbtn;
	}
	
	@FindBy(css="input[value*='Reassing']")
	private WebElement Reassignbtn;
	public WebElement Reassignbtn()
	{
		return Reassignbtn;
	}
	
	@FindBy(css="input[value*='Request']")
	private WebElement RequestUpdateBtn;
	public WebElement RequestUpdateBtn()
	{
		return RequestUpdateBtn;
	}
	
	@FindBy(css="input[value*='Approve']")
	private WebElement ApproveBtn;
	public WebElement ApproveBtn()
	{
		return ApproveBtn;
	}
	
	@FindBy(css="span[class*='error']")
	private WebElement Errormsg;
	public WebElement Errormsg()
	{
		return Errormsg;
	}
	
	//Reject Section
	@FindBy(id="comment")
	private WebElement comment;
	public WebElement comment()
	{
		return comment;
	}
	
	//Approve IFRAME
	@FindBy(css="iframe[src*='approve']")
	private WebElement IFRAMEApprove;
	public WebElement IFRAMEApprove()
	{
		return IFRAMEApprove;
	}
	
	@FindBy(id="isTempApproved")
	private WebElement TempApprovalchkbox;
	public WebElement TempApprovalchkbox()
	{
		return TempApprovalchkbox;
	}
	
	@FindBy(id="tempApprovedThroughDate")
	private WebElement TempApprovalDate;
	public WebElement TempApprovalDate()
	{
		return TempApprovalDate;
	}
	
	@FindBy(css="a[class*='high']")
	private WebElement TodayDate;
	public WebElement TodayDate(){
		return TodayDate;
	}
	
	@FindBy(how=How.XPATH,using="//a[@href='#']")
	private List<WebElement> Date;
	public  List<WebElement>  Date(){
		return Date;
	}
	
	
	
	@FindBy(id="comment")
	private WebElement ApprovalComment;
	public WebElement ApprovalComment()
	{
		return ApprovalComment;
	}
	
	@FindBy(css="[type='submit']")
	private WebElement ApprovalSubmit;
	public WebElement ApprovalSubmit()
	{
		return ApprovalSubmit;
	}

	
	
	//Request Update Forms
	@FindBy(css="iframe[src*='requestUpdate']")
	private WebElement IFRAMEreqUpdate;
	public WebElement IFRAMEreqUpdate()
	{
		return IFRAMEreqUpdate;
	}
	
	@FindBy(id="subject")
	private WebElement ReqUpdateSub;
	public WebElement ReqUpdateSub()
	{
		return ReqUpdateSub;
	}
	
	@FindBy(id="message")
	private WebElement ReqUpdateMsg;
	public WebElement ReqUpdateMsg()
	{
		return ReqUpdateMsg;
	}
	
	@FindBy(css="[value*='Request']")
	private WebElement ReqUpdatefrmbtn;
	public WebElement ReqUpdatefrmbtn()
	{
		return ReqUpdatefrmbtn;
	}
	
	//Email 
	@FindBy(css="iframe[src*='message']")
	private WebElement IFRAMEemail;
	public WebElement IFRAMEemail()
	{
		return IFRAMEemail;
	}
	
	@FindBy(id="from")
	private WebElement mailFrombtn;

	public WebElement mailFrombtn() {
		return mailFrombtn;
	}

	/*@FindBy(css="[id*='emailTemplate'] a")
	private WebElement mailTemplate;

	public WebElement mailTemplate() {
		return mailTemplate;
	}*/

	@FindBy(id="subject")
	private WebElement mailsubtxt;

	public WebElement mailsubtxt() {
		return mailsubtxt;
	}

	@FindBy(css="div[class*='editor']")
	private WebElement mailmsgtxt;

	public WebElement mailmsgtxt() {
		return mailmsgtxt;
	}

/*	@FindBy(how = How.XPATH, using = "//input[contains(@id,'emailAttachment')][last()]")
	private WebElement mailUploadbtn;

	public WebElement mailUploadbtn() {
		return mailUploadbtn;
	}

	@FindBy(how = How.XPATH, using = "//input[contains(@id,'emailAttachment')][last()]")
	private List<WebElement> mailUploadlstbtn;

	public List<WebElement> mailUploadlstbtn() {
		return mailUploadlstbtn;
	}

	@FindBy(how = How.XPATH, using = "//*[contains(@class,'MultiFile-title')]")
	private List<WebElement> mailAttchdfilname;

	public List<WebElement> mailAttchdfilname() {
		return mailAttchdfilname;
	}*/

	@FindBy(id="send_message")
	private WebElement mailSendbtn;

	public WebElement mailSendbtn() {
		return mailSendbtn;
	}

	/*@FindBy(id="save_as_template")
	private WebElement mailSavebtn;

	public WebElement mailSavebtn() {
		return mailSavebtn;
	}

	@FindBy(css="[type*='reset']")
	private WebElement mailClearbtn;

	public WebElement mailClearbtn() {
		return mailClearbtn;
	}*/

/*	@FindBy(css="input[name*='prompt']")
	private WebElement mailTemplateNametxt;

	public WebElement mailTemplateNametxt() {
		return mailTemplateNametxt;
	}*/
	
	@FindBy(css="[role*='dia'] button[class*='primary']")
	private WebElement OKbtn;

	public WebElement OKbtn() {
		return OKbtn;
	}

	@FindBy(css="div[class='header'] form-select  select")
	private WebElement tasksViewDDL;
	public WebElement tasksViewDDL(){
		return tasksViewDDL;
	}
	
	@FindBy(css="thead th")
	private List<WebElement> Headers;
	
	//End of Email
	
	//RE-USABLE METHODS 
	
	public String selectSupplierFormAction(LinkedHashMap<String, String> dataMap) throws Exception
	{
		String sname="";
		Search(dataMap);
		sname=selectSupplier(dataMap);
		if(sname.length()>0){
			formAction(dataMap);
			lavanteUtils.switchtoFrame(null);
			lavanteUtils.waitForTime(4000);
		}else{
			Assert.assertTrue(false,"Please Add Test Data for Invoice Page");
		}
		
		return sname;
		
	}

	public void Search(LinkedHashMap<String, String> dataMap) throws IOException
	{
		switchTasksClaimView(dataMap);
		if(dataMap.containsKey("Search")){
			
			lavanteUtils.fluentwait(searchbtn);
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
				if(!dataMap.get("InvoiceNumber").equalsIgnoreCase("ANY")){
					String z=x;
					z=z.replace(y, "Invoice Type");
					z=z.replace("input", "button");
					lavanteUtils.driver.findElement(By.xpath(z)).click();
					lavanteUtils.NwselectvalueFrmDpdn1(dataMap.get("InvoiceType"));
				}
			}
			
			lavanteUtils.click(searchbtn);
			
		}
		
		
		
	}
	
	/**
	 * 				//By Default My Task only for All task view will be triggered
	 * 
	 * @author Piramanayagam.S
	 * @param dataMap
	 */
	private void switchTasksClaimView(LinkedHashMap<String, String> dataMap) {
		String data="17202";
		if (dataMap.containsKey("View")){
			data=dataMap.get("View");
			if(data.contains("All Tasks")){
				data=""+17201;
				lavanteUtils.selectbyvalue(data,tasksViewDDL);
			}else{
				data=""+17202;

			}
		}	
		
		
	}
	
	public String selectSupplier(LinkedHashMap<String, String> dataMap) throws IOException 
	{
		String sname="";
		//lavanteUtils.waitForTime(5000);
		if(iterateSearchHeaderFindColList("Supplier Name").size()>0){
			//lavanteUtils.fluentwait(iterateSearchHeaderFindColList("Supplier Name").get(0));
			sname=iterateSearchHeaderFindColList("Supplier Name").get(0).getText();
			if(dataMap.containsKey("supplierName"))
			{
					lavanteUtils.click(iterateSearchHeaderFindColList("Division").get(0));
			}else{
					lavanteUtils.click(iterateSearchHeaderFindColList("Division").get(0));
			}	
		}
		return sname;
	}

	public String Managedby(LinkedHashMap<String, String> dataMap) throws FileNotFoundException, IOException, SQLException {
			String sname="";
			if(iterateSearchHeaderFindColList("Supplier Name").size()>0){
				
					sname=iterateSearchHeaderFindColList("Supplier Name").get(0).getText();
					int totalPage=TotalPages.size();
					if(totalPage==0) { 
							totalPage=1;
						}
					boolean foundinv=false;
					outr:for(int j=0;j<totalPage;j++){
						for(int i=0;i<iterateSearchHeaderFindColList("Supplier Name").size();i++){
							sname=iterateSearchHeaderFindColList("Supplier Name").get(i).getText();
							String quer="select ValueDescription from KeyValue where KeyValueID in ("
									+ " select ProfileManagedBy_KVID from Relationship where CustomerID="+dataMap.get("CustomerID")+" and LavanteUID in "
									+ " (select LavanteUID from Supplier where SupplierName like '%"+sname+"%'))";
							quer=lavanteUtils.fetchDBdata(quer);
							
							if(dataMap.containsKey("Managedby")){
								String manager=dataMap.get("Managedby");
								if(manager.equalsIgnoreCase(quer)){
										foundinv=true;
										break outr;
									}else{
										sname="";
									}
								}
						
						}
						int k=j+1;
						if(foundinv==false&&k<totalPage){
							Reporter.log("Search Ended on Page No:"+k,true);
							lavanteUtils.click(TotalPages.get(k));
							lavanteUtils.waitForTime(5000);
							lavanteUtils.fluentwait(iterateSearchHeaderFindColList("Supplier Name").get(0));
							lavanteUtils.waitforPageload(iterateSearchHeaderFindColList("Supplier Name").get(0));
						}
					}
				}
				if(!(sname.length()>0)){
					//Assert.assertTrue("Supplier Not Found for this category",false);
				}
				return sname;
		}
		
	public void formAction(LinkedHashMap<String, String> dataMap) throws Exception 
	{
	
		if(dataMap.containsKey("SendEmail")){
			lavanteUtils.click(Actnbtn);
			lavanteUtils.click(SendEmailbtn);
			SendEmail(dataMap);
		}
		if(dataMap.containsKey("EditProfile")){
			lavanteUtils.click(Actnbtn);
			lavanteUtils.click(EditProfilebtn);	
		}
		if(dataMap.containsKey("ReqUpdate")){
			lavanteUtils.click(Actnbtn);
			lavanteUtils.click(RequestUpdateBtn);	
			RequestUpdateformaction(dataMap);
		}
		if(dataMap.containsKey("Approve")){
			lavanteUtils.click(Actnbtn);
			lavanteUtils.click(ApproveBtn);	
			ApproveFormAction(dataMap);
		}
		if(dataMap.containsKey("Reject")){
			lavanteUtils.click(Actnbtn);
			lavanteUtils.click(Rejectbtn);	
			RejectFormAction(dataMap);
		}
		if(dataMap.containsKey("Reassign")){
			lavanteUtils.click(Actnbtn);
			lavanteUtils.click(Reassignbtn);	
		}
	}

	private void RejectFormAction(LinkedHashMap<String, String> dataMap) {
		lavanteUtils.switchtoFrame(IFRAMEApprove);
		if(dataMap.containsKey("RejectComment")){
			lavanteUtils.typeinEdit(dataMap.get("RejectComment"),comment);
		}
		if(dataMap.containsKey("RejectSupplier")){
			lavanteUtils.click(ApprovalSubmit);
		}
	}

	private void ApproveFormAction(LinkedHashMap<String, String> dataMap) {
		lavanteUtils.switchtoFrame(IFRAMEApprove);
		if(dataMap.containsKey("TempApprovalChk")){
			lavanteUtils.selectChkBox(TempApprovalchkbox,dataMap.get("TempApprovalChk"));
		}
		if(dataMap.containsKey("TempApprovalDate")){
			String date=dataMap.get("TempApprovalDate");
			lavanteUtils.click(TempApprovalDate);
			lavanteUtils.switchtoFrame(null);
			if(date.equalsIgnoreCase("Any")){ 
				lavanteUtils.clickJavaScript(TodayDate);
			}else{
				lavanteUtils.selectdate(date);
			}
			
			lavanteUtils.switchtoFrame(IFRAMEApprove);
		}
		if(dataMap.containsKey("ApprovalComment")){
			lavanteUtils.typeinEdit(dataMap.get("ApprovalComment"),ApprovalComment);	
		}
		if(dataMap.containsKey("SubmitApproval")){
			lavanteUtils.click(ApprovalSubmit);
			String err=dataMap.get("SubmitApproval");
			if(err.contains("ErrorMsg")){
				
			}else{
				
			}
		}
		
	}

	private void RequestUpdateformaction(LinkedHashMap<String, String> dataMap) {
		lavanteUtils.switchtoFrame(IFRAMEreqUpdate);
		if(dataMap.containsKey("Subject")){
			lavanteUtils.typeinEdit(dataMap.get("Subject"),ReqUpdateSub);	
		}
		if(dataMap.containsKey("Message")){
			lavanteUtils.typeinEdit(dataMap.get("Message"),ReqUpdateMsg);	
		}
		if(dataMap.containsKey("SubmitRequestUpdate")){
			lavanteUtils.click(ReqUpdatefrmbtn);	
		}
		
		
	}
	
	private void SendEmail(LinkedHashMap<String, String> dataMap) throws Exception {
		lavanteUtils.switchtoFrame(IFRAMEemail);
		fillformEmail(dataMap);
		formActionEmail(dataMap);
	}
	
	private void fillformEmail(LinkedHashMap<String, String> dataMap) throws Exception {
		lavanteUtils.switchtoFrame(IFRAMEemail);
		if (dataMap.containsKey("mailFrom")) {
			lavanteUtils.selectbyvalue(dataMap.get("mailFrom"),mailFrombtn);
/*			lavanteUtils.click(mailFrombtn);
			lavanteUtils.selectContainFrmDpdn(dataMap.get("mailFrom"));
			lavanteUtils.switchtoFrame(IFRAMEemail);
*/		}
		/*if (dataMap.containsKey("mailTemplate")) {
			lavanteUtils.click(mailTemplate);
			lavanteUtils.selectFrmDpdn(dataMap.get("mailTemplate"));
			lavanteUtils.switchtoFrame(IFRAMEemail);
		}*/
		if (dataMap.containsKey("mailSubject")) {
			lavanteUtils.typeinEdit(dataMap.get("mailSubject"), mailsubtxt);
		}
		if (dataMap.containsKey("mailMessage")) {
			lavanteUtils.click(mailmsgtxt);
			lavanteUtils.typeinEdit(dataMap.get("mailMessage"), mailmsgtxt);
		}
		/*if (dataMap.containsKey("attachFile")) {
			String file = dataMap.get("attachFile");
			if (file.contains("#")) {
				String[] f = file.split("#");
				for (int i = 0; i < f.length; i++) {
					String x = f[i];
					lavanteUtils.uploadFile(x, mailUploadbtn);
				}

			} else {
				lavanteUtils.uploadFile(file, mailUploadbtn);
			}

		}*/
	}

	private void formActionEmail(LinkedHashMap<String, String> dataMap) {
		lavanteUtils.switchtoFrame(IFRAMEemail);
		if (dataMap.containsKey("mailSend")) {
			lavanteUtils.click(mailSendbtn);
			confirmsendEmail(dataMap);
		}
		if (dataMap.containsKey("mailSave")) {
			//lavanteUtils.click(mailSavebtn);
		}
		if (dataMap.containsKey("mailClear")) {
			//lavanteUtils.click(mailClearbtn);
		}

	}
	
	private void confirmsendEmail(LinkedHashMap<String, String> dataMap) {
		lavanteUtils.switchtoFrame(null);
		if (dataMap.containsKey("mailSend")) {
			lavanteUtils.click(OKbtn);
			if (dataMap.containsKey("confirmMailSend")) {

			} else {
				//lavanteUtils.click(OKbtn);
			}
		}
	}

	public List<WebElement> iterateSearchHeaderFindColList(String col) {
		List<WebElement> s = null;
		int j = ColIdentify(col);
		String x = "tbody td:nth-child(" + j + ")";
		s = lavanteUtils.driver.findElements(By.cssSelector(x));
		if (col.contains("Invitation ID") || col.contains("Supplier Name")) {
			x = "tbody td:nth-child(" + j + ") a";
			s = lavanteUtils.driver.findElements(By.cssSelector(x));
		}
		return s;
	}
	
	private int ColIdentify(String col) {
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
}
