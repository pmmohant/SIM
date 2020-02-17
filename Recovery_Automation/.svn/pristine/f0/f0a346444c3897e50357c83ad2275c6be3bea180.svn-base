package lavante.recovery.pageobjects;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import junit.framework.Assert;
import lavante.recovery.utilities.seleniumBaseClass;
import lavante.recovery.utilities.LavanteUtils;

public class MainClaimsPage {
	
	LavanteUtils lavanteUtils=new LavanteUtils();
	public MainClaimsPage(WebDriver driver){
		lavanteUtils.driver=driver;
	}
	
	//Main Claims Link
	@FindBy(linkText="Claims")
	private WebElement claimsLink;
	public WebElement claimsLink(){
		return claimsLink;
	}
	
	public WebElement verifyclaimsLink() {
		lavanteUtils.fluentwait(claimsLink);
		//click("claimsLink",claimsLink);
		return claimsLink;
	}

	//Total Claims table
	//@FindBy(css="#content div:nth-child(2) tbody tr td:nth-child(3) a")
	@FindBy(css="table tr td span[class='highlight_green']")	//added by Ramya
	private WebElement totalClaimsTable;
	public WebElement totalClaimsTable(){		//added by Ramya
		return totalClaimsTable;
	}
		
	public void verifytotalClaimsTable() {
		
		lavanteUtils.isDisplayed("totalClaimsTable",totalClaimsTable);
		lavanteUtils.verifyError(totalClaimsTable);	
	}
	
	//Claims List table
	//@FindBy(css="#claimDetailsTable tr td a")
	@FindBy(id="claimDetailsTable") 			//added by Ramya
	private WebElement claimsListTable;
	public WebElement claimsListTable(){  		//added by Ramya
		return claimsListTable;
		
	}
		
	public void verifyclaimsListTable() {
		lavanteUtils.fluentwait(claimsListTable);
		lavanteUtils.isDisplayed("claimsListTable",claimsListTable);
		lavanteUtils.verifyError(claimsListTable);	
	}

	//Claims List--Document icon 
	@FindBy(css="#claims-list tr:nth-child(1) td:nth-child(16) a")
	private WebElement docIconClaimsList;
	public WebElement doIconClaimsList(){
		return docIconClaimsList;
	}
	
	//Claims List--Document icon--Reference
	@FindBy(css=".data_table tr:nth-child(1) td[class='align_left']")
	public WebElement docIconReference;
	public WebElement docIconReference(){					//added by Ramya
		return docIconReference;
	}
	
	
	//Claims List--Document icon--Amount
	@FindBy(css=".data_table tr:nth-child(4) td[class='align_left']")
	public WebElement docIconAmt;
	public WebElement docIconAmt(){							//Added by Ramya
		return docIconAmt;
	}
	
	
	//Claims List--Document icon--Claim ID
	@FindBy(css="div[title='Claim Details'] span")
	public WebElement docIconClaimID;
	public WebElement docIconClaimID(){						//added by Ramya
		return docIconClaimID;
	}
	
	//Claims List--Claim ID
	@FindBy(css="#claimDetailsTable tr:nth-child(1) td:nth-child(5) a")
	private WebElement claimListClaimID;
	public WebElement claimListClaimID(){
		return claimListClaimID;
	}
	
	//Claims List--Supplier Reference
	@FindBy(css="#claimDetailsTable tr:nth-child(1) td:nth-child(6)")
	public WebElement claimListSuppRefence;
	public WebElement claimListSuppRefence(){				//added by Ramya
		return claimListSuppRefence;
	}
	
	//Claims List--Claim Amount
	@FindBy(css="#claimDetailsTable tr:nth-child(1) td:nth-child(8)")
	public WebElement claimListAmt;
	public WebElement claimListAmt(){						//added by Ramya
		return claimListAmt;
	}
	
	
	//Claims List--Claim Status
	@FindBy(css="#claimDetailsTable tr:nth-child(1) td:nth-child(12)")
	public WebElement claimListStatus;
	public WebElement claimListStatus(){					//added by Ramya
		return claimListStatus;
	}
	
	//Claims List--Edit Claims icon
	@FindBy(css="#claimDetailsTable tr:nth-child(1) td:nth-child(2) a")
	public WebElement editClaimsIcon;
	public WebElement editClaimsIcon(){						//added  by Ramya
		return editClaimsIcon;
	}
	
	//Edit Claims--Claim ID
	@FindBy(css="#editClaimsTable tr:nth-child(1) td:nth-child(2) label")
	public WebElement editClaimsClaimID;
	
	//Edit Claims--Claim Amt
	@FindBy(css="#editClaimsTable tr:nth-child(3) td:nth-child(2) span:nth-child(1)")
	public WebElement editClaimsClaimAmt;
	
	//Edit Claims--Supplier Reference
	@FindBy(css="#editClaimsTable tr:nth-child(5) td:nth-child(2) label")
	public WebElement editClaimsSuppRef;
	
	//Edit Claims--Claim status
	@FindBy(css="#editClaimsTable tr:nth-child(2) td:nth-child(2) #claimStatus_chosen a")
	public WebElement editClaimsClaimStatus;
	
	//Claims Queue--Supplier
	@FindBy(css="#queue-navigation tbody tr td:nth-child(1)")
	public List <WebElement> supplierNameClaimQueueTable;
	
