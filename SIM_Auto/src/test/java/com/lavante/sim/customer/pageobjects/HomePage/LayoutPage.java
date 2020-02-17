package com.lavante.sim.customer.pageobjects.HomePage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.Reporter;

import com.lavante.sim.Common.Util.LavanteUtils;

//manageLayouts.lvp

public class LayoutPage  {

	//manageLayouts.lvp
	public WebDriver driver;
	public LavanteUtils lavanteUtils = new LavanteUtils();

	public LayoutPage(WebDriver driver) {
		lavanteUtils.driver = driver;
		this.driver = driver;
	}
	
	//Page Objects 
	
	@FindBy(css="//div[@class = 'dropdown inline_block header_account open']")
	private WebElement Username;
	public WebElement Username(){
		return Username;
	}

	
	@FindBy(css="a[class='stopNavigation'][href*='manageLayouts.lvp']")
	private WebElement ManageLayout;
	public WebElement ManageLayout(){
		return ManageLayout;
	}
	
	
	@FindBy(css="form-select:nth-child(1) select")
	private WebElement PageSelection;
	
	@FindBy(css="form-select:nth-child(2) select")
	private WebElement CreatedbySelection;
	
	@FindBy(css="button[class*='primary']")
	private WebElement AddNewBtn;
	public WebElement AddNewBtn(){
		return AddNewBtn;
	}
	@FindBy(css="#div1 li")
	private List<WebElement> AvailbleSelection;

	@FindBy(css="#div2 li")
	private List<WebElement> SelectedSection;
	
	@FindBy(css="div[ng-click*='left']")
	private WebElement lefttoright;
	
	
	@FindBy (css="div[class*='slid'] button[class*='primary']")
	private WebElement savebtn;
	

	
	@FindBy(css="div[class*='row'] button[class*='toggle']")
	private WebElement actnbtn;
	
	@FindBy(css="input[value*='Edit']")
	private WebElement editActnBtn;
	
	@FindBy(css="input[value*='Make']")
	private WebElement defaultActnBtn;
	
	@FindBy(css="input[value*='Unmark']")
	private WebElement unMarkdefaultActnBtn;
	
	@FindBy(css="input[value*='Delete']")
	private WebElement delteActnbtn;
	
	@FindBy(css="div[class*='dial'] button[class*='pr']")
	private WebElement okBtn;
	
	//Task PAge Dropdown
	@FindBy(css="thead th")
	private List<WebElement> Headers;
	
	@FindBy(css="drop-down button")
	private WebElement LayoutDrpdn;
	
	
		
	//Reusable MEthod
	
	public void CreateLayout(LinkedHashMap<String, String> dataMap){
		addLayout();
		fillLayout(dataMap);
		formAction(dataMap);
	}
	
	private void addLayout(){
		lavanteUtils.fluentwait(AddNewBtn);
		lavanteUtils.click(AddNewBtn);
	}
	
