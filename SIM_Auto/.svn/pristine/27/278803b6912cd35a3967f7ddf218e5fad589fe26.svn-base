
package com.lavante.sim.customer.pageobjects.Admin.ManageFiles;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import com.lavante.sim.Common.Util.LavanteUtils;

/**
 * @author Piramanayagam.S
 *
 */
public class UploadFiles {

	LavanteUtils lavanteUtils = new LavanteUtils();
	public WebDriver driver;

	public UploadFiles(WebDriver driver) {
		lavanteUtils.driver = driver;
		this.driver = driver;
	}

	@FindBy(css="[id*='sub'] [href*='customerUploadFiles']")
	private WebElement Pageuploadfile;

	public WebElement Pageuploadfile() {
		return Pageuploadfile;
	}

	@FindBy(css="iframe[class*='iframe']")
	private WebElement IFRAME;

	@FindBy(css="iframe[src*='VMFFile']")
	private WebElement IFRAMEVMFuploadFile;

	public WebElement IFRAMEVMFuploadFile() {
		return IFRAMEVMFuploadFile;
	}
	
	@FindBy(css="iframe[src*='userFile']")
	private WebElement IFRAMEuserFile;

	public WebElement IFRAMEuserFile() {
		return IFRAMEuserFile;
	}

	@FindBy(css="iframe[src*='invoiceFile']")
	private WebElement IFRAMEInvuploadFile;

	public WebElement IFRAMEInvuploadFile() {
		return IFRAMEInvuploadFile;
	}

	@FindBy(css="iframe[src*='spendFile']")
	private WebElement IFRAMESpenduploadFile;

	public WebElement IFRAMESpenduploadFile() {
		return IFRAMESpenduploadFile;
	}

	@FindBy(css="iframe[src*='location']")
	private WebElement IFRAMELocationuploadFile;

	public WebElement IFRAMELocationuploadFile() {
		return IFRAMELocationuploadFile;
	}

	@FindBy(css="iframe[src*='contact']")
	private WebElement IFRAMEContactuploadFile;

	public WebElement IFRAMEContactuploadFile() {
		return IFRAMEContactuploadFile;
	}
	
	@FindBy(css="iframe[src*='divisionFileDetails']")
	private WebElement IFRAMEDivisonuploadFile;

	public WebElement IFRAMEDivisonuploadFile() {
		return IFRAMEDivisonuploadFile;
	}
	
	@FindBy(css="iframe[src*='divisionMapping']")
	private WebElement IFRAMEDivisonMappinguploadFile;

	public WebElement IFRAMEDivisonMappinguploadFile() {
		return IFRAMEDivisonMappinguploadFile;
	}
	
	@FindBy(css="iframe[src*='paymentCenterDivisionMappingFileDetails']")
	private WebElement IFRAMEpaymentCenterFile;

	public WebElement IFRAMEpaymentCenterFile() {
		return IFRAMEpaymentCenterFile;
	}

	@FindBy(css="iframe[src*='PaymentTerm']")
	private WebElement IFRAMEpaymentTermFile;

	public WebElement IFRAMEpaymentTermFile() {
		return IFRAMEpaymentTermFile;
	}
	
	@FindBy(css="iframe[src*='eft']")
	private WebElement IFRAMEEFTFile;

	public WebElement IFRAMEEFTFile() {
		return IFRAMEEFTFile;
	}

	
	

	
	// End of IFRAM

	@FindBy(css="div[class='header'] td[class*='caption']")
	private WebElement uploadFiletitle;

	public WebElement uploadFiletitle() {
		return uploadFiletitle;
	}

	@FindBy(css="td:nth-child(3) a")
	private List<WebElement> ListUploadFileTemplate;

	public List<WebElement> ListUploadFileTemplate() {
		return ListUploadFileTemplate;
	}

	// Tab Selection
	
	@FindBy(css="a[href*='#userCreation']")
	private WebElement TabUser;

	public WebElement TabUser() {
		return TabUser;
	}
	
	@FindBy(css="a[href*='spend']")
	private WebElement TabSpend;

	public WebElement TabSpend() {
		return TabSpend;
	}

	@FindBy(css="a[href*='invoice']")
	private WebElement TabInvoice;

	public WebElement TabInvoice() {
		return TabInvoice;
	}
	
	@FindBy(css="a[href*='location']")
	private WebElement TabLocation;

	public WebElement TabLocation() {
		return TabLocation;
	}

