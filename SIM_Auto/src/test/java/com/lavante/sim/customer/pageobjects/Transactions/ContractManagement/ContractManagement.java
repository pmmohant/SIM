/**
 * 
 */
package com.lavante.sim.customer.pageobjects.Transactions.ContractManagement;

import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.lavante.sim.Common.Util.LavanteUtils;

/**
 * @author Piramanayagam.S
 *
 */
public class ContractManagement {
	
	public LavanteUtils lavanteUtils=new LavanteUtils();
	
	public ContractManagement(WebDriver driver){
		lavanteUtils.driver=driver;		
	}

	
	@FindBy(id="search_tab")
	private  WebElement  basicSearchtab;	
	public WebElement  basicSearchtab(){
		return basicSearchtab;
	}
	
	@FindBy(id="adv_search_tab")
	private  WebElement  advSearchtab;	
	public WebElement  advSearchtab(){
		return advSearchtab;
	}
	
	
	@FindBy(css="#contractMgmt_table th")
	private List<WebElement> tableheaderlist;	
	public List<WebElement>  tableheaderlist(){
		return tableheaderlist;
	}
	
	@FindBy(css="Label")
	private  List<WebElement>  Label;	
	public  List<WebElement>  Labellist(){
		return Label;
	}
	
	//IFRAME
	
	@FindBy(css="iframe[id*='search']")
	private WebElement IFRAMESearchResult;	
	public WebElement  IFRAMESearchResult(){
		return IFRAMESearchResult;
	}
	
	@FindBy(css="iframe[src*='viewEnter']")
	private  WebElement  IFRAMESuppview;	
	public WebElement  IFRAMESuppview(){
		return IFRAMESuppview;
	}
	

	@FindBy(css="iframe[src*='sow']")
	private WebElement IFRAMESOWView;	
	public WebElement  IFRAMESOWView(){
		return IFRAMESOWView;
	}
	
	//Supplier Pop up
	@FindBy(css="div[style*='visible'][style*='block'] span[class*='title']")
	private  WebElement  SuppNAMEIframe;	
	public WebElement  SuppNAMEIframe(){
		return SuppNAMEIframe;
	}
	
	
	@FindBy(css="[id*='main'] a[class*='active']")
	private  WebElement  mainTab;	
	public WebElement  mainTab(){
		return mainTab;
	}
	

	@FindBy(css="[id*='sub'] a[class*='active']")
	private  WebElement  subtab;	
	public WebElement  subtab(){
		return subtab;
	}
	
	
	@FindBy(css="a[href*='MasterSer']")
	private  List<WebElement>  msalist;	
	public List<WebElement>  msalist(){
		return msalist;
	}
	

	@FindBy(css="#contractMgmt_table td:nth-child(3)")
	private  List<WebElement>  msatypelist;	
	public List<WebElement>  msatypelist(){
		return msatypelist;
	}
	
	@FindBy(css="a[href*='sow']")
	private List<WebElement> sowNoList;	
	public List<WebElement>  sowNoList(){
		return sowNoList;
	}
	
	
	@FindBy(css="a[href*='viewEnter']")
	private  List<WebElement>  supplist;	
	public List<WebElement>  supplist(){
		return supplist;
	}


	@FindBy(css="a[href*='viewStatement']")
	private  List<WebElement>  sowlist;	
	public List<WebElement>  sowlist(){
		return sowlist;
	}
	
	@FindBy(css="#contractMgmt_table td:nth-child(6)")
	private  List<WebElement>  SowStatus;	
	public List<WebElement>  SowStatus(){
		return SowStatus;
	}
	
	@FindBy(css="#contractMgmt_table td:nth-child(7)")
	private  List<WebElement>  DELDel;	
	public List<WebElement>  DELDel(){
		return DELDel;
	}
	
	@FindBy(css="a[href*='viewDel']")
	private  List<WebElement>  dellist;	
	public List<WebElement>  dellist(){
		return dellist;
	}
	
	//Edit Button

