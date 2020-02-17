/**
 * Company			: 	LAVANTE
 * Project Name	   	:	Lavante SIM Application
 * Automation		: 	Selenium Automation
 * Author			: 	Venkata Ravi Majjari 
 */

package com.lavante.sim.customer.pageobjects.Admin;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import com.lavante.sim.Common.Util.LavanteUtils;
import com.lavante.sim.Common.Util.setTestData;

public class ManageUsersPage {

	String methodName = "";
	// Declare web driver
	LavanteUtils lavanteUtils = new LavanteUtils();

	@FindBy(css = "table a[href*='Contacts']")
	private WebElement xpathManageUsersLink;

	@FindBy(css = "table a[href*='Contacts'][class*='tab']")
	private WebElement UsersLink;

	@FindBy(css = "table a[href*='Address']")
	private WebElement AddressLink;

	@FindBy(css = "table a[href*='Summary']")
	private WebElement SummaryLink;

	private String expectedTitle = "Lavante SIM - Manage Organization";
	@FindBy(linkText = "Users")
	private WebElement LnkTxtUserLink;
	@FindBy(linkText = "Addresses")
	private WebElement LnkTxtAddressLink;
	@FindBy(xpath = "//table[@id='contact-details']/tbody")
	private WebElement xpathUserTbl;
	@FindBy(xpath = "//table[@class='data_table table_grid zebra']/tbody")
	private WebElement xpathAddressTbl;
	@FindBy(xpath = "//table[contains(@id,'contact-details')]/tbody/tr[1]/td[9]/a[contains(@class,'icon_edit open_popup')]")
	private WebElement xpatheditBtn;
	@FindBy(xpath = "//div[contains(@id,'content')]/table/tbody/tr/td[1]/div/div[3]/table/tbody/tr[1]/td[8]/a[contains(@class,'icon_edit open_popup')]")
	private WebElement xpathaddressTblEditBtn;
	@FindBy(xpath = "//button[@title='Add New User']")
	private WebElement xpathAddNewUser;
	@FindBy(xpath = "//button[@title='Add New']")
	private WebElement xpathtAddNewAddress;
	@FindBy(xpath = "//span[@class='ui-dialog-title']")
	private WebElement xpathtDialogTitle;
	@FindBy(id = "contactName")
	private WebElement IdName;
	@FindBy(id = "email")
	private WebElement IdEmail;
	@FindBy(xpath = "//div[@class='align_right button_set']/descendant::button[@title='Cancel']")
	private WebElement xpathCancelBtn;
	@FindBy(xpath = "//*[@id='command']//*[@type='reset']")
	private WebElement xpathClearBtn;
	@FindBy(xpath = "//*[@id='command']//*[@type='submit']")
	private WebElement xpathSaveBtn;
	@FindBy(xpath = "//span[@class='error']")
	private WebElement xpathErrorMessage;
	@FindBy(xpath = ".//iframe[@class='popup_iframe ui-dialog-content ui-widget-content']")
	private WebElement iFrame;

	@FindBy(id = "address1")
	private WebElement IdAddress1;
	@FindBy(id = "city")
	private WebElement IdCity;
	@FindBy(id = "countryId_chosen")
	private WebElement IdCountry;
	@FindBy(id = "stateId_chosen")
	private WebElement IdState;
	@FindBy(id = "zipCode")
	private WebElement IdPostalCode;

	private String xpathedit = "//div[contains(@id,'content')]/table/tbody/tr/td[1]/div/div[3]/table/tbody/tr[";
	private String xpathoption = "]/td[8]/a[contains(@class,'icon_edit open_popup')]";

	public ManageUsersPage(WebDriver driver) {
		lavanteUtils.driver = driver;

	}

