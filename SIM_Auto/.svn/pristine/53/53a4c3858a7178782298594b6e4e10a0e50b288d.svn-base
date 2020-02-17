package com.lavante.sim.customer.pageobjects.Tasks.Claims;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.Reporter;

import com.lavante.sim.Common.Util.LavanteUtils;

/**
 * Tasks-> Claims Page   [URL: claimTasks.lvp]
 *
 */

public class TasksClaimPage {
	
	LavanteUtils lavanteUtils=new LavanteUtils();

	public TasksClaimPage(WebDriver driver){
		lavanteUtils.driver=driver;
	}

	@FindBy(css="input[id*='taskId']+label")
	private List<WebElement> selectClaimTaskChkBox;
	public List<WebElement> selectClaimTaskChkBox(){
		return selectClaimTaskChkBox;
	}
	
	@FindBy(css="thead th")
	private List<WebElement> Headers;
	
	@FindBy(css="table-grid button[class*='action_buttons']")
	private WebElement actionBtn;
	public WebElement actionBtn(){
		return actionBtn;
	}
	
	@FindBy(css="[ng-bind='vm.dataSource.message']")
	private WebElement NoData;
	public WebElement NoData(){
		return NoData;
	}	
	
	@FindBy(css="li input[value*='Edit']")
	private WebElement editClaimOption;
	public WebElement editClaimOption(){
		return editClaimOption;
	}
	
	@FindBy(css="li input[value*='Reassign']")
	private WebElement reassignOption;
	public WebElement reassignOption(){
		return reassignOption;
	}
	
	@FindBy(css="li input[value*='Request']")
	private WebElement reqUpdateOption;
	public WebElement reqUpdateOption(){
		return reqUpdateOption;
	}
	
	@FindBy(css="li input[value*='Process']")
	private WebElement processClaimOption;
	public WebElement processClaimOption(){
		return processClaimOption;
	}
	
	@FindBy(css="li input[value*='Deny']")
	private WebElement denyClaimOption;
	public WebElement denyClaimOption(){
		return denyClaimOption;
	}
	
	@FindBy(css="iframe[src*='processClaims']")
	private WebElement IFrameProcessClaim;
	public WebElement IFrameProcessClaim(){
		return IFrameProcessClaim;
	}
	
	@FindBy(css="button[title='Cancel']")
	private WebElement processClaimCancelBtn;
	public WebElement processClaimCancelBtn(){
		return processClaimCancelBtn;
	}
	
	@FindBy(css="button[value='Save and Submit']")
	private WebElement processClaimConfirmBtn;
	public WebElement processClaimConfirmBtn(){
		return processClaimConfirmBtn;
	}
	
	@FindBy(css="div.bannerMessage")
	private WebElement processClaimBannerMsg;
	public WebElement processClaimBannerMsg(){
		return processClaimBannerMsg;
	}
	
	//My Task/All Task
	@FindBy(css="drop-down:nth-child(2) button")
	private WebElement tasksViewDDL;
	public WebElement tasksViewDDL(){
		return tasksViewDDL;
	}
	
	//Layout Drpdown
	@FindBy(css="drop-down button")
	private WebElement LayoutDrpdn;
	
	
	//Claims/Claims and GL CODE
	@FindBy(css="div[class='header'] form-select:nth-child(2)  select")
	private WebElement tasksClaimsViewDDL;
	public WebElement tasksClaimsViewDDL(){
		return tasksClaimsViewDDL;
	}
	
	@FindBy(css="button-group button:nth-child(2)")
	private WebElement taskSearchBtn;
	public WebElement taskSearchBtn(){
		return taskSearchBtn;
	}
	
	@FindBy(css="iframe[src*='claimRequestUpdateForm.lvp']")
	private WebElement frameReqUpdate;
	public WebElement frameReqUpdate(){
		return frameReqUpdate;
	}
	
	@FindBy(css="iframe[src*='customerReassignForm.lvp']")
	private WebElement frameReassign;
	public WebElement frameReassign(){
		return frameReassign;
	}
	
	@FindBy(css="div[class*='titlebar']")
	private WebElement titleText;
	public WebElement titleText(){
		return titleText;
	}
			
	//Request Update Popup 
	@FindBy(css="#recipient_chosen a")
	private WebElement recipientDDL;
	public WebElement recipientDDL(){
		return recipientDDL;
	}
	
	@FindBy(css="#recipient_chosen input")
	private WebElement recipientSearchTxtBox;
	public WebElement recipientSearchTxtBox(){
		return recipientSearchTxtBox;
	}
	
	@FindBy(id="subject")
	private WebElement subTxtBox;
	public WebElement subTxtBox(){
		return subTxtBox;
	}
	
	@FindBy(css="[data-messagebag-id*='subject']")
	private WebElement subjectErrMsg;
	public WebElement subjectErrMsg(){
		return subjectErrMsg;
	}
	
	@FindBy(id="message")
	private WebElement msgTxtBox;
	public WebElement msgTxtBox(){
		return msgTxtBox;
	}
	
