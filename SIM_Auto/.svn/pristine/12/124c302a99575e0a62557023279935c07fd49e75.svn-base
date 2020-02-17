/**
 * 
 */
package com.lavante.sim.customer.pageobjects.Suppliers.EditProfile;

import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.lavante.sim.Common.Util.LavanteUtils;

/**
 * @author Piramanayagam.S
 *
 */
public class EditProfilePage {

	public WebDriver driver;
	LavanteUtils lavanteUtils = new LavanteUtils();

	public EditProfilePage(WebDriver driver) {
		this.driver = driver;
		lavanteUtils.driver = driver;
	}

	@FindBy(css="iframe[src*='Confirmation']")
	private WebElement iframe_Profile_Popup;

	public WebElement iframe_Profile_Popup() {
		return iframe_Profile_Popup;
	}

	@FindBy(css="iframe[src*='StatusInfo']")
	private WebElement iframe_todo;

	public WebElement iframe_todo() {
		return iframe_todo;
	}

	@FindBy(css="iframe[src*='TabMessage']")
	private WebElement iframe_Nextab;

	public WebElement iframe_Nextab() {
		return iframe_Nextab;
	}

	@FindBy(css="iframe[src*='TabMessage']")
	private List<WebElement> iframeNextTabMsg;

	public List<WebElement> iframeNextTabMsg() {
		return iframeNextTabMsg;
	}

	// TODO

	@FindBy(css="li[class]")
	private List<WebElement> todolist;

	public List<WebElement> todolist() {
		return todolist;
	}

	@FindBy(id="profile_percentage")
	private WebElement profpercent;

	public WebElement profpercent() {
		return profpercent;
	}

	@FindBy(css="span[class*='error']")
	private WebElement errorMSG;

	public WebElement errorMSG() {
		return errorMSG;
	}

	@FindBy(css="[id*='dialog'] div[class*='std']>div")
	private WebElement CompletedMsg;

	public WebElement CompletedMsg() {
		return CompletedMsg;
	}

	// Form Actions Button
	
	@FindBy(css="button[class*='secondar'][value*='Previous']")
	private WebElement previousButton;

	public WebElement previousButton() {
		return previousButton;
	}
	
	
	@FindBy(id = "save_button")
	private WebElement SaveBtn;

	public WebElement SaveBtn() {
		return SaveBtn;
	}
	
	@FindBy(id="saveexit_button")
	private WebElement saveExitbtn;

	public WebElement saveExitbtn() {
		return saveExitbtn;
	}

	@FindBy(id="saveexit_button")
	private List<WebElement> saveExitbtn1;

	public List<WebElement> saveExitbtn1() {
		return saveExitbtn1;
	}

	@FindBy(id="save_button")
	private WebElement Finish_Profile_Button;

	public WebElement Finish_Profile_Button() {
		return Finish_Profile_Button;
	}

	@FindBy(id="sendinvite")
	private WebElement sendInviteBtn;

	public WebElement sendInviteBtn() {
		return sendInviteBtn;
	}

	@FindBy(id="takecontrol")
	private WebElement TakecontrolBtn;

	public WebElement TakecontrolBtn() {
		return TakecontrolBtn;
	}

	@FindBy(css="[role*='dialog'] button[class*='green']")
	private List<WebElement> OKbtn1;

	public List<WebElement> OKbtn1() {
		return OKbtn1;
	}

	@FindBy(css="[role*='dialog'] button[class*='green']")
	private WebElement OKbtn;

	public WebElement OKbtn() {
		return OKbtn;
	}
	
	@FindBy(css="div[class*='load']")
	private WebElement Load;

	public WebElement Load() {
		return Load;
	}

	@FindBy(css="[href*='restore']")
	private WebElement cancelBtn;

	public WebElement cancelBtn() {
		return cancelBtn;
	}

	@FindBy(css="[href*='restore']")
	private List<WebElement> cancelBtn1;

	public List<WebElement> cancelBtn1() {
		return cancelBtn1;
	}

	@FindBy(css="button[name='yes']")
	private WebElement confirm_OK_Button;

	public WebElement confirm_OK_Button() {
		return confirm_OK_Button;
	}

	@FindBy(css="button[name='no']")
	private WebElement confirm_NO_Button;

	public WebElement confirm_NO_Button() {
		return confirm_NO_Button;
	}

	@FindBy(css="input[name='confirm']")
	private WebElement confirm_Yes_Button;

	public WebElement confirm_Yes_Button() {
		return confirm_Yes_Button;
	}

	@FindBy(css="iframe[src*='preScreenSupplier']")
	private WebElement IframePreScreenSupp;

	public WebElement IframePreScreenSupp() {
		return IframePreScreenSupp;
	}