	@FindBy(css="a[href*='contact']")
	private WebElement TabContact;

	public WebElement TabContact() {
		return TabContact;
	}
	
	@FindBy(css="a[href*='division_details']")
	private WebElement TabDivison;

	public WebElement TabDivison() {
		return TabDivison;
	}
	
	@FindBy(css="a[href*='divisionMapping']")
	private WebElement TabDivisonMapping;

	public WebElement TabDivisonMapping() {
		return TabDivisonMapping;
	}
	
	@FindBy(css="a[href*='#paymentCenter_division']")
	private WebElement TabPaymentCenter;

	public WebElement TabPaymentCenter() {
		return TabPaymentCenter;
	}
	
	@FindBy(css="a[href*='#paymentCenter_Payment']")
	private WebElement TabPaymentTerm;

	public WebElement TabPaymentTerm() {
		return TabPaymentTerm;
	}
	
	@FindBy(css="a[href*='Eft']")
	private WebElement TabEFT;

	public WebElement TabEFT() {
		return TabEFT;
	}


	// Search

	@FindBy(css="[id*='fileType'] a")
	private WebElement uploadTypedpdn;

	public WebElement uploadTypedpdn() {
		return uploadTypedpdn;
	}

	@FindBy(how = How.ID, using = "multipartFile")
	private WebElement brwsebtn;

	public WebElement brwsebtn() {
		return brwsebtn;
	}

	@FindBy(how = How.ID, using = "isFileOverWrite")
	private WebElement updateRecords;

	public WebElement updateRecords() {
		return updateRecords;
	}

	@FindBy(css="[id='upload_button'][type='submit']")
	private WebElement uploadbtn;

	public WebElement uploadbtn() {
		return uploadbtn;
	}

	@FindBy(css="[role*='dia'] button[class*='primary']")
	private WebElement OKbtn;

	public WebElement OKbtn() {
		return OKbtn;
	}

	@FindBy(css="[style*='block'] [class*='refresh']")
	private WebElement refreshBtn;

	public WebElement refreshBtn() {
		return refreshBtn;
	}

	// Table
	@FindBy(css="[id*='upload'] td:nth-child(1) a")
	private List<WebElement> ListUploadFile;

	public List<WebElement> ListUploadFile() {
		return ListUploadFile;
	}
	
	@FindBy(css="[id*='uploadedFileDetailsDiv'] td:nth-child(2)")
	private List<WebElement> ListUploadFileOn;

	public List<WebElement> ListUploadFileOn() {
		return ListUploadFileOn;
	}

	@FindBy(css="[id*='upload'] td:nth-child(4)")
	private List<WebElement> ListUploadStatus;

	public List<WebElement> ListuploadStatus() {
		return ListUploadStatus;
	}

	// VMF
	@FindBy(css="[id*='upload'] td:nth-child(6)")
	private List<WebElement> ListVMFUploadUniqrecord;

	public List<WebElement> VMFUploadListUniqrecord() {
		return ListVMFUploadUniqrecord;
	}

	@FindBy(css="[id*='upload'] td:nth-child(7)")
	private List<WebElement> ListVMFUploadupdatedrecord;

	public List<WebElement> VMFUploadListupdatedrecord() {
		return ListVMFUploadupdatedrecord;
	}

	@FindBy(css="[id*='upload'] td:nth-child(8)")
	private List<WebElement> ListUploadduprecord;

	public List<WebElement> VMFUploadListduprecord() {
		return ListUploadduprecord;
	}

	@FindBy(css="[id*='upload'] td:nth-child(9)")
	private List<WebElement> ListUploadntwrkmatchrecord;

	public List<WebElement> VMFUploadListntwrkmatchrecord() {
		return ListUploadntwrkmatchrecord;
	}

	@FindBy(css="[id*='upload'] td:nth-child(10) a")
	private List<WebElement> ListUploaderrrecord;

	public List<WebElement> VMFUploadListerrrecord() {
		return ListUploaderrrecord;
	}

	@FindBy(css="[id*='upload'] td:nth-child(11)")
	private List<WebElement> VMFUploadListTotalCount;

	public List<WebElement> VMFUploadListTotalCount() {
		return VMFUploadListTotalCount;
	}

	@FindBy(css="td[title*='Found following error']")
	private WebElement GetVMFFileProcessLogMsg;

	public WebElement GetVMFFileProcessLogMsg() {
		return GetVMFFileProcessLogMsg;
	}