	@FindBy(css="[data-messagebag-id*='message']")
	private WebElement messageErrMsg;
	public WebElement messageErrMsg(){
		return messageErrMsg;
	}
	
	@FindBy(css="input[class*='primary']")
	private WebElement reqUpdateBtn;
	public WebElement reqUpdateBtn(){
		return reqUpdateBtn;
	}

	@FindBy(css=".page-header")
	private WebElement pageHeader;
	public WebElement pageHeader(){
		return pageHeader;
	}

	@FindBy(id="bannerDiv")
	private WebElement bannerMsg;	
	public WebElement bannerMsg(){
		return bannerMsg;
	}

	//Reassign Popup
	@FindBy(css="#assignType_group+label")
	private WebElement assignToGroupRadBtn;
	public WebElement assignToGroupRadBtn(){
		return assignToGroupRadBtn;
	}
	
	@FindBy(css="#assignType_role+label")
	private WebElement assignToRoleRadBtn;
	public WebElement assignToRoleRadBtn(){
		return assignToRoleRadBtn;
	}
	
	@FindBy(css="#assignType_user+label")
	private WebElement assignToUserRadBtn;
	public WebElement assignToUserRadBtn(){
		return assignToUserRadBtn;
	}
	
	@FindBy(css="#customerInvitingOrg_chosen a")
	private WebElement invitingOrgDDL;
	public WebElement invitingOrgDDL(){
		return invitingOrgDDL;
	}
	
	@FindBy(css="#customerInvitingOrg_chosen input")
	private WebElement invitingOrgSearchTxtBox;
	public WebElement invitingOrgSearchTxtBox(){
		return invitingOrgSearchTxtBox;
	}
	
	@FindBy(css="#customerGroup_chosen a")
	private WebElement customerGrpDDL;
	public WebElement customerGrpDDL(){
		return customerGrpDDL;
	}
	
	@FindBy(css="#customerGroup_chosen input")
	private WebElement customerGrpSearchTxtBox;
	public WebElement customerGrpSearchTxtBox(){
		return customerGrpSearchTxtBox;
	}
	
	@FindBy(css="#customerUserRole_chosen a")
	private WebElement userRoleDDL;
	public WebElement userRoleDDL(){
		return userRoleDDL;
	}
	
	@FindBy(css="#customerUserRole_chosen input")
	private WebElement userRoleSearchTxtBox;
	public WebElement userRoleSearchTxtBox(){
		return userRoleSearchTxtBox;
	}
	
	@FindBy(css="#customerContact_chosen a")
	private WebElement userDDL;
	public WebElement userDDL(){
		return userDDL;
	}
	
	@FindBy(css="#customerContact_chosen input")
	private WebElement userSearchTxtBox;
	public WebElement userSearchTxtBox(){
		return userSearchTxtBox;
	}
	
	@FindBy(css="input[class*='primary']")
	private WebElement reassignBtn;
	public WebElement reassignBtn(){
		return reassignBtn;
	}
	
	//total no. of records displayed in header
	@FindBy(css="span[class='highlight_green']")
	private WebElement totalRecords;
	public WebElement totalRecords(){
		return totalRecords;
	}
	
	//Pagination
	@FindBy(css="ul[class='pagination']")
	private WebElement paginationBox;
	public WebElement paginationBox(){
		return paginationBox;
	}
	
	@FindBy(css="[class*='pagination'] li a[ng-click*='+ 1']")
	private List<WebElement> paginationBtns;
	public List<WebElement> paginationBtns(){
		return paginationBtns;
	}
	
	//Lock icons
	@FindBy(css="#claimTaskApproval span[class*='lock']")
	private WebElement lockIcons;
	public WebElement lockIcons(){
		return lockIcons;
	}	
	
	
	//Search
	@FindBy(css="button[class*='primary']")
	private WebElement basicsearchbtn;
	public WebElement basicsearchbtn(){
		return basicsearchbtn;
	}	
	
	//Dynamic
	
	@FindBy(css="div[class*='sear'] a")
	private WebElement advancedbtn;
	public WebElement advancedbtn(){
		return advancedbtn;
	}
	
	@FindBy(css="div[class*='sear'] #addCriteria")
	private WebElement addCriteria;
	public WebElement addCriteria(){
		return addCriteria;
	}
	
	@FindBy(css="button[class*='primary']")
	private WebElement searchbtn;
	public WebElement searchbtn(){
		return searchbtn;
	}
	
	@FindBy(css="button[class*='flat']:nth-child(2)")
	private WebElement clearbtn;
	public WebElement clearbtn(){
		return clearbtn;
	}
	
	@FindBy(css="button[class*='flat']")
	private WebElement savebtn;
	public WebElement savebtn(){
		return savebtn;
	}
	
	// save query slider Page objects
	@FindBy(id="searchQuery")
	private WebElement saveName;
	public WebElement saveName(){
		return saveName;
	}
	
	@FindBy(id = "accessRights")
	private WebElement accessRightsDrpdwn;

	public WebElement accessRightsDrpdwn() {
		return accessRightsDrpdwn;
	}
	
