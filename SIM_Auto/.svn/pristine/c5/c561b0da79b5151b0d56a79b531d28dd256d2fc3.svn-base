package com.lavante.sim.supplier.pageobjects.Agreements;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.lavante.sim.Common.Util.LavanteUtils;

public class CreateCostChangePage {

	LavanteUtils lavanteUtils = new LavanteUtils();

	public CreateCostChangePage(WebDriver driver) {
		lavanteUtils.driver = driver;
	}

	@FindBy(css = "thead th")
	private List<WebElement> Headers;

	@FindBy(css = "div#captionDropdown button[ng-class*='drop']")
	private WebElement CreateNewDropDwn;

	public WebElement CreateNewDropDwn() {
		return CreateNewDropDwn;
	}

	@FindBy(id = "costChangeReference")
	private WebElement CostChangeRefNoTxtBox;

	public WebElement CostChangeRefNoTxtBox() {
		return CostChangeRefNoTxtBox;
	}

	@FindBy(id = "costChangeDescription")
	private WebElement CostChangeDesTxtBox;

	public WebElement CostChangeDesTxtBox() {
		return CostChangeDesTxtBox;
	}

	@FindBy(id = "costChangeDescription")
	private WebElement DivisionMultiSelDropDwn;

	public WebElement DivisionMultiSelDropDwn() {
		return DivisionMultiSelDropDwn;
	}

	@FindBy(id = "effectiveDateType")
	private WebElement EffectiveDateTypeDropDwn;

	public WebElement EffectiveDateTypeDropDwn() {
		return EffectiveDateTypeDropDwn;
	}

	@FindBy(css = "table[class$='selectable'] tbody td:nth-child(1) span[class$='checkbox_image']")
	private List<WebElement> ListItemsCheckBox;

	public List<WebElement> ListItemsCheckBox() {
		return ListItemsCheckBox;
	}

	@FindBy(css = "table[class$='selectable'] tbody td:nth-child(2) input")
	private List<WebElement> ListCaseGTINDescTxtBox;

	public List<WebElement> ListCaseGTINDescTxtBox() {
		return ListCaseGTINDescTxtBox;
	}

	@FindBy(css = "table[class$='selectable'] tbody td:nth-child(4) input")
	private List<WebElement> ListBracketMaxTxtBox;

	public List<WebElement> ListBracketMaxTxtBox() {
		return ListBracketMaxTxtBox;
	}

	@FindBy(css = "table[class$='selectable'] tbody td:nth-child(7) input")
	private List<WebElement> ListNewCostTxtBox;

	public List<WebElement> ListNewCostTxtBox() {
		return ListNewCostTxtBox;
	}

	@FindBy(css = "table[class$='selectable'] tbody td:nth-child(3) input")
	private List<WebElement> ListBracketMinTxtBox;

	public List<WebElement> ListBracketMinTxtBox() {
		return ListNewCostTxtBox;
	}

	@FindBy(css = "table[class$='selectable'] tbody td:nth-child(8) select")
	private List<WebElement> ListCurrencyDropDwn;

	public List<WebElement> ListCurrencyDropDwn() {
		return ListCurrencyDropDwn;
	}

	@FindBy(css = "table[class$='selectable'] tbody td:nth-child(10) span[ng-if$='rowDropDownEnable']")
	private List<WebElement> ListActionsDel;

	public List<WebElement> ListActionsDel() {
		return ListActionsDel;
	}

	@FindBy(partialLinkText = "Add another item")
	private WebElement AddAnoterItemLink;

	public WebElement AddAnoterItemLink() {
		return AddAnoterItemLink;
	}

	@FindBy(css = "div[class$='container']button[type='reset']")
	private WebElement CancelLink;

	public WebElement CancelLink() {
		return CancelLink;
	}

	@FindBy(xpath = "//button[contains(text(),'Save as draft')]")
	private WebElement SaveAsDraftLink;

	public WebElement SaveAsDraftLink() {
		return SaveAsDraftLink;
	}

	@FindBy(xpath = "//button[contains(text(),'Save and submit')]")
	private WebElement SaveAndSubmitBtn;

	public WebElement SaveAndSubmitBtn() {
		return SaveAndSubmitBtn;
	}

	@FindBy(css = "button[class^='button_default']")
	private WebElement ActionDropDwn;

	public WebElement ActionDropDwn() {
		return ActionDropDwn;
	}

	@FindBy(css = "button[class^='button_default']+ul li input")
	private List<WebElement> ActionsMenu;

	public List<WebElement> ActionsMenu() {
		return ActionsMenu;
	}

