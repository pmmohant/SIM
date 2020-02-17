/**
 * 
 */
package com.lavante.sim.customer.pageobjects.Transactions.ContractManagement;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.lavante.sim.Common.Util.LavanteUtils;

/**
 * @author Piramanayagam.S
 *
 */
public class CMAdvancedSearch {
	
	public WebDriver driver;
	public LavanteUtils lavanteUtils=new LavanteUtils();
	
	public CMAdvancedSearch(WebDriver driver){
		lavanteUtils.driver=driver;
		this.driver=driver;
	}
	
	@FindBy(how=How.CSS,using="iframe[src*='Advance']")
	private WebElement IFRAMEadvSearch;	
	public WebElement  IFRAMEadvSearch(){
		return IFRAMEadvSearch;
	}
	

	@FindBy(how=How.CSS,using="#dialog input[type*='submit'][title*='Search']")
	private WebElement searchbtn;	
	public WebElement  searchbtn(){
		return searchbtn;
	}
	

	
	@FindBy(how=How.CSS,using="[id*='clientName'] a")
	private WebElement msaclientdpdn;	
	public WebElement  msaclientdpdn(){
		return msaclientdpdn;
	}

	@FindBy(how=How.CSS,using="[id*='supplierName'] a")
	private WebElement MSASupNamepdn;	
	public WebElement  MSASupNamepdn(){
		return MSASupNamepdn;
	}
	@FindBy(how=How.ID,using="supplierName_field")
	private WebElement MSASuppnametxt;	
	public WebElement  MSASuppnametxt(){
		return MSASuppnametxt;
	}
	
	@FindBy(how=How.CSS,using="[id*='MSANum'] a")
	private WebElement MSANumdpdn;	
	public WebElement  MSANumdpdn(){
		return MSANumdpdn;
	}
	@FindBy(how=How.CSS,using="input[name*='MSANumber']")
	private WebElement MSANUMtxt;	
	public WebElement  MSANUMtxt(){
		return MSANUMtxt;
	}
	
	@FindBy(how=How.CSS,using="[id*='MSAType'] a")
	private WebElement MSATYPEdpdn;	
	public WebElement  MSATYPEdpdn(){
		return MSATYPEdpdn;
	}
	
	@FindBy(how=How.CSS,using="div[id^='MSAStatus']")
	private WebElement MSAStatusdpdn;	
	public WebElement  MSAStatusdpdn(){
		return MSATYPEdpdn;
	}
	
	//SOW
	@FindBy(how=How.CSS,using="[id*='SOWNum'] a")
	private WebElement SOWNumdpdn;	
	public WebElement  SOWNumdpdn(){
		return SOWNumdpdn;
	}
	@FindBy(how=How.CSS,using="input[name*='SOWNumbers']")
	private WebElement SOWNUMtxt;	
	public WebElement  SOWNUMtxt(){
		return SOWNUMtxt;
	}
	
	@FindBy(how=How.CSS,using="[id*='notes'] a")
	private WebElement SOWnotesdpdn;	
	public WebElement  SOWnotesdpdn(){
		return SOWnotesdpdn;
	}
	@FindBy(how=How.CSS,using="input[name*='notes']")
	private WebElement SOWnotestxt;	
	public WebElement  SOWnotestxt(){
		return SOWnotestxt;
	}
	
	@FindBy(how=How.CSS,using="[id*='SOWDescription'] a")
	private WebElement SOWDescdpdn;	
	public WebElement  SOWDescdpdn(){
		return SOWDescdpdn;
	}
	@FindBy(how=How.CSS,using="input[name*='SOWDescription']")
	private WebElement SOWDesctxt;	
	public WebElement  SOWDesctxt(){
		return SOWDesctxt;
	}
	
	@FindBy(how=How.CSS,using="[id*='internalContact'] a")
	private WebElement SOWInterpdn;	
	public WebElement  SOWInterpdn(){
		return SOWInterpdn;
	}
	@FindBy(how=How.CSS,using="input[name*='InternalContact']")
	private WebElement SOWIntertxt;	
	public WebElement  SOWIntertxt(){
		return SOWIntertxt;
	}
	