	@FindBy(css = ".checkbox_image.new_icons")
	private WebElement makedefaultChkbox;

	public WebElement makedefaultChkbox() {
		return makedefaultChkbox;
	}

	@FindBy(css = "slider-body.ng-scope button[type='Submit']")
	private WebElement sliderSaveBtn;

	public WebElement sliderSaveBtn() {
		return makedefaultChkbox;
	}
	//end of save query slider
	
	@FindBy(css="h3[class*='accordian_header']")
	private WebElement SaveAccordin;
	public WebElement SaveAccordin() {
		return SaveAccordin;
	}
	
	@FindBy(css="h3[class*='accordian_close']")
	private List<WebElement> SaveAccordinClose;
	public List<WebElement> SaveAccordinClose() {
		return SaveAccordinClose;
	}
	
	@FindBy(css="li[ng-repeat*='query'] div>a[class='ng-binding']")
	private List<WebElement> SavedQNameList;
	public List<WebElement> SavedQNameList(){
		return SavedQNameList;
	}
	
	@FindBy(css="li[ng-repeat*='query'] div>div")
	private List<WebElement> markDefaultIconList;
	public List<WebElement> markDefaultIconList(){
		return markDefaultIconList;
	}
	
	
	
	@FindBy(css="li[ng-repeat*='query'] div a[id=dLabel]")
	private List<WebElement> SavedQNameAction;
	public List<WebElement> SavedQNameAction(){
		return SavedQNameAction;
	}
	
	@FindBy(xpath="//span[contains(@class,'Default')]/..")
	private List<WebElement> markAsDefault;
	public List<WebElement> markAsDefault(){
		return markAsDefault;
	}
	
	@FindBy(xpath="//span[contains(@class,'edit')]/..")
	private List<WebElement> editQuery;
	public List<WebElement> editQuery(){
		return editQuery;
	}
	
	@FindBy(xpath="//span[contains(@class,'delete')]/..")
	private List<WebElement> deleteQuery;
	public List<WebElement> deleteQuery(){
		return deleteQuery;
	}
	
	@FindBy(xpath="//span[contains(@class,'loadCriteria')]/..")
	private List<WebElement> runQuery;
	public List<WebElement> runQuery(){
		return runQuery;
	}
	
	@FindBy(css="#bannerId span+span")
	private WebElement queryBannerMsg;
	public WebElement queryBannerMsg(){
		return queryBannerMsg;
	}
	//End of Search
	
	
	/**
	 * Method to search a claim and perform an action.
	 * @author girish.n 
	 */
	
	public LinkedHashMap<String, String> actionOnTasksClaims(LinkedHashMap<String, String> dataMap) throws IOException {
		
		String index="";
		dataMap=searchTasksClaim(dataMap);
		
		if(dataMap.containsKey("Index")){
			index=dataMap.get("Index");
		}
		if(!index.equalsIgnoreCase("-1")){	
			Reporter.log("Claim ID is found in Task Claim Page at index:"+index,true);
			selectAction(dataMap);
			dataMap.put("flag","true");
		}
		else{
			Reporter.log("Claim ID is not present",true);
			dataMap.put("flag","false");
		}
		
		return dataMap;
	
	}	
	/**
	 * Method to search claim. Pagination is handled.
	 * 
	 * @param dataMap
	 * @return
	 */
	public LinkedHashMap<String, String> searchTasksClaim(LinkedHashMap<String, String> dataMap) {
		int ind=-1;
		boolean flag=false;
		do{
			dataMap=searchClaim(dataMap);
			if(dataMap.containsKey("Index")){
				ind=Integer.parseInt(dataMap.get("Index"));
			}
			if(ind!=-1)
			{
				break;
			}
			if(paginationBtns.size()>0){
		//		if(paginationBtns.get(paginationBtns.size()-2).getAttribute("href")!=null)
				{
					flag=true;
					lavanteUtils.click(paginationBtns.get(0));
					lavanteUtils.waitforPageload(pageHeader);
				}//else{
				//	flag=false;
				//}
			}
		}while(flag);
		return dataMap;
	}
	
	private LinkedHashMap<String, String> searchClaim(LinkedHashMap<String, String> dataMap) {
		switchTasksClaimView(dataMap);
		basicSearch(dataMap);
		advanceSearch(dataMap);
		int index=-1;
		dataMap.put("Index", String.valueOf(index));
		if(iterateSearchHeaderFindColList("Claim ID").size()>0){
			if (dataMap.containsKey("ClaimId")){
					String data=dataMap.get("ClaimId");
					if (data.equalsIgnoreCase("Any")){
						outr: for(int i=0;i<iterateSearchHeaderFindColList("Division").size();i++){
							String x=iterateSearchHeaderFindColList("Division").get(i).getText();
							x=x.trim();
							if(x.length()>0){
								dataMap.put("Index", String.valueOf(i));
								dataMap.put("ClaimId", iterateSearchHeaderFindColList("Claim ID").get(i).getText().trim());
								break outr;
							}
						}
						return dataMap;
					}else{
						for(int i=0;i<iterateSearchHeaderFindColList("Claim ID").size();i++){
							if(data.equals(iterateSearchHeaderFindColList("Claim ID").get(i).getText().trim())){
								index=i;
								dataMap.put("Index", String.valueOf(index));
								return dataMap;
							}
						}
					}
			}
		}	
		return dataMap;
	}
	