	//Claims Queue--Supplier ID
	@FindBy(css="#queue-navigation tbody tr td:nth-child(2)")
	public List <WebElement> suppIDinClaimQueueTable;
	
	//Claims Queue--Claim ID
	@FindBy(css="#queue-navigation tbody tr td:nth-child(3)")
	private List <WebElement> claimIDinClaimQueueTable;
	
	//Claims Queue--Supp Ref
	@FindBy(css="#queue-navigation tbody tr td:nth-child(4)")
	private List <WebElement> suppRefinClaimQueueTable;
	
	//Claims Queue--Claim Amt
	@FindBy(css="#queue-navigation tbody tr td:nth-child(6)")
	private List <WebElement> claimAmtinClaimQueueTable;
	
	//Claims Queue--Claim Status
	@FindBy(css="#queue-navigation tbody tr td:nth-child(8)")
	private List <WebElement> claimStatusinClaimQueueTable;
	
	public void verifyViewDocumentInClaimsPage(){
		String claimListINClaimID = lavanteUtils.getText("claimListClaimID", claimListClaimID);
		String claimListINSuppRefence = lavanteUtils.getText("claimListSuppRefence", claimListSuppRefence);
		String claimListINAmt = lavanteUtils.getText("claimListAmt", claimListAmt);
		
		lavanteUtils.click(docIconClaimsList);
		
		String docIconINClaimID = lavanteUtils.getText("docIconClaimID", docIconClaimID);
		String docIconINReference = lavanteUtils.getText("docIconReference", docIconReference);
		String docIconINAmt = lavanteUtils.getText("docIconAmt", docIconAmt);
		
		Assert.assertEquals(claimListINClaimID, docIconINClaimID);
		Assert.assertEquals(claimListINSuppRefence, docIconINReference);
		Assert.assertEquals(claimListINAmt, docIconINAmt);
	}
	
	public void verifyClaimDetailsinEditClaimsPage(){

		String claimListINClaimID = lavanteUtils.getText("claimListClaimID", claimListClaimID);
		String claimListINStatus = lavanteUtils.getText("claimListStatus", claimListStatus);
		String claimListINAmt = lavanteUtils.getText("claimListAmt", claimListAmt);
		String claimListINSuppRefence = lavanteUtils.getText("claimListSuppRefence", claimListSuppRefence);

		lavanteUtils.click(editClaimsIcon);
		lavanteUtils.waitForTime(5000);

		String editClaimsINClaimID = lavanteUtils.getText("editClaimsClaimID", editClaimsClaimID);
		String editClaimsINClaimStatus = lavanteUtils.getText("editClaimsClaimStatus", editClaimsClaimStatus);
		String editClaimsINClaimAmt = lavanteUtils.getText("editClaimsClaimAmt", editClaimsClaimAmt);
		String editClaimsINSuppRef = lavanteUtils.getText("editClaimsSuppRef", editClaimsSuppRef);
		
	//	Assert.assertEquals(claimListINClaimID, editClaimsINClaimID);
		Assert.assertEquals(claimListINStatus, editClaimsINClaimStatus);
		Assert.assertEquals(claimListINAmt, editClaimsINClaimAmt);
		Assert.assertEquals(claimListINSuppRefence, editClaimsINSuppRef);
	}
	
	public void verifyClaimDetailsinEditClaimsPageClaimsQueue(){
		Random rn = new Random();
		int claimQueueRowNo = rn.nextInt(5);
		
	/*	click(editClaimsIcon);
		waitForTime(5000);*/
		
		claimIDinClaimQueueTable.get(claimQueueRowNo).click();
		lavanteUtils.waitForTime(5000);
		
		String claimQueueINClaimID = lavanteUtils.getText("claimIDinClaimQueueTable", claimIDinClaimQueueTable.get(claimQueueRowNo));
		String claimQueueINStatus = lavanteUtils.getText("claimStatusinClaimQueueTable", claimStatusinClaimQueueTable.get(claimQueueRowNo));
		String claimQueueINAmt = lavanteUtils.getText("claimAmtinClaimQueueTable", claimAmtinClaimQueueTable.get(claimQueueRowNo));
		String claimQueueINSuppRefence = lavanteUtils.getText("suppRefinClaimQueueTable", suppRefinClaimQueueTable.get(claimQueueRowNo));

		String editClaimsINClaimID = lavanteUtils.getText("editClaimsClaimID", editClaimsClaimID);
		String editClaimsINClaimStatus = lavanteUtils.getText("editClaimsClaimStatus", editClaimsClaimStatus);
		String editClaimsINClaimAmt = lavanteUtils.getText("editClaimsClaimAmt", editClaimsClaimAmt);
		String editClaimsINSuppRef = lavanteUtils.getText("editClaimsSuppRef", editClaimsSuppRef);
		
		Assert.assertEquals(claimQueueINClaimID, editClaimsINClaimID);
		Assert.assertEquals(claimQueueINStatus, editClaimsINClaimStatus);
		Assert.assertEquals(claimQueueINAmt, editClaimsINClaimAmt);
		Assert.assertEquals(claimQueueINSuppRefence, editClaimsINSuppRef);
	}
	
	
	
	
	
}




