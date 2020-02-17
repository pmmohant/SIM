package com.lavante.sim.supplier.pageobjects;

import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.lavante.sim.Common.Util.LavanteUtils;

public class NotesCommentsPage {

	public WebDriver driver;
	public LavanteUtils lavanteUtils = new LavanteUtils();

	public NotesCommentsPage(WebDriver driver) {
		lavanteUtils.driver = driver;
		this.driver = driver;
	}

	@FindBy(id = "viewprofile_inviteID")
	private WebElement InviatationIDDropDwn;

	@FindBy(id = "comment")
	private WebElement DescriptionTxtBox;

	@FindBy(css = "button[class*='button_primary']")
	private WebElement SaveBtn;

	public WebElement SaveBtn() {
		return SaveBtn;
	}

	@FindBy(css = "table[class*='dynamic_table'] tr td:nth-child(1)")
	private List<WebElement> ListDateTime;

	public List<WebElement> ListDateTime() {
		return ListDateTime;
	}

	@FindBy(css = "table[class*='dynamic_table'] tr td:nth-child(2)")
	private List<WebElement> ListCommentTxt;

	public List<WebElement> ListCommentTxt() {
		return ListCommentTxt;
	}

	/**
	 * Get the selected Invited ID
	 * 
	 * @author Subhas.BV
	 * @return
	 */
	public String getSelctedInviteID() {
		WebElement ele = driver.findElement(By.cssSelector("#viewprofile_inviteID option[selected=selected]"));
		return lavanteUtils.getText(ele);
	}

	/**
	 * Add Notes
	 * 
	 * @author Subhas.BV
	 */
	public void addNotes(LinkedHashMap<String, String> dataMap) {
		if (dataMap.containsKey("Description")) {
			if (dataMap.get("Description").equalsIgnoreCase("any")) {
				String notes = "Auto_BV" + lavanteUtils.generateRandomNumber9OnLength(9);
				lavanteUtils.typeinEdit(notes, DescriptionTxtBox);
				dataMap.put("Description", notes);
			} else {
				lavanteUtils.typeinEdit(dataMap.get("Description"), DescriptionTxtBox);
			}
			formActions(dataMap);
		} else {
			Assert.assertTrue(false, " Data Key not given for the Description ");
		}
	}

	private void formActions(LinkedHashMap<String, String> dataMap) {
		if (dataMap.containsKey("Save")) {
			lavanteUtils.clicks(SaveBtn);
		}
	}

}
