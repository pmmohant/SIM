package com.lavante.sim.customer.pageobjects.Transactions.Payments;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.lavante.sim.Common.Util.LavanteUtils;
import com.sun.glass.events.KeyEvent;

public class ViewPaymentsPage {

	LavanteUtils lavanteUtils = new LavanteUtils();
	public static String dir = System.getProperty("TestData") + File.separator + "data";

	public ViewPaymentsPage(WebDriver driver) {
		lavanteUtils.driver = driver;
	}

	@FindBy(id = "invoiceNumber")
	private WebElement invoiceNumLink;

	public WebElement invoiceNumLink() {
		return invoiceNumLink;
	}
	
	@FindBy(css = "a[href*='create']")
	public WebElement createClaim;

	@FindBy(css = "a[href*='uploadPaymentSupportingDocs.lvp']")
	private WebElement addDocumentsLink;

	public WebElement addDocumentsLink() {
		return addDocumentsLink;
	}

	@FindBy(css = "iframe[src*='uploadPaymentSupportingDocs.lvp']")
	private WebElement IFrameUploadDocs;

	public WebElement IFrameUploadDocs() {
		return IFrameUploadDocs;
	}

	// [id*='uploadSection'] button
	@FindBy(css = "input[type*='file']")
	private WebElement selectFileBtn;

	public WebElement selectFileBtn() {
		return selectFileBtn;
	}

	@FindBy(css = "table#uploadDocTable tr[style*='table-row'] td>select")
	private List<WebElement> documentTypeDrpdwn;

	public List<WebElement> documentTypeDrpdwn() {
		return documentTypeDrpdwn;
	}

	@FindBy(css = "tr[style*='table-row'] #rowUploadFile")
	private List<WebElement> documentUploaded;

	public List<WebElement> documentUploaded() {
		return documentUploaded;
	}

	@FindBy(css = "span[class*='glyphicon-remove']")
	private List<WebElement> documentDelete;

	public List<WebElement> documentDelete() {
		return documentDelete;
	}

	@FindBy(css = ".uploadError")
	private WebElement uploadErrText;

	public WebElement uploadErrText() {
		return uploadErrText;
	}

	@FindBy(id = "btnSubmit")
	private WebElement fileSaveBtn;

	public WebElement fileSaveBtn() {
		return fileSaveBtn;
	}

	@FindBy(css = "button[title='Cancel']")
	private WebElement fileCancelBtn;

	public WebElement fileCancelBtn() {
		return fileCancelBtn;
	}

	@FindBy(css = ".button_primary>span")
	private WebElement fileDeleteBtn;

	public WebElement fileDeleteBtn() {
		return fileDeleteBtn;
	}

	@FindBy(css = ".data_table.table_grid.wrap.table-layout-fixed.zebra td:nth-child(2)>a")
	private List<WebElement> docNameList;

	public List<WebElement> docNameList() {
		return docNameList;
	}

	@FindBy(xpath = "//table[contains(@class,'table-layout-fixed zebra')]//td[contains(text(),'Supplier') and @title='']/following-sibling::td/a")
	private List<WebElement> SupplierDelList;

	public List<WebElement> SupplierDelList() {
		return SupplierDelList;
	}

	@FindBy(xpath = "//table[contains(@class,'table-layout-fixed zebra')]//td[contains(text(),'Buyer') and @title='']/following-sibling::td/a")
	private List<WebElement> BuyerDelList;

	public List<WebElement> BuyerDelList() {
		return BuyerDelList;
	}

	@FindBy(css = ".data_table.table_grid.wrap.table-layout-fixed.zebra>thead th")
	private List<WebElement> docTableHeaders;

	public List<WebElement> docTableHeaders() {
		return docTableHeaders;
	}

	@FindBy(css = ".prgx-text-link")
	private WebElement backLink;

