
package com.lavante.sim.customer.pageobjects.Reports;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.lavante.sim.Common.Util.LavanteUtils;

/**
 * @author Piramanayagam.S
 *
 */
public class ReportUserDefined {
	
	LavanteUtils lavanteUtils=new LavanteUtils();
	public WebDriver driver;
	
	public ReportUserDefined(WebDriver driver){
		lavanteUtils.driver=driver;
		this.driver=driver;
	}
		
	@FindBy(css="iframe[src*='Report']")
	private WebElement IFRAMEaddReport;	
	public WebElement IFRAMEaddReport(){
		return IFRAMEaddReport;
	}
	
	//For Sanity

	@FindBy(linkText = "User Defined")
	private WebElement linkUserDefined;
	
	@FindBy(linkText = "Customer Specific")
	private WebElement linkCustomerSpecific;
	
	@FindBy(xpath="//div[not(contains(@style,'display'))][@class='toggle_content std_padding']//li//a[contains(@href,'CustomReport')][@onclick]")
	private List<WebElement> ReportSection;

	@FindBy(css="h3[class*='accordian']")
	private List<WebElement> ReportHeader;
			
	@FindBy(css="div[role*='grid']")
	private WebElement CSVSection;
	
	@FindBy(css="button[class*='primary'][data-ng-click*='download']")
	private WebElement DownloadBtn;
	
    @FindBy(css="div[class*='bannerMessage']")
	private WebElement ErrMsg;
	
	//End sanity

	
	@FindBy(css="button[href*='Report']")
	private WebElement addReportbtn;	
	public WebElement addReportbtn(){
		return addReportbtn;
	}
	
	@FindBy(id="reportName")
	private WebElement addreportnametxt;	
	public WebElement addreportnametxt(){
		return addreportnametxt;
	}
	
	@FindBy(id="reportDescription")
	private WebElement addreportdesctxt;	
	public WebElement addreportdesctxt(){
		return addreportdesctxt;
	}	

	@FindBy(css="[id*='savedSearch'] a")
	private WebElement addSavedQrydpdn;	
	public WebElement addSavedQrydpdn(){
		return addSavedQrydpdn;
	}
	
	@FindBy(css="[id*='reportTemplate'] a")
	private WebElement addTemplatedpdn;	
	public WebElement addTemplatedpdn(){
		return addTemplatedpdn;
	}
	

	@FindBy(css="[id*='publicReport'] a")
	private WebElement addreportTypedpdn;	
	public WebElement addreportTypedpdn(){
		return addreportTypedpdn;
	}
	
	@FindBy(id="reportCriteria")
	private WebElement addreportCriteriatxt;	
	public WebElement addreportCriteriatxt(){
		return addreportCriteriatxt;
	}

	@FindBy(css="input[type*='submit']")
	private WebElement reportSavebtn;	
	public WebElement reportSavebtn(){
		return reportSavebtn;
	}
	
	//Table Data
	@FindBy(css="[id*='user-defined'] tbody td:nth-child(1)")
	private List<WebElement> tblreportname;	
	public List<WebElement> tblreportname(){
		return tblreportname;
	}
	
	@FindBy(css="[id*='user-defined'] tbody td:nth-child(7)")
	private List<WebElement> tblreporttype;	
	public List<WebElement> tblreporttype(){
		return tblreporttype;
	}	
	
	@FindBy(css="a[class*='csv']")
	private WebElement csvExport;	
	public WebElement csvExport(){
		return csvExport;
	}
	
	@FindBy(css="a[class*='pdf']")
	private WebElement pdfExport;	
	public WebElement pdfExport(){
		return pdfExport;
	}
	
	@FindBy(css="a[class*='xls']")
	private WebElement xlsExport;		
	public WebElement xlsExport() {
		return xlsExport;
	}

	public String  AddnewReport(LinkedHashMap<String, String> dataMap) throws FileNotFoundException, IOException, SQLException {
		ClickAddNew();
		String rname=fillNewReport(dataMap);
		formActionnwReport(dataMap);
		return rname;
	}


	public void ClickAddNew() {
		lavanteUtils.switchtoFrame(null);
		lavanteUtils.click(addReportbtn());
	}