	@FindBy(id="editSupplierProfile")
	private  WebElement  editSupplierProfilebtn;	
	public WebElement  editSupplierProfilebtn(){
		return editSupplierProfilebtn;
	}

	@FindBy(id="editMsa")
	private  WebElement  editMSAbtn;	
	public WebElement  editMSAbtn(){
		return editMSAbtn;
	}
	

	@FindBy(id="editSow")
	private  WebElement  editSOWbtn;	
	public WebElement  editSOWbtn(){
		return editSOWbtn;
	}
	
	@FindBy(id="editDeliverable")
	private  WebElement  editDelBtn;	
	public WebElement  editDelBtn(){
		return editDelBtn;
	}
	
	//Basic Search field
	
	@FindBy(id="supplierName")
	private  WebElement  msasuppnametxt;	
	public WebElement  msasuppnametxt(){
		return msasuppnametxt;
	}
	
	@FindBy(id="msaNumber")
	private  WebElement  msaNumtxt;	
	public WebElement  msaNumtxt(){
		return msaNumtxt;
	}
	
	@FindBy(css="[id*='msaType'] a")
	private  WebElement  msaTypedpdn;	
	public WebElement  msaTypedpdn(){
		return msaTypedpdn;
	}
	
	@FindBy(id="sowNumber")
	private  WebElement  sowNumtxt;	
	public WebElement  sowNumtxt(){
		return sowNumtxt;
	}
	
	@FindBy(id="internalContact")
	private  WebElement  sowInternalcontcttxt;	
	public WebElement  sowInternalcontcttxt(){
		return sowInternalcontcttxt;
	}
		
		
	//Adv Search 
	@FindBy(css="[id*='queries'] td:nth-child(1) span,[id*='queries'] td:nth-child(1) a")
	private  List<WebElement>  ListSAVEDQUERYNAME;	
	public List<WebElement>  ListSAVEDQUERYNAME(){
		return ListSAVEDQUERYNAME;
	}
	
	
	@FindBy(css="[id*='queries'] td:nth-child(3) a")
	private  List<WebElement>  ListSAVEDQUERYDEL;	
	public List<WebElement>  ListSAVEDQUERYDEL(){
		return ListSAVEDQUERYDEL;
	}
	
	
	@FindBy(css="#public_queries td:nth-child(1)")
	private  List<WebElement>  ListPublicSAVEDQUERYNAME;	
	public List<WebElement>  ListPublicSAVEDQUERYNAME(){
		return ListPublicSAVEDQUERYNAME;
	}
	
	@FindBy(css="div[class*='dialog'] button[class*='green']")
	private  WebElement  OKBtn;	
	public WebElement  OKBtn(){
		return OKBtn;
	}
	
	@FindBy(css="div[class*='dialog'] button[class*='green']")
	private  WebElement  editOKBtn;	
	public WebElement  editOKBtn(){
		return editOKBtn;
	}
	
	@FindBy(css="button[href*='loadContract']")
	private  WebElement  buildQry;	
	public WebElement  buildQry(){
		return buildQry;
	}
	
	@FindBy(css="div[id][style*='display: block'] [title='Clear']")
	private  List<WebElement>  clearbtnlist;	
	public List<WebElement>  clearbtnlist(){
		return clearbtnlist;
	}
	
	@FindBy(css="#advanceSearchExecute input[type*='reset']")
	private  WebElement  clearbtn;	
	public WebElement  clearbtn(){
		return clearbtn;
	}
	
	@FindBy(css="#search_supplier_form button:nth-child(1)")
	private  WebElement  Basicclearbtn;	
	public WebElement  Basicclearbtn(){
		return Basicclearbtn;
	}
	
	@FindBy(id="contMgmtSearch")
	private  WebElement  searchbtn;	
	public WebElement  searchbtn(){
		return searchbtn;
	}
	
	@FindBy(css="#contractMgmtForm span")
	private  WebElement  SearchCount;	
	public WebElement  SearchCount(){
		return SearchCount;
	}