	@FindBy(css = "li[id='externallilink']")
	private WebElement ViewDetailedSearchResultsLink;

	public WebElement ViewDetailedSearchResultsLink() {
		return ViewDetailedSearchResultsLink;
	}

	@FindBy(css = "//li[@id='externallilink']/parent::ul/tr/td[1]")
	private List<WebElement> ListSearchResult;

	public List<WebElement> ListSearchResult() {
		return ListSearchResult;
	}

	// Pop-up screen
	@FindBy(css = "div[class='slider-content'] input[type='text']")
	private WebElement SearchTxtBox;

	public WebElement SearchTxtBox() {
		return SearchTxtBox;
	}

	@FindBy(css = "span[class^='close_image_black']")
	private WebElement CloseIcon;

	public WebElement CloseIcon() {
		return CloseIcon;
	}

	@FindBy(css = "span[class^='icon_search']")
	private WebElement SearchIcon;

	public WebElement SearchIcon() {
		return SearchIcon;
	}

	@FindBy(css = "div[class='slider-content'] drop-down[class^='dropDownParent']")
	private WebElement PopUPActionsDropDwn;

	public WebElement PopUPActionsDropDwn() {
		return PopUPActionsDropDwn;
	}

	@FindBy(css = "div[class='slider-content'] ul li input")
	private WebElement PopUPAddItems;

	public WebElement PopUPAddItems() {
		return PopUPAddItems;
	}

	String selectItemByCaseGTIN = "//span[contains(text(),'$')]/ancestor::td[1]/preceding-sibling::td[1]/span[1]";

	@FindBy(css = "[id='externallilink'] a")
	private WebElement ViewDetailedSearchResLink;

	public WebElement ViewDetailedSearchResLink() {
		return ViewDetailedSearchResLink;
	}

	// Edit
	@FindBy(css = "[id='bracketMin']")
	private WebElement BracketMinTxtbox;

	public WebElement BracketMinTxtbox() {
		return BracketMinTxtbox;
	}

	@FindBy(css = "[id='bracketMax']")
	private WebElement BracketMaxTxtbox;

	public WebElement BracketMaxTxtbox() {
		return BracketMaxTxtbox;
	}

	@FindBy(css = "form-select[form-reference='appForm'] select[id='uomType']")
	private WebElement UOMTypeDropDwn;

	public WebElement UOMTypeDropDwn() {
		return UOMTypeDropDwn;
	}

	@FindBy(css = "form-select[form-reference='appForm'] select[id='uom']")
	private WebElement UOMDropDwn;

	public WebElement UOMDropDwn() {
		return UOMDropDwn;
	}

	@FindBy(css = "[id='itemListPrice']")
	private WebElement NewCostTxtBox;

	public WebElement NewCostTxtBox() {
		return NewCostTxtBox;
	}

	@FindBy(css = "form-select[form-reference='appForm'] select[id='currency']")
	private WebElement CurrencyDropDwn;

	public WebElement CurrencyDropDwn() {
		return CurrencyDropDwn;
	}

	@FindBy(xpath = "//button[contains(text(),'Apply')]")
	private WebElement ApplyBtn;

	public WebElement ApplyBtn() {
		return ApplyBtn;
	}

	@FindBy(css = "table[class='dpheader'] div[ng-click*='prevMonth']")
	private WebElement PrevMonth;

	@FindBy(css = "table[class='dpheader'] div[class^='dpheadermonthtxt']")
	private WebElement GetMonth;

	@FindBy(css = "table[class='dpheader'] div[ng-click*='nextMonth']")
	private WebElement NextMonth;

	@FindBy(css = "table[class='dpheader'] select")
	private WebElement YearDropDwn;

	@FindBy(css = "table[class='dptable'] tr td span[class='ng-binding dpcurrmonth']")
	private List<WebElement> Date;

	public void createCostChange(LinkedHashMap<String, String> dataMap) {
		lavanteUtils.clicks(CreateNewDropDwn);
		if (dataMap.containsKey("EnterManually")) {
			lavanteUtils.selectvalueFrmDpdnAction("Enter details manually");

			editCostChange(dataMap);
		}
	}

	public void editCostChange(LinkedHashMap<String, String> dataMap) {
		fillHeaderCostChange(dataMap);
		costChangeActions(dataMap);
	}

	public void costChangeActions(LinkedHashMap<String, String> dataMap) {
		lavanteUtils.fluentwait(SaveAndSubmitBtn);
		lavanteUtils.waitForTime(2000);
		if (dataMap.containsKey("Cancel")) {
			lavanteUtils.clicks(CancelLink);
		}
		if (dataMap.containsKey("SaveAsDraft")) {
			lavanteUtils.clicks(SaveAsDraftLink);
		}
		if (dataMap.containsKey("SaveAndSubmit")) {
			lavanteUtils.clicks(SaveAndSubmitBtn);
		}
	}

