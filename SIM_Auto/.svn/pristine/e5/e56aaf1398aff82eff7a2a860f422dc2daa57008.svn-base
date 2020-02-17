
package com.lavante.sim.customer.pageobjects.Tasks.Reassignment;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.lavante.sim.Common.Util.LavanteUtils;

/**
 * Navigate to Task - Approval
 * 
 * @author Piramanayagam.S
 * @date- 24-10-2016
 */
public class Reassignment {

	LavanteUtils lavanteUtils = new LavanteUtils();

	public Reassignment(WebDriver driver) {
		lavanteUtils.driver = driver;
	}

	// Web Elements
	@FindBy(css="a[href*='viewApprovalTask']")
	private WebElement ReassignTAB;

	public WebElement ReassignTAB() {
		return ReassignTAB;
	}

	@FindBy(css="[id*='filterWorkflow'] a")
	private WebElement filterby;

	public WebElement filterby() {
		return filterby;
	}

	@FindBy(id="searchFilter")
	private WebElement suppnametxt;

	public WebElement suppnametxt() {
		return suppnametxt;
	}

	@FindBy(id= "supplierSearch")
	private WebElement searchbtn;

	public WebElement searchbtn() {
		return searchbtn;
	}

	@FindBy(css="#pendingTasks [href*='Invoice']")
	private List<WebElement> listInvNum;

	public List<WebElement> listInvNum() {
		return listInvNum;
	}

	@FindBy(css="#pendingTasks [href*='viewCompany']")
	private List<WebElement> listSName;

	public List<WebElement> listSName() {
		return listSName;
	}

	@FindBy(css="#pendingTasks td:nth-child(6)")
	private List<WebElement> listAssignedTo;

	public List<WebElement> listAssignedTo() {
		return listAssignedTo;
	}

	@FindBy(css="#new-supplier-approval tbody td:nth-child(1)")
	private List<WebElement> ListSupplierChckbox;

	public List<WebElement> ListSupplierChckbox() {
		return ListSupplierChckbox;
	}

	
	@FindBy(css="label[for*='bulkSelect']")
	private WebElement AllSupChkbox;

	public WebElement AllSupChkbox() {
		return AllSupChkbox;
	}
	
	@FindBy(css= "button[class*='action_buttons']")
	private WebElement Actnbtn;

	public WebElement Actnbtn() {
		return Actnbtn;
	}


	@FindBy(css="input[type*='submit']")
	private WebElement Reassignbtn;

	public WebElement Reassignbtn() {
		return Reassignbtn;
	}

	@FindBy(css="input[name='remindTask']")
	private WebElement SendReminderBtn;

	public WebElement SendReminderBtn() {
		return SendReminderBtn;
	}

	@FindBy(css="div[role='dialog'] div[class*='ui-dialog-content']")
	private WebElement GetSuccessfulTxt;

	public WebElement GetSuccessfulTxt() {
		return GetSuccessfulTxt;
	}

	@FindBy(css="iframe[src*='Reassign']")
	private WebElement IFRAMEReassign;

	public WebElement IFRAMEReassign() {
		return IFRAMEReassign;
	}

	@FindBy(css="input[data-input-id*='Group']~label")
	private WebElement Groupoption;

	public WebElement Groupoption() {
		return Groupoption;
	}

	@FindBy(css="input[data-input-id*='Contact']~label")
	private WebElement Useroption;

	public WebElement Useroption() {
		return Useroption;
	}

	@FindBy(css="input[data-input-id*='Role']~label")
	private WebElement Roleoption;

	public WebElement Roleoption() {
		return Roleoption;
	}

	@FindBy(css="[id*='customerGroup'] a")
	private WebElement Grpdpdn;

	public WebElement Grpdpdn() {
		return Grpdpdn;
	}

	@FindBy(css="[id*='customerUserRole'] a")
	private WebElement Roledpdn;

	public WebElement Roledpdn() {
		return Roleoption;
	}

