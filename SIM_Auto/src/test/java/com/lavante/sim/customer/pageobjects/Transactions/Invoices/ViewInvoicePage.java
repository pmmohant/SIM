package com.lavante.sim.customer.pageobjects.Transactions.Invoices;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.lavante.sim.Common.Util.LavanteUtils;

public class ViewInvoicePage {
	LavanteUtils lavanteUtils = new LavanteUtils();
	public static String dir = System.getProperty("TestData") + File.separator + "data";

	public ViewInvoicePage(WebDriver driver) {
		lavanteUtils.driver = driver;
	}

	@FindBy(xpath = "//span[contains(text(),'Invoice Header')]")
	private WebElement invoiceHeaderTxt;

	public WebElement invoiceHeaderTxt() {
		return invoiceHeaderTxt;
	}
	
	@FindBy(xpath = "//span[contains(text(),'Net Amount')]/../..//dd")
	private WebElement NetAmntTxt;

	public WebElement NetAmntTxt() {
		return NetAmntTxt;
	}

	@FindBy(css = "a[href*='uploadInvoiceSupportingDocs.lvp']")
	private WebElement addDocumentsLink;

	public WebElement addDocumentsLink() {
		return addDocumentsLink;
	}

	@FindBy(css = "iframe[src*='uploadInvoiceSupportingDocs.lvp']")
	private WebElement IFrameUploadDocs;

	public WebElement IFrameUploadDocs() {
		return IFrameUploadDocs;
	}

	@FindBy(id = "uploadedFileButton")
	private WebElement selectFileBtn;

	public WebElement selectFileBtn() {
		return selectFileBtn;
	}

	@FindBy(css = ".button_primary>span")
	private WebElement fileDeleteBtn;

	public WebElement fileDeleteBtn() {
		return fileDeleteBtn;
	}
//	@FindBy(id = "fileselect")
//	private WebElement fileselect;
//
//	public WebElement fileselect() {
//		return fileselect;
//	}

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

	@FindBy(css = "a[href*='downloadAttachment.lvp']")
	private List<WebElement> docNameList;

	public List<WebElement> docNameList() {
		return docNameList;
	}
	
	@FindBy(css = "#invoiceStatus tr>td:nth-child(6)")
	private List<WebElement> ApprovalComntList;

	public List<WebElement> ApprovalComntList() {
		return ApprovalComntList;
	}
	
	//Submit Questions
	@FindBy(css = "a[href*='createClaim']")
	private WebElement CreateClaimBtn;
	public WebElement CreateClaimBtn() {
		return CreateClaimBtn;
	}
	
	@FindBy(css = "#addQuestion")
	private WebElement ViewPageSubmitQuesBtn;

	public WebElement ViewPageSubmitQuesBtn() {
		return ViewPageSubmitQuesBtn();
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

	@FindBy(xpath = "	//div[contains(@data-ng-if,'isPrivate')]/../..//a[contains(@data-ng-click,'Edit')]")
	public List<WebElement> EditPrivateComments;

	@FindBy(xpath = "	//div[contains(@data-ng-if,'isPrivate')]/../..//a[contains(@data-ng-click,'delete')]")
	public List<WebElement> DeletePrivateComments;

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


	@FindBy(css = "div[class*='ui-dialog'] button[class='button_primary']")
	private WebElement DeleteBtn;

	public WebElement DeleteBtn() {
		return DeleteBtn;
	}
	
	public String ListCommentOptions = "//p[contains(text(),'$')]/parent::div[1][starts-with(@class,'commentText')]/preceding-sibling::div[starts-with(@class,'userInfo')]/time/following-sibling::div/descendant::ul[@role='menu']/li/a";
	
	public String CommentOptionIcon = "//p[contains(text(),'$')]/parent::div[1][starts-with(@class,'commentText')]/preceding-sibling::div[starts-with(@class,'userInfo')]/time/following-sibling::div/descendant::a[@id='dLabel']";
	
	public String EditCommentTxtArea = "//p[contains(text(),'$')]/following-sibling::div[1]/textarea";

	public String SaveComment = "//p[starts-with(text(),'$')]/following-sibling::div[1]/div/button[@class='button button_primary']";

	
	
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

	@FindBy(css="[class*='submitQuestionTextArea']")
	private WebElement QuestionsTextArea;

	public WebElement QuestionsTextArea() {
		return QuestionsTextArea;
	}

	@FindBy(css="div[class*='buttons-container'] button[class*='button_primary ng-binding']")
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
				uploadFile(docArray[i]);
				lavanteUtils.waitForTime(2000);
			}
			if (docArray.length == 5) {
				// To get the error message if the upload exceeds more than 5
				// files
				lavanteUtils.click(selectFileBtn);
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
	 * @param dataMap
	 */
	public void SubmitQuestion(LinkedHashMap<String, String> dataMap) {
		if(dataMap.containsKey("Question")) {
			lavanteUtils.clicks(ViewPageSubmitQuesBtn);
			lavanteUtils.typeinEdit(dataMap.get("Question"), QuestionsTextArea);
			lavanteUtils.clicks(QuestSaveBtn);
			lavanteUtils.fluentwait(BannerMsg);
			dataMap.put("QuesBannerMsg", BannerMsg.getText());
		}
	}
	
	public List<WebElement> iterateAssociatedSearchHeaderFindColList(String col) {
		List<WebElement> s = null;
		List<WebElement> e=lavanteUtils.driver.findElements(By.xpath("//*[contains(text(),'Associated Claims')]/../../..//div[2]//th"));
		
		int j = ColIdentify(e,col);
		String x = "//*[contains(text(),'Associated Claims')]/../../..//div[2]//td["+j+"]";
		
		s = lavanteUtils.driver.findElements(By.xpath(x));
		System.out.println("Iterate col locator:" + x + ",Size:" + s.size());
		if (col.contains("Claim ID")) {
			x = "//*[contains(text(),'Associated Claims')]/../../..//div[2]//td["+j+"]//a";
			System.out.println("Iterate for Claim:" + x);
			s = lavanteUtils.driver.findElements(By.xpath(x));
		}
		System.out.println("Iterate Search Col:" + col + ":" + s.size());
		return s;
	}
	
	private int ColIdentify(List<WebElement> Headers,String col) {
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

	
	/**
	 * Fetching Associated Claim Values
	 * 
	 * @author Piramanayagam.S
	 * @param colHeader
	 * @return String Value
	 */
	public List<String> fetchAssClaimValue(String colHeader) {
		List<WebElement> x=iterateAssociatedSearchHeaderFindColList(colHeader);
		List<String> colValue=new ArrayList<String>();
		
		for(int ji=0;ji<x.size();ji++){
			if(x.get(ji).getText().length()>0){
				colValue.add(x.get(ji).getText());
			}
		}
		return colValue;
	}
}