	@FindBy(css="button[class*='save_query']")
	private  WebElement  Saveqrybtn;	
	public WebElement  Saveqrybtn(){
		return Saveqrybtn;
	}
	
	
	
	public void selectSearchTab(LinkedHashMap<String, String> dataMap) {
		lavanteUtils.switchtoFrame(IFRAMESearchResult);
		lavanteUtils.switchtoFrame(null);
		lavanteUtils.fluentwait(advSearchtab);
		if(dataMap.containsKey("AdvSearch")){	
			lavanteUtils.click(advSearchtab);
		}
		if(dataMap.containsKey("BasicSearch")){
			lavanteUtils.fluentwait(basicSearchtab);
			lavanteUtils.click(basicSearchtab);
		}
		lavanteUtils.switchtoFrame(IFRAMESearchResult);
		lavanteUtils.switchtoFrame(null);
	}
	
	public void SelectSearchOption(LinkedHashMap<String, String> dataMap) {
		if(dataMap.containsKey("Build")){
			lavanteUtils.fluentwait(buildQry);
			lavanteUtils.click(buildQry);
		}
	}


	public void search(LinkedHashMap<String, String> dataMap) {
		fillSearchDetails(dataMap);
		formactionSearch(dataMap);
		 
	}



	public void fillSearchDetails(LinkedHashMap<String, String> dataMap) {
		lavanteUtils.fluentwait(msasuppnametxt);
		if(dataMap.containsKey("msasuppliername"))
		{
			lavanteUtils.typeinEdit(dataMap.get("msasuppliername"), msasuppnametxt);
		}
		if(dataMap.containsKey("MSANum"))
		{
			lavanteUtils.typeinEdit(dataMap.get("MSANum"), msaNumtxt);	
		}
		
		if(dataMap.containsKey("MSATYPE"))
		{
			lavanteUtils.click(msaTypedpdn);
			lavanteUtils.selectvalueFrmDpdn(dataMap.get("MSATYPE"));
			
		}
		if(dataMap.containsKey("SOWNumber"))
		{
			lavanteUtils.typeinEdit(dataMap.get("SOWNumber"), sowNumtxt);
		}
		 if(dataMap.containsKey("SOWInternalContact"))
		{
			 lavanteUtils.typeinEdit(dataMap.get("SOWInternalContact"), sowInternalcontcttxt);
		}
		 
	}


	/**
	 * formactionSearch  Search form action
	 * @author Piramanayagam S
	 * @param dataMap
	 */
	public void formactionSearch(LinkedHashMap<String, String> dataMap) {
		lavanteUtils.fluentwait(searchbtn);
		lavanteUtils.switchtoFrame(IFRAMESearchResult);
		lavanteUtils.switchtoFrame(null);
		lavanteUtils.fluentwait(searchbtn);
		if(dataMap.containsKey("Search")){
			lavanteUtils.click(searchbtn);
		}
		if(dataMap.containsKey("Clear")){
			lavanteUtils.click(Basicclearbtn);
		}
	}
	
	/**Sanity
	 * @author Thejaswi.Bhat
	 */
	public boolean verifyContractManagementPage(){
		boolean flag=false;
		
		lavanteUtils.switchtoFrame(null);
		boolean flag1=lavanteUtils.verifyElementDisplayed("Search Button", searchbtn);
		boolean flag2=lavanteUtils.verifyElementDisplayed("Clear Button", Basicclearbtn);
		lavanteUtils.switchtoFrame(IFRAMESearchResult);
		boolean flag3=lavanteUtils.verifyElementDisplayed("Edit Supplier Profile Button", editSupplierProfilebtn);
		boolean flag4=lavanteUtils.verifyElementDisplayed("Edit MSA Button", editMSAbtn);
		boolean flag5=lavanteUtils.verifyElementDisplayed("Edit SOW Button", editSOWbtn);
		boolean flag6=lavanteUtils.verifyElementDisplayed("Edit Deliverable Button", editDelBtn);
		
		if(flag1 && flag2 && flag3 && flag4 && flag5 && flag6){
			flag=true;
		}
		
		return flag;
	}
	
	
	
}