	/**
	 * Basic Search on Claims to Approve
	 * 
	 * @author Piramanayagam.S
	 * @param dataMap
	 */
	public void basicSearch(Map<String, String> dataMap) {
		if(!dataMap.containsKey("Advanced")){
			fillBasicSearchDetails(dataMap);
			formBasicSearchDetails(dataMap);
		}
	}

	private void fillBasicSearchDetails(Map<String, String> dataMap) {
		//Created Dummy Text
		lavanteUtils.fluentwait(basicsearchbtn);
		String y="DUMMY";
		String x="//*[text()='"+y+"']/../following-sibling::div//input";
		
		if(dataMap.containsKey("ClaimId")){
			if(!dataMap.get("ClaimId").equalsIgnoreCase("ANY")){
				String z=x;
				z=z.replace(y, "Claim ID");
				lavanteUtils.driver.findElement(By.xpath(z)).clear();
				lavanteUtils.driver.findElement(By.xpath(z)).sendKeys(dataMap.get("ClaimId"));
			}
		}
		
		if(dataMap.containsKey("SupplierName")){
			if(!dataMap.get("SupplierName").equalsIgnoreCase("ANY")){
				String z=x;
				z=z.replace(y, "Supplier name");
				lavanteUtils.driver.findElement(By.xpath(z)).clear();
				lavanteUtils.driver.findElement(By.xpath(z)).sendKeys(dataMap.get("SupplierName"));
			}
		}
		
	}

	private void formBasicSearchDetails(Map<String, String> dataMap) {
		if(dataMap.containsKey("Search")){
			lavanteUtils.click(basicsearchbtn);
			lavanteUtils.waitForTime(2000);
		}
	}

	private void selectAction(Map<String, String> dataMap){
		
		int index=Integer.parseInt(dataMap.get("Index"));
		
		lavanteUtils.click(iterateSearchHeaderFindColList("Claim Type").get(index));
		lavanteUtils.click(actionBtn);
		//lavanteUtils.waitForTime(2000);
		
		String action = dataMap.get("Action");
		
		if(action.equalsIgnoreCase("EditClaim")){
			//lavanteUtils.fluentwait(editClaimOption);
			lavanteUtils.click(editClaimOption);
			lavanteUtils.waitForTime(3000);
		}
		
		if(action.equalsIgnoreCase("RequestUpdate")){
			lavanteUtils.click(reqUpdateOption);
			lavanteUtils.waitForTime(3000);
			requestUpdateClaim(dataMap);
		}
		
		if(action.equalsIgnoreCase("Reassign")){
			lavanteUtils.click(reassignOption);
			lavanteUtils.waitForTime(3000);;
		}
		
		if(action.equalsIgnoreCase("ProcessClaims")){
			lavanteUtils.click(processClaimOption);
			lavanteUtils.waitForTime(3000);
			lavanteUtils.switchtoFrame(IFrameProcessClaim);
			lavanteUtils.click(processClaimConfirmBtn);
			lavanteUtils.switchtoFrame(null);
			dataMap.put("BannerMsg", processClaimBannerMsg.getText());
		}
		
		
	}
	
	/**
	 * Request Update for a claim
	 * 
	 * @author girish.n
	 */
	public void requestUpdateClaim(Map<String, String> dataMap){
		lavanteUtils.switchtoFrame(frameReqUpdate);
		String data="";
		if(dataMap.containsKey("MandatoryChecks")) {
			lavanteUtils.click(reqUpdateBtn);
			dataMap.put("SubjectErr", subjectErrMsg.getText());
			dataMap.put("MessageErr", messageErrMsg.getText());
		}
		if(dataMap.containsKey("Recipient")){
			data = dataMap.get("Recipient");
			lavanteUtils.waitForTime(1000);
			lavanteUtils.click(recipientDDL);
			lavanteUtils.waitForTime(1000);
			lavanteUtils.switchtoFrame(null);
			lavanteUtils.fluentwait(recipientSearchTxtBox);
			lavanteUtils.typeString(data, recipientSearchTxtBox);
			lavanteUtils.selectValueFrmdropdown("any");
			lavanteUtils.waitForTime(1000);
			lavanteUtils.switchtoFrame(frameReqUpdate);
		}
		
		if(dataMap.containsKey("Subject")){
			data=dataMap.get("Subject");
			lavanteUtils.fluentwait(subTxtBox);
			lavanteUtils.typeinEdit(data, subTxtBox);
			lavanteUtils.waitForTime(1000);
		}

		if(dataMap.containsKey("Message")){
			data=dataMap.get("Message");
			lavanteUtils.fluentwait(msgTxtBox);
			lavanteUtils.typeinEdit(data, msgTxtBox);
			lavanteUtils.waitForTime(1000);
		}
		
		if(dataMap.containsKey("ReqUpdate")){
			lavanteUtils.click(reqUpdateBtn);
			
		}
		
		lavanteUtils.switchtoFrame(null);
		lavanteUtils.fluentwait(bannerMsg);
		dataMap.put("BannerMsg", bannerMsg.getText());
	}
	
