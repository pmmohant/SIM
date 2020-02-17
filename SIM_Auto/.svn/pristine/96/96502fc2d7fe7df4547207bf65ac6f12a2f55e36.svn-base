package com.lavante.sim.customer.pageobjects.Tasks.PendingUpdate;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.lavante.sim.Common.Util.LavanteUtils;

public class InvoicePendingUpdate {
	LavanteUtils lavanteUtils=new LavanteUtils();

	public InvoicePendingUpdate(WebDriver driver){
		lavanteUtils.driver=driver;
	}
	
	@FindBy(css="button[class*='primary']")
	private WebElement Search;
	public WebElement Search()	{
		return Search;
	}
	
	@FindBy(css="[id*='filterWorkflow'] a")
	private WebElement Filterby;
	public WebElement Filterby() {
		return Filterby;
	}
	
	@FindBy(css="div[class='header'] form-select  select")
	private WebElement tasksViewDDL;
	public WebElement tasksViewDDL() {
		return tasksViewDDL;
	}
	
	@FindBy(css="thead th")
	private List<WebElement> Headers;
	
	@FindBy(css="[ng-bind='vm.dataSource.message']")
	private WebElement NoData;
	public WebElement NoData(){
		return NoData;
	}	
	
	@FindBy(css=".ng-scope.check_box span")
	private List<WebElement> checkBoxList;
	public List<WebElement> checkBoxList(){
		return checkBoxList;
	}
	
	@FindBy(css= "button[class*='action_buttons']")
	private WebElement Actnbtn;
	
	@FindBy(css="[title='Edit Invoice']")
	private WebElement editInvoice;
	public WebElement editInvoice(){
		return editInvoice;
	}	
	
	@FindBy(css="[value='Submit Invoice']")
	private WebElement submitInvoice;
	public WebElement submitInvoice(){
		return submitInvoice;
	}	
	
	public void selectInvoiceMethod(LinkedHashMap<String, String> dataMap) throws IOException {
		switchTasksClaimView(dataMap);
		search(dataMap);
		selectInvoice(dataMap);
		formAction(dataMap);
	}
	private void switchTasksClaimView(LinkedHashMap<String, String> dataMap) {
		String data="17201";
		if (dataMap.containsKey("View")){
			data=dataMap.get("View");
			if(data.contains("My Tasks")){
				data=""+17202;
				lavanteUtils.selectbyvalue(data,tasksViewDDL);
				lavanteUtils.fluentwait(Search);
			}else{
				lavanteUtils.selectbyvalue(data,tasksViewDDL);
				lavanteUtils.fluentwait(Search);
			}
		}
	}
	
	public void search(LinkedHashMap<String, String> dataMap) throws IOException
	{
		lavanteUtils.fluentwait(Search);
		String y="DUMMY";
		String x="//*[text()='"+y+"']/../following-sibling::div//input";
		
		if(dataMap.containsKey("supplierName")){
			if(!dataMap.get("supplierName").equalsIgnoreCase("ANY")){
				String z=x;
				z=z.replace(y, "Supplier Name");
				lavanteUtils.driver.findElement(By.xpath(z)).clear();
				lavanteUtils.driver.findElement(By.xpath(z)).sendKeys(dataMap.get("supplierName"));
			}
		}
		if(dataMap.containsKey("InvoiceNumber")){
			if(!dataMap.get("InvoiceNumber").equalsIgnoreCase("ANY")){
				String z=x;
				z=z.replace(y, "Invoice Number");
				lavanteUtils.driver.findElement(By.xpath(z)).clear();
				lavanteUtils.driver.findElement(By.xpath(z)).sendKeys(dataMap.get("InvoiceNumber"));
			}
		}
				
		lavanteUtils.click(Search);
		lavanteUtils.waitForTime(2000);
	}
	
	public List<WebElement> iterateSearchHeaderFindColList(String col) {
		List<WebElement> s = null;
		int j = ColIdentify(col);
		String x = "tbody td:nth-child(" + j + ")";
		s = lavanteUtils.driver.findElements(By.cssSelector(x));
		if (col.contains("Invoice Number") || col.contains("Supplier Name")) {
			x = "tbody td:nth-child(" + j + ") a";
			s = lavanteUtils.driver.findElements(By.cssSelector(x));
		}
		return s;
	}
	
	public int ColIdentify(String col) {
		int ki = 0;
		boolean found = false;
		if (Headers.size() > 0) {
			for (int i = 0; i < Headers.size(); i++) {
				String x = Headers.get(i).getText().toLowerCase();
				if (x.contains(col.toLowerCase())) {
					ki = i;
					// List start with 0 but need a number more than that to
					// fetch in xpath
					ki = i + 1;
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
	
	private void selectInvoice(LinkedHashMap<String, String> dataMap) {
		int size = iterateSearchHeaderFindColList("Invoice Number").size() - 1;
		if (iterateSearchHeaderFindColList("Invoice Number").size() > 0) {
			if (dataMap.containsKey("InvoiceNumber") && dataMap.containsKey("supplierName") ) {
				String actualInv="";  
				String actualSup=""; 
				
				for (int i = 0; i <= size; i++) {
					String expSuper = dataMap.get("supplierName"); 
					String expInv= dataMap.get("InvoiceNumber")  ;
					actualSup = iterateSearchHeaderFindColList("Supplier Name").get(i).getText();
					if(expSuper.equalsIgnoreCase(actualSup)){
						actualInv = iterateSearchHeaderFindColList("Invoice Number").get(i).getText(); //1100
						if(expInv.equalsIgnoreCase(actualInv) || expInv.equalsIgnoreCase("ANY") ){
								lavanteUtils.click(iterateSearchHeaderFindColList("Invoice Date").get(i));
								dataMap.put("supplierName", expSuper);
								dataMap.put("InvoiceNumber", actualInv);
								break;
							}
						}
					}
				
			}
		}
		lavanteUtils.waitForTime(2000);
	}
	
	public void formAction(LinkedHashMap<String, String> dataMap) {
		lavanteUtils.fluentwait(Actnbtn);
		lavanteUtils.click(Actnbtn);
		
		if(dataMap.containsKey("EditInvoice")) {
			lavanteUtils.click(editInvoice);
			
		}
		
		if(dataMap.containsKey("SubmitInvoice")) {
			lavanteUtils.click(submitInvoice);
			
		}
	}
}