	// Error Process
	@FindBy(css="iframe[src*='showCUFErrorLog']")
	private WebElement IframeFileProcessLogMsg;

	public WebElement IframeFileProcessLogMsg() {
		return IframeFileProcessLogMsg;
	}

	// Invoice

	// Spend File

	// Location
	@FindBy(css="[id*='upload'] td:nth-child(5)")
	private List<WebElement> LocationUploadListunqrecord;

	public List<WebElement> LocationUploadListunqrecord() {
		return LocationUploadListunqrecord;
	}

	@FindBy(css="[id*='upload'] td:nth-child(6)")
	private List<WebElement> LocationUploadListDuprecord;

	public List<WebElement> LocationUploadListDuprecord() {
		return LocationUploadListDuprecord;
	}

	@FindBy(css="[id*='upload'] td:nth-child(7)")
	private List<WebElement> LocationUploadListErrrecord;

	public List<WebElement> LocationUploadListErrrecord() {
		return LocationUploadListErrrecord;
	}

	@FindBy(css="[id*='upload'] td:nth-child(8)")
	private List<WebElement> LocationErrorLog;

	public List<WebElement> LocationErrorLog() {
		return LocationErrorLog;
	}


	// Error Log MSG
	/*
	 * @FindBy(how=How.CSS,using="#errorLog td:nth-child(2)") private
	 * List<WebElement> LocationErrorLogMsg; public List<WebElement>
	 * LocationErrorLogMsg(){ return LocationErrorLogMsg; }
	 */

	// User
	@FindBy(css="[id*='upload'] td:nth-child(6)")
	private List<WebElement> UserUploadListNoofrecord;

	public List<WebElement> UserUploadListNoofrecord() {
		return UserUploadListNoofrecord;
	}
	
	//Divison Details
	@FindBy(css="[id*='upload'] td:nth-child(5)")
	private List<WebElement> DivisonUploadListunqrecord;

	public List<WebElement> DivisonUploadListunqrecord() {
		return DivisonUploadListunqrecord;
	}

	@FindBy(css="[id*='upload'] td:nth-child(6)")
	private List<WebElement> DivisionUploadListduprecord;

	public List<WebElement> DivisionUploadListduprecord() {
		return DivisionUploadListduprecord;
	}

	@FindBy(css="[id*='upload'] td:nth-child(7)")
	private List<WebElement> DivisonUploadListErrrecord;

	public List<WebElement> DivisonUploadListErrrecord() {
		return DivisonUploadListErrrecord;
	}
	
	@FindBy(css="[id*='upload'] td:nth-child(7)")
	private List<WebElement> DivisonUploadListTotalrecord;

	public List<WebElement> DivisonUploadListTotalrecord() {
		return DivisonUploadListTotalrecord;
	}
	
	//Divison Mapping  Details
	@FindBy(css="[id*='upload'] td:nth-child(5)")
	private List<WebElement> DivisonMappingUploadListunqrecord;

	public List<WebElement> DivisonMappingUploadListunqrecord() {
		return DivisonMappingUploadListunqrecord;
	}

	@FindBy(css="[id*='upload'] td:nth-child(6)")
	private List<WebElement> DivisionMappingUploadListduprecord;

	public List<WebElement> DivisionMappingUploadListduprecord() {
		return DivisionMappingUploadListduprecord;
	}

	@FindBy(css="[id*='upload'] td:nth-child(7)")
	private List<WebElement> DivisonMappingUploadListErrrecord;

	public List<WebElement> DivisonMappingUploadListErrrecord() {
		return DivisonMappingUploadListErrrecord;
	}
	
	@FindBy(css="[id*='upload'] td:nth-child(7)")
	private List<WebElement> DivisonMappingUploadListTotalrecord;

	public List<WebElement> DivisonMappingUploadListTotalrecord() {
		return DivisonMappingUploadListTotalrecord;
	}	
	
	//Payment Center Details
	@FindBy(css="[id*='upload'] td:nth-child(5)")
	private List<WebElement> PaymentCenterUploadListunqrecord;

	public List<WebElement> PaymentCenterUploadListunqrecord() {
		return PaymentCenterUploadListunqrecord;
	}

	@FindBy(css="[id*='upload'] td:nth-child(6)")
	private List<WebElement> PaymentCenterUploadListduprecord;

	public List<WebElement> PaymentCenterUploadListduprecord() {
		return PaymentCenterUploadListduprecord;
	}

