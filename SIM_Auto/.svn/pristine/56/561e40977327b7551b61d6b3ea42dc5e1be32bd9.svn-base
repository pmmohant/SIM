
package com.lavante.sim.customer.pageobjects.Compliance.OIG;

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
public class OIGDetails {

	LavanteUtils lavanteUtils = new LavanteUtils();

	@FindBy(css="a[href*='customerOIG.lvp']")
	private WebElement OIGlink;
	public WebElement OIGlink(){
		return OIGlink;
	}
	
	public OIGDetails(WebDriver driver) {
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

	@FindBy(css="label[for*='All']")
	private WebElement filterBYALL;

	public WebElement filterBYALL() {
		return filterBYALL;
	}

	@FindBy(css="label[for*='Awaiting Check']")
	private WebElement filterBYAwaiting;

	public WebElement filterBYAwaiting() {
		return filterBYAwaiting;
	}

	@FindBy(css="label[for*='No Match']")
	private WebElement filterBYNoMatch;

	public WebElement filterBYNoMatch() {
		return filterBYNoMatch;
	}

	@FindBy(css="label[for*='Requires Disposition']")
	private WebElement filterByRequiredis;

	public WebElement filterByRequiredis() {
		return filterByRequiredis;
	}

	@FindBy(css="label[for*='Overridden']")
	private WebElement filterByOverridden;

	public WebElement filterByOverridden() {
		return filterByOverridden;
	}

	@FindBy(css="label[for*='Deactivated']")
	private WebElement filterByDeactivated;

	public WebElement filterByDeactivated() {
		return filterByDeactivated;
	}

	@FindBy(css="label[for*='showDeactivatedSuppliers']")
	private WebElement showDeactivatedSuppliers;

	public WebElement showDeactivatedSuppliers() {
		return showDeactivatedSuppliers;
	}
	
	@FindBy(css="input[name*='showDeactivatedSuppliers']")
	private WebElement InputshowDeactivatedSuppliers;

	public WebElement InputshowDeactivatedSuppliers() {
		return InputshowDeactivatedSuppliers;
	}

	@FindBy(id="supplierSearchOIG")
	private WebElement searchbtn;

	public WebElement searchbtn() {
		return searchbtn;
	}

	// Table Data

	@FindBy(css="[type*='radio'][name*='relationShipID']")
	private List<WebElement> ListRadiobtn;

	public List<WebElement> ListRadiobtn() {
		return ListRadiobtn;
	}

	@FindBy(css="a[href*='viewCompany']")
	private List<WebElement> ListSupplier;

	public List<WebElement> ListSupplier() {
		return ListSupplier;
	}

	@FindBy(css="#supplier_oig tbody:nth-child(2) td:nth-child(1)")
	private WebElement OFACReason;

	public WebElement OFACReason() {
		return OFACReason;
	}

	@FindBy(css="#table_ofac tbody:nth-child(2) td:nth-child(2)")
	private WebElement OFACFirstName;

	public WebElement OFACFirstName() {
		return OFACFirstName;
	}

	@FindBy(css="#table_ofac tbody:nth-child(2) td:nth-child(3)")
	private WebElement OFACLastName;

	public WebElement OFACLastName() {
		return OFACLastName;
	}

	@FindBy(css="#table_ofac tbody:nth-child(2) td:nth-child(4)")
	private WebElement OFACAlsoknwn;

	public WebElement OFACAlsoknwn() {
		return OFACAlsoknwn;
	}

	@FindBy(id="oigDeactivate")
	private WebElement deactivatebtn;

	public WebElement deactivatebtn() {
		return deactivatebtn;
	}

	@FindBy(id="oigOverride")
	private WebElement overridebtn;

	public WebElement overridebtn() {
		return overridebtn;
	}

	@FindBy(css="[class*='dialog'] [class*='primary']")
	private WebElement OKbtn;

	public WebElement OKbtn() {
		return OKbtn;
	}

	@FindBy(css="a[class*='expandAll']")
	private WebElement expandall;

	public WebElement expandall() {
		return expandall;
	}

	// DEACTIVATE

	@FindBy(css="iframe[src*='overrideDeactivate']")
	private WebElement IFRAMEDeactivate;

	public WebElement IFRAMEDeactivate() {
		return IFRAMEDeactivate;
	}

	@FindBy(id="oigNote")
	private WebElement oigNote;

	public WebElement oigNote() {
		return oigNote;
	}

	@FindBy(id="saveOIGNote")
	private WebElement saveOIGNote;

	public WebElement saveOIGNote() {
		return saveOIGNote;
	}

	// OVERRIDE

	public void searchSupplier(LinkedHashMap<String, String> dataMap) throws Exception {
		lavanteUtils.fluentwait(searchbtn);
		fillSearch(dataMap);
		lavanteUtils.click(searchbtn);
		lavanteUtils.fluentwait(searchbtn);
	}

	public void fillSearch(LinkedHashMap<String, String> dataMap) throws Exception {

		lavanteUtils.fluentwait(filterBYALL);

		if (dataMap.containsKey("FilterBY")) {
			lavanteUtils.waitForTime(5000);
			String data = dataMap.get("FilterBY");
			if (data.equalsIgnoreCase("All")) {
				lavanteUtils.click(filterBYALL);
			} else if (data.contains("Awaiting")) {
				lavanteUtils.click(filterBYAwaiting);
			} else if (data.contains("NoMatch")) {
				lavanteUtils.click(filterBYNoMatch);

			} else if (data.contains("Disposition")) {
				lavanteUtils.click(filterByRequiredis);

			} else if (data.contains("Override")) {
				lavanteUtils.click(filterByOverridden);

			} else if (data.contains("Deactivated")) {
				lavanteUtils.click(filterByDeactivated);
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
			}
			lavanteUtils.fluentwait(searchbtn);

		}
		if (dataMap.containsKey("supplierName")) {
			lavanteUtils.typeString(dataMap.get("supplierName"), supplrnametxt());
		}

	}

	public void formAction(LinkedHashMap<String, String> dataMap) {

		if (ListRadiobtn.size() > 0) {
			lavanteUtils.click(ListRadiobtn.get(0));

			if (dataMap.containsKey("Override")) {
				lavanteUtils.click(overridebtn);
				lavanteUtils.switchtoFrame(IFRAMEDeactivate);
				lavanteUtils.typeinEdit(dataMap.get("Override"), oigNote);
				lavanteUtils.click(saveOIGNote);
				lavanteUtils.switchtoFrame(null);

			}
			if (dataMap.containsKey("Deactivate")) {
				lavanteUtils.click(deactivatebtn);
				lavanteUtils.fluentwait(OKbtn);
				lavanteUtils.click(OKbtn);
				lavanteUtils.switchtoFrame(IFRAMEDeactivate);
				lavanteUtils.typeinEdit(dataMap.get("Deactivate"), oigNote);
				lavanteUtils.click(saveOIGNote);
				lavanteUtils.switchtoFrame(null);

			}
		}

	}

}