	/**
	 * Method to Reassign Claim
	 * @author girish.n
	 */
	public void reassignClaim(LinkedHashMap<String, String> dataMap){
	
		String data = "";
		lavanteUtils.switchtoFrame(frameReassign);
		if(dataMap.containsKey("AssignTo")){
			data=dataMap.get("AssignTo");
			if(data.equalsIgnoreCase("Group")){
				lavanteUtils.fluentwait(assignToGroupRadBtn);
				lavanteUtils.click(assignToGroupRadBtn);
				lavanteUtils.waitForTime(2000);
			}
			if(data.equalsIgnoreCase("Role")){
				lavanteUtils.fluentwait(assignToRoleRadBtn);
				lavanteUtils.click(assignToRoleRadBtn);
				lavanteUtils.waitForTime(2000);
			}
			if(data.equalsIgnoreCase("User")){
				lavanteUtils.fluentwait(assignToUserRadBtn);
				lavanteUtils.click(assignToUserRadBtn);
				lavanteUtils.waitForTime(2000);
			}	
		}
		
		if(dataMap.containsKey("InvitingOrganization")){
			data=dataMap.get("InvitingOrganization");
			
			if(data.equalsIgnoreCase("Any")||data.equalsIgnoreCase("All")){
				data="All";
			}
			
			lavanteUtils.click(invitingOrgDDL);
			lavanteUtils.switchtoFrame(null);
			lavanteUtils.fluentwait(invitingOrgSearchTxtBox);
			lavanteUtils.typeString(data, invitingOrgSearchTxtBox);
			lavanteUtils.selectvalueFrmDpdn(data);
			lavanteUtils.switchtoFrame(frameReassign);
			
		}
		
		if(dataMap.containsKey("Role")){
			data=dataMap.get("Role");
			
			lavanteUtils.click(userRoleDDL);
			lavanteUtils.waitForTime(2000);
			lavanteUtils.switchtoFrame(null);
			lavanteUtils.typeString(data, userRoleSearchTxtBox);
			lavanteUtils.selectvalueFrmDpdn(data);
			lavanteUtils.switchtoFrame(frameReassign);
		}
		
		if(dataMap.containsKey("User")){
			data=dataMap.get("User");
			
			lavanteUtils.click(userDDL);
			lavanteUtils.switchtoFrame(null);
			lavanteUtils.typeString(data, userSearchTxtBox);
			lavanteUtils.selectvalueFrmDpdn("Any");
			lavanteUtils.switchtoFrame(frameReassign);
		}
		
		if(dataMap.containsKey("Reassign")){
			lavanteUtils.click(reassignBtn);
			lavanteUtils.waitForTime(5000);
		}
		
	}
	
	/**
	 * Method to switch view "Claims" and "Claims and GL Codes"
	 * 
	 * By default Claims View if , needed for Claim and GL code then use this method
	 * @author Girish.N
	 * 
	 */
	public void switchTasksClaimView(Map<String, String> dataMap){
		lavanteUtils.switchtoFrame(null);
		//All Task
		String x="My tasks";
		if (dataMap.containsKey("TaskView")){
			x=dataMap.get("TaskView");
			if(x.contains("My")){
				x="My tasks";
			}
		}
	//	lavanteUtils.selectbyvalue(x,tasksViewDDL);
	//	
		
		String defaultValue=tasksViewDDL.getText();
		if(!defaultValue.contains(x)){
			dataMap.put("defaultValue", defaultValue);
			
			lavanteUtils.click(tasksViewDDL);

			x=lavanteUtils.selectvalueFrmDpdnXpathAttribute(x,"//drop-down//li//input");
			dataMap.put("selectedValue", x);
			lavanteUtils.waitforPageload(pageHeader);
		}
		
		if (dataMap.containsKey("View")){
			String xx=dataMap.get("View");
			/*	
				if(xx.contains("Claims and GL codes")){
					xx=""+164002;
				}else{
					xx=""+123;
				}
				lavanteUtils.selectbyvalue(xx,tasksClaimsViewDDL);
				lavanteUtils.waitforPageload(pageHeader);*/
				
				
				defaultValue=LayoutDrpdn.getText();
				defaultValue=defaultValue.replace("Layout: ", "");
				if(!defaultValue.contains(xx)){
					dataMap.put("defaultValue", defaultValue);
					
					lavanteUtils.click(LayoutDrpdn);

					xx=lavanteUtils.selectvalueFrmDpdnXpathAttribute(xx,"//drop-down//li//input");
					dataMap.put("selectedValue", xx);
				}
				
				
				
		}
		
	}
	
