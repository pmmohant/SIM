package lavante.recovery.pageobjects.Configuration.MailerRegistry;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.Reporter;

import lavante.recovery.utilities.LavanteUtils;
import lavante.recovery.utilities.seleniumBaseClass;

public class MailerRegistryPage {
	
	LavanteUtils lavanteUtils=new LavanteUtils();
	public WebDriver driver=null;
	public MailerRegistryPage(WebDriver driver){
		lavanteUtils.driver=driver;
	}
	
	//Configuration--Mailer Registry Link
	@FindBy(css="a[title='Mailer Registry']")
	private WebElement mailerRegistryLink;
	public WebElement mailerRegistryLink(){					//added by Ramya
		return mailerRegistryLink;
	}
		
	public void verifyMailerRegistryLink() {
		lavanteUtils.fluentwait(mailerRegistryLink);
		lavanteUtils.click("mailerRegistryLink",mailerRegistryLink);
	}
			
	//Configuration--Mailer Registry table
	@FindBy(css="#registry-list tbody tr")
	private WebElement mailerRegistryTable;
	public WebElement mailerRegistryTable(){				//added by Ramya
		return mailerRegistryTable;
	}
		
	public void verifyMailerRegistryTable() {
		
		lavanteUtils.isDisplayed("mailerRegistryTable",mailerRegistryTable);
		lavanteUtils.verifyError(mailerRegistryTable);
	}
	
	//Add New Button
	@FindBy(css="#addNew")
	private WebElement addNewBtn;
	public WebElement addNewBtn(){						//added by Ramya
		return addNewBtn;
	}
	
	//Add Mailer Registry
	@FindBy(css="iframe[src*='addMailerRegistry']")
	private WebElement iframeMailerReg;
	
	//Add Mailer Registry--Date Mailed
	@FindBy(css="#maildate")
	private WebElement mailDate;
	
	//Add Mailer Registry--Today's date
	@FindBy(css="button[data-handler*='today']")
	private WebElement todayDate;
	
	//Add Mailer Registry--LAV Qty
	@FindBy(css="#mailQty")
	private WebElement mailQty;
	
	//Add Mailer Registry--PMP Qty
	@FindBy(css="#pmpQty")
	private WebElement pmpQty;
	
	//Add Mailer Registry--Tax
	@FindBy(css="#mailertax")
	private WebElement mailertax;
	
	//Add Mailer Registry--Total
	@FindBy(css="#mailertotal")
	private WebElement mailertotal;
	
	//Add Mailer Registry--USPS Total
	@FindBy(css="#maileruspcs")
	private WebElement maileruspcs;
	
	//Add Mailer Registry--Add 
	@FindBy(css="input[name='save']")
	private WebElement add;
	
	//Add Mailer Registry--Pop up msg
	@FindBy(css=".ui-dialog-content")
	private WebElement dialogMsg;
	
	//Add Mailer Registry--Pop up --OK Btn
	@FindBy(css=".button_green span")
	private WebElement conformationOkBtn;
	
	//Add Mailer Registry--Audit Name
	@FindBy(css="#registry-list tr td:nth-child(1)")
	private List<WebElement> auditNameCol;
	
	//Add Mailer Registry--Audit Name
	@FindBy(css="#registry-list tr td:nth-child(3)")
	private List<WebElement> dateMailedCol;
	
	//Add Mailer Registry--LAV QTY
	@FindBy(css="#registry-list tr td:nth-child(4)")
	private List<WebElement> lavqtyCol;
	
	//Add Mailer Registry--PMP QTY
	@FindBy(css="#registry-list tr td:nth-child(5)")
	private List<WebElement> pmpqtyCol;
	
	//Add Mailer Registry--Tax
	@FindBy(css="#registry-list tr td:nth-child(6)")
	private List<WebElement> taxCol;
	
	//Add Mailer Registry--Total
	@FindBy(css="#registry-list tr td:nth-child(7)")
	private List<WebElement> totalCol;
	
	//Add Mailer Registry--USPS Total
	@FindBy(css="#registry-list tr td:nth-child(8)")
	private List<WebElement> uspstotalCol;
	
	
	
		
	public void verifyaddNewBtn() {
		lavanteUtils.click(addNewBtn);
		lavanteUtils.isDisplayed("addNewBtn",addNewBtn);
		lavanteUtils.verifyError(addNewBtn);
	}
	
	
	public void verifyNewMailerRegFunctionality(LinkedHashMap<String, String> map){
		 LinkedHashMap<String, List<WebElement>> mailerRegMap = new LinkedHashMap<String, List<WebElement>>();
		 mailerRegMap.put("AuditName", auditNameCol);
		 mailerRegMap.put("DateMailed", dateMailedCol);
		 mailerRegMap.put("LAVQTY", lavqtyCol);
		 mailerRegMap.put("PMPQTY", pmpqtyCol);
		 mailerRegMap.put("Tax", taxCol);
		 mailerRegMap.put("Total", totalCol);
		 mailerRegMap.put("USPSTotal", uspstotalCol);
		 
		 
		 
		Random rn = new Random();
		int nextInt = rn.nextInt(999);
		
		lavanteUtils.switchtoFrame(iframeMailerReg);
		lavanteUtils.click(mailDate);
		lavanteUtils.click(todayDate);
		
		if(map.containsKey("LAVQTY")){
			lavanteUtils.enterText("LAVQTY", mailQty, (map.get("LAVQTY") + nextInt));
			map.put("LAVQTY", (map.get("LAVQTY") + nextInt));
		}
		
		if(map.containsKey("PMPQTY")){
			lavanteUtils.enterText("PMPQTY", pmpQty, (map.get("PMPQTY") + nextInt));
			map.put("PMPQTY", (map.get("PMPQTY") + nextInt));
		}
		
		if(map.containsKey("Tax")){
			lavanteUtils.enterText("Tax", mailertax, (map.get("Tax") + nextInt));
			map.put("Tax", (map.get("Tax") + nextInt));
		}
		
		if(map.containsKey("Total")){
			lavanteUtils.enterText("Total", mailertotal, (map.get("Total") + nextInt));
			map.put("Total", (map.get("Total") + nextInt));
		}
		
		if(map.containsKey("USPSTotal")){
			lavanteUtils.enterText("USPSTotal", maileruspcs, (map.get("USPSTotal") + nextInt));
			map.put("USPSTotal", (map.get("USPSTotal") + nextInt));
		}
		
		lavanteUtils.click(add);
		lavanteUtils.switchtoFrame(null);
		
		lavanteUtils.waitForTime(3000);
		System.out.println(map);
		
		if(lavanteUtils.getText("dialogMsg", dialogMsg).equalsIgnoreCase(lavanteUtils.readConfigFile("MailerRegConfirmOK"))){
			lavanteUtils.ActionsforSingleClick(conformationOkBtn);
			Reporter.log("");
		}
		
		else
			Assert.assertTrue(false, "Error in adding mailer registry");
		
		
	}
}