	@FindBy(css="[href*='preScreenSupplier']")
	private WebElement PreScreenBtn;

	public WebElement PreScreenBtn() {
		return PreScreenBtn;
	}

	@FindBy(name="preScreenOk")
	private WebElement PreScreenOkBtn;

	public WebElement PreScreenOkBtn() {
		return PreScreenOkBtn;
	}

	// Next Tab Switchover Msg
	@FindBy(id = "leave")
	private WebElement leavethisTab;

	public WebElement leavethisTab() {
		return leavethisTab;
	}

	// Supplier Login
	@FindBy(css = "a[href*='supplierDashboard']")
	private WebElement SupplierHomePageTab;

	public WebElement SupplierHomePageTab() {
		return SupplierHomePageTab;
	}

	@FindBy(css = "div[id='inviteID_chosen'] a")
	public WebElement InviteDropDwn;

	public WebElement InviteDropDwn() {
		return InviteDropDwn;
	}

	@FindBy(css = "div[id='inviteID_chosen'] ul li")
	public List<WebElement> ListOfInvites;

	public List<WebElement> ListOfInvites() {
		return ListOfInvites;
	}

	@FindBy(css = "div[id='inviteID_chosen'] a")
	public WebElement GetInviteIdSelectedInDropDwn;

	public WebElement GetInviteIdSelectedInDropDwn() {
		return GetInviteIdSelectedInDropDwn;
	}

	@FindBy(css = "[id='iframe_page']>div>span:nth-child(1)")
	public WebElement GetCustomerOrSupplierName;

	public WebElement GetCustomerOrSupplierName() {
		return GetCustomerOrSupplierName;
	}

	@FindBy(css = "iframe[src*='supplierProfileStatusInfo']")
	public WebElement IframeSupplierProfileStatusInfo;

	public WebElement IframeSupplierProfileStatusInfo() {
		return IframeSupplierProfileStatusInfo;
	}
	
	@FindBy(css = "[class*='header'] span[style*='bold']")
	public WebElement SuppnameTxt;

	public WebElement SuppnameTxt() {
		return SuppnameTxt;
	}
	
	//LegalId duplicate
	@FindBy(css = "[src*='showMergeDuplicateSupplier']")
	public WebElement IFrameMergeSupplier;
	public WebElement IFrameMergeSupplier() {
		return IFrameMergeSupplier;
	}
	
	@FindBy(css = "[value='Yes']")
	public WebElement YesBtn;
	public WebElement YesBtn() {
		return YesBtn;
	}
	
	@FindBy(id = "no")
	public WebElement NoBtn;
	public WebElement NoBtn() {
		return NoBtn;
	}
	
	@FindBy(css = "[src*='getSupportAssistanceDialog']")
	public WebElement IFrameSupportAssistance;
	public WebElement IFrameSupportAssistance() {
		return IFrameSupportAssistance;
	}
	
	@FindBy(css = "#command>div.std_margin")
	public WebElement dupLegalIdTxt;
	public WebElement dupLegalIdTxt() {
		return dupLegalIdTxt;
	}
	
	@FindBy(id = "supportMail")
	public WebElement saveBtn;
	public WebElement saveBtn() {
		return saveBtn;
	}
	//Reusable Method
	
	public String[] suppName() {
		String[] suppName = SuppnameTxt.getText().split(" : ");
		return suppName;
	}
	
	/**
	 * 
	 * @author subhas.bv
	 */
	public String getDefaultInviteIdSelected() {
		String inviteId = null;
		if (ListOfInvites().size() > 0) {
			for (int i = 0; i < ListOfInvites().size(); i++) {
				String classAttribute = ListOfInvites.get(i).getAttribute("class");
				if (classAttribute.equals("active-result result-selected")) {
					inviteId = ListOfInvites.get(i).getText();
					break;
				}
			}
		}
		return inviteId;
	}

	public String selectInviteFromDropDwn(LinkedHashMap<String, String> dataMap) {
		lavanteUtils.click(InviteDropDwn());
		return lavanteUtils.selectvalueFrmDpdn(dataMap.get("SelectInviteId"));
	}

