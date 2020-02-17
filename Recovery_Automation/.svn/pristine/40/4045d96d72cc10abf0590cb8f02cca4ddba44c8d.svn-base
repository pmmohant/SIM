package com.lavante.recovery.pageobjects.Audit.ContactEntry;

import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import com.lavante.recovery.Common.Util.LavanteUtils;

/**
 * @author Nagappa Date - 09/08/2017 This class is to capture page objects of
 *         Contact Entry
 *
 */
public class AuditContactEntryPage {

	LavanteUtils lavanteUtils = new LavanteUtils();
	public WebDriver driver = null;

	public AuditContactEntryPage(WebDriver driver) {
		lavanteUtils.driver = driver;
	}

	@FindBy(css = "[id='supplier-queue-table'] span")
	private WebElement docQueueSpan;

	public WebElement docQueueSpan() {
		return docQueueSpan;
	}

	// WebElements
	// Contact Entry Link
	@FindBy(css = "[href*='dataentry']")
	private WebElement contactEntryLink;

	public WebElement contactEntryLink() {
		return contactEntryLink;
	}

	// Audit choosen from the main ddl
	@FindBy(css = "div[id='audit_chosen'] a span")
	private WebElement choosenAudit;

	public WebElement choosenAudit() {
		return choosenAudit;
	}

	// validate supplier pop up
	@FindBy(css = ".validateUID td label")
	private WebElement supPopUp;

	public WebElement supPopUp() {
		return supPopUp;
	}

	// Entry field for keying in the LavateID to validate
	@FindBy(id = "validate-lavanteuid")
	private WebElement supPopUpLavanteID;

	public WebElement supPopUpLavanteID() {
		return supPopUpLavanteID;
	}

	@FindBy(id = "validate-lavanteuid")
	private List<WebElement> supPopUpLavanteID1;

	public List<WebElement> supPopUpLavanteID1() {
		return supPopUpLavanteID1;
	}

	// Validate button
	@FindBy(name = "btnValidate")
	private WebElement supPopUpValidateBtn;

	public WebElement supPopUpValidateBtn() {
		return supPopUpValidateBtn;
	}

	// #queue-navigation tbody tr
	@FindBy(css = "#queue-navigation tbody tr")
	private List<WebElement> docQueueTable;

	public List<WebElement> docQueueTable() {
		return docQueueTable;
	}

	// Supplier table rows
	@FindBy(css = "#queue-navigation tbody tr")
	private List<WebElement> docQueueTableRows;

	public List<WebElement> docQueueTableRows() {
		return docQueueTableRows;
	}

	// Supplier name from Document queue table
	@FindBy(css = "#queue-navigation td:nth-child(1)")
	private List<WebElement> docQueueSuppName;

	public List<WebElement> docQueueSuppName() {
		return docQueueSuppName;
	}

	// Spend rank from Document queue table
	@FindBy(css = "#queue-navigation tr:nth-child(1) td:nth-child(5)")
	private List<WebElement> docQueueSpendRank;

	public List<WebElement> docQueueSpendRank() {
		return docQueueSpendRank;
	}

	// Pages from Document queue table
	@FindBy(css = "#queue-navigation tr:nth-child(1) td:nth-child(6)")
	private List<WebElement> docQueuePages;

	public List<WebElement> docQueuePages() {
		return docQueuePages;
	}

	// supplier lookup input
	@FindBy(css = "input[id='fix-ocr-sup-name']")
	private WebElement suppLookupText;

	public WebElement suppLookupText() {
		return suppLookupText;
	}

	// Supplier details - name and Spend rank
	@FindBy(css = "span[ng-bind*='supplierName']")
	private WebElement supName;

	public WebElement supName() {
		return supName;
	}

	@FindBy(css = "span[ng-bind*='rank']")
	private WebElement spendRank;

	public WebElement spendRank() {
		return spendRank;
	}

	// supplier lookup button
	@FindBy(css = "button[id='fix-ocr-sup-name']")
	private WebElement suppLookupBtn;

	public WebElement suppLookupBtn() {
		return suppLookupBtn;
	}

	// Fix OCR button
	@FindBy(css = "[class*='fix-ocr-save']")
	private WebElement fixOcrBtn;

	public WebElement fixOcrBtn() {
		return fixOcrBtn;
	}