	@FindBy(css="[id*='upload'] td:nth-child(7)")
	private List<WebElement> PaymentCenterUploadListErrrecord;

	public List<WebElement> PaymentCenterUploadListErrrecord() {
		return PaymentCenterUploadListErrrecord;
	}
	
	@FindBy(css="[id*='upload'] td:nth-child(8)")
	private List<WebElement> PaymentCenterUploadListTotalrecord;

	public List<WebElement> PaymentCenterUploadListTotalrecord() {
		return PaymentCenterUploadListTotalrecord;
	}
	
	//Payment Term Details
	@FindBy(css="[id*='upload'] td:nth-child(5)")
	private List<WebElement> PaymentTermUploadListunqrecord;

	public List<WebElement> PaymentTermUploadListunqrecord() {
		return PaymentTermUploadListunqrecord;
	}

	@FindBy(css="[id*='upload'] td:nth-child(6)")
	private List<WebElement> PaymentTermUploadListduprecord;

	public List<WebElement> PaymentTermUploadListduprecord() {
		return PaymentTermUploadListduprecord;
	}

	@FindBy(css="[id*='upload'] td:nth-child(7)")
	private List<WebElement> PaymentTermUploadListErrrecord;

	public List<WebElement> PaymentTermUploadListErrrecord() {
		return PaymentTermUploadListErrrecord;
	}
	
	@FindBy(css="[id*='upload'] td:nth-child(8)")
	private List<WebElement> PaymentTermUploadListTotalrecord;

	public List<WebElement> PaymentTermUploadListTotalrecord() {
		return PaymentTermUploadListTotalrecord;
	}
	
	//EFT Details
	@FindBy(css="[id*='upload'] td:nth-child(5)")
	private List<WebElement> EFTUploadListunqrecord;

	public List<WebElement> EFTUploadListunqrecord() {
		return EFTUploadListunqrecord;
	}

	@FindBy(css="[id*='upload'] td:nth-child(6)")
	private List<WebElement> EFTUploadListduprecord;

	public List<WebElement> EFTUploadListduprecord() {
		return EFTUploadListduprecord;
	}

	@FindBy(css="[id*='upload'] td:nth-child(7)")
	private List<WebElement> EFTUploadListErrrecord;

	public List<WebElement> EFTUploadListErrrecord() {
		return EFTUploadListErrrecord;
	}
	
	@FindBy(css="[id*='upload'] td:nth-child(7)")
	private List<WebElement> EFTUploadListTotalrecord;

	public List<WebElement> EFTUploadListTotalrecord() {
		return EFTUploadListTotalrecord;
	}

	// Contacts
	@FindBy(css="[id*='upload'] td:nth-child(5)")
	private List<WebElement> ContactUploadListunqrecord;

	public List<WebElement> ContactUploadListunqrecord() {
		return ContactUploadListunqrecord;
	}

	@FindBy(css="[id*='upload'] td:nth-child(6)")
	private List<WebElement> ContactUploadListduprecord;

	public List<WebElement> ContactUploadListduprecord() {
		return ContactUploadListduprecord;
	}

	@FindBy(css="[id*='upload'] td:nth-child(7)")
	private List<WebElement> ContactUploadListErrrecord;

	public List<WebElement> ContactUploadListErrrecord() {
		return ContactUploadListErrrecord;
	}

	@FindBy(css="[id*='upload'] td:nth-child(8)")
	private List<WebElement> ContactErrorLog;

	public List<WebElement> ContactErrorLog() {
		return ContactErrorLog;
	}

	// Error Log MSG
	@FindBy(css="#errorLog td:nth-child(2)")
	private List<WebElement> ContactErrorLogMsg;

	public List<WebElement> ContactErrorLogMsg() {
		return ContactErrorLogMsg;
	}

	// Reusable Methods

	public void UploadFile(LinkedHashMap<String, String> dataMap) throws IOException {

		fillUpload(dataMap);
		formActionUpload(dataMap);
		if (dataMap.containsKey("UploadFile")) {
			lavanteUtils.deleteFile(dataMap.get("FileName"));
		}
	}

	private void fillUpload(LinkedHashMap<String, String> dataMap) throws IOException {
		lavanteUtils.switchtoFrame(null);
		if (dataMap.containsKey("UploadType")) {

			lavanteUtils.click(uploadTypedpdn());
			lavanteUtils.waitForTime(3000);
			lavanteUtils.selectFrmDpdn(dataMap.get("UploadType"));
		}

		if (dataMap.containsKey("UploadFile")) {

			lavanteUtils.uploadFile(dataMap.get("UploadFile"), brwsebtn());

		}

		if (dataMap.containsKey("UpdateRecords")) {
			lavanteUtils.click(updateRecords());
		}

	}