	public WebElement backLink() {
		return backLink;
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
	
	@FindBy(css = "[id*='public_question']")
	private WebElement QnRadioBtn;

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

	@FindBy(css = "tbody>tr:nth-child(1)>td:nth-child(1)")
	private WebElement UserName;

	public WebElement UserName() {
		return UserName;
	}

	@FindBy(css = "tbody>tr:nth-child(1)>td:nth-child(2)")
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

	// Submit Questions
	@FindBy(css = "#addQuestion")
	private WebElement ViewPageSubmitQuesBtn;

	public WebElement ViewPageSubmitQuesBtn() {
		return ViewPageSubmitQuesBtn();
	}

	@FindBy(css = "[class*='submitQuestionTextArea']")
	private WebElement QuestionsTextArea;

	public WebElement QuestionsTextArea() {
		return QuestionsTextArea;
	}

	@FindBy(css = "div[class*='buttons-container'] button[class*='button_primary ng-binding']")
	private WebElement QuestSaveBtn;

	public WebElement QuestSaveBtn() {
		return QuestSaveBtn;
	}

	@FindBy(css = "#bannerDiv")
	private WebElement BannerMsg;

	public WebElement BannerMsg() {
		return BannerMsg;
	}

	@FindBy(css = "div[data-ng-if*='isQuestion'] p")
	private List<WebElement> QuestionTagList;

	public List<WebElement> QuestionTagList() {
		return QuestionTagList;
	}

	@FindBy(css = "div[data-ng-if*='isQuestion']+p[class*='commentUserText']")
	private List<WebElement> QuestionCommentsList;

	public List<WebElement> QuestionCommentsList() {
		return QuestionCommentsList;
	}

	// Add/Verify Comments
	@FindBy(id = "addComments")
	private WebElement AddCommentBtn;

	public WebElement AddCommentBtn() {
		return AddCommentBtn;
	}

	@FindBy(css = "button[class*='button_primary']")
	private WebElement AddCommentsBtn;

	public WebElement AddCommentsBtn() {
		return AddCommentsBtn;
	}

	@FindBy(id = "flex")
	private WebElement EnterCommentsTxtArea;

	public WebElement EnterCommentsTxtArea() {
		return EnterCommentsTxtArea;
	}

	@FindBy(css = "div[class*='ui-dialog'] button[class='button_primary']")
	private WebElement DeleteBtn;

	public WebElement DeleteBtn() {
		return DeleteBtn;
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

	@FindBy(css = "img[src*='ic_comment_black']")
	private List<WebElement> CommentImg;

	public List<WebElement> CommentImg() {
		return CommentImg;
	}

	@FindBy(css = "sup[id='readUnreadComments']")
	private List<WebElement> GetCommentCountSearchPage;

	public List<WebElement> GetCommentCountSearchPage() {
		return GetCommentCountSearchPage;
	}

	public String ListCommentOptions = "//p[contains(text(),'$')]/parent::div[1][starts-with(@class,'commentText')]/preceding-sibling::div[starts-with(@class,'userInfo')]/time/following-sibling::div/descendant::ul[@role='menu']/li/a";

	public String CommentOptionIcon = "//p[contains(text(),'$')]/parent::div[1][starts-with(@class,'commentText')]/preceding-sibling::div[starts-with(@class,'userInfo')]/time/following-sibling::div/descendant::a[@id='dLabel']";

	public String EditCommentTxtArea = "//p[contains(text(),'$')]/following-sibling::div[1]/textarea";

	public String SaveComment = "//p[starts-with(text(),'$')]/following-sibling::div[1]/div/button[@class='button button_primary']";

	// claims section

	@FindBy(css = "//span[starts-with(text(),'Associated Claims')]/ancestor::div[@class='header']/following-sibling::div//tr/td")
	private List<WebElement> GetClaimNoResultsTxt;

	public List<WebElement> GetClaimNoResultsTxt() {
		return GetClaimNoResultsTxt;
	}

	/**
	 * Add private/public comments
	 * 
	 * @author subhas.bv
	 * 
	 */
	public void addComment(LinkedHashMap<String, String> dataMap) {

		lavanteUtils.switchtoFrame(null);
		if (lavanteUtils.isElementDisplayed(addCommentBtn)) {
			lavanteUtils.clicks(AddCommentBtn);
		}
		lavanteUtils.fluentwait(EnterCommentsTxtArea);
		if(dataMap.containsKey("EnterComment")){
			lavanteUtils.typeinEdit(dataMap.get("EnterComment"), EnterCommentsTxtArea);
		}
		if (dataMap.containsKey("PrivateComment")) {
			lavanteUtils.clicks(privateRadioBtn);
		}
		if (dataMap.containsKey("PublicComment")) {
			lavanteUtils.clickJavaScriptNoWait(publicRadioBtn);
		}
		if (dataMap.containsKey("Question")) {
			lavanteUtils.typeinEdit(dataMap.get("Question"), EnterCommentsTxtArea);
			lavanteUtils.clickJavaScriptNoWait(QnRadioBtn);
		}
		lavanteUtils.clicks(AddCommentsBtn);
		
		lavanteUtils.fluentwait(BannerMsg);
		dataMap.put("QuesBannerMsg", BannerMsg.getText());
	}

	/**
	 * Method to upload documents in Payment view page
	 * 
	 * @param dataMap
	 * @throws IOException
	 * @throws AWTException
	 */
	public void addDocuments(LinkedHashMap<String, String> dataMap) throws IOException, AWTException {

		lavanteUtils.click(addDocumentsLink);
		lavanteUtils.switchtoFrame(IFrameUploadDocs);

		String data = dataMap.get("Document");
		String data1 = dataMap.get("DocumentType");
		if (data.contains("#")) {
			String[] docArray = data.split("#");
			for (int i = 0; i < docArray.length; i++) {
				// uploadFile(docArray[i]);
				lavanteUtils.click(selectFileBtn);
				lavanteUtils.uploadFile(docArray[i], selectFileBtn);

				lavanteUtils.waitForTime(2000);
			}
			if (docArray.length == 5) {
				// To get the error message if the upload exceeds more than 5
				// files
				lavanteUtils.click(selectFileBtn);
				lavanteUtils.uploadFile(dataMap.get("Invfile"), selectFileBtn);

				dataMap.put("UploadError", uploadErrText.getText());
			}
		} else {
			uploadFile(data);
			lavanteUtils.waitForTime(2000);
		}
		// To delete the uploaded files
		if (dataMap.containsKey("Delete")) {
			int size = documentDelete.size();
			for (int k = size - 1; k > 0; k--) {
				lavanteUtils.click(documentDelete.get(k));
			}
			lavanteUtils.waitForTime(3000);
			dataMap.put("Document", documentUploaded.get(0).getText());
		}
		if (data1.contains("#")) {
			String[] typeArray = data1.split("#");
			for (int j = 0; j < typeArray.length; j++) {
				lavanteUtils.selectbyvisibiletxt(typeArray[j], documentTypeDrpdwn.get(j));
			}
		} else {
			lavanteUtils.selectbyvisibiletxt(data1, documentTypeDrpdwn.get(0));
		}
		formActions(dataMap);
	}

	public void formActions(LinkedHashMap<String, String> dataMap) {
		lavanteUtils.switchtoFrame(IFrameUploadDocs);

		if (dataMap.containsKey("Save")) {
			lavanteUtils.click(fileSaveBtn);
		}
		if (dataMap.containsKey("Cancel")) {
			lavanteUtils.click(fileCancelBtn);
		}
		lavanteUtils.switchtoFrame(null);
	}

	/**
	 * Method to get the name of the document, document type details of the
	 * uploaded file
	 * 
	 * @param dataMap
	 * @param docName
	 */
	public void getDocumentDetails(LinkedHashMap<String, String> dataMap, String docName) {
		String locator = "";
		if (dataMap.containsKey("TableDocumentType")) {
			locator = "//td[2]/a[.='" + docName + "']/../preceding-sibling::td";
			String text = lavanteUtils.driver.findElement(By.xpath(locator)).getText();
			dataMap.put("TableDocumentType", text);
		}
		if (dataMap.containsKey("DocumentName")) {
			locator = "//td[2]/a[.='" + docName + "']";
			String text = lavanteUtils.driver.findElement(By.xpath(locator)).getText();
			dataMap.put("DocumentName", text);
		}
		if (dataMap.containsKey("UploadedBy")) {
			locator = "//td[2]/a[.='" + docName + "']/../following-sibling::td[3]";
			String text = lavanteUtils.driver.findElement(By.xpath(locator)).getText();
			dataMap.put("UploadedBy", text);
		}
		if (dataMap.containsKey("DeleteDoc")) {
			locator = "//td[2]/a[.='" + docName + "']/../following-sibling::td[4]/a";
			dataMap.put("DeleteDoc", locator);
		}
	}

	/**
	 * Method to upload a file from local using robot class
	 * 
	 * @author Vidya.C
	 * @param fileName
	 * @throws AWTException
	 * @throws IOException
	 */
	public void uploadFile(String fileName) throws AWTException, IOException {
		lavanteUtils.click(selectFileBtn);

		String path = LavanteUtils.getPresentWorkingDir() + File.separator + dir + File.separator + fileName;
		StringSelection ss = new StringSelection(path);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

		Robot robot = new Robot();
		robot.delay(300);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	/**
	 * Method to submit question in details page
	 * 
	 * @param dataMap
	 */
	public void SubmitQuestion(LinkedHashMap<String, String> dataMap) {
		if (dataMap.containsKey("Question")) {
			lavanteUtils.clicks(ViewPageSubmitQuesBtn);
			lavanteUtils.typeinEdit(dataMap.get("Question"), QuestionsTextArea);
			lavanteUtils.clicks(QuestSaveBtn);
			lavanteUtils.fluentwait(BannerMsg);
			dataMap.put("QuesBannerMsg", BannerMsg.getText());
		}
	}
}