	public List<WebElement> getGLDataList(LinkedHashMap<String, String> dataMap) {
		List<WebElement> glcode = null;
		if(dataMap.containsKey("ClaimId")) {
			String claimId = dataMap.get("ClaimId");
			if(dataMap.containsKey("GLData")) {
				if(dataMap.get("GLData").contains("GLCodeList")) {
					String ele = "tr[data-elem-id='"+claimId+"']>td:nth-child(3)";
					glcode = getGLCodeList(dataMap,ele);
				} else if(dataMap.get("GLData").contains("GLCodeAmtList")) {
					String ele = "tr[data-elem-id='"+claimId+"']>td:nth-child(4)";
					glcode = getGLCodeList(dataMap,ele);
				}
			}
		}
		return glcode;
	}

	public LinkedHashMap<String, String> getGLDatas(LinkedHashMap<String, String> dataMap) {
		LinkedHashMap<String, String>  glcode = new LinkedHashMap<>();
		if(dataMap.containsKey("ClaimId")) {
			String claimId = dataMap.get("ClaimId");
				if(dataMap.get("GLData").contains("GLCodeList")) {
					String u=""+1;
					if(dataMap.containsKey("Index")){
						String x=""+dataMap.get("Index");
						//Index increment
						u=""+Integer.parseInt(x)+1;
						
					}
					String ele = "tbody tr:nth-child("+u+") td:nth-child(1) span:nth-child(1)";
					lavanteUtils.click(lavanteUtils.driver.findElement(By.cssSelector(ele)));
					List<WebElement> glcodse=getGLCodeList(dataMap,ele);
					 //ele = "tr[data-elem-id='"+claimId+"']>td:nth-child(4)";
					List<WebElement> amntlist= iterateSearchHeaderFindColList("Amount");
					for(int i=0;i<glcodse.size();i++){
						String amt = amntlist.get(i).getText();
						if(amt.contains(",")) {
							String[] newStr = amt.split(",");
							amt="";
							for(int k=0; k<newStr.length; k++) {
								amt = amt+newStr[k];
							}
						}
						if(!(glcode.containsKey(glcodse.get(i).getText()))){
							glcode.put(glcodse.get(i).getText(),amt);
						}else{
							String x=glcode.get(glcodse.get(i).getText());
							x=x+"#";
							glcode.put(glcodse.get(i).getText(),x+amt);
						}
					}
			}
		}
		return glcode;
	}
	
	public List<WebElement> getGLCodeList(LinkedHashMap<String, String> dataMap, String element) {
		List<WebElement> glcode = null;
		if(iterateSearchHeaderFindColList("Claim ID").size()>0) {
		//	if(dataMap.containsKey("ClaimId")) {
			//	String claimId = dataMap.get("ClaimId");
				for(int i=0;i<iterateSearchHeaderFindColList("GL Code").size();i++) {
				//	if(claimId.equals(iterateSearchHeaderFindColList("Claim ID").get(i).getText())) {
						//glcode = lavanteUtils.driver.findElements(By.cssSelector(element));
						glcode=iterateSearchHeaderFindColList("GL Code");
					}
			//	}
			}
		
		return glcode;		
	}

	/**
	 * Methods to check whether the lock icon is present or not in Task -> Claim page
	 * @author Girish.N
	 * @param dataMap
	 * @param element
	 * @return
	 */
	public LinkedHashMap<String, String> isLockExists(LinkedHashMap<String, String> dataMap) {
		
		String index= "";
		if (dataMap.containsKey("Index")){
			index=String.valueOf(Integer.parseInt(dataMap.get("Index")) +1) ;
		}
		
		String lockIconXPath = "//tbody//tr[1]//td[1]/span[contains(@class,'icon_lock')]";		
		
		if (index.length()>0){
			try{
				WebElement lockIcon = lavanteUtils.driver.findElement(By.xpath(lockIconXPath));
				dataMap.put("LockExists", "True");
				String lockToolTip = lockIcon.getAttribute("title").trim();
				Reporter.log("Lock Message: " + lockToolTip, true);
				dataMap.put("LockMessage", lockToolTip);
			}catch(Exception e){
				dataMap.put("LockExists", "False");
			}
		}
		
		return dataMap;
	}
	
	/**
	 * Method to check whether the check box to edit the claim is present or not in Task -> Claim page.
	 * @author Girish.N
	 * @param dataMap
	 * @param element
	 * @return
	 */
	public LinkedHashMap<String, String> isCheckBoxExists(LinkedHashMap<String, String> dataMap) {
		
		String index= "";
		if (dataMap.containsKey("Index")){
			index=String.valueOf(Integer.parseInt(dataMap.get("Index")) +1) ;
		}
	
		String chkBoxXPath = "//table[@id='claimTaskApproval']//tbody//tr//td[1][" + index + "]/label[contains(@class,'box-image')]";
		chkBoxXPath="//table-grid//tr[" + index + "]/td[1]/label[contains(@class,'box-image')]";
			
		if (index.length()>0){
			try{
				lavanteUtils.driver.findElement(By.xpath(chkBoxXPath));
				dataMap.put("CheckBoxExists", "True");
				
			}catch(Exception e){
				dataMap.put("CheckBoxExists", "False");
			}
		}
		
		return dataMap;		
	}
	