	public void selectTab(LinkedHashMap<String, String> dataMap) {

		lavanteUtils.switchtoFrame(null);
		lavanteUtils.fluentwait(cancelBtn);
		if (dataMap.containsKey("tab")) {
			lavanteUtils.waitForTime(4000);
			String path = "#profile_tab a[href*='" + dataMap.get("tab") + "']";
		
			lavanteUtils.fluentwait(saveExitbtn());
			lavanteUtils.Scrollintoview(driver.findElement(By.cssSelector(path)));
			lavanteUtils.waitforPageload(driver.findElement(By.cssSelector(path)));
			lavanteUtils.click(driver.findElement(By.cssSelector(path)));
			lavanteUtils.fluentwait(saveExitbtn());
			lavanteUtils.Scrollintoview(driver.findElement(By.cssSelector(path)));
			lavanteUtils.waitforPageload(driver.findElement(By.cssSelector(path)));
			lavanteUtils.waitForTime(4000);
			lavanteUtils.waitforPageload(saveExitbtn);
			lavanteUtils.fluentwait(cancelBtn);

		}
		if (dataMap.containsKey("Leavethis")) {
			lavanteUtils.fluentwait(iframe_Nextab);
			if (iframeNextTabMsg.size() > 0) {
				lavanteUtils.switchtoFrame(iframe_Nextab);

				lavanteUtils.click(leavethisTab);
				lavanteUtils.switchtoFrame(null);
			}

		}

	}

	public void formAction(LinkedHashMap<String, String> dataMap) {
		lavanteUtils.switchtoFrame(null);
		if (dataMap.containsKey("SaveExit")) {
			lavanteUtils.fluentwait(Finish_Profile_Button);
			if (saveExitbtn1.size() > 0) {
				lavanteUtils.fluentwait(saveExitbtn);
				lavanteUtils.click(saveExitbtn());
				lavanteUtils.waitForTime(6000);
			//	lavanteUtils.fluentwait(OKbtn());
				/*if (OKbtn1.size() > 0) {
					lavanteUtils.click(OKbtn());
				} else*/
				if (cancelBtn1.size() > 0) {
					lavanteUtils.click(cancelBtn());
					// Assert.assertTrue(false,"Profile Not Saved");
				}
			}

		}
		if (dataMap.containsKey("Previous")) {
			lavanteUtils.click(previousButton);
			lavanteUtils.waitForTime(4000);
		}
		if (dataMap.containsKey("Save")) {
			lavanteUtils.click(Finish_Profile_Button);
			lavanteUtils.waitForTime(4000);
			/*lavanteUtils.fluentwait(OKbtn());
			if (OKbtn1.size() > 0) {
				lavanteUtils.fluentwait(OKbtn());
				lavanteUtils.click(OKbtn());
			}*/
		}
		if (dataMap.containsKey("EditCancel")) {
			// This method is called by most of the script so cant wait for
			// Cancel button or any So commenting the below line
			// lavanteUtils.fluentwait(Finish_Profile_Button);
			if (cancelBtn1.size() > 0) {
				lavanteUtils.click(cancelBtn);
				lavanteUtils.waitForTime(4000);
			}
		}
		if (dataMap.containsKey("SendInvite")) {
			lavanteUtils.fluentwait(Finish_Profile_Button);
			lavanteUtils.click(sendInviteBtn);
			lavanteUtils.waitForTime(4000);
			/*lavanteUtils.fluentwait(OKbtn);
			lavanteUtils.click(OKbtn);*/
		}
		if (dataMap.containsKey("TakeControl")) {
			lavanteUtils.fluentwait(Finish_Profile_Button);
			lavanteUtils.click(TakecontrolBtn);
			lavanteUtils.fluentwait(saveExitbtn);
			lavanteUtils.waitForTime(4000);
		}

		// App got Renamed From Finish to Submit
		if (dataMap.containsKey("Finish")) {
			lavanteUtils.fluentwait(Finish_Profile_Button);
			lavanteUtils.click(Finish_Profile_Button);
			lavanteUtils.waitForTime(4000);

		}
		if (dataMap.containsKey("ConfrmOK")) {
			lavanteUtils.switchtoFrame(iframe_Profile_Popup);
			/*lavanteUtils.fluentwait(confirm_OK_Button());
			lavanteUtils.click(confirm_OK_Button());*/
		}
		if (dataMap.containsKey("ConfrmNO")) {
			lavanteUtils.switchtoFrame(iframe_Profile_Popup);
			lavanteUtils.fluentwait(confirm_NO_Button);
			lavanteUtils.click(confirm_NO_Button);
			lavanteUtils.waitForTime(4000);
		}
		if (dataMap.containsKey("Prescreen")) {
			lavanteUtils.click(PreScreenBtn);
			lavanteUtils.switchtoFrame(IframePreScreenSupp);
			lavanteUtils.click(PreScreenOkBtn);
			lavanteUtils.switchtoFrame(null);
			lavanteUtils.waitForTime(4000);
		}

		if (dataMap.containsKey("SupplierHomePage")) {
			lavanteUtils.fluentwait(SupplierHomePageTab);
			lavanteUtils.click(SupplierHomePageTab);
			lavanteUtils.waitForTime(4000);
		}
		lavanteUtils.waitForTime(4000);
	}

}
