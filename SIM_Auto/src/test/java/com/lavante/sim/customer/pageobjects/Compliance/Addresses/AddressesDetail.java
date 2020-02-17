
package com.lavante.sim.customer.pageobjects.Compliance.Addresses;

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
public class AddressesDetail {

	LavanteUtils lavanteUtils = new LavanteUtils();

	public AddressesDetail(WebDriver driver) {
		lavanteUtils.driver = driver;
	}

	@FindBy(how = How.CSS, using = "[class*='cap'] span")
	private WebElement rcrdCount;

	public WebElement rcrdCount() {
		return rcrdCount;
	}

	@FindBy(id="searchFilter")
	private WebElement supplrnametxt;

	public WebElement supplrnametxt() {
		return supplrnametxt;
	}

	@FindBy(how = How.CSS, using = "[id*='supplierLocation'] a")
	private WebElement supplrlocatindpdn;

	public WebElement supplrlocatindpdn() {
		return supplrlocatindpdn;
	}

	@FindBy(css="label[for*='All']")
	private WebElement filterBYALL;

	public WebElement filterBYALL() {
		return filterBYALL;
	}

	@FindBy(css="label[for*='Valid']")
	private WebElement filterBYValid;

	public WebElement filterBYValid() {
		return filterBYValid;
	}

	@FindBy(css="label[for*='Invalid']")
	private WebElement filterBYinValid;

	public WebElement filterBYinValid() {
		return filterBYinValid;
	}

	@FindBy(css="label[for*='Pending']")
	private WebElement filterByPending;

	public WebElement filterByPending() {
		return filterByPending;
	}
	
	@FindBy(css="label[for*='Cannot be validated']")
	private WebElement filterByCantValidate;

	public WebElement filterByCantValidate() {
		return filterByPending;
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

	@FindBy(id="supplierSearch")
	private WebElement searchbtn;

	public WebElement searchbtn() {
		return searchbtn;
	}

	// Table Data

	@FindBy(how = How.CSS, using = "a[href*='viewCompany']")
	private List<WebElement> ListSupplier;

	public List<WebElement> ListSupplier() {
		return ListSupplier;
	}

	@FindBy(how = How.CSS, using = "tbody td:nth-child(4)")
	private List<WebElement> ListAddress1;

	public List<WebElement> ListAddress1() {
		return ListAddress1;
	}

	@FindBy(how = How.CSS, using = "tbody td:nth-child(5)")
	private List<WebElement> Listcity;

	public List<WebElement> Listcity() {
		return Listcity;
	}

	@FindBy(how = How.CSS, using = "tbody td:nth-child(6)")
	private List<WebElement> ListState;

	public List<WebElement> ListState() {
		return ListState;
	}

	@FindBy(how = How.CSS, using = "tbody td:nth-child(7)")
	private List<WebElement> ListPostalCode;

	public List<WebElement> ListPostalCode() {
		return ListPostalCode;
	}

	@FindBy(how = How.CSS, using = "tbody td:nth-child(8)")
	private List<WebElement> ListCountry;

	public List<WebElement> ListCountry() {
		return ListCountry;
	}

	public void searchSupplier(LinkedHashMap<String, String> dataMap) throws Exception {
		lavanteUtils.fluentwait(searchbtn);
		fillSearch(dataMap);
		lavanteUtils.click(searchbtn);
	}

	public void fillSearch(LinkedHashMap<String, String> dataMap) throws Exception {
		lavanteUtils.fluentwait(filterBYALL);
		if (dataMap.containsKey("SupplierLocation")) {
			lavanteUtils.fluentwait(supplrlocatindpdn);
			lavanteUtils.click(supplrlocatindpdn);
			lavanteUtils.selectFrmDpdn(dataMap.get("SupplierLocation"));
		}
		if (dataMap.containsKey("FilterBY")) {
			lavanteUtils.waitForTime(5000);
			String data = dataMap.get("FilterBY");
			if (data.equalsIgnoreCase("ALL")) {
				lavanteUtils.fluentwait(filterBYALL);
				lavanteUtils.click(filterBYALL);
			} else if (data.equalsIgnoreCase("Valid")) {
				lavanteUtils.fluentwait(filterBYValid);
				lavanteUtils.click(filterBYValid);
			} else if (data.equalsIgnoreCase("Invalid")) {
				lavanteUtils.fluentwait(filterBYinValid);
				lavanteUtils.click(filterBYinValid);
			} else if (data.equalsIgnoreCase("Pending")) {
				lavanteUtils.fluentwait(filterByPending);
				lavanteUtils.click(filterByPending);
			} else if (data.equalsIgnoreCase("CantValidate")) {
				lavanteUtils.fluentwait(filterByCantValidate);
				lavanteUtils.click(filterByCantValidate);
			}

			if (dataMap.containsKey("ShowInactive")) {
				data = dataMap.get("ShowInactive");
				lavanteUtils.fluentwait(showDeactivatedSuppliers());
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
			lavanteUtils.fluentwait(supplrnametxt);
			lavanteUtils.typeString(dataMap.get("supplierName"), supplrnametxt());
		}

	}

}