	@FindBy(how=How.CSS,using="[id*='IsCreditUsedForVendorPayments'] a")
	private WebElement SOWCreditCard;	
	public WebElement  SOWCreditCard(){
		return SOWCreditCard;
	}
	
	
	
	//Del
	
	@FindBy(how=How.CSS,using="[id*='deliverable_'] a")
	private WebElement DELDeldpdn;	
	public WebElement  DELDeldpdn(){
		return DELDeldpdn;
	}
	
	@FindBy(how=How.CSS,using="input[name*='deliverable']")
	private WebElement DELdeltxt;	
	public WebElement  DELdeltxt(){
		return DELdeltxt;
	}
	
	@FindBy(how=How.CSS,using="[id*='deliverableLocation'] a")
	private WebElement DELDellocationdpdn;	
	public WebElement  DELDellocationdpdn(){
		return DELDellocationdpdn;
	}
	
	@FindBy(how=How.CSS,using="[id*='itemType'] a")
	private WebElement DELitemTypedpdn;	
	public WebElement  DELitemTypedpdn(){
		return DELitemTypedpdn;
	}
	
	@FindBy(how=How.CSS,using="[id*='chargeNumber'] a")
	private WebElement DELAccnumdpdn;	
	public WebElement  DELAccnumdpdn(){
		return DELAccnumdpdn;
	}
	

	@FindBy(how=How.CSS,using="input[name*='chargeNumber']")
	private WebElement DELAccnumtxt;	
	public WebElement  DELAccnumtxt(){
		return DELAccnumtxt;
	}
	
	@FindBy(how=How.CSS,using="[id*='ClientBudgetCode'] a")
	private WebElement DELBudgtCodedpdn;	
	public WebElement  DELBudgtCodedpdn(){
		return DELBudgtCodedpdn;
	}
	

	@FindBy(how=How.CSS,using="input[name*='ClientBudgetCode']")
	private WebElement DELbudgtcodetxt;	
	public WebElement  DELbudgtcodetxt(){
		return DELbudgtcodetxt;
	}
	
	@FindBy(how=How.CSS,using="[id*='ClientOrgCode'] a")
	private WebElement DELOrgCodedpdn;	
	public WebElement  DELOrgCodedpdn(){
		return DELOrgCodedpdn;
	}
	

	@FindBy(how=How.CSS,using="input[name*='ClientOrgCode']")
	private WebElement DELOrgcodetxt;	
	public WebElement  DELOrgcodetxt(){
		return DELOrgcodetxt;
	}
	

	@FindBy(how=How.CSS,using="[id*='ExpenseNotPassedToClient'] a")
	private WebElement DELexptoClientdpdn;	
	public WebElement  DELexptoClientdpdn(){
		return DELexptoClientdpdn;
	}

	@FindBy(how=How.ID,using="save")
	private WebElement buildSaveQuery;	
	public WebElement  buildSaveQuery(){
		return buildSaveQuery;
	}
	
	@FindBy(how=How.CSS,using="iframe[src*='Saved']")
	private WebElement IFRAMESaveQry;	
	public WebElement  IFRAMESaveQry(){
		return IFRAMESaveQry;
	}
	
	
	@FindBy(how=How.ID,using="specify_query")
	private WebElement SaveQryName;	
	public WebElement  SaveQryName(){
		return SaveQryName;
	}
	
	@FindBy(how=How.ID,using="isShareWithAll")
	private WebElement publicqry;	
	public WebElement  publicqry(){
		return publicqry;
	}
	
	
	@FindBy(how=How.ID,using="private_query")
	private WebElement prvteqry;	
	public WebElement  prvteqry(){
		return prvteqry;
	}
	

	
	@FindBy(how=How.CSS,using="#adv_search [type='submit']")
	private WebElement SAVEsaveQrybtn;	
	public WebElement  SAVEsaveQrybtn(){
		return SAVEsaveQrybtn;
	}
	