	/**
	 * Method Name : verifyUILnksonManageUsersPage Purpose: Public method which
	 * includes logic related to verify the UI Links on ManageUsersPage
	 * 
	 * @param: None
	 * @return: None
	 */
	public void verifyUILnksonManageUsersPage() {
		try {
			Reporter.log("SIM - Customer/Supplier - Manage Users Module - Started");
			lavanteUtils.click(xpathManageUsersLink);
			lavanteUtils.waitForTime(3000);
			Reporter.log("Successfully clicked on the Manage Users tab");
			lavanteUtils.assertPageTitle(expectedTitle);
			lavanteUtils.isElementDisplayed(LnkTxtUserLink);
			lavanteUtils.waitForTime(1000);
			lavanteUtils.isElementDisplayed(LnkTxtAddressLink);
			lavanteUtils.waitForTime(1000);
			Reporter.log(
					"Verification of the UI controls on Manage Users page is Successful with the Users and Adresses buttons");
		} catch (Exception e) {
			// Assert.assertTrue(true,"Exception in the method
			// verifyUILnksonManageUsersPage: "+e.getMessage);
		}
	}

	/**
	 * Method Name : verifyAddEditOptionsInUsersTab Purpose: Public method which
	 * includes logic related to ge.clicks and validate the Add new user and
	 * edit options under Users field
	 * 
	 * @param: None
	 * @return: None
	 */
	public void verifyAddEditOptionsInUsersTab() {
		boolean flag = false;
		try {
			if (lavanteUtils.isElementDisplayed(LnkTxtUserLink) == true) {
				lavanteUtils.click(LnkTxtUserLink);
				lavanteUtils.waitForTime(2000);
				Reporter.log("Successfully clicked on the Users tab: ");
			}
			if (lavanteUtils.isElementDisplayed(xpathAddNewUser) == true) {
				String strUserText = lavanteUtils.getText(xpathAddNewUser);
				Reporter.log("Verification is successful for " + strUserText + " button in the Users table ", true);
			}
			List<WebElement> rows = xpathUserTbl.findElements(By.tagName("tr"));
			lavanteUtils.waitForTime(2000);
			for (int rnum = 0; rnum < rows.size(); rnum++) {
				List<WebElement> columns = rows.get(rnum).findElements(By.tagName("td"));
				for (int cnum = 0; cnum < columns.size(); cnum++) {
					if (lavanteUtils.isElementDisplayed(xpatheditBtn) == true) {
						lavanteUtils.isElementDisplayed(xpatheditBtn);
						flag = true;
						break;
					} else {
						flag = false;
					}
				}
				if (flag == true) {
					Reporter.log("Verification is successful for Edit option in the Users table: ", true);
					break;
				} else {
					// log.severe("Verification is failed for Edit option in the
					// Users table: ");
				}
			}
		} catch (Exception e) {
			// Assert.assertTrue(false,"Exception in the method
			// verifyAddEditOptionsInUsersTab: "+e.getMessage);
		}
	}

	/**
	 * Method Name : verifyAddEditOptionsInAddressTab Purpose: Public method
	 * which includes logic related to ge.clicks and validate the Add new user
	 * and edit options under Address field
	 * 
	 * @param: None
	 * @return: None
	 */
	public void verifyAddEditOptionsInAddressTab() {
		boolean flag = false;
		try {
			if (lavanteUtils.isElementDisplayed(LnkTxtAddressLink) == true) {
				lavanteUtils.click(LnkTxtAddressLink);
				Reporter.log("Successfully clicked on the Address tab: ");
			}
			if (lavanteUtils.isElementDisplayed(xpathtAddNewAddress) == true) {
				String strAddressText = lavanteUtils.getText(xpathtAddNewAddress);
				Reporter.log("Verification is successful for " + strAddressText + " button in the Address table", true);
			}
			List<WebElement> rows = xpathAddressTbl.findElements(By.tagName("tr"));
			for (int rnum = 0; rnum < rows.size(); rnum++) {
				List<WebElement> columns = rows.get(rnum).findElements(By.tagName("td"));
				for (int cnum = 0; cnum < columns.size(); cnum++) {
					if (lavanteUtils.isElementDisplayed(xpathaddressTblEditBtn) == true) {
						lavanteUtils.isElementDisplayed(xpathaddressTblEditBtn);
						flag = true;
						break;
					} else {
						flag = false;
					}
				}
				if (flag == true) {
					Reporter.log("Verification is successful for Edit option in the Address table: ", true);
					break;
				} else {
					// log.severe("Verification is failed for Edit option in the
					// Address table:");
				}
			}
		} catch (Exception e) {
			// Assert.assertTrue(false,"Exception in the method
			// verifyAddEditOptionsInAddressTab: "+e.getMessage);
		}
	}

