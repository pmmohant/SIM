package com.lavante.sim.customer.pageobjects.Transactions.Claims;

import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.lavante.sim.Common.Util.LavanteUtils;

public class ViewClaimsPage {
	LavanteUtils lavanteUtils = new LavanteUtils();

	public ViewClaimsPage(WebDriver driver) {
		lavanteUtils.driver = driver;
	}

	@FindBy(css = ".prgx-text-link")
	private WebElement backLink;

	public WebElement backLink() {
		return backLink;
	}
	
	@FindBy(css = "div[class*='work']  [class*='button']")
	public WebElement ViewEdit;

	@FindBy(css = "div[ng-class*='showComments']>div.header>div>span")
	private WebElement claimHeaderLabel;

	public WebElement claimHeaderLabel() {
		return claimHeaderLabel;
	}
	
	@FindBy(xpath = "//dt[contains(text(),'Claim Type')]/..//dd")
	private WebElement claimTypeTxt;

	public WebElement claimTypeTxt() {
		return claimTypeTxt;
	}

	@FindBy(css = "div[class^='claim-amount'] span")
	private WebElement getClaimAmount;

	public WebElement getClaimAmount() {
		return getClaimAmount;
	}

	@FindBy(id = "addComments")
	private WebElement addCommentBtn;

	public WebElement addCommentBtn() {
		return addCommentBtn;
	}

	@FindBy(css = "textarea#flex")
	private WebElement addCommentTxt;

	public WebElement addCommentTxt() {
		return addCommentTxt;
	}

	@FindBy(id = "public_user")
	private WebElement publicRadioBtn;

	public WebElement publicRadioBtn() {
		return publicRadioBtn;
	}

	@FindBy(id = "private_user")
	private WebElement privateRadioBtn;

	public WebElement privateRadioBtn() {
		return privateRadioBtn;
	}

	@FindBy(css = "a[href*='approvalHistory']")
	private WebElement claimStatuslink;

	public WebElement claimStatuslink() {
		return claimStatuslink;
	}

	@FindBy(css = "iframe[src*='viewApproverDetails.lvp']")
	private WebElement IFrameUserDetails;

	public WebElement IFrameUserDetails() {
		return IFrameUserDetails;
	}

	@FindBy(css = "table[class*='table_grid zebra']")
	private WebElement Table1;
	public WebElement Table1() {
		return Table1;
	}

	@FindBy(css = "#approvalHistory tbody>tr:nth-child(1)>td:nth-child(2)")
	private WebElement email;

	public WebElement email() {
		return email;
	}

	@FindBy(xpath = "//label[@for='email']/../following-sibling::td")
	private WebElement email2;

	public WebElement email2() {
		return email2;
	}

	@FindBy(xpath = "//label[@for='contactName']/../following-sibling::td")
	private WebElement UserNameLabel;

	public WebElement UserNameLabel() {
		return UserNameLabel;
	}

	// Not in frame
	@FindBy(css = "button[class*='ui-dialog-titlebar-close']")
	private WebElement closeDailog;

	public WebElement closeDailog() {
		return closeDailog;
	}

	
	@FindBy(css = "a[href*='createClaim']")
	private WebElement createClaimbtn;
	public WebElement createClaimbtn() {
		return createClaimbtn;
	}
	
	// Add/Verify Comments
	@FindBy(id = "addComments")
	private WebElement AddCommentBtn;

	public WebElement AddCommentBtn() {
		return AddCommentBtn;
	}

	@FindBy(css = "button[class='button_primary']")
	private WebElement AddCommentsBtn;

	public WebElement AddCommentsBtn() {
		return AddCommentsBtn;
	}

	@FindBy(css = "div[class*='ui-dialog'] button[class='button_primary']")
	private WebElement DeleteBtn;

	public WebElement DeleteBtn() {
		return DeleteBtn;
	}

	@FindBy(id = "flex")
	private WebElement EnterCommentsTxtArea;

	public WebElement EnterCommentsTxtArea() {
		return EnterCommentsTxtArea;
	}

	@FindBy(id = "public_user")
	private WebElement PublicRadioBtn;

	@FindBy(id = "private_user")
	private WebElement PrivateRadioBtn;

	@FindBy(css = "div[data-ng-if*='isPrivate']+p[class*='commentUserText']")
	private List<WebElement> PrivateCommentsList;

	public List<WebElement> PrivateCommentsList() {
		return PrivateCommentsList;
	}

	@FindBy(xpath = "//div[contains(@data-ng-if,'isPrivate')]/../..//a")
	public List<WebElement> PrivateCommentActionbtn;

	@FindBy(xpath = "//div[contains(@data-ng-if,'isPrivate')]/../..//a[contains(@data-ng-click,'Edit')]")
	public List<WebElement> EditPrivateComments;

	@FindBy(xpath = "//div[contains(@data-ng-if,'isPrivate')]/../..//a[contains(@data-ng-click,'delete')]")
	public List<WebElement> DeletePrivateComments;

	@FindBy(css = "[title='Mark as read']")
	public List<WebElement> MarkAsRead;

	@FindBy(css = "[title='Mark as unread']")
	public List<WebElement> MarkAsUnRead;

	@FindBy(css = "[title='Edit Comment']")
	public List<WebElement> EditComment;

	@FindBy(css = "[title='Delete Comment']")
	public List<WebElement> DeleteComment;