	@FindBy(how=How.CSS,using="#adv_search button[class*='cancel']")
	private WebElement SAVEcancelQrybtn;	
	public WebElement  SAVEcancelQrybtn(){
		return SAVEcancelQrybtn;
	}
	
	
	
	@FindBy(how=How.CSS,using="button[class*='clear']")
	private WebElement clearqrybtn;	
	public WebElement  clearqrybtn(){
		return clearqrybtn;
	}
	
	@FindBy(how=How.CSS,using="#advance_search [title*='Save']")
	private WebElement AdvSaveQry;	
	public WebElement  AdvSaveQry(){
		return AdvSaveQry;
	}
	
	@FindBy(how=How.CSS,using="#public_queries a[title*='Edit']")
	private List<WebElement> ListSavedPublicEdit;	
	public List<WebElement>  ListSavedPublicEdit(){
		return ListSavedPublicEdit;
	}
	
	@FindBy(how=How.CSS,using="#private_queries a[title*='Edit']")
	private List<WebElement> ListSavedPrvtEdit;	
	public List<WebElement>  ListSavedPrvtEdit(){
		return ListSavedPrvtEdit;
	}
	

	@FindBy(how=How.CSS,using="#public_queries a[href*='delete']")
	private List<WebElement> ListSavedPublicDel;	
	public List<WebElement>  ListSavedPublicDel(){
		return ListSavedPublicDel;
	}
	
	@FindBy(how=How.CSS,using="#private_queries a[href*='delete']")
	private List<WebElement> ListSavedPrvtDel;	
	public List<WebElement>  ListSavedPrvtDel(){
		return ListSavedPrvtDel;
	}
	
	@FindBy(how=How.CSS,using="#public_queries a[class*='run']")
	private List<WebElement> ListSavedPublicRUN;	
	public List<WebElement>  ListSavedPublicRUN(){
		return ListSavedPublicRUN;
	}
	
	@FindBy(how=How.CSS,using="#private_queries a[class*='run']")
	private List<WebElement> ListSavedPrvtRUN;	
	public List<WebElement>  ListSavedPrvtRUN(){
		return ListSavedPrvtRUN;
	}
	
	//Reusable MEthods
	public void buildquery(LinkedHashMap<String, String> dataMap) throws IOException {
		lavanteUtils.waitForTime(4000);
		lavanteUtils.switchtoFrame(IFRAMEadvSearch());
		
		if(dataMap.containsKey("ClearQuery")){
			lavanteUtils.click(clearqrybtn());
		}
		
		buildingQuery(dataMap);
		formAction(dataMap);
	}

	
	