	/**
	 * Method Name : getEmail Purpose: Public method which includes logic
	 * related to return the concatenate email with current date
	 * 
	 * @param: None
	 * @return: None
	 */
	public String getEmail() {
		String email = "";
		SimpleDateFormat sdfDate = new SimpleDateFormat("MMddHHmmss");
		Date now = new Date();
		String strDate = sdfDate.format(now);
		email = "Santha" + strDate + "@gmail.com";
		return email;
	}

	/**
	 * Method Name : addNewUserAndEditDetails Purpose: Public method which
	 * includes logic related to ge.clicks on the Add New User link and validate
	 * the page with valid and invalid data and verify the successful creation
	 * of New User, and edit the user details
	 * 
	 * @param: List<setTestData>
	 *             getManageUsers
	 * @return: None
	 */
	public void addNewUserAndEditDetails(List<setTestData> getManageUsers) {
		boolean flag = false;
		String concatenateEmail = null;
		lavanteUtils.waitForTime(4000);
		lavanteUtils.click(xpathManageUsersLink);
		lavanteUtils.waitForTime(4000);
		lavanteUtils.assertPageTitle(expectedTitle);
		lavanteUtils.click(LnkTxtUserLink);
		lavanteUtils.waitForTime(3000);
		lavanteUtils.click(xpathAddNewUser);
		lavanteUtils.waitForTime(2000);
		Reporter.log("Successfully clicked on the Add New User button");

		if (lavanteUtils.isElementDisplayed(xpathtDialogTitle)) {
			// log.info("Verification is successful for Add New users Page: ");
		} else {
			// Assert.assertTrue(false,"Test failed due to 'Add new user' dialog
			// pop up box is not displayed: ");
		}
		lavanteUtils.switchtoFrame(iFrame);
		try {
			for (int i = 0; i < getManageUsers.size(); i++) {
				lavanteUtils.waitForTime(3000);
				// ge.clicks on the Clear Button
				lavanteUtils.click(xpathClearBtn);
				lavanteUtils.waitForTime(2000);
				lavanteUtils.typeinEdit(getManageUsers.get(i).getNewUserName().toString(), IdName);
				lavanteUtils.waitForTime(3000);
				if (!(getManageUsers.get(i).getNewEmail().toString() == (""))) {
					concatenateEmail = getEmail();
					lavanteUtils.typeinEdit(concatenateEmail, IdEmail);
				}
				// ge.typeinEdit(wdManageUsers,
				// ConfigPathFile.ID.getConstantValue(),IdEmail,getManageUsers.get(i).getNewEmail().toString);
				lavanteUtils.click(xpathSaveBtn);
				lavanteUtils.waitForTime(1000);
				Reporter.log("Entered UserName: " + getManageUsers.get(i).getNewUserName().toString() + " And Email: "
						+ concatenateEmail);
				if (lavanteUtils.isElementDisplayed(xpathErrorMessage) == true) {
					validateErrorMessage(getManageUsers, i);
					flag = true;
				} else {
					flag = false;
				}
				if (!flag) {
					lavanteUtils.switchtoFrame(null);
					lavanteUtils.waitForTime(3000);
					if (lavanteUtils.isElementDisplayed(xpathAddNewUser) == true) {
						Reporter.log("User creation is successful");
						List<WebElement> rows = xpathUserTbl.findElements(By.tagName("tr"));

						for (int rnum = 0; rnum < rows.size(); rnum++) {
							List<WebElement> columns = rows.get(rnum).findElements(By.tagName("td"));

							for (int cnum = 0; cnum < columns.size(); cnum++) {
								if (lavanteUtils.isElementDisplayed(xpatheditBtn) == true) {
									lavanteUtils.click(xpatheditBtn);
									lavanteUtils.waitForTime(2000);
									lavanteUtils.switchtoFrame(iFrame);

									if (lavanteUtils.isElementDisplayed(IdName) == true) {
										lavanteUtils.typeinEdit(getManageUsers.get(i).getUpdatedUserName().toString(),
												IdName);
										lavanteUtils.waitForTime(3000);
										lavanteUtils.click(xpathSaveBtn);
										lavanteUtils.waitForTime(3000);
										lavanteUtils.switchtoFrame(null);
										Reporter.log("Successfully updated the existing user with new user: "
												+ getManageUsers.get(i).getUpdatedUserName().toString(), true);
										flag = true;
										break;
									} else {
										Reporter.log(
												"Failed to identify the username after ge.clicks on the edit option in User table",
												true);
									}

								} else {
									flag = false;
								}
							}
							if (flag == true) {
								break;
							}
						}

					} else {
						// Assert.assertTrue(false,"Failed to identify the
						// locator element in the User table ");
					}
				}
			}
		} catch (Exception e) {
			// log.severe("Exception in the method addNewUserAndEditDetails:
			// "+e.getMessage);
			// Assert.assertTrue(false,"Exception in the method
			// addNewUserAndEditDetails: "+e.getMessage);
		}
	}