	public void fillHeaderCostChange(LinkedHashMap<String, String> dataMap) {
		lavanteUtils.fluentwait(SaveAsDraftLink);
		String y = "DUMMY";
		// Multi Select
		String multiSelect = "//*[text()='" + y + "']/../following-sibling::div//button";
		// Select from dropdown
		String dropDown = "//*[text()='" + y + "']/../following-sibling::div//select";
		// datepicker
		String datePicker = "//*[text()='" + y + "']/../following-sibling::div//button[@class='dpbtnpicker adv_date']";
		if (dataMap.containsKey("CostChangeRefNo")) {
			CostChangeRefNoTxtBox.clear();
			lavanteUtils.typeString(dataMap.get("CostChangeRefNo"), CostChangeRefNoTxtBox);
		}
		if (dataMap.containsKey("CostChangeDesc")) {
			lavanteUtils.fluentwait(CostChangeDesTxtBox);
			CostChangeDesTxtBox.clear();
			lavanteUtils.typeString(dataMap.get("CostChangeDesc"), CostChangeDesTxtBox);
		}
		if (dataMap.containsKey("Division")) {
			if (!dataMap.get("Division").equalsIgnoreCase("ANY")) {
				String z = multiSelect;
				z = z.replace(y, "Division");
				lavanteUtils.click(lavanteUtils.driver.findElement(By.xpath(z)));
				// only if dataMap contains key selectData this method will work
				multiSelect(dataMap);
			}
		}
		if (dataMap.containsKey("EffectiveDataType")) {
			if (!dataMap.get("EffectiveDataType").equalsIgnoreCase("ANY")) {
				String z = dropDown;
				z = z.replace(y, "Effective Date Type");
				lavanteUtils.click(lavanteUtils.driver.findElement(By.xpath(z)));
				lavanteUtils.selectbyvisibiletxt(dataMap.get("EffectiveDataType"),
						lavanteUtils.driver.findElement(By.xpath(z)));
			}
		}
		if (dataMap.containsKey("EffectiveStartDate")) {
			String z = datePicker;
			z = z.replace(y, "Effective Start Date");
			lavanteUtils.click(lavanteUtils.driver.findElement(By.xpath(z)));
			selectDate(dataMap.get("EffectiveStartDate"));
		}
		fillItemsCostChange(dataMap);
	}

	public void fillItemsCostChange(LinkedHashMap<String, String> dataMap) {
		if (dataMap.containsKey("CaseGTINDesc")) {
			String x=dataMap.get("CaseGTINDesc");
			int size = 0;
			if (x.contains("#")) {
				String caseGTIN[] = dataMap.get("CaseGTINDesc").split("#");
				size = caseGTIN.length;
				for (int i = 0; i < size; i++) {
					lavanteUtils.typeString(caseGTIN[i], ListCaseGTINDescTxtBox.get(i));
					if (i != (size - 1)) {
						lavanteUtils.clicks(AddAnoterItemLink);
					}
				}
				dataMap.put("Size", size + "");
			} else 	if (x.length()>0) {
				lavanteUtils.typeString(dataMap.get("CaseGTINDesc"), ListCaseGTINDescTxtBox.get(0));
			}
			
			Bracket(dataMap);
		}
		if (dataMap.containsKey("SelectExistCaseGTINDesc")) {
			lavanteUtils.typeString(dataMap.get("SelectExistCaseGTINDesc"), ListCaseGTINDescTxtBox.get(0));
			if (dataMap.containsKey("SelectDetailSearch")) {
				lavanteUtils.clicks(ViewDetailedSearchResultsLink);
				selectSearchAddItems(dataMap);
				Bracket(dataMap);
			}
		}
	}