	// Lavante id from UI
	@FindBy(css = "td[ng-bind*='supplierId']")
	private WebElement lavanteId;

	public WebElement lavanteId() {
		return lavanteId;
	}

	// type of audit
	@FindBy(css = "td[ng-bind*='audit']")
	private WebElement audit;

	public WebElement audit() {
		return audit;
	}

	// number of statements.pages
	@FindBy(css = "td[ng-bind*='supplier_details[0].pages']")
	private WebElement stmtPages;

	public WebElement stmtPages() {
		return stmtPages;
	}

	// supplier contact details:
	// contact name
	@FindBy(css = "td[ng-bind*='contactName']")
	private WebElement contactName;

	public WebElement contactName() {
		return contactName;
	}

	// contact phone
	@FindBy(css = "td[ng-bind*='contactPhone']")
	private WebElement contactPhone;

	public WebElement contactPhone() {
		return contactPhone;
	}

	// contact extension
	@FindBy(css = "td[ng-bind*='extension']")
	private WebElement contactExtension;

	public WebElement contactExtension() {
		return contactExtension;
	}

	// contact email
	@FindBy(css = "td[ng-bind*='email']")
	private WebElement contactEmail;

	public WebElement contactEmail() {
		return contactEmail;
	}

	// contact fax
	@FindBy(css = "td[ng-bind*='contactFax']")
	private WebElement contactFax;

	public WebElement contactFax() {
		return contactFax;
	}

	// supplier Edit details:
	// edit name
	@FindBy(css = "input[ng-model*='contactName']")
	private WebElement editName;

	public WebElement editName() {
		return editName;
	}

	// edit phone
	@FindBy(css = "input[ng-model*='contactPhone']")
	private WebElement editPhone;

	public WebElement editPhone() {
		return editPhone;
	}

	// edit extension
	@FindBy(css = "input[ng-model*='extension']")
	private WebElement editExtension;

	public WebElement editExtension() {
		return editExtension;
	}

	// edit email
	@FindBy(css = "input[ng-model*='email']")
	private WebElement editEmail;

	public WebElement editEmail() {
		return editEmail;
	}

	// edit fax
	@FindBy(css = "input[ng-model*='contactFax']")
	private WebElement editFax;

	public WebElement editFax() {
		return editFax;
	}

	// Save button
	@FindBy(css = "#save-button")
	private WebElement saveBtn;

	public WebElement saveBtn() {
		return saveBtn;
	}

	// Next button
	@FindBy(css = "#next-button")
	private WebElement nextBtn;

	public WebElement nextBtn() {
		return nextBtn;
	}

	// Previous button
	@FindBy(css = "#previous-button")
	private WebElement previousBtn;

	public WebElement previousBtn() {
		return previousBtn;
	}

	// Save and Dispose button
	@FindBy(css = "#save-dispose-button")
	private WebElement saveAndDisposeBtn;

	public WebElement saveAndDisposeBtn() {
		return saveAndDisposeBtn;
	}

	// Review button
	@FindBy(css = "#need-review-button")
	private WebElement reviewBtn;

	public WebElement reviewBtn() {
		return reviewBtn;
	}

	// Review comment text box
	@FindBy(css = "#needs-review-comment-textarea")
	private WebElement commentTxtBox;

	public WebElement commentTxtBox() {
		return commentTxtBox;
	}

	// Submit button from Review pop up
	@FindBy(id = "save-button")
	private WebElement reviewSubmit;

	public WebElement reviewSubmit() {
		return reviewSubmit;
	}

	// Cancel button from Review pop up
	@FindBy(id = "reset-button")
	private WebElement reviewCancel;

	public WebElement reviewCancel() {
		return reviewCancel;
	}

	// Methods
	// Click on Contact Entry tab
	public void clickContactEntry() {
		lavanteUtils.click(contactEntryLink);
		lavanteUtils.fluentwait(contactEntryLink);
	}