	public String ListCommentOptions = "//p[contains(text(),'$')]/parent::div[1][starts-with(@class,'commentText')]/preceding-sibling::div[starts-with(@class,'userInfo')]/time/following-sibling::div/descendant::ul[@role='menu']/li/a";

	/*
	 * @FindBy(xpath =
	 * "//div[@id='commentsPaymentSection']/descendant::div[@class='messages']/div/div/time/following-sibling::div/descendant::div[@class='dropdown']/ul/li/a")
	 * public List<WebElement> ListCommentOptions;
	 */

	public String CommentOptionIcon = "//p[contains(text(),'$')]/parent::div[1][starts-with(@class,'commentText')]/preceding-sibling::div[starts-with(@class,'userInfo')]/time/following-sibling::div/descendant::a[@id='dLabel']";

	/*
	 * @FindBy(xpath =
	 * "//p[starts-with(text(),'AutoBV_Private419181708')]/parent::div[@class='commentText']/preceding-sibling::div[@class='userInfo']/time/following-sibling::div/descendant::a[@id='dLabel']")
	 * public List<WebElement> CommentOptionIcon;
	 */

	public String EditCommentTxtArea = "//p[contains(text(),'$')]/following-sibling::div[1]/textarea";

	public String SaveComment = "//p[starts-with(text(),'$')]/following-sibling::div[1]/div/button[@class='button button_primary']";

	@FindBy(css = "p[class*='commentUserText']")
	private List<WebElement> PublicCommentsList;

	public List<WebElement> PublicCommentsList() {
		return PublicCommentsList;
	}

	@FindBy(css = "p[class*='userProile_items']")
	private List<WebElement> ProfileCommentsList;

	public List<WebElement> ProfileCommentsList() {
		return ProfileCommentsList;
	}

	@FindBy(css = "a[class*='table_comment_box']")
	private List<WebElement> CommentDropDwn;

	public List<WebElement> CommentDropDwn() {
		return CommentDropDwn;
	}

	@FindBy(css = "a[ng-click*='markAllCommAsRead']")
	private List<WebElement> MarkAllReadLink;

	public List<WebElement> MarkAllReadLink() {
		return MarkAllReadLink;
	}

	@FindBy(css = "span[ng-if*='!showMarkAllAsRead'] sup")
	private List<WebElement> GetUnreadCommentCount;

	public List<WebElement> GetUnreadCommentCount() {
		return GetUnreadCommentCount;
	}

	/**
	 * @author Vidya.C
	 * @param dataMap
	 */
	public void viewDetails(LinkedHashMap<String, String> dataMap) {
		lavanteUtils.switchtoFrame(null);
		if (dataMap.containsKey("ActionTaken")) {

			WebElement actr = getActor(dataMap);
			if (actr != null) {
				String actor = actr.getText();
				if (dataMap.containsKey("Actor")) {
					lavanteUtils.click(getActor(dataMap));
					lavanteUtils.switchtoFrame(IFrameUserDetails);
				}
				dataMap.put("Actor", actor);
			}

		}
	}

	/**
	 * @author Vidya.C
	 * @param dataMap
	 */
	private WebElement getActor(LinkedHashMap<String, String> dataMap) {
		String data = "//div[@id='approvalHistory']//td[contains(text(),'" + dataMap.get("ActionTaken")
				+ "')]/following-sibling::td/a";
		WebElement actor;
		try {
			actor = lavanteUtils.driver.findElement(By.xpath(data));
		} catch (Exception e) {
			actor = null;
		}
		return actor;
	}

	/**
	 * Add private/public comments
	 * 
	 * @author subhas.bv
	 * 
	 */
	public void addComment(LinkedHashMap<String, String> dataMap) {
		lavanteUtils.switchtoFrame(null);
		if (!dataMap.containsKey("Editcomment")) {
			if (lavanteUtils.isElementDisplayed(addCommentBtn)) {
				lavanteUtils.clicks(AddCommentBtn);
			}
		}

		if (dataMap.containsKey("EnterComment")) {
			lavanteUtils.fluentwait(EnterCommentsTxtArea);
			EnterCommentsTxtArea.clear();
			lavanteUtils.typeinEdit(dataMap.get("EnterComment"), EnterCommentsTxtArea);
		}
		if (dataMap.containsKey("PrivateComment")) {
			lavanteUtils.clicks(privateRadioBtn);
		}
		if (dataMap.containsKey("PublicComment")) {
			lavanteUtils.clicks(publicRadioBtn);
		}
		lavanteUtils.clicks(AddCommentsBtn);
	}

	
/*	public void getCommentsSectionData(LinkedHashMap<String, String> dataMap) {

		String obj = "//p[contains(text(),'" + dataMap.get("CommentTxt")
				+ "')]/parent::div[1][starts-with(@class,'commentText')]/preceding-sibling::div[starts-with(@class,'userInfo')]/time/following-sibling::div/descendant::a[@id='dLabel']";

	}*/
	
	
	/**
	 * Fetch data  from view page
	 * 
	 * @param Col
	 * @return
	 */
	public String fetchData(String Col){
		WebElement e=lavanteUtils.driver.findElement(By.xpath("//*[contains(text(),'"+Col+"')]/../..//dd"));
		boolean f=lavanteUtils.isElementDisplayed(e);
		
		String act="";
		if(Col.equalsIgnoreCase("Invoice Number")){
			 e=lavanteUtils.driver.findElement(By.xpath("//*[contains(text(),'"+Col+"')]/../..//dd//a"));
		}
		
		if(f==true){
			act=e.getText().trim();
		}
		
		return act;
	}
	

	
	
}