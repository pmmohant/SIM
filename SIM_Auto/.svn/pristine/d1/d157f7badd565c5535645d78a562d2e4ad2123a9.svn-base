
package com.lavante.sim.customer.pageobjects.Compliance.OFAC;

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
public class OFACDetails {

	LavanteUtils lavanteUtils = new LavanteUtils();

	public OFACDetails(WebDriver driver) {
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

	@FindBy(id="supplierSearchOFAC")
	private WebElement searchbtn;

	public WebElement searchbtn() {
		return searchbtn;
	}

	@FindBy(css="a[class*='expandAll']")
	private WebElement expandall;

	public WebElement expandall() {
		return expandall;
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

	@FindBy(css="#table_ofac tbody:nth-child(2) td:nth-child(1)")
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

	@FindBy(id="ofacDeactivate")
	private WebElement deactivatebtn;

	public WebElement deactivatebtn() {
		return deactivatebtn;
	}

	@FindBy(id="ofacOverride")
	private WebElement overridebtn;

	public WebElement overridebtn() {
		return overridebtn;
	}

	@FindBy(css="[class*='dialog'] [class*='primary']")
	private WebElement OKbtn;

	public WebElement OKbtn() {
		return OKbtn;
	}

	// DEACTIVATE

	@FindBy(css="iframe[src*='overrideDeactivate']")
	private WebElement IFRAMEDeactivate;

	public WebElement IFRAMEDeactivate() {
		return IFRAMEDeactivate;
	}

	@FindBy(id="ofacNote")
	private WebElement ofacNote;

	public WebElement ofacNote() {
		return ofacNote;
	}

	@FindBy(id="saveOfacNote")
	private WebElement saveOfacNote;

	public WebElement saveOfacNote() {
		return saveOfacNote;
	}

	// OVERRIDE

	public void searchSupplier(LinkedHashMap<String, String> dataMap) throws Exception {
		lavanteUtils.fluentwait(searchbtn);
		fillSearch(dataMap);
		lavanteUtils.click(searchbtn);
		lavanteUtils.fluentwait(searchbtn);
	}

	public void fillSearch(LinkedHashMap<String, String> dataMap) throws Exception {

		lavanteUtils.fluentwait(searchbtn);

		if (dataMap.containsKey("FilterBY")) {
			lavanteUtils.waitForTime(5000);
			String data = dataMap.get("FilterBY");
			if (data.equalsIgnoreCase("ALL")) {
				lavanteUtils.fluentwait(filterBYALL);
				lavanteUtils.click(filterBYALL);
			} else if (data.contains("Awaiting")) {
				lavanteUtils.fluentwait(filterBYAwaiting);
				lavanteUtils.click(filterBYAwaiting);
			} else if (data.contains("NoMatch")) {
				lavanteUtils.fluentwait(filterBYNoMatch);
				lavanteUtils.click(filterBYNoMatch);

			} else if (data.contains("Disposition")) {
				lavanteUtils.fluentwait(filterByRequiredis);
				lavanteUtils.click(filterByRequiredis);

			} else if (data.contains("Override")) {
				lavanteUtils.fluentwait(filterByOverridden);
				lavanteUtils.click(filterByOverridden);

			} else if (data.contains("Deactivated")) {
				lavanteUtils.fluentwait(filterByDeactivated);
				lavanteUtils.click(filterByDeactivated);
			}
			if (dataMap.containsKey("ShowInactive")) {
				data = dataMap.get("ShowInactive");
				lavanteUtils.fluentwait(showDeactivatedSuppliers());
				if ("yes".equalsIgnoreCase(data)) {
					lavanteUtils.selectChkBox(showDeactivatedSuppliers, "YES");
					lavanteUtils.selectChkBox(showDeactivatedSuppliers, "YES");
				} else if ("NO".equalsIgnoreCase(data)) {
					lavanteUtils.selectChkBox(showDeactivatedSuppliers, "NO");
					lavanteUtils.selectChkBox(showDeactivatedSuppliers, "NO");
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
				lavanteUtils.typeinEdit(dataMap.get("Override"), ofacNote);
				lavanteUtils.click(saveOfacNote);
				lavanteUtils.switchtoFrame(null);

			}
			if (dataMap.containsKey("Deactivate")) {
				lavanteUtils.click(deactivatebtn);
				lavanteUtils.fluentwait(OKbtn);
				lavanteUtils.click(OKbtn);
				lavanteUtils.switchtoFrame(IFRAMEDeactivate);
				lavanteUtils.typeinEdit(dataMap.get("Deactivate"), ofacNote);
				lavanteUtils.click(saveOfacNote);
				lavanteUtils.switchtoFrame(null);

			}
		}

	}

}
