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

public class ListCostChangePage {

	LavanteUtils lavanteUtils = new LavanteUtils();

	public ListCostChangePage(WebDriver driver) {
		lavanteUtils.driver = driver;
	}
	

	@FindBy(css = "thead th")
	private List<WebElement> Headers;

	@FindBy(id = "listCostChangeId")
	private WebElement CostChangeIDTxtBox;

	@FindBy(id = "supplierReferenceId")
	private WebElement CostChangeRefNoTxtBox;

	@FindBy(id = "costChangeDescription")
	private WebElement CostChangeDesTxtBox;

	@FindBy(xpath = "//div/label[contains(text(),'Cost Change Status')]/parent::div[1]/following-sibling::div[1]/../..//button[1]")
	private WebElement CostChangeStatusMultiSelDropDwn;

	@FindBy(xpath = "//div/label[contains(text(),'Effective Date Type')]/parent::div[1]/following-sibling::div[1]/../..//button[1]")
	private WebElement EffectiveDateTypeMultSelDropDwn;

	@FindBy(xpath = "//div/label[contains(text(),'Effective Start Date')]/parent::div[1]/following-sibling::div[1]/div/div/div")
	private WebElement EffectiveStartDate;

	@FindBy(xpath = "//label[contains(text(),'Division')]/parent::div[1]/following-sibling::div[1]/div/div/button")
	private WebElement DivisionMultiSelDropDwn;

	@FindBy(id = "itemCode")
	private WebElement ItemCodeTxtBox;

	@FindBy(id = "caseGTIN")
	private WebElement CaseGTINTxtBox;

	@FindBy(id = "consumerGTIN")
	private WebElement ConsumerGTINTxtBox;

	@FindBy(id = "itemDescription")
	private WebElement ItemDesTxtBox;

	@FindBy(xpath = "//label[contains(text(),'Created On')]/parent::div[1]/following-sibling::div[1]/div/div/div")
	private WebElement CreatedOnDate;

	@FindBy(css = "button[class$='button_flat'][type='reset']")
	private WebElement ClearLink;
	public WebElement ClearLink() {
		return ClearLink;
	}
	
	@FindBy(css = "button[class$='button_primary'][type='Submit']")
	private WebElement SearchBtn;

	public WebElement SearchBtn() {
		return SearchBtn;
	}

	@FindBy(css = "drop-down[class^='dropDownParent'] button")
	private WebElement ActionsDropDwn;

	public WebElement ActionsDropDwn() {
		return ActionsDropDwn;
	}

	@FindBy(css = "drop-down[class^='dropDownParent'] button+ul li input")
	private List<WebElement> ActionsMenu;

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

	@FindBy(css = "tr[ng-if$='Source.message'] td")
	private WebElement VeirfyNoResultTxt;

	public WebElement VeirfyNoResultTxt() {
		return VeirfyNoResultTxt;
	}

	@FindBy(css = "div[class^='modal-footer'] button[class='button_primary']")
	private WebElement ConfirmatonYesBtn;

	public WebElement ConfirmatonYesBtn() {
		return ConfirmatonYesBtn;
	}

	@FindBy(css = "div[class^='modal-footer'] button[class='button_flat']")
	private WebElement ConfirmatonNoBtn;

	public WebElement ConfirmatonNoBtn() {
		return ConfirmatonNoBtn;
	}

	@FindBy(css = "textarea[id='flex']")
	private WebElement EnterCommentsTxtArea;

	public WebElement EnterCommentsTxtArea() {
		return EnterCommentsTxtArea;
	}

	@FindBy(css = "label[for='public_user']")
	private WebElement PublicRadioBtn;

	@FindBy(css = "label[for='private_user']")
	private WebElement PrivateRadioBtn;

	@FindBy(id = "questionCommentBtn")
	private WebElement AddCommentsBtn;

	public WebElement AddCommentsBtn() {
		return AddCommentsBtn;
	}

	@FindBy(css = "button[aria-label='Close']")
	private WebElement ComSecCloseIcon;

	public WebElement ComSecCloseIcon() {
		return ComSecCloseIcon;
	}
	
	@FindBy(css = "p[class*='commentUserText']")
	private List<WebElement> PublicCommentsList;

	public List<WebElement> PublicCommentsList() {
		return PublicCommentsList;
	}


	public void searchListcostChanges(LinkedHashMap<String, String> dataMap) {
		fillListCostChangeDetails(dataMap);
		formActions(dataMap);
	}

	public void formActions(LinkedHashMap<String, String> dataMap) {
		if (dataMap.containsKey("Clear")) {
			lavanteUtils.click(ClearLink);
		}
		if (dataMap.containsKey("Search")) {
			lavanteUtils.click(SearchBtn);
		}
	}

