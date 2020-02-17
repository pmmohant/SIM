package com.lavante.sim.customer.pageobjects.Transactions.PromoAllowances;

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

import com.lavante.sim.Common.Util.LavanteUtils;

public class PromoAllowancePage {
	LavanteUtils lavanteUtils = new LavanteUtils();

	public PromoAllowancePage(WebDriver driver) {
		lavanteUtils.driver = driver;
	}

	@FindBy(css = "table-grid th")
	private List<WebElement> Headers;

	public List<WebElement> Headers() {
		return Headers;
	}
	
	@FindBy(css = "table-grid th span")
	private List<WebElement> Headersspan;

	
	@FindBy(css = "table-grid td:nth-child(1)>span")
	private List<WebElement> invoiceChkbxList;

	public List<WebElement> invoiceChkbxList() {
		return invoiceChkbxList;
	}

	@FindBy(css = "table-grid button[class*='action_buttons']")
	private WebElement ActionsDropDwn;

	public WebElement ActionsDropDwn() {
		return ActionsDropDwn;
	}

	@FindBy(css = "drop-down li input:nth-child(1)[title*='claim']")
	private WebElement createClaim;

	public WebElement createClaim() {
		return createClaim;
	}

	@FindBy(css = "drop-down li input:nth-child(1)[title*='comment']")
	private WebElement addComment;

	public WebElement addComment() {
		return addComment;
	}
	
	//Add Comment
	@FindBy(id = "flex")
	private WebElement EnterCommentsTxtArea;

	public WebElement EnterCommentsTxtArea() {
		return EnterCommentsTxtArea;
	}

	@FindBy(id = "public_user")
	private WebElement publicRadioBtn;

	public WebElement publicRadioBtn() {
		return publicRadioBtn;
	}

	@FindBy(id = "private_user")
	private WebElement privateRadioBtn;

	public WebElement privateRadioBtn() {
		return privateRadioBtn;
	}
	
	@FindBy(css = "#parentComments button[class*='primary']")
	private WebElement AddCommentBtn;

	public WebElement AddCommentBtn() {
		return AddCommentBtn;
	}

	@FindBy(css = "div[data-ng-if*='isPrivate']+p[class*='commentUserText']")
	private List<WebElement> PrivateCommentsList;

	public List<WebElement> PrivateCommentsList() {
		return PrivateCommentsList;
	}

	@FindBy(css = "p[class*='commentUserText']")
	private List<WebElement> PublicCommentsList;

	public List<WebElement> PublicCommentsList() {
		return PublicCommentsList;
	}

	//End of Add Comment
	
	//Basic Fields
	@FindBy(id = "OfferNumber")
	private WebElement Offernumbertxt;
	
	@FindBy(id = "InvoiceNumber")
	private WebElement InvoiceNumbertxt;
	
	@FindBy(id = "SupplierName")
	private WebElement SupplierNametxt;
	
	
	//End of BAsic

	@FindBy(css = "button[type='submit']")
	private WebElement searchBtn;
	public WebElement searchBtn() {
		return searchBtn;
	}

	@FindBy(css = "button[type='reset']")
	private WebElement clearBtn;
	public WebElement clearBtn() {
		return clearBtn;
	}
	
	@FindBy(css = "table-grid td")
	private WebElement NoData;

	public WebElement NoData() {
		return NoData;
	}

	@FindBy(css = "div[class*='results']  span[ng-if*='pag']")
	private WebElement pgCount;

	public WebElement pgCount() {
		return pgCount;
	}
	
	@FindBy(css = "li input[value*='Download']")
	private WebElement DownloadRcrds;
	
	@FindBy(css = "div[class*='dialog'] button[class*='button_primary']")
	private WebElement Okbtn;

	@FindBy(css = "a[class*='click']")
	private WebElement Downloadpopup;
	
	//Download
	
		@FindBy(css = "#dialog select")
		private WebElement Filetype;
		public WebElement Filetype() {
			return Filetype;
		}
		
		@FindBy(css = "iframe[src*='Download']")
		private WebElement IFRAMEFileDownload;
		public WebElement IFRAMEFileDownload() {
			return IFRAMEFileDownload;
		}
		
		@FindBy(css = "iframe[src*='down']")
		private WebElement IFRAMEFile;
		public WebElement IFRAMEFile() {
			return IFRAMEFile;
		}
		
		@FindBy(css = "[id*='downloadFileDetailsDiv'] td:nth-child(1)")
		private List<WebElement> filename;
		public List<WebElement> filename() {
			return filename;
		}
		
		@FindBy(css = "[id*='downloadFileDetailsDiv'] td:nth-child(4)")
		private List<WebElement> fileType;
		public List<WebElement> fileType() {
			return fileType;
		}
		