	private void formActionUpload(LinkedHashMap<String, String> dataMap) {
		lavanteUtils.switchtoFrame(null);
		if (dataMap.containsKey("UploadOK")) {
			lavanteUtils.click(uploadbtn());
			lavanteUtils.waitForTime(3000);
			if (dataMap.containsKey("UpdateRecords")) {
				lavanteUtils.waitForTime(3000);
				lavanteUtils.click(OKbtn());
			}

			lavanteUtils.waitForTime(3000);
		}

	}

	public boolean uploadFileGrid(LinkedHashMap<String, String> dataMap) {
		boolean flag = false;
		if (dataMap.containsKey("UploadType")) {
			String type = dataMap.get("UploadType");
			//VMF has been renamed to Supplier  Condition for VMF can be deleted
			if (type.contains("VMF")||type.contains("Supplier")) {
				lavanteUtils.switchtoFrame(IFRAMEVMFuploadFile);
				if (dataMap.containsKey("Status")) {
					if (ListuploadStatus().size() > 0) {
						String expStatus = dataMap.get("Status");
						String actStatus = ListuploadStatus().get(0).getText();
						if (actStatus.contains(expStatus)) {
							flag = true;
						} else {
							flag = refreshgrid(IFRAMEVMFuploadFile, expStatus);
						}
					} else {
						flag = true;
					}
				}
			} else if (type.contains("User Creation File")) {
				lavanteUtils.fluentwait(TabUser);
				lavanteUtils.click(TabUser);
				lavanteUtils.switchtoFrame(IFRAMEuserFile);
				if (dataMap.containsKey("Status")) {
					if (ListuploadStatus().size() > 0) {
						String expStatus = dataMap.get("Status");
						String actStatus = ListuploadStatus().get(0).getText();
						if (actStatus.contains(expStatus)) {
							flag = true;
						} else {
							flag = refreshgrid(IFRAMEuserFile, expStatus);
						}
					} else {
						flag = true;
					}
				}
			} else if (type.contains("Invoice")) {
				lavanteUtils.fluentwait(TabInvoice);
				lavanteUtils.click(TabInvoice);
				lavanteUtils.switchtoFrame(IFRAMEInvuploadFile);
				if (dataMap.containsKey("Status")) {
					if (ListuploadStatus().size() > 0) {
						String expStatus = dataMap.get("Status");
						String actStatus = ListuploadStatus().get(0).getText();
						if (actStatus.contains(expStatus)) {
							flag = true;
						} else {
							flag = refreshgrid(IFRAMEInvuploadFile, expStatus);
						}
					} else {
						flag = true;
					}
				}
			} else if (type.contains("Spend")) {
				lavanteUtils.fluentwait(TabSpend);
				lavanteUtils.click(TabSpend);
				lavanteUtils.switchtoFrame(IFRAMESpenduploadFile);
				if (dataMap.containsKey("Status")) {
					if (ListuploadStatus().size() > 0) {
						String actStatus = ListuploadStatus().get(0).getText();
						String expStatus = dataMap.get("Status");
						if (actStatus.contains(expStatus)) {
							flag = true;
						} else {
							flag = refreshgrid(IFRAMESpenduploadFile, expStatus);
						}
					} else {
						flag = true;
					}
				}
			} else if (type.contains("LocationFile")) {
				lavanteUtils.fluentwait(TabLocation);
				lavanteUtils.click(TabLocation);
				lavanteUtils.switchtoFrame(IFRAMELocationuploadFile);
				if (dataMap.containsKey("Status")) {
					if (ListuploadStatus().size() > 0) {
						String expStatus = dataMap.get("Status");
						String actStatus = ListuploadStatus().get(0).getText();
						if (actStatus.contains(expStatus)) {
							flag = true;
						} else {
							flag = refreshgrid(IFRAMELocationuploadFile, expStatus);
						}
					} else {
						flag = true;
					}
				}

			} else if (type.contains("ContactFile")) {
				lavanteUtils.fluentwait(TabContact);
				lavanteUtils.click(TabContact);
				lavanteUtils.switchtoFrame(IFRAMEContactuploadFile);
				if (dataMap.containsKey("Status")) {
					if (ListuploadStatus().size() > 0) {
						String expStatus = dataMap.get("Status");
						String actStatus = ListuploadStatus().get(0).getText();
						if (actStatus.contains(expStatus)) {
							flag = true;
						} else {
							flag = refreshgrid(IFRAMEContactuploadFile, expStatus);
						}
					} else {
						flag = true;
					}
				}

			}else if (type.contains("Divison")) {
				lavanteUtils.fluentwait(TabDivison);
				lavanteUtils.click(TabDivison);
				lavanteUtils.switchtoFrame(IFRAMEDivisonuploadFile);
				if (dataMap.containsKey("Status")) {
					if (ListuploadStatus().size() > 0) {
						String expStatus = dataMap.get("Status");
						String actStatus = ListuploadStatus().get(0).getText();
						if (actStatus.contains(expStatus)) {
							flag = true;
						} else {
							flag = refreshgrid(IFRAMEDivisonuploadFile, expStatus);
						}
					} else {
						flag = true;
					}
				}

			}else if (type.contains("Divison Mapping")) {
				lavanteUtils.fluentwait(TabDivisonMapping);
				lavanteUtils.click(TabDivisonMapping);
				lavanteUtils.switchtoFrame(IFRAMEDivisonMappinguploadFile);
				if (dataMap.containsKey("Status")) {
					if (ListuploadStatus().size() > 0) {
						String expStatus = dataMap.get("Status");
						String actStatus = ListuploadStatus().get(0).getText();
						if (actStatus.contains(expStatus)) {
							flag = true;
						} else {
							flag = refreshgrid(IFRAMEDivisonMappinguploadFile, expStatus);
						}
					} else {
						flag = true;
					}
				}

			}else if (type.contains("Payment Center")) {
				lavanteUtils.fluentwait(TabPaymentCenter);
				lavanteUtils.click(TabPaymentCenter);
				lavanteUtils.switchtoFrame(IFRAMEpaymentCenterFile);
				if (dataMap.containsKey("Status")) {
					if (ListuploadStatus().size() > 0) {
						String expStatus = dataMap.get("Status");
						String actStatus = ListuploadStatus().get(0).getText();
						if (actStatus.contains(expStatus)) {
							flag = true;
						} else {
							flag = refreshgrid(IFRAMEpaymentCenterFile, expStatus);
						}
					} else {
						flag = true;
					}
				}

			}else if (type.contains("Payment Term")) {
				lavanteUtils.fluentwait(TabPaymentTerm);
				lavanteUtils.click(TabPaymentTerm);
				lavanteUtils.switchtoFrame(IFRAMEpaymentTermFile);
				if (dataMap.containsKey("Status")) {
					if (ListuploadStatus().size() > 0) {
						String expStatus = dataMap.get("Status");
						String actStatus = ListuploadStatus().get(0).getText();
						if (actStatus.contains(expStatus)) {
							flag = true;
						} else {
							flag = refreshgrid(IFRAMEpaymentTermFile, expStatus);
						}
					} else {
						flag = true;
					}
				}

			}else if (type.contains("EFT")) {
				lavanteUtils.fluentwait(TabEFT);
				lavanteUtils.click(TabEFT);
				lavanteUtils.switchtoFrame(IFRAMEEFTFile);
				if (dataMap.containsKey("Status")) {
					if (ListuploadStatus().size() > 0) {
						String expStatus = dataMap.get("Status");
						String actStatus = ListuploadStatus().get(0).getText();
						if (actStatus.contains(expStatus)) {
							flag = true;
						} else {
							flag = refreshgrid(IFRAMEEFTFile, expStatus);
						}
					} else {
						flag = true;
					}
				}

			}

			Assert.assertTrue(flag, "File Status is not matched as expected,Please recheck");

		}

		return flag;

	}

	private boolean refreshgrid(WebElement iframe, String expStatus) {
		boolean flag = false;
		String actStatus = "";
		int i = 0;

		do {

			lavanteUtils.switchtoFrame(iframe);
			lavanteUtils.waitForTime(5000);
			actStatus = ListuploadStatus().get(0).getText();
			lavanteUtils.switchtoFrame(null);
			lavanteUtils.fluentwait(refreshBtn());
			lavanteUtils.click(refreshBtn);
			i=i+1;
			System.out.println(i + actStatus + expStatus + flag);
			if (actStatus.contains(expStatus)) {
				flag = true;
			}
		} while ((!(flag == true)) && (i < 50));

		return flag;
	}

}