	public List<WebElement> iterateSearchHeaderFindColList(String col) {
		List<WebElement> s = null;
		int j = ColIdentify(col);
		String x = "tbody td:nth-child(" + j + ")";
		s = lavanteUtils.driver.findElements(By.cssSelector(x));
		System.out.println("Iterate col locator:" + x + ",Size:" + s.size());
		if (col.contains("Claim ID") ) {
			x = "tbody td:nth-child(" + j + ") a";
			System.out.println("Iterate for name/contact:" + x);
			s = lavanteUtils.driver.findElements(By.cssSelector(x));
		}
		System.out.println("Iterate Search Col:" + col + ":" + s.size());
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
					System.out.println(col + ",Col Found at " + ki);
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

	
	//Dynamic Search
	/**
	 * Advance Search on Claims to Approve
	 * 
	 * @author Piramanayagam.S
	 * @param dataMap
	 */
	public void advanceSearch(LinkedHashMap<String, String> dataMap) {
		lavanteUtils.fluentwait(searchbtn);
		if(dataMap.containsKey("Advanced")){
			if(!(lavanteUtils.verifyElementDisplayed("Add Criteria", addCriteria))) {
				lavanteUtils.click(advancedbtn);
			}
			if(dataMap.containsKey("Clear")){
				lavanteUtils.click(clearbtn);
				lavanteUtils.fluentwait(searchbtn);
			}
			convert(dataMap);
			fillAdvanceSearchDetails(dataMap);
			fillCriteria(dataMap);
			formAdvanceSearch(dataMap);
		}
	}

	private void fillCriteria(LinkedHashMap<String, String> dataMap) {
		lavanteUtils.fluentwait(addCriteria);
		boolean dropd=true;
		String methodKey="AutoMAtion";
		String input="//*[contains(text(),'"+methodKey+"')]/../following-sibling::div//input";
		String dropdown="//*[contains(text(),'"+methodKey+"')]/../..//select";
		String multiselect1="//*[contains(text(),'"+methodKey+"')]/../..//div[2][@ng-class]";
		String multiselect="//*[contains(text(),'"+methodKey+"')]/../..//ul//li//div[2]";
		String inptmod="";
		String dpdnmod="";
		String multimod="";
		String multimod1="";
	    String x=dataMap.get("SearchFields");
		String[] y=new String[1];
		
		if(x.contains("#")){
			y=x.split("#");
		}else{
			y[0]=x;
		}
		
		for(int i=0;i<y.length;i++ ){
			String sefkey=y[i];
			dropd=true;
			
			if(dataMap.containsKey(sefkey)){
				String value=dataMap.get(sefkey);
				
				if(sefkey.contains("Invoice Type")||sefkey.contains("Claim Type")){
					dropd=false;
				}
				
				String[] valueSplit=new String[2];
				valueSplit[0]="";
				if(value.contains("#")){
					String[] ads=value.split("#");
					valueSplit=ads;
				}else{
					valueSplit[0]="Equals";
					if(value.equalsIgnoreCase("Is Empty")){
						valueSplit[0]="Is Empty";
					}else	if(value.equalsIgnoreCase("ANY")){
						valueSplit[0]="Is Not Empty";
					}else{
						valueSplit[1]=value;
					}
				}
						
				if(valueSplit[0].length()>0){
					for(int ads=0;ads<valueSplit.length;ads++){
						if(ads==0){
							dpdnmod=dropdown;
							dpdnmod=dpdnmod.replace(methodKey, sefkey);
							lavanteUtils.selectbyvisibiletxt(valueSplit[0], lavanteUtils.driver.findElement(By.xpath(dpdnmod)));
						}else if(dropd==true && ads==1 && valueSplit[ads]!=null){
							inptmod=input;
							inptmod=inptmod.replace(methodKey, sefkey);
							lavanteUtils.driver.findElement(By.xpath(inptmod)).clear();
							lavanteUtils.typeinEdit(valueSplit[ads],lavanteUtils.driver.findElement(By.xpath(inptmod)));
						}if(dropd==false && ads==1 && valueSplit[ads]!=null){
							multimod=multiselect;
							multimod=multimod.replace(methodKey, sefkey);
							multimod1=multiselect1;
							multimod1=multiselect1.replace(methodKey, sefkey);
							System.out.println(multimod1);
							lavanteUtils.driver.findElement(By.xpath(multimod1)).click();
							lavanteUtils.selectvalueFrmDpdnXpath(valueSplit[ads],multimod);
						}
					}
				}
			}
			
		}
			 
	}



	private void convert(LinkedHashMap<String, String> dataMap) {
		LinkedHashMap<String, String> dataMap1=new LinkedHashMap<>();
		dataMap1.putAll(dataMap);
		 for (String keys: dataMap.keySet()) { 
			 //UsualKey   //Change acc to UI
			 dataMap1= convert1("ClaimId","Claim ID",keys,dataMap,dataMap1);
			 dataMap1=  convert1("ClaimAmount","Claim amount",keys,dataMap,dataMap1);
			 dataMap1=  convert1("ClaimType","Claim type",keys,dataMap,dataMap1);
		}
		 dataMap.putAll(dataMap1);
	}

	private LinkedHashMap<String, String> convert1(String curvalue, String futValue,String keys,LinkedHashMap<String, String> dataMap,LinkedHashMap<String, String> dataMap1) {
		 if(keys.equalsIgnoreCase(curvalue)){
			 dataMap1.put(futValue, dataMap.get(keys));
			 dataMap1=searchfield(dataMap,curvalue,futValue,dataMap1);
		 }
		 
		 return dataMap1;
		
	}

	private LinkedHashMap<String, String> searchfield(LinkedHashMap<String, String> dataMap,String curvalue, String futValue,LinkedHashMap<String, String> dataMap1) {
		 if(dataMap.containsKey("SearchFields")){
			 String x=dataMap1.get("SearchFields");
			 x=x.replace(curvalue, futValue);
			 dataMap1.put("SearchFields", x);
		 }
		 
		 return dataMap1;
	}

	private void fillAdvanceSearchDetails(LinkedHashMap<String, String> dataMap) {
		if(dataMap.containsKey("SearchFields")){
			String x=dataMap.get("SearchFields");
			String[] y=new String[1];
			
			if(x.contains("#")){
				y=x.split("#");
			}else{
				y[0]=x;
			}
			
			for(int i=0;i<y.length;i++ ){
				String tyop=y[i];
				lavanteUtils.fluentwait(addCriteria);
				addCriteria.clear();
				lavanteUtils.typeinEdit(tyop, addCriteria);
				lavanteUtils.waitForTime(4000);
				lavanteUtils.selectvalueFrmDpdn(tyop,"ul[id*='ui-id'] li");
			}
		}
	}

	private void formAdvanceSearch(LinkedHashMap<String, String> dataMap) {
		if(dataMap.containsKey("Search")){
			lavanteUtils.click(searchbtn);
		}
		if(dataMap.containsKey("Save")){
			lavanteUtils.click(savebtn);
			SaveSearch(dataMap);
			SavedQueryAction(dataMap);
		}
	}

	

	private void SaveSearch(LinkedHashMap<String, String> dataMap) {
		lavanteUtils.fluentwait(savebtn);
		if(dataMap.containsKey("SaveSearchName")){
			String x=dataMap.get("SaveSearchName");
			if(x.equalsIgnoreCase("ANY")){
				x="Auto"+lavanteUtils.randomnum();
				dataMap.put("SaveSearchName", x);
			}
			saveName.clear();
			lavanteUtils.typeinEdit(x, saveName);
		}
		if(dataMap.containsKey("AccessRights")) {
			String x = dataMap.get("AccessRights");
			lavanteUtils.selectbyvisibiletxt(x, accessRightsDrpdwn);			
		}
		if(dataMap.containsKey("MarkDefaultChkBox")) {
			lavanteUtils.click(makedefaultChkbox);
		}
		if(dataMap.containsKey("SaveQuery")){
			lavanteUtils.click(sliderSaveBtn);
			lavanteUtils.waitForTime(5000);
			if(dataMap.containsKey("SearchSaveQuery")) {
				lavanteUtils.click(searchbtn);
			}
		}
	}
	
	public void SavedQueryAction(LinkedHashMap<String, String> dataMap) {
		String banner = "";
		if(dataMap.containsKey("QueryAction")){
			lavanteUtils.fluentwait(SaveAccordin);
			
			if(SaveAccordinClose.size()>0) {
				lavanteUtils.click(SaveAccordinClose.get(0));
			}
			
			String x=dataMap.get("SaveSearchName");
			if(x.length()>0){
				for(int i=0;i<SavedQNameList.size();i++){
					String act=SavedQNameList.get(i).getText().trim();
					if(act.equalsIgnoreCase(x)){
						lavanteUtils.click(SavedQNameAction.get(i));
						
						if(dataMap.containsKey("MarkAsDefault")){
							lavanteUtils.click(markAsDefault.get(i));
							banner = queryBannerMsg.getText();
							break;
						}
						if(dataMap.containsKey("EditQuery")){
							lavanteUtils.click(editQuery.get(i));
							convert(dataMap);
							fillCriteria(dataMap);
							//SaveSearch(dataMap);
							lavanteUtils.click(sliderSaveBtn);
							banner = queryBannerMsg.getText();
							lavanteUtils.fluentwait(savebtn);
							//After editing,Query is not executing hence written the below,can be removed if the query executes in the app
							lavanteUtils.click(SavedQNameList.get(i));
							lavanteUtils.click(searchbtn);
							break;
						}
						if(dataMap.containsKey("DeleteQuery")){
							lavanteUtils.click(deleteQuery.get(i));
							banner = queryBannerMsg.getText();
							break;
						}
						if(dataMap.containsKey("RunQuery")){
							lavanteUtils.click(runQuery.get(i));
							break;
						}
						
					}
				}
				
				dataMap.put("BannerMsg", banner);
			
			}
			
			
		}
		
	}
	
	//End of Dynamic Search
	
	
}