	@FindBy(css="[id*='customerInvitingOrg'] a")
	private WebElement InvitingOrgdpdn;

	public WebElement InvitingOrgdpdn() {
		return InvitingOrgdpdn;
	}
	
	@FindBy(css="[id*='customerInvitingOrg'] input")
	private WebElement InvitingOrgdpdntxt;


	@FindBy(css="[id*='customerContact'] a")
	private WebElement UserDrpdn;

	public WebElement UserDrpdn() {
		return UserDrpdn;
	}

	@FindBy(css="[id*='groupUser'] a")
	private WebElement GrpUserDrpdn;

	public WebElement GrpUserDrpdn() {
		return GrpUserDrpdn;
	}

	@FindBy(css="[id*='customerContact'] input")
	private WebElement Usertxt;

	public WebElement Usertxt() {
		return Usertxt;
	}

	@FindBy(css="button[class='primary']")
	private WebElement OkBtn;

	public WebElement OkBtn() {
		return OkBtn;
	}
	// RE-USABLE METHODS

	public String selectSupplierFormAction(LinkedHashMap<String, String> dataMap) throws IOException, SQLException {
		String sname = "";
		Search(dataMap);
		sname = selectSupplier(dataMap);
		if(sname.length()>0){
			formAction(dataMap);
			lavanteUtils.fluentwait(filterby);
		}else{
			Assert.assertTrue(false,"Please Add Test Data in Reassignment Page");
		}
		return sname;
	}

	public void Search(LinkedHashMap<String, String> dataMap) throws IOException {
		lavanteUtils.waitforPageload(searchbtn);
		if (dataMap.containsKey("filterby")) {
			String data=dataMap.get("filterby");
			
			if(data.toLowerCase().contains("invoice")){
				String url=lavanteUtils.driver.getCurrentUrl();
				System.out.println(url);
				lavanteUtils.driver.get(url+"?filterWorkflow=13");
			}else{
				lavanteUtils.click(filterby);
				lavanteUtils.selectvalueFrmDpdn(data);
			}
			lavanteUtils.waitforPageload(searchbtn);
		}
		if (dataMap.containsKey("supplierName")) {
			lavanteUtils.typeinEdit(dataMap.get("supplierName"), suppnametxt);
		}
		if (dataMap.containsKey("search")) {
			lavanteUtils.click(searchbtn);
			lavanteUtils.waitforPageload(searchbtn);
		}

	}

	public String selectSupplier(LinkedHashMap<String, String> dataMap) throws IOException {
		String sname = "";

		if (listSName.size() > 0) {
			lavanteUtils.fluentwait(listSName.get(0));
			if(dataMap.containsKey("supplierName"))
			{
				
			}else if(dataMap.containsKey("ALLSupplier")){
				lavanteUtils.click(AllSupChkbox);
				sname=listSName.get(0).getText();
			}else{
				int rand=0;
				sname=listSName.get(rand).getText();
				if(dataMap.containsKey("filterby")){
					String inv=dataMap.get("filterby");
					if(inv.contains("Invoice")){
						sname=listInvNum.get(rand).getText();
					}
				}
				if(ListSupplierChckbox().size()>0){
					lavanteUtils.click(listAssignedTo().get(rand));
					}
			}	
		}
		
		
		return sname;
	}

	public void formAction(LinkedHashMap<String, String> dataMap) throws IOException, SQLException {

		if (dataMap.containsKey("SendReminder")) {
			lavanteUtils.click(Actnbtn);
			lavanteUtils.click(SendReminderBtn);
			lavanteUtils.waitForTime(4000);
		}
		if (dataMap.containsKey("ReAssign")) {
			lavanteUtils.click(Actnbtn);
			lavanteUtils.click(Reassignbtn);
			Reassigns(dataMap);
			if(!dataMap.containsKey("ReAssignError")){
				lavanteUtils.waitforPageload(searchbtn);
				lavanteUtils.fluentwait(searchbtn);
				lavanteUtils.waitForTime(4000);
			}
		}

	}