	private String fillNewReport(LinkedHashMap<String, String> dataMap) throws FileNotFoundException, IOException, SQLException {
		String rname="";
		lavanteUtils.switchtoFrame(IFRAMEaddReport());
		if(dataMap.containsKey("ReportName")){
			rname=lavanteUtils.typeString(dataMap.get("ReportName"), addreportnametxt());
		}
		if(dataMap.containsKey("ReportDesc")){
			lavanteUtils.typeinEdit(dataMap.get("ReportDesc"), addreportdesctxt());
		}
		if(dataMap.containsKey("ReportSavedQuery")){
			String x=dataMap.get("ReportSavedQuery");
			if(x.equalsIgnoreCase("ANY")){
				x="select MAX(QueryName) from SavedSearch where  isPrivate=0 and CustomerID="+dataMap.get("CustomerID");
				x=lavanteUtils.fetchDBdata(x);
			}
			lavanteUtils.click(addSavedQrydpdn);
			lavanteUtils.selectvalueFrmDpdn(x);
			lavanteUtils.switchtoFrame(IFRAMEaddReport);
		}
		if(dataMap.containsKey("ReportTemplate")){
			String x=dataMap.get("ReportTemplate");
			if(x.equalsIgnoreCase("ANY")){
				x=" select UTFString from UserTranslation where i18nKey= (select MIN(ReportTemplateDisplay_i18nKey) from ReportTemplate "
				 + " where CustomerID is null) and LanguageID=50;";
				x=lavanteUtils.fetchDBdata(x);
			}
			lavanteUtils.click(addTemplatedpdn);
			lavanteUtils.selectvalueFrmDpdn(x);
			lavanteUtils.switchtoFrame(IFRAMEaddReport);
		}
		if(dataMap.containsKey("ReportType")){
			String x=dataMap.get("ReportType");
			lavanteUtils.click(addreportTypedpdn);
			lavanteUtils.selectvalueFrmDpdn(x);
			lavanteUtils.switchtoFrame(IFRAMEaddReport);	
		}
		if(dataMap.containsKey("ReportCriteria")){
			lavanteUtils.typeinEdit(dataMap.get("ReportCriteria"), addreportCriteriatxt());
		}

		return rname;
		
	}


	private void formActionnwReport(LinkedHashMap<String, String> dataMap) {
		if(dataMap.containsKey("ReportSave")){
			lavanteUtils.click(reportSavebtn());		
		}
		
	}

	//FOR SANITY TEST =Below method used 
	public boolean verifyAdminTablePresent() {
		boolean flag=lavanteUtils.verifyElementDisplayed("ReportTable", ReportSection.get(0));
		SoftAssert softAssert=new SoftAssert();
		if(flag){
			
			Reporter.log("Report is shown status:"+flag);
			softAssert.assertTrue(flag,"Report is shown");
			flag=false;
						
			for(int j=0;j<ReportHeader.size();j++){
				String zzy=ReportHeader.get(j).getAttribute("class");
				if(zzy.contains("close")){
					lavanteUtils.click(ReportHeader.get(j));
				}
				
				for(int i=0;i<ReportSection.size();i++){
			
					lavanteUtils.click(ReportSection.get(i));
					String att=ReportSection.get(i).getAttribute("href");
					String rname=ReportSection.get(i).getText();
					String time=lavanteUtils.currenttime();
					
					Integer y=1000;
					String x="";
					
					if(att.contains("CSV")){
						
						lavanteUtils.fluentwait(CSVSection);
						while((lavanteUtils.isElementDisplayed(CSVSection)==false) && (lavanteUtils.isElementDisplayed(ErrMsg)==false) && y<400){
							x=lavanteUtils.currenttime();
							y=Integer.parseInt(x)-Integer.parseInt(time);
							Reporter.log(rname+",Not yet Report is a CSV report and the table loaded time diff of :"+x+",da"+time,true);
							Reporter.log(rname+",Not yet Report is a CSV report and the table loaded time diff of :"+y,true);
						}
						if(lavanteUtils.isElementDisplayed(CSVSection)){
							x=lavanteUtils.currenttime();
							y=Integer.parseInt(x)-Integer.parseInt(time);
							Reporter.log(rname+",Report is a CSV report and the table loaded time diff of :"+x+",da"+time,true);
							Reporter.log(rname+",Report is a CSV report and the table loaded time diff of :"+y,true);
							flag=true;
						}else{
							Reporter.log("Report Rendered with Error:"+rname);
							flag=false;
						}
						
					}else if (att.contains("PDF")){
						Reporter.log(rname+",Report is a PDF report and the table loaded time diff of :"+y,true);
						flag=lavanteUtils.isElementDisplayed(DownloadBtn);
					}else if (att.contains("Excel")){
						Reporter.log(rname+",Report is a Excel report and the table loaded time diff of :"+y,true);
						flag=lavanteUtils.isElementDisplayed(DownloadBtn);
					}
				
				}
			}
			
			softAssert.assertAll();
		}
		return flag;
		
		
		
	}
	
	/*public void verifyCustomerTablePresent() {
		lavanteUtils.switchtoFrame(IFRAMEReporttable);
		lavanteUtils.verifyElementDisplayed("ReportTable", ReportTable);
		lavanteUtils.switchtoFrame(null);
		
	}
	
	public void verifyUserDefineTablePresent() {
		lavanteUtils.switchtoFrame(IFRAMEReporttable);
		lavanteUtils.verifyElementDisplayed("ReportTable", ReportTable);
		lavanteUtils.switchtoFrame(null);
		
	}*/

	//End of Sanity Method

}