	public void fillLayout(LinkedHashMap<String, String> dataMap) {
		lavanteUtils.fluentwait(savebtn);
		String methodKey="AutoMAtion";
		String input="//div[contains(@class,'slid')]//*[contains(text(),'"+methodKey+"')]/../following-sibling::div//input";
		String dropdown="//div[contains(@class,'slid')]//*[contains(text(),'"+methodKey+"')]/../..//select";
		String chkbx="//div[contains(@class,'slid')]//*[contains(text(),'"+methodKey+"')]";
		
		if(dataMap.containsKey("Page")){
			String x=dataMap.get("Page");
			String z=dropdown;
			z=z.replace(methodKey, "Page");
			WebElement e=lavanteUtils.driver.findElement(By.xpath(z));
			lavanteUtils.selectbyvisibiletxt(x,e );
		}
		lavanteUtils.fluentwait(savebtn);
		if(dataMap.containsKey("LayoutName")){
			String x=dataMap.get("LayoutName");
			String z=input;
			z=z.replace(methodKey, "Layout name");
			WebElement e=lavanteUtils.driver.findElement(By.xpath(z));
			e.clear();
			lavanteUtils.typeString(x, e);
		}
		if(dataMap.containsKey("LayoutList")){
			String x=dataMap.get("LayoutList");
			String[] ads=new String[1];
			if(x.contains("#")){
				ads=x.split("#");
			}else{
				ads[0]=x;
			}
			
			outr:for(int i=0;i<ads.length;i++){
					for(int j=0;j<AvailbleSelection.size();j++){
						String das=AvailbleSelection.get(j).getText();
						if(das.length()>0){
								if(ads[i].equalsIgnoreCase(das)){
									lavanteUtils.click(AvailbleSelection.get(j));
									lavanteUtils.click(lefttoright);
									break;
								}
						}
					}
			}
			
			String asdx="";
			
			for(int j=0;j<SelectedSection.size();j++){
					String das=SelectedSection.get(j).getText();
					if(das.length()>0){
								asdx=asdx+das+"#";
						}
			}
			dataMap.put("SelectedSection",asdx);
		}
		if(dataMap.containsKey("Access")){
			String x=dataMap.get("Access");
			String z=dropdown;
			z=z.replace(methodKey, "Access");
			WebElement e=lavanteUtils.driver.findElement(By.xpath(z));
			lavanteUtils.selectbyvalue(x,e );
		}
		if(dataMap.containsKey("Visibility")){
			String x=dataMap.get("Visibility");
			String[] ads=new String[1];
			if(x.contains("#")){
				ads=x.split("#");
			}else{
				ads[0]=x;
			}
			for(int i=0;i<ads.length;i++){
				if(ads[i].length()>0){
					String z=chkbx;
					z=z.replace(methodKey,ads[i]);
					WebElement e=lavanteUtils.driver.findElement(By.xpath(z));
					lavanteUtils.click(e);
				}
			}
		}
		
	}


	public void formAction(LinkedHashMap<String, String> dataMap) {
		lavanteUtils.fluentwait(savebtn);
		if(dataMap.containsKey("Save")){
			lavanteUtils.click(savebtn);
			lavanteUtils.waitForTime(4000);
		}
	}
	
	
	public void selectAction(LinkedHashMap<String, String> dataMap) {
		filterSearch(dataMap);
		selectLayout(dataMap);
		Action(dataMap);
	}
	

	public void filterSearch(LinkedHashMap<String, String> dataMap){
		if(dataMap.containsKey("Search")){
			if(dataMap.containsKey("Page")){
				String x=dataMap.get("Page");
				lavanteUtils.selectbyvisibiletxt(x,PageSelection);
			} 
			if(dataMap.containsKey("Createdby")){
				String x=dataMap.get("Createdby");
				lavanteUtils.selectbyvisibiletxt(x,CreatedbySelection);
			}
		}
	}
	
	private void selectLayout(LinkedHashMap<String, String> dataMap) {
		if(dataMap.containsKey("LayoutName")){
			int size = iterateSearchHeaderFindColList("Layout name").size();
			for (int i = 0; i <= size - 1; i++) {
				String actualName = lavanteUtils.getText(iterateSearchHeaderFindColList("Layout name").get(i));
				String lname=dataMap.get("LayoutName");
				if (lname.equalsIgnoreCase(actualName)) {
					lavanteUtils.click(iterateSearchHeaderFindColList("Layout name").get(i));
					break;
				}else if (lname.equalsIgnoreCase("ANY")){
					lavanteUtils.click(iterateSearchHeaderFindColList("Layout name").get(i));
					break;
				}
			}
		}
	}
	

	
	private void Action(LinkedHashMap<String, String> dataMap) {
		if(dataMap.containsKey("Action")){
			String x=dataMap.get("Action");
			lavanteUtils.click(actnbtn);
			
			if(x.contains("Edit")){
				lavanteUtils.click(editActnBtn);
			}else if(x.contains("MakeDefault")){
				lavanteUtils.click(defaultActnBtn);
				lavanteUtils.waitForTime(4000);
			}else if(x.contains("UnMarkDefault")){
				lavanteUtils.click(unMarkdefaultActnBtn);
				lavanteUtils.waitForTime(4000);
				lavanteUtils.waitForTime(4000);
			}else if(x.contains("Delete")){
				lavanteUtils.click(delteActnbtn);
				lavanteUtils.click(okBtn);
				lavanteUtils.waitForTime(4000);
			} 
			
		}
		
	}