	private void buildingQuery(LinkedHashMap<String, String> dataMap) throws IOException {
		
		lavanteUtils.switchtoFrame(IFRAMEadvSearch());
		lavanteUtils.fluentwait(msaclientdpdn());
		
		if(dataMap.containsKey("msaclient"))
		{
			lavanteUtils.click(msaclientdpdn());
			lavanteUtils.selectvalueFrmDpdn(dataMap.get("msaclient"));
			lavanteUtils.switchtoFrame(IFRAMEadvSearch());
		}

		if(dataMap.containsKey("msasuppliername"))
		{
			lavanteUtils.click(MSASupNamepdn());
			lavanteUtils.selectvalueFrmDpdn(dataMap.get("DPTYPESUPPMSA"));
			lavanteUtils.switchtoFrame(IFRAMEadvSearch());
			if(!dataMap.get("DPTYPESUPPMSA").contains("Is")){
				lavanteUtils.typeinEdit(dataMap.get("msasuppliername"),MSASuppnametxt());
			}
		}

		if(dataMap.containsKey("MSATYPE"))
		{
			lavanteUtils.click(MSATYPEdpdn());
			lavanteUtils.selectvalueFrmDpdn(dataMap.get("MSATYPE"));
			lavanteUtils.switchtoFrame(IFRAMEadvSearch());
		}
		
		if(dataMap.containsKey("MSANum"))
		{
			lavanteUtils.click(MSANumdpdn());
			lavanteUtils.selectvalueFrmDpdn(dataMap.get("TypeMSANum"));
			lavanteUtils.switchtoFrame(IFRAMEadvSearch());
			if(!dataMap.get("TypeMSANum").contains("Is")){
				lavanteUtils.typeinEdit(dataMap.get("MSANum"),MSANUMtxt());
			}
		}
		if(dataMap.containsKey("MSAstatus"))
		{
			String data=dataMap.get("MSAstatus");
			if(data.contains("#"))
			{
				String[] d=data.split("#");
				for(int i=0;i<d.length;i++)
				{
					lavanteUtils.click(driver.findElement(By.cssSelector("[id*='MSAStatus'] input")));
					lavanteUtils.selectvalueFrmDpdn(d[i]);
					lavanteUtils.switchtoFrame(IFRAMEadvSearch());
				}
			} else{
				lavanteUtils.click(driver.findElement(By.cssSelector("[id*='MSAStatus'] input")));
				lavanteUtils.selectvalueFrmDpdn(data);
				lavanteUtils.switchtoFrame(IFRAMEadvSearch());
			}
			
			
		}
		//SOW
		if(dataMap.containsKey("SOWNumber"))
		{ 
			lavanteUtils.click(SOWNumdpdn());
			lavanteUtils.selectvalueFrmDpdn(dataMap.get("TypeSOWNumber"));
			lavanteUtils.switchtoFrame(IFRAMEadvSearch());
			if(!dataMap.get("TypeSOWNumber").contains("Is")){
				lavanteUtils.typeinEdit(dataMap.get("SOWNumber"),SOWNUMtxt());
			}
		}
		if(dataMap.containsKey("SOWNotes"))
		{
			lavanteUtils.click(SOWnotesdpdn());
			lavanteUtils.selectvalueFrmDpdn(dataMap.get("TypeSOWNotes"));
			lavanteUtils.switchtoFrame(IFRAMEadvSearch());
			if(!dataMap.get("TypeSOWNotes").contains("Is")){
				lavanteUtils.typeinEdit(dataMap.get("SOWNotes"),SOWnotestxt());
			}
		}
		if(dataMap.containsKey("SOWStatus")){
			String data=dataMap.get("SOWStatus");
			if(data.contains("#"))
			{
				String[] d=data.split("#");
				for(int i=0;i<d.length;i++)
				{
					lavanteUtils.click(driver.findElement(By.cssSelector("[id*='SOWStatus'] input")));
					lavanteUtils.selectvalueFrmDpdn(d[i]);
					lavanteUtils.switchtoFrame(IFRAMEadvSearch());
				}
			} else{
				lavanteUtils.click(driver.findElement(By.cssSelector("[id*='SOWStatus'] input")));
				lavanteUtils.selectvalueFrmDpdn(data);
				lavanteUtils.switchtoFrame(IFRAMEadvSearch());
				//	lu.selectbyvisibiletxt(data,driver.findElement(By.id("SOWStatus")));
			}
		}
		if(dataMap.containsKey("SOWDescription"))
		{
			lavanteUtils.click(SOWDescdpdn());
			lavanteUtils.selectvalueFrmDpdn(dataMap.get("TypeSOWDescription"));
			lavanteUtils.switchtoFrame(IFRAMEadvSearch());
			if(!dataMap.get("TypeSOWDescription").contains("Is")){
				lavanteUtils.typeinEdit(dataMap.get("SOWDescription"),SOWDesctxt());
			}
		}
		if(dataMap.containsKey("SOWInternalContact"))
		{
			lavanteUtils.click(SOWInterpdn());
			lavanteUtils.selectvalueFrmDpdn(dataMap.get("TYpeSOWInternalContact"));
			lavanteUtils.switchtoFrame(IFRAMEadvSearch());
			if(!dataMap.get("TYpeSOWInternalContact").contains("Is")){
				lavanteUtils.typeinEdit(dataMap.get("SOWInternalContact"),SOWIntertxt());
			}
		}
		if(dataMap.containsKey("SOWPaymentStatus")){
			String data=dataMap.get("SOWPaymentStatus");
			if(data.contains("#"))
			{
				String[] d=data.split("#");
				for(int i=0;i<d.length;i++)
				{
					lavanteUtils.click(driver.findElement(By.cssSelector("[id*='PaymentTypeId'] input")));
					lavanteUtils.selectvalueFrmDpdn(d[i]);
					lavanteUtils.switchtoFrame(IFRAMEadvSearch());
				//	lu.selectbyvisibiletxt(d[i],driver.findElement(By.id("PaymentTypeId")));
				}
			} else{
				lavanteUtils.click(driver.findElement(By.cssSelector("[id*='PaymentTypeId'] input")));
				lavanteUtils.selectvalueFrmDpdn(data);
				lavanteUtils.switchtoFrame(IFRAMEadvSearch());
			}
		}/*if(dataMap.containsKey("SOWUpfront")){
			
			String id=CommonUtils.getCustomIDQUERY("UP", "2");
			String xp="[id*='"+id+"'] a";
			driver.findElement(By.cssSelector(xp)).click();
			CommonUtils.waitForTime(2000);
			lu.switchtoFrame(null);
			lu.selectvalueFrmDpdn(dataMap.get("SOWUpfront"));
			lu.switchtoFrame(IFRAMEadvSearch());
		}*/if(dataMap.containsKey("SOWCreditCard")){
			
			lavanteUtils.click(SOWCreditCard());
			lavanteUtils.selectvalueFrmDpdn(dataMap.get("SOWCreditCard"));
			lavanteUtils.switchtoFrame(IFRAMEadvSearch());
		}
		//Del
		if(dataMap.containsKey("DELdeliverable"))
		{
			lavanteUtils.click(DELDeldpdn());
			lavanteUtils.selectvalueFrmDpdn(dataMap.get("TypeDel"));
			lavanteUtils.switchtoFrame(IFRAMEadvSearch());
		
			if(!dataMap.get("TypeDel").contains("Is")){
				lavanteUtils.typeinEdit(dataMap.get("DELdeliverable"),DELdeltxt());
			}
		}
		if(dataMap.containsKey("DELdeliverablelocation"))
		{
			lavanteUtils.click(DELDellocationdpdn());
			lavanteUtils.selectvalueFrmDpdn(dataMap.get("DELdeliverablelocation"));
			lavanteUtils.switchtoFrame(IFRAMEadvSearch());
		}if(dataMap.containsKey("DELitemtype"))
		{
			lavanteUtils.click(DELitemTypedpdn());
			lavanteUtils.selectvalueFrmDpdn(dataMap.get("DELitemtype"));
			lavanteUtils.switchtoFrame(IFRAMEadvSearch());
		}
		if(dataMap.containsKey("DELaccnumber"))
		{
			lavanteUtils.click(DELAccnumdpdn());
			lavanteUtils.selectvalueFrmDpdn(dataMap.get("TypeAcc"));
			lavanteUtils.switchtoFrame(IFRAMEadvSearch());
		
			if(!dataMap.get("TypeAcc").contains("Is")){
				lavanteUtils.typeinEdit(dataMap.get("DELaccnumber"),DELAccnumtxt());
			}
		}if(dataMap.containsKey("DELPaymentStatus")){
			String data=dataMap.get("DELPaymentStatus");
			if(data.contains("#"))
			{
				String[] d=data.split("#");
				for(int i=0;i<d.length;i++)
				{
					lavanteUtils.click(driver.findElement(By.cssSelector("[id*='PaymentStatusId'] input")));
					lavanteUtils.switchtoFrame(null);
					lavanteUtils.selectvalueFrmDpdn(d[i]);
					lavanteUtils.switchtoFrame(IFRAMEadvSearch());
					//lu.selectbyvisibiletxt(d[i],);
				}
			} else{
				lavanteUtils.click(driver.findElement(By.cssSelector("[id*='PaymentStatusId'] input")));
				lavanteUtils.selectvalueFrmDpdn(data);
				lavanteUtils.switchtoFrame(IFRAMEadvSearch());
			}
		}
		if(dataMap.containsKey("DELBudgetCode"))
		{
			lavanteUtils.click(DELBudgtCodedpdn());
			lavanteUtils.selectvalueFrmDpdn(dataMap.get("TypeDELBudgetCode"));
			lavanteUtils.switchtoFrame(IFRAMEadvSearch());
			if(!dataMap.get("TypeDELBudgetCode").contains("Is")){
				lavanteUtils.typeinEdit(dataMap.get("DELBudgetCode"),DELbudgtcodetxt());
			}
			
			
		}
		if(dataMap.containsKey("DELOrgCode"))
		{
		
			lavanteUtils.click(DELOrgCodedpdn());
			lavanteUtils.selectvalueFrmDpdn(dataMap.get("TypeDELOrgCode"));
			lavanteUtils.switchtoFrame(IFRAMEadvSearch());
			if(!dataMap.get("TypeDELOrgCode").contains("Is")){
				lavanteUtils.typeinEdit(dataMap.get("DELOrgCode"),DELOrgcodetxt());
			}
		
		}
		if(dataMap.containsKey("DELexpenseNottoClient"))
		{
			lavanteUtils.click(DELexptoClientdpdn());
			lavanteUtils.selectvalueFrmDpdn(dataMap.get("DELexpenseNottoClient"));
			lavanteUtils.switchtoFrame(IFRAMEadvSearch());
		}
		
		
		
	}