	public void fillListCostChangeDetails(LinkedHashMap<String, String> dataMap) {
		lavanteUtils.fluentwait(SearchBtn);
		if (dataMap.containsKey("CostChangeID")) {
			CostChangeIDTxtBox.clear();
			lavanteUtils.typeinEdit(dataMap.get("CostChangeID"), CostChangeIDTxtBox);
		}
		if (dataMap.containsKey("CostChangeRefNo")) {
			CostChangeRefNoTxtBox.clear();
			lavanteUtils.typeinEdit(dataMap.get("CostChangeRefNo"), CostChangeRefNoTxtBox);
		}
		if (dataMap.containsKey("CostChangeDes")) {
			CostChangeDesTxtBox.clear();
			lavanteUtils.typeinEdit(dataMap.get("CostChangeDes"), CostChangeDesTxtBox);
		}
		if (dataMap.containsKey("SelCostChangeStatus")) {
			lavanteUtils.clicks(CostChangeStatusMultiSelDropDwn);
			multiSelect(dataMap);
		}
		if (dataMap.containsKey("EffDateType")) {
			lavanteUtils.clicks(EffectiveDateTypeMultSelDropDwn);
			multiSelect(dataMap);
		}
		if (dataMap.containsKey("EffStartDate")) {
			lavanteUtils.clicks(EffectiveDateTypeMultSelDropDwn);
			selectDate(dataMap.get("EffectiveStartDate"));
		}
		if (dataMap.containsKey("Division")) {
			lavanteUtils.clicks(DivisionMultiSelDropDwn);
			multiSelect(dataMap);
		}
		if (dataMap.containsKey("ItemCode")) {
			ItemCodeTxtBox.clear();
			lavanteUtils.typeinEdit(dataMap.get("ItemCode"), ItemCodeTxtBox);
		}
		if (dataMap.containsKey("CaseGTIN")) {
			CaseGTINTxtBox.clear();
			lavanteUtils.typeinEdit(dataMap.get("CaseGTIN"), CaseGTINTxtBox);
		}
		if (dataMap.containsKey("ConsumerGTIN")) {
			ConsumerGTINTxtBox.clear();
			lavanteUtils.typeinEdit(dataMap.get("ConsumerGTIN"), ConsumerGTINTxtBox);
		}
		if (dataMap.containsKey("ItemDescription")) {
			ItemDesTxtBox.clear();
			lavanteUtils.typeinEdit(dataMap.get("ItemDescription"), ItemDesTxtBox);
		}
		if (dataMap.containsKey("CreatedOnDate")) {
			lavanteUtils.clicks(CreatedOnDate);
			selectDate(dataMap.get("CreatedOnDate"));
		}
	}

	public void actions(LinkedHashMap<String, String> dataMap) {
		
		WebElement costChaStaObj = iterateSearchHeaderFindColList("Cost Change Status").get(0);
		lavanteUtils.clicks(costChaStaObj);
		
		lavanteUtils.clicks(ActionsDropDwn);

		List<WebElement> options = ActionsMenu;
		for (int i = 0; i < options.size(); i++) {
			String option = options.get(i).getAttribute("value");
			if (dataMap.containsKey("ActEdit") && option.equals("Edit")) {
				lavanteUtils.clicks(options.get(i));
				break;
			}
			if (dataMap.containsKey("ActDelete") && option.equals("Delete")) {
				lavanteUtils.clicks(options.get(i));
				lavanteUtils.clicks(ConfirmatonYesBtn());
				break;
			}
			if (dataMap.containsKey("ActSubmit") && option.equals("Submit")) {
				lavanteUtils.clicks(options.get(i));
				lavanteUtils.clicks(ConfirmatonYesBtn());
				break;
			}
			if (dataMap.containsKey("ActAddComments") && option.equals("Add Comments")) {
				lavanteUtils.clicks(options.get(i));
				break;
			}
		}
	}

	/**
	 * Add private/public comments
	 * 
	 * @author subhas.bv
	 * 
	 */
	public void addComment(LinkedHashMap<String, String> dataMap) {
		lavanteUtils.fluentwait(EnterCommentsTxtArea);
		if (dataMap.containsKey("EnterComment")) {
			EnterCommentsTxtArea.clear();
			lavanteUtils.typeinEdit(dataMap.get("EnterComment"), EnterCommentsTxtArea);
		}
		if (dataMap.containsKey("PrivateComment")) {
			lavanteUtils.clicks(PrivateRadioBtn);
		}
		if (dataMap.containsKey("PublicComment")) {
			lavanteUtils.clicks(PublicRadioBtn);
		}
		lavanteUtils.clicks(AddCommentsBtn);
	}

	public List<WebElement> iterateSearchHeaderFindColList(String col) {
		List<WebElement> s = null;
		int j = ColIdentify(col);
		String x = "tbody td:nth-child(" + j + ")";
		s = lavanteUtils.driver.findElements(By.cssSelector(x));
		System.out.println("Iterate col locator:" + x + ",Size:" + s.size());
		if (col.contains("Cost Change ID")) {
			x = "tbody td:nth-child(" + j + ") a";
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
			int monInt = Month.valueOf(getMonth.toUpperCase()).getValue();
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