	public List<WebElement> iterateSearchHeaderFindColList(String col) {
		List<WebElement> s = null;
		int j = ColIdentify(col);
		String x = "tbody td:nth-child(" + j + ")";
		s = lavanteUtils.driver.findElements(By.cssSelector(x));
		if(col.contains("Actions")){
			if(col.contains("#")){
				String[] d=col.split("#");
				col=d[1];
			}
			if(col.equalsIgnoreCase("Default")){
				x = "tbody td:nth-child(" + j + ") span:nth-child(1)";
			}else if(col.equalsIgnoreCase("Edit")) {
				x = "tbody td:nth-child(" + j + ") span:nth-child(2)";
			}else if(col.equalsIgnoreCase("Delete")) {
				x = "tbody td:nth-child(" + j + ") span:nth-child(3)";
			}
			s = lavanteUtils.driver.findElements(By.cssSelector(x));
		}
		System.out.println("Iterate col locator:" + x + ",Size:" + s.size());
		return s;
	}
	
	public int ColIdentify(String col) {
		int ki = 0;
		boolean found = false;
		if (Headers.size() > 0) {
			for (int i = 1; i < Headers.size(); i++) {
				String x = Headers.get(i).getText().toLowerCase();
				//Action Col,  we send  with extra charachter
				if (col.toLowerCase().contains(x)) {
					if(col.contains("#")){
						String[] d=col.split("#");
						col=d[0];
						//UI Bug extra td available so adding 1 actions is 8th  and result is 9
						i=i+1;
					}
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

	public void jumpTaskPage(LinkedHashMap<String, String> dataMap) {
		if(dataMap.containsKey("Page")){
			String x=dataMap.get("Page");
			dataMap.put("maintab", "Tasks");
			
			if(x.equalsIgnoreCase("Claims To approve")){
				dataMap.put("subtab", "claimTasks");
			}else if (x.equalsIgnoreCase("Claims pending update")){
				dataMap.put("subtab", "ClaimPendingUpdates");
			}
		
		
		}
		
	}

	public List<String> ListofHeader() {
		String ki = "";
		List<String> xcx=new ArrayList<String>();
		
		if (Headers.size() > 0) {
			for (int i = 0; i < Headers.size(); i++) {
				String x = Headers.get(i).getText();
				if(x.length()>0){
					System.out.println(x + ",Col Found at " + ki);
					xcx.add(x);
				}else{
					//Only Attachment dont have text
					xcx.add("Attachment");
				}
			}
		}

		Collections.sort(xcx);
		return xcx;
		
	}
	
	/**
	 * @author Piramanayagam.S
	 */
	public void changeLayout(LinkedHashMap<String, String> dataMap) {
		if(dataMap.containsKey("LayoutName")){
			String x=dataMap.get("LayoutName");
			
			String defaultValue=LayoutDrpdn.getText();
			defaultValue=defaultValue.replace("Layout: ", "");
			dataMap.put("defaultValue", defaultValue);
			
			lavanteUtils.click(LayoutDrpdn);
			
			
			String xx=lavanteUtils.selectvalueFrmDpdnXpathAttribute(x,"//drop-down//li//input");
			dataMap.put("selectedValue", xx);
		}
		
	}
	
	

	
	
	
}
