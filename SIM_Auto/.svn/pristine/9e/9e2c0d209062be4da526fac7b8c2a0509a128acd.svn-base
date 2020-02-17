package com.lavante.sim.customer.pageobjects.Transactions.Claims;

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

public class ClaimsPage {
	LavanteUtils lavanteUtils = new LavanteUtils();

	public ClaimsPage(WebDriver driver) {
		lavanteUtils.driver = driver;
	}

	@FindBy(id = "getRecords")
	private WebElement showCountlink;

	public WebElement showCountlink() {
		return showCountlink;
	}

	@FindBy(css = "div[id='supplier-details-box'] span[class='highlight_green']")
	private WebElement GetResultsCount;

	public WebElement GetResultsCount() {
		return GetResultsCount;
	}

	@FindBy(css = ".button_default.action_buttons")
	private WebElement Actionsbtn;

	public WebElement Actionsbtn() {
		return Actionsbtn;
	}

	@FindBy(css = "table tbody td:nth-child(1)")
	private List<WebElement> ClaimChkboxList;

	public List<WebElement> ClaimChkboxList() {
		return ClaimChkboxList;
	}

	@FindBy(css = "#search_results tr.data_not_found>td")
	private WebElement NoData;

	public WebElement NoData() {
		return NoData;
	}

	@FindBy(css = "drop-down[action-info*='Bulk'] button[class*='action_buttons']")
	private WebElement ActionsDropDwn;

	public WebElement ActionsDropDwn() {
		return ActionsDropDwn;
	}

	@FindBy(css = "#editClaim")
	private WebElement EditClaimLink;

	public WebElement EditClaimLink() {
		return EditClaimLink;
	}

	@FindBy(css = "a[href*='deleteClaim']")
	private WebElement DeleteClaimLink;

	public WebElement DeleteClaimLink() {
		return DeleteClaimLink;
	}

	@FindBy(css = "div[class*='dialog'] button[class*='button_primary']")
	private WebElement Okbtn;

	public WebElement Okbtn() {
		return Okbtn;
	}

	@FindBy(id = "submitClaim")
	private WebElement SubmitClaimLink;

	public WebElement SubmitClaimLink() {
		return SubmitClaimLink;
	}


	@FindBy(css = "li input[value*='Downl']")
	private WebElement DownloadRcrds;

	public WebElement DownloadRcrds() {
		return DownloadRcrds;
	}
	
	@FindBy(css = "a[class*='click']")
	private WebElement Downloadpopup;

	public WebElement Downloadpopup() {
		return Downloadpopup;
	}
	
	@FindBy(css = "table[id='search_results'] tr[class='data_not_found'] td")
	private WebElement VerifyNoResultTxt;

	public WebElement VerifyNoResultTxt() {
		return VerifyNoResultTxt;
	}

	@FindBy(css = "td[class='check_box'] label")
	private List<WebElement> ListSelectChkBox;

	public List<WebElement> ListSelectChkBox() {
		return ListSelectChkBox;
	}

	@FindBy(css = "a[href*='viewClaimDetails']")
	private List<WebElement> ListClaimId;

	public List<WebElement> ListClaimId() {
		return ListClaimId;
	}

	@FindBy(css = "#search_results th")
	private List<WebElement> Headers;

	@FindBy(css = "input[data-claimfilter-name='myClaims']")
	private WebElement myClaimsRadBtn1;
	public WebElement myClaimsRadBtn1() {
		return myClaimsRadBtn1;
	}

	@FindBy(css = "label[class='box-image'][for='My Claims']")
	private WebElement myClaimsRadBtn;

	public WebElement myClaimsRadBtn() {
		return myClaimsRadBtn;
	}

	@FindBy(css = "input[data-claimfilter-name='allClaims']")
	private WebElement allClaimsRadBtn1;

	public WebElement allClaimsRadBtn1() {
		return allClaimsRadBtn1;
	}

	@FindBy(css = "label[class='box-image'][for='All Claims']")
	private WebElement allClaimsRadBtn;

	public WebElement allClaimsRadBtn() {
		return allClaimsRadBtn;
	}

	@FindBy(css = "iframe[id='search_results']")
	private WebElement IframeResultsPage;

	public WebElement IframeResultsPage() {
		return IframeResultsPage;
	}

	@FindBy(css = "div a img[src*='ic_comment_black']")
	private List<WebElement> CommentImg;

	public List<WebElement> CommentImg() {
		return CommentImg;
	}

	@FindBy(css = "div a sup[id='readUnreadComments']")
	private List<WebElement> GetCommentCount;

	public List<WebElement> GetCommentCount() {
		return GetCommentCount;
	}

	@FindBy(css = "button[id *='Search']")
	private WebElement searchBtn;
	public WebElement searchBtn() {
		return searchBtn;
	}

	@FindBy(css = "button[name *='clear']")
	private WebElement clearBtn;
	public WebElement clearBtn() {
		return clearBtn;
	}
	
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
	
	
	