		@FindBy(css = "[id*='downloadFileDetailsDiv'] td:nth-child(6)")
		private List<WebElement> fileStatus;
		public List<WebElement> fileStatus() {
			return fileStatus;
		}
		
		//End of Download
	
	
	public void Search(LinkedHashMap<String, String> dataMap) {
		lavanteUtils.switchtoFrame(null);
		fillSearchdetails(dataMap);
		formAction(dataMap);

	}
	
	public void fillSearchdetails(LinkedHashMap<String, String> dataMap) {
		if (dataMap.containsKey("OfferNumber")) {
			Offernumbertxt.clear();
			lavanteUtils.typeinEdit(dataMap.get("OfferNumber"), Offernumbertxt);
		}
		if (dataMap.containsKey("InvoiceNumber")) {
			InvoiceNumbertxt.clear();
			lavanteUtils.typeinEdit(dataMap.get("InvoiceNumber"), InvoiceNumbertxt);
		}
		if (dataMap.containsKey("DealNumber")) {

			
		}
		if (dataMap.containsKey("Division")) {
		//	lavanteUtils.click(Offernumbertxt);
		//	lavanteUtils.selectFrmDpdn(dataMap.get("Division"));
		}
		if (dataMap.containsKey("SupplierName")) {
			SupplierNametxt.clear();
			lavanteUtils.typeinEdit(dataMap.get("SupplierName"), SupplierNametxt);

		}
		if (dataMap.containsKey("SuuplierERP")) {

		}
		if (dataMap.containsKey("TotalInvoiceAmount")) {

		}
	}

	
	public void formAction(LinkedHashMap<String, String> dataMap) {
		lavanteUtils.switchtoFrame(null);
		if (dataMap.containsKey("Search")) {
			lavanteUtils.click(searchBtn);
			//As it loads used the same
			lavanteUtils.fluentwait(searchBtn);
		}
		if (dataMap.containsKey("Clear")) {
			lavanteUtils.click(clearBtn);
			//As it loads used the same
			lavanteUtils.fluentwait(clearBtn);
		}
	}
	
	public List<WebElement> iterateSearchHeaderFindColList(String col) {
		List<WebElement> s = null;
		int j = ColIdentify(col);
		String x = "table-grid tr td:nth-child(" + j + ")";
		s = lavanteUtils.driver.findElements(By.cssSelector(x));
		if (col.contains("Invoice number")) {
			x = "table-grid tr td:nth-child(" + j + ") a";
			s = lavanteUtils.driver.findElements(By.cssSelector(x));
		}else if (col.contains("Deal number") || col.contains("Contract number") || col.contains("Offer number") || col.contains("Supplier name") || col.contains("Payment ref number") ) {
			x = "table-grid tr td:nth-child(" + j + ") a";
			s = lavanteUtils.driver.findElements(By.cssSelector(x));
		}else if (col.contains("ANY")) {
			
		}
		System.out.println("Iterate Search Col:" + col + ":" + s.size());
		return s;
	}

	public int ColIdentify(String col) {
		int ki = 0;
		boolean found = false;
		lavanteUtils.fluentwait(searchBtn);
		if (Headers.size() > 0) {
			for (int i = 0; i < Headers.size(); i++) {
				String x = Headers.get(i).getText().toLowerCase().trim();
				if(!(x.length()>0)){
					x = Headersspan.get(i).getAttribute("class").toLowerCase().trim();
					if(col.contains("attachment") && x.contains("attachment")){
						ki=i+1;
						break;
					}else if(col.equalsIgnoreCase("comment") && x.contains("comment")){
						ki=i+1; 
						break;
					}
				}else if (x.contains(col.toLowerCase())) {
					ki = i;
					// List start with 0 but need a number more than that to
					// fetch in xpath
					ki = i + 1;
					System.out.println(col + ",Col Found at " + ki);
					found = true;
					break;
				}else if (col.contains("ANY") && (!x.contains("number"))){
					 ki = i + 1;
					 found = true;
					 break;
				}
			}
		}

		
		return ki;

	}
	

	
	/**
	 * Used for Sanity 
	 * @author Thejaswi.Bhat
	 */
	public boolean verifyPromoPage() {
		boolean flag=false;
		
		lavanteUtils.switchtoFrame(null);
		boolean flag1=lavanteUtils.verifyElementDisplayed("Search Button", searchBtn);
		boolean flag2=lavanteUtils.verifyElementDisplayed("Clear Button", clearBtn);
		
		if(flag1 && flag2){
			flag=true;
		}
		
		return flag;
		
	}