	public void formAction(LinkedHashMap<String, String> dataMap) {
		if(dataMap.containsKey("Search"))
		{
			lavanteUtils.switchtoFrame(IFRAMEadvSearch());
			lavanteUtils.click(searchbtn());
		}
		if(dataMap.containsKey("SaveQuery"))
		{	
			lavanteUtils.switchtoFrame(IFRAMEadvSearch());
			lavanteUtils.click(buildSaveQuery());
			SaveQry(dataMap);
		}
	}


	public void SaveQry(LinkedHashMap<String, String> dataMap) {
		
		lavanteUtils.switchtoFrame(IFRAMESaveQry());
		
		if(dataMap.containsKey("SaveQueryName"))
		{
			lavanteUtils.typeString(dataMap.get("SaveQueryName"), SaveQryName());
		}
		
		if(dataMap.containsKey("Public"))
		{
			lavanteUtils.click(publicqry());
		}
		if(dataMap.containsKey("Private"))
		{
			lavanteUtils.click(prvteqry());
		}
		
		if(dataMap.containsKey("SavetheQuery"))
		{
			lavanteUtils.click(SAVEsaveQrybtn());
		}
		if(dataMap.containsKey("CanceltheSaveQuery"))
		{
			lavanteUtils.click(SAVEcancelQrybtn());
		}
		
		
	}





	public List<WebElement> editSaved(LinkedHashMap<String, String> dataMap) {
		List<WebElement> editSaved=null;
		if(dataMap.containsKey("private"))
		{
			editSaved=ListSavedPrvtEdit();
		}else {
			editSaved=ListSavedPublicEdit();
		}
		return editSaved;
	}
	
	public List<WebElement> delSaved(LinkedHashMap<String, String> dataMap) {
		List<WebElement> delSaved=null;
		if(dataMap.containsKey("private"))
		{
			delSaved=ListSavedPrvtDel();
		}else {
			delSaved=ListSavedPublicDel();
		}
		return delSaved;
	}
	
	public List<WebElement> runSaved(LinkedHashMap<String, String> dataMap) {
		List<WebElement> runSaved=null;
		if(dataMap.containsKey("private"))
		{
			runSaved=ListSavedPrvtRUN();
		}else {
			runSaved=ListSavedPublicRUN();
		}
		return runSaved;
	}
	
	
	
}