	public void Bracket(LinkedHashMap<String, String> dataMap) {

		if (dataMap.get("BracketMin").contains("#")) {
			String bracketMin[] = dataMap.get("BracketMin").split("#");
			String bracketMax[] = dataMap.get("BracketMax").split("#");
			String newCost[] = dataMap.get("NewCost").split("#");
			String currency[] = dataMap.get("Currency").split("#");
			int size = Integer.parseInt(dataMap.get("Size"));
			for (int i = 0; i < size; i++) {
				// lavanteUtils.typeString(caseGTIN[i],
				// ListCaseGTINDescTxtBox.get(i));
				if (dataMap.containsKey("BracketMin")) {
					lavanteUtils.typeString(bracketMin[i], ListBracketMinTxtBox.get(i));
				}
				if (dataMap.containsKey("BracketMax")) {
					lavanteUtils.typeString(bracketMax[i], ListBracketMaxTxtBox.get(i));
				}
				if (dataMap.containsKey("NewCost")) {
					lavanteUtils.typeString(newCost[i], ListNewCostTxtBox.get(i));
				}
				if (dataMap.containsKey("Currency")) {
					lavanteUtils.selectbyvisibiletxt(currency[i], ListCurrencyDropDwn.get(i));
				}
			}
		} else {
			if (dataMap.containsKey("BracketMin")) {
				lavanteUtils.typeString(dataMap.get("BracketMin"), ListBracketMinTxtBox.get(0));
			}
			if (dataMap.containsKey("BracketMax")) {
				lavanteUtils.typeString(dataMap.get("BracketMax"), ListBracketMaxTxtBox.get(0));
			}
			if (dataMap.containsKey("NewCost")) {
				lavanteUtils.typeString(dataMap.get("NewCost"), ListNewCostTxtBox.get(0));
			}
			if (dataMap.containsKey("Currency")) {
				lavanteUtils.selectbyvisibiletxt(dataMap.get("Currency"), ListCurrencyDropDwn.get(0));
			}
		}
	}

	public void editfillItemsCostChange(LinkedHashMap<String, String> dataMap) {
		if (dataMap.containsKey("EditBracketMin")) {
		
			lavanteUtils.typeinEdit(dataMap.get("EditBracketMin"), BracketMinTxtbox);
		}
		if (dataMap.containsKey("EditBracketMax")) {
			lavanteUtils.typeinEdit(dataMap.get("EditBracketMax"), BracketMaxTxtbox);
		}
		if (dataMap.containsKey("EditUOMType")) {
			lavanteUtils.selectFrmDpdn(dataMap.get("EditUOMType"));
		}
		if (dataMap.containsKey("EditUOM")) {
			lavanteUtils.selectFrmDpdn(dataMap.get("EditUOM"));
		}
		if (dataMap.containsKey("EditNewCost")) {
			lavanteUtils.typeinEdit(dataMap.get("EditNewCost"), NewCostTxtBox);
		}
		if (dataMap.containsKey("EditCurrency")) {
			lavanteUtils.selectbyvalue(dataMap.get("EditCurrency"), CurrencyDropDwn);
		}
		lavanteUtils.clicks(ApplyBtn);
	}

	public void itemActions(LinkedHashMap<String, String> dataMap) {
		lavanteUtils.fluentwait(ActionDropDwn());
		lavanteUtils.clicks(ActionDropDwn());
		List<WebElement> options = ActionsMenu();
		for (int i = 0; i < options.size(); i++) {
			String option = options.get(i).getAttribute("value");
			if (dataMap.containsKey("EditValue") && option.equals("Edit values")) {
				lavanteUtils.clicks(options.get(i));
				break;
			}
			if (dataMap.containsKey("Remove") && option.equals("Remove lines")) {
				lavanteUtils.clicks(options.get(i));
				break;
			}
			if (dataMap.containsKey("Duplicate") && option.equals("Duplicate lines")) {
				lavanteUtils.clicks(options.get(i));
				break;
			}
		}
	}

	public void selectSearchAddItems(LinkedHashMap<String, String> dataMap) {
		lavanteUtils.fluentwait(SearchTxtBox);
		SearchItem(dataMap);
		if (dataMap.containsKey("AddItems")) {
			if (dataMap.get("AddItems").contains("#")) {
				String item[] = dataMap.get("AddItems").split("#");
				for (int i = 0; i < item.length; i++) {
					String obj = selectItemByCaseGTIN.replace("$", item[i]);
					WebElement ele = lavanteUtils.driver.findElement(By.xpath(obj));
					lavanteUtils.clicks(ele);
				}
			} else {
				String obj = selectItemByCaseGTIN.replace("$", dataMap.get("AddItems"));
				WebElement ele = lavanteUtils.driver.findElement(By.xpath(obj));
				lavanteUtils.clicks(ele);
			}
		}

		if (dataMap.containsKey("SelectAllAddItems")) {
			lavanteUtils.clicks(Headers.get(0));
		}
		lavanteUtils.clicks(PopUPActionsDropDwn());
		lavanteUtils.clicks(PopUPAddItems());

	}

