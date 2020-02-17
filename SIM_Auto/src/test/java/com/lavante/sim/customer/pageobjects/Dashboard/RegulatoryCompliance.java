package com.lavante.sim.customer.pageobjects.Dashboard;

import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.lavante.sim.Common.Util.LavanteUtils;

public class RegulatoryCompliance {

	public WebDriver driver;
	LavanteUtils lavanteUtils = new LavanteUtils();

	public RegulatoryCompliance(WebDriver driver) {
		lavanteUtils.driver = driver;
		this.driver = driver;
	}

	@FindBy(css="div[id='country_chosen']>a")
	private WebElement ChooseCountryDropDwn;

	public WebElement ChooseCountryDropDwn() {
		return ChooseCountryDropDwn;
	}

	@FindBy(css="div[id='country_chosen']+a[id*='type']")
	private WebElement LegalIdChartDropDwn;

	public WebElement LegalIdChartDropDwn() {
		return LegalIdChartDropDwn;
	}

	@FindBy(css="span[id*='t'][style*='blo'] a[title='Pie Chart']")
	private WebElement PieChart;

	public WebElement PieChart() {
		return PieChart;
	}

	@FindBy(css="span[id*='type'][style*='blo'] a[title='Bar Chart']")
	private WebElement BarChart;

	public WebElement BarChart() {
		return BarChart;
	}

	@FindBy(css="span[id*='type'][style*='blo'] a[title='Line Chart']")
	private WebElement LineChart;

	public WebElement LineChart() {
		return PieChart;
	}

	@FindBy(css="span[id*='t'][style*='blo'] a[title='Data Table']")
	private WebElement DataTable;

	public WebElement DataTable() {
		return DataTable;
	}

	@FindBy(css="span[id*='t'][style*='blo'] a[title='Stacked Bar Chart']")
	private WebElement StackedBarChart;

	public WebElement StackedBarChart() {
		return StackedBarChart;
	}

	public void selectCountryInLegalIdAuthentication(LinkedHashMap<String, String> dataMap) {
		lavanteUtils.fluentwait(ChooseCountryDropDwn);
		lavanteUtils.click(ChooseCountryDropDwn);
		lavanteUtils.selectFrmDpdn(dataMap.get("SupplierLocation"));

	}

	public void selectChartCategory(LinkedHashMap<String, String> dataMap) {
		if (dataMap.containsKey("LegalIDAuthentication")) {
			String chartName = dataMap.get("SelectChart");
			String getClassValue = LegalIdChartDropDwn.getAttribute("class");
			System.out.println("Clas Value "+getClassValue);
			if (!getClassValue.contains(chartName)) {
				lavanteUtils.fluentwait(LegalIdChartDropDwn());
				lavanteUtils.click(LegalIdChartDropDwn());
				selectChartType(dataMap);
			}
		}
	}

	public void selectChartType(LinkedHashMap<String, String> dataMap) {

		if (dataMap.get("SelectChart").equalsIgnoreCase("line")) {
			lavanteUtils.fluentwait(LineChart());
			lavanteUtils.click(LineChart());
		} else if (dataMap.get("SelectChart").equalsIgnoreCase("pie")) {
			lavanteUtils.fluentwait(PieChart());
			lavanteUtils.click(PieChart());
		} else if (dataMap.get("SelectChart").equalsIgnoreCase("stacked")) {
			lavanteUtils.fluentwait(StackedBarChart());
			lavanteUtils.click(StackedBarChart());
		} else if (dataMap.get("SelectChart").equalsIgnoreCase("table")) {
			lavanteUtils.fluentwait(DataTable());
			lavanteUtils.click(DataTable());
		} else if (dataMap.get("SelectChart").equalsIgnoreCase("column")) {
			lavanteUtils.fluentwait(BarChart());
			lavanteUtils.click(BarChart());
		}
	}
	
	@FindBy(how = How.XPATH, using = "//span[@title='Legal ID Authentication']/../../../../../..//thead//th")
	private List<WebElement> getLegalIdColumnNames;

	public List<WebElement> getLegalIdColumnNames() {
		return getLegalIdColumnNames;
	}
	

	public int getValueFromLegalIdAuthentication(String filterName) {
		// String getLegalIdColumnNames = "//span[@title='Legal ID
		// Authentication']/parent::td/parent::tr/parent::tbody/parent::table/parent::div/following-sibling::div/descendant::thead/tr/th";
//		String getLegalIdColumnNames = "//span[@title='Legal ID Authentication']/../../../../../..//thead//th";
		String getLegalIdColumnValues = "//span[@title='Legal ID Authentication']/../../../../../..//div[2]//td[*]";
		// String getLegalIdColumnValues = "//span[@title='Legal ID
		// Authentication']/parent::td/parent::tr/parent::tbody/parent::table/parent::div/following-sibling::div/descendant::tbody/tr/td[*]";
		lavanteUtils.waitForTime(4000);
		lavanteUtils.waitforPageload(getLegalIdColumnNames.get(0));
		int getValue = 0;
		for (int i = 0; i <= getLegalIdColumnNames.size(); i++) {
			String actualColumnName = "";
			String getColumnName = getLegalIdColumnNames.get(i).getAttribute("title");
			
			//Fetch the colum name and match to Excel name,So truncating the space Ex: Auto Validated to AutoValidated
			if(getColumnName.contains(" ")){
				String[] splitColumnName = getColumnName.split(" ");
				for (String columnName : splitColumnName) {
					actualColumnName = actualColumnName + columnName;
				}
			}else{
				actualColumnName=getColumnName;
			}

			if (actualColumnName.equalsIgnoreCase(filterName)) {

				String object = getLegalIdColumnValues.replace("*", "" + (i + 1) + "");
				System.out.println("Object " + object);
				WebElement getColumnValue = driver.findElement(By.xpath(object));
				String value = getColumnValue.getAttribute("title");
				getValue = Integer.parseInt(value);
				break;
			}
		}
		return getValue;
	}

}