	public void Reassigns(LinkedHashMap<String, String> dataMap) throws FileNotFoundException, IOException, SQLException {
		Reassigning(dataMap);
		lavanteUtils.switchtoFrame(IFRAMEReassign);
		if(!dataMap.containsKey("ReAssignError")){
			lavanteUtils.click(Reassignbtn);
			lavanteUtils.switchtoFrame(null);
		}
		
	}

	public void Reassigning(LinkedHashMap<String, String> dataMap) throws FileNotFoundException, IOException, SQLException {
		lavanteUtils.switchtoFrame(IFRAMEReassign);
		lavanteUtils.fluentwait(Useroption);
		if (dataMap.containsKey("AssginTo")) {
			String data = dataMap.get("AssginTo");
			if (data.equalsIgnoreCase("Group")) {
				// lavanteUtils.click(Groupoption);
			}
			if (data.equalsIgnoreCase("Role")) {
				lavanteUtils.click(Roleoption);
			}
			if (data.equalsIgnoreCase("User")) {
				lavanteUtils.click(Useroption);
			}

		}
		if (dataMap.containsKey("InvitingOrg")) {
			lavanteUtils.click(InvitingOrgdpdn);
			lavanteUtils.switchtoFrame(null);
			lavanteUtils.typeinEdit(dataMap.get("InvitingOrg"),InvitingOrgdpdntxt);
			lavanteUtils.selectvalueFrmDpdn(dataMap.get("InvitingOrg"));
			lavanteUtils.switchtoFrame(IFRAMEReassign);
		}

		if (dataMap.containsKey("Group")) {
			lavanteUtils.click(Grpdpdn);
			lavanteUtils.selectvalueFrmDpdn(dataMap.get("Group"));
			lavanteUtils.switchtoFrame(IFRAMEReassign);

			if (dataMap.containsKey("User")) {
				lavanteUtils.click(GrpUserDrpdn);
				lavanteUtils.selectContainFrmDpdn(dataMap.get("User"));
				lavanteUtils.switchtoFrame(IFRAMEReassign);
			}

		}
		if (dataMap.containsKey("Role")) {
			lavanteUtils.click(Roledpdn);
			lavanteUtils.selectvalueFrmDpdn(dataMap.get("Role"));
			lavanteUtils.switchtoFrame(IFRAMEReassign);
		}
		if ((!dataMap.containsKey("Group")) && (dataMap.containsKey("User"))) {
			lavanteUtils.click(UserDrpdn);
			lavanteUtils.selectContainFrmDpdn(dataMap.get("User"));
			lavanteUtils.switchtoFrame(IFRAMEReassign);
		}

		/*
		 * if(dataMap.containsKey("User")){
		 * lavanteUtils.switchtoFrame(IFRAMEReassign);
		 * lavanteUtils.fluentwait(UserDrpdn); String x=dataMap.get("User");
		 * String qu="select ContactName from Contact where Email like '"+x+"'";
		 * String ax=lavanteUtils.fetchDBdata(qu)+"("+x+")";
		 * System.out.println(ax); Select s = new Select(UserDrpdn);
		 * s.selectByValue(lavanteUtils.fetchDBdata(
		 * "select ContactID from Contact where Email like 'gpstrategies.admin@lavante.com%'"
		 * )); lavanteUtils.selectbyvisibiletxt(ax, UserDrpdn);
		 * 
		 * 
		 * lavanteUtils.click(UserDrpdn); lavanteUtils.click(UserDrpdn); String
		 * data=dataMap.get("User"); lavanteUtils.switchtoFrame(null);
		 * lavanteUtils.fluentwait(Usertxt);
		 * 
		 * data="gpstrategies.admin"; lavanteUtils.typeinEdit(data,Usertxt);
		 * Usertxt().sendKeys(Keys.ENTER);
		 * //lavanteUtils.selectvalueFrmDpdn(data);
		 * lavanteUtils.switchtoFrame(IFRAMEReassign); }
		 */

	}
	
}