	private void SearchItem(LinkedHashMap<String, String> dataMap) {
		if (dataMap.containsKey("SearchAddItems")) {
			if (dataMap.get("SearchAddItems").contains("#")) {
				String item[] = dataMap.get("SearchAddItems").split("#");
				for (int i = 0; i < item.length; i++) {
					SearchTxtBox.clear();
					lavanteUtils.typeinEdit(dataMap.get("SearchAddItems"), SearchTxtBox());
					lavanteUtils.clicks(SearchIcon());
					String obj = selectItemByCaseGTIN.replace("$", item[i]);
					WebElement ele = lavanteUtils.driver.findElement(By.xpath(obj));
					lavanteUtils.clicks(ele);
				}
			} else {
				SearchTxtBox.clear();
				lavanteUtils.typeinEdit(dataMap.get("SearchAddItems"), SearchTxtBox());
				lavanteUtils.clicks(SearchIcon());
				String obj = selectItemByCaseGTIN.replace("$", dataMap.get("SearchAddItems"));
				WebElement ele = lavanteUtils.driver.findElement(By.xpath(obj));
				lavanteUtils.clicks(ele);
			}
		}

	}

	public void multiSelect(LinkedHashMap<String, String> dataMap) {
		List<WebElement> options = lavanteUtils.driver.findElements(
				By.xpath("//div[@class='selectAll']/following-sibling::ul[1]//li/div[@ng-bind='key.label']"));
		if (dataMap.containsKey("selectData")) {
			if (dataMap.get("selectData").equalsIgnoreCase("selectall")) {
				String getAttribute = lavanteUtils.getValue(
						lavanteUtils.driver.findElement(By.xpath("//div[@class='selectAll']/a/span")), "class");
				if (!getAttribute.contains("selected")) {
					lavanteUtils.click(lavanteUtils.driver.findElement(By.xpath("//div[@class='selectAll']/a")));
				}
			} else if (dataMap.get("selectData").contains("#")) {
				String selData[] = dataMap.get("selectData").split("#");
				for (int j = 0; j < selData.length; j++) {
					for (int i = 0; i < options.size(); i++) {
						String opt = lavanteUtils.getText(options.get(i));
						if (selData[j].equals(opt)) {
							String getAttribute = lavanteUtils.getValue(
									options.get(i).findElement(By.xpath("//preceding-sibling::div")), "class");
							if (!getAttribute.contains("selected")) {
								lavanteUtils.click(options.get(i));
							}
						}
					}
				}
			}
			for (int i = 0; i < options.size(); i++) {
				if (dataMap.get("selectData").equals(lavanteUtils.getText(options.get(i)))) {
					String getAttribute = lavanteUtils
							.getValue(options.get(i).findElement(By.xpath("//preceding-sibling::div")), "class");
					if (!getAttribute.contains("selected")) {
						lavanteUtils.clicks(options.get(i));
						break;
					}
				}
			}
		}
	}

	public List<WebElement> iterateSearchHeaderFindColList(String col) {
		List<WebElement> s = null;
		int j = ColIdentify(col);
		String x = "tbody td:nth-child(" + j + ")";
		s = lavanteUtils.driver.findElements(By.cssSelector(x));
		System.out.println("Iterate col locator:" + x + ",Size:" + s.size());
		return s;
	}

	public int ColIdentify(String col) {
		int ki = 0;
		boolean found = false;
		if (Headers.size() > 0) {
			for (int i = 0; i < Headers.size(); i++) {
				String x = Headers.get(i).getText();
				if (x.contains(col)) {
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
	 * Pass the date as dd-MM-YYYY format
	 * 
	 * 
	 * 
	 * @author Subhas.BV
	 * @param day
	 */
	public void selectDate(String day) {
		if (day == null) {
			DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
			day = df.format(new java.util.Date()).toString();
		}
		String getDay[] = day.split("-");
		String date = getDay[0];
		String month = Month.of(Integer.parseInt(getDay[1])).getDisplayName(TextStyle.FULL, Locale.ENGLISH);
		String year = getDay[2];
		String getMonth = "";
		lavanteUtils.fluentwait(GetMonth);
		for (int i = 1; i <= 11; i++) {
			getMonth = lavanteUtils.getText(GetMonth);
			// int monInt = Month.valueOf(getMonth.toUpperCase()).getValue();
			if (!getMonth.equals(month)) {
				lavanteUtils.clicks(NextMonth);
			} else {
				break;
			}
		}
		lavanteUtils.selectbyvalue(year, YearDropDwn);
		String getDate = "";
		for (int i = 0; i < Date.size(); i++) {
			getDate = lavanteUtils.getText(Date.get(i));
			if (date.equals(getDate)) {
				lavanteUtils.clicks(Date.get(i));
				break;
			}
		}
	}

}