	public void validatePopup(LinkedHashMap<String, String> dataMap) {
		lavanteUtils.fluentwait(docQueueSpan);
		String docspan = docQueueSpan.getText().trim();
		String count = "";
		if (docspan.contains("Document Queue")) {
			String[] dsa = docspan.split("\\(");
			System.out.println("DSA: " + dsa);
			count = dsa[1];
			System.out
					.println("count: " + count + " length: " + count.length());
		}
		System.out.println("Count Validate: " + count + "doc span: " + docspan);
		if (count.length() > 1) {
			if (dataMap.containsKey("validate")) {
				lavanteUtils.fluentwait(lavanteId);
				String x = lavanteId.getText().toString();
				// System.out.println("In validation step: " +
				// supPopUpLavanteID.isDisplayed() + " id: " + x );
				lavanteUtils.waitForTime(4000);
				if (supPopUpLavanteID1.size() > 0) {
					if (x.length() > 0) {
						System.out.println("Enter lavante id and validate: "
								+ x);
						lavanteUtils.typeString(x, supPopUpLavanteID);
						lavanteUtils.click(supPopUpValidateBtn);
					} else {
						lavanteUtils.typeString(Keys.ESCAPE, supPopUpLavanteID);
					}
				}
			}
		} 
	}

	public String SelectSupplier(LinkedHashMap<String, String> dataMap) {
		String actSupName = "";
		String actSpendRank = "";
		String actPages = "";

		String docspan = docQueueSpan.getText().trim();
		String count = "";
		if (docspan.contains("Document Queue")) {
			String[] dsa = docspan.split("\\(");
			System.out.println("DSA: " + dsa);
			count = dsa[1];
			System.out
					.println("count: " + count + " length: " + count.length());
		}
		System.out.println("Count select: " + count + "doc span: " + docspan);
		if (count.length() > 1) {
			System.out.println("Printing the first Element --> "
					+ docQueueSuppName.get(0).getText());
			if (dataMap.containsKey("SuppName")) {
				String data = dataMap.get("SuppName");

				if (data.equalsIgnoreCase("ANY")) {
					actSupName = docQueueSuppName.get(0).getText();
					actSpendRank = docQueueSpendRank.get(0).getText();
					actPages = docQueuePages.get(0).getText();
					lavanteUtils.click(docQueueSuppName.get(0));
				} else {
					List<WebElement> listOfSuppNameRows = docQueueTableRows;
					for (int i = 0; i < listOfSuppNameRows.size(); i++) {
						// List<WebElement> listColumns =
						// listOfSuppNameRows.get(i).findElements(By.tagName("td"));
						// actSupName = listColumns.get(0).getText().trim();
						actSupName = docQueueSuppName.get(i).getText();
						System.out.println("Actual: " + actSupName + " Data: "
								+ data);
						if (actSupName.equalsIgnoreCase(data)) {
							actSpendRank = docQueueSpendRank.get(i).getText();
							actPages = docQueuePages.get(i).getText();
							/*
							 * actSpendRank =
							 * listColumns.get(4).getText().trim(); actPages =
							 * listColumns.get(5).getText().trim();
							 */
							lavanteUtils.click(docQueueSuppName.get(i));
							Reporter.log("Clicked on the | Supplier Name | Link successfully");
							break;
						} else {
							Reporter.log("Did not click on the | Supplier Name |");
						}
					}

				}
			}

			validatePopup(dataMap);
		}

		return actSupName + "#" + actSpendRank + "#" + actPages;
	}

	public void contactEntry(LinkedHashMap<String, String> dataMap) {
		fillContactEntry(dataMap);
		formContactEntry(dataMap);
	}

	private void fillContactEntry(LinkedHashMap<String, String> dataMap) {
		if (dataMap.containsKey("ContactName")) {
			lavanteUtils.typeString(dataMap.get("ContactName"), editName);
		}
		if (dataMap.containsKey("ContactPhone")) {
			lavanteUtils.typeString(dataMap.get("ContactPhone"), editPhone);
		}
		if (dataMap.containsKey("ContactExtension")) {
			lavanteUtils.typeString(dataMap.get("ContactExtension"),
					editExtension);
		}
		if (dataMap.containsKey("ContactEmail")) {
			lavanteUtils.typeString(dataMap.get("ContactEmail"), editEmail);
		}
		if (dataMap.containsKey("ContactFax")) {
			lavanteUtils.typeString(dataMap.get("ContactFax"), editFax);
		}
	}

	private void formContactEntry(LinkedHashMap<String, String> dataMap) {
		if (dataMap.containsKey("Save")) {
			lavanteUtils.click(saveBtn);
			validatePopup(dataMap);
		}
		if (dataMap.containsKey("SaveDispose")) {
			lavanteUtils.click(saveAndDisposeBtn);
		}

	}
}
