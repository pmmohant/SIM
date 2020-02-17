
package com.lavante.sim.customer.pageobjects.Compliance.LegalID;

import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.lavante.sim.Common.Util.LavanteUtils;

/**
 * @author Piramanayagam.S data 29-09-2016
 */
public class LegalID {

	LavanteUtils lavanteUtils = new LavanteUtils();

	public LegalID(WebDriver driver) {
		lavanteUtils.driver = driver;
	}
	
	@FindBy(css="[class*='cap'] span")
	private WebElement rcrdCount;

	public WebElement rcrdCount() {
		return rcrdCount;
	}

	@FindBy(id="searchFilter")
	private WebElement supplrnametxt;

	public WebElement supplrnametxt() {
		return supplrnametxt;
	}

	@FindBy(css="[id*='supplierLocation']")
	private WebElement supplrlocatindpdn;

	public WebElement supplrlocatindpdn() {
		return supplrlocatindpdn;
	}
	
	@FindBy(css="[id='supplierLocation']")
	private WebElement supplrlocatindpdn1;

	public WebElement supplrlocatindpdn1() {
		return supplrlocatindpdn1;
	}
	

	@FindBy(css="label[for*='All']")
	private WebElement filterBYALL;

	public WebElement filterBYALL() {
		return filterBYALL;
	}

	@FindBy(css="label[for*='With Legal ID']")
	private WebElement filterByWithLegalID;

	public WebElement filterByWithLegalID() {
		return filterByWithLegalID;
	}

	@FindBy(css="label[for*='No Legal ID']")
	private WebElement filterByNoLegalID;

	public WebElement filterByNoLegalID() {
		return filterByNoLegalID;
	}

	@FindBy(css="label[for*='Auto Validated']")
	private WebElement filterByAutovalid;

	public WebElement filterByAutovalid() {
		return filterByAutovalid;
	}

	@FindBy(css="label[for*='Auto Passed']")
	private WebElement filterByAutoPassed;

	public WebElement filterByAutoPassed() {
		return filterByAutoPassed;
	}

	@FindBy(css="label[for*='Mismatch']")
	private WebElement filterByMismatch;

	public WebElement filterByMismatch() {
		return filterByMismatch;
	}

	@FindBy(css="label[for*='Pending Validation']")
	private WebElement filterByPendingValidation;

	public WebElement filterByPendingValidation() {
		return filterByPendingValidation;
	}

	@FindBy(css="label[for*='Manually Validated']")
	private WebElement filterByManuallyValidated;

	public WebElement filterByManuallyValidated() {
		return filterByManuallyValidated;
	}
	
	@FindBy(css="label[for*='Cannot Be Validated']")
	private WebElement filterByCannotBeValidated;

	public WebElement filterByCannotBeValidated() {
		return filterByCannotBeValidated;
	}

	@FindBy(css="label[for*='Not Provided']")
	private WebElement filterByNotProvided;

	public WebElement filterByNotProvided() {
		return filterByNotProvided;
	}

	@FindBy(css="label[for*='Unknown']")
	private WebElement filterByUnknown;

	public WebElement filterByUnknown() {
		return filterByUnknown;
	}

	@FindBy(css="label[for*='showDeactivatedSuppliers']")
	private WebElement showDeactivatedSuppliers;

	public WebElement showDeactivatedSuppliers() {
		return showDeactivatedSuppliers;
	}
	
	@FindBy(css="label[for*='showDeactivatedSuppliers']")
	private WebElement InputshowDeactivatedSuppliers;

	public WebElement InputshowDeactivatedSuppliers() {
		return InputshowDeactivatedSuppliers;
	}
	
	@FindBy(id="searchFilter")
	private WebElement searchtxt;

	public WebElement searchtxt() {
		return searchtxt;
	}

	@FindBy(id="supplierSearch")
	private WebElement searchbtn;

	public WebElement searchbtn() {
		return searchbtn;
	}

	// Table Data
	@FindBy(css=".caption span:nth-child(1)")
	private WebElement searchCount;

	public WebElement searchCount() {
		return searchCount;
	}

	@FindBy(css="#supplier_legalID>tbody td:nth-child(1)")
	private List<WebElement> ListSelectSupp;

	public List<WebElement> ListSelectSupp() {
		return ListSelectSupp;
	}

	@FindBy(css="a[href*='viewCompany']")
	private List<WebElement> ListSupplier;

	public List<WebElement> ListSupplier() {
		return ListSupplier;
	}

	@FindBy(css="tbody td:nth-child(3)")
	private List<WebElement> ListSupplierLegalName;

	public List<WebElement> ListSupplierLegalName() {
		return ListSupplierLegalName;
	}
	
	@FindBy(css="tbody td:nth-child(5)")
	private List<WebElement> ListSupplierLegalID;
	
	public List<WebElement> ListSupplierLegalID(){
		return ListSupplierLegalID;
	}

	@FindBy(css="tbody td:nth-child(6)")
	private List<WebElement> ListValidCode;

	public List<WebElement> ListValidCode() {
		return ListValidCode;
	}

	@FindBy(css="tbody td:nth-child(7)")
	private List<WebElement> ListProfstatus;

	public List<WebElement> ListProfstatus() {
		return ListProfstatus;
	}

	//Form Action
	@FindBy(css="[id*='markAsValidated']")
	private WebElement overridebtn;