	public void action(LinkedHashMap<String, String> dataMap) throws FileNotFoundException, IOException, SQLException {
		if(dataMap.containsKey("Action")){
			
		List<WebElement> searchResultList = iterateSearchHeaderFindColList("ANY");
		if(searchResultList.size()>0){
			lavanteUtils.click(searchResultList.get(0));
			lavanteUtils.click(ActionsDropDwn);
			
			String x=dataMap.get("Action");
			if(x.contains("AddComment")){
				lavanteUtils.click(addComment);
				addCommentView(dataMap);
			}if(x.contains("CreateClaim")){
				lavanteUtils.click(createClaim);
			}if(x.contains("DownloadRecords")){
				lavanteUtils.click(DownloadRcrds);
				x="";
				if(dataMap.containsKey("CustomerID")){
					x="select MAX(FileDownloadID) From FileDownload where CustomerID="+dataMap.get("CustomerID");
					x=lavanteUtils.fetchDBdata(x);
				}
							
				lavanteUtils.switchtoFrame(null);
				lavanteUtils.clicks(Okbtn);
				lavanteUtils.click(Downloadpopup);
				String xx="select FileName From FileDownload where FileDownloadID>"+x;
				xx=lavanteUtils.fetchDBdata(xx);
				if(xx!=null){
					dataMap.put("FileName", xx);
					IterateDownload(dataMap);
					}
				}
				
			}
		}
	}
		
		private void IterateDownload(LinkedHashMap<String, String> dataMap) {
			
			lavanteUtils.switchtoFrame(IFRAMEFileDownload);
			lavanteUtils.switchFrame(IFRAMEFile);
			
			for(int i=0;i<filename.size();i++){
				String filenameAct=filename.get(i).getText();
				if(filenameAct.equalsIgnoreCase(dataMap.get("FileName"))){
					String fileStatusAct=fileStatus.get(i).getText();
					String fileTypeAct=fileType.get(i).getText();
					String expct="Completed";
					if(!fileStatusAct.equalsIgnoreCase(expct)){
						
						boolean flag=refreshgrid(IFRAMEFileDownload,IFRAMEFile,expct);
						lavanteUtils.switchtoFrame(IFRAMEFileDownload);
						lavanteUtils.switchFrame(IFRAMEFile);
						
						if(flag){
							dataMap.put("FileName",filenameAct);
							fileStatusAct=fileStatus.get(i).getText();
							dataMap.put("FileStatus",fileStatusAct);
							dataMap.put("FileType",fileTypeAct);
						break;
						}
						
					}else{
						dataMap.put("FileName",filenameAct);
						dataMap.put("FileStatus",fileStatusAct);
						dataMap.put("FileType",fileTypeAct);
						break;
					}
					
				}
				
			}
			
		}
		
		private boolean refreshgrid(WebElement iframe,WebElement iframe2, String expStatus) {
			boolean flag = false;
			String actStatus = "";
			int i = 0;

			do {
				lavanteUtils.switchtoFrame(iframe);
				lavanteUtils.switchFrame(iframe2);
				lavanteUtils.waitForTime(5000);
				actStatus = fileStatus().get(0).getText();
				lavanteUtils.switchtoFrame(iframe);
				lavanteUtils.selectbyvalue("11502",Filetype);
				lavanteUtils.selectbyvalue("11504",Filetype);
				i=i+1;
				System.out.println(i + actStatus + expStatus + flag);
				if (actStatus.contains(expStatus)) {
					flag = true;
				}
			} while ((!(flag == true)) && (i < 50));

			return flag;
		}


	/**
	 * Add Comment for Promo From Slider Aswell RHS
	 * @author Piramanayagam.S
	 * @param dataMap
	 */
	public void addCommentView(LinkedHashMap<String, String> dataMap) {

		/*if (lavanteUtils.isElementDisplayed(addCommentBtn)) {
			lavanteUtils.clicks(AddCommentBtn);
		}*/
		if (dataMap.containsKey("EnterComment")) {
			lavanteUtils.typeinEdit(dataMap.get("EnterComment"), EnterCommentsTxtArea);
		}
		if (dataMap.containsKey("PrivateComment")) {
			lavanteUtils.clickJavaScriptNoWait(privateRadioBtn);
		}
		if (dataMap.containsKey("PublicComment")) {
			lavanteUtils.clickJavaScriptNoWait(publicRadioBtn);
		}
		lavanteUtils.clicks(AddCommentBtn);
		
	}
	
	
	public String clickColText(String colname) {
		String x = "";
		
		int size = iterateSearchHeaderFindColList(colname).size();
		List<WebElement> sx = iterateSearchHeaderFindColList(colname);
		outr: for (int i = 0; i < size; i++) {
				x=sx.get(i).getText();
				lavanteUtils.click(sx.get(i));
				break outr;
		}
		return x;
	}
	
	
}