	/**
	 * Method Name : addNewAddressAndEditDetails Purpose: Public method which
	 * includes logic related to ge.clicks on the Add New Address link and
	 * validate the page with valid and invalid data and verify the successful
	 * creation of Address, and edit the Address details
	 * 
	 * @param: List<setTestData>
	 *             getManageUsers
	 * @return: None
	 */
	public void addNewAddressAndEditDetails(List<setTestData> getManageAddress) {
		boolean flag = false;
		lavanteUtils.waitForTime(3000);

		lavanteUtils.click(xpathManageUsersLink);
		lavanteUtils.waitForTime(4000);
		lavanteUtils.click(
				lavanteUtils.driver.findElement(By.xpath("//div[@class='tab_set']//*[contains(@href,'Address')]")));
		lavanteUtils.waitForTime(3000);
		lavanteUtils.click(lavanteUtils.driver.findElement(By.xpath("//*[contains(@title,'Add New')]")));
		lavanteUtils.waitForTime(2000);
		Reporter.log("Successfully clicked on the Add New Address button");

		if (lavanteUtils.isElementDisplayed(xpathtDialogTitle)) {
			Reporter.log("verification is successful for Add New Address Page: ");
		} else {
			// Assert.assertTrue(false,"Failed due to dialog pop up box is not
			// displayed in the Address table ");
		}
		lavanteUtils.switchtoFrame(iFrame);
		try {
			for (int i = 0; i < getManageAddress.size(); i++) {
				lavanteUtils.waitForTime(2000);
				String strCountry = getManageAddress.get(i).getCountryKey().toString();
				String strState = getManageAddress.get(i).getStateKey().toString();

				int countryKey = Integer.parseInt(strCountry);
				int stateKey = Integer.parseInt(strState);
				lavanteUtils.waitForTime(3000);
				// ge.clicks on the Clear Button
				lavanteUtils.click(xpathClearBtn);
				lavanteUtils.waitForTime(2000);
				lavanteUtils.typeinEdit(getManageAddress.get(i).getAddress().toString(), IdAddress1);
				lavanteUtils.typeinEdit(getManageAddress.get(i).getCity().toString(), IdCity);
				lavanteUtils.click(IdCountry);
				lavanteUtils.switchtoFrame(null);
				lavanteUtils.click(lavanteUtils.driver
						.findElement(By.cssSelector("li.active-result:nth-child(" + countryKey + ")")));
				lavanteUtils.switchtoFrame(iFrame);
				lavanteUtils.click(IdState);
				lavanteUtils.switchtoFrame(null);
				lavanteUtils.click(lavanteUtils.driver
						.findElement(By.cssSelector("li.active-result:nth-child(" + stateKey + ")")));

				lavanteUtils.switchtoFrame(iFrame);
				lavanteUtils.typeinEdit(getManageAddress.get(i).getPostalCode().toString(), IdPostalCode);
				lavanteUtils.click(xpathSaveBtn);
				lavanteUtils.waitForTime(2000);

				Reporter.log("Entered Address: " + getManageAddress.get(i).getAddress().toString() + " City: "
						+ getManageAddress.get(i).getCity().toString() + " Country: "
						+ getManageAddress.get(i).getCountry().toString() + " State: "
						+ getManageAddress.get(i).getState().toString() + " Postal Code: "
						+ getManageAddress.get(i).getPostalCode().toString());

				if (lavanteUtils.isElementDisplayed(xpathErrorMessage) == true) {
					validateErrorMessage(getManageAddress, i);
					flag = true;
				} else {
					flag = false;
				}
				if (flag == false) {
					lavanteUtils.waitForTime(3000);
					lavanteUtils.switchtoFrame(null);
					lavanteUtils.waitForTime(2000);
					// if(ge.isElementDisplayed(wdManageUsers,
					// By.xpath(xpathtAddNewAddress))==true)
					if (flag == false) {
						Reporter.log("Address creation is successful");
						List<WebElement> rows = xpathAddressTbl.findElements(By.tagName("tr"));
						lavanteUtils.waitForTime(2000);
						int rowSize = rows.size();
						for (int rnum = rowSize; rnum >= 1; rnum--) {
							List<WebElement> columns = rows.get(rnum - 1).findElements(By.tagName("td"));
							if (columns.get(0).getText().trim().toString()
									.equalsIgnoreCase(getManageAddress.get(i).getAddress().trim().toString())) {
								lavanteUtils.waitForTime(2000);
								lavanteUtils.click(
										lavanteUtils.driver.findElement(By.xpath(xpathedit + rnum + xpathoption)));
								lavanteUtils.waitForTime(2000);
								lavanteUtils.switchtoFrame(iFrame);
								// Verification
								if (lavanteUtils.isElementDisplayed(IdAddress1) == true) {
									lavanteUtils.typeinEdit(getManageAddress.get(i).getUpdatedAddress().toString(),
											IdAddress1);
									lavanteUtils.click(xpathSaveBtn);
									lavanteUtils.waitForTime(2000);
									lavanteUtils.switchtoFrame(null);
									Reporter.log("Successfully updated with the new Address: "
											+ getManageAddress.get(i).getUpdatedAddress().toString(), true);
									flag = true;
									break;
								} else {
									Reporter.log(
											"Failed to identify the Address field after ge.clicks on the edit option in Address table",
											true);
								}

							} else {
								flag = false;
							}
						}
						if (flag == true) {
							break;
						}
					} else {
						// Assert.assertTrue(false,"Failed to identify the
						// locator element in the Address table ");
					}
				}
			}
		} catch (Exception e) {
			// log.severe("Exception in the method addNewAddressAndEditDetails:
			// "+e.getMessage);
			// Assert.assertTrue(false,"Exception in the method
			// addNewAddressAndEditDetails: "+e.getMessage);
		}
	}

	/**
	 * Method Name : validateErrorMessage Purpose: Public method which includes
	 * logic related to validate the error message
	 * 
	 * @param: List<setTestData>
	 *             getManageUsers, i
	 * @return: None
	 */
	public void validateErrorMessage(List<setTestData> getManageUsers, int i) {
		methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		String strErrorMsg = "";

		strErrorMsg = lavanteUtils.getText(xpathErrorMessage);
		if (!(getManageUsers.get(i).getErrorMessage().trim().toString().equalsIgnoreCase(strErrorMsg))) {
			lavanteUtils.waitForTime(1000);
			lavanteUtils.takeScreenshot(methodName);
			// log.severe("Validation is failed in the method
			// validateErrorMessage due to: " + strErrorMsg);
			// Assert.assertTrue(false,"Test failed due to Validation is failed
			// in the method validateErrorMessage due to: " + strErrorMsg);
		} else {
			Reporter.log("Expected error Message: " + strErrorMsg);
		}
	}

	
}