	public WebElement overridebtn() {
		return overridebtn;
	}
	
	//Override
	
	@FindBy(css="iframe[src*='legal']")
	private WebElement IFRAMEOverride;

	public WebElement IFRAMEOverride() {
		return IFRAMEOverride;
	}
	
	@FindBy(id="comment")
	private WebElement overrideComment;

	public WebElement overrideComment() {
		return overrideComment;
	}
	
	@FindBy(css="button[title*='Save']")
	private WebElement savebtn;

	public WebElement savebtn() {
		return savebtn;
	}
	
	
	
	
	
	public void searchSupplier(LinkedHashMap<String, String> dataMap) {
		fillSearch(dataMap);
		lavanteUtils.pressEnterkey("das",searchtxt);
	}

	public void fillSearch(LinkedHashMap<String, String> dataMap) {
		String data="";
		lavanteUtils.Scrollintoview(searchtxt);
		if (dataMap.containsKey("SupplierLocation")) {
			String x=dataMap.get("SupplierLocation");
			if(x.equalsIgnoreCase("CANADA")){
				x="CA";
			}else if(x.equalsIgnoreCase("SWISS")){
				x="CH";
			}
			lavanteUtils.selectbyvalue(x, supplrlocatindpdn);
			lavanteUtils.fluentwait(filterBYALL);
			lavanteUtils.waitForTime(5000);
			lavanteUtils.waitforPageload(searchtxt);
		}
		if (dataMap.containsKey("FilterBY")) {
			data = dataMap.get("FilterBY");
			if (data.equalsIgnoreCase("All")) {
				lavanteUtils.click(filterBYALL);
			} else if (data.equalsIgnoreCase("LegalID")) {
				lavanteUtils.click(filterByWithLegalID);
			} else if (data.equalsIgnoreCase("NoLegalID")) {
				lavanteUtils.click(filterByNoLegalID);
			}
			lavanteUtils.fluentwait(showDeactivatedSuppliers);
			lavanteUtils.waitForTime(5000);
			lavanteUtils.waitforPageload(searchtxt);
		}
		if (dataMap.containsKey("FilterSub")) {
			data = dataMap.get("FilterSub");
			if (data.equalsIgnoreCase("AutoValidated")) {
				lavanteUtils.click(filterByAutovalid);
			}
			if (data.equalsIgnoreCase("AutoPassed")) {
				lavanteUtils.click(filterByAutoPassed);
			}
			if (data.equalsIgnoreCase("Mismatch")) {
				lavanteUtils.click(filterByMismatch);
			}
			if (data.equalsIgnoreCase("CannotBeValidated")) {
				lavanteUtils.click(filterByCannotBeValidated);
			}
			if (data.equalsIgnoreCase("PendingValidation")) {
				lavanteUtils.click(filterByPendingValidation);
			}
			if (data.equalsIgnoreCase("NotProvided")) {
				lavanteUtils.click(filterByNotProvided);
			}
			if (data.equalsIgnoreCase("Unknown")) {
				lavanteUtils.click(filterByUnknown);
			}
			if (data.equalsIgnoreCase("ManuallyValidated")) {
				lavanteUtils.click(filterByManuallyValidated);
			}
			lavanteUtils.fluentwait(searchtxt);
			lavanteUtils.waitForTime(5000);
			lavanteUtils.waitforPageload(searchtxt);
		}

		if (dataMap.containsKey("ShowInactive")) {
			data = dataMap.get("ShowInactive");
			lavanteUtils.fluentwait(showDeactivatedSuppliers);
			String x=InputshowDeactivatedSuppliers.getAttribute("Checked");
			if ("yes".equalsIgnoreCase(data)) {
				if(x==null){
					lavanteUtils.click(showDeactivatedSuppliers);
				}
			} else if ("NO".equalsIgnoreCase(data)) {
				if(x!=null){
					lavanteUtils.click(showDeactivatedSuppliers);
				}
			}
			lavanteUtils.fluentwait(searchtxt);
			lavanteUtils.waitForTime(5000);
		}

		if (dataMap.containsKey("supplierName")) {
			lavanteUtils.typeString(dataMap.get("supplierName"), supplrnametxt);
		}
		lavanteUtils.waitForTime(5000);
		
	}

	public void formAction(LinkedHashMap<String, String> dataMap) {

		if (ListSupplier.size() > 0) {
			lavanteUtils.selectChkBox(ListSelectSupp.get(0), "YES");

			if (dataMap.containsKey("Override")) {
				  lavanteUtils.click(overridebtn);
				  lavanteUtils.switchtoFrame(IFRAMEOverride);
				  lavanteUtils.typeinEdit(dataMap.get("Override"), overrideComment);
				  
				  lavanteUtils.click(savebtn);
			}
			if (dataMap.containsKey("Deactivate")) {
				/*
				 * lavanteUtils.click(deactivatebtn);
				 * lavanteUtils.fluentwait(OKbtn); lavanteUtils.click(OKbtn);
				 * lavanteUtils.switchtoFrame(IFRAMEDeactivate);
				 * lavanteUtils.typeinEdit(dataMap.get("Deactivate"), ofacNote);
				 * lavanteUtils.click(saveOfacNote);
				 * lavanteUtils.switchtoFrame(null);
				 */

			}
		}
		lavanteUtils.switchtoFrame(null);
	}

}