	/**
	 * @author subhas.bv
	 * @throws SQLException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * 
	 * 
	 * 
	 */
	public void selectClaimActions(LinkedHashMap<String, String> dataMap) throws FileNotFoundException, IOException, SQLException {
		lavanteUtils.clicks(ClaimChkboxList().get(0));
	//	lavanteUtils.fluentwait(ActionsDropDwn);
		lavanteUtils.clicks(ActionsDropDwn);
		if (dataMap.containsKey("EditClaim")) {
			lavanteUtils.clicks(EditClaimLink);
		}
		if (dataMap.containsKey("DeleteClaim")) {
			lavanteUtils.clicks(DeleteClaimLink);
			lavanteUtils.switchtoFrame(null);
			lavanteUtils.clicks(Okbtn);
		}
		if (dataMap.containsKey("SubmitClaim")) {
			lavanteUtils.clicks(SubmitClaimLink);
			lavanteUtils.clicks(Okbtn);
		}
		if (dataMap.containsKey("DownloadRecords")) {
			String x="";
			if(dataMap.containsKey("CustomerID")){
				x="select MAX(FileDownloadID) From FileDownload where CustomerID="+dataMap.get("CustomerID");
				x=lavanteUtils.fetchDBdata(x);
			}
						
			lavanteUtils.clicks(DownloadRcrds);
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

	private void IterateDownload(LinkedHashMap<String, String> dataMap) {
		
		lavanteUtils.switchtoFrame(IFRAMEFileDownload);
		lavanteUtils.switchFrame(IFRAMEFile);
		
		for(int i=0;i<filename.size();i++){
			String filenameact=filename.get(i).getText();
			if(filenameact.equalsIgnoreCase(dataMap.get("FileName"))){
				String fileStatusAct=fileStatus.get(i).getText();
				String fileStatusExp="Completed";
				String fileTypeAct=fileType.get(i).getText();
				if(!fileStatusAct.equalsIgnoreCase(fileStatusExp)){
					
					boolean flag=refreshgrid(IFRAMEFileDownload,IFRAMEFile,fileStatusExp);
					lavanteUtils.switchtoFrame(IFRAMEFileDownload);
					lavanteUtils.switchFrame(IFRAMEFile);
					if(flag){
						dataMap.put("FileName",filenameact);
						fileStatusAct=fileStatus.get(i).getText();
						dataMap.put("FileStatus",fileStatusAct);
						dataMap.put("FileType",fileTypeAct);
					break;
					}
					
				}else{
					dataMap.put("FileName",filenameact);
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
			lavanteUtils.selectbyvalue("11501",Filetype);
			lavanteUtils.selectbyvalue("11502",Filetype);
			i=i+1;
			System.out.println(i + actStatus + expStatus + flag);
			if (actStatus.contains(expStatus)) {
				flag = true;
			}
		} while ((!(flag == true)) && (i < 50));

		return flag;
	}

	public List<WebElement> iterateSearchHeaderFindColList(String col) {
		List<WebElement> s = null;
		int j = ColIdentify(col);
		String x = "#search_results tr td:nth-child(" + j + ")";
		s = lavanteUtils.driver.findElements(By.cssSelector(x));

		if (col.contains("Claim ID") || col.contains("Payment Ref No") || col.contains("Invoice Number")) {
			x = "#search_results tr td:nth-child(" + j + ") a";
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

	/**
	 * Methods to check whether the lock icon is present or not in Task -> Claim
	 * page
	 * 
	 * @author Girish.N
	 * @param dataMap
	 * @param element
	 * @return
	 */
	public LinkedHashMap<String, String> isLockExists(LinkedHashMap<String, String> dataMap) {
		String lockIconXPath = "//table[@id='search_results']//span[contains(@class,'icon_lock')]";

		try {
			WebElement lockIcon = lavanteUtils.driver.findElement(By.xpath(lockIconXPath));
			dataMap.put("LockExists", "True");
			String lockToolTip = lockIcon.getAttribute("title").trim();
			Reporter.log("Lock Message: " + lockToolTip, true);
			dataMap.put("LockMessage", lockToolTip);
		} catch (Exception e) {
			dataMap.put("LockExists", "False");
		}
		return dataMap;
	}

	/**
	 * Method to check whether the check box to edit the claim is present or not
	 * in Task -> Claim page.
	 * 
	 * @author Girish.N
	 * @param dataMap
	 * @param element
	 * @return
	 */
	public LinkedHashMap<String, String> isCheckBoxExists(LinkedHashMap<String, String> dataMap) {
		String chkBoxXPath = "//table[@id='search_results']/tbody//tr[1]//label[contains(@class,'box-image')]";

		try {
			lavanteUtils.driver.findElement(By.xpath(chkBoxXPath));
			dataMap.put("CheckBoxExists", "True");

		} catch (Exception e) {
			dataMap.put("CheckBoxExists", "False");
		}
		return dataMap;
	}

	/**
	 * Used for Sanity 
	 * @author Thejaswi.Bhat
	 */
	public boolean verifyClaimsPage() {
		boolean flag=false;
		
		lavanteUtils.switchtoFrame(null);
		boolean flag1=lavanteUtils.verifyElementDisplayed("Search Button", searchBtn);
		boolean flag2=lavanteUtils.verifyElementDisplayed("Clear Button", clearBtn);
		
		if(flag1 && flag2){
			flag=true;
		}
		
		return flag;
		
	}
}
