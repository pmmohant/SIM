package com.lavante.sim.customer.TestScripts.Transactions.Invoices;
/*package com.lavante.sim.customer.TestScripts.Supplier.Invoices;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.lavante.sim.Common.Util.LavanteUtils;
import com.lavante.sim.customer.pageobjects.PageInitiator;

*//**
 * SIM-1294
 * 
 * @author subhas.bv
 *
 *//*
public class InvoiceCommentsTests extends PageInitiator {

	LavanteUtils lavanteUtils = new LavanteUtils();
	String customerID = null;
	String invoiceNumber = null;

	*//**
	 * This class all test starts using login page and driver intilization
	 * 
	 * @author subhas.bv
	 * 
	 *//*
	@BeforeClass
	@Parameters({ "Platform", "Browser", "Version" })
	public void navigateToLoginPage(@Optional(LavanteUtils.Platform) String Platform,
			@Optional(LavanteUtils.browser) String browser, @Optional(LavanteUtils.browserVersion) String Version)
			throws Exception {

		launchAppFromPOM(Platform, browser, Version);
		initiate();
		openAPP();
		// Assigning the driver to the object of lavante utils
		lavanteUtils.driver = driver;

		List listofdatafrm = lavanteUtils.login("Search-Supp", browser);
		LinkedHashMap<String, String> LdataMap = new LinkedHashMap<String, String>();
		LdataMap = (LinkedHashMap<String, String>) listofdatafrm.get(0);
		customerID = (String) listofdatafrm.get(1);
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();

		LdataMap.put("maintab", "Invoice");
		LdataMap.put("subtab", "customerInvoiceSearchResult");
		enobjhomePage.selectTab(LdataMap);

	}

	*//***
	 * SIM-1294 Show Invoice Comments in Invoice Detail Popup
	 * 
	 * @throws SQLException
	 * @throws IOException
	 * @throws FileNotFoundException
	 * 
	 *//*
	@Test
	public void validateInvoiceCommentsTest() throws FileNotFoundException, IOException, SQLException {
		System.out.println(
				"------------Test Started for validateInvoiceCommentsTest --------------" + lavanteUtils.currenttime());
		boolean flag = false;
		SoftAssert softAssert = new SoftAssert();
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<>();
		lavanteUtils.fluentwait(eninvoicePage.IFRAMEsearchresult());
		lavanteUtils.switchtoFrame(eninvoicePage.IFRAMEsearchresult());

		if (eninvoicePage.Listinvnum().size() > 0) {

			String suppERPID = lavanteUtils.getText(eninvoicePage.TBLerpID());
			invoiceNumber = lavanteUtils.getText(eninvoicePage.TBLInvoicenumber());

			lavanteUtils.switchtoFrame(null);
			dataMap.put("InvNum", invoiceNumber);
			eninvoiceBasicSearch.fillSearchdetails(dataMap);

			String comment = "comment" + lavanteUtils.generateRandomNumber9OnLength(7);
			dataMap.put("AddComment", comment);
			eninvoicePage.AddComment(dataMap);

			lavanteUtils.switchtoFrame(eninvoicePage.IFRAMEComments());

			String actualComment = null;
			int commentSize = eninvoicePage.ListCommenttxt().size();
			for (int i = 0; i < commentSize; i++) {

				actualComment = lavanteUtils.getText(eninvoicePage.ListCommenttxt().get(i));
				if (comment.equals(actualComment)) {
					flag = true;
					break;
				}
			}
			Reporter.log(
					" Verify added Comment from invoice Page, Expected - " + comment + " Actual - " + actualComment);
			softAssert.assertTrue(flag, " verification failed  is not valid ");
			flag = false;
			lavanteUtils.switchtoFrame(null);
			lavanteUtils.click(eninvoicePage.PopUpCloseBtn());

			lavanteUtils.switchtoFrame(eninvoicePage.IFRAMEsearchresult());
			lavanteUtils.click(eninvoicePage.TBLInvoicenumber());

			lavanteUtils.fluentwait(eninvoicePage.IframePopUp());
			lavanteUtils.switchtoFrame(eninvoicePage.IframePopUp());
			String popUpcomment = null;
			commentSize = eninvoicePage.ListCommenttxt().size();
			for (int i = 0; i < commentSize; i++) {

				popUpcomment = lavanteUtils.getText(eninvoicePage.ListCommenttxt().get(i));
				if (comment.equals(popUpcomment)) {
					flag = true;
					break;
				}
			}

			Reporter.log(
					" Verify Comment from invoice popUp page, Expected - " + comment + " Actual - " + popUpcomment);
			softAssert.assertTrue(flag, " verification failed Comment from invoice popUp page invalid/same ");
			flag = false;
			lavanteUtils.switchtoFrame(null);
			lavanteUtils.click(eninvoicePage.PopUpCloseBtn());

			dataMap.clear();
			dataMap.put("subtab", "customerSupplierSearch");
			enobjhomePage.selectTab(dataMap);

			dataMap.put("SupplierID", suppERPID);
			dataMap.put("Search", "");
			enobjsupplierBasicSearch.search(dataMap);

			lavanteUtils.fluentwait(enobjsupplierPage.SearchListIFRAME());
			lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());
			lavanteUtils.click(enobjsupplierPage.supplist().get(0));

			dataMap.clear();
			dataMap.put("maintab", "viewEnterpriseInformation");
			dataMap.put("subtab", "viewSupplieProfileInvoices");
			enviewSupplier.selectTab(dataMap);

			lavanteUtils.fluentwait(enviewSupplier.IframeInvoiceSearchPage());
			lavanteUtils.switchtoFrame(enviewSupplier.IframeInvoiceSearchPage());

			int invoiceListSize = eninvoicePage.TBLInvoicenumberList().size();
			for (int i = 0; i < invoiceListSize; i++) {
				if (invoiceNumber.equals(lavanteUtils.getText(eninvoicePage.TBLInvoicenumberList().get(i)))) {
					lavanteUtils.click(eninvoicePage.TBLInvoicenumberList().get(i));
				}
			}

			lavanteUtils.fluentwait(eninvoicePage.IframePopUp());
			lavanteUtils.switchtoFrame(eninvoicePage.IframePopUp());

			String viewProfileInvoicePopUpcomment = null;
			commentSize = eninvoicePage.ListCommenttxt().size();
			for (int i = 0; i < commentSize; i++) {

				viewProfileInvoicePopUpcomment = lavanteUtils.getText(eninvoicePage.ListCommenttxt().get(i));
				if (comment.equals(viewProfileInvoicePopUpcomment)) {
					flag = true;
					break;
				}
			}
			Reporter.log(" Verify Comment from view profile invoice popUp page, Expected - " + comment + " Actual - "
					+ popUpcomment);
			softAssert.assertTrue(flag,
					" verification failed Comment from view profile invoice popUp page invalid/same ");

		} else {
			softAssert.assertTrue(flag, " Please add data and Retest ");
		}
		softAssert.assertAll();
		System.out.println("------------Test ended for validateInvoiceCommentsTest -------------------"
				+ lavanteUtils.currenttime());
	}

	@AfterClass
	public void close() throws FileNotFoundException, IOException, SQLException {

		if (invoiceNumber != null) {
			String query = "delete from Note where NoteID in (select NoteID from InvoiceNotes where InvoiceNumber='"
					+ invoiceNumber + "' )";
			lavanteUtils.UpdateDB(query);
		}

		lavanteUtils.switchtoFrame(null);
		enobjhomePage.logout();
		quitBrowser();
	}
}
*/