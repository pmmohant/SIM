package com.lavante.recovery.pageobjects.Dashboard;

import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import com.lavante.recovery.Common.Util.LavanteUtils;
import com.lavante.recovery.pageobjects.HomePage;

/**
 * @author Nagappa This class is to capture page objects of Compliance tab from
 *         Dashboard home page
 *
 */
public class CompliancePage {
	LavanteUtils lavanteUtils = new LavanteUtils();	
	public WebDriver driver = null;
	
	public CompliancePage(WebDriver drivers) {
		lavanteUtils.driver = drivers;
		driver=lavanteUtils.driver;
	}

	// Compliant tab
	@FindBy(css = "a[href='#Compliant']")
	private WebElement complaintTab;

	public WebElement complaintTab() {
		return complaintTab;
	}

	// Non-Compliant tab
	@FindBy(css = "a[href='#NonCompliant']")
	private WebElement nonComplaintTab;

	public WebElement nonComplaintTab() {
		return nonComplaintTab;
	}

	// Table Compliant- Supplier name
	@FindBy(css = "[id='Compliant'] a[href*='supplierdetail']")
	private List<WebElement> compSuppName;

	public List<WebElement> compSuppName() {
		return compSuppName;
	}

	// Table Compliant- Spend Rank
	@FindBy(css = "[id='Compliant'] tbody tr td:nth-child(2)")
	private List<WebElement> compSpendRank;

	public List<WebElement> compSpendRank() {
		return compSpendRank;
	}

	// Table Non-Compliant- Supplier name
	@FindBy(css = "[id='NonCompliant'] a[href*='supplierdetail']")
	private List<WebElement> nonCompSuppName;

	public List<WebElement> nonCompSuppName() {
		return nonCompSuppName;
	}

	// Table Non-Compliant- Spend Rank
	@FindBy(css = "[id='NonCompliant'] tbody tr td:nth-child(2)")
	private List<WebElement> nonCompSpendRank;

	public List<WebElement> nonCompSpendRank() {
		return nonCompSpendRank;
	}

	// Methods
	//click on the Compliance tab
		public void clickComplaintTab() {
			lavanteUtils.click(complaintTab);
		}
	
	//click on the non-Compliance tab
	public void clickNonComplaintTab() {
		lavanteUtils.click(nonComplaintTab);
	}
	
	// The following method to select the supplier from Compliant
	public LinkedHashMap<String, String> selectCompliantSupplier(LinkedHashMap<String, String> dataMap) {
		
		lavanteUtils.click(complaintTab);		
		lavanteUtils.waitForTime(3000);
		LinkedHashMap<String, String> dataMap1=new LinkedHashMap<String, String>();
		dataMap1.put("SuppName", "");
		dataMap1.put("SpendRank", "");
		String actSupName = "";
		String actSpendRank = "";

		System.out.println("Printing the first Element --> "
				+ compSuppName.get(0).getText());
		if (dataMap.containsKey("SuppName")) {
			String data = dataMap.get("SuppName");

			if (data.equalsIgnoreCase("ANY")) {
				actSupName = compSuppName.get(0).getText();
				actSpendRank = compSpendRank.get(0).getText();
				dataMap1.put("SuppName", actSupName);
				dataMap1.put("SpendRank", actSpendRank);
				//lavanteUtils.click(compSuppName.get(0));
				compSuppName.get(0).click();
				lavanteUtils.waitForTime(3000);
			} else {
				for (int i = 0; i < compSuppName.size(); i++) {

					actSupName = compSuppName.get(i).getText();
					System.out.println("Actual: " + actSupName + " Data: "
							+ data);
					if (actSupName.equalsIgnoreCase(data)) {
						actSpendRank = compSpendRank.get(i).getText();
						dataMap1.put("SuppName", actSupName);
						dataMap1.put("SpendRank", actSpendRank);
						lavanteUtils.click(compSuppName.get(i));
						Reporter.log("Clicked on the | Supplier Name | Link successfully");
						break;
					} else {
						Reporter.log("Did not click on the | Supplier Name |");
					}
				}

			}
		}
		return dataMap1;

	}

	// The following method to select the supplier from non-Compliant
	public LinkedHashMap<String, String> selectNonCompliantSupplier(LinkedHashMap<String, String> dataMap) {
		LinkedHashMap<String, String> dataMap1=new LinkedHashMap<String, String>();
		dataMap1.put("SuppName", "");
		dataMap1.put("SpendRank", "");
		String actSupName = "";
		String actSpendRank = "";

		System.out.println("Printing the first Element --> "+ nonCompSuppName.get(0).getText() + "DataMap value: " + dataMap.get("SuppName"));
		if (dataMap.containsKey("SuppName")) {
			String data = dataMap.get("SuppName");

			if (data.equalsIgnoreCase("ANY")) {
				actSupName = nonCompSuppName.get(0).getText();
				actSpendRank = nonCompSpendRank.get(0).getText();
				dataMap1.put("SuppName", nonCompSuppName.get(0).getText());
				dataMap1.put("SpendRank", nonCompSpendRank.get(0).getText());
				System.out.println("DataMap1 : " + dataMap1 );
				lavanteUtils.click(nonCompSuppName.get(0));
			} else {
				for (int i = 0; i < nonCompSuppName.size(); i++) {
					dataMap1.put("SuppName", nonCompSuppName.get(i).getText());
					actSupName = nonCompSuppName.get(i).getText();
					System.out.println("Actual: " + actSupName + " Data: "
							+ data);
					if (actSupName.equalsIgnoreCase(data)) {
						dataMap1.put("SpendRank", nonCompSpendRank.get(i).getText());
						actSpendRank = nonCompSpendRank.get(i).getText();
						lavanteUtils.click(nonCompSuppName.get(i));
						Reporter.log("Clicked on the | Supplier Name | Link successfully");
						break;
					} else {
						Reporter.log("Did not click on the | Supplier Name |");
					}
				}

			}
		}
		return dataMap1;

	}
}
