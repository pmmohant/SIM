package com.lavante.sim.customer.pageobjects.Transactions.NCH;

import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.lavante.sim.Common.Util.LavanteUtils;

public class NCHInvoice {
	LavanteUtils lavanteUtils = new LavanteUtils();

	public NCHInvoice(WebDriver driver) {
		lavanteUtils.driver = driver;
	}

	@FindBy(css = "[ng-reflect-name*='NCHDeductionNumber']")
	private WebElement nchDeductionNumber;
	
	@FindBy(css = "[ng-reflect-name*='NCHInvoiceNumber']")
	private WebElement nchInvoiceNumber;

	@FindBy(css = "[ng-reflect-name*='NCHManufacturerNumber']")
	private WebElement nchManufacturerNumber;
	
	@FindBy(css = "[ng-reflect-name*='NCHManufacturerName']")
	private WebElement nchManufacturerName;
	
	@FindBy(css = "[ng-reflect-name*='SupplierERPID']")
	private WebElement supplierErpId;
	
	@FindBy(css = "[ng-reflect-name*='SupplierName']")
	private WebElement supplierName;
	
	@FindBy(css = "span[class*= 'ng-tns-c20-11 ui-calendar']")
	private WebElement nchInvoiceDate;
	
	@FindBy(css = "span[class*= 'ng-tns-c20-12 ui-calendar']")
	private WebElement reportDate;
	
	@FindBy(css = "[ng-reflect-name*='Totaldeductionamount']")
	private WebElement totalDeductionAmount;
	
	@FindBy(css = "[ng-reflect-name*='Adjustmentcode']")
	private WebElement adjustmentCode;
	
	@FindBy(css = "[ng-reflect-name*='Adjustmentdescription']")
	private WebElement adjustmentDescription;
	
	@FindBy(xpath = "//button/span[contains(text(),'Search')]")
	private WebElement searchBtn;
	public WebElement SearchBtn(){
		return searchBtn;
	}
	
	@FindBy(xpath = "//button/span[contains(text(),'Clear')]")
	private WebElement clearBtn;

	@FindBy(css = "p-table table th")
	private List<WebElement> Headers;

	@FindBy(css = "p-table table tr td")
	private WebElement noDataFound;
	public WebElement noDataFound() {
		return noDataFound;
	}
	@FindBy(css="div[class*='recordInfo']")
	private WebElement GetResultsCount;
	public WebElement GetResultsCount() {
		// TODO Auto-generated method stub
		return GetResultsCount;
	}

	@FindBy(css="a[href*='buyerHome']")
	private WebElement Home;
	public WebElement Home() {
		return Home;
	}
	
	@FindBy(css="dummy")
	private List<WebElement> getUnreadCommentCount;	
	public List<WebElement> getUnreadCommentCount() {
		// TODO Auto-generated method stub
		return getUnreadCommentCount;
	}
	
	
	@FindBy(css="dummy")
	private List<WebElement> markAllReadLink;	
	public List<WebElement> markAllReadLink() {
		// TODO Auto-generated method stub
		return markAllReadLink;
	}
	
	@FindBy(css = "dummy")
	private List<WebElement> commentDropDwn;
	
	public List<WebElement> commentDropDwn() {
		return commentDropDwn;
	}
	
	@FindBy(css="dummy")
	private WebElement addComment;	
	public WebElement addComment() {
		// TODO Auto-generated method stub
		return addComment;
	}
	
	@FindBy(css = "dummy")
	private List<WebElement> privateCommentsList;

	public List<WebElement> privateCommentsList() {
		return privateCommentsList;
	}
	
	@FindBy(css = "dummy")
	private List<WebElement> publicCommentsList;

	public List<WebElement> publicCommentsList() {
		return publicCommentsList;
	}

	@FindBy(css = "dummy")
	private List<WebElement> profileCommentsList;

	public List<WebElement> profileCommentsList() {
		return profileCommentsList;
	}
	
	@FindBy(css = "dummy")
	private List<WebElement> addComments;

	public List<WebElement> addComments() {
		return addComments;
	}
	
	
	
	// Add/Verify Comments
	@FindBy(css = "dummy")
	private WebElement AddCommentBtn;

	public WebElement AddCommentBtn() {
		return AddCommentBtn;
	}

	@FindBy(css = "dummy")
	private WebElement AddCommentsBtn;

	public WebElement AddCommentsBtn() {
		return AddCommentsBtn;
	}

	@FindBy(css = "dummy")
	private WebElement DeleteBtn;

	public WebElement DeleteBtn() {
		return DeleteBtn;
	}

	
	@FindBy(css = "dummy")
	private WebElement EnterCommentsTxtArea;

	public WebElement EnterCommentsTxtArea() {
		return EnterCommentsTxtArea;
	}

	@FindBy(css = "dummy")
	private WebElement PublicRadioBtn;

	@FindBy(css = "dummy")
	private WebElement PrivateRadioBtn;

