package com.lavante.recovery.pageobjects.Dashboard;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.lavante.recovery.Common.Util.LavanteUtils;

public class SupplierPage {

	/**
	 * Dashboard Supplier Page
	 * 
	 */
LavanteUtils lavanteUtils = new LavanteUtils();
	
	public SupplierPage(WebDriver driver) {
		lavanteUtils.driver = driver;
	}
	
	//Supplier Tab
	@FindBy(css="a[href*='supplierDashboard.lvp']")
	private WebElement supplierTab;
	
	//Credit Tab
	@FindBy(css="a[href='#Credit']")
	private WebElement creditTab;
	public WebElement creditTab(){
		return creditTab;
	}
	
	
	//Spend Tab
	@FindBy(css="a[href='#Spend']")
	private WebElement spendTab;
	public WebElement spendTab(){
		return spendTab;
	}
	
	//Check Request Tab
	@FindBy(css="a[href='#CheckRequest']")
	private WebElement requestCheckTab;
	public WebElement requestCheckTab(){
		return requestCheckTab;
	}
	
	//More button
	@FindBy(css="a[href*='moreSupplierDBInfo.lvp']")
	private WebElement moreSupplierBtn;

	//Dashboard-->Credit-->Supplier Names
	@FindBy(css="#Credit td:nth-child(1) a")
	private List<WebElement> creditSupplierNameList;
	public List<WebElement> creditSupplierNameList(){
		return creditSupplierNameList;
	}

	//Dashboard-->Credit-->Amount
	@FindBy(css="#Credit td:nth-child(2)")
	private List<WebElement> creditTotalAmountList;
	public List<WebElement> creditTotalAmountList(){
		return creditTotalAmountList;
	}

	//Dashboard-->Credit-->Count
	@FindBy(css="#Credit td:nth-child(3)")
	private List<WebElement> creditCountList;
	public List<WebElement> creditCountList(){
		return creditCountList;
	}
	
	//Dashboard-->Spend-->Supplier Names
	@FindBy(css="#Spend td:nth-child(1) a")
	private List<WebElement> spendSupplierNameList;
	public List<WebElement> spendSupplierNameList(){
		return spendSupplierNameList;
	}

	//Dashboard-->Spend-->Amount
	@FindBy(css="#Spend td:nth-child(2)")
	private List<WebElement> spendTotalAmountList;
	public List<WebElement> spendTotalAmountList(){
		return spendTotalAmountList;
	}

	//Dashboard-->Spend-->Rank
	@FindBy(css="#Spend td:nth-child(3)")
	private List<WebElement> spendRankList;
	public List<WebElement> spendRankList(){
		return spendRankList;
	}
	
	//Dashboard-->Check Request-->Supplier Names
	@FindBy(css="#CheckRequest td:nth-child(1) a")
	private List<WebElement> checkRequestSupplierNameList;
	public List<WebElement> checkRequestSupplierNameList(){
		return checkRequestSupplierNameList;
	}

	//Dashboard-->Check Request-->Amount
	@FindBy(css="#CheckRequest td:nth-child(2)")
	private List<WebElement> checkRequestTotalAmountList;
	public List<WebElement> checkRequestTotalAmountList(){
		return checkRequestTotalAmountList;
	}

	//Dashboard-->Check Request-->Count
	@FindBy(css="#CheckRequest td:nth-child(3)")
	private List<WebElement> checkRequestCountList;
	public List<WebElement> checkRequestCountList(){
		return checkRequestCountList;
	}
	
	@FindBy(css="a[href='/recovery/supplierDashboard.lvp']")
	private WebElement supplierLink;
	public WebElement supplierLink(){
		return supplierLink;
	}
	
	@FindBy(css="#recKHf77GG_select_type")
	private WebElement supplierChangeStatisticsDropdown;
	public WebElement supplierChangeStatisticsDropdown(){
		return supplierChangeStatisticsDropdown;
	
		}
	
	@FindBy(css="span[id='recKHf77GG_select_type'] a[title = 'Data Table']")
	private WebElement supplierChangeStatisticsDatatable;
	public WebElement supplierChangeStatisticsDatatable(){
		return supplierChangeStatisticsDatatable;
	}
	
	
	@FindBy(css="table[class='data_table table_grid zebra'] tr th a ")
	private List<WebElement> supplierChangeStatisticsLinks;
	public List<WebElement> supplierChangeStatisticsLinks(){
		return supplierChangeStatisticsLinks;
	}
	
	@FindBy(css="table[class='data_table table_grid zebra'] tr td:nth-child(3)")
	private List<WebElement> supplierChangeStatisticsDataTableCount;
	public List<WebElement> supplierChangeStatisticsDataTableCount(){
		return supplierChangeStatisticsDataTableCount;
	}
	
	@FindBy(css="#recKHf77HH_select_type")
	private WebElement relatedSupplierAnalysisDropdown;
	public WebElement relatedSupplierAnalysisDropdown(){
		return relatedSupplierAnalysisDropdown;
	}
	
	@FindBy(css="#recKHf77HH_select_type a[class='option_type option_type_table']")
	private WebElement relatedSupplierAnalysisDataTable;
	public WebElement relatedSupplierAnalysisDataTable(){
		return relatedSupplierAnalysisDataTable;
	}
	
	@FindBy(css="div[id='recKHf77HH'] table[class='data_table table_grid zebra'] tbody tr th a")
	private List<WebElement> relatedSupplierAnalysisLinks;
	public List<WebElement> relatedSupplierAnalysisLinks(){
		return relatedSupplierAnalysisLinks;
	}
	
	@FindBy(css="div[id='recKHf77HH'] table[class='data_table table_grid zebra'] tbody tr td:nth-child(3)")
	private List<WebElement> relatedSupplierAnalysisCounts;
	public List<WebElement> relatedSupplierAnalysisCounts(){
		return relatedSupplierAnalysisCounts;
	}
	
	
	
}