	@FindBy(css = "dummy")
	private List<WebElement> PrivateCommentsList;

	public List<WebElement> PrivateCommentsList() {
		return PrivateCommentsList;
	}

	@FindBy(css = "dummy")
	public List<WebElement> PrivateCommentActionbtn;

	@FindBy(css = "dummy")
	public List<WebElement> EditPrivateComments;

	@FindBy(css = "dummy")
	public List<WebElement> DeletePrivateComments;

	@FindBy(css = "dummy")
	public List<WebElement> MarkAsRead;

	@FindBy(css = "dummy")
	public List<WebElement> MarkAsUnRead;

	@FindBy(css = "dummy")
	public List<WebElement> EditComment;

	@FindBy(css = "dummy")
	public List<WebElement> DeleteComment;

	
	@FindBy(css = "tbody[class*='ui-table-tbody'] td:nth-child(3) a")
	public List<WebElement> ListNCHName;
	
	@FindBy(css = "dummy")
	private List<WebElement> commentImg;

	public List<WebElement> commentImg() {
		return commentImg;
	}
	
	

	@FindBy(css = "dummy")
	private List<WebElement> getCommentCount;

	public List<WebElement> getCommentCount() {
		return getCommentCount;
	}
	public String ListCommentOptions = "//p[contains(text(),'$')]/parent::div[1][starts-with(@class,'commentText')]/preceding-sibling::div[starts-with(@class,'userInfo')]/time/following-sibling::div/descendant::ul[@role='menu']/li/a";

	public List<WebElement> iterateSearchHeaderFindColList(String col) {
		List<WebElement> s = null;
		int j = ColIdentify(col);
		int y = j + 1;
		String x = "p-table table td:nth-child(" + j + ")";
		s = lavanteUtils.driver.findElements(By.cssSelector(x));
		if (col.contains("NCH deduction #")) {

			x = "p-table table td:nth-child(" + j + ") a";
			s = lavanteUtils.driver.findElements(By.cssSelector(x));
		}
		return s;
	}
	
	
	
	public void searchNCH(LinkedHashMap<String, String> dataMap) {
		fillSearchdetails(dataMap);
		formAction(dataMap);

	}
	

	public void formAction(LinkedHashMap<String, String> dataMap) {
		if (dataMap.containsKey("Search")) {
			lavanteUtils.click(searchBtn);
		}
		if (dataMap.containsKey("Clear")) {
			lavanteUtils.click(clearBtn);
		}
		
	}

	
	public int ColIdentify(String col) {
		int ki = 0;
		boolean found = false;
		lavanteUtils.fluentwait(Headers.get(0));
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
			/*
			 * Reporter.log(
			 * "Col name not found,Will be trying with Other Column," + col,
			 * found); ColIdentify("Pending");
			 */
			Assert.assertTrue(found, "Col name not found" + col);
		}
		return ki;

	}
	private void fillSearchdetails(LinkedHashMap<String, String> dataMap) {
		if (dataMap.containsKey("NCHDeduction")) {
			lavanteUtils.typeinEdit(dataMap.get("NCHDeduction"), nchDeductionNumber);
		}
		
		if (dataMap.containsKey("NCHInvoice")) {
			lavanteUtils.typeinEdit(dataMap.get("NCHInvoice"), nchInvoiceNumber);
		}
		if (dataMap.containsKey("NCHManufacturer")) {
			//Text Field
			lavanteUtils.typeinEdit(dataMap.get("NCHManufacturer"), nchManufacturerNumber);
		}
		if (dataMap.containsKey("NCHManufacturerName")) {
			//Text Field
			lavanteUtils.typeinEdit(dataMap.get("NCHManufacturerName"), nchManufacturerName);
		}
		if (dataMap.containsKey("SupplierERPID")) {
			//Text Field
			lavanteUtils.typeinEdit(dataMap.get("SupplierERPID"), supplierErpId);
		}
		if (dataMap.containsKey("SupplierName")) {
			//Text Field
			lavanteUtils.typeinEdit(dataMap.get("SupplierName"), supplierName);
		}
		if (dataMap.containsKey("NCHInvoiceDate")) {
			//Date Range field
			
		}
		if (dataMap.containsKey("ReportDate")) {
			//Date range field
			
		}
		if (dataMap.containsKey("TotalDeductionAmount")) {
			//Text Field
			lavanteUtils.typeinEdit(dataMap.get("TotalDeductionAmount"), totalDeductionAmount);
		}
		if (dataMap.containsKey("AdjustmentCode")) {
			//Text Field
			lavanteUtils.typeinEdit(dataMap.get("AdjustmentCode"), adjustmentCode);
		}
		if (dataMap.containsKey("AdjustmentDescription")) {
			//Text Field
			lavanteUtils.typeinEdit(dataMap.get("AdjustmentDescription"), adjustmentDescription);
		}
		
	}
  
	

}
